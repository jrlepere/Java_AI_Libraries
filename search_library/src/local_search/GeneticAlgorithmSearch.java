package local_search;

import java.util.Arrays;
import java.util.Random;

import problem.Problem;
import problem.State;
import search.IResultObject;
import search.LocalSearch;

/**
 * Implementation for the Genetics Algorithm
 * @author JLepere2
 * @date 02/07/2018
 */
public class GeneticAlgorithmSearch extends LocalSearch {

	/**
	 * Creates a Genetics Algorithm object.
	 * @param fun the objective function to evaluate the states
	 * @param sbsConversion an object to convert states to bit streams and bit streams to states
	 * @param populationSize the size of the population
	 * @param mutateProbability the probability of mutation (0.0,1.0)
	 * @param fitnessGoal the fitness goal to reach
	 * @param maxGenerations the max generations
	 */
	public GeneticAlgorithmSearch(ObjectiveFunction fun, StateBitStreamConversion sbsConversion, int populationSize, double mutateProbability, int fitnessGoal, int maxGenerations) {
		super(fun);
		this.sbsConversion = sbsConversion;
		this.populationSize = populationSize;
		this.mutateProbability = mutateProbability;
		this.fitnessGoal = fitnessGoal;
		this.maxGenerations = maxGenerations;
	}

	public IResultObject execute(Problem problem) {
		
		// --- INITIALIZATION --- //
		Population population = new Population(populationSize);
		for (int i = 0; i < populationSize; i ++) {
			population.addIndividual(new Individual(problem.getInitialState()));
		}
		
		/*
		 * GENERATION LOOPS 
		 *  - Stop when a OR b
		 *     a) fittestIndividual is sufficient
		 *     b) max generations has been reached 
		 */
		int generations = 0;
		while (population.fittestIndividual.fitnessScore < fitnessGoal && generations < maxGenerations) {
			
			// -- NEW POPULATION -- //
			Population newPopulation = new Population(populationSize);
			
			// -- POPULATE NEW POPULATION -- //
			for (int i = 0; i < populationSize; i ++) {
				
				// -- GET PARENTS -- //
				Individual parent1 = population.getParent();
				Individual parent2 = population.getParent();
				
				// -- BREED PARENTS -- //
				Individual child = population.breed(parent1, parent2);
				
				// -- MUTATE CHILD -- //
				population.mutate(child);
				
				// -- ADD CHILD TO POPULATION -- //
				newPopulation.addIndividual(child);
			}
			
			// -- UPDATE -- //
			population = newPopulation;
			generations += 1;
		}
		
		return new LocalSearchResult(population.fittestIndividual.state);
	}
	
	/**
	 * An Individual for the population
	 * @author JLepere2
	 * @date 02/07/2018
	 */
	private class Individual {
		
		/**
		 * Creates an Individual with an internal state
		 * @param s the state
		 */
		public Individual(State s) {
			this.state = s;
			this.fitnessScore = function.execute(s);
			this.bitStream = sbsConversion.getBitStream(s);
		}
		
		/**
		 * Creates an Individual with an internal bitStream
		 * @param s the bitStream
		 */
		public Individual(int[] s) {
			this.bitStream = s;
			this.state = sbsConversion.convertBitStream(s);
			this.fitnessScore = function.execute(state);
		}
		
		private State state;
		private int fitnessScore;
		private int[] bitStream;
	}
	
	/**
	 * A Population class for the genetics algorithm
	 * @author JLepere2
	 * @date 02/07/2018
	 */
	private class Population {
		
		/**
		 * Creates a new Population.
		 * @param populationSize the population size
		 */
		public Population(int populationSize) {
			this.population = new Individual[populationSize];
			this.currentSize = 0;
			this.totalFitnessScore = 0;
			this.fittestIndividual = null;
		}
		
		/**
		 * Adds an individual to the Population.
		 * @param i the individual
		 */
		public void addIndividual(Individual i) {
			population[currentSize] = i;
			currentSize += 1;
			totalFitnessScore += i.fitnessScore;
			if (fittestIndividual == null) {
				fittestIndividual = i;
			} else {
				if (i.fitnessScore > fittestIndividual.fitnessScore) {
					fittestIndividual = i;
				}
			}
		}
		
		/**
		 * Gets a parent Individual for breeding giving priority to those individuals with a higher fitness function.
		 * @return an Individual for breeding.
		 */
		private Individual getParent() {
			int r = gen.nextInt(totalFitnessScore);
			int c = 0;
			for (int i = 0; i < populationSize; i ++) {
				c += population[i].fitnessScore;
				if (c > r) {
					return population[i];
				}
			}
			return null;
		}
		
		/**
		 * Breeds two individuals to create a child.
		 * @param i1 the first individual
		 * @param i2 the second individual
		 * @return a child
		 */
		private Individual breed(Individual i1, Individual i2) {
			int[] p1BitStream = i1.bitStream;
			int[] p2BitStream = i2.bitStream;
			int len = p1BitStream.length;
			int crossPoint = gen.nextInt(len);
			int[] childBitStream = new int[len];
			for (int i = 0; i < len; i ++) {
				if (i < crossPoint) childBitStream[i] = p1BitStream[i];
				else childBitStream[i] = p2BitStream[i];
			}
			if (sbsConversion.isAcceptableBitStream(childBitStream)) {
				return new Individual(childBitStream);
			} else {
				for (int i = 0; i < len; i ++) {
					if (i < crossPoint) childBitStream[i] = p2BitStream[i];
					else childBitStream[i] = p1BitStream[i];
				}
				if (sbsConversion.isAcceptableBitStream(childBitStream)) {
					return new Individual(childBitStream);
				} else {
					int r = gen.nextInt(2);
					if (r == 0) {
						return new Individual(Arrays.copyOf(p1BitStream, len));
					} else {
						return new Individual(Arrays.copyOf(p2BitStream, len));
					}
				}
			}
		}
		
		/**
		 * Mutates an individual with some probability
		 * @param individual the individual
		 * @return a new mutated individual
		 */
		private void mutate(Individual individual) {
			int[] bitStream = individual.bitStream;
			int len = bitStream.length;
			int[] newBitStream = new int[len];
			for (int i = 0; i < len; i ++) {
				if (gen.nextDouble() < mutateProbability) {
					newBitStream[i] = (bitStream[i] + 1) % 2;
				} else {
					newBitStream[i] = bitStream[i];
				}
			}
			if (sbsConversion.isAcceptableBitStream(newBitStream)) {
				individual.bitStream = newBitStream;
			}
		}
		
		private Individual[] population;
		private int currentSize;
		private int totalFitnessScore;
		private Individual fittestIndividual;
	}
	
	/**
	 * An interface to define state and bit stream conversion required for the genetics algorithms
	 * @author JLepere2
	 * @date 02/07/2018
	 */
	public interface StateBitStreamConversion {
		/**
		 * Converts a state to a string of bits.
		 * @param s the state
		 * @return a string of bits
		 */
		public int[] getBitStream(State s);
		/**
		 * Converts a string of bits to a state.
		 * @param s the string of bits
		 * @return a state
		 */
		public State convertBitStream(int[] s);
		/**
		 * Tests whether or not the bit stream is acceptable for the problem.
		 * @param s the bitStream s
		 * @return true if the bitStream is acceptable, false otherwise
		 */
		public boolean isAcceptableBitStream(int[] s);
	}
	
	private StateBitStreamConversion sbsConversion;
	private int populationSize;
	private double mutateProbability;
	private int fitnessGoal;
	private int maxGenerations;
	Random gen = new Random();

}

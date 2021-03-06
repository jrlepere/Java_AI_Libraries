import local_search.GeneticAlgorithmSearch;
import local_search.LocalSearchResult;
import local_search.ObjectiveFunction;
import local_search.RandomRestartHillClimb;
import problem.Problem;

public class Main {

	public static void main(String[] args) {
		
		int n = 8;
		Problem p = new NQueensProblem(n);
		ObjectiveFunction objectiveFunction =  new NQueensObjectiveFunction(n);
		
		RandomRestartHillClimb algo1 = new RandomRestartHillClimb(objectiveFunction);
		NQueensState goalState1 = (NQueensState) algo1.execute(p).getObject(LocalSearchResult.GOAL_STATE);
		System.out.println(goalState1);
		System.out.println(p.isGoalState(goalState1));
		
		NQueensStateBitStreamConverstion sbsConversion = new NQueensStateBitStreamConverstion(n);
		int populationSize = 100;
		double mutateProbability = 0.02;
		int fitnessGoal = ((n-1)*(n))/2;
		int maxGenerations = 5000;
		GeneticAlgorithmSearch algo2 = new GeneticAlgorithmSearch(objectiveFunction, sbsConversion, populationSize, mutateProbability, fitnessGoal, maxGenerations);
		NQueensState goalState2 = (NQueensState) algo2.execute(p).getObject(LocalSearchResult.GOAL_STATE);
		System.out.println(goalState2);
		System.out.println(p.isGoalState(goalState2));
		
		
	}
	
}

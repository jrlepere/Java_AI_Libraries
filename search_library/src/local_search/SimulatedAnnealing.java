package local_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import problem.Action;
import problem.Problem;
import problem.State;
import search.IResultObject;
import search.LocalSearch;

/**
 * Implementation for simulated annealing local search.
 * @author JLepere2
 * @date 02/05/2018
 */
public class SimulatedAnnealing extends LocalSearch {

	public SimulatedAnnealing(ObjectiveFunction fun, Scheduler scheduler) {
		super(fun);
		this.scheduler = scheduler;
	}
	
	public IResultObject execute(Problem p) {
		State currentState = p.getInitialState();
		while (true) {
			double T = this.scheduler.getNextT();
			if (T == 0) return new LocalSearchResult(currentState);
			List<State> successors = new ArrayList<>();
			for (Action a : p.getActions()) {
				if (!a.canExecute(currentState)) continue;
				successors.add(a.execute(currentState));
			}
			if (successors.isEmpty()) return new LocalSearchResult(currentState);
			State successorState = successors.get(gen.nextInt(successors.size()));
			double delta = this.function.execute(successorState) - this.function.execute(currentState);
			if (delta > 0) currentState = successorState;
			else {
				if (gen.nextDouble() < Math.exp(delta/T)) currentState = successorState;
			}
		}
		
	}
	
	public interface Scheduler {
		
		public double getNextT();
		
	}
	
	private Scheduler scheduler;
	Random gen = new Random();

}

package games;

public class MiniMax<A extends Action<S>, S extends State> implements Decision<A, S> {

	public MiniMax(Problem<A, S> p) {
		this.p = p;
	}
	
	public A getOptimalSuccessor(S s) {
		A bestAction = null;
		int bestActionValue = Integer.MIN_VALUE;
		for (A a : p.getActions(s)) {
			int v = minValue(a.execute(s), p.getPlayer(s));
			if (v > bestActionValue) {
				bestAction = a;
				bestActionValue = v;
			}
		}
		return bestAction;
	}
	
	private int minValue(S s, Player player) {
		if (p.isTerminalState(s)) return p.utilityFunction(s, player);
		int v = Integer.MAX_VALUE;
		for (A a : p.getActions(s)) {
			v = Math.min(v, maxValue(a.execute(s), player));
		}
		return v;
	}
	
	private int maxValue(S s, Player player) {
		if (p.isTerminalState(s)) return p.utilityFunction(s, player);
		int v = Integer.MIN_VALUE;
		for (A a : p.getActions(s)) {
			v = Math.max(v, minValue(a.execute(s), player));
		}
		return v;
	}

	private Problem<A, S> p;
	
}

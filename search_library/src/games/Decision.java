package games;

public interface Decision<A extends Action<S>, S extends State> {
	public A getOptimalSuccessor(S s);
}

package csp;

public interface Variable<D extends Domain<V>, V> {
	public D getDomain();
	public void assign(V v);
	public boolean isAssigned();
	public V getAssignment();
}

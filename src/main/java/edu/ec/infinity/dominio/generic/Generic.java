package edu.ec.infinity.dominio.generic;

public interface Generic<K, V> {

	public abstract K getKey();

	public abstract V getValue();

}

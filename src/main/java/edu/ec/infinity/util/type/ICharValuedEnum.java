package edu.ec.infinity.util.type;

public interface ICharValuedEnum<T extends Enum<T>> extends IStringValuedEnum<T> {
	public Character getCharValue();

}
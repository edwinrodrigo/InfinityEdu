package edu.ec.infinity.util.type;

import edu.ec.infinity.dominio.generic.Generic;

public interface IStringValuedEnum<T extends Enum<T>> extends Generic<String, String> {
	public String getDescription();

}

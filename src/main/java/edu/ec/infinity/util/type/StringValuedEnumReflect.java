package edu.ec.infinity.util.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class designed to inspect IStringValuedEnums.
 * 
 * @see http://community.jboss.org/wiki/Java5IStringValuedEnumUserType
 */
public class StringValuedEnumReflect {

	/**
	 * Don't let anyone instantiate this class.
	 * 
	 * @throws UnsupportedOperationException
	 *             Always.
	 */
	private StringValuedEnumReflect() {
		throw new UnsupportedOperationException("This class must not be instanciated.");
	}

	/**
	 * All Enum constants (instances) declared in the specified class.
	 * 
	 * @param enumClass
	 *            Class to reflect
	 * @return Array of all declared EnumConstants (instances).
	 */
	private static <T extends Enum<T>> T[] getValues(Class<T> enumClass) {
		return enumClass.getEnumConstants();
	}

	/**
	 * All possible string values of the string valued enum.
	 * 
	 * @param enumClass
	 *            Class to reflect.
	 * @return Available string values.
	 */
	public static <T extends Enum<T> & IStringValuedEnum<T>> String[] getStringValues(Class<T> enumClass) {
		T[] values = getValues(enumClass);
		String[] result = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			result[i] = values[i].getValue();
		}
		return result;
	}

	/**
	 * Name of the enum instance which hold the especified string value. If value
	 * has duplicate enum instances than returns the first occurency.
	 * 
	 * @param enumClass
	 *            Class to inspect.
	 * @param value
	 *            String.
	 * @return name of the enum instance.
	 */
	protected static <T extends Enum<T> & IStringValuedEnum<T>> String getNameFromValue(Class<T> enumClass,
			String value) {
		T[] values = getValues(enumClass);
		for (T v : values) {
			if (v.getValue().equals(value)) {
				return v.name();
			}
		}
		return "";
	}

	/**
	 * Enum instance which hold the especified string value.
	 * 
	 * @param enumClass
	 *            Class to inspect.
	 * @param value
	 *            String.
	 * @return enum instance
	 */
	public static <T extends Enum<T> & IStringValuedEnum<T>> T getEnumFromValue(Class<T> enumClass, String value) {
		T[] values = getValues(enumClass);
		for (T v : values) {
			if (v.getValue().equals(value)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Enum instance which hold the especified character value.
	 * 
	 * @param enumClass
	 *            Class to inspect.
	 * @param value
	 *            Character.
	 * @return enum instance
	 */
	public static <T extends Enum<T> & ICharValuedEnum<T>> T getEnumFromValue(Class<T> enumClass, Character value) {
		T[] values = getValues(enumClass);
		for (T v : values) {
			if (v.getCharValue().equals(value)) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Value of the especified enum instance.
	 * 
	 * @param enumInstance
	 *            enum instance
	 * @return value of the enum instance, null if enumConstant is null
	 */
	public static <T extends Enum<T> & IStringValuedEnum<T>> String getValueFromEnum(T enumInstance) {
		return (enumInstance == null ? null : enumInstance.getValue());
	}

	/**
	 * Label key of the specified enum instance, based on parent class simple name,
	 * enum class simple name and enum name.
	 * 
	 * @param enumInstance
	 * @return
	 */
	public static <T extends Enum<T> & IStringValuedEnum<T>> String getLabelKeyFromEnum(T enumInstance) {
		// Class<T> enumClass = enumInstance.getDeclaringClass();
		// Class<?> parentClass = enumClass.getDeclaringClass();
		// return (parentClass != null ? parentClass.getSimpleName() + "." : "") +
		// enumClass.getSimpleName() +
		// "." + enumInstance.name();

		return enumInstance.name();
	}

	public static <T extends Enum<T> & ICharValuedEnum<T>> Map<Long, T> getMapFromString(Class<T> enumClass,
			String string, T defaultEnumValue) {
		Map<Long, T> map = new HashMap<Long, T>();
		if (string != null) {
			char[] values = string.toCharArray();
			for (int i = 0; i < values.length; i++) {
				T v = getEnumFromValue(enumClass, values[i]);
				if (v == null) {
					v = defaultEnumValue;
				}
				map.put(Long.valueOf(i + 1), v);
			}
		}
		return map;
	}

	public static <T extends Enum<T> & ICharValuedEnum<T>> String getStringFromMap(Map<Long, T> map, T defaultEnumValue,
			int max) {
		char[] charArray = new char[max];
		boolean valid = false;
		for (int i = 0; i < max; i++) {
			T v = map.get(Long.valueOf(i + 1));
			if (v == null) {
				v = defaultEnumValue;
			} else {
				valid = true;
			}
			charArray[i] = v.getCharValue();
		}
		if (!valid) {
			return null;
		}
		return new String(charArray);
	}

}

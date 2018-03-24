package edu.ec.infinity.util.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;

/**
 * @see StringValuedEnum
 * @see ExampleEnum
 * @see http://community.jboss.org/wiki/Java5StringValuedEnumUserType
 */
@SuppressWarnings("unchecked")
public class StringValuedEnumType<T extends Enum<T> & IStringValuedEnum<T>>
		implements EnhancedUserType, ParameterizedType {

	/**
	 * Enum class for this particular user type.
	 */
	private Class<T> enumClass;

	/**
	 * Value to use if null.
	 */
	private String defaultValue;

	/** Creates a new instance of StringValuedEnumType */
	public StringValuedEnumType() {
	}

	public void setParameterValues(Properties parameters) {
		if (parameters == null) {
			parameters = new Properties();
		}
		Class<?> enclosingClass = getClass().getEnclosingClass();
		if (enclosingClass != null && IStringValuedEnum.class.isAssignableFrom(enclosingClass)) {
			enumClass = (Class<T>) enclosingClass;
		} else {
			String enumClassName = parameters.getProperty("enumClassName");
			try {
				// Validates the class but does not eliminate the cast
				enumClass = (Class<T>) Class.forName(enumClassName).asSubclass(Enum.class)
						.asSubclass(IStringValuedEnum.class);
			} catch (ClassNotFoundException cnfe) {
				throw new HibernateException("Enum class not found", cnfe);
			}
		}
		setDefaultValue(parameters.getProperty("defaultValue"));
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * The class returned by <tt>nullSafeGet()</tt>.
	 * 
	 * @return Class
	 */
	@SuppressWarnings("rawtypes")
	public Class returnedClass() {
		return enumClass;
	}

	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	public boolean isMutable() {
		return false;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Enum<T>) value;
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y;
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	public String objectToSQLString(Object value) {
		return '\'' + ((T) value).getValue() + '\'';
	}

	public String toXMLString(Object value) {
		return ((T) value).getValue();
	}

	public Object fromXMLString(String xmlValue) {
		String name = StringValuedEnumReflect.getNameFromValue(enumClass, xmlValue);
		return Enum.valueOf(enumClass, name);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor sesion, Object owner)
			throws HibernateException, SQLException {
		String value = rs.getString(names[0]);
		if (value == null) {
			value = getDefaultValue();
			if (value == null) { // no default value
				return null;
			}
		}
		String name = StringValuedEnumReflect.getNameFromValue(enumClass, value);
		Object res = rs.wasNull() ? null : Enum.valueOf(enumClass, name);

		return res;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor sesion)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.VARCHAR);
		} else {
			st.setString(index, ((T) value).getValue());
		}
	}

}

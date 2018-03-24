package edu.ec.infinity.util.type;

import java.io.Serializable;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.PrimitiveType;
import org.hibernate.type.StringType;
import org.hibernate.type.descriptor.java.BooleanTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class BooleanToCharType extends AbstractSingleColumnStandardBasicType<Boolean>
		implements PrimitiveType<Boolean>, DiscriminatorType<Boolean> {

	private static final long serialVersionUID = 4977136133948551398L;

	public static final String TYPE = "ec.edu.ug.erp.util.type.BooleanToCharType";

	private static final String TRUE_STRING = "S";

	private static final char TRUE_CHAR = 'S';

	private static final String FALSE_STRING = "N";

	private static final char FALSE_CHAR = 'N';

	public static final BooleanToCharType INSTANCE = new BooleanToCharType();

	public BooleanToCharType() {
		super(VarcharTypeDescriptor.INSTANCE, new BooleanTypeDescriptor(TRUE_CHAR, FALSE_CHAR));
	}

	public String getName() {
		return "si_no";
	}

	@SuppressWarnings("rawtypes")
	public Class getPrimitiveClass() {
		return boolean.class;
	}

	public Boolean stringToObject(String xml) throws Exception {
		return fromString(xml);
	}

	public Serializable getDefaultValue() {
		return Boolean.FALSE;
	}

	public String objectToSQLString(Boolean value, Dialect dialect) throws Exception {
		return StringType.INSTANCE.objectToSQLString(value.booleanValue() ? TRUE_STRING : FALSE_STRING, dialect);
	}

	/**
	 * Convierte un Boolean en su representacion String.
	 * 
	 * @param booleanValue
	 *            Boolean
	 * @return {@link #TRUE_STRING} si value es igual a {@link Boolean#TRUE},
	 *         {@link #FALSE_STRING} si value es igual a {@link Boolean#FALSE}, null
	 *         en caso contrario
	 */
	public static String getStringFromBoolean(Boolean booleanValue) {
		return Boolean.TRUE.equals(booleanValue) ? TRUE_STRING
				: Boolean.FALSE.equals(booleanValue) ? FALSE_STRING : null;
	}

	/**
	 * Convierte un String en su valor Boolean correspondiente.
	 * 
	 * @param stringValue
	 *            String
	 * @return {@link Boolean#TRUE} si value es igual a {@link #TRUE_STRING},
	 *         {@link Boolean#FALSE} si value es igual a {@link #FALSE_STRING}, null
	 *         en caso contrario
	 */
	public static Boolean getBooleanFromString(String stringValue) {
		return TRUE_STRING.equals(stringValue) ? Boolean.TRUE : FALSE_STRING.equals(stringValue) ? Boolean.FALSE : null;
	}

	/**
	 * Indica si un String es igual a {@link #TRUE_STRING}.
	 * 
	 * @param stringValue
	 *            String
	 * @return <code>true</code> si value es igual a {@link #TRUE_STRING},
	 *         <code>false</code> en caso contrario
	 */
	public static boolean isTrueString(String stringValue) {
		return TRUE_STRING.equals(stringValue);
	}

	/**
	 * Indica si un String es igual a {@link #FALSE_STRING}.
	 * 
	 * @param stringValue
	 *            String
	 * @return <code>true</code> si value es igual a {@link #FALSE_STRING},
	 *         <code>false</code> en caso contrario
	 */
	public static boolean isFalseString(String stringValue) {
		return FALSE_STRING.equals(stringValue);
	}

}

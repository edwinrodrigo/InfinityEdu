package edu.ec.infinity.dominio.generic;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.IEtiquetas;
import edu.ec.infinity.util.constantes.IRutas;
import edu.ec.infinity.util.constantes.ITablas;
import edu.ec.infinity.util.type.IStringValuedEnum;
import edu.ec.infinity.util.type.StringValuedEnumReflect;
import edu.ec.infinity.util.type.StringValuedEnumType;

public abstract class DominioGeneric<T extends DominioGeneric<T>>
		implements Generic<String, String>, ITablas, ICamposTablas, IEsquemas, IRutas, IEtiquetas, Serializable {

	private static final long serialVersionUID = -3536581547513733717L;

	public abstract Long getId();

	public abstract void setId(Long id);

	/**
	 * @return true si el otro DTO es del mismo tipo y tiene el mismo id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (getClass().isInstance(other) && (getId() != null))
			return getId().equals(((DominioGeneric<T>) other).getId());
		return (other == this);
	}

	/**
	 * @return true si el otro DTO del mismo tipo tiene el mismo id
	 */
	public boolean equalsId(T other) {
		if (other == null)
			return false;
		if (getId() != null)
			return getId().equals(other.getId());
		return (other == this);
	}

	/**
	 * @return el mismo hashCode para DTOs del mismo tipo que tengan el mismo id
	 * @see http://balusc.blogspot.com/2007/09/objects-in-hselectonemenu.html
	 */
	@Override
	public int hashCode() {
		return getId() != null ? this.getClass().hashCode() + getId().hashCode() : super.hashCode();
	}

	/**
	 * Representacion directa y final en modo texto en base al nombre del DTO, el id
	 * y el label
	 * 
	 * @since 2008-09-07
	 */
	@Override
	public final String toString() {
		return this.getClassName() + "#" + this.getId() + "(" + this.getKey() + ")";
	}

	/**
	 * @return String Nombre de clase del DTO
	 * @since 2008-09-20
	 */
	public final String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

	public enum EstadoAI implements IStringValuedEnum<EstadoAI> {
		ACTIVO("A"), INACTIVO("I"),;

		public static class Type extends StringValuedEnumType<EstadoAI> {
		}

		public static final String TYPE = "edu.ec.infinity.dominio.generic.DominioGeneric$EstadoAI$Type";

		public boolean isActivo() {
			return this.equals(ACTIVO);
		}

		public boolean isInactivo() {
			return this.equals(INACTIVO);
		}

		private String value;
		private String labelKey;

		/**
		 * Map para ser usado en f:selectItems, cuyas entradas cumplen con la regla:<br>
		 * (key=item's label , value=item's value)
		 */
		public static Map<String, EstadoAI> LABELED_MAP;

		/**
		 * Lists para iteraciones (e.g. suggestions)
		 */
		public static final List<EstadoAI> LIST = Arrays.asList(EstadoAI.values());

		private EstadoAI(String value) {
			this.value = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}

		@Override
		public String getValue() {
			return this.value;
		}

		@Override
		public String getKey() {
			return labelKey;
		}

		@Override
		public String getDescription() {
			return getValue();
		}

	}

	public enum Sexo implements IStringValuedEnum<Sexo> {
		MASCULINO("M"), FEMENINO("F"),;

		public static class Type extends StringValuedEnumType<Sexo> {
		}

		public static final String TYPE = "edu.ec.infinity.dominio.generic.DominioGeneric$Sexo$Type";

		public boolean isMasculino() {
			return this.equals(MASCULINO);
		}

		public boolean isFemenino() {
			return this.equals(FEMENINO);
		}

		private String value;
		private String labelKey;

		/**
		 * Map para ser usado en f:selectItems, cuyas entradas cumplen con la regla:<br>
		 * (key=item's label , value=item's value)
		 */
		public static Map<String, Sexo> LABELED_MAP;

		/**
		 * Lists para iteraciones (e.g. suggestions)
		 */
		public static final List<Sexo> LIST = Arrays.asList(Sexo.values());

		private Sexo(String value) {
			this.value = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}

		@Override
		public String getValue() {
			return this.value;
		}

		@Override
		public String getKey() {
			return labelKey;
		}

		@Override
		public String getDescription() {
			return getValue();
		}

	}
	
	public enum EstadoCivil implements IStringValuedEnum<EstadoCivil> {
		SOLTERO("S"), CASADO("C"), DIVORCIADO("D"), VIUDO("V"), UNIONHECHO("U"),;

		public static class Type extends StringValuedEnumType<EstadoCivil> {
		}

		public static final String TYPE = "edu.ec.infinity.dominio.generic.DominioGeneric$EstadoCivil$Type";

		public boolean isSoltero() {
			return this.equals(SOLTERO);
		}

		public boolean isCasado() {
			return this.equals(CASADO);
		}
		
		public boolean isDivorciado() {
			return this.equals(DIVORCIADO);
		}

		public boolean isViudo() {
			return this.equals(VIUDO);
		}
		
		public boolean isUnionHecho() {
			return this.equals(UNIONHECHO);
		}

		private String value;
		private String labelKey;

		/**
		 * Map para ser usado en f:selectItems, cuyas entradas cumplen con la regla:<br>
		 * (key=item's label , value=item's value)
		 */
		public static Map<String, EstadoCivil> LABELED_MAP;

		/**
		 * Lists para iteraciones (e.g. suggestions)
		 */
		public static final List<EstadoCivil> LIST = Arrays.asList(EstadoCivil.values());

		private EstadoCivil(String value) {
			this.value = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}

		@Override
		public String getValue() {
			return this.value;
		}

		@Override
		public String getKey() {
			return labelKey;
		}

		@Override
		public String getDescription() {
			return getValue();
		}

	}

}

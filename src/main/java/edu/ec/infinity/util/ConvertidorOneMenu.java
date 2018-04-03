package edu.ec.infinity.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.DualListModel;

import edu.ec.infinity.dominio.generic.DominioGeneric;

@FacesConverter("convertidorOneMenu")
public class ConvertidorOneMenu implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Object objeto = component.getChildren().get(0);
			if (objeto instanceof UISelectItem)
				objeto = component.getChildren().get(1);
			UISelectItems items = (UISelectItems) objeto;
			List<?> elements = (List<?>) items.getValue();
			Object myObject = null;
			for (Object object : elements) {
				DominioGeneric<?> p = (DominioGeneric<?>) object;
				if (p.getId() == Integer.parseInt(value)) {
					myObject = object;
					break;
				}
			}
			return myObject;
		} catch (ClassCastException cce) {
			throw new ConverterException();
		}
		//return getObjectFromUIPickListComponent(component, value);
	}

//	@SuppressWarnings("unchecked")
//	private <T extends DominioGeneric<T>> T getObjectFromUIPickListComponent(UIComponent component, String value) {
//		try {
//			Object objeto = arg1.getChildren().get(0);
//			if (objeto instanceof UISelectItem)
//				objeto = arg1.getChildren().get(1);
//			UISelectItems items = (UISelectItems) objeto;
//			List<?> elements = (List<?>) items.getValue();
//			Object myObject = null;
//			for (Object object : elements) {
//				IDominioGenerico p = (IDominioGenerico) object;
//				if (p.getId() == Integer.parseInt(arg2)) {
//					myObject = object;
//					break;
//				}
//			}
//			return myObject;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		final DualListModel<T> dualList;
//		try {
//			dualList = (DualListModel<T>) ((SelectOneMenu) component).getValue();
//			T team = getObjectFromList(dualList.getSource(), value);
//			if (team == null) {
//				team = getObjectFromList(dualList.getTarget(), value);
//			}
//			return team;
//		} catch (ClassCastException cce) {
//			throw new ConverterException();
//		} catch (NumberFormatException nfe) {
//			throw new ConverterException();
//		}
//	}
//
//	private String serialize(final Object object) {
//		if (object == null) {
//			return null;
//		}
//		return object.getClass() + "@" + object.hashCode();
//	}
//
//	private Object fromSelect(final UIComponent currentcomponent, final String objectString) {
//		if (currentcomponent.getClass() == UISelectItem.class) {
//			final UISelectItem item = (UISelectItem) currentcomponent;
//			final Object value = item.getValue();
//			if (objectString.equals(serialize(value))) {
//				return value;
//			}
//		}
//		if (currentcomponent.getClass() == UISelectItems.class) {
//			final UISelectItems items = (UISelectItems) currentcomponent;
//			final List<Object> elements = (List<Object>) items.getValue();
//			for (final Object element : elements) {
//				if (objectString.equals(serialize(element))) {
//					return element;
//				}
//			}
//		}
//		if (!currentcomponent.getChildren().isEmpty()) {
//			for (final UIComponent component : currentcomponent.getChildren()) {
//				final Object result = fromSelect(component, objectString);
//				if (result != null) {
//					return result;
//				}
//			}
//		}
//		return null;
//	}
//
//	@SuppressWarnings("unchecked")
//	private <T extends DominioGeneric<T>> T getObjectFromList(final List<?> list, final String identifier) {
//		for (final Object object : list) {
//			final T team = (T) object;
//			if (team.getId().equals(identifier)) {
//				return team;
//			}
//		}
//		return null;
//	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String string;
		if (value == null) {
			string = "";
		} else {
			try {
				string = String.valueOf(((DominioGeneric<?>) value).getId());
			} catch (ClassCastException cce) {
				throw new ConverterException();
			}
		}
		return string;
	}

}

package edu.ec.infinity.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class DAOUtils {

	/**
	 * @param criteria
	 * @param associationPaths
	 * @return
	 */
	public static DetachedCriteria addInnerJoins(DetachedCriteria criteria, String... associationPaths) {
		return addJoins(criteria, JoinType.INNER_JOIN, associationPaths);
	}

	/**
	 * @param criteria
	 * @param associationPaths
	 * @return
	 */
	public static DetachedCriteria addLeftJoins(DetachedCriteria criteria, String... associationPaths) {
		return addJoins(criteria, JoinType.LEFT_OUTER_JOIN, associationPaths);
	}

	/**
	 * @param criteria
	 * @param joinType
	 * @param associationPaths
	 * @return
	 */
	private static DetachedCriteria addJoins(DetachedCriteria criteria, JoinType joinType, String... associationPaths) {
		if (associationPaths != null) {
			for (String associationPath : associationPaths) {
				String[] tokens = associationPath.split("@");
				if (associationPath.length() == 0 || tokens.length > 2) {
					throw new IllegalArgumentException();
				}
				String path = tokens[0];
				String alias = tokens[tokens.length - 1];
				if (tokens.length == 1) {
					tokens = alias.split("\\.");
					alias = tokens[tokens.length - 1];
				}
				criteria.createAlias(path, alias, joinType).setFetchMode(path, FetchMode.JOIN);
			}
		}
		return criteria;
	}

	/**
	 * @param orders
	 * @return
	 */
	public static Order[] stringToOrderAsc(String... orders) {
		return stringToOrder(true, orders);
	}

	/**
	 * @param orders
	 * @return
	 */
	public static Order[] stringToOrderDesc(String... orders) {
		return stringToOrder(false, orders);
	}

	/**
	 * @param ascending
	 * @param orders
	 * @return
	 */
	public static Order[] stringToOrder(boolean ascending, String... orders) {
		List<Order> orderList = new ArrayList<Order>();
		if (orders != null) {
			for (String order : orders) {
				if (ascending)
					orderList.add(Order.asc(order));
				else
					orderList.add(Order.desc(order));
			}
		}
		return orderList.toArray(new Order[orderList.size()]);
	}

	/**
	 * Metodo para agregar order by a criteria
	 * 
	 * @param criteria
	 * @param ascending
	 * @param orders
	 */
	public static void addOrder(DetachedCriteria criteria, boolean ascending, String orders) {
		Order[] orderArray = stringToOrder(ascending, orders);
		for (Order order : orderArray) {
			criteria.addOrder(order);
		}
	}

	/**
	 * Metodo para agregar order by ascendente criteria
	 * 
	 * @param criteria
	 * @param orders
	 */
	public static void addOrderAsc(DetachedCriteria criteria, String orders) {
		Order[] orderArray = stringToOrderAsc(orders);
		for (Order order : orderArray) {
			criteria.addOrder(order);
		}
	}

	/**
	 * Metodo para agregar order by descendente criteria
	 * 
	 * @param criteria
	 * @param orders
	 */
	public static void addOrderDesc(DetachedCriteria criteria, String orders) {
		Order[] orderArray = stringToOrderDesc(orders);
		for (Order order : orderArray) {
			criteria.addOrder(order);
		}
	}

	/**
	 * Agregar like a criteria
	 * 
	 * @param criteria
	 * @param searchText
	 * @param properties
	 * @return
	 */
	public static DetachedCriteria addLikeProperies(DetachedCriteria criteria, String searchText,
			String... properties) {

		if (criteria != null && properties != null) {
			Disjunction orLike = Restrictions.disjunction();
			for (String prop : properties) {
				orLike.add(Restrictions.like(prop, searchText, MatchMode.ANYWHERE));
			}
			criteria.add(orLike);
		}

		return criteria;
	}

	/**
	 * Agregar Like sin tomar en cuenta mayusculas y minusculas a criteria
	 * 
	 * @param criteria
	 * @param searchText
	 * @param properties
	 * @return
	 */
	public static DetachedCriteria addILikeProperies(DetachedCriteria criteria, String searchText,
			String... properties) {

		if (criteria != null && properties != null) {
			Disjunction orLike = Restrictions.disjunction();
			for (String prop : properties) {
				orLike.add(Restrictions.ilike(prop, searchText, MatchMode.ANYWHERE));
			}
			criteria.add(orLike);
		}

		return criteria;
	}

	/**
	 * @param clazz
	 * @param instance
	 * @see http://stackoverflow.com/questions/24327353/initialize-all-lazy-loaded-collections-in-hibernate
	 */
	public static <T> void forceLoadLazyCollections(Class<T> clazz, T instance) {
		if (instance == null) {
			return;
		}
		for (Field field : clazz.getDeclaredFields()) {
			LazyCollection annotation = field.getAnnotation(LazyCollection.class);
			if (annotation != null) {
				try {
					field.setAccessible(true);
					Hibernate.initialize(field.get(instance));
				} catch (IllegalAccessException e) {
					System.err.println("No se puede forzar la carga del la colleccion: " + field.getName());
				}
			}
		}
	}

	public static DetachedCriteria copyCriteria(DetachedCriteria criteria) {
		try {
			ByteArrayOutputStream baostream = new ByteArrayOutputStream();
			ObjectOutputStream oostream = new ObjectOutputStream(baostream);
			oostream.writeObject(criteria);
			oostream.flush();
			oostream.close();
			ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
			ObjectInputStream oistream = new ObjectInputStream(baistream);
			DetachedCriteria copy = (DetachedCriteria) oistream.readObject();
			oistream.close();
			return copy;
		} catch (Throwable t) {
			throw new HibernateException(t);
		}
	}

	public DetachedCriteria addEquals(DetachedCriteria criteria, String propertyName, Object value) {
		criteria.add(Restrictions.eq(propertyName, value));
		return criteria;
	}
	
	public DetachedCriteria addEqualsProperty(DetachedCriteria criteria, String propertyName, String otherPropertyName) {
		criteria.add(Restrictions.eqProperty(propertyName, otherPropertyName));
		return criteria;
	}

}

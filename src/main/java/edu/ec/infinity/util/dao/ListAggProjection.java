package edu.ec.infinity.util.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.SimpleProjection;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

public class ListAggProjection extends SimpleProjection {

	private static final long serialVersionUID = -2949764679991296495L;

	private final String propertyName;
	private final String orderName;
	private final String separator;

	protected ListAggProjection(String propertyName, String orderName, String separator) {
		this.propertyName = propertyName;
		this.orderName = orderName;
		this.separator = separator;
	}

	public String toString() {
		return "string_agg(" + propertyName + ')';
	}

	/**
	 * {@inheritDoc}
	 */
	public Type[] getTypes(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
		return new Type[] { StandardBasicTypes.STRING };
	}

	/**
	 * {@inheritDoc}
	 */
	public String toSqlString(Criteria criteria, int loc, CriteriaQuery criteriaQuery) throws HibernateException {
		final String property = criteriaQuery.getColumn(criteria, propertyName);
		final String order = criteriaQuery.getColumn(criteria, orderName);
		final String functionFragment = "string_agg(" + property + ",'" + separator + "') within group (order by " + order
				+ ")";
		return functionFragment + " as y" + loc + '_';
	}

}
package edu.ec.infinity.util.dao;

import java.io.Serializable;

import org.hibernate.criterion.Projection;

public class PostgresCriteria implements Serializable {

	private static final long serialVersionUID = -1995764095236177349L;

	public static Projection listAgg(String propertyName, String orderName, String separator) {
		return new ListAggProjection(propertyName, orderName, separator);
	}

}

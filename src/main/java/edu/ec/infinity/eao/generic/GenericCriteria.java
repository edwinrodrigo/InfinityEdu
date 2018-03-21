package edu.ec.infinity.eao.generic;

import java.io.Serializable;

import org.hibernate.Criteria;

public class GenericCriteria<T> implements Serializable {

//	private static final long serialVersionUID = -6088186846547455010L;
//
//	public static final String ID_FIELD = "id";
//
//	private Class<T> clazz;
//	private final CriteriaImpl impl;
//	private final Criteria criteria;
//	public boolean changed = false;
//	private Map<String, String> aliasMap = new HashMap<String, String>(0);
//	private String rowCountPropertyName = null;
//	
//	private List<Order> listaOrderCriteria = new ArrayList<Order>();
//	
//	protected GenericCriteria(Class<T> clazz, CriteriaImpl impl, Criteria criteria) {
//		this.clazz = clazz;
//		this.impl = impl;
//		this.criteria = criteria;
//	}
//
//	protected GenericCriteria(Class<T> clazz) {
//		this.clazz = clazz;
//		this.impl = new CriteriaImpl(this.clazz.getName(), null);
//		this.criteria = this.impl;
//	}
//
//	protected GenericCriteria(Class<T> clazz, String alias) {
//		this.clazz = clazz;
//		this.impl = new CriteriaImpl(this.clazz.getName(), alias, null);
//		this.criteria = this.impl;
//	}
//
//	public static <T> GenericCriteria<T> forClass(Class<T> clazz) {
//		return new GenericCriteria<T>(clazz);
//	}
//
//	public static <T> GenericCriteria<T> forClass(Class<T> clazz, String alias) {
//		return new GenericCriteria<T>(clazz, alias);
//	}
//
//	public DetachedCriteria getCriteria() {
//		return new InnerDetachedCriteria(impl, criteria);
//	}
//
//	private static class InnerDetachedCriteria extends DetachedCriteria {
//		private static final long serialVersionUID = 1L;
//		protected InnerDetachedCriteria(CriteriaImpl impl, Criteria criteria) {
//			super(impl, criteria);
//		}
//	}
//
//	public String getRowCountPropertyName() {
//		return rowCountPropertyName;
//	}
//	public void setRowCountPropertyName(String rowCountPropertyName) {
//		this.rowCountPropertyName = rowCountPropertyName;
//	}
//
//	////////////////// Proxy methods ////////////////////
//
//	public GenericCriteria<T> add(Criterion criterion) {
//		criteria.add(criterion);
//		return this;
//	}
//
//	public GenericCriteria<T> addOrder(String... propertyNames) {
//		if (propertyNames != null) {
//			for (String propertyName : propertyNames) {
//				String[] split = StringUtils.split(propertyName);
//				if (split.length < 1 || split.length > 2) {
//					throw new IllegalArgumentException();
//				}
//				boolean ascending = (split.length == 1 || (split.length == 2 && split[1].equalsIgnoreCase("asc")));
//				//criteria.addOrder(ascending ? Order.asc(split[0]) : Order.desc(split[0]));
//				listaOrderCriteria.add(ascending ? Order.asc(split[0]) : Order.desc(split[0]));
//			}
//		}
//		return this;
//	}
//	
//	public GenericCriteria<T> addOrderAsc(String... propertyNames) {
//		if (propertyNames != null) {
//			for (String propertyName : propertyNames) {
//				listaOrderCriteria.add(Order.asc(propertyName));
//				//criteria.addOrder(Order.asc(propertyName));
//			}
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addOrderDesc(String... propertyNames) {
//		if (propertyNames != null) {
//			for (String propertyName : propertyNames) {
//				listaOrderCriteria.add(Order.desc(propertyName));
//				//criteria.addOrder(Order.desc(propertyName));
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Metodo llamado en FinderImpl, para setear el orden asc o desc de la consulta.
//	 */
//	public void addOrderCriteria(){
//		for(Order order : listaOrderCriteria){
//			criteria.addOrder(order);
//		}
//	}
//	
//	public GenericCriteria<T> addOrderSql(String... sqlFormulas) {
//		if (sqlFormulas != null) {
//			for (String sqlFormula : sqlFormulas) {
//				criteria.addOrder(OrderBySqlFormula.sqlFormula(sqlFormula));
//			}
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> createAlias(String associationPath, String alias, int joinType)
//			throws HibernateException {
//		if (!StringUtils.equals(aliasMap.get(associationPath), alias)) {
//			aliasMap.put(associationPath, alias);
//			criteria.createAlias(associationPath, alias, joinType);
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> createAlias(String associationPath, String alias)
//			throws HibernateException {
//		return createAlias(associationPath, alias, CriteriaSpecification.INNER_JOIN);
//	}
//
//	public <V> GenericCriteria<V> createCriteria(Class<V> clazz, String associationPath, String alias)
//			throws HibernateException {
//		Criteria newCriteria = criteria.createCriteria(associationPath, alias);
//		return new GenericCriteria<V>(clazz, impl, newCriteria);
//	}
//
//	public <V> GenericCriteria<V> createCriteria(Class<V> clazz, String associationPath)
//			throws HibernateException {
//		Criteria newCriteria = criteria.createCriteria(associationPath);
//		return new GenericCriteria<V>(clazz, impl, newCriteria);
//	}
//
//	public String getAlias() {
//		return criteria.getAlias();
//	}
//
//	public Criteria getExecutableCriteria(Session session) {
//		impl.setSession(( SessionImplementor ) session);
//		return impl;
//	}
//
//	public GenericCriteria<T> setFetchMode(String associationPath, FetchMode mode) throws HibernateException {
//		criteria.setFetchMode(associationPath, mode);
//		return this;
//	}
//
//	public GenericCriteria<T> setProjection(Projection projection) {
//		criteria.setProjection(projection);
//		return this;
//	}
//
//	public GenericCriteria<T> setComment(String commnet) {
//		criteria.setComment(commnet);
//		return this;
//	}
//
//	public GenericCriteria<T> setResultTransformer(ResultTransformer resultTransformer) {
//		criteria.setResultTransformer(resultTransformer);
//		return this;
//	}
//
//	public String toString() {
//		return criteria.toString();
//	}
//
//	public static ProjectionList buildProjectionList(String... associationPaths) {
//		ProjectionList projectionList = Projections.projectionList();
//		if (associationPaths != null) {
//			for (String associationPath : associationPaths) {
//				String[] split = StringUtils.split(associationPath);
//				if (split.length < 1 || split.length > 2) {
//					throw new IllegalArgumentException();
//				}
//				ProjectionType type = (split.length == 2 ? ProjectionType.valueOf(split[1].toLowerCase()) : ProjectionType.none);
//				associationPath = split[0];
//				String[] tokens = associationPath.split("@");
//				if (associationPath.length() == 0 || tokens.length > 2) {
//					throw new IllegalArgumentException();
//				}
//				String path = tokens[0];
//				String alias = tokens[tokens.length - 1];
//				if (tokens.length == 1) {
//					tokens = alias.split("\\.");
//					alias = tokens[tokens.length - 1];
//				}
//				switch (type) {
//				case count:
//					projectionList.add(Projections.count(path), alias);
//					break;
//				case sum:
//					projectionList.add(Projections.sum(path), alias);
//					break;
//				case min:
//					projectionList.add(Projections.min(path), alias);
//					break;
//				case max:
//					projectionList.add(Projections.max(path), alias);
//					break;
//				case avg:
//					projectionList.add(Projections.avg(path), alias);
//					break;
//				case listagg:
//					projectionList.add(OracleCriteria.listAgg(path, path, ","), alias);
//					break;
//				case connectbypath:
//					projectionList.add(OracleCriteria.connectByPath(path, "/"), alias);
//					break;
//				case group:
//					// group by all fields has no bad effect
//					projectionList.add(Projections.groupProperty(path), alias);
//					break;
//				case none:
//					projectionList.add(Projections.property(path), alias);
//					break;
//				}
//			}
//		}
//		return projectionList;
//	}
//
//	private static enum ProjectionType {
//		count, sum, min, max, avg, listagg, connectbypath, group, none
//	}
//
//	////////////////// Proxy restriction methods ////////////////////
//
//	/**
//	 * Agrega filtros exists con los GenericCriteria dados
//	 * @author Eduardo Plua Alay
//	 */
//	public GenericCriteria<T> addExists(GenericCriteria<?>... subCriterias) {
//		Disjunction or = Restrictions.disjunction();
//		changed = false;
//		if (!ObjectUtils.isEmpty(subCriterias)) {
//			for (GenericCriteria<?> subCriteria : subCriterias) {
//				if (subCriteria != null) {
////					subCriteria.setProjection(Projections.id());
//					subCriteria.setProjection(Projections.sqlProjection("1", null, null));
//					or.add(Subqueries.exists(subCriteria.getCriteria()));
//					changed = true;
//				}
//			}
//			if (changed) {
//				criteria.add(or);
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Agrega filtros not exists con los GenericCriteria dados
//	 * @author ARJ
//	 */
//	public GenericCriteria<T> addNotExists(GenericCriteria<?>... subCriterias) {
//		Disjunction or = Restrictions.disjunction();
//		changed = false;
//		if (!ObjectUtils.isEmpty(subCriterias)) {
//			for (GenericCriteria<?> subCriteria : subCriterias) {
//				if (subCriteria != null) {
//					subCriteria.setProjection(Projections.sqlProjection("1", null, null));
//					or.add(Subqueries.notExists(subCriteria.getCriteria()));
//					changed = true;
//				}
//			}
//			if (changed) {
//				criteria.add(or);
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a SQL restriction
//	 */
//	public GenericCriteria<T> addSql(String sql) {
//		criteria.add(Restrictions.sqlRestriction(sql));
//		return this;
//	}
//
//	/**
//	 * Adds a SQL restriction with given JDBC param
//	 */
//	public GenericCriteria<T> addSql(String sql, Object value, Type type) {
//		criteria.add(Restrictions.sqlRestriction(sql, value, type));
//		return this;
//	}
//
//	/**
//	 * Adds a SQL restriction with given JDBC params
//	 */
//	public GenericCriteria<T> addSql(String sql, Object[] values, Type[] types) {
//		criteria.add(Restrictions.sqlRestriction(sql, values, types));
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to the named property,
//	 * not ignoring case by default
//	 */
//	public GenericCriteria<T> addEquals(String propertyName, Object value) {
//		return addEquals(propertyName, value, false);
//	}
//
//	/**
//	 * Adds an "equal" constraint to the named property, with long value
//	 */
//	public GenericCriteria<T> addEqualsLong(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNumeric(value)) {
//			criteria.add(Restrictions.eq(propertyName, Long.parseLong(value)));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to the id property
//	 * @see #ID_FIELD
//	 */
//	public GenericCriteria<T> addEqualsId(Object value) {
//		changed = false;
//		if (value != null) {
//			if (value instanceof Number) {
//				criteria.add(Restrictions.eq(ID_FIELD, ((Number) value).longValue()));
//				changed = true;
//			} else {
//				String str = value.toString();
//				if (StringUtils.isNumeric(str)) {
//					criteria.add(Restrictions.eq(ID_FIELD, Long.parseLong(str)));
//					changed = true;
//				}
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to the value property, mostly for Suggestions
//	 * @see #ID_FIELD
//	 */
//	public GenericCriteria<T> addEqualsValue(String valueField, String value) {
//		changed = false;
//		if (value != null) {
//			if (ID_FIELD.equals(valueField) || StringUtils.endsWith(valueField, "." + ID_FIELD)) {
//				if (StringUtils.isNumeric(value)) {
//					criteria.add(Restrictions.eq(valueField, Long.parseLong(value)));
//					changed = true;
//				}
//			} else {
//				criteria.add(Restrictions.eq(valueField, value));
//				changed = true;
//			}
//		}
//		return this;
//	}
//
////	public <P, V extends P> GenericCriteria<T> addSafeEquals(P property, V value) {
////		Argument<P> arg = Lambda.argument(property);
////		return addEquals(arg.getInkvokedPropertyName(), value, false);
////	}
//
//	/**
//	 * Adds an "equal" constraint to the named property,
//	 * optionally ignoring case
//	 */
//	public GenericCriteria<T> addEquals(String propertyName, Object value, boolean ignoreCase) {
//		changed = false;
//		if (ignoreCase) {
//			criteria.add(Restrictions.eq(propertyName, value).ignoreCase());
//		} else {
//			criteria.add(Restrictions.eq(propertyName, value));
//		}
//		changed = true;
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to two properties
//	 */
//	public GenericCriteria<T> addEqualsProperty(String propertyName, String otherPropertyName) {
//		criteria.add(Restrictions.eqProperty(propertyName, otherPropertyName));
//		return this;
//	}
//
//	public GenericCriteria<T> addNotEqualsProperty(String propertyName, String otherPropertyName) {
//		criteria.add(Restrictions.neProperty(propertyName, otherPropertyName));
//		return this;
//	}
//
//	public GenericCriteria<T> addLtProperty(String propertyName, String otherPropertyName) {
//		criteria.add(Restrictions.ltProperty(propertyName, otherPropertyName));
//		return this;
//	}
//	public GenericCriteria<T> addGtProperty(String propertyName, String otherPropertyName) {
//		criteria.add(Restrictions.gtProperty(propertyName, otherPropertyName));
//		return this;
//	}
//
//	public GenericCriteria<T> addLeProperty(String propertyName, String otherPropertyName) {
//		criteria.add(Restrictions.leProperty(propertyName, otherPropertyName));
//		return this;
//	}
//	public GenericCriteria<T> addGeProperty(String propertyName, String otherPropertyName) {
//		criteria.add(Restrictions.geProperty(propertyName, otherPropertyName));
//		return this;
//	}
//
//	public GenericCriteria<T> addIsNull(String propertyName) {
//		criteria.add(Restrictions.isNull(propertyName));
//		return this;
//	}
//
//	/**
//	 * Adds a disjunction <code>(property=value or property is null)</code>.
//	 * If value==null, only the "is null" constraint is added.
//	 */
//	public GenericCriteria<T> addEqualsOrIsNull(String propertyName, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		if (value != null) {
//			or.add(Restrictions.eq(propertyName, value));
//		}
//		or.add(Restrictions.isNull(propertyName));
//		criteria.add(or);
//		return this;
//	}
//
//	public GenericCriteria<T> addDisjunction(Criterion ... criterion) {
//		Disjunction or = Restrictions.disjunction();
//		for (Criterion criterion2 : criterion) {
//			or.add(criterion2);
//		}
//		criteria.add(or);
//		return this;
//	}
//
//	public Disjunction getEqualsOrIsNull(String propertyName, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		if (value != null) {
//			or.add(Restrictions.eq(propertyName, value));
//		}
//		or.add(Restrictions.isNull(propertyName));
//		return or;
//	}
//	/**
//	 * Adds a disjunction <code>(property<>value or property is null)</code>.
//	 * If value==null, only the "is null" constraint is added.
//	 */
//	public GenericCriteria<T> addNotEqualsOrIsNull(String propertyName, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		if (value != null) {
//			or.add(Restrictions.ne(propertyName, value));
//		}
//		or.add(Restrictions.isNull(propertyName));
//		criteria.add(or);
//		return this;
//	}
//
//	public GenericCriteria<T> addIsNotNull(String propertyName) {
//		criteria.add(Restrictions.isNotNull(propertyName));
//		return this;
//	}
//
//	/**
//	 * Adds a "not equal" constraint to the named property
//	 */
//	public GenericCriteria<T> addNotEquals(String propertyName, Object value) {
//		criteria.add(Restrictions.ne(propertyName, value));
//		changed = true;
//		return this;
//	}
//
//	/**
//	 * Adds a "not equal" constraint to the named property, if value != null
//	 */
//	public GenericCriteria<T> addNotEqualsIfNotNull(String propertyName, Object value) {
//		changed = false;
//		if (value != null) {
//			criteria.add(Restrictions.ne(propertyName, value));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a "like" constraint to the named propertiy, if value != empty
//	 */
//	public GenericCriteria<T> addLike(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNotEmpty(value)) {
//			criteria.add(Restrictions.like(propertyName, value, MatchMode.ANYWHERE));
//			changed = true;
//		}
//		return this;
//	}
//	public GenericCriteria<T> addStartLike(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNotEmpty(value)) {
//			criteria.add(Restrictions.like(propertyName, value, MatchMode.START));
//			changed = true;
//		}
//		return this;
//	}
//	public GenericCriteria<T> addEndLike(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNotEmpty(value)) {
//			criteria.add(Restrictions.like(propertyName, value, MatchMode.END));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a "ilike" constraint to the named propertiy, if value != empty
//	 */
//	public GenericCriteria<T> addILike(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNotEmpty(value)) {
//			criteria.add(Restrictions.ilike(propertyName, value, MatchMode.ANYWHERE));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a "ilike" constraint to the named property,
//	 * for each of the given values or tokens, split using " " as separator,
//	 * if values != empty and each value != empty
//	 */
//	public GenericCriteria<T> addILikeTokens(String propertyName, String values) {
//		return addILikeTokensSeparator(propertyName, values, " ");
//	}
//
//	/**
//	 * Adds a "ilike" constraint to the named property,
//	 * for each of the given values or tokens, split using the given separator,
//	 * if values != empty and each value != empty
//	 */
//	public GenericCriteria<T> addILikeTokensSeparator(String propertyName, String values, String separator) {
//		changed = false;
//		if (StringUtils.isNotBlank(values)) {
//			String[] tokens = values.split(separator);
//			if (!ObjectUtils.isEmpty(tokens)) {
//				for (String value : tokens) {
//					if (StringUtils.isNotBlank(value)) {
//						criteria.add(Restrictions.ilike(propertyName, value, MatchMode.ANYWHERE));
//						changed = true;
//					}
//				}
//			}
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addStartILike(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNotBlank(value)) {
//			criteria.add(Restrictions.ilike(propertyName, value, MatchMode.START));
//			changed = true;
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addNotStartILike(String propertyName, String value) {
//		changed = false;
//		if (StringUtils.isNotBlank(value)) {
//			criteria.add(Restrictions.not(Restrictions.ilike(propertyName, value, MatchMode.START)));
//			changed = true;
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addPropertyILikeValues(String propertyName, String... values) {
//		changed = false;
//		if (StringUtils.isNotBlank(propertyName) && !ObjectUtils.isEmpty(values)) {
//			Disjunction or = Restrictions.disjunction();
//			for (String value : values) {
//				or.add(Restrictions.ilike(propertyName, value, MatchMode.ANYWHERE));
//			}
//			criteria.add(or);
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a "ilike" constraint to each of the named properties, as a disjunction,
//	 * for each of the given values or tokens, split using " " as separator,
//	 * if values != empty and each value != empty. E.g.:<br>
//	 * <code>criteria.addTokensILikeProperties("token1 token2", "property1", "property2")</code> generates:<br>
//	 * <code>and (property1 like token1 or property2 like token1 ...) and (property1 like token2 or property2 like token2 ...) ...</code>
//	 */
//	public GenericCriteria<T> addTokensILikeProperties(String valueTokens, String... propertyNames) {
//		return addTokensSeparatorILikeProperties(valueTokens, " ", propertyNames);
//	}
//
//	/**
//	 * Adds a "ilike" constraint to each of the named properties, as a disjunction,
//	 * for each of the given values or tokens, split using the given separator,
//	 * if values != empty and each value != empty. E.g.:<br>
//	 * <code>criteria.addTokensSeparatorILikeProperties("token1_token2", "_", "property1", "property2")</code> generates:<br>
//	 * <code>and (property1 like token1 or property2 like token1 ...) and (property1 like token2 or property2 like token2 ...) ...</code>
//	 */
//	public GenericCriteria<T> addTokensSeparatorILikeProperties(String valueTokens, String separator, String... propertyNames) {
//		changed = false;
//		if (StringUtils.isNotBlank(valueTokens)) {
//			String[] tokens = valueTokens.split(separator);
//			if (!ObjectUtils.isEmpty(tokens)) {
//				for (String value : tokens) {
//					addValueILikePropertiesPrv(value, propertyNames);
//				}
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a "ilike" constraint to each of the named properties, as a disjunction, if value != empty. E.g.:<br>
//	 * <code>criteria.addValueILikeProperties("value", "property1", "property2")</code> generates:<br>
//	 * <code>and (property1 like value or property2 like value ...)</code>
//	 */
//	public GenericCriteria<T> addValueILikeProperties(String value, String... propertyNames) {
//		changed = false;
//		addValueILikePropertiesPrv(value, propertyNames);
//		return this;
//	}
//
//	/**
//	 * Adds a "ilike" constraint to each of the named properties, as a disjunction, if value != empty. E.g.:<br>
//	 * <code>criteria.addValueILikeProperties("value", "property1", "property2")</code> generates:<br>
//	 * <code>and (property1 like value or property2 like value ...)</code>
//	 */
//	private void addValueILikePropertiesPrv(String value, String... propertyNames) {
//		if (StringUtils.isNotBlank(value) && !ObjectUtils.isEmpty(propertyNames)) {
//			Disjunction or = Restrictions.disjunction();
//			for (String propertyName : propertyNames) {
//				if (ID_FIELD.equals(propertyName) || StringUtils.endsWith(propertyName, "." + ID_FIELD)) {
//					if (StringUtils.isNumeric(value)) {
//						or.add(Restrictions.eq(propertyName, Long.parseLong(value)));
//					}
//				/*} else if(StringUtils.isNumeric(value)) {
//					or.add(Restrictions.eq(propertyName, Long.parseLong(value)));*/
//				} else {
//					Conjunction and = Restrictions.conjunction();
//					if (StringUtils.isNotBlank(value)) {
//						String[] tokens = value.split(" ");
//						if (!ObjectUtils.isEmpty(tokens)) {
//							for (String val : tokens) {
//								if (StringUtils.isNotBlank(val)) {
//									and.add(Restrictions.ilike(propertyName, val, MatchMode.ANYWHERE));
//								}
//							}
//						}
//					}
//					or.add(and);
//				}
//			}
//			criteria.add(or);
//			changed = true;
//		}
//	}
//
//	/**
//	 * Adds an "equals" constraint to each of the named properties, as a disjunction, if value != null. E.g.:<br>
//	 * <code>criteria.addValueEqualsProperties(value, "property1", "property2")</code> generates:<br>
//	 * <code>and (property1=value or property2=value ...)</code>
//	 */
//	public GenericCriteria<T> addValueEqualsProperties(Object value, String... propertyNames) {
//		changed = false;
//		if (value != null && !ObjectUtils.isEmpty(propertyNames)) {
//			Disjunction or = Restrictions.disjunction();
//			for (String propertyName : propertyNames) {
//				or.add(Restrictions.eq(propertyName, value));
//			}
//			criteria.add(or);
//			changed = true;
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addValueEqualsProperties(String sql, Object value, String... propertyNames) {
//		changed = false;
//		if (value != null && !ObjectUtils.isEmpty(propertyNames)) {
//			Disjunction or = Restrictions.disjunction();
//			for (String propertyName : propertyNames) {
//				or.add(Restrictions.eq(propertyName, value));
//			}
//			or.add(Restrictions.sqlRestriction(sql));
//			criteria.add(or);
//			changed = true;
//		}
//		return this;
//	}
//	/**
//	 * Adds an "in" constraint to each of the named properties, as in sentence, if value != null. E.g.:<br>
//	 * <code>criteria.addSqlValueInProperties(value, "property1", "property2")</code> generates:<br>
//	 * <code>and value in (property1, property2, ...)</code>
//	 */
//	public GenericCriteria<T> addSqlValueInProperties(Object value, String... propertyNames) {
//		changed = false;
//		if (value != null && !ObjectUtils.isEmpty(propertyNames)) {
//		    StringBuilder nameBuilder =  new StringBuilder();
//		    for (String n : propertyNames) {
//		        nameBuilder.append(n).append(",");
//		    }
//		    nameBuilder.deleteCharAt(nameBuilder.length() - 1);
//			addSql(value + " in (" + nameBuilder.toString() + ")");
//			changed = true;
//		}
//		return this;
//	}
//	/**
//	 * Adds an "equal" constraint to the named property, if value != null
//	 */
//	public GenericCriteria<T> addEqualsIfNotNull(String propertyName, Object value) {
//		changed = false;
//		if (value != null) {
//			criteria.add(Restrictions.eq(propertyName, value));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to the named property, if value != null.
//	 * Adds an "is null" constraint to the named property, otherwise.
//	 */
//	public GenericCriteria<T> addEqualsNullSafe(String propertyName, Object value) {
//		if (value != null) {
//			criteria.add(Restrictions.eq(propertyName, value));
//		} else {
//			criteria.add(Restrictions.isNull(propertyName));
//		}
//		return this;
//	}
//
//	public <I> GenericCriteria<T> addEqualsIfNotNull(I clazz,  String propertyName, I value) {
//		changed = false;
//		if (value != null) {
//			criteria.add(Restrictions.eq(propertyName, value));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to the named property, if value != null && value != 0
//	 */
//	public GenericCriteria<T> addEqualsIfNotZero(String propertyName, Number value) {
//		changed = false;
//		if (value != null && value.longValue() != 0) {
//			criteria.add(Restrictions.eq(propertyName, value));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds an "equal" constraint to the named property, if value != null && value != empty,
//	 * ignoring case by default
//	 */
//	public GenericCriteria<T> addEqualsIfNotEmpty(String propertyName, String value) {
//		return addEqualsIfNotEmpty(propertyName, value, true);
//	}
//
//	/**
//	 * Adds an "equal" constraint to the named property, if value != null && value != empty,
//	 * optionally ignoring case
//	 */
//	public GenericCriteria<T> addEqualsIfNotEmpty(String propertyName, String value, boolean ignoreCase) {
//		changed = false;
//		if (StringUtils.isNotEmpty(value)) {
//			if (ignoreCase)
//				criteria.add(Restrictions.eq(propertyName, value).ignoreCase());
//			else
//				criteria.add(Restrictions.eq(propertyName, value));
//			changed = true;
//		}
//		return this;
//	}
//
//	private GenericCriteria<T> addBetweenPrv(String propertyName, Object startValue, Object endValue) {
//		if (startValue != null && endValue != null) {
//			criteria.add(Restrictions.between(propertyName, startValue, endValue));
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a "between" constraint to the named property,
//	 * if startValue != null && endValue != null
//	 */
//	public GenericCriteria<T> addBetween(String propertyName, Date startValue, Date endValue) {
//		if (startValue != null && endValue != null) {
//	        Calendar c = Calendar.getInstance();
//	        c.setLenient(false);
//	        c.setTime(startValue);
//	        c.set(Calendar.HOUR_OF_DAY, 0);
//	        c.set(Calendar.MINUTE, 0);
//	        c.set(Calendar.SECOND, 0);
//	        startValue = c.getTime();
//	        c.setTime(endValue);
//	        c.set(Calendar.HOUR_OF_DAY, 23);
//	        c.set(Calendar.MINUTE, 59);
//	        c.set(Calendar.SECOND, 59);
//	        endValue = c.getTime();
//			criteria.add(Restrictions.between(propertyName, startValue, endValue));
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addBetweenOrEquals(String propertyName, Date startValue, Date endValue) {
//		if (startValue != null && endValue != null) {
//			if (DateUtils.areSameDateMonthYear(startValue, endValue)) {
//				criteria.add(Restrictions.eq(propertyName, DateUtils.truncate(startValue)));
//			} else {
//				Calendar c = Calendar.getInstance();
//				c.setTime(endValue);
//				c.set(Calendar.HOUR_OF_DAY, 23);
//				c.set(Calendar.MINUTE, 59);
//				c.set(Calendar.SECOND, 59);
//				endValue = c.getTime();
//				criteria.add(Restrictions.between(propertyName, DateUtils.truncate(startValue), endValue));
//			}
//		}
//		return this;
//	}
//	/**
//	 * Adds a "between" constraint to the named property,
//	 * if startValue != null && endValue != null
//	 */
//	public GenericCriteria<T> addBetween(String propertyName, String startValue, String endValue) {
//		return addBetweenPrv(propertyName, startValue, endValue);
//	}
//
//	/**
//	 * Adds a "between" constraint to the named property,
//	 * if startValue != null && endValue != null
//	 */
//	public GenericCriteria<T> addBetween(String propertyName, Number startValue, Number endValue) {
//		return addBetweenPrv(propertyName, startValue, endValue);
//	}
//
//	/**
//	 * Adds a <code>startPropertyName <= value and value <= endPropertyName</code> constraint
//	 */
//	public GenericCriteria<T> addBetweenProperty(String startPropertyName, String endPropertyName, Object value) {
//		if (value != null) {
//			criteria.add(Restrictions.le(startPropertyName, value));
//			criteria.add(Restrictions.ge(endPropertyName, value));
//		} else {
//			criteria.add(Restrictions.sqlRestriction("1=0"));
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a range overlap constraint, if startValue != null and endValue != null<br>
//	 * <strong>Explanation:</strong><br>
//	 * Let condition A mean TableRange completely after GivenRange (true if <code>startProperty > endValue</code>)<br>
//	 * Let condition B mean GivenRange completely after TableRange (true if <code>endProperty < startValue</code>)<br>
//	 * Then overlap exists if Neither A Nor B is true
//	 * (if one range is neither completely after the other,
//	 * nor completely before the other, then they must overlap)<br>
//	 * But from De Morgan's law: <code>Not(A Or B) <=> Not(A) And Not(B)</code><br>
//	 * Then overlap exists if: <code>(startProperty <= endValue) And (endProperty >= startValue)</code>
//	 * @see http://stackoverflow.com/questions/325933/determine-whether-two-date-ranges-overlap
//	 */
//	public GenericCriteria<T> addRangeOverlap(String startPropertyName, String endPropertyName, Object startValue, Object endValue) {
//		changed = false;
//		if (startValue != null && endValue != null) {
//			criteria.add(Restrictions.le(startPropertyName, endValue));
//			criteria.add(Restrictions.ge(endPropertyName, startValue));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds an "in" constraint to the named property,
//	 * if values != null and values is not empty
//	 */
//	public GenericCriteria<T> addIn(String propertyName, Object... values) {
//		changed = false;
//		if (values != null && values.length != 0) {
//			criteria.add(Restrictions.in(propertyName, values));
//			changed = true;
//		}
//		return this;
//	}
//	public GenericCriteria<T> addPropertyInValues(String propertyName, Object... values) {
//		changed = false;
//		if (values != null && values.length != 0) {
//			criteria.add(Restrictions.in(propertyName, values));
//			changed = true;
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addInOrIsNull(String propertyName, Object... values) {
//		changed = true;
//		Disjunction or = Restrictions.disjunction();
//		if (!ObjectUtils.isEmpty(values)) {
//			or.add(Restrictions.in(propertyName, values));
//		}
//		or.add(Restrictions.isNull(propertyName));
//		criteria.add(or);
//		
//		return this;
//	}
//
//	public GenericCriteria<T> addNotInValues(String propertyName, Object... values) {
//		changed = false;
//		if (values != null && values.length != 0) {
//			criteria.add(Restrictions.not(Restrictions.in(propertyName, values)));
//			changed = true;
//		}
//		return this;
//	}
//	
//	/**
//	 * Adds an "in" constraint to the named property,
//	 * if col != null and col is not empty
//	 */
//	public GenericCriteria<T> addInCollection(String propertyName, Collection<?> col) {
//		changed = false;
//		if (!ObjectUtils.isEmpty(col)) {
//			criteria.add(Restrictions.in(propertyName, col));
//			changed = true;
//		}
//		return this;
//	}
//
//	public <V> GenericCriteria<T> addEqualsOrInCollection(String propertyName, V value, Collection<V> col) {
//		changed = false;
//		if (value != null) {
//			if (col.contains(value)) {
//				addEquals(propertyName, value);
//				changed = true;
//			} else {
//				addSql("1=0"); // false
//			}
//		} else {
//			addInCollection(propertyName, col);
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addNotInCollection(String propertyName, Collection<?> col) {
//		changed = false;
//		if (!ObjectUtils.isEmpty(col)) {
//			criteria.add(Restrictions.not(Restrictions.in(propertyName, col)));
//			changed = true;
//		}
//		return this;
//	}
//
//	/**
//	 * Adds a disjunction <code>(property in(col) or property is null)</code>.
//	 * If col is null or empty, only the "is null" constraint is added.
//	 */
//	public GenericCriteria<T> addInCollectionOrIsNull(String propertyName, Collection<?> col) {
//		Disjunction or = Restrictions.disjunction();
//		if (!ObjectUtils.isEmpty(col)) {
//			or.add(Restrictions.in(propertyName, col));
//		}
//		or.add(Restrictions.isNull(propertyName));
//		criteria.add(or);
//		return this;
//	}
//
//	/**
//	 * Adds an "in" constraint to each of the named properties,
//	 * as a disjunction, if col != null and col is not empty
//	 */
//	public GenericCriteria<T> addPropertiesInCollection(Collection<?> col, String... propertyNames) {
//		changed = false;
//		if (!ObjectUtils.isEmpty(col) && !ObjectUtils.isEmpty(propertyNames)) {
//			Disjunction or = Restrictions.disjunction();
//			for (String propertyName : propertyNames) {
//				or.add(Restrictions.in(propertyName, col));
//			}
//			criteria.add(or);
//			changed = true;
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addJoins(String... associationPaths) {
//		if (associationPaths != null) {
//			for (String associationPath : associationPaths) {
//				criteria.setFetchMode(associationPath, FetchMode.JOIN);
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Usage:<br>
//	 * <code>addAliasedJoins("path1.property1", "path2.property2@alias2", "property3", ...)</code><br>
//	 * Generates:<br>
//	 * <code>createAlias("path1.property1", "property1")<br>
//	 * createAlias("path2.property2", "alias2")<br>
//	 * createAlias("property3", "property3")<br>
//	 * ...<br>
//	 * addJoins("path1.property1", "path2.property2@alias2", "property3", ...)</code>
//	 * @param associationPaths
//	 * @return
//	 */
//	private GenericCriteria<T> addAliasedJoins(int joinType, String... associationPaths) {
//		if (associationPaths != null) {
//			for (String associationPath : associationPaths) {
//				String[] tokens = associationPath.split("@");
//				if (associationPath.length() == 0 || tokens.length > 2) {
//					throw new IllegalArgumentException();
//				}
//				String path = tokens[0];
//				String alias = tokens[tokens.length - 1];
//				if (tokens.length == 1) {
//					tokens = alias.split("\\.");
//					alias = tokens[tokens.length - 1];
//				}
//				createAlias(path, alias, joinType);
//				criteria.setFetchMode(path, FetchMode.JOIN);
//			}
//		}
//		return this;
//	}
//
//	/**
//	 * Usage:<br>
//	 * <code>addAliasedJoins("path1.property1", "path2.property2@alias2", "property3", ...)</code><br>
//	 * Generates:<br>
//	 * <code>createAlias("path1.property1", "property1", CriteriaSpecification.INNER_JOIN)<br>
//	 * createAlias("path2.property2", "alias2", CriteriaSpecification.INNER_JOIN)<br>
//	 * createAlias("property3", "property3", CriteriaSpecification.INNER_JOIN)<br>
//	 * ...<br>
//	 * addJoins("path1.property1", "path2.property2@alias2", "property3", ...)</code>
//	 * @param associationPaths
//	 * @return
//	 */
//	public GenericCriteria<T> addAliasedJoins(String... associationPaths) {
//		return addAliasedJoins(CriteriaSpecification.INNER_JOIN, associationPaths);
//	}
//
//	/**
//	 * Usage:<br>
//	 * <code>addAliasedLeftJoins("path1.property1", "path2.property2@alias2", "property3", ...)</code><br>
//	 * Generates:<br>
//	 * <code>createAlias("path1.property1", "property1", CriteriaSpecification.LEFT_JOIN)<br>
//	 * createAlias("path2.property2", "alias2",CriteriaSpecification.LEFT_JOIN)<br>
//	 * createAlias("property3", "property3", CriteriaSpecification.LEFT_JOIN)<br>
//	 * ...<br>
//	 * addJoins("path1.property1", "path2.property2@alias2", "property3", ...)</code>
//	 * @param associationPaths
//	 * @return
//	 */
//	public GenericCriteria<T> addAliasedLeftJoins(String... associationPaths) {
//		return addAliasedJoins(CriteriaSpecification.LEFT_JOIN, associationPaths);
//	}
//
//	/**
//	 * Tells if this criteria has just been changed by the last addEquals* method
//	 * @return
//	 * @see #addEqualsIfNotNull(String, Object)
//	 * @see #addEqualsIfNotZero(String, Number)
//	 * @see #addEqualsIfNotEmpty(String, String)
//	 */
//	public boolean isChanged() {
//		return changed;
//	}
//
//	public void unsetChanged() {
//		changed = false;
//	}
//
//	public GenericCriteria<T> addGreaterThan(String property, Object value) {
//		this.add(Restrictions.gt(property, value));
//		return this;
//	}
//
//	public GenericCriteria<T> addGreaterEquals(String property, Object value) {
//		this.add(Restrictions.ge(property, value));
//		return this;
//	}
//
//	public GenericCriteria<T> addGreaterEqualsIfNotNull(String property, Object value) {
//		this.changed = false;
//		if (value != null) {
//			this.add(Restrictions.ge(property, value));
//			this.changed = true;
//		}
//		return this;
//	}
//
//	public GenericCriteria<T> addLessEquals(String property, Object value) {
//		this.add(Restrictions.le(property, value));
//		return this;
//	}
//
//	public GenericCriteria<T> addLessThan(String property, Object value) {
//		this.add(Restrictions.lt(property, value));
//		return this;
//	}
//
//	public GenericCriteria<T> addLessThanOrIsNull(String property, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		or.add(Restrictions.isNull(property));
//		or.add(Restrictions.lt(property, value));
//		this.add(or);
//		return this;
//	}
//	public GenericCriteria<T> addLessEqualsOrIsNull(String property, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		or.add(Restrictions.isNull(property));
//		or.add(Restrictions.le(property, value));
//		this.add(or);
//		return this;
//	}
//	public GenericCriteria<T> addGreaterThanOrIsNull(String property, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		or.add(Restrictions.gt(property, value));
//		or.add(Restrictions.isNull(property));
//		this.add(or);
//		return this;
//	}
//
//	public GenericCriteria<T> addGreaterEqualsOrIsNull(String property, Object value) {
//		Disjunction or = Restrictions.disjunction();
//		or.add(Restrictions.ge(property, value));
//		or.add(Restrictions.isNull(property));
//		this.add(or);
//		return this;
//	}
//
//	@SuppressWarnings("unchecked")
//	public GenericCriteria<T> clone(){
//		//Referencia: https://forum.hibernate.org/viewtopic.php?p=2266068
//	        try {
//	            ByteArrayOutputStream baostream = new ByteArrayOutputStream();
//	            ObjectOutputStream oostream = new ObjectOutputStream(baostream);
//	            oostream.writeObject(this);
//	            oostream.flush();
//	            oostream.close();
//	            ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
//	            ObjectInputStream oistream = new ObjectInputStream(baistream);
//	            GenericCriteria<T> copy = (GenericCriteria<T>)oistream.readObject();
//	            oistream.close();            
//	            return copy;
//	        } catch(Throwable t) {
//	            throw new HibernateException(t);
//	        }
//   }
	
}

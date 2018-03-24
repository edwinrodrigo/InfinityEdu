package edu.ec.infinity.dao.generic.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.internal.SessionImpl;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.util.DAOUtils;
import edu.ec.infinity.util.constantes.ICamposTablas;

public abstract class GenericDAO<T, PK extends Serializable> extends DAOUtils implements IGenericDAO<T, PK>, ICamposTablas {

	@PersistenceContext(unitName = "infinityPU")
	protected EntityManager em;

	private Class<T> type;

	public GenericDAO() {
	}

	/**
	 * Creates a new instance of GenericDAOAbstract
	 */
	public GenericDAO(Class<T> type) {
		this.type = type;
	}

	public void create(T entidad) throws PersistenceException {
		try {
			em.persist(entidad);
			em.flush();
		} catch (PersistenceException e) {
			throw new PersistenceException(e.getMessage(), e.getCause());
		}
	}

	public T edit(T entidad) throws PersistenceException {
		try {
			entidad = em.merge(entidad);
			em.flush();
			return entidad;
		} catch (PersistenceException e) {
			throw e;
		}
	}

	public void destroy(T entidad) throws PersistenceException {
		try {
			em.merge(entidad);
			em.remove(entidad);
		} catch (PersistenceException e) {
			throw e;
		}
	}

	public void remove(T entidad) throws PersistenceException {
		try {

			em.remove(entidad);
		} catch (PersistenceException e) {
			throw e;
		}
	}

	public T find(Object pk) throws NoResultException {
		T entidad = null;
		try {
			entidad = (T) em.find(type, pk);
			return entidad;
		} catch (EntityNotFoundException e) {
			throw new NoResultException(e.getMessage());
		}
	}

	public T load(Object pk) throws NoResultException {
		T entidad = null;
		try {
			entidad = (T) em.getReference(type, pk);
			return entidad;
		} catch (EntityNotFoundException e) {
			throw new NoResultException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findPage(int firstResult, int maxResults) {
		Query query = em.createQuery(" from " + type.getName());
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.getResultList();
	}

	public Long count() {
		Query query = em.createQuery("select count(*) from " + type.getName());
		return (Long) query.getSingleResult();
	}

	private SessionImpl getSession() {
		return (SessionImpl) em.getDelegate();
	}

	public List<T> findByCriteria(final DetachedCriteria criteria) {
		return findByCriteria(criteria, -1, -1);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults) {
		Criteria executableCriteria = criteria.getExecutableCriteria(getSession());
		if (firstResult >= 0) {
			executableCriteria.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			executableCriteria.setMaxResults(maxResults);
		}

		return executableCriteria.list();
	}

	// public List<T> findByCriteria(DetachedCriteria criteria) {
	// return findByCriteriaWithResultTransformer(criteria,
	// CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	// }

	// public <T> List<T> findByCriteria(GenericCriteria<T> criteria) throws
	// Exception {
	// if (criteria == null) {
	// return new ArrayList<T>();
	// }
	// criteria.addOrderCriteria();
	// return (List<T>)findByCriteriaWithResultTransformer(criteria.getCriteria(),
	// CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	// }

	// public <T> List<T> findByCriteriaWithProjection(GenericCriteria<T> criteria)
	// {
	// if (criteria == null) {
	// return new ArrayList<T>();
	// }
	// //orden by
	// criteria.addOrderCriteria();
	// return (List<T>)findByCriteriaWithResultTransformer(criteria.getCriteria(),
	// CriteriaSpecification.PROJECTION);
	// }

	// public <T,V> List<V> findByCriteria(GenericCriteria<T> criteria, Class<V>
	// clazz) {
	// if (criteria == null) {
	// return new ArrayList<V>();
	// }
	// //orden by
	// criteria.addOrderCriteria();
	// return (List<V>)findByCriteriaWithResultTransformer(criteria.getCriteria(),
	// CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	// }

	// public <T,V> List<V> findByCriteriaWithProjection(GenericCriteria<T>
	// criteria, Class<V> clazz) {
	// if (criteria == null) {
	// return new ArrayList<V>();
	// }
	// //orden by
	// criteria.addOrderCriteria();
	// return (List<V>)findByCriteriaWithResultTransformer(criteria.getCriteria(),
	// CriteriaSpecification.PROJECTION);
	// }

	// public <T,V> List<V> findByCriteriaWithResultTransformer(GenericCriteria<T>
	// criteria, ResultTransformer resultTransformer) {
	// if (criteria == null) {
	// return new ArrayList<V>();
	// }
	// //orden by
	// criteria.addOrderCriteria();
	// return (List<V>)findByCriteriaWithResultTransformer(criteria.getCriteria(),
	// resultTransformer);
	// }

	// public <T,V> List<V> findByCriteriaWithResultTransformer(GenericCriteria<T>
	// criteria, ResultTransformer resultTransformer, PaginationTemplate pagination)
	// {
	// if (criteria == null) {
	// pagination.setTotalRows(0);
	// return new ArrayList<V>();
	// }
	// criteria.setResultTransformer(resultTransformer);
	// // obtener lista con el criteria con paginacion
	// getHibernateTemplate().setMaxResults(0);
	// List<V> list = new ArrayList<V>();
	// GenericCriteria<T> criteriaTotalClone = criteria.clone();
	// // obtener total de registros con el criteria, quitando paginacion
	// Number count = 0;
	// String rowCountPropertyName = criteriaTotalClone.getRowCountPropertyName();
	// if (StringUtils.isBlank(rowCountPropertyName)) {
	// criteriaTotalClone.setProjection(Projections.rowCount());
	// } else {
	// criteriaTotalClone.setProjection(Projections.count(rowCountPropertyName).setDistinct());
	// }
	// Criteria executableCriteria =
	// criteriaTotalClone.getExecutableCriteria(getSession());
	// executableCriteria.setFirstResult(0);
	// executableCriteria.setMaxResults(1);
	// count = (Number) executableCriteria.uniqueResult();
	// pagination.setTotalRows(count.longValue());
	//
	// //Verificamos el numero total de registros si es mayor que dero se hace la
	// consulta
	// if(count.longValue()>0){
	// // obtener lista con el criteria con paginacion
	// //Seteando el orden
	// criteria.addOrderCriteria();
	// list = (List<V>)getHibernateTemplate().findByCriteria(criteria.getCriteria(),
	// (int) pagination.getFirstRow(), (int) pagination.getMaxRows());
	//
	//
	// }
	//
	// return list;
	// }

	// /**
	// * Ejecuta un generic criteria, con el ResultTransformer especificado
	// * @param criteria
	// * @param resultTransformer
	// * @return
	// * @throws FinderException
	// * @author Luis Tama Wong
	// * @throws Exception
	// */
	// private List findByCriteriaWithResultTransformer(DetachedCriteria criteria,
	// ResultTransformer resultTransformer) throws Exception {
	// try {
	// criteria.setResultTransformer(resultTransformer);
	// return findByCriteria(criteria);
	//
	// } catch (Exception e) {
	// throw new Exception(e);
	// }
	// }

	@SuppressWarnings("unchecked")
	public List<T> nativeQueryAdvanced(StringBuffer pSql, HashMap<?,?> pparams, String sqlMapping, int startFrom, int length) {
		Query query = null;
		List<T> results = null;
		String[] paramNamesFind = null;
		Object[] valuesFind = null;
		if (pparams != null) {
			paramNamesFind = new String[pparams.size()];
			valuesFind = new Object[pparams.size()];
			List<?> keys = new ArrayList<>(pparams.keySet());
			int i = 0;
			for (; i < keys.size(); i++) {
				paramNamesFind[i] = (String) keys.get(i);
				valuesFind[i] = pparams.get((String) keys.get(i));
			}
			if (pparams.size() > 0) {
				if (sqlMapping != null) {
					query = em.createNativeQuery(pSql.toString(), sqlMapping);
				} else {
					query = em.createNativeQuery(pSql.toString());
				}
				i = 0;
				for (; i < pparams.size(); i++) {
					query.setParameter(paramNamesFind[i], valuesFind[i]);
				}
				if ((startFrom >= 0) && (length > 0)) {
					query.setFirstResult(startFrom);
					query.setMaxResults(length);
				}
				results = query.getResultList();
			}
			keys = null;
		} else {
			if (sqlMapping != null) {
				query = em.createNativeQuery(pSql.toString(), sqlMapping);
			} else {
				query = em.createNativeQuery(pSql.toString());
			}
			if ((startFrom >= 0) && (length > 0)) {
				query.setFirstResult(startFrom);
				query.setMaxResults(length);
			}
			results = query.getResultList();
		}
		pSql = null;
		pparams = null;
		sqlMapping = null;
		paramNamesFind = null;
		valuesFind = null;
		query = null;
		return (List<T>) results;
	}

	/**
	 * Realiza una consulta armando la select Dinamicamente.
	 * 
	 * @author Lenin Boada
	 * @param pSql
	 *            String que contiene la select sin where
	 * @param pparams
	 *            HashMap con los nombres de los campos y sus valores que formaran
	 *            la WHERE
	 */
	public int nativeSentenceAdvanced(StringBuffer pSql, HashMap<?,?> pparams) {
		Query query = null;
		int results = 0;
		String[] paramNamesFind = null;
		Object[] valuesFind = null;
		if (pparams != null) {
			paramNamesFind = new String[pparams.size()];
			valuesFind = new Object[pparams.size()];
			List<?> keys = new ArrayList<>(pparams.keySet());
			int i = 0;
			for (; i < keys.size(); i++) {
				paramNamesFind[i] = (String) keys.get(i);
				valuesFind[i] = pparams.get((String) keys.get(i));
			}
			if (pparams.size() > 0) {
				query = em.createNativeQuery(pSql.toString());
				i = 0;
				for (; i < pparams.size(); i++) {
					query.setParameter(paramNamesFind[i], valuesFind[i]);
				}
				results = query.executeUpdate();
			}
			keys = null;
		} else {
			results = em.createNativeQuery(pSql.toString()).executeUpdate();
		}
		pSql = null;
		pparams = null;
		paramNamesFind = null;
		valuesFind = null;
		query = null;
		return results;
	}

	/**
	 * Realiza una consulta armando la select Dinamicamente.
	 * 
	 * @author Lenin Boada
	 * @param pSql
	 *            String que contiene la select sin where
	 * @param pparams
	 *            HashMap con los nombres de los campos y sus valores que formaran
	 *            la WHERE
	 * @param pGropuyBy
	 *            Vector de Strings con los nombres de los campos a agrupar
	 * @param pOrder
	 *            Vector de Strings con los nombres de los campos a ordenar
	 * @param pStartFrom
	 *            int índice desde donde empieza las consultas(paginadores)
	 * @param plength
	 *            int índice que índica cuántos registros va a recuperar la
	 *            consulta.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findObjectsAdvanced(StringBuffer pSql, HashMap<?,?> pparams, int startFrom, int length) {
		List<T> results = null;
		String[] paramNamesFind = null;
		Object[] valuesFind = null;
		Query query = null;
		// int tempSize = 0;
		if (pparams != null) {
			paramNamesFind = new String[pparams.size()];
			valuesFind = new Object[pparams.size()];
			List<?> keys = new ArrayList<>(pparams.keySet());
			// tempSize = keys.size();
			int i = 0;
			for (; i < keys.size(); i++) {
				// String k = (String) keys.get(i);
				paramNamesFind[i] = (String) keys.get(i);
				valuesFind[i] = pparams.get((String) keys.get(i));
			}
			keys = null;
		}

		if (pparams != null) {
			query = em.createQuery(pSql.toString());
			int i = 0;
			for (; i < pparams.size(); i++) {
				query.setParameter(paramNamesFind[i], valuesFind[i]);
			}
			if ((startFrom >= 0) && (length > 0)) {
				query.setFirstResult(startFrom);
				query.setMaxResults(length);
			}
			results = query.getResultList();
		} else {
			query = em.createQuery(pSql.toString());
			if ((startFrom >= 0) && (length > 0)) {
				query.setFirstResult(startFrom);
				query.setMaxResults(length);
			}
			results = query.getResultList();
		}
		pSql = null;
		pparams = null;
		paramNamesFind = null;
		valuesFind = null;
		query = null;
		return (List<T>) results;
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T findUniqueByProperties(HashMap<String, Object> hashmap) {
		try {
			return (T) queryFormatByProperties(hashmap).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findByProperties(HashMap<String, Object> hashmap) {
		return queryFormatByProperties(hashmap).getResultList();
	}

	protected Query queryFormatByProperties(HashMap<String, Object> hashmap) {
		String s = (new StringBuilder()).append("select modelo from ").append(type.getSimpleName()).append(" modelo ")
				.toString();
		Set<String> set = hashmap.keySet();
		int i = 0;
		for (String sKey : set) {
			if (i == 0)
				s = s + " where " + sKey + " = :valor_" + i;
			else
				s = s + " and " + sKey + " = :valor_" + i;
			i++;
		}
		Query query = getEntityManager().createQuery(s);
		i = 0;
		for (String sKey : set) {
			query.setParameter("valor_" + i, hashmap.get(sKey));
			i++;
		}

		return query;
	}

	private EntityManager getEntityManager() {
		return this.em;
	}
}
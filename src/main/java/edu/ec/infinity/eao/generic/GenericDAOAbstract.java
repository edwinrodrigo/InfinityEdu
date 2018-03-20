/*
 * GenericDAOAbstract.java
 
 * Created on April 18, 2007, 7:02 PM
 *
 * Copyright CASABACA. All Rights Reserved.
 *
 * CASABACA cia ltda
 * Quito-Ecuador
 * www.casabaca.com
 */

package edu.ec.infinity.eao.generic;

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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.internal.SessionImpl;

/**
 * Clase utilizada para...
 * 
 * @author pmlopez
 * @version $Revision: 1.2 $
 */
public abstract class GenericDAOAbstract<T, PK extends Serializable> implements
		GenericDAO<T, PK> {

	@PersistenceContext(unitName = "infinityPU")
	protected EntityManager em;
	
	private Class<T> type;

	public GenericDAOAbstract() {
	}

	/**
	 * Creates a new instance of GenericDAOAbstract
	 */
	public GenericDAOAbstract(Class<T> type) {
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
			return  entidad;
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
	
	public List<T> findAll() {
		return findByCriteria(null);
	}

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

	/**
	 * El parametro Criterion... lo que realmente hace es armar un objeto
	 * Criterio del tipo list por eso es que le podemos pasar n parametros al
	 * criterio de la consulta. esto se puede aplicar en muchos de nuestro
	 * metodos que no conoscamos exactamene el numero de parametros que
	 * necesitamos pasar al metodo.
	 * 
	 */
	public List<T> findByCriteria(String[] orderList, Criterion... criterions) {
		// Se comenta esta linea por la actualizaciom a Hibernate 3.2.4 sp1,
		// ahora devuelve un objeto del tipo SessionImpl y NO un objeto del tipo
		// HibernateEntityManager.
		// HibernateEntityManager hibernateEntityManager =
		// (HibernateEntityManager) em
		// .getDelegate();
		SessionImpl session = (SessionImpl) em.getDelegate();

		Criteria criteria = session.createCriteria(type);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		if (orderList != null && orderList.length > 0) {
			for (int i = 0; i < orderList.length; i++) {
				criteria.addOrder(Order.asc(orderList[i]));
			}
		}

		return criteria.list();
	}

	public List<T> findPageByCriteria(int firstResult, int maxResults,
			String[] orderList, Criterion... criterions) {
		SessionImpl session = (SessionImpl) em.getDelegate();

		Criteria criteria = session.createCriteria(type);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		if (orderList != null && orderList.length > 0) {
			for (int i = 0; i < orderList.length; i++) {
				criteria.addOrder(Order.asc(orderList[i]));
			}
		}

		criteria.setMaxResults(maxResults);
		criteria.setFirstResult(firstResult);

		return criteria.list();
	}

	public List<T> findPageByCriteria(int firstResult, int maxResults,
			Order[] orderList, Criterion... criterions) {
		SessionImpl session = (SessionImpl) em.getDelegate();

		Criteria criteria = session.createCriteria(type);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		if (orderList != null && orderList.length > 0) {
			for (int i = 0; i < orderList.length; i++) {
				criteria.addOrder(orderList[i]);
			}
		}

		criteria.setMaxResults(maxResults);
		criteria.setFirstResult(firstResult);

		return criteria.list();
	}

	public List<T> findPageByCriteria(int firstResult, int maxResults,
			String[] orderList, List<Criterion> criterions) {
		SessionImpl session = (SessionImpl) em.getDelegate();

		Criteria criteria = session.createCriteria(type);

		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}

		if (orderList != null && orderList.length > 0) {
			for (int i = 0; i < orderList.length; i++) {
				criteria.addOrder(Order.asc(orderList[i]));
			}
		}

		criteria.setMaxResults(maxResults);
		criteria.setFirstResult(firstResult);

		return criteria.list();
	}

	/**
	 * Realiza una consulta armando la select Dinamicamente.
	 * @author Lenin Boada
	 * @param pSql String que contiene la  select sin where 
	 * @param pparams HashMap con los nombres de los campos y sus valores que formaran la WHERE
	 */	
	
	public List nativeQueryAdvanced(StringBuffer pSql, HashMap pparams,
			String sqlMapping, int startFrom, int length) {
		Query query = null;
		List results = null;
		String[] paramNamesFind = null;
		Object[] valuesFind = null;
		if (pparams != null) {
			paramNamesFind = new String[pparams.size()];
			valuesFind = new Object[pparams.size()];
			List keys = new ArrayList(pparams.keySet());
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
		return (List) results;
	}

	/**
	 * Realiza una consulta armando la select Dinamicamente.
	 * @author Lenin Boada
	 * @param pSql String que contiene la  select sin where 
	 * @param pparams HashMap con los nombres de los campos y sus valores que formaran la WHERE
	 */	
	public int nativeSentenceAdvanced(StringBuffer pSql,HashMap pparams){
		 Query query = null;
		 int results = 0;
		 String[] paramNamesFind = null;
		 Object[] valuesFind = null;
		 if (pparams!=null){
			 paramNamesFind = new String[pparams.size()];
			 valuesFind = new Object[pparams.size()];
			 List keys = new ArrayList(pparams.keySet());
			 int i=0;
			 for(; i<keys.size(); i++){
				 paramNamesFind[i] = (String) keys.get(i);
				 valuesFind[i] = pparams.get((String) keys.get(i));
			 }
			 if (pparams.size()>0){
			 	query = em.createNativeQuery(pSql.toString());
			 	i=0;
			 	for(; i<pparams.size(); i++){
			 		query.setParameter(paramNamesFind[i], valuesFind[i]);
			 	}
			 	results = query.executeUpdate();
			 }
			 keys = null;
		 }
		 else{
			results =  em.createNativeQuery(pSql.toString()).executeUpdate();
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
	 * @author Lenin Boada
	 * @param pSql String que contiene la  select sin where 
	 * @param pparams HashMap con los nombres de los campos y sus valores que formaran la WHERE
	 * @param pGropuyBy Vector de Strings con los nombres de los campos a agrupar
	 * @param pOrder Vector de Strings con los nombres de los campos a ordenar
	 * @param pStartFrom int índice desde donde empieza las consultas(paginadores)  
	 * @param plength int índice que índica cuántos registros va a recuperar la consulta. 
	 */
	   @SuppressWarnings("unchecked")
	public List findObjectsAdvanced(StringBuffer pSql,HashMap pparams,int startFrom, int length){
		    List results = null;
		    String[] paramNamesFind = null;
		    Object[] valuesFind = null;
		    Query query = null;
		    //int tempSize = 0;
		    if (pparams!=null){
				paramNamesFind = new String[pparams.size()];
				valuesFind = new Object[pparams.size()];
				List keys = new ArrayList(pparams.keySet());
				//tempSize = keys.size();
				int i=0;
				for(; i<keys.size(); i++){
					//String k = (String) keys.get(i);
					paramNamesFind[i] = (String) keys.get(i);
					valuesFind[i] = pparams.get((String) keys.get(i));
				}
				keys = null;
		   }

			if (pparams!=null){
				query = em.createQuery(pSql.toString());
				int i=0;
				for(; i< pparams.size(); i++){
					 query.setParameter(paramNamesFind[i], valuesFind[i]);
				}
				if ((startFrom>=0)&&(length>0)){
					query.setFirstResult(startFrom);
				    query.setMaxResults(length);
				}
				results = query.getResultList();
			}
			else{
				query = em.createQuery(pSql.toString());
				if ((startFrom>=0)&&(length>0)){
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
			return (List) results;
		}

	   
		@SuppressWarnings("unchecked")
		@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
		public T findUniqueByProperties(HashMap<String, Object> hashmap)
		{
			try
			{
				return (T)queryFormatByProperties(hashmap).getSingleResult();
			}catch (NoResultException e)
			{
				return null;
			}
		}
		
		@SuppressWarnings("unchecked")
		@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
		public List<T> findByProperties(HashMap<String, Object> hashmap)
		{
			return queryFormatByProperties(hashmap).getResultList();
		}
		
		
		protected Query queryFormatByProperties(HashMap<String, Object> hashmap)
		{
			String s = (new StringBuilder()).append("select modelo from ").append(type.getSimpleName()).append(" modelo ").toString();
			Set<String> set = hashmap.keySet();
			int i = 0;
			for( String sKey : set)
			{
				if(i == 0)
					s = s + " where " + sKey + " = :valor_" + i;
				else
					s = s + " and " + sKey + " = :valor_" + i;
				i++;
			}
			Query query = getEntityManager().createQuery(s);
			i = 0;
			for( String sKey : set)
			{
				query.setParameter("valor_"+i, hashmap.get(sKey));
				i++;
			}

			return query;
		} 
		
		private EntityManager getEntityManager() {
			return this.em;
		}
}
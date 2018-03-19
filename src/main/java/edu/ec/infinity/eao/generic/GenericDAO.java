/*
 * GenericDAO.java
 
 * Created on February 13, 2018, 10:38 AM
 *
 * Copyright INFINITY. All Rights Reserved.
 *
 * INFINITY cia ltda
 * Guayaquil - Ecuador
 * www.infinity.edu
 */

package edu.ec.infinity.eao.generic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * Interfaz de metodos genericos EAO
 * 
 * @author eamaguaya
 * @version $Revision: 1.2 $
 */

public interface GenericDAO<T, PK extends Serializable> {
	void create(T entidad) throws PersistenceException;

	T edit(T entidad) throws PersistenceException;

	void destroy(T entidad) throws PersistenceException;

	T find(Object pk) throws NoResultException;
	T load(Object pk) throws NoResultException;
	List<T> findAll();

	List<T> findPage(int firstResult, int maxResults);

	Long count();

	List<T> findByCriteria(String[] orderList, Criterion... criterions);

	List<T> findPageByCriteria(int firstResult, int maxResults,
			String[] orderList, Criterion... criterions);

	List<T> findPageByCriteria(int firstResult, int maxResults,
			String[] orderList, List<Criterion> criterions);

	/**
	 * Genera una lista paginada de entidades filtrados por los criterios
	 * ingresados
	 * 
	 * @param firstResult
	 *            el valor de first result
	 * @param maxResults
	 *            el valor de max results
	 * @param orderList
	 *            el valor de order list
	 * @param criterions
	 *            el valor de criterions
	 * 
	 * @return el valor de list< t>
	 */
	List<T> findPageByCriteria(int firstResult, int maxResults,
			Order[] orderList, Criterion... criterions);

	@SuppressWarnings("unchecked")
	List findObjectsAdvanced(StringBuffer pSql, HashMap pparams, int startFrom,
			int length);

	int nativeSentenceAdvanced(StringBuffer pSql, HashMap pparams);

	@SuppressWarnings("unchecked")
	List nativeQueryAdvanced(StringBuffer pSql, HashMap pparams,
			String sqlMapping, int startFrom, int length);
	
	public void remove(T entidad) throws PersistenceException;
	
	public T findUniqueByProperties(HashMap<String, Object> hashmap);
	
	public List<T> findByProperties(HashMap<String, Object> hashmap);
}
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

package edu.ec.infinity.dao.generic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * Interfaz de metodos genericos EAO
 * 
 * @author eamaguaya
 * @version $Revision: 1.2 $
 */

public interface IGenericDAO<T, PK extends Serializable> {

	void create(T entidad) throws PersistenceException;

	T edit(T entidad) throws PersistenceException;

	void destroy(T entidad) throws PersistenceException;

	T find(Object pk) throws NoResultException;

	T load(Object pk) throws NoResultException;

	List<T> findPage(int firstResult, int maxResults);

	Long count();

	List<T> findObjectsAdvanced(StringBuffer pSql, HashMap<?, ?> pparams, int startFrom, int length);

	int nativeSentenceAdvanced(StringBuffer pSql, HashMap<?, ?> pparams);

	List<T> nativeQueryAdvanced(StringBuffer pSql, HashMap<?, ?> pparams, String sqlMapping, int startFrom, int length);

	public void remove(T entidad) throws PersistenceException;

	public T findUniqueByProperties(HashMap<String, Object> hashmap);

	public List<T> findByProperties(HashMap<String, Object> hashmap);
}
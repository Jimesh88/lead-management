package com.jimmy.finalproject.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class HibernateDoa<E,K extends Serializable> implements GenericDao<E, K> {

	
	private SessionFactory sessionFactory;
	protected Class<? extends E>daoType;
	
	@SuppressWarnings("unchecked")
	public HibernateDoa(){
		daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
			                       .getActualTypeArguments()[0];
		
		
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
		
		
	}
	protected Session currentSession()
	{
		
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void add(E entity) {
		// TODO Auto-generated method stub
		currentSession().save(entity);
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		// TODO Auto-generated method stub
		currentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E find(K Key) {
		// TODO Auto-generated method stub
		return (E)currentSession().get(daoType, Key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(daoType).list();
	}

}

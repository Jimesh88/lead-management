package com.jimmy.finalproject.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jimmy.finalproject.model.Role;

@Repository("roleDoa")
public class RoleDaoImpl extends HibernateDoa<Role, Long> implements RoleDao {

	@Override
	public Role getRole(long id) {
		// TODO Auto-generated method stub
		Query q = currentSession().createQuery("From Role r where r.roleId=:id");
		q.setParameter("id", id);
		Role role = (Role)q.uniqueResult();
		return role;
	}

}

package com.jimmy.finalproject.dao;

import com.jimmy.finalproject.model.Role;

 
public interface RoleDao extends GenericDao<Role,Long> {
	
	
	Role getRole(long id);
			

}

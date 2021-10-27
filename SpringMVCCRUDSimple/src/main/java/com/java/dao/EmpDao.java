package com.java.dao;  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.beans.Emp;



@Repository

public class EmpDao {  

	@Autowired
	private HibernateTemplate template;
	
	@Transactional
public void save(Emp p){    
	    template.save(p);    
	}
	@Transactional
	public void update(Emp p){    
	   template.update(p);    
	} 
	@Transactional
	public void delete(int id){  
		Emp p = (Emp)this.template.get(Emp.class, id);
	   template.delete(p);    
	}  
	public Emp getEmpById(int id){    
		Emp p = (Emp)this.template.get(Emp.class, id);
	    return p;  
	}    
	
	
	public List<Emp> getEmployeeById(){    
		List<Emp> list=new ArrayList<Emp>();  
	    list=template.loadAll(Emp.class);  
	    return list;     
	}
	
} 

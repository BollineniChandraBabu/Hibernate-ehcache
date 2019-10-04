package com.revature.Hibernate_app.dao;


import org.hibernate.Cache;
import org.hibernate.Session;    
import org.hibernate.SessionFactory;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.revature.Hibernate_app.model.Employee;  
public class FetchTest {
	public static void main(String[] args) throws InterruptedException {    
	    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("com/revature/Hibernate_app/conf/hibernate.cfg.xml").build();  
	    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
	      
	    SessionFactory factory=meta.getSessionFactoryBuilder().build();  
	        
	    Session session1=factory.openSession();    
	    Employee emp1=(Employee)session1.load(Employee.class,1);    
	    System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary());    
	    session1.close();
	 /* Cache cache = factory.getCache();

	    if (cache != null) {
	        cache.evictAllRegions(); // Evict data from all query regions.
	    }	*/   Thread.sleep(12*1000);
	    Session session2=factory.openSession();    
	    Employee emp2=(Employee)session2.load(Employee.class,1);    
	    System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getSalary());    
	    session2.close();         
	}    
}

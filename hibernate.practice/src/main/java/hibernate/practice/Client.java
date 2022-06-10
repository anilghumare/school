package hibernate.practice;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class Client {
	public static void main(String[] main){
		Employee employee = new Employee(1,"Anil",27, new Date());
		Address address = new Address(24,"maha","Pune");
		employee.setAddress(address);
		address.setEmployee(employee);
		
		
		//Scanner scanner = new Scanner(System.in);
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//Employee employee  = (Employee) session.get(Employee.class, 3);
		
		//System.out.println(employee1);
		
		
		//session.saveOrUpdate(new Employee(4,"Raja",29, new Date()));
		/*
		 * Object object = session.get(Employee.class, 4); session.delete(object);
		 */
		/*
		 * Query query = session.
		 * createQuery("select employeeName from Employee e where employeeAge=:eage");
		 * System.out.println("Enter your age"); int age = scanner.nextInt();
		 * query.setParameter("eage", age); List list = query.list(); for(Object
		 * obj:list) { System.out.println(obj); }
		 */
		/*
		 * SQLQuery sqlQuery = session.createSQLQuery("select * from emp");
		 * sqlQuery.addEntity(Employee.class); List list = sqlQuery.list(); for(Object
		 * obj:list) { System.out.println(obj); }
		 */
		/*
		 * Criteria criteria = session.createCriteria(Employee.class);
		 * criteria.addOrder(Order.asc("employeeName"));
		 * 
		 * List list = criteria.list(); for(Object obj:list) { System.out.println(obj);
		 * }
		 */
		session.save(employee);
		session.save(address);
	
		
		Transaction transaction = session.beginTransaction();
		
		
		transaction.commit();
		session.close();
		factory.close();
		
		System.out.println(employee);
	
	}

}

package utils;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		System.out.println("Prueba de conexion");
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
		String sql = "SELECT version();";
		
		String result = (String) session.createNativeQuery(sql).getSingleResult();
		System.out.println(result);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
}

import javax.security.auth.login.Configuration;

public class HibernateUtils {

	public static final SessionFactory sessionFactory = buildSessionFactory();
	
	private satic SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println(e.printStackTrace());
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static SessionFactory close() {
		return getSessionFactory().close();
	}
}

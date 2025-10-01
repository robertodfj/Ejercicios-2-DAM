import HibernateUtils;

public class Main {
	public static void main(String[] args) {
		System.out.println("Prueba de conexion:");
		
		Session sesion = HibernateUtils.getSessionFactory();
		
		String sql = "SELECT version();";
		
		String resultado = (String) sesion.createNativeQuery(sql).getSingleResult();
		System.out.println(resultado);
		
		sesion.close();
		HibernateUtils.close();
	}
}

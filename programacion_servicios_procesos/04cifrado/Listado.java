
import java.security.Provider;
import java.security.Security;
import java.util.Set;

public class Listado {
    public static void main(String[] args) {
        try {
            Provider[] providers = Security.getProviders();

            for (Provider provider : providers) {
                Set<Provider.Service> service = provider.getServices();
                
                for (Provider.Service services : service) {
                    if (services.getType().equals("MessageDigest")) {
                        String algoritmo = services.getAlgorithm();
                        System.out.println(provider.getName() + algoritmo);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

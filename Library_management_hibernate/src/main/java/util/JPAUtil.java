package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	 private static final EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("libraryPU");

	    public static EntityManagerFactory getEMF() {
	        return emf;
}
}
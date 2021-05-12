package aula_devin_jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("aula_jpa");

}

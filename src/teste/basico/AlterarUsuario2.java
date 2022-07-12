package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 4L);
		usuario.setEmail("jonaspereira@gmail.com");
		
		//Comando para tirar o objeto do estado gerenciado.
		em.detach(usuario);
		em.merge(usuario);
		
		em.getTransaction().commit();
		
		emf.close();
		em.close();
	}

}

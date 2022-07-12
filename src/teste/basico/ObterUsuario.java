package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Consulta através do método find()
		Usuario usuario = em.find(Usuario.class, 2l);
		System.out.println(usuario.getNome());
		
		
		emf.close();
		em.close();
	}

}

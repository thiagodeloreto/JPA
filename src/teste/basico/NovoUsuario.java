package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Novo Usuario
		Usuario novoUsuario = new Usuario("Estev�o", "estevaogrecco@gmail.com");
		
		//Transa��o para o Banco de Dados -> Persist�ncia de Dados.
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println("O ID do novo usu�rio �: " + novoUsuario.getId());
		
		em.close();
		emf.close();
		
	}

}
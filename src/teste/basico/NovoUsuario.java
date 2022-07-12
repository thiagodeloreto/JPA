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
		Usuario novoUsuario = new Usuario("Estevão", "estevaogrecco@gmail.com");
		
		//Transação para o Banco de Dados -> Persistência de Dados.
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println("O ID do novo usuário é: " + novoUsuario.getId());
		
		em.close();
		emf.close();
		
	}

}
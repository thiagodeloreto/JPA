package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		//In�cio da transa��o
		em.getTransaction().begin();
		
		//Escolha do usu�rio e altera��o
		Usuario usuario = em.find(Usuario.class, 6L);
		usuario.setNome("Joice");
		usuario.setEmail("joiceabdalla@gmail.com");
		
		//Comando para cruzar os dados alterados
		em.merge(usuario);
		
		//Fim da transa��o
		em.getTransaction().commit();
	
		//Encerramento da conex�o
		emf.close();
		em.close();

	}

}

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
		
		//Início da transação
		em.getTransaction().begin();
		
		//Escolha do usuário e alteração
		Usuario usuario = em.find(Usuario.class, 6L);
		usuario.setNome("Joice");
		usuario.setEmail("joiceabdalla@gmail.com");
		
		//Comando para cruzar os dados alterados
		em.merge(usuario);
		
		//Fim da transação
		em.getTransaction().commit();
	
		//Encerramento da conexão
		emf.close();
		em.close();

	}

}

package teste.basico;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		
		//Itera��o da lista com os resultados
				for(Usuario usuario: usuarios) {
					System.out.println("O usu�rio do sistema " + usuario.getNome() +
					" possui o ID: " + usuario.getId() + ".\n\nSeu e-mail �: " + 
					usuario.getEmail() + "\n\n");
				}
		
		em.close();
		emf.close();
	}
}

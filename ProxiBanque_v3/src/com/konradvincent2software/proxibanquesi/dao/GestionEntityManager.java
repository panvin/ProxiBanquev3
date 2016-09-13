package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe permettant la gestion de l'EntityManager
 * Cette classe permet de gerer l'EntityManager pour le domaine de persistance pour JPA
 * @author Konrad THHOMAS et VIncent PANOUILLERES
 *
 */
public class GestionEntityManager {
	
	/** 
	 * M�thode permettant de cr�er un EntityManager pour JPA
	 * @return L'entityManager (Objet de type EntityManager)
	 */
	public EntityManager creerEntityManager(){
		// Ouverture unit� de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
	/**
	 * M�thode permettant de fermer l'EntityManager
	 * @param em L'entityManager qu'on souhaite fermet (Objet de type EntityManager)
	 */
	public void fermerEntityManager( EntityManager em){
		// Fermeture unit� de travail JPA
		EntityManagerFactory emf = em.getEntityManagerFactory();
		em.close();
		emf.close();	 
	}

}

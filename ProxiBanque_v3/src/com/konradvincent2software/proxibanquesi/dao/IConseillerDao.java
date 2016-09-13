package com.konradvincent2software.proxibanquesi.dao;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Interface pour la Classe de gestion des conseillerds en base de donn�es
 * @author Konrad THOMAS et VIncent PANOUILLERES
 */
public interface IConseillerDao {
	
	/**
	 * M�thode permettant la cr�ation en base d'un nouveau conseiller en base
	 * @param conseiller L'objet conseiller qu'on souhaite entrer dans la base de donn�es. (Objet de type Conseiller)
	 * @return Retourne true si la methode se deroule correctement, retourne false sinon (bool�en)
	 */
	public void createConseiller(Conseiller conseiller);
	
	/**
	 * M�thode permettant de r�cup�rer les informations en base d'un conseiller � partir de son login
	 * @param loginInit Login du conseiller (String)
	 * @return conseiller Le conseiller obtenu � partir du Login (Objet de type Conseiller).
	 */
	public Conseiller readConseillerByLogin(String loginInit);
	
	/**
	 * M�thode permettant de mettre � jour en base un conseiller � partir de son login
	 * @param loginInit Login du conseiller (String)
	 * @param newConseiller Objet Conseiller contenant les nouvelles informations (Objet de type Conseiller)
	 * @return Retourne true si la methode se deroule correctement, retourne false sinon (bool�en)
	 */
	public void updateConseillerByLogin(String loginInit, Conseiller newConseiller);
	
	/**
	 * M�thode permettant de supprimer en base un conseiller � partir de son login.
	 * @param loginInit Login du conseiller (String).
	 * @return Retourne true si la methode se deroule correctement, retourne false sinon (bool�en).
	 */
	public void deleteConseillerByLogin(String loginInit);
}
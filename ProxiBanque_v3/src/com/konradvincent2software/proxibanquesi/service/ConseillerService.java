package com.konradvincent2software.proxibanquesi.service;

import com.konradvincent2software.proxibanquesi.dao.ConseillerDaoJpa;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe de la couche service concernant l'ensemble des op�ration pour le conseiller 
 * Cette classe permet de cr�er, modifier, supprimer, lire ou effacer
 * un conseiller
 * 
 * @author Konrad THOMAS et Vincent PANOUILLERES
 *
 */
public class ConseillerService {

	/**
	 * Cette m�thode permet de cr�er un conseiller dans la base de donn�es.
	 * @param conseiller L'objet conseiller qu'on va vouloir stocker dans la database (Objet de type Conseiller)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon false. (bool�en)
	 */
	public boolean creerConseiller(Conseiller conseiller) {
		try{
		ConseillerDaoJpa conseillerDao = new ConseillerDaoJpa();
		conseillerDao.createConseiller(conseiller);
		return true;
		}
		catch(Exception e){
			return false;
		}

	}

	/**
	 * Cette m�thode permet de modifier un conseiller dans la base de donn�es
	 * @param login Le login unique du conseiller (String)
	 * @param conseiller L'objet conseiller modifi� (Objet de type conseiller)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon false. (bool�en)
	 */
	public boolean modifierConseiller(String login, Conseiller conseiller) {
		try{
		ConseillerDaoJpa conseillerDao = new ConseillerDaoJpa();
		conseillerDao.updateConseillerByLogin(login, conseiller);
		return true;
		} catch (Exception e){
			return false;
		}
	}

	/**
	 * Cette m�thode permet de supprimer un conseiller de la base de donn�es � partir de son Login
	 * @param login Le login unique du conseiller (String)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon false. (bool�en)
	 */
	public boolean supprimerConseiller(String login) {
		try{
			ConseillerDaoJpa conseillerDao = new ConseillerDaoJpa();
			conseillerDao.deleteConseillerByLogin(login);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	/**
	 * Cette m�trhode permet de recuperer les informations
	 * @param login Le login unique du conseiller (String)
	 * @return Le conseiller correspondant � l'identifiant sp�cifi� en param�tre (Objet de type Conseiller)
	 */
	public Conseiller lireConseiller(String login) {
		ConseillerDaoJpa conseillerDao = new ConseillerDaoJpa();
		Conseiller conseiller = conseillerDao.readConseillerByLogin(login);
		return conseiller;
	}
}

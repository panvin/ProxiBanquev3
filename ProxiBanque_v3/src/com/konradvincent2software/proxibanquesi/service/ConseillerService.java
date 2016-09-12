package com.konradvincent2software.proxibanquesi.service;

import com.konradvincent2software.proxibanquesi.dao.ClientDao;
import com.konradvincent2software.proxibanquesi.dao.ConseillerDao;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe de la couche service concernant l'ensemble des op�ration pour le
 * conseiller Cette classe permet de cr�er, modifier, supprimer, lire ou effacer
 * un conseiller
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ConseillerService {

	/**
	 * Cette m�thode permet de cr�er un conseiller dans la base de donn�es.
	 * 
	 * @param conseiller
	 *            L'objet conseiller qu'on va vouloir stocker dans la database
	 *            (Objet de type Conseiller)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon
	 *         false. (bool�en)
	 */
	public boolean creerConseiller(Conseiller conseiller) {
		boolean status;
		ConseillerDao conseillerDao = new ConseillerDao();
		status = conseillerDao.createConseiller(conseiller);
		return status;

	}

	/**
	 * Cette m�thode permet de modifier un conseiller dans la base de donn�es
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @param conseiller
	 *            L'objet conseiller modifi� (Objet de type conseiller)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon
	 *         false. (bool�en)
	 */
	public boolean modifierConseiller(String login, Conseiller conseiller) {
		ConseillerDao conseillerDao = new ConseillerDao();
		boolean status = conseillerDao.updateConseillerByLogin(login, conseiller);
		return status;
	}

	/**
	 * Cette m�thode permet de supprimer un conseiller de la base de donn�es �
	 * partir de son Login
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon
	 *         false. (bool�en)
	 */
	public boolean supprimerConseiller(String login) {
		boolean status;
		ConseillerDao conseillerDao = new ConseillerDao();
		status = conseillerDao.deleteConseillerByLogin(login);
		return status;
	}

	/**
	 * Cette m�trhode permet de recuperer les informations
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @return Le conseiller correspondant � l'identifiant sp�cifi� en param�tre
	 *         (Objet de type Conseiller)
	 */
	public Conseiller lireConseiller(String login) {
		ConseillerDao conseillerDao = new ConseillerDao();
		Conseiller conseiller = conseillerDao.readConseillerByLogin(login);
		return conseiller;
	}
}

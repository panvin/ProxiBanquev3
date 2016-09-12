package com.konradvincent2software.proxibanquesi.service;

import java.util.ArrayList;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.konradvincent2software.proxibanquesi.domaine.Coordonnees;
import com.konradvincent2software.proxibanquesi.dao.ClientDao;
import com.konradvincent2software.proxibanquesi.dao.CompteDao;
import com.konradvincent2software.proxibanquesi.dao.CoordonneesDao;

/**
 * Classe du domaine service qui concerne l'ensemble des services Clients. Cette
 * classe va permettre de: modifier, supprimer, creer, lire un client et
 * egalement d'obtenir la liste de tous les clients.
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ClientService {

	/**
	 * Cette classe permet de cr�er un client dans la base de donn�e.
	 * 
	 * @param client
	 *            Le client qu'on souhaite cr�er dans la base de donn�e. (Objet
	 *            de type CLient)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon
	 *         false. (bool�en)
	 */
	public boolean creerClient(Client client) {
		boolean status, statusCreationClient, statusCreationCoord, statusCreationCompteEpargne,
				statusCreationCompteCourant;
		ClientDao clientDao = new ClientDao();
		CoordonneesDao coordonneesDao = new CoordonneesDao();
		CompteDao compteDao = new CompteDao();
		
		statusCreationClient = clientDao.createClient(client);
		statusCreationCoord = coordonneesDao.createCoordonnees(client.getCoordonnees(), client.getId());

		status = statusCreationClient && statusCreationCoord;

		if (client.getCompteEpargne() != null) {
			statusCreationCompteEpargne = compteDao.createCompte(client.getCompteEpargne(), "Epargne", client.getId());
			status = status && statusCreationCompteEpargne;
		}

		if (client.getCompteCourant() != null) {
			statusCreationCompteCourant = compteDao.createCompte(client.getCompteCourant(), "Courant", client.getId());
			status = status && statusCreationCompteCourant;
		}

		return status;
	}

	/**
	 * Cette m�thode permet de modifier un client � partir de son identifiant
	 * (id).
	 * 
	 * @param idClient
	 *            L'identifiant du client qu'on souhaite changer. (int)
	 * @param client
	 *            L'objet client qui va permettre de mettre � jour le client
	 *            dans la base de donn�es. (Objet de type Client)
	 * 
	 */
	public boolean modifierClient(int idClient, Client client) {
		boolean status;
		ClientDao clientDao = new ClientDao();
		CoordonneesDao coordonneesDao = new CoordonneesDao();
		status = clientDao.updateClientById(idClient, client);
		coordonneesDao.updateCoordonneesByClientId(idClient, client.getCoordonnees());
		return status;
	}

	/**
	 * Cette m�thode permet de supprimer un client de la base de donn�e.
	 * 
	 * @param idClient
	 *            L'identifiant (id) du client qu'on souhaite supprimer.
	 */
	public boolean suppressionClient(int idClient) {
		boolean status;
		CoordonneesDao coordonneesDao = new CoordonneesDao();
		CompteDao compteDao = new CompteDao();
		coordonneesDao.deleteCoordonneesByClientId(idClient);
		ClientDao clientDao = new ClientDao();
		compteDao.deleteCompteByIdClient(idClient);
		status = clientDao.deleteClientById(idClient);
		return status;

	}

	/**
	 * Cette m�thode permet de recuperer les informations client sous la forme
	 * d'un objet Client.
	 * 
	 * @param idClient
	 *            L'identifiant (id) du client dont on souhaite consulter les
	 *            donn�es. (int)
	 * @return Retourne un bool�en: true si tout se d�roule sans problemes sinon
	 *         false. (bool�en)
	 */
	public Client lireClient(int idClient) {
		ClientDao clientDao = new ClientDao();
		CoordonneesDao coordonneesDao = new CoordonneesDao();
		CompteDao compteDao = new CompteDao();
		
		Client client = clientDao.readClientById(idClient);
		Coordonnees coordClient = coordonneesDao.readCoordonneesByIdClient(idClient);
		client.setCoordonnees(coordClient);
		
		CompteEpargne compteEpargneClient = (CompteEpargne) compteDao.readCompteByClientAndByType(idClient, "Epargne");
		client.setCompteEpargne(compteEpargneClient);
		CompteCourant compteCourantClient = (CompteCourant) compteDao.readCompteByClientAndByType(idClient, "Courant");
		client.setCompteCourant(compteCourantClient);
		return client;
	}

	/**
	 * Cette m�thode permet de recuperer une liste de l'ensemble des clients qui
	 * existent.
	 * 
	 * @return Cette methode retourne une liste de Client sous forme d'ArrayList
	 *         (ArrayList<Client>)
	 */
	public ArrayList<Client> lireTousLesCLients() {
		ArrayList<Client> listeClient;
		ClientDao clientDao = new ClientDao();
		listeClient = (ArrayList<Client>) clientDao.readAllClient();
		return listeClient;
	}

	/**
	 * Cette m�thode permet � partir du login d'un conseiller de retrouver
	 * l'ensemble des clients rattach�s � ce conseiller. Cette methode renvoie
	 * les CLients sous forme d'ArrayList
	 * 
	 * @param login
	 *            Le login du conseiller responsable des clients dont on veut la
	 *            liste (String).
	 * @return Cette methode retourne une liste de Client sous forme d'ArrayList
	 *         (ArrayList<Client>)
	 */
	public ArrayList<Client> lireClientsParConseiller(String login) {
		ArrayList<Client> listeClient;
		ClientDao clientDao = new ClientDao();
		
		listeClient = (ArrayList<Client>) clientDao.readClientByConseiller(login);
		return listeClient;
	}
}

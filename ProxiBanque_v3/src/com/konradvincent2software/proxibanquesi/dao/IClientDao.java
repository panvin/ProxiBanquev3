package com.konradvincent2software.proxibanquesi.dao;

import java.util.Collection;

import com.konradvincent2software.proxibanquesi.domaine.Client;

/**
 * Interface pour la Classe de gestion des clients en base de donn�es
 * @author Konrad THOMAS et VIncent PANOUILLERES
 *
 */
public interface IClientDao {
	
	/**
	 * Methode permettant de cr�er un client
	 * @param client Le client a cr�er en base de donn�es (Objet de type Client)
	 * @return Retourne un bool�en (true si r�ussi sinon false)
	 */
	public boolean createClient(Client client);
	
	/**
	 * Methode permettant de lire l'ensemble des clients en base de donn�es
	 * @return Retourne une collection de client (Objet de type Collection)
	 */
	public Collection<Client> readAllClient();
	
	/**
	 * M�thode permettant de r�cup�rer en base la liste des clients d'un conseiller � partir de son login
	 * @param logInit login du conseiller (String)
	 * @return Collection de Clients (Collection de Client)
	 */
	public Collection<Client> readClientByConseiller(String logInit);
	
	/**
	 * M�thode permettant de r�cup�rer en base les informations d'un Client � partir de son identifiant
	 * @param idInit L'identifiant unique du client (int)
	 * @return Client Retourne l'objet client correspondant � l'identifiant sp�cifi� (Objet Client)
	 */
	public Client readClientById(int idInit);
	
	/**
	 * M�thode permettant de mettre � jour en base un client � partir de son identifiant
	 * @param idInit L'identifiant du Client � mettre � jour (int)
	 * @param newClient Objet Client contenant les nouvelles informations (Client)
	 * @return Retourne true si la m�thode se d�roule bien sinon retourne false (bool�en)
	 */
	public boolean updateClientById(int idInit, Client newClient);
	
	/**
	 * M�thode permettant de supprimer en base un client � partir de son identifiant
	 * @param idInit L'identifiant du client � supprimer (int)
	 * @return Retourne true si la m�thode se d�roule bien sinon retourne false (bool�en)
	 */
	public boolean deleteClientById(int idInit);
}
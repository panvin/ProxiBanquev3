package com.konradvincent2software.proxibanquesi.dao;

import java.util.ArrayList;

import com.konradvincent2software.proxibanquesi.domaine.Compte;

/**
 * Interface pour la Classe de gestion des comptes en base de donn�es
 * @author Konrad THOMAS et VIncent PANOUILLERES
 */
public interface ICompteDao {
	
	/**
	 * M�thode permettant de cr�er en base un compte.
	 * @param compte Objet compte li� au compte qu'on souhaite cr�er. (Objet de type COmpte)
	 * @param typeCompte Le type de compte qui va �tre cr�e: "Courant" ou "Epargne". (String)
	 * @param idClient Identifiant du client titulaire du futur compte. (int)
	 * @return Renvoie true si la m�thode se d�roule sans probleme, renvoie false sinon. (bool�en)
	 */
	public boolean createCompte(Compte compte, String typeCompte, int idClient);
	
	/**
	 * M�thode permettant d'obtenir les informations d'un compte � partir de son num�ro.
	 * @param numCompte Le num�ro du compte dont on souhaite obtenir des informations. (String)
	 * @return Retourne l'objet compte � partir du numero de compte specifi� en parametre de la m�thode. (Objet de type Compte)
	 */
	public Compte readCompteByNum(String numCompte);
	
	/**
	 * M�thode permettant de modifier en base le solde d'un compte � partir du num�ro de compte.
	 * @param numCompte Le num�ro de compte qu'on souhaite mettre � jour. (String)
	 * @param newSolde Le nouveau solde du compte � mettre � jour. (float)
	 * @return Renvoie true si la m�thode se d�roule sans probleme, renvoie false sinon. (bool�en)
	 */
	public boolean updateCompteByNum(String numCompte, float newSolde);
	
	/**
	 * M�thode permettant de supprimer en base un compte � partir de son num�ro.
	 * @param numCompte Le num�ro du compte � supprimer dans la base de donn�es. (String)
	 * @return Renvoie true si la m�thode se d�roule sans probleme, renvoie false sinon. (bool�en)
	 */
	public boolean deleteCompteByNum(String numCompte);
	
	/**
	 * M�thode permettant de supprimer en base un compte � partir de l'identifiant client.
	 * @param idClient L'identifiant du client dont on souhaite supprimer le ou les comptes. (int)
	 * @return Renvoie true si la m�thode se d�roule sans probleme, renvoie false sinon. (bool�en)
	 */
	public boolean deleteCompteByIdClient(int idClient);
	
	/**
	 * M�thode permettant de lire en base l'ensemble des comptes clients.
	 * @return Renvoie une liste de compte (Objet de type ArrayList).
	 */
	public ArrayList<Compte> readAllCompte();

}
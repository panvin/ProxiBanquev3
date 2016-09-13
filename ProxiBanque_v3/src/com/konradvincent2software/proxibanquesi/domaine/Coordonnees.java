package com.konradvincent2software.proxibanquesi.domaine;

import javax.persistence.Embeddable;

/**
 * Classe Coordonn�es, repr�sente les coordon�es d'un client proxibanque
 * @author Konrad THOMAS et Vincent PANOUILLERES
 *
 */

@Embeddable
public class Coordonnees {
	
	private String adresse;
	private String ville;
	private String telephone;
	private String cp;


	/**
	 * Constructeur de la classe Coordonnees
	 * @param adresse L'adresse (String)
	 * @param ville La ville (String)
	 * @param telephone Le telephone (String)
	 * @param cp Le code postal (String)
	 */
	public Coordonnees(String adresse, String ville, String telephone, String cp) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.cp = cp;
	}
	
	/**
	 * Constructeur par defaut de la classe coordonnees
	 */
	public Coordonnees(){
		
	}

	/**
	 * M�thode permettant d'obtenir l'adresse
	 * @return L'adresse (String)
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * M�thode permettant de modifier l'adresse
	 * @param adresse L'adresse (String)
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * M�thode permettant d'obtenir la ville
	 * @return La ville (String)
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * M�thode permettant de modifier la ville
	 * @param ville La ville (String)
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * M�thode permettant d'obtenir le numero de telephone
	 * @return Le telephone (String)
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * M�thode permettant de modifier le numero de telephone
	 * @param telephone Le telephone (String)
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * M�thode permettant d'obtenir le code postal
	 * @return Le code postal (String)
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * M�thode permettant de modifier le code postal
	 * @param cp Le code postal (String)
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
}

package com.konradvincent2software.proxibanquesi.domaine;

/**
 * Classe Abstraite Personne, repr�sente les personnes qui interviennent dans le
 * SI
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
public abstract class Personne {

	private String nom;
	private String prenom;
	private String civilite;

	/**
	 * Constructeur de la classe Personne
	 * 
	 * @param nom
	 *            Le nom de la personne (String)
	 * @param prenom
	 *            Le prenom de la personne (String)
	 * @param civilite
	 *            La civilit� de la personne (String)
	 */
	public Personne(String nom, String prenom, String civilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}

	/**
	 * M�thode permettant d'obtenir le nom de la personne
	 * 
	 * @return Le nom de la personne (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * M�thode permettant de modifier le nom de la personne
	 * 
	 * @param nom
	 *            Le nom de la personne (String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * M�thode permettant d'obtenir le prenom de la personne
	 * 
	 * @return Le prenom de la personne (String)
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * M�thode permettant de modifier le prenom de la personne
	 * 
	 * @param prenom
	 *            Le prenom de la personne (String)
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * M�thode permettant d'obtenir la civilit� de la personne
	 * 
	 * @return La civilit� de la personne (String)
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * M�thode permettant de modifier la civilit� de la personne
	 * 
	 * @param civilite
	 *            La civilit� de la personne (String)
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
}

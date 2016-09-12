package com.konradvincent2software.proxibanquesi.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe abstraite Compte, repr�sente les comptes des clients de proxibanque C'est � partir de cette classe que sont construites les Classes CompteEpargne et CompteCourant. Contient le solde, le numero de compte, et la date d'ouverture du compte.
 * @author Konrad THOAMAS et Vincent PANOUILLERES
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@DiscriminatorValue("MERE")
public abstract class Compte {

	@Id
	private String numero;
	private Float solde;
	private String dateOuverture;
	
	/**
	 * Constructeur de la classe Compte
	 * @param numero Le numero du compte (String)
	 * @param solde Le solde du compte (float)
	 * @param dateOuverture La date d'ouverture du compte (String)
	 */
	public Compte(String numero, Float solde, String dateOuverture) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	/**
	 * M�thode permettant d'obtenir le num�ro du compte
	 * @return Le numero du compte (String)
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * M�thode permettant de modifier le num�ro du compte
	 * @param numero Le numero du compte (String)
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * M�thode permettant d'obtenir le solde du compte
	 * @return Le solde du compte (float)
	 */
	public Float getSolde() {
		return solde;
	}

	/**
	 * M�thode permettant de modifier le solde du compte
	 * @param solde Le solde du compte (float)
	 */
	public void setSolde(Float solde) {
		this.solde = solde;
	}

	/**
	 * M�thode permettant d'obtenir la date d'ouverture du compte
	 * @return La date d'ouverture du compte (String)
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * M�thode permettant de modifier la date d'ouverture du compte
	 * @param dateOuverture La date d'ouverture du compte (String)
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	
}

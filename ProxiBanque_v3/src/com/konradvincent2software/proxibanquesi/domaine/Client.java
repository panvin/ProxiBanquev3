package com.konradvincent2software.proxibanquesi.domaine;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.domaine.Coordonnees;
import com.konradvincent2software.proxibanquesi.domaine.Personne;

/**
 * Classe de la couche Domaine Permet de stocker et manipuler l'ensemble des
 * �l�ments m�tieurs correspondant � un client de ProxiBanque
 * 
 * @author Konrad THOMAS et Vincent PANOUILLERES
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Client extends Personne {

	private String email;
	@Embedded
	private Coordonnees coordonnees;
	@Id
	private int id;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Conseiller monConseiller;
	@OneToOne(orphanRemoval = true)
	private CompteEpargne compteEpargne;
	@OneToOne(orphanRemoval = true)
	private CompteCourant compteCourant;

	/**
	 * Constructeur de la classe Client
	 * @param nom Le Nom du client (String).
	 * @param prenom Le Prenom du client (String).
	 * @param civilite La civilit� du client (String).
	 * @param email L'email du client (String).
	 * @param adresse L'adresse du client (String)
	 * @param ville La ville du client (String)
	 * @param telephone Le telephone du client (String)
	 * @param cp Le code postal du client (String)
	 * @param id L'identifiant unique du client (int)
	 * @param monConseiller Le conseiller correspondant au client (Objet Conseiller)
	 * @param compteEpargne Le compte Epargne correspondant au client (Objet CompteEpargne)
	 * @param compteCourant Le compte Courant correspondant au client (Objet COmpteCourant)
	 */
	public Client(String nom, String prenom, String civilite, String email, String adresse, String ville,
			String telephone, String cp, int idClient, Conseiller monConseiller, CompteEpargne compteEpargne,
			CompteCourant compteCourant) {
		super(nom, prenom, civilite);
		this.email = email;
		this.coordonnees = new Coordonnees(adresse, ville, telephone, cp);
		this.id = idClient;
		this.monConseiller = monConseiller;
		this.compteEpargne = compteEpargne;
		this.compteCourant = compteCourant;
	}

	/**
	 * Constructeur de la classe Client avec compte epargne et courant null
	 * 
	 * @param nom Le Nom du client (String).
	 * @param prenom Le Prenom du client (String).
	 * @param civilite La civilit� du client (String).
	 * @param email L'email du client (String).
	 * @param adresse L'adresse du client (String)
	 * @param ville La ville du client (String)
	 * @param telephone Le telephone du client (String)
	 * @param cp Le code postal du client (String)
	 * @param id L'identifiant unique du client (int)
	 * @param monConseiller Le conseiller correspondant au client (Objet Conseiller)
	 */
	public Client(String nom, String prenom, String civilite, String email, String adresse, String ville,
			String telephone, String cp, int idClient, Conseiller monConseiller) {
		super(nom, prenom, civilite);
		this.email = email;
		this.coordonnees = new Coordonnees(adresse, ville, telephone, cp);
		this.id = idClient;
		this.monConseiller = monConseiller;
		this.compteEpargne = null;
		this.compteCourant = null;
	}

	/**
	 * Constructeur de la classe Client
	 * @param nom Le Nom du client (String).
	 * @param prenom Le Prenom du client (String).
	 * @param civilite La civilit� du client (String).
	 */
	public Client(String nom, String prenom, String civilite, String emailClient, int idClient) {
		super(nom, prenom, civilite);
		this.id = idClient;
		this.email = emailClient;
	}
	
	/**
	 * Constructeur par d�faut
	 */
	public Client(){
		super();
	}

	/**
	 * M�thode permettant d'obtenir l'Email du Client
	 * @return L'email du client (String).
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M�thode permettant de modifier l'Email du Client
	 * @param email L'email du client (String).
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * M�thode permettant d'obtenir les coordonn�es du Client
	 * @return Les coordonn�es du client (Objet de type Coordonnees)
	 */
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	/**
	 * M�thode permettant de modifier les coordonn�es du Client
	 * @param Les coordonn�es du client (Objet de type Coordonn�es)
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	/**
	 * M�thode permettant d'obtenir les informations du compte epargne du Client
	 * @return Le compte courant du client (Objet de type COmpteCourant)
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * M�thode permettant de modifier les informations du compte epargne du
	 * Client
	 * @param compteEpargne Le compte courant du client (Objet de type COmpteCourant)
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	/**
	 * M�thode permettant d'obtenir les informations du compte courant du Client
	 * @return Le compte courant du client (Objet de type COmpteCourant)
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * M�thode permettant de modifier les informations du compte courant du
	 * Client
	 * @param compteCourant Le compte courant du client (Objet de type COmpteCourant)
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	/**
	 * M�thode permettant d'obtenir l'identifiant du client
	 * @return L'identifiant unique du client (int)
	 */
	public int getId() {
		return id;
	}

	/**
	 * M�thode permettant de modifier l'identifiant du Client
	 * @param id L'identifiant unique du client (int)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * M�thode permettant d'obtenir le conseiller du client
	 * @return Le conseill� auquel est rattach� le client (Objet de type Conseiller)
	 */
	public Conseiller getMonConseiller() {
		return monConseiller;
	}

	/**
	 * M�thode permettant de modifier le conseiller du client
	 * @param monConseiller Le conseill� auquel est rattach� le client (Objet de type Conseiller)
	 */
	public void setMonConseiller(Conseiller monConseiller) {
		this.monConseiller = monConseiller;
	}
}

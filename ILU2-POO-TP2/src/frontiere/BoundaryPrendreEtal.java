package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu;
		boolean etalDisponible;
		nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée "+ nomVendeur + " mais il faut être un habitant de notre village pour commercer ici\n");	
		}else {
			System.out.println("Bonjour "+ nomVendeur + ", je vais regarder si je peux vous trouver un étal\n");
			etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé\n");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int quantite;
		int numeroEtal;
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements :\n");
		System.out.println("Quel produit souhaitez-vous vendre ?");
		produit=scan.next();
		System.out.println("Combien souhaitez-vous en vendre ?");
		quantite=scan.nextInt();
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		if (numeroEtal !=-1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + numeroEtal + "\n");
		}
	}	
}

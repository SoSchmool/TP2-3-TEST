package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit;
		int vendeur, quantite;
		String[] vendeurs;
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici");
		}else {
		System.out.println("Quel produit voulez-vous acheter ?");
		produit = scan.nextLine();
		vendeurs = controlAcheterProduit.vendeursProduit(produit);
		if (vendeurs == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
		}else {
			System.out.println("Chez quel commerçant voulez-vous acheter des " + produit +" ?");
			for (int i=0; i<vendeurs.length; i++) {
				System.out.println((i+1) + " - " + vendeurs[i]);
			}
			vendeur = scan.nextInt()-1;
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurs[vendeur]);
			System.out.println("Bonjour " + nomAcheteur);
			System.out.println("Combien de " + produit + " voulez-vous acheter ?");
			quantite = scan.nextInt();
			if (controlAcheterProduit.quantiteDisponible(vendeurs[vendeur]) == 0) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheurement il n'y en a plus !");
			}else if(controlAcheterProduit.quantiteDisponible(vendeurs[vendeur]) < quantite) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheursement " + vendeurs[vendeur] + " n'en a plus que " + controlAcheterProduit.quantiteDisponible(vendeurs[vendeur]) + ". " + nomAcheteur + " achète tout le stock de " + vendeurs[vendeur]);
				controlAcheterProduit.miseAJourQuantite(vendeurs[vendeur], quantite);
			}else {
				System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + vendeurs[vendeur]);
				controlAcheterProduit.miseAJourQuantite(vendeurs[vendeur], quantite);
			}
		}
	}
	}
}

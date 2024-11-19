package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public String[] vendeursProduit(String produit) {
		if (village.rechercherVendeursProduit(produit) == null) {
			return null;
		}else {
		String[] vendeursProduit = new String[village.rechercherVendeursProduit(produit).length];
		for(int i=0; i<village.rechercherVendeursProduit(produit).length; i++) {
			vendeursProduit[i] = village.rechercherVendeursProduit(produit)[i].getNom();
		}
		return vendeursProduit;
		}
	}
	
	public void miseAJourQuantite(String nomVendeur, int quantite) {
		controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
	}
			
	
	public int quantiteDisponible(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite();
	}
	
	public boolean verifierIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}

	//TODO a completer
}

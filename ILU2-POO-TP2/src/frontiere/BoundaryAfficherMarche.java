package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		int tailleMarche;
		String[] infosMarche;
		if (controlAfficherMarche.donnerInfosMarche().length == 0) {
			System.out.println("Le marché est vide, revenez plus tard\n");
		}else {

			System.out.println(nomAcheteur + ", vous trouverez au marché.\n");
			tailleMarche = controlAfficherMarche.donnerInfosMarche().length;
			infosMarche = controlAfficherMarche.donnerInfosMarche();
			for (int i=0; i<tailleMarche; i=i+3) {
				System.out.println("- " + infosMarche[i] + " qui vend " + infosMarche[i+1] + " " + infosMarche[i+2]);
			}
		}
	}
}

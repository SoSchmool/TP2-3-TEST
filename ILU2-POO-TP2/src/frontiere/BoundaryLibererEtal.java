package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu;
		String[] donneesEtal = new String[5];
		vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !\n");
		}else {
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (Boolean.TRUE.equals(Boolean.valueOf(donneesEtal[0]))) {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journ�e");
			}
			controlLibererEtal.etalLib�r�(nomVendeur);
		}
	}

}
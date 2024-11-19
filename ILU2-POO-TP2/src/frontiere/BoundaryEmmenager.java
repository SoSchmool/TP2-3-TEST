package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int forceGaulois;
					System.out.println("Bienvenue villageois " + nomVisiteur + "\n");
					question.delete(0, question.length());
					question.append("Quelle est votre force\n");
					forceGaulois= Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide, effetPotionMax=-1, effetPotionMin=0;
		StringBuilder questionDruide = new StringBuilder();
		System.out.println("Bienvenue druide " + nomVisiteur + "\n");
		questionDruide.append("Quelle est votre force ?\n");
		forceDruide = Clavier.entrerEntier(questionDruide.toString());
		while(effetPotionMax < effetPotionMin) {
			questionDruide.delete(0, questionDruide.length());
			questionDruide.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMin=Clavier.entrerEntier(questionDruide.toString());
			questionDruide.delete(0, questionDruide.length());
			questionDruide.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
			effetPotionMax=Clavier.entrerEntier(questionDruide.toString());
			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum\n");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		
	}
}

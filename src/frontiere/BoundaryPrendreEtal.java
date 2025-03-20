package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		int numeroEtal = -1;
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
		boolean etatDisponible = controlPrendreEtal.resteEtals();
		if (!etatDisponible) {
			System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déjà occupé.");
			return;
		}
		installerVendeur(nomVendeur);
		return;
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\nIl me faudrait quelques renseignements :\n");
		StringBuilder chaine = new StringBuilder();
		chaine.append("Quel produit souhaitez-vous vendre ?\n");
		String produit = Clavier.entrerChaine(chaine.toString());
		
	}
}

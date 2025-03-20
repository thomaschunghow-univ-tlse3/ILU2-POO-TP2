package frontiere;

import controleur.ControlPrendreEtal;
import personnages.Gaulois;

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
	}
	
	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\nIl me faudrait quelques renseignements :\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre?\n");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n� " + numeroEtal);
		}
	}
}

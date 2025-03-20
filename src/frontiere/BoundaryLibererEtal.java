package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
//		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur) != null;
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur) != null && controlLibererEtal.isVendeur(nomVendeur).isEtalOccupe();
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
			return;
		}
		String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
		boolean etatOccupe = donneesEtal[0] == "true";
		if (etatOccupe) {
			System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".\n");
			System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.\n");
		}
	}

}

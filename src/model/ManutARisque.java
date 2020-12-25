package model;

import Linterface.ARisque;

public class ManutARisque extends Manutentionnaire implements ARisque {

	public ManutARisque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManutARisque(String nom, String prenom, int age, String date, double chiffreAffaire, int heurs) {
		super(nom, prenom, age, date, chiffreAffaire, heurs);
		// TODO Auto-generated constructor stub
	}   
}

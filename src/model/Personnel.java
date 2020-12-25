package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Personnel {

	Conection con = new Conection();

	private Employe[] staff;
	private int nbreEmploye;
	private final static int MAXEMPLOYE = 200;

	public Personnel() {
		staff = new Employe[MAXEMPLOYE];
		nbreEmploye = 0;
	}

	public void create_data(String nom, String prenom, int age, int date, String type, double chiffreAffaire) {
		// TODO Auto-generated method stub

	}
}

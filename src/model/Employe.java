package model;

import java.sql.PreparedStatement;

abstract class Employe {
	private String nom;
	private String prenom;
	private int age;
	private String date;
	double chiffreAffaire;

	public Employe(String nom, String prenom, int age, String date, double chiffreAffaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
		this.chiffreAffaire = chiffreAffaire;
	}

	static Conection con = new Conection();

	public Employe() {

	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

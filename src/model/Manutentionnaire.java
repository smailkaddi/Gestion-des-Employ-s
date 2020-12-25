package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Manutentionnaire extends Employe {

	private final static double SALAIRE_HORAIRE = 50;
	private int heurs;

	public Manutentionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manutentionnaire(String nom, String prenom, int age, String date, double chiffreAffaire, int heurs) {
		super(nom, prenom, age, date, chiffreAffaire);
		this.heurs = heurs;
	}

	public void create_data(String nom, String prenom, int age, int date, int heurs) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO `montention`(`nom` , `prenom`,`age`,`date`,`heurs`) VALUES (?,?,?,?,?)";
			ps = con.conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(5, heurs);
			ps.executeUpdate();
			System.out.println(" \n employee Ajoute Avec Succes ");
		} catch (Exception e1) {
			System.out.print(e1);
		}

	}

	// select
	public void read_data() throws SQLException {
		// First f = new First();
		con.Connect();
		con.stat = con.conn.createStatement();
		con.rs = con.stat.executeQuery("SELECT * FROM `montention` ");
		while (con.rs.next()) {
			double value = con.rs.getDouble("heurs") * SALAIRE_HORAIRE;
			System.out.println(" -> ID:  " + "\t" + con.rs.getInt("id") + "\n \t nom: " + con.rs.getString("nom")
					+ " \n \t prenom " + con.rs.getString("prenom") + " \n \t age " + con.rs.getInt("age")
					+ " \n \t date " + con.rs.getInt("date") + " \n \t gagne  " + value + "3DH");
		}
	}

	public void update_data(int id, String nom, String prenom, int age, int date, double heurs) {
		// First f = new First();
		con.Connect();

		PreparedStatement ps = null;

		try {

			String query = "UPDATE `montention` SET `nom`=?,`prenom`=?,`age`=?,`date`=?,`heurs`=?  WHERE `id`=?";
			ps = con.conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(4, heurs);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");
		} catch (Exception e) {

		}
	}
	public void RemoveEmployee(int id) throws SQLException {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM `montention` WHERE id=?";
			ps = con.conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("the data deleted sucssesfuly !!!!!!");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}

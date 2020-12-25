package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Vendeur extends Employe {

	static Conection con = new Conection();
	private final static double pourcentage = 0.2;
	private final static int Bonus = 1500;

	public Vendeur(String nom, String prenom, int age, String date, double getChiffreAffaire) {
		super(nom, prenom, age, date, getChiffreAffaire);
		// TODO Auto-generated constructor stub
	}

	public Vendeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create_data(String nom, String prenom, int age, int date, double chiffreAffaire) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO `vendeurs`(`nom` , `prenom`,`age`,`date`,`chiffreAffaire`) VALUES (?,?,?,?,?)";
			ps = con.conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(5, chiffreAffaire);
			ps.executeUpdate();
			System.out.println(" \n employee Ajoute Avec Succes ");
		} catch (Exception e1) {
			System.out.print(e1);
		}

	}

	// select
	public static void read_data() throws SQLException {
		// First f = new First();
		con.Connect();
		con.stat = con.conn.createStatement();
		con.rs = con.stat.executeQuery("SELECT * FROM `vendeurs` ");
		while (con.rs.next()) {
			double value = pourcentage * con.rs.getDouble("chiffreAffaire") + Bonus;
			System.out.println(" -> ID:  " + "\t" + con.rs.getInt("id") + "\n \t nom: " + con.rs.getString("nom")
					+ " \n \t prenom " + con.rs.getString("prenom") + " \n \t age " + con.rs.getInt("age")
					+ " \n \t date " + con.rs.getInt("date") + " \n \t chiffreAffaire " + value);
		}
	}

	public void update_data(int id, String nom, String prenom, int age, int date, double chiffreAffaire) {
		// First f = new First();
		con.Connect();

		PreparedStatement ps = null;

		try {

			String query = "UPDATE `vendeurs` SET `nom`=?,`prenom`=?,`age`=?,`date`=?,`chiffreAffaire`=?  WHERE `id`=?";
			ps = con.conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(4, chiffreAffaire);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");
		} catch (Exception e) {

		}
	}

	public void RemoveEmployee(int id) throws SQLException {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM `vendeurs` WHERE id=?";
			ps = con.conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("the data deleted sucssesfuly !!!!!!");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}

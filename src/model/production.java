package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class production extends Employe {
	private int nomber_Pr;
	private static int bouns = 5;

	public production() {
		super();
		// TODO Auto-generated constructor stub
	}

	public production(String nom, String prenom, int age, String date, double chiffreAffaire, int nomber_Pr) {
		super(nom, prenom, age, date, chiffreAffaire);
		// TODO Auto-generated constructor stub
		this.setNomber_Pr(nomber_Pr);
	}

	public void create_data(String nom, String prenom, int age, int date, int nomber_Pr) {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO `production`(`nom` , `prenom`,`age`,`date`,`nomber_Pr`) VALUES (?,?,?,?,?)";
			ps = con.conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(5, nomber_Pr);
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
		con.rs = con.stat.executeQuery("SELECT * FROM `production` ");
		while (con.rs.next()) {
			double value = con.rs.getDouble("nomber_Pr") * bouns;
			System.out.println(" -> ID:  " + "\t" + con.rs.getInt("id") + "\n \t nom: " + con.rs.getString("nom")
					+ " \n \t prenom " + con.rs.getString("prenom") + " \n \t age " + con.rs.getInt("age")
					+ " \n \t date " + con.rs.getInt("date") + " \n \t nomber_Pr " + value);
		}
	}
	public void update_data(int id,String nom, String prenom, int age, int date, double nomber_Pr) {
		//First f = new First();
		con.Connect();
		
		PreparedStatement ps = null;
		
		try {
			
			String query = "UPDATE `production` SET `nom`=?,`prenom`=?,`age`=?,`date`=?,`nomber_Pr`=?  WHERE `id`=?";
			ps=con.conn.prepareStatement(query);
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setInt(3, age);
			ps.setInt(4, date);
			ps.setDouble(4,nomber_Pr);
			ps.executeUpdate();
			System.out.println(" \t modification avec succes");
		}catch (Exception e){
			
		}
		
	}
	public void RemoveEmployee(int id) throws SQLException {
		con.Connect();
		PreparedStatement ps = null;
		try {
			String query = "DELETE FROM `production` WHERE id=?";
			ps = con.conn.prepareStatement(query);
			ps.setInt(1,id);
			ps.executeUpdate();
			System.out.println("the data deleted sucssesfuly !!!!!!");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	public int getNomber_Pr() {
		return nomber_Pr;
	}

	public void setNomber_Pr(int nomber_Pr) {
		this.nomber_Pr = nomber_Pr;
	}

}

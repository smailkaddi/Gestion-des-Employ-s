package model;

import java.util.Scanner;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) throws SQLException {
		Vendeur vendeur = new Vendeur();
		production production = new production();
		Representant Representant = new Representant();
		Manutentionnaire Manutentionnaire = new Manutentionnaire();

		Scanner sc = new Scanner(System.in);
		Conection con = new Conection();
		con.Connect();
		String nom = "";
		String prenom = "";
		int heurs;
		int age;
		int date;
		String type = "";
		double chiffreAffaire = 0;
		int nomber_Pr = 0;
		int id = 0;

		System.out.println(" 1--gestion Employee");
		String method = sc.next();
		switch (method) {
		case "1":
			// add
			System.out.println("1 ---> add Employee");
			System.out.println("2 ---->Afficher Employee");
			System.out.println("3 ---> Modifier Employee");
			System.out.println("4 ---> Suppression Employee");
			String method2 = sc.next();

			switch (method2) {
			case "1":
				System.out.println("1 ---> add Employee");
				System.out.println(" Nom Employee");
				nom = sc.next();
				System.out.println(" prenom Employee");
				prenom = sc.next();
				System.out.println(" age Employee");
				age = sc.nextInt();
				System.out.println(" date Employee");
				date = sc.nextInt();
				System.out.println(" type Employee");
				System.out.println("1---> Vendeur");
				System.out.println("2--> Representant ");
				System.out.println("3--> Production");
				System.out.println("4--> Manutentionnaire");
				type = sc.next();
				switch (type) {
				case "1":
					System.out.println(" entre chiffreAffaire");
					chiffreAffaire = sc.nextInt();
					vendeur.create_data(nom, prenom, age, date, chiffreAffaire);

					break;
				case "2":
					System.out.println(" entre chiffreAffaire");
					chiffreAffaire = sc.nextInt();
					Representant.create_data(nom, prenom, age, date, chiffreAffaire);

					break;
				case "3":
					System.out.println(" entre nomber de proudui");
					nomber_Pr = sc.nextInt();
					production.create_data(nom, prenom, age, date, nomber_Pr);

					break;
				case "4":
					System.out.println(" entre chiffreAffaire");
					heurs = sc.nextInt();
					Manutentionnaire.create_data(nom, prenom, age, date, heurs);
					break;
				default:
					break;
				}
				break;
			case "2":

				// select
				System.out.println(
						" Afficher Vendeur  : 1 \n Afficher Representant : 2 \n Afficher Production   : 3 \n Afficher Manutentionnaire   : 4");
				String methodafich = sc.next();
				switch (methodafich) {
				case "1":
					// 1
					System.out.println("\n \t -----------------" + "\n \t Les Vendeurs  " + "\n \t ----------------- ");
					Vendeur.read_data();
					break;
				case "2":
					// 2
					System.out.println(
							"\n \t ------------------" + "\n \t Les Representant " + "\n \t  ------------------ ");
					Representant.read_data();
					break;
				case "3":
					// 2
					System.out.println(
							"\n \t ------------------" + "\n \t Les Production " + "\n \t  ------------------ ");
					production.read_data();

					break;
				case "4":
					// 3
					System.out.println(
							"\n \t ------------------" + "\n \t Les Manutentionnaire " + "\n \t ------------------ ");
					Manutentionnaire.read_data();
					break;
				default:

				}
				break;
			case "3":

				System.out.println(
						" update Vendeur  : 1 \n update Representant : 2 \n update Production   : 3 \n update Manutentionnaire   : 4");
				String method5 = sc.next();
				switch (method5) {

				case "1":
					Vendeur.read_data();
					System.out.println("\n--------------------------------");
					System.out.println(" ID pour Modifier : \n");
					id = sc.nextInt();
					System.out.println(" Nom Vendeur");
					nom = sc.next();
					System.out.println(" prenom Vendeur");
					prenom = sc.next();
					System.out.println(" age Vendeur");
					age = sc.nextInt();
					System.out.println(" date Vendeur");
					date = sc.nextInt();
					System.out.println("  chiffreAffaire");
					chiffreAffaire = sc.nextInt();
					vendeur.update_data(id, nom, prenom, age, date, chiffreAffaire);
					break;
				case "2":
					Representant.read_data();
					System.out.println("\n--------------Representant------------------");
					System.out.println(" ID pour Modifier : \n");
					id = sc.nextInt();
					System.out.println(" Nom Representant");
					nom = sc.next();
					System.out.println(" prenom Representant");
					prenom = sc.next();
					System.out.println(" age Representant");
					age = sc.nextInt();
					System.out.println(" date Representant");
					date = sc.nextInt();
					System.out.println("  chiffreAffaire");
					chiffreAffaire = sc.nextInt();
					Representant.update_data(id, nom, prenom, age, date, chiffreAffaire);
					break;
				case "3":
					production.read_data();
					System.out.println("\n--------------Production-----------------");
					System.out.println(" ID pour Modifier : \n");
					id = sc.nextInt();
					System.out.println(" Nom production");
					nom = sc.next();
					System.out.println(" prenom production");
					prenom = sc.next();
					System.out.println(" age production");
					age = sc.nextInt();
					System.out.println(" date production");
					date = sc.nextInt();
					System.out.println("  nomber_Pr");
					nomber_Pr = sc.nextInt();
					production.update_data(id, nom, prenom, age, date, nomber_Pr);
					break;
				case "4":

					Manutentionnaire.read_data();
					System.out.println("\n-----------Manutentionnaire---------------");
					System.out.println(" ID pour Modifier  : \n");
					id = sc.nextInt();
					System.out.println(" Nom Manutentionnaire");
					nom = sc.next();
					System.out.println(" prenom VManutentionnaireendeur");
					prenom = sc.next();
					System.out.println(" age Manutentionnaire");
					age = sc.nextInt();
					System.out.println(" date Manutentionnaire");
					date = sc.nextInt();
					System.out.println(" chiffreAffaire");
					heurs = sc.nextInt();
					Manutentionnaire.update_data(id, nom, prenom, age, date, heurs);
					break;

				default:
					break;
				}
			case "4":
				System.out.println(
						" SUP Vendeur  : 1 \n SUP Representant : 2 \n SUP Production   : 3 \n SUP Manutentionnaire   : 4");
				String method6 = sc.next();

				switch (method6) {
				case "1":
					Vendeur.read_data();
					System.out.println("\n--------------------------------");
					System.out.println(" ID pour Suprem Vendeur : \n");
					id = sc.nextInt();
					vendeur.RemoveEmployee(id);
					break;
				case "2":
					Representant.read_data();
					System.out.println("\n--------------------------------");
					System.out.println(" ID pour Suprem Representant : \n");
					id = sc.nextInt();
					Representant.RemoveEmployee(id);
					

					break;
				case "3":
					production.read_data();
					System.out.println("\n--------------------------------");
					System.out.println(" ID pour Suprem Production : \n");
					id = sc.nextInt();
					production.RemoveEmployee(id);

					break;
				case "4":
					
					Manutentionnaire.read_data();
					System.out.println("\n--------------------------------");
					System.out.println(" ID pour Suprem Manutentionnaire : \n");
					id = sc.nextInt();
					Manutentionnaire.RemoveEmployee(id);
					break;

				default:
					break;
				}

				break;
			default:
				break;
			}

		}
	}
}

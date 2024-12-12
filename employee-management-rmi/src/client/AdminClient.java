package client;

import service.RMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AdminClient {
    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RMIInterface stub = (RMIInterface) registry.lookup("EmployeeService");

            // Authentification de l'administrateur
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Interface Administrateur ===");
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();
            System.out.print("Entrez votre mot de passe : ");
            String password = scanner.nextLine();

            if (!stub.login(username, password)) {
                System.out.println("Échec de la connexion. Vérifiez vos identifiants.");
                return;
            }

            System.out.println("Connexion réussie !");
            while (true) {
                System.out.println("\n=== Menu Administrateur ===");
                System.out.println("1. Ajouter un employé");
                System.out.println("2. Modifier un employé");
                System.out.println("3. Supprimer un employé");
                System.out.println("4. Afficher la liste des employés");
                System.out.println("5. Quitter");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne

                switch (choice) {
                    case 1: // Ajouter un employé
                        System.out.print("Nom : ");
                        String name = scanner.nextLine();
                        System.out.print("Prénom : ");
                        String surname = scanner.nextLine();
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        System.out.print("CIN : ");
                        String cin = scanner.nextLine();
                        System.out.print("Adresse : ");
                        String address = scanner.nextLine();
                        System.out.print("Téléphone : ");
                        String phone = scanner.nextLine();
                        stub.addEmployee(name, surname, email, cin, address, phone);
                        System.out.println("Employé ajouté avec succès !");
                        break;

                    case 2: // Modifier un employé
                        System.out.print("CIN de l'employé à modifier : ");
                        String updateCin = scanner.nextLine();
                        System.out.print("Nouveau nom : ");
                        String newName = scanner.nextLine();
                        System.out.print("Nouveau prénom : ");
                        String newSurname = scanner.nextLine();
                        System.out.print("Nouveau email : ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Nouvelle adresse : ");
                        String newAddress = scanner.nextLine();
                        System.out.print("Nouveau téléphone : ");
                        String newPhone = scanner.nextLine();
                        stub.updateEmployee(updateCin, newName, newSurname, newEmail, newAddress, newPhone);
                        System.out.println("Employé modifié avec succès !");
                        break;

                    case 3: // Supprimer un employé
                        System.out.print("CIN de l'employé à supprimer : ");
                        String deleteCin = scanner.nextLine();
                        stub.deleteEmployee(deleteCin);
                        System.out.println("Employé supprimé avec succès !");
                        break;

                    case 4: // Afficher tous les employés
                        System.out.println("Liste des employés :");
                        for (String employee : stub.getAllEmployees()) {
                            System.out.println(employee);
                        }
                        break;

                    case 5: // Quitter
                        System.out.println("Déconnexion...");
                        return;

                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

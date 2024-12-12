package client;

import service.RMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class EmployeeClient {
    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RMIInterface stub = (RMIInterface) registry.lookup("EmployeeService");

            // Authentification de l'employé
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Interface Employé ===");
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();
            System.out.print("Entrez votre mot de passe : ");
            String password = scanner.nextLine();

            if (!stub.login(username, password)) {
                System.out.println("Échec de la connexion. Vérifiez vos identifiants.");
                return;
            }

            System.out.println("Connexion réussie !");
            System.out.print("Entrez votre CIN pour consulter vos informations : ");
            String cin = scanner.nextLine();

            String details = stub.getEmployeeDetails(cin);
            System.out.println("Vos informations :");
            System.out.println(details);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

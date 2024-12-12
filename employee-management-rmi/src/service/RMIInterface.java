package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {
    // Méthode pour l'authentification
    boolean login(String username, String password) throws RemoteException;

    // Méthodes pour l'administrateur
    void addEmployee(String name, String surname, String email, String cin, String address, String phone) throws RemoteException;
    void updateEmployee(String cin, String name, String surname, String email, String address, String phone) throws RemoteException;
    void deleteEmployee(String cin) throws RemoteException;
    List<String> getAllEmployees() throws RemoteException;

    // Méthode pour l'employé
    String getEmployeeDetails(String cin) throws RemoteException;
}

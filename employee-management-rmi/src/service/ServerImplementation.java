package service;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class ServerImplementation extends UnicastRemoteObject implements RMIInterface {

    private List<Employee> employees;

    public ServerImplementation() throws RemoteException {
        super();
        this.employees = new ArrayList<>();
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        // Vérification simple des identifiants
        if ((username.equals("admin") && password.equals("admin123")) ||
            (username.equals("employee") && password.equals("emp123"))) {
            return true;
        }
        return false;
    }

    @Override
    public void addEmployee(String name, String surname, String email, String cin, String address, String phone) throws RemoteException {
        Employee employee = new Employee(name, surname, email, cin, address, phone);
        employees.add(employee);
        System.out.println("Employé ajouté : " + employee);
    }

    @Override
    public void updateEmployee(String cin, String name, String surname, String email, String address, String phone) throws RemoteException {
        for (Employee employee : employees) {
            if (employee.getCin().equals(cin)) {
                employee.setName(name);
                employee.setSurname(surname);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setPhone(phone);
                System.out.println("Employé mis à jour : " + employee);
                return;
            }
        }
    }

    @Override
    public void deleteEmployee(String cin) throws RemoteException {
        employees.removeIf(employee -> employee.getCin().equals(cin));
        System.out.println("Employé avec CIN " + cin + " supprimé.");
    }

    @Override
    public List<String> getAllEmployees() throws RemoteException {
        List<String> result = new ArrayList<>();
        for (Employee employee : employees) {
            result.add(employee.toString());
        }
        return result;
    }

    @Override
    public String getEmployeeDetails(String cin) throws RemoteException {
        for (Employee employee : employees) {
            if (employee.getCin().equals(cin)) {
                return employee.toString();
            }
        }
        return "Aucun employé trouvé avec ce CIN.";
    }
}

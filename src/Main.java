import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[10];
        employees[0] = new AdminEmployee("Admin", "Admin", "Administrator", 5000);
        int nrAngajati = 1;
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Vezi toti angajatii");
            System.out.println("2. Adauga un angajat");
            System.out.println("3. Editeaza un angajat");
            System.out.println("4. Sterge un angajat");
            System.out.println("5. Iesire");
            System.out.print("Alegeti o optiune: ");


            int optiune = Integer.parseInt(scanner.nextLine());


            switch (optiune) {
                case 1:
                    ShowEmployees.ShowAllEmployees(employees, nrAngajati);
                    break;
                case 2:
                    AddEmployee.main(args);
                    break;
                case 3:
                    EditEmployee.editEmployee(employees, nrAngajati);
                    break;
                case 4:
                    DeleteEmployee.deleteEmployee(employees, nrAngajati);
                    nrAngajati--;
                    break;
                case 5:
                    System.out.println("Programul s-a incheiat.");
                    return;
                default:
                    System.out.println("Optiune invalida. Va rugam sa alegeti din nou.");
            }
        }
    }
}
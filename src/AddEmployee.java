import java.util.Scanner;

class Employee {
    String nume;
    String prenume;
    String functie;
    double salariu;

    public Employee(String nume, String prenume, String functie, double salariu) {
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
        this.salariu = salariu;
    }

    public String getFullName() {
        return nume + " " + prenume;
    }

    @Override
    public String toString() {
        return "Nume: " + getFullName() + ", Functia: " + functie + ", Salariul: " + salariu;
    }
}



public class AddEmployee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[10];

        while (true) {
            System.out.print("Enter nume: ");
            String nume = scanner.nextLine();

            if (nume.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter prenume: ");
            String prenume = scanner.nextLine();

            System.out.print("Enter functie: ");
            String functie = scanner.nextLine();

            System.out.print("Enter salariu: ");
            double salariu = Double.parseDouble(scanner.nextLine());

            Employee newEmployee = new Employee(nume, prenume, functie, salariu);

            employees = addEmployeeToArray(employees, newEmployee);

            System.out.println("Employee '" + newEmployee.getFullName() + "' a fost adaugat cu succes!");
            System.out.println("1. Continua inregistrarea de employee-uri");
            System.out.println("2. Inapoi la meniu principal");
            System.out.print("Alegeti o optiune: ");
            int option = Integer.parseInt(scanner.nextLine());
            if (option == 2) {
                break;
            }
        }

        scanner.close();
    }

    private static Employee[] addEmployeeToArray(Employee[] array, Employee employee) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = employee;
                break;
            }
        }
        return array;
    }
}



class EditEmployee {

    public static void editEmployee(Employee[] employees, int nrAngajati) {
        Scanner scanner = new Scanner(System.in);

        displayEmployees(employees);

        System.out.print("\nIntrodu numarul de identificare: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= nrAngajati || employees[index] == null) {
            System.out.println("Angajatul dat nu exista");
            scanner.close();
            return;
        }

        // Prompt pentru noile detalii
        System.out.print("Enter nume: ");
        String nume = scanner.nextLine();

        System.out.print("Enter prenume: ");
        String prenume = scanner.nextLine();

        System.out.print("Enter functie: ");
        String functie = scanner.nextLine();

        System.out.print("Enter salariu: ");
        double salariu = Double.parseDouble(scanner.nextLine());

        employees[index].nume = nume;
        employees[index].prenume = prenume;
        employees[index].functie = functie;
        employees[index].salariu = salariu;

        System.out.println("Employee " + index + " a fost editat cu succes!");

        System.out.println("1. Inapoi la meniu principal");
        System.out.print("Alegeti o optiune: ");
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
            scanner.close();
            return;
        }

        scanner.close();
    }

    public static void displayEmployees(Employee[] employees) {
        System.out.println("Angajati curenti:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(i + ": " + employees[i]);
            }
        }
    }
}
class DeleteEmployee {

    public static void deleteEmployee(Employee[] employees, int nrAngajati) {
        Scanner scanner = new Scanner(System.in);

        displayEmployees(employees);

        System.out.print("\nIntrodu numarul de identificare: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= nrAngajati || employees[index] == null) {
            System.out.println("Angajatul dat nu exista");
            scanner.close();
            return;
        }

        for (int i = index; i < nrAngajati - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[nrAngajati - 1] = null;
        System.out.println("Employee" + index + " a fost sters cu succes!");

        System.out.println("1. Inapoi la meniu principal");
        System.out.print("Alegeti o optiune: ");
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
            scanner.close();
            return;
        }

        scanner.close();
    }

    public static void displayEmployees(Employee[] employees) {
        System.out.println("Angajati curenti:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(i + ": " + employees[i]);
            }
        }
    }
}

class ShowEmployees {

    public static void ShowAllEmployees(Employee[] employees, int nrAngajati) {
        displayEmployees(employees);

        System.out.println("1. Inapoi la meniu principal");
        System.out.print("Alegeti o optiune: ");
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        if (option == 1) {
            scanner.close();
            return;
        }

        scanner.close();
    }

    public static void displayEmployees(Employee[] employees) {
        System.out.println("Angajati curenti:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
}

class AdminEmployee extends Employee {
    public AdminEmployee(String nume, String prenume, String functie, double salariu) {
        super(nume, prenume, functie, salariu);
    }
}
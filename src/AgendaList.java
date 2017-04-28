import java.util.Scanner;
import java.util.*;
/**
 * Created by Mihnea on 28.04.2017.
 */
public class AgendaList {

    static List<Person> agendaPersoane = new ArrayList<>();

    public static void main(String[] args) {
        runProgram();
    }

    public static void Meniu() {
//        System.out.println("\n");
        System.out.print("1 - Afisare;      ");
        System.out.print(" 2 - Adaugare;      ");
        System.out.print(" 3 - Modificare;      ");
        System.out.print(" 4 - Stergere;      ");
        System.out.print(" 5 - Cautare;      ");
        System.out.println(" 7 - Terminare;      \n");
    }

    public static void runProgram() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Meniu();
            int optiune = scanner.nextInt();
            if (optiune == 7) {
                break;
            } else if (optiune == 1) {
                afisare();
                System.out.println("\n");
            } else if (optiune == 2) {
                adaugare();
                System.out.println("");
            } else if (optiune == 3) {
                System.out.println("What do you want to modify?");
                System.out.println("Type 1 for name. Type 2 for phone.");
                scanner = new Scanner(System.in);
                int x = scanner.nextInt();
                if (x == 1) {

                    modificareNume();
                } else {
                    modificarePhone();
                    System.out.println("");
                }
            } else if (optiune == 4) {
                stergere();
                System.out.println("");
            } else if (optiune == 5) {
                searchCore();
                System.out.println("");
            }
        }
    }

    public static void afisare() {

        for (Person x : agendaPersoane) {
//            agendaPersoane.add(x);
            if (x.getName() != null && x.getPhone() != null) {

                System.out.print("Nume: " + x.getName().trim() + ", ");
                System.out.println("Telefon: " + x.getPhone().trim() + ". ");

            }
        }
    }

    public static void adaugare() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a new person name: ");
        String newEntryInAgenda = scanner.nextLine();
        System.out.println("Please enter phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Person p = new Person(newEntryInAgenda, newPhoneNumber);


        if (newEntryInAgenda != null && newPhoneNumber != null) {
            if (!agendaPersoane.contains(newEntryInAgenda)) {
                p.setName(newEntryInAgenda.trim());
                p.setPhone(newPhoneNumber.trim());
                agendaPersoane.add(p);

            } else System.out.println("Name already in agenda.");
        }

    }

    public static void modificareNume() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your current name: ");
        String vechiulNume = scanner.nextLine();
        System.out.println("Please enter your new name: ");
        String noulNume = scanner.nextLine();

        Person gasit = cautare(vechiulNume);
        if (gasit == null) {
            System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
        } else {
            gasit.setName(noulNume);
//            System.out.println("Enter the new name: ");
//            String newName = scanner.nextLine();
//            Person p1 = new Person()
//            for (int i = 0; i < agendaPersoane.length; i++) {
//                if (personNameInAgenda.equals(agendaPersoane[i])) {
//                    agendaPersoane[i] = newName;
        }
    }

    public static void modificarePhone() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the person's name: ");
        String vn = scanner.nextLine();
        System.out.println();
        System.out.print("Please enter phone number: ");
        String newPhoneNumber = scanner.nextLine();


        Scanner noulNumar = new Scanner(System.in);
        Person gasit = cautare(vn);
        if (gasit == null) {
            System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
        } else {
            gasit.setPhone(newPhoneNumber);

        }
    }

    public static void searchCore() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name to search for: ");
        String name = sc.nextLine();


        System.out.println("1 - Find first occurence \n");
        System.out.println("2 - Find all occurences \n");
        int optiune = sc.nextInt();
        if (optiune == 1) {
            if (cautare(name) == null) {
                System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
            } else {
                for (Person x : agendaPersoane) {
                    System.out.println("The following results were found: ");
                    System.out.println("Nume: "+x.getName() + ", Telefon: "+x.getPhone());
                }
            }
            if (optiune == 2) {
                int howManyWereFound = cautareAll(name);

                if (howManyWereFound != 0) {
                    System.out.println(name + " appears " + howManyWereFound + " times.");
                } else {
                    System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
                }
            }
        }
    }

    public static Person cautare(String name) {

        for (Person x : agendaPersoane) {
//            if (name.equals(x.getName().trim())) return x;
            if(x.getName().contains(name.trim())) return x;
        }
        return null;

    }

    public static int cautareAll(String name) {
        int nrNames = 0;

        for (Person x : agendaPersoane) {
//            if (name.equals(x.getName().trim())) {
                if(x.getName().contains(name.trim())) {
                nrNames++;
            }
        }

//        System.out.println(name + " appears " + nrNames + " times.");

        return nrNames;
    }

    private static void stergere() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name you want to delete: ");
        String name = scanner.nextLine();
        if (cautare(name) == null) {
            System.out.println("There is no entry in the agenda with the given name.");

        } else {
            for (Person x : agendaPersoane) {
                try {
                    if (name.equals(x.getName())) {
                        x.name = null;
                        x.phone = null;
                    }
                } catch (NullPointerException e) {
                    System.out.println();
                }
            }
        }
    }
}


import java.util.Scanner;

/**
 * Created by Mihnea on 02.04.2017.
 */
public class Agenda {

    static Person[] agendaPersoane = new Person[2]; //e variabila GLOBALA acum. In metode, se numeste LOCALE.

    public static void main(String[] args) {
//        agendaPersoane[0] = "Mihnea";
//        agendaPersoane[1] = "Razvan";
//        agendaPersoane[2] = "David";
//        agendaPersoane[3] = "Andra";
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

        for (int i = 0; i < agendaPersoane.length; i++) {
            Person temp = agendaPersoane[i];
            if (temp != null) {

                System.out.println("Numele: " + temp.getName() + ", ");
                System.out.println("Telefon: " + temp.getPhone() + ", ");

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

        for (int i = 0; i < agendaPersoane.length; i++) {

            if (agendaPersoane[i] == null) {
                agendaPersoane[i] = p;
                break;
            }

        }
    }

    public static void modificareNume() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your current name: ");
        String vechiulNume = scanner.nextLine();
        System.out.println("Please enter your new name: ");
        String noulNume = scanner.nextLine();

        int gasit = cautare(vechiulNume);
        if (gasit == -1) {
            System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
        } else {
            Person temp = agendaPersoane[gasit];
            temp.setName(noulNume);
            agendaPersoane[gasit] = temp;
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
        System.out.println("Please enter a new person name: ");
        String vn = scanner.nextLine();
        System.out.println("Please enter phone number: ");
        String newPhoneNumber = scanner.nextLine();


        Scanner noulNumar = new Scanner(System.in);
        int gasit = cautare(vn);
        if (gasit == -1) {
            System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
        } else {
            Person temp = agendaPersoane[gasit];
            temp.setPhone(newPhoneNumber);
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
            if (cautare(name) == -1) {
                System.out.println("There is no entry in the agenda with the given name ! Sorry :( . Try again.");
            } else {
                System.out.println(name + " was found !");
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

    public static int cautare(String name) {

        for (int i = 0; i < agendaPersoane.length; i++) {
            if (name.equals(agendaPersoane[i].getName())) return i;
        }
        return -1;

    }

    public static int cautareAll(String name) {
        int nrNames = 0;

        for (int i = 0; i < agendaPersoane.length; i++) {
            if (name.equals(agendaPersoane[i].getName())) {
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
        if (cautare(name) == -1) {
            System.out.println("There is no entry in the agenda with the given name.");

        } else {
            for (int i = 0; i < agendaPersoane.length; i++) {
                try {
                    if (name.equals(agendaPersoane[i].getName())) {
                        agendaPersoane[i].name = null;
                        agendaPersoane[i].phone = null;
                    }
                } catch (NullPointerException e) {
                    System.out.println();
                }
            }
        }
    }
}
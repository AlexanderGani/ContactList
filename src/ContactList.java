/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> contacts;
    // TODO: Write a Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        Scanner read = new Scanner(System.in);
        System.out.println("Select a type of contact to add:\n" + "1. Student\n" + "2. Teacher");
        if(read.nextInt() == 1) {
            System.out.println("Please fill in the following information");
            System.out.println("First Name: ");
            read.nextLine();
            String firstName = read.nextLine();
            System.out.println("Last Name: ");
            String lastName = read.nextLine();
            System.out.println("Phone Number: ");
            String phoneNumber = read.nextLine();
            System.out.println("Grade: ");
            int grade = read.nextInt();
            read.nextLine();
            Student s = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(s);
        }
        else if(read.nextInt() == 2) {
            System.out.println("Please fill in the following information");
            System.out.println("First Name: ");
            String firstName = read.nextLine();
            System.out.println("Last Name: ");
            String lastName = read.nextLine();
            System.out.println("Phone Number: ");
            String phoneNumber = read.nextLine();
            System.out.println("Subject: ");
            String subject = read.nextLine();
            Teacher s = new Teacher(firstName, lastName, phoneNumber, subject);
            contacts.add(s);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).toString());
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        if (sortBy == 0) {
            for (int i = 0; i < contacts.size(); i++) {
                String current = contacts.get(i).getFirstName();
                for (int j = i + 1; j < contacts.size(); j++) {
                    String next = contacts.get(j).getFirstName();
                    if (current.compareTo(next) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(i));
                        contacts.set(i, temp);
                    }
                }
                }
            }
        else if (sortBy == 1) {
            for (int i = 0; i < contacts.size(); i++) {
                String current = contacts.get(i).getLastName();
                for (int j = i + 1; j < contacts.size(); j++) {
                    String next = contacts.get(j).getLastName();
                    if (current.compareTo(next) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(i));
                        contacts.set(i, temp);
                    }
                }
            }
        }
        else if (sortBy == 2) {
            for (int i = 0; i < contacts.size(); i++) {
                String current = contacts.get(i).getPhoneNumber();
                for (int j = i + 1; j < contacts.size(); j++) {
                    String next = contacts.get(j).getPhoneNumber();
                    if (current.compareTo(next) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(i));
                        contacts.set(i, temp);
                    }
                }
            }
        }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            String name = contacts.get(i).getFirstName();
            if (firstName.compareTo(name) == 0) {
                return contacts.get(i);
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            String name = contacts.get(i).getLastName();
            if (lastName.compareTo(name) == 0) {
                return contacts.get(i);
            }
        }
        return null;
    }
    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            String number = contacts.get(i).getPhoneNumber();
            if (phoneNumber.compareTo(number) == 0) {
                return contacts.get(i);
            }
        }
        return null;
    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i) instanceof Student) {
                System.out.println(contacts.get(i).toString());
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        int option;
        Scanner read = new Scanner(System.in);
        option = read.nextInt();
        if (option == 0) {
            System.exit(1);
        }
        while(option != 0) {
            if (option == 1) {
               addContact();
               run();
            }
            else if (option == 2) {
                sort(0);
                printContacts();
                run();
            }
            else if (option == 3) {
                sort(1);
                printContacts();
                run();
            }
            else if (option == 4) {
                sort(2);
                printContacts();
                run();
            }
            else if (option == 5) {
                listStudents();
                run();
            }
            else if (option == 6) {
                System.out.println("Enter a name: ");
                read.nextLine();
                String fName = read.nextLine();
                System.out.println(searchByFirstName(fName));
                run();
            }
            else if (option == 7) {
                System.out.println("Enter a name: ");
                read.nextLine();
                String lName = read.nextLine();
                searchByLastName(lName);
                run();
            }
            else if (option == 8) {
                System.out.println("Enter a phone number: ");
                read.nextLine();
                String number = read.nextLine();
                System.out.println(searchByPhoneNumber(number));
                run();
            }
        }

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}

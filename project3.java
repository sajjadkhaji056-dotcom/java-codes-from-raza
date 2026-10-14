//Hospital Management : A hospital experiences long queues because appointments are recorded manually. 
//Doctors cannot easily access  patient history or appointment schedules.
// Develop a patient management system that automates registration, appointment  booking, billing, and patient record management. 
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}

class Appointment {
    int patientId;
    String drName;
    String date;

    public Appointment(int patientId, String drName, String date) {
        this.patientId = patientId;
        this.drName = drName;
        this.date = date;
    }
}

public class project3 {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int patientIdCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n------< Welcome to Al Shifa, The Hospital of Cure  >------");
            System.out.println("1. Register a new Patient");
            System.out.println("2. Book an Appointment");
            System.out.println("3. View Patient History");
            System.out.println("4. Exit");
            System.out.print("Choose an option from above : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    bookAppointment();
                    break;
                case 3:
                    viewPatientHistory();
                    break;
                case 4:
                    System.out.println("Exiting system");
                    System.out.println("Thanks for coming.");
                    return;
                default:
                    System.out.println("Invalid choice! Please try to enter from 1 to 4 only");
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Medical History/Disease: ");
        String disease = scanner.nextLine();

        Patient newPatient = new Patient(patientIdCounter++, name, age, disease);
        patients.add(newPatient);
        System.out.println("Patient registered successfully! \n Assigned Patient ID: " + newPatient.id);
    }

    private static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int pId = scanner.nextInt();
        scanner.nextLine();
      // If the patient ID is wrong, then this block will be executed...
        boolean found = false;
        for (Patient p : patients) {
            if (p.id == pId) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient ID not found! Please register the patient first.");
            return;
        }

        //If the patient is alrwady registered, then this block will be executed


        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Appointment newAppt = new Appointment(pId, doctor, date);
        appointments.add(newAppt);
        System.out.println("Congrats! The patient appointment has scheduled successfully.");
    }

    private static void viewPatientHistory() {

        System.out.print("Enter Patient ID for the histor : ");
        int pId = scanner.nextInt();

        boolean found = false;
        for (Patient p : patients) {
            if (p.id == pId) {
                found = true;
                System.out.println("\n--- Patient Record ---");
                System.out.println("ID: " + p.id);
                System.out.println("Name: " + p.name);
                System.out.println("Age: " + p.age);
                System.out.println("Medical History / Disease: " + p.disease);
                
                System.out.println("Appointments:");
                boolean hasAppt = false;
                for (Appointment a : appointments) {
                    if (a.patientId == pId) {
                        hasAppt = true;
                        System.out.println(" - Dr. " + a.drName + " on " + a.date);
                    }
                }
                if (!hasAppt) {
                    System.out.println(" - No appointments scheduled.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Patient with ID " + pId + " not found.");
        }
    }
}
//By KHAZI SAJJAD ALRAZVI
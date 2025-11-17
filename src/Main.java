import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Message> messages = new ArrayList<>();


        // BoardMessage
        messages.add(new BoardMessage("Dana", "Important update for class", new Date(), false, Priority.URGENT, "School"));
        messages.add(new BoardMessage("Yossi", "Meeting at 18:00 today", false, "Work"));

        // EmailMessage
        ArrayList<File> attach1 = new ArrayList<>();
        attach1.add(new File("report.pdf", "pdf"));

        messages.add(new EmailMessage("Noa", "Here is the project submission", new Date(), false, "Project Submission", attach1));
        messages.add(new EmailMessage("Rina", "Don't forget tomorrow's deadline!", false, "Reminder"));

        // ChatMessage
        try {
            messages.add(new ChatMessage("Avi", "Hey, are you coming?", new Date(), false, "FriendsChat"));
            messages.add(new ChatMessage("Lior", "Good morning!", false, "FamilyRoom"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== Messaging System Menu =====");
            System.out.println("1. Add Message");
            System.out.println("2. Delete Message");
            System.out.println("3. Print All Messages");
            System.out.println("4. Count Messages Containing Words");
            System.out.println("5. Print Digital Messages Only");
            System.out.println("6. Search Messages by Sender");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Choose type to add: 1-Board, 2-Email, 3-Chat");
                    int t = sc.nextInt(); sc.nextLine();

                    if (t == 1) {
                        System.out.print("Sender: ");
                        String s = sc.nextLine();
                        System.out.print("Content: ");
                        String c = sc.nextLine();
                        System.out.print("Category: ");
                        String cat = sc.nextLine();

                        messages.add(new BoardMessage(s, c, false, cat));
                    }

                    else if (t == 2) {
                        System.out.print("Sender: ");
                        String s = sc.nextLine();
                        System.out.print("Content: ");
                        String c = sc.nextLine();
                        System.out.print("Subject: ");
                        String sub = sc.nextLine();

                        messages.add(new EmailMessage(s, c, false, sub));
                    }

                    else if (t == 3) {
                        System.out.print("Sender: ");
                        String s = sc.nextLine();
                        System.out.print("Content: ");
                        String c = sc.nextLine();
                        System.out.print("Chat room: ");
                        String room = sc.nextLine();

                        try {
                            messages.add(new ChatMessage(s, c, false, room));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 2:
                    System.out.println("Enter index to delete (0 - " + (messages.size() - 1) + "):");
                    int index = sc.nextInt();

                    if (index >= 0 && index < messages.size()) {
                        messages.remove(index);
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;

                case 3:
                    for (int i = 0; i < messages.size(); i++) {
                        System.out.println(i + ": " + messages.get(i));
                    }
                    break;

                case 4:
                    System.out.print("Enter words (separated by space): ");
                    String line = sc.nextLine();
                    String[] arr = line.split(" ");

                    ArrayList<String> words = new ArrayList<>();
                    for (String w : arr) words.add(w);

                    int count = 0;
                    for (Message m : messages) {
                        if (m.find(words)) count++;
                    }

                    System.out.println("Found: " + count);
                    break;

                case 5:
                    for (Message m : messages) {
                        if (m instanceof IDigital) {
                            System.out.println(m);
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter sender name: ");
                    String s = sc.nextLine();

                    for (Message m : messages) {
                        if (m.getSender().equalsIgnoreCase(s)) {
                            System.out.println(m);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
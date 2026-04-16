package org.apache.maven.archetypes.Library_management_hibernate;
import service.AdminService;
import service.MemberService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AdminService adminService = new AdminService();
        MemberService memberService = new MemberService();

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Member Login");
            System.out.println("3. New Member Registration");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    adminMenu(adminService, sc);
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int id = sc.nextInt();

                    if (memberService.login(id)) {
                        memberMenu(memberService, sc);
                    } else {
                        System.out.println("❌ Not a registered member!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    memberService.registerMember(mid, name, phone);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }

   
    static void adminMenu(AdminService admin, Scanner sc) {
        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Logout");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    admin.addBook(id, name, author, price);
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    admin.removeBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("New Author: ");
                    String uauthor = sc.nextLine();

                    System.out.print("New Price: ");
                    double uprice = sc.nextDouble();

                    admin.updateBook(uid, uname, uauthor, uprice);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    admin.searchBook(sc.nextInt());
                    break;

                case 5:
                    admin.showAllBooks();
                    break;

                case 6:
                	System.out.println("Thank you:), Exiting..");
                    return;
            }
        }
    }

    
    static void memberMenu(MemberService service, Scanner sc) {
        while (true) {
            System.out.println("\n--- MEMBER MENU ---");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. Search Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Logout");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    service.issueBook(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    service.returnBook(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    service.searchBook(sc.nextInt());
                    break;

                case 4:
                    service.viewAvailableBooks();
                    break;

                case 5:
                    return;
            }
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

 class LibraryManagementSystem {
    private ArrayList<Book> bookList;
    private Scanner scanner;

    public LibraryManagementSystem() {
        bookList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.run();
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. View Book List");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewBookList();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting Library Management System. Goodbye!");
    }

    private void viewBookList() {
        if (bookList.isEmpty()) {
            System.out.println("The library has no books.");
        } else {
            System.out.println("Book List:");
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println((i + 1) + ". " + bookList.get(i));
            }
        }
    }

    private void addBook() {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        bookList.add(book);
        System.out.println("Book added.");
    }

    private void removeBook() {
        if (bookList.isEmpty()) {
            System.out.println("The library has no books.");
            return;
        }
        System.out.print("Enter the number of the book to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (index > 0 && index <= bookList.size()) {
            bookList.remove(index - 1);
            System.out.println("Book removed.");
        } else {
            System.out.println("Invalid book number. Please try again.");
        }
    }

    private static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }
}


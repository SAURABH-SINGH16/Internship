import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Book {
    String title;
    String author;
    String ISBN;
    boolean availability;

    public Book(String title, String author, String ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return title + " by " + author + " | ISBN: " + ISBN + " | " +
                (availability ? "Available" : "Not Available");
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.ISBN.equals(ISBN));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

public class LibraryManagementSystemGUI extends JFrame {
    private Library library;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;

    public LibraryManagementSystemGUI() {
        library = new Library();
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // This is for GUI Layout
        setLayout(new BorderLayout());

        //This is for Book list
        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        add(new JScrollPane(bookList), BorderLayout.CENTER);

        //This is the Basic GUI Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book");
        JButton refreshButton = new JButton("Refresh List");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add book action
        addButton.addActionListener(e -> {
            JTextField titleField = new JTextField();
            JTextField authorField = new JTextField();
            JTextField isbnField = new JTextField();
            JCheckBox availableBox = new JCheckBox("Available");

            Object[] message = {
                    "Title:", titleField,
                    "Author:", authorField,
                    "ISBN:", isbnField,
                    availableBox
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Add Book", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                Book book = new Book(
                        titleField.getText(),
                        authorField.getText(),
                        isbnField.getText(),
                        availableBox.isSelected()
                );
                library.addBook(book);
                refreshBookList();
            }
        });

        // Remove book action
        removeButton.addActionListener(e -> {
            String isbn = JOptionPane.showInputDialog(this, "Enter ISBN of book to remove:");
            if (isbn != null && !isbn.trim().isEmpty()) {
                library.removeBook(isbn);
                refreshBookList();
            }
        });

        // Refresh book list
        refreshButton.addActionListener(e -> refreshBookList());

        setVisible(true);
    }

    private void refreshBookList() {
        bookListModel.clear();
        for (Book book : library.getBooks()) {
            bookListModel.addElement(book.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryManagementSystemGUI::new);
    }
}

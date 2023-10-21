
package com.mycompany.biblioteca; 
 
import java.io.IOException; 
import java.net.URL; 
import java.util.ResourceBundle; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.Initializable; 
import javafx.scene.control.TableColumn; 
import javafx.scene.control.TableView; 
 
public class BookController implements Initializable { 
 
    @FXML 
    private TableView<Book> table_books; 
    @FXML 
    private TableColumn<Book, Integer> idbook; 
    @FXML 
    private TableColumn<Book, String> title; 
    @FXML 
    private TableColumn<Book, String> author; 
    @FXML 
    private TableColumn<Book, String> gender; 
    @FXML 
    private TableColumn<Book, Integer> publicationyear; 
    @FXML 
    private TableColumn<Book, String> isbn; 
 
    private ObservableList<Book> bookList = FXCollections.observableArrayList(); 
 
    @Override 
    public void initialize(URL url, ResourceBundle rb) { 
        // Llenar la tabla con datos de ejemplo (reemplaza con tu lógica de obtención de datos) 
        bookList.add(new Book(1, "Título 1", "Autor 1", "Género 1", 2021, "ISBN-12345")); 
        bookList.add(new Book(2, "Título 2", "Autor 2", "Género 2", 2022, "ISBN-67890")); 
 
        table_books.setItems(bookList); 
    } 
 
    @FXML 
    private void On_Click_Exit(ActionEvent event) { 
        try { 
            App.setRoot("Library"); 
        } catch (IOException ex) { 
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
 
    @FXML 
    private void On_Click_Search(ActionEvent event) { 
        // Agrega tu lógica de búsqueda aquí 
    } 
 
    // Clase Book 
    public class Book { 
        private int id; 
        private String title; 
        private String author; 
        private String gender; 
        private int publicationYear; 
        private String isbn; 
 
        // Constructor 
        public Book(int id, String title, String author, String gender, int publicationYear, String isbn) { 
            this.id = id; 
            this.title = title; 
            this.author = author; 
            this.gender = gender; 
            this.publicationYear = publicationYear; 
            this.isbn = isbn; 
        } 
 
        // Getters 
        public int getId() { 
            return id; 
        } 
 
        public String getTitle() { 
            return title; 
        } 
 
        public String getAuthor() { 
            return author; 
        } 
 
        public String getGender() { 
            return gender; 
        } 
 
        public int getPublicationYear() { 
            return publicationYear; 
        } 
 
        public String getIsbn() { 
            return isbn; 
        } 
    } 
}
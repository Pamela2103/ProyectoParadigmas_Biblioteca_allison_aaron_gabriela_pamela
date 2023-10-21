package com.mycompany.biblioteca; 
 
import java.io.IOException; 
import java.net.URL; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ResourceBundle; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.Initializable; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.TextField; 
 
public class UpBook implements Initializable { 
 
    @FXML 
    private TextField txt_field1; 
    @FXML 
    private TextField txt_field2; 
    @FXML 
    private ChoiceBox<String> txt_choice_box; 
 
    private Connection connection; 
 
    public UpBook() { 
        CConexion cConexion = new CConexion(); 
        this.connection = cConexion.estableceConexion(); 
    } 
 
    @Override 
    public void initialize(URL url, ResourceBundle rb) { 
        ObservableList<String> options = FXCollections.observableArrayList( 
            "Literatura", "Novela", "Romance" 
        ); 
        txt_choice_box.setItems(options); 
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
    private void On_Click_Add(ActionEvent event) { 
        try { 
            String value1 = txt_field1.getText(); 
            String value2 = txt_field2.getText(); 
            String selectedOption = txt_choice_box.getValue(); 
 
            String sql = "INSERT INTO books (field1, field2, field_option) VALUES (?, ?, ?)"; 
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.setString(1, value1); 
            statement.setString(2, value2); 
            statement.setString(3, selectedOption); 
            statement.executeUpdate(); 
 
            txt_field1.clear(); 
            txt_field2.clear(); 
            txt_choice_box.setValue(null); 
 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
      public void insertBook(String idbook, String titule, String author, String publicationday, String category, String edition, String editorial) { 
        try { 
            String sql = "INSERT INTO libros (idbook, titule, author, publicationday, category, edition, editorial) VALUES (?, ?, ?, ?, ?, ?, ?)"; 
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.setString(1, idbook); 
            statement.setString(2, titule); 
            statement.setString(3, author); 
            statement.setString(4, publicationday); 
            statement.setString(5, category); 
            statement.setString(6, edition); 
            statement.setString(7, editorial); 
            statement.executeUpdate(); 
            System.out.println("Libro agregado correctamente."); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
            System.out.println("Error al agregar el libro: " + e.getMessage()); 
        } 
    } 
     
}
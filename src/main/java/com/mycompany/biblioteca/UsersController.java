package com.mycompany.biblioteca; 
 
import java.io.IOException; 
import java.net.URL; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ResourceBundle; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.Initializable; 
import javafx.scene.control.Button; 
import javafx.scene.control.TableColumn; 
import javafx.scene.control.TableView; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.AnchorPane; 
 
public class UsersController implements Initializable { 
 
    @FXML 
    private TableView<Usuario> userTable; 
    @FXML 
    private TableColumn<Usuario, String> idColumn; 
    @FXML 
    private TableColumn<Usuario, String> nameColumn; 
    @FXML 
    private TableColumn<Usuario, String> lastNamePColumn; 
    @FXML 
    private TableColumn<Usuario, String> lastNameMColumn; 
    @FXML 
    private TableColumn<Usuario, String> addressColumn; 
    @FXML 
    private TableColumn<Usuario, String> phoneColumn; 
    @FXML 
    private TextField searchField; 
    @FXML 
    private Button searchButton; 
    @FXML 
    private AnchorPane content; 
 
    private Connection conn; 
 
    private ObservableList<Usuario> userList = FXCollections.observableArrayList(); 
 
    @Override 
    public void initialize(URL url, ResourceBundle rb) { 
        CConexion conexion = new CConexion(); 
        conn = conexion.estableceConexion(); 
         
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty()); 
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty()); 
        lastNamePColumn.setCellValueFactory(cellData -> cellData.getValue().lastNamePProperty()); 
        lastNameMColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameMProperty()); 
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty()); 
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty()); 
 
         
        try { 
            GetUsers(); 
        } catch (SQLException ex) { 
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
 
    private void GetUsers() throws SQLException { 
        Statement stm = conn.createStatement(); 
        ResultSet counter = stm.executeQuery("SELECT * FROM `user`"); 
 
        while (counter.next()) { 
            String id = counter.getString("id"); 
            String name = counter.getString("name"); 
            String lastNameP = counter.getString("last_name_p"); 
            String lastNameM = counter.getString("last_name_m"); 
            String address = counter.getString("domicilio"); 
            String phone = counter.getString("tel"); 
 
            Usuario user = new Usuario(id, name, lastNameP, lastNameM, address, phone); 
            userList.add(user); 
        } 
 
        userTable.setItems(userList); 
    } 
 
    @FXML 
    private void onSearch(ActionEvent event) { 
        String searchTerm = searchField.getText(); 
        ObservableList<Usuario> filteredList = FXCollections.observableArrayList(); 
 
        for (Usuario user : userList) { 
            { 
                filteredList.add(user); 
            } 
        } 
 
        userTable.setItems(filteredList); 
    } 
 
    @FXML 
    private void onResetSearch(ActionEvent event) { 
        searchField.clear(); 
        userTable.setItems(userList); 
    } 
 
   
 
 
    private void On_Click_Exit(ActionEvent event) { 
         
        try { 
            App.setRoot("Library"); 
        } catch (IOException ex) { 
            Logger.getLogger( LoginController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
     
}
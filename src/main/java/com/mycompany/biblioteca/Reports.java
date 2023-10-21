package com.mycompany.biblioteca; 
 
import java.io.IOException; 
import java.net.URL; 
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.Date; 
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
 
public class Reports implements Initializable { 
 
    @FXML 
    private TableView<Reports> table_reports; 
    @FXML 
    private TableColumn<Reports, Integer> userid; 
    @FXML 
    private TableColumn<Reports, Integer> book_id; 
    @FXML 
    private TableColumn<Reports, Date> departuredate; 
    @FXML 
    private TableColumn<Reports, Date> checkindate; 
 
    private Connection conn; 
 
    @Override 
    public void initialize(URL url, ResourceBundle rb) { 
        CConexion conexion = new CConexion(); 
        conn = conexion.estableceConexion(); 
        loadReports(); 
    } 
 
    private void loadReports() { 
        try { 
            Statement statement = conn.createStatement(); 
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reports"); 
 
            ObservableList<Reports> data = FXCollections.observableArrayList(); 
 
            while (resultSet.next()) { 
                int UserID = resultSet.getInt("user_id"); 
                int BookID = resultSet.getInt("book_id"); 
                Date DEPARTUREDATE = resultSet.getDate("departure_date"); 
                Date CHECKINDATE = resultSet.getDate("checkin_date"); 
 
                Reports report = new Reports(UserID, BookID, DEPARTUREDATE, CHECKINDATE); 
                data.add(report); 
            } 
 
            resultSet.close(); 
            statement.close(); 
 
            table_reports.setItems(data); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    @FXML 
    private void On_Click_Exit(ActionEvent event) { 
        try { 
            App.setRoot("Library"); 
        } catch (IOException ex) { 
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
 
    private int userID; 
    private int bookID; 
    private Date departureDate; 
    private Date checkinDate; 
 
    public Reports(int userID, int bookID, Date departureDate, Date checkinDate) { 
        this.userID = userID; 
        this.bookID = bookID; 
        this.departureDate = departureDate; 
        this.checkinDate = checkinDate; 
    } 
 
    public int getUserID() { 
        return userID; 
    } 
 
    public int getBookID() { 
        return bookID; 
    } 
 
    public Date getDepartureDate() { 
        return departureDate; 
    } 
 
    public Date getCheckinDate() { 
        return checkinDate; 
    } 
}
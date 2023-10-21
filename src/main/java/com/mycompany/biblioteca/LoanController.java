package com.mycompany.biblioteca;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoanController implements Initializable {

    private Connection connection;

    public LoanController() {
        CConexion cConexion = new CConexion();
        this.connection = cConexion.estableceConexion();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void On_Click_exit(ActionEvent event) {
        try {
            App.setRoot("Library");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void On_Click_returnBook(ActionEvent event) {
        try {
            
            int loanId = 1; 
            LocalDate checkinDate = LocalDate.now();

            // Actualizar la base de datos con la fecha de devolución
            String sql = "UPDATE loans SET checkin_date = loan WHERE loan_id = loan";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(checkinDate));
            statement.setInt(2, loanId);
            statement.executeUpdate();

           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

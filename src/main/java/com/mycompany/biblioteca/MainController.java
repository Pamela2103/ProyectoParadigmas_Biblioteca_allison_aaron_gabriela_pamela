/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.biblioteca;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author barra
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void On_Click_next(ActionEvent event) {
        
        try {
            App.setRoot("Library");
        } catch (IOException ex) {
            Logger.getLogger( LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void On_Click_Exit(ActionEvent event) {
        try {
            App.setRoot("Login");
        } catch (IOException ex) {
            Logger.getLogger( LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

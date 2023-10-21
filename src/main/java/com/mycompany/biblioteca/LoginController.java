package com.mycompany.biblioteca;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización (si es necesaria)
    }    

    @FXML
    private void On_click_SingIn(ActionEvent event) {
        try {
            CConexion conexion = new CConexion();
            conn = conexion.estableceConexion();


            if (conn != null) {
                String sql = "SELECT * FROM administrator WHERE User = ? AND Password = ?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, txtusername.getText());
                pst.setString(2, txtpassword.getText());

                rs = pst.executeQuery();

                if (rs.next()) {
                    // Usuario y contraseña son correctos
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Login Exitoso");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario y contraseña son correctos");
                    alert.showAndWait();

                 
                    App.setRoot("Main");
                        
                } else {
                    // Usuario o contraseña incorrectos
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error de Inicio de Sesión");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario o contraseña incorrectos");
                    alert.showAndWait();
                }
            } else {
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error de Conexión");
                alert.setHeaderText(null);
                alert.setContentText("No se pudo conectar a la base de datos");
                alert.showAndWait();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace(); 
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
    }
}

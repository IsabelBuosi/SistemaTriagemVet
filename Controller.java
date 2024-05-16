package projeto.a3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;

public class Controller {
    
    @FXML
    private Button filaEsperaButton;
    
    @FXML
    private Button atenderButton;
    
    @FXML
    private Button cadastrarButton;

    @FXML
    private void handleFilaEsperaButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("filaInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) filaEsperaButton.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleatenderButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("atenderInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) filaEsperaButton.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handlecadastrarButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastroInterface.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) filaEsperaButton.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private SistemaTriage triagem = SistemaTriageSingleton.getInstance();
}

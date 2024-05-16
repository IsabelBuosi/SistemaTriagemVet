package projeto.a3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.TextArea;

public class AtenderInterfaceController {
    
    @FXML
    private TextArea chamarAnimal;
    
    @FXML
    private Button voltarButton;
    
    @FXML
    private Button botaoAtender;

    @FXML
    private void iniciarAtendimento(ActionEvent event) {
        SistemaTriage triagem = SistemaTriageSingleton.getInstance();
        try {
        	  triagem.atender(chamarAnimal::appendText);
        	} catch (Exception e) {
        	  e.printStackTrace();
        	  System.out.println("Erro ao atender animal: " + e.getMessage());
        	}
        }
    
    @FXML
    private void handlevoltarButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainInterface.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) voltarButton.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}

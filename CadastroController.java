package projeto.a3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CadastroController {
    
    @FXML
    private ChoiceBox<String> gravidadeBox;
    
    @FXML
    private ChoiceBox<String> sintomasBox;

    @FXML
    private Button adicionarButton;

    @FXML
    private TextArea nomeTextArea;

    @FXML
    private Button voltarButton;
    
    private SistemaTriage triagem = SistemaTriageSingleton.getInstance();
    
    @FXML
    public void initialize() {
        ObservableList<String> gravidadeList = FXCollections.observableArrayList("3", "2", "1");
        ObservableList<String> sintomasList = FXCollections.observableArrayList("grave", "moderado", "leve");
        
        gravidadeBox.setItems(gravidadeList);
        sintomasBox.setItems(sintomasList);
    }

    @FXML
    void adicionarButtonClicked(ActionEvent event) {
    	 if (gravidadeBox.getValue() == null || sintomasBox.getValue() == null || nomeTextArea.getText().isEmpty()) {
    	        Alert alert = new Alert(AlertType.ERROR);
    	        alert.setTitle("Erro");
    	        alert.setHeaderText(null);
    	        alert.setContentText("Por favor, preencha todos os campos corretamente.");
    	        alert.showAndWait();
    	    } else {
    	        int gravidade = Integer.parseInt(gravidadeBox.getValue());
    	        String sintomas = sintomasBox.getValue();
    	        String nome = nomeTextArea.getText();

    	        Animal animal = new Animal(0, sintomas, nome, gravidade); // Idade é 0, pois não é fornecida no formulário

    	        triagem.triar(animal);

    	        Alert alert = new Alert(AlertType.INFORMATION);
    	        alert.setTitle("Sucesso");
    	        alert.setHeaderText(null);
    	        alert.setContentText("Animal adicionado com sucesso.");
    	        alert.showAndWait();

    	        gravidadeBox.getSelectionModel().clearSelection();
    	        sintomasBox.getSelectionModel().clearSelection();
    	        nomeTextArea.clear();
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

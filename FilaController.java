package projeto.a3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FilaController {
    @FXML
    private Button voltarButton;
    
    @FXML
    private ListView<Animal> listaAlta;

    @FXML
    private ListView<Animal> listaMedia;

    @FXML
    private ListView<Animal> listaBaixa;
    
    private SistemaTriage triagem = SistemaTriageSingleton.getInstance(); 

    public void initialize() {
        atualizarListas();
    }

    public void atualizarListas() {

        FilaAlta filaAlta = triagem.getFilaAlta();
        FilaMedia filaMedia = triagem.getFilaMedia();
        FilaBaixa filaBaixa = triagem.getFilaBaixa();

        listaAlta.getItems().setAll(filaAlta.getAnimais());
        listaMedia.getItems().setAll(filaMedia.getAnimais());
        listaBaixa.getItems().setAll(filaBaixa.getAnimais());
        
        Callback<ListView<Animal>, ListCell<Animal>> factory = lv -> new ListCell<Animal>() {
            @Override
            protected void updateItem(Animal animal, boolean empty) {
                super.updateItem(animal, empty);
                if (animal != null) {
                    setText(animal.getNome());
                } else {
                    setText(null);
                }
            }
        };
        listaAlta.setCellFactory(factory);
        listaMedia.setCellFactory(factory);
        listaBaixa.setCellFactory(factory);
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

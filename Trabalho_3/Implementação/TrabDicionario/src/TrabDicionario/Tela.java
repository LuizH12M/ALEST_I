package TrabDicionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tela {
	private Stage mainStage; 
	private Scene cenaEntrada;
	private TextField tfText;
        
        private Arquivo arquivo;
        private ArrayList<Palavra> listaDePalavras;

	public Tela(Stage anStage) {
		this.mainStage = anStage;
        arquivo = new Arquivo();
	}
	
	public Scene getTelaEntrada() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10); // altura
		grid.setVgap(10); // largura
		grid.setPadding(new Insets(25, 25, 25, 25));
                arquivo.leitura();

		Label userName = new Label("Digite uma palavra:");
		grid.add(userName, 0, 1);

		tfText = new TextField();
		grid.add(tfText, 0, 2);
                
                ListView<Palavra> lv = new ListView<>();
                
		Button btnIn = new Button("Buscar");
		HBox hbBtn = new HBox(30); // Tamanho botão
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(btnIn);
		grid.add(hbBtn, 1, 2); // Onde adiciona o botão
            grid.add(lv, 0, 3, 25, 25);
            btnIn.setOnAction(e -> {
				try {
					listaDePalavras = arquivo.buscaPalavras(tfText.getText());
                            lv.setItems(FXCollections.observableList(listaDePalavras));
				} catch (Exception ex) {
				
				}
		});
		
		cenaEntrada = new Scene(grid);
		return cenaEntrada;
	}
}
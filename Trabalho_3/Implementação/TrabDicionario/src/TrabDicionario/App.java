package TrabDicionario;

import java.awt.Dimension;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App extends Application{
  
    public static void main(String[] args) {        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Dicionario");

    	Tela tela = new Tela(primaryStage);

        primaryStage.setScene(tela.getTelaEntrada());
        primaryStage.show();
    }
}

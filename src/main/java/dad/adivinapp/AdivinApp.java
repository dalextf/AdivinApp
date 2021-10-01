package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

    private Label infoLabel;
    private TextField nombreText;
    private Button checkButton;
    int random = (int) (Math.random() * 100) + 1, intentos = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {

        infoLabel = new Label("Introduce un número de 1 al 100");

        nombreText = new TextField();
        nombreText.setAlignment(Pos.CENTER);
        nombreText.setMaxWidth(100);

        checkButton = new Button("Comprobar");
        checkButton.setDefaultButton(true);
        checkButton.setOnAction(e -> comprobarButtonAction(e));

        VBox root = new VBox(5, infoLabel, nombreText, checkButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root,320,230);

        primaryStage.setTitle("AdivinApp");
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println(random);

    }

    private void comprobarButtonAction(ActionEvent e){

        String numText = nombreText.getText();

        try {
            int numero = Integer.parseInt(numText);
            if(numero==random) {
                intentos++;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("AdivinApp");
                alert.setHeaderText("¡Has ganado!");
                alert.setContentText("Sólo has necesitado "+ intentos +" intentos\n Vuelve a jugar y hazlo mejor.");
                alert.showAndWait();

            }else if(numero<random) {
                intentos++;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("AdivinApp");
                alert.setHeaderText("¡Has fallado!");
                alert.setContentText("El número a adivinar es mayor que "+numero);
                alert.showAndWait();
            }else if (numero>random){
                intentos++;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("AdivinApp");
                alert.setHeaderText("¡Has fallado!");
                alert.setContentText("El número a adivinar es menor que "+numero);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("AdivinApp");
                alert.setHeaderText("Algo ha fallado");
                alert.setContentText("El número introducido no es válido, verifica los rangos.");
                alert.showAndWait();
            }

        } catch (NumberFormatException error){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("Error");
            alert.setContentText("No has introducido un número.");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

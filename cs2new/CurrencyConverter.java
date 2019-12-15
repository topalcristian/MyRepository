import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;



public class CurrencyConverter extends Application{

    // Currency that you convert
    ComboBox<String> currency;
    // Currency that you want
    ComboBox<String> convertTo;
    Button convert;
    // Textfield where you can enter the amount that you want to convert
    TextField enteramount;
    // label for the result
    Label label;
    // additional label for the warning
    Label warning;
    Double outcome;

    Stage window;
    Scene scene;

    public static void main(String [] args){

        //when we start our javafx program, its gonna call this method and set up program as javafx application
        launch(args);
    }
    // next this method gets called
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Currency Converter");

        convert = new Button("Convert!");

        currency = new ComboBox<>();
        currency.setPromptText("Converting Currency");
        currency.getItems().addAll(
                "USD",
                "EUR",
                "GBP");

        convertTo = new ComboBox<>();
        convertTo.setPromptText("Requested Currency");
        convertTo.getItems().addAll(
                "USD",
                "EUR",
                "GBP");

        enteramount = new TextField ();
        label = new Label();
        warning = new Label();

        // with the click on the button:
        convert.setOnAction( e -> {
            String selected = currency.getValue();
            String selected2 = convertTo.getValue();

            if(selected.equals("USD") && selected2.equals("EUR")){
                double d = Double.parseDouble(enteramount.getText());
                outcome = d*0.847;
                label.setText("Outcome: " + outcome + " Euro");
            }
            if(selected.equals("USD") && selected2.equals("GBP")){

                double d = Double.parseDouble(enteramount.getText());
                outcome = d*0.756;
                label.setText("Outcome: " + outcome + " Pounds");
            }

            if(selected.equals("USD") && selected2.equals("USD")){
                warning.setText("ERROR! ENTER DIFFERENT CURRENCIES!");
                label.setText(null);
            }

            if(selected.equals("EUR") && selected2.equals("USD")){
                double d = Double.parseDouble(enteramount.getText());
                outcome = d*1.18;
                label.setText("Outcome: " + outcome + " Dollar");
            }

            if(selected.equals("EUR") && selected2.equals("GBP")){
                double d = Double.parseDouble(enteramount.getText());
                outcome = d*0.89;
                label.setText("Outcome: " + outcome + " Pounds");
            }

            if(selected.equals("EUR") && selected2.equals("EUR")){
                warning.setText("ERROR! ENTER DIFFERENT CURRENCIES!");
                label.setText(null);
            }

            if(selected.equals("GBP") && selected2.equals("USD")){
                double d = Double.parseDouble(enteramount.getText());
                outcome = d*1.32;
                label.setText("Outcome: " + outcome + " Dollar");
            }

            if(selected.equals("GBP") && selected2.equals("EUR")){
                double d = Double.parseDouble(enteramount.getText());
                outcome = d*1.12;
                label.setText("Outcome: " + outcome + " Euro");
            }

            if(selected.equals("GBP") && selected2.equals("GBP")){
                warning.setText("ERROR! ENTER DIFFERENT CURRENCIES!");
                label.setText(null);
            }
        });

        //Layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(40,50,50,50));
        layout.getChildren().addAll(currency, convertTo,enteramount, label, warning, convert);

        scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.show();


    }

}

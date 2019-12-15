import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class AlertBox {

    // simple AlertBox, which pops up if the user types in the worng password or username 3 times
    public static void display(String title, String message) {

        Stage window = new Stage();

        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(message);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}

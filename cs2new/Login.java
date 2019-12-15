import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Login extends Application{

    TextField userName;
    TextField passWord;

    Label usernameLabel;
    Label passwordLabel;
    Label welcome;
    Label wrong;
    Button login;



    Stage window;
    Scene scene, scene2;
    // storing all usernames (and passwords) in an array list
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();

    // used to count, how often the wrong creditials were entered
    int counter = 0;

    public static void main(String [] args) {

        launch(args);

    }

    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        window.setTitle("Login Window");

        login = new Button("Login");
        GridPane.setConstraints(login,  1, 2);

        userName = new TextField();
        GridPane.setConstraints(userName, 1, 0);
        userName.getText().toLowerCase();
        passWord =  new TextField();
        GridPane.setConstraints(passWord, 1, 1);

        usernameLabel = new Label("Username: ");
        GridPane.setConstraints(usernameLabel, 0, 0);
        passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel,  0, 1);
        wrong = new Label();
        GridPane.setConstraints(wrong, 2,1);

        welcome = new Label("Welcome To The Program");

        try {
            File file = new File("users.txt");
            // I use a scanner instead of a buffered reader
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                // first word in the file is always the username
                String user = sc.next();
                // second word is the password
                String pass = sc.next();
                // add username and password to the array
                usernames.add(user);
                passwords.add(pass);
                sc.nextLine();
                System.out.println(usernames);
                System.out.println(passwords);
            }
            sc.close();
        } catch (IOException h) {
            h.printStackTrace();
        }

        login.setOnAction(e -> {

            boolean check = true;
            while(check == true){

                for(int i=0; i<usernames.size(); i++) {
                    // transform to lowercase, since it is not case sensitive
                    usernames.get(i).toLowerCase();
                    // if correct username and password
                    if (userName.getText().equals(usernames.get(i)) && passWord.getText().equals(passwords.get(i))) {
                        window.setScene(scene2);
                        window.show();
                    } else {
                        check = false;
                        wrong.setText("Wrong credentials");
                    }
                }
                if(check==false){
                    // counting each time someone entered the wrong credentials
                    counter++;
                }
                if (counter == 3) {
                    closeProgram();
                    AlertBox.display("ERROR", "You typed 3 times the wrong credentials");
                }
            }
        });
        //layout and form
        GridPane layout = new GridPane();
        scene = new Scene(layout, 600, 400);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(8);
        layout.setHgap(10);
        layout.getChildren().addAll(usernameLabel, userName, passwordLabel, passWord,login,wrong);

        StackPane layout2 = new StackPane();
        scene2 = new Scene(layout2, 600, 400);
        layout2.getChildren().addAll(welcome);

        window.setScene(scene);
        window.show();

    }

    private void closeProgram(){
        window.close();
    }
}
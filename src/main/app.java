package main;

import classes.Storage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import screens.Main;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class app extends Application
{
    public static void main(String[] args)
    {
        Storage.startProgram();
        Application.launch(app.class);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        StackPane root = new StackPane();
        stage.setTitle("DietSystem");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 400, 400));
        root.setStyle("-fx-background-color: #eb2728");

        try
        {
            InputStream imageURL = getClass().getResourceAsStream("/img/dieticianapp-logo-white.png");
            System.out.println(imageURL);
            Image image = new Image(imageURL);
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(250);
            imageView.setFitWidth(250);
            StackPane.setAlignment(imageView, Pos.CENTER);
            root.getChildren().add(imageView);
        }
        catch (Exception e)
        {
            System.err.println("Logo can not loaded!");
            e.printStackTrace();
        }

        stage.show();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> new Main().start(new Stage()));
                Platform.runLater(() -> stage.hide());
                timer.cancel();
            }
        },1000,1000);
    }
}

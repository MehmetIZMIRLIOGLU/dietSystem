package main;

import classes.Storage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import screens.Main;

import java.sql.Time;
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

        Label lbl = new Label("DietSystem");
        root.getChildren().add(lbl);

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

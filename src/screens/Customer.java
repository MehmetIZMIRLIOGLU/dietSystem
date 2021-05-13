package screens;

import classes.Storage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Customer extends Application
{
    @Override
    public void start(Stage stage)
    {
        StackPane root = new StackPane();
        stage.setTitle("Customer Screen");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 400, 400));

        root.getChildren().add(new Label(Storage.currentCustomer.toString()));

        stage.setOnHiding( event -> {
            stage.hide();
            Platform.runLater(() -> new Main().start(new Stage()));
        });
        stage.show();
    }
}

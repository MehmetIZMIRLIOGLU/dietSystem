package screens;

import classes.Customer;
import classes.Dietician;
import classes.Genders;
import classes.Packages;
import classes.Storage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage mainStage;
    Stage dieticianLoginStage;
    Stage customerLoginStage;
    Stage customerRegisterStage;
    private Button dietician;
    private Button customer;
    @Override
    public void start(Stage stage)
    {
        mainStage = stage;
        StackPane root = new StackPane();
        stage.setTitle("DietSystem");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 400, 400));

        Label lbl = new Label("Select Your Type");
        StackPane.setMargin(lbl, new Insets(-100, 0, 0, 0));
        lbl.setTextFill(Color.web("#eb2728"));
        lbl.setFont(new Font("Arial",30));
        root.getChildren().add(lbl);
        root.setStyle("-fx-background-color: #3d3d3d");

        dietician = new Button("Dietician");
        customer = new Button("Customer");
        dietician.setMinWidth(150);
        customer.setMinWidth(150);
        dietician.setMinHeight(60);
        customer.setMinHeight(60);
        dietician.setTextFill(Color.web("#ffffff"));
        customer.setTextFill(Color.web("#ffffff"));
        dietician.setStyle("-fx-background-color: #eb2728");
        customer.setStyle("-fx-background-color: #eb2728");
        dietician.setFont(new Font("Arial",15));
        customer.setFont(new Font("Arial",15));
        StackPane.setAlignment(dietician,Pos.CENTER_LEFT);
        StackPane.setAlignment(customer,Pos.CENTER_RIGHT);
        StackPane.setMargin(dietician, new Insets(100, 30, 0, 30));
        StackPane.setMargin(customer, new Insets(100, 30, 0, 30));
        root.getChildren().add(dietician);
        root.getChildren().add(customer);

        dietician.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                stage.hide();
                Platform.runLater(() -> dieticianLogin(new Stage()));
            }
        });

        customer.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                stage.hide();
                Platform.runLater(() -> customerLogin(new Stage()));
            }
        });

        stage.show();
    }

    private void dieticianLogin(Stage stage)
    {
        dieticianLoginStage = stage;
        StackPane root = new StackPane();
        stage.setTitle("Dietician Login");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 400, 400));

        ComboBox<Dietician> dieticianComboBox = new ComboBox<Dietician>();
        ObservableList<Dietician> oListDietician = FXCollections.observableArrayList(Storage.getDieticians());
        dieticianComboBox.setItems(oListDietician);
        root.getChildren().add(dieticianComboBox);

        Button loginBtn = new Button("Login");
        root.getChildren().add(loginBtn);

        loginBtn.setMinWidth(130);
        dieticianComboBox.setMinWidth(130);

        StackPane.setMargin(dieticianComboBox,new Insets(-40, 0, 0, 0));
        StackPane.setMargin(loginBtn,new Insets(40, 0, 0, 0));

        loginBtn.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if(dieticianComboBox.getValue() == null)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please select your fullname.");
                    alert.showAndWait();
                }
                else
                {
                    Storage.currentDietician = dieticianComboBox.getValue();
                    stage.hide();
                    mainStage.hide();
                    Platform.runLater(() -> new screens.Dietician().start(new Stage()));
                }

            }
        });

        stage.setOnHiding( event -> {
            stage.hide();
            mainStage.show();
        });
        stage.show();
    }

    private void customerLogin(Stage stage)
    {
        customerLoginStage = stage;
        StackPane root = new StackPane();
        stage.setTitle("Customer Login");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 400, 400));

        ComboBox<Customer> customerComboBox = new ComboBox<Customer>();
        ObservableList<Customer> oListCustomer = FXCollections.observableArrayList(Storage.getCustomers());
        customerComboBox.setItems(oListCustomer);
        root.getChildren().add(customerComboBox);

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");
        root.getChildren().add(loginBtn);
        root.getChildren().add(registerBtn);

        loginBtn.setMinWidth(130);
        registerBtn.setMinWidth(130);
        customerComboBox.setMinWidth(130);

        StackPane.setMargin(customerComboBox,new Insets(-60, 0, 0, 0));
        StackPane.setMargin(loginBtn,new Insets(20, 0, 0, 0));
        StackPane.setMargin(registerBtn,new Insets(80, 0, 0, 0));

        loginBtn.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                if(customerComboBox.getValue() == null)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please select your fullname.");
                    alert.showAndWait();
                }
                else
                {
                    Storage.currentCustomer = customerComboBox.getValue();
                    stage.hide();
                    mainStage.hide();
                    Platform.runLater(() -> new screens.Customer().start(new Stage()));
                }

            }
        });

        registerBtn.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                stage.hide();
                mainStage.hide();
                Platform.runLater(() -> customerRegister(new Stage()));
            }
        });

        stage.setOnHiding( event -> {
            stage.hide();
            mainStage.show();
        });
        stage.show();
    }

    private void customerRegister(Stage stage)
    {
        customerRegisterStage = stage;
        StackPane root = new StackPane();
        stage.setTitle("Customer Register");
        stage.setResizable(false);
        GridPane gridPane = new GridPane();
        stage.setScene(new Scene(root, 400, 400));

        root.getChildren().add(gridPane);

        Label lblName = new Label("Name:");
        Label lblSurname = new Label("Surname:");
        Label lblBirthYear = new Label("Birth Year (ex.1990):");
        Label lblWeight = new Label("Weight (kg):");
        Label lblHeight = new Label("Height (cm):");
        Label lblGender = new Label("Gender:");
        Label lblPackage = new Label("Package:");
        Label lblAddress = new Label("Address:");

        TextField fieldName = new TextField();
        TextField fieldSurname = new TextField();
        TextField fieldBirthYear = new TextField();
        TextField fieldWeight = new TextField();
        TextField fieldHeight = new TextField();
        ComboBox<Genders> gendersComboBox = new ComboBox<Genders>();
        gendersComboBox.getItems().setAll(Genders.values());
        ComboBox<Packages> packagesComboBox = new ComboBox<Packages>();
        packagesComboBox.getItems().setAll(Packages.values());
        TextField fieldAddress = new TextField();

        for (int i = 0; i < 2; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(50);
            gridPane.getColumnConstraints().add(column);
        }

        //Setting size for the pane
        gridPane.setMaxSize(350, 350);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(lblName,0,0);
        gridPane.add(fieldName,1,0);
        gridPane.add(lblSurname,0,1);
        gridPane.add(fieldSurname,1,1);
        gridPane.add(lblBirthYear,0,2);
        gridPane.add(fieldBirthYear,1,2);
        gridPane.add(lblWeight,0,3);
        gridPane.add(fieldWeight,1,3);
        gridPane.add(lblHeight,0,4);
        gridPane.add(fieldHeight,1,4);
        gridPane.add(lblGender,0,5);
        gridPane.add(gendersComboBox,1,5);
        gridPane.add(lblPackage,0,6);
        gridPane.add(packagesComboBox,1,6);
        gridPane.add(lblAddress,0,7);
        gridPane.add(fieldAddress,1,7);

        Button btnCancel = new Button("Cancel");
        Button btnRegister = new Button("Register");

        gridPane.add(btnCancel,0,8);
        gridPane.add(btnRegister,1,8);

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gendersComboBox.setMaxWidth(Double.MAX_VALUE);
        packagesComboBox.setMaxWidth(Double.MAX_VALUE);
        btnRegister.setMaxWidth(Double.MAX_VALUE);
        btnCancel.setMaxWidth(Double.MAX_VALUE);

        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                stage.hide();
                customerLoginStage.show();
            }
        });

        btnRegister.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                try
                {
                    classes.Customer newCustomer = new classes.Customer(fieldName.getText(),fieldSurname.getText(),Integer.parseInt(fieldBirthYear.getText()),Double.parseDouble(fieldWeight.getText()),Double.parseDouble(fieldHeight.getText()),(Genders) gendersComboBox.getValue(),(Packages) packagesComboBox.getValue(),fieldAddress.getText());
                    Storage.addCustomer(newCustomer);
                    Storage.currentCustomer = newCustomer;
                    stage.hide();
                    customerLoginStage.hide();
                    mainStage.hide();
                    Platform.runLater(() -> new screens.Customer().start(new Stage()));
                }
                catch (Exception e)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in the blanks.");
                    alert.showAndWait();
                }
            }
        });

        stage.setOnHiding( event -> {
            stage.hide();
            customerLoginStage.show();
        });
        stage.show();
    }
}

package screens;

import classes.Customer;
import classes.Packages;
import classes.Storage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class Dietician extends Application
{
    Customer selectedCustomer;
    @Override
    public void start(Stage stage)
    {
        StackPane root = new StackPane();
        stage.setTitle("Dietician Screen");
        stage.setResizable(false);
        root.setPadding(new Insets(10,10,10,10));
        stage.setScene(new Scene(root, 1000, 500));

        Label fullName = new Label("Hi, " + Storage.currentDietician.getName() + " " + Storage.currentDietician.getSurname());
        fullName.setFont(new Font("Arial",18));
        StackPane.setAlignment(fullName, Pos.TOP_LEFT);
        root.getChildren().add(fullName);

        Label lblCustomers = new Label("Customers");
        lblCustomers.setFont(new Font("Arial",25));
        lblCustomers.setStyle("-fx-font-weight: bold");
        StackPane.setMargin(lblCustomers,new Insets(25,0,0,0));
        StackPane.setAlignment(lblCustomers, Pos.TOP_LEFT);
        root.getChildren().add(lblCustomers);

        TableView tableView = new TableView();
        TableColumn<classes.Dietician, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column1.setSortable(false);
        column1.setMinWidth(119);
        TableColumn<classes.Dietician, String> column2 = new TableColumn<>("Surname");
        column2.setCellValueFactory(new PropertyValueFactory<>("surname"));
        column2.setSortable(false);
        column2.setMinWidth(119);
        tableView.getColumns().addAll(column1,column2);

        ObservableList<classes.Customer> oListCustomer = FXCollections.observableArrayList(Storage.currentDietician.getCustomers());
        tableView.setItems(oListCustomer);

        tableView.setMaxWidth(240);
        StackPane.setAlignment(tableView, Pos.TOP_LEFT);

        root.getChildren().add(tableView);
        StackPane.setMargin(tableView,new Insets(60,0,0,0));

        StackPane rigthPane = new StackPane();
        StackPane.setAlignment(rigthPane, Pos.TOP_RIGHT);
        rigthPane.setMinWidth(730);
        rigthPane.setMaxWidth(730);
        rigthPane.setPadding(new Insets(10,10,10,10));

        rigthPane.setBorder(new Border(new BorderStroke(null,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rigthPane.setStyle("-fx-border-color: black");
        root.getChildren().add(rigthPane);

        Label rightPanePlaceholder = new Label("Please select the customer");
        rightPanePlaceholder.setFont(new Font("Arial",35));
        rigthPane.getChildren().add(rightPanePlaceholder);

        TextFlow textFlow = new TextFlow();
        StackPane.setAlignment(textFlow, Pos.TOP_LEFT);
        rigthPane.getChildren().add(textFlow);
        textFlow.setVisible(false);

        Label lblPack = new Label();
        StackPane.setAlignment(lblPack, Pos.TOP_RIGHT);
        lblPack.setFont(new Font("Arial",30));
        lblPack.setStyle("-fx-font-weight: bold");
        rigthPane.getChildren().add(lblPack);
        lblPack.setVisible(false);

        StackPane rigthPaneBottom = new StackPane();
        rigthPaneBottom.setMaxHeight(270);
        StackPane.setAlignment(rigthPaneBottom,Pos.BOTTOM_LEFT);
        rigthPane.getChildren().add(rigthPaneBottom);
        rigthPaneBottom.setVisible(false);

        Button btnSave = new Button("SAVE");
        btnSave.setStyle("-fx-font-weight: bold");
        rigthPaneBottom.getChildren().add(btnSave);
        StackPane.setAlignment(btnSave,Pos.TOP_RIGHT);
        btnSave.setPadding(new Insets(15,15,15,15));
        StackPane.setMargin(btnSave,new Insets(10,0,0,0));

        Label foodListLbl = new Label("Food List");
        foodListLbl.setFont(new Font("Arial",20));
        foodListLbl.setStyle("-fx-font-weight: bold");
        rigthPaneBottom.getChildren().add(foodListLbl);
        StackPane.setAlignment(foodListLbl, Pos.TOP_LEFT);
        ComboBox comboBoxFoodList = new ComboBox();
        rigthPaneBottom.getChildren().add(comboBoxFoodList);
        StackPane.setAlignment(comboBoxFoodList, Pos.TOP_LEFT);
        StackPane.setMargin(comboBoxFoodList,new Insets(30,0,0,0));

        TextArea foodDetails = new TextArea();
        rigthPaneBottom.getChildren().add(foodDetails);
        StackPane.setAlignment(foodDetails, Pos.TOP_LEFT);
        StackPane.setMargin(foodDetails,new Insets(70,0,0,0));

        comboBoxFoodList.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            try
            {
                int selectedDay = 0;
                if(t1 != null)
                    selectedDay = Integer.parseInt(t1.toString().split(" ")[1]);
                if(selectedCustomer.getFoodList() == null)
                    foodDetails.setText("not prepared yet.");
                else if(selectedCustomer.getFoodList().getFoodDetails(selectedDay) == "")
                    foodDetails.setText("not prepared yet.");
                else
                    foodDetails.setText(selectedCustomer.getFoodList().getFoodDetails(selectedDay));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            selectedCustomer = (Customer)newValue;
            rightPanePlaceholder.setVisible(false);
            lblPack.setText(selectedCustomer.getPack().toString().toUpperCase());
            lblPack.setVisible(true);
            textFlow.setVisible(true);

            comboBoxFoodList.getSelectionModel().clearSelection();
            foodDetails.setText("");

            Text[] texts = new Text[13];
            texts[0] = new Text("Customer Details\n\n");
            texts[0].setStyle("-fx-font-weight: bold");

            texts[1] = new Text("Full Name\t\t: ");
            texts[1].setStyle("-fx-font-weight: bold");
            texts[2] = new Text(selectedCustomer.getName() + " " + selectedCustomer.getSurname() + "\n");

            texts[3] = new Text("Gender\t\t: ");
            texts[3].setStyle("-fx-font-weight: bold");
            texts[4] = new Text(selectedCustomer.getGender() + "\n");

            texts[5] = new Text("Birth Year\t\t: ");
            texts[5].setStyle("-fx-font-weight: bold");
            texts[6] = new Text(selectedCustomer.getBirth_year() + "\n");

            texts[7] = new Text("Weight\t\t: ");
            texts[7].setStyle("-fx-font-weight: bold");
            texts[8] = new Text(selectedCustomer.getWeight() + "\n");

            texts[9] = new Text("Height\t\t: ");
            texts[9].setStyle("-fx-font-weight: bold");
            texts[10] = new Text(selectedCustomer.getHeight() + "\n");

            texts[11] = new Text("Address\t\t: ");
            texts[11].setStyle("-fx-font-weight: bold");
            texts[12] = new Text(selectedCustomer.getAddress() + "\n");

            for (Text txt: texts)
                txt.setFont(new Font("Arial",(txt.equals(texts[0])) ? 20 : 16));

            textFlow.getChildren().setAll(texts);


            rigthPaneBottom.setVisible(true);

            int dayCount = 0;
            if(selectedCustomer.getPack() == Packages.Weekly)
                dayCount = 7;
            if(selectedCustomer.getPack() == Packages.Monthly)
                dayCount = 30;

            ArrayList<String> arrayListDays = new ArrayList<>();
            for (int i=1; i<=dayCount; i++)
                arrayListDays.add("Day " + i);
            ObservableList<String> oListDays = FXCollections.observableArrayList(arrayListDays);
            comboBoxFoodList.setItems(oListDays);
        });

        stage.setOnHiding( event -> {
            stage.hide();
            Platform.runLater(() -> new Main().start(new Stage()));
        });
        stage.show();
    }
}

package screens;

import classes.Dietician;
import classes.Packages;
import classes.Storage;
import classes.BinarySearchTreeForRanking;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.util.ArrayList;

public class Customer extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Customer Screen");
        stage.setResizable(false);
        StackPane root = new StackPane();
        root.setPadding(new Insets(10,10,10,10));
        stage.setScene(new Scene(root, 1000, 500));

        Label fullName = new Label("Hi, " + Storage.currentCustomer.getName() + " " + Storage.currentCustomer.getSurname());
        fullName.setFont(new Font("Arial",18));
        StackPane.setAlignment(fullName, Pos.TOP_LEFT);
        root.getChildren().add(fullName);

        Label YourDieticianDetails = new Label("Your Dietician Details");
        YourDieticianDetails.setFont(new Font("Arial",30));
        YourDieticianDetails.setStyle("-fx-font-weight: bold");
        root.getChildren().add(YourDieticianDetails);
        StackPane.setAlignment(YourDieticianDetails, Pos.TOP_LEFT);
        StackPane.setMargin(YourDieticianDetails,new Insets(55,0,0,0));

        Label YourDieticianFullname = new Label();
        YourDieticianFullname.setFont(new Font("Arial",20));
        root.getChildren().add(YourDieticianFullname);
        StackPane.setAlignment(YourDieticianFullname, Pos.TOP_LEFT);
        StackPane.setMargin(YourDieticianFullname,new Insets(95,0,0,0));

        Label ratingDietician = new Label("Rating Dietician");
        ratingDietician.setFont(new Font("Arial",20));
        ratingDietician.setStyle("-fx-font-weight: bold");
        root.getChildren().add(ratingDietician);
        StackPane.setAlignment(ratingDietician, Pos.TOP_LEFT);
        StackPane.setMargin(ratingDietician,new Insets(145,0,0,0));

        Rating rating = new Rating();
        rating.setUpdateOnHover(true);
        rating.setPartialRating(false);
        rating.setMax(5);
        rating.setRating(0);
        root.getChildren().add(rating);
        StackPane.setAlignment(rating, Pos.TOP_LEFT);
        StackPane.setMargin(rating,new Insets(175,0,0,0));
        rating.setMaxHeight(33);

        Label foodListLbl = new Label("Food List");
        foodListLbl.setFont(new Font("Arial",20));
        foodListLbl.setStyle("-fx-font-weight: bold");
        root.getChildren().add(foodListLbl);
        StackPane.setAlignment(foodListLbl, Pos.TOP_LEFT);
        StackPane.setMargin(foodListLbl,new Insets(230,0,0,0));

        int dayCount = 0;
        if(Storage.currentCustomer.getPack() == Packages.Weekly)
            dayCount = 7;
        if(Storage.currentCustomer.getPack() == Packages.Monthly)
            dayCount = 30;

        ArrayList<String> arrayListDays = new ArrayList<>();
        for (int i=1; i<=dayCount; i++)
            arrayListDays.add("Day " + i);

        ComboBox comboBoxFoodList = new ComboBox();
        ObservableList<String> oListDays = FXCollections.observableArrayList(arrayListDays);
        comboBoxFoodList.setItems(oListDays);
        root.getChildren().add(comboBoxFoodList);
        StackPane.setAlignment(comboBoxFoodList, Pos.TOP_LEFT);
        StackPane.setMargin(comboBoxFoodList,new Insets(260,0,0,0));

        TextArea foodDetails = new TextArea();
        foodDetails.setDisable(true);
        root.getChildren().add(foodDetails);
        StackPane.setAlignment(foodDetails, Pos.TOP_LEFT);
        StackPane.setMargin(foodDetails,new Insets(300,0,0,0));
        foodDetails.setMaxWidth(490);

        comboBoxFoodList.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            int selectedDay = Integer.parseInt(t1.toString().split(" ")[1]);
            if(Storage.currentCustomer.getFoodList() == null)
                foodDetails.setText("not prepared yet.");
            else if(Storage.currentCustomer.getFoodList().getFoodDetails(selectedDay) == "")
                foodDetails.setText("not prepared yet.");
            else
                foodDetails.setText(Storage.currentCustomer.getFoodList().getFoodDetails(selectedDay));
        });


        Label selectYourDietician = new Label("Select Your Dietician");
        selectYourDietician.setFont(new Font("Arial",30));
        selectYourDietician.setStyle("-fx-font-weight: bold");
        root.getChildren().add(selectYourDietician);
        StackPane.setAlignment(selectYourDietician, Pos.TOP_LEFT);
        StackPane.setMargin(selectYourDietician,new Insets(55,0,0,0));


        Label topDietician = new Label("Top Dietician");
        topDietician.setFont(new Font("Arial",25));
        topDietician.setStyle("-fx-font-weight: bold");
        root.getChildren().add(topDietician);
        StackPane.setAlignment(topDietician, Pos.TOP_RIGHT);
        StackPane.setMargin(topDietician,new Insets(15,0,0,0));


        GridPane gridPane = new GridPane();
        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        StackPane.setAlignment(gridPane, Pos.TOP_LEFT);
        StackPane.setMargin(gridPane,new Insets(100,0,0,0));

        ArrayList<Dietician> dieticians = Storage.getDieticians();
        Button[] buttons = new Button[dieticians.size()];
        for(int i = 0; i < dieticians.size(); i++)
        {
            buttons[i] = new Button(Storage.getDieticians().get(i).toString());
            gridPane.add(buttons[i], i%3, i/3);
            buttons[i].setMinWidth(153.33);
            buttons[i].setMaxWidth(153.33);
            buttons[i].setMinHeight(100);
            buttons[i].setMaxHeight(100);
            int finalI = i;
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    Storage.currentCustomer.setDietician(dieticians.get(finalI));
                    dieticians.get(finalI).addCustomer(Storage.currentCustomer);

                    selectYourDietician.setVisible(false);
                    gridPane.setVisible(false);
                    YourDieticianFullname.setText(Storage.currentCustomer.getDietician().getName() + " " + Storage.currentCustomer.getDietician().getSurname());
                    ratingDietician.setVisible(true);
                    rating.setVisible(true);
                    foodDetails.setVisible(true);
                    foodListLbl.setVisible(true);
                    comboBoxFoodList.setVisible(true);
                }
            });
        }

        root.getChildren().add(gridPane);

        TableView tableView = new TableView();
        TableColumn<Dietician, String> column1 = new TableColumn<>("Rank");
        column1.setCellValueFactory(new PropertyValueFactory<>("rank_avg"));
        column1.setSortable(false);
        column1.setMinWidth(98);
        TableColumn<Dietician, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setSortable(false);
        column2.setMinWidth(190);
        TableColumn<Dietician, String> column3 = new TableColumn<>("Surname");
        column3.setCellValueFactory(new PropertyValueFactory<>("surname"));
        column3.setSortable(false);
        column3.setMinWidth(190);
        tableView.getColumns().addAll(column1,column2,column3);

        BinarySearchTreeForRanking binarySearchTreeForRanking = new BinarySearchTreeForRanking();
        Dietician[] orderedDieticians = binarySearchTreeForRanking.order();
        ObservableList<Dietician> oListDietician = FXCollections.observableArrayList(orderedDieticians);
        tableView.setItems(oListDietician);

        tableView.setMaxWidth(480);
        StackPane.setAlignment(tableView, Pos.TOP_RIGHT);

        root.getChildren().add(tableView);
        StackPane.setMargin(tableView,new Insets(50,0,0,0));

        if(Storage.currentCustomer.getDietician() != null)
        {
            selectYourDietician.setVisible(false);
            gridPane.setVisible(false);
            YourDieticianFullname.setText(Storage.currentCustomer.getDietician().getName() + " " + Storage.currentCustomer.getDietician().getSurname());
            if(Storage.currentCustomer.getRanked() > 0)
            {
                rating.setRating(Storage.currentCustomer.getRanked());
                rating.setDisable(true);
            }
        }
        else
        {
            selectYourDietician.setVisible(false);
            ratingDietician.setVisible(false);
            rating.setVisible(false);
            foodDetails.setVisible(false);
            foodListLbl.setVisible(false);
            comboBoxFoodList.setVisible(false);
        }


        rating.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                Storage.currentCustomer.getDietician().addRank((int)rating.getRating());
                Storage.currentCustomer.setRanked((int)rating.getRating());
                rating.setDisable(true);
                BinarySearchTreeForRanking binarySearchTreeForRanking = new BinarySearchTreeForRanking();
                Dietician[] orderedDieticians = binarySearchTreeForRanking.order();
                ObservableList<Dietician> oListDietician = FXCollections.observableArrayList(orderedDieticians);
                tableView.setItems(oListDietician);
            }
        });


        stage.setOnHiding( event -> {
            stage.hide();
            Platform.runLater(() -> new Main().start(new Stage()));
        });
        stage.show();
    }
}

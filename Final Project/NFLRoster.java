/**Program: MyFinalProject Program
 *File: NFLRoster.java
 *Summary: Program allows the user to choose an offense or defense roster, review players and their stats and remove
 * players from the listing.
 *Author: Mercedes Thigpen
 *Date: April 6, 2018
 **/

// This is my own work <Mercedes Thigpen> 

package MyFinalProject;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class NFLRoster extends Application {
    
    Stage window;
    Scene scene1, choiceScene, offenseScene, defenseScene;
    Button button1, button2, button3, button4, button5, button6, button7;
    Label label1, label2, label3;
    CheckBox oBox1;
    TableView<offensivePlayer> offTable;
    TableView<defensivePlayer> defTable;
    ObservableList<offensivePlayer> offensePlayer;
    ObservableList<defensivePlayer> defensePlayer;
   
    
public static void main(String[] args) {//Start of main method to launch program
        launch(args);
    }

 @Override
    public void start(Stage primaryStage) { //setting the stage for the opening window
        window = primaryStage;
        window.setTitle("Final Project"); // adding title to the window
        window.getIcons().add(new Image("/MyFinalProject/NFL Logo.png")); // adding icon to the window
        
        button1 = new Button("Pick Your Roster");//adding text and designing button for scene1
        button1.setFont(Font.font("System", 18));
        button1.setPrefSize(175, 63);
        button1.setOnAction(e -> window.setScene(choiceScene));//when button is pressed, opens to choiceScene
   
        
        label1= new Label("Mercedes Thigpen's NFL Roster");//adding text and designing label for scene1
        label1.setFont(Font.font("System", FontWeight.BOLD, 28));
        label1.setTextFill(Color.NAVY);//sets color of text
    
        // layout for scene1 //
        VBox layout = new VBox(); //vertical layout
        layout.setPadding(new Insets(30));//sets margins
        layout.setSpacing(20);//sets spacing between nodes
        layout.setAlignment(Pos.CENTER);//aligning all nodes to the center of the pane
        layout.getChildren().add(new ImageView("/MyFinalProject/cowboysheaderlarge.gif"));//adding image
        layout.getChildren().addAll(label1, button1);//adding nodes to scene1
        scene1 = new Scene(layout, 500, 400);//setting the pane size for scene1
        window.setScene(scene1);
        window.show();// opens and shows scene1
        
        
        // Set up for choiceScene //
        button2 = new Button("Offense");//adding text and designing button for offenseScene
        button2.setFont(Font.font("System", 18));
        button2.setOnAction(e -> window.setScene(offenseScene));//when button is pressed, opens to choiceScene
        button2.setPrefSize(125, 50);//sets button size
        
        button3 = new Button("Defense");//when button is pressed, opens to defenseScene
        button3.setFont(Font.font("System", 18));
        button3.setOnAction(e -> window.setScene(defenseScene));//when button is pressed, opens to choiceScene
        button3.setPrefSize(125, 50);//sets button size
        
        // choiceScene layout//
        HBox layout2 = new HBox(); //horizontal layout
        layout2.setSpacing(50); //spacing between nodes
        layout2.setPadding(new Insets(15, 12, 15, 12));//sets margins
        layout2.setAlignment(Pos.CENTER); //aligns all nodes to the center of the pane
        layout2.getChildren().add(button2); //adds button2 to choiceScene
        layout2.getChildren().add(new ImageView("/MyFinalProject/cowboysstar.png"));//adds image to choiceScene
        layout2.getChildren().add(button3); //adds button3 to choiceScene
        layout2.setBackground(new Background(new BackgroundFill(Color.NAVY, CornerRadii.EMPTY, Insets.EMPTY)));//adds background color to choiceScene
        choiceScene = new Scene(layout2, 600, 300); //sets size for the pane
        
      // Set up for offenseScene //
        button4 = new Button("Go To Defense");//adding text to button4
        button4.setOnAction(e -> window.setScene(defenseScene));//when button is pressed, opens defenseScene
        
        button5 = new Button("Remove from Roster");//adding text to button5
        button5.setOnAction(e -> deleteOffense()); //when button is pressed, removes selected players from roster
        
        label2 = new Label("Offense"); //adds text to label2
        label2.setFont(Font.font("Calibri", FontWeight.BOLD, 36)); //sets font and size, BOLD lettering
        label2.setTextFill(Color.NAVY);
        
        offTable = new TableView<>(); //creates table for offenseScene
        offTable.setItems(getOffense()); //items in offenseScene table will come from the getOffense method
        
        VBox vBox = new VBox(); //vertical layout
        vBox.setPadding(new Insets(15, 12, 15, 12)); //setting margins
        vBox.setSpacing(10); //spacing between nodes
        vBox.setAlignment(Pos.CENTER); //aligns all nodes to the center of the pane
        vBox.getChildren().addAll(label2, button4); //adding nodes to offenseScene
        vBox.getChildren().addAll(offTable, button5); //added table and button5 to the vertical layout
        vBox.getChildren().add(new ImageView("/MyFinalProject/cowboysheaderlarge.gif"));//adding image to offenseScene
        offenseScene = new Scene(vBox);
        
      // Set up for defenseScene //  
        button6 = new Button("Go To Offense"); //adding text to button6
        button6.setOnAction(e -> window.setScene(offenseScene));//when button is pressed, opens offenseScene
        
        button7 = new Button("Remove from Roster"); //adding text to button7
        button7.setOnAction(e -> deleteDefense()); //when button is pressed, removes selected players from roster
        
        
        label3 = new Label("Defense"); //adding text to label
        label3.setFont(Font.font("Calibri", FontWeight.BOLD, 36)); //sets font and size, BOLD lettering
        label3.setTextFill(Color.NAVY);
        
        defTable = new TableView<>(); //creates table for defenseScene
        defTable.setItems(getDefense()); //items in defenseScene table will come from the getDefense method
        
        VBox defBox = new VBox(); //vertical layout
        defBox.setPadding(new Insets(15, 12, 15, 12)); //setting margins
        defBox.setSpacing(10); //spacing between nodes
        defBox.setAlignment(Pos.CENTER); //aligns all nodes to the center of the pane
        defBox.getChildren().addAll(label3, button6); //adding nodes to defenseScene
        defBox.getChildren().addAll(defTable, button7); //adds table and button7 to defenseScene
        defBox.getChildren().add(new ImageView("/MyFinalProject/cowboysheaderlarge.gif")); //adding image to offenseScene
        defenseScene = new Scene(defBox, 530, 650);
        
        // Setup for columns for both tables //
        TableColumn selectColumn = new TableColumn<>("Select");
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        TableColumn pickColumn = new TableColumn<>("Select");
        pickColumn.setCellValueFactory(new PropertyValueFactory<>("pick"));
        
        TableColumn nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn positionColumn = new TableColumn<>("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        
        TableColumn yardsColumn = new TableColumn<>("Yards");
        yardsColumn.setCellValueFactory(new PropertyValueFactory<>("yards"));
        
        TableColumn receptionsColumn = new TableColumn<>("Receptions");
        receptionsColumn.setCellValueFactory(new PropertyValueFactory<>("receptions"));
        
        TableColumn touchdownsColumn = new TableColumn<>("Touchdowns");
        touchdownsColumn.setCellValueFactory(new PropertyValueFactory<>("touchdowns"));
        
       TableColumn tacklesColumn = new TableColumn<>("Tackles");
        tacklesColumn.setCellValueFactory(new PropertyValueFactory<>("tackles"));
        
        TableColumn sacksColumn = new TableColumn<>("Sacks");
        sacksColumn.setCellValueFactory(new PropertyValueFactory<>("sacks"));
        
        TableColumn interceptionsColumn = new TableColumn<>("Interceptions");
        interceptionsColumn.setCellValueFactory(new PropertyValueFactory<>("interceptions"));
        
        TableColumn namesColumn = new TableColumn<>("Name");
        namesColumn.setCellValueFactory(new PropertyValueFactory<>("names"));
        
        TableColumn positionsColumn = new TableColumn<>("Position");
        positionsColumn.setCellValueFactory(new PropertyValueFactory<>("positions"));
   
      
      //adds columns to offense table
      offTable.getColumns().addAll(selectColumn, nameColumn, positionColumn, yardsColumn, receptionsColumn, touchdownsColumn);
   
      //adds columns to defense table
      defTable.getColumns().addAll(pickColumn, namesColumn, positionsColumn, tacklesColumn, sacksColumn, interceptionsColumn);
      
}
    // Listing of player data to populate offense table from variables defined in offensivePlayer.java //
public ObservableList<offensivePlayer> getOffense(){
    
    offensePlayer = FXCollections.observableArrayList();
    
    offensePlayer.add(new offensivePlayer ("Dez Bryant", "Wide Receiver", 838, 69, 6));
    offensePlayer.add(new offensivePlayer ("Brice Butler", "Wide Receiver", 317, 15, 3));
    offensePlayer.add(new offensivePlayer ("Jason Witten", "Tight End", 560, 63, 5));
    offensePlayer.add(new offensivePlayer ("James Hanna", "Tight End", 88, 4, 1));
    offensePlayer.add(new offensivePlayer ("Tyron Smith", "Left Tackle", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("Chaz Green", "Left Tackle", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("Jonathan Cooper", "Left Guard", 838, 69, 6));
    offensePlayer.add(new offensivePlayer ("Travis Frederick", "Center", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("Joe Looney", "Center", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("Zack Martin", "Right Guard", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("La'el Collins", "Right Tackle", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("Byron Bell", "Right Tackle", 0, 0, 0));
    offensePlayer.add(new offensivePlayer ("Terrance Williams", "Wide Receiver 2", 568, 53, 0));
    offensePlayer.add(new offensivePlayer ("Noah Brown", "Wide Receiver 2", 33, 4, 0));
    offensePlayer.add(new offensivePlayer ("Dak Prescott", "Quarterback", 3324, 0, 22));
    offensePlayer.add(new offensivePlayer ("Cooper Rush", "Quarterback", 2, 0, 0));
    offensePlayer.add(new offensivePlayer ("Ezekiel Elliott", "Running Back", 983, 0, 7));
    offensePlayer.add(new offensivePlayer ("Alfed Morris", "Running Back", 872, 0, 5));
    offensePlayer.add(new offensivePlayer ("Keith Smith", "Full Back", 838, 69, 6));
    offensePlayer.add(new offensivePlayer ("Cole Beasley", "Wide Receiver 3", 314, 36, 4));
    offensePlayer.add(new offensivePlayer ("Ryan Switzer", "Wide Receiver 3", 41, 6, 0));

        return offensePlayer;
  
        }

// Listing of player data to populate defense table from variables defined in defensivePlayer.java //
public ObservableList<defensivePlayer> getDefense(){
    
    defensePlayer = FXCollections.observableArrayList();
    
    defensePlayer.add(new defensivePlayer ("", "", 58, 15, 0, "Demarcus Lawrence", "Defensive End (L)"));
    defensePlayer.add(new defensivePlayer ("", "", 21, 1, 1, "Benson Mayowa", "Defensive End (L)"));
    defensePlayer.add(new defensivePlayer ("", "", 22, 3, 0, "Maliek Collins", "Defensive Tackle"));
    defensePlayer.add(new defensivePlayer ("", "", 8, 0, 0, "Lewis Neal", "Defensive Tackle"));
    defensePlayer.add(new defensivePlayer ("", "", 22, 7, 0, "David Irving", "Defensive Tackle"));
    defensePlayer.add(new defensivePlayer ("", "", 27, 4, 0, "Tyrone Crawford", "Defensive End (R)"));
    defensePlayer.add(new defensivePlayer ("", "", 19, 3, 0, "Taco Charlton", "Defensive End (R)"));
    defensePlayer.add(new defensivePlayer ("", "", 35, 1, 0, "Damien Wilson", "Strongside Linebacker"));
    defensePlayer.add(new defensivePlayer ("", "", 10, 0, 0, "Kyle Wilber", "Strongside Linebacker"));
    defensePlayer.add(new defensivePlayer ("", "", 84, 0, 0, "Anthony Hitchens", "Middle Linebacker"));
    defensePlayer.add(new defensivePlayer ("", "", 81, 1, 0, "Jaylon Smith", "Middle Linebacker"));
    defensePlayer.add(new defensivePlayer ("", "", 101, 0, 1, "Sean Lee", "Weakside Linebacker"));
    defensePlayer.add(new defensivePlayer ("", "", 58, 15, 0, "Justin Durant", "Weakside Linebacker"));
    defensePlayer.add(new defensivePlayer ("", "", 54, 0, 1, "Jourdan Lewis", "Left Cornerback"));
    defensePlayer.add(new defensivePlayer ("", "", 2, 1, 0, "Bene Benwikere", "Left Cornerback"));
    defensePlayer.add(new defensivePlayer ("", "", 38, 0, 1, "Orlando Scandrick", "Right Cornerback"));
    defensePlayer.add(new defensivePlayer ("", "", 25, 0, 1, "Chidobe Awuzie", "Right Cornerback"));
    defensePlayer.add(new defensivePlayer ("", "", 71, 0, 3, "Jeff Heath", "Safety"));
    defensePlayer.add(new defensivePlayer ("", "", 33, 0, 0, "Kavon Frazier", "Safety"));    
        
        return defensePlayer;
}
// Method to remove offense players from table //
public void deleteOffense(){
    ObservableList<offensivePlayer> offensePlayerRemove = FXCollections.observableArrayList();
    offensePlayer.stream().filter((bean) -> (bean.getSelect().isSelected())).forEachOrdered((bean) -> {
        offensePlayerRemove.add(bean); //function assignment suggested by IDE. When the button is pressed, 
        }); // a player will be deleted from the roster if their Checkbox is selected.
        offensePlayer.removeAll(offensePlayerRemove);
}

// Method to remove defense players from table //
public void deleteDefense(){
    ObservableList<defensivePlayer> defensePlayerRemove = FXCollections.observableArrayList();
    defensePlayer.stream().filter((bean) -> (bean.getPick().isSelected())).forEachOrdered((bean) -> {
        defensePlayerRemove.add(bean);//function assignment suggested by IDE. When the button is pressed, 
        }); // a player will be deleted from the roster if their Checkbox is selected.
        defensePlayer.removeAll(defensePlayerRemove);}
} 
// End of Program
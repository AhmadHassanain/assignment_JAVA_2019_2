/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

/**
 *
 * @author Ahmad
 */
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;



public class File_view extends Application {
    
    MenuBar MenuBr = new MenuBar();
    Menu MenuFile = new Menu("File");
    Menu MenuEdit = new Menu("Edit");
    
    MenuItem ItemOpen = new MenuItem("_Open");
    MenuItem ItemClose = new MenuItem("_Close");
    MenuItem ItemExit = new MenuItem("E_xit");
    MenuItem ItemFont = new MenuItem("_Font");
    MenuItem ItemColor = new MenuItem("Co_lor");
     File  SelectedFile;
     
    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane theBorderPane = new BorderPane();

        TextArea text =new TextArea();
        text.setPrefSize(350,280);
        text.setEditable(false);
       text.setFont(Font.font("Verdana", FontWeight.BOLD,14));
      
        MenuBr.getMenus().addAll(MenuFile, MenuEdit);
    
        MenuFile.getItems().add(ItemOpen);
        MenuFile.getItems().add(ItemClose);
        MenuFile.getItems().add(ItemExit);
        
        MenuEdit.getItems().add(ItemFont);
        MenuEdit.getItems().add(ItemColor);
        
        MenuBr.setPrefWidth(400);
        theBorderPane.setTop(MenuBr);

        ScrollPane scrollPane = new ScrollPane(text);
        scrollPane.setPrefSize(300, 300);
        scrollPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-focus-color: transparent;");

         theBorderPane.setCenter(scrollPane);
       Scene scene=new Scene(theBorderPane,350,320);
         
       stage.setScene(scene);
       stage.setTitle("File View");
       stage.show();
        ItemOpen.setOnAction((ActionEvent e) -> {
            
                  FileChooser fileChooser = new FileChooser(); 
                  ExtensionFilter filter = new ExtensionFilter(".txt", "txt");
                  fileChooser.setSelectedExtensionFilter(filter);
                  SelectedFile  =fileChooser.showOpenDialog(stage);
                 
              
              try {
                   if (SelectedFile!=null) {
                      
                       Scanner Scanner;
                      
                          Scanner = new Scanner(SelectedFile);
                     
                       text.setText("");
                       while(Scanner.hasNextLine()){
                            text.appendText(Scanner.nextLine()+"\n");
                         
                        }
                       System.out.println("Open File and write True.");
                    }
		    text.setEditable(true);
                } catch (FileNotFoundException ex) {
                          Logger.getLogger(File_view.class.getName()).log(Level.SEVERE, null, ex);
                      }
        });
        ItemClose.setOnAction((ActionEvent e) -> {
         
           text.setText("");
           text.setEditable(false);
            System.out.println("Close True.");
        });
        
        ItemExit.setOnAction((ActionEvent e) -> {
            
            System.out.println("Exit True");
		System.exit(0);
        });
        
        ItemFont.setOnAction((ActionEvent e) -> {
            
                  int x=fontSize();
                    text.setFont(Font.font("Verdana", FontWeight.BOLD,x));
              System.out.println("Font Size Text :"+x+ " \n in true ");
        });
        ItemColor.setOnAction((ActionEvent e) -> {
            String x=color();
            text.setStyle("-fx-text-fill:"+x+";");
        });
        
       
    }
       
    public static void main(String[] args) {
        launch(args);
    }
    public static  int fontSize(){
       String [] fontsize={"8", "14", "18", "24", "30", "37", "48", "60", "68","75", "82","90"};
       
       ChoiceDialog d = new ChoiceDialog(fontsize[1], fontsize); 
      
       Optional<String> Auswahl = d.showAndWait();
       if (Auswahl.isPresent()) {
           int x=Integer.parseInt(Auswahl.get());
           return x;
       }
       return 14; 
       }
    
    
    public static  String color(){
       String [] fontsize={"red", "blue", "green", "black","Cyan","DarkGray","Gray"};
       ChoiceDialog d = new ChoiceDialog(fontsize[1], fontsize); 
      
       Optional<String> Auswahl = d.showAndWait();
       if (Auswahl.isPresent()) {
           String x=Auswahl.get();
           return x;
       }
       return "Black"; 
       }
}
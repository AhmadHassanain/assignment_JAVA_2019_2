/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class multiple_selection extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
    
       FlowPane pane=new FlowPane();
        
        pane.setPadding(new Insets(10,10,20,10));
         pane.setHgap(10);
         pane.setVgap(10);
        ObservableList<String> List = FXCollections.<String>observableArrayList("Black","Blue",
                "Cyan","Dark Gray","Gray","Green");
       
        ListView<String> ListView=new ListView<>();
        ListView.setItems(List);
        ListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ScrollPane scroll=new ScrollPane();
        scroll.setContent(ListView);
        scroll.setPrefSize(130, 150);
        scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
       pane.getChildren().add(scroll);
       Button button=new Button("Copy>>>");
          
        pane.getChildren().add(button);

       TextArea textArea =new TextArea();
       textArea.setPrefSize(130, 150);
       pane.getChildren().add(textArea);

       button.setOnAction(new EventHandler<ActionEvent>() {
          @Override
           public void handle(ActionEvent e) {
               String lister="";
                for (int i = 0; i < ListView.getSelectionModel().getSelectedItems().size(); i++) {
                  lister=lister+ListView.getSelectionModel().getSelectedItems().get(i)+"\n";
              }
              
              
              textArea.setText(lister);
           }
       });

       Scene scene=new Scene(pane,380,180);
      
       stage.setScene(scene);
       stage.setTitle("Multiple Selection Lists");
       stage.show();
       
    }
       
    public static void main(String[] args) {
        launch(args);
    }
}
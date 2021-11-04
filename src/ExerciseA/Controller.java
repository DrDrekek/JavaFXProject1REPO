package ExerciseA;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
   @FXML
   private ComboBox<String> combo_box;
   @FXML
   private Pane pane_code;
   @FXML
   private TextField x;
   @FXML
   private TextField y;
   @FXML
   private Slider slider_1;

   private final String[] choices = {"White", "Gray", "Blue"};
   private Alert.AlertType type = Alert.AlertType.INFORMATION;
   private Alert alertwindow = new Alert(type,"");

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      combo_box.getItems().addAll(choices);
      combo_box.setOnAction(this::paneChangeBackground);
   }
   private void paneChangeBackground(javafx.event.ActionEvent actionEvent) {
      String choice = combo_box.getValue();
      switch (choice) {
         case "White"-> pane_code.setStyle("-fx-background-color: #ebeaea");
         case "Gray" -> pane_code.setStyle("-fx-background-color: #7b7777");
         case "Blue" -> pane_code.setStyle("-fx-background-color: #8ee4f7");

      }
   }
   public void mouseClick(MouseEvent e){
      Circle circle = new Circle((int)e.getSceneX(),(int)e.getSceneY(),20, Color.BLUE);
      pane_code.getChildren().add(circle);
   }
   public void btnDraw(){
      double width = pane_code.getWidth()-10;
      double height = pane_code.getHeight()-10;
      if(height>=Double.parseDouble(y.getText())&&width>=Double.parseDouble(x.getText())){
         pane_code.getChildren().add(new Circle(Integer.parseInt(x.getText()),Integer.parseInt(y.getText()),(int)slider_1.getValue()));
      }
      else {
         alertwindow.getDialogPane().setContentText("Do not draw outside of height(y):"+height+" and width(x):"+width);
         alertwindow.getDialogPane().setHeaderText("Error! Can't draw out of bounds.");
         alertwindow.setTitle("input error");
         alertwindow.showAndWait();
      }
   }
   public void btnClear(){
      pane_code.getChildren().clear();
   }
}

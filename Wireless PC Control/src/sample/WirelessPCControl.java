/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class WirelessPCControl extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {



        //Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("MainScreen.fxml")
        );
        Parent root = (Parent) fxmlLoader.load();
        MainScreenController mainScreenController = 
                (MainScreenController) fxmlLoader.getController();
        mainScreenController.setMainScreenController(mainScreenController);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("WirelessPCControl");
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });

        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

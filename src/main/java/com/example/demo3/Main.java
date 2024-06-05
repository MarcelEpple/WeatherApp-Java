package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // override the "start()" method of the "Application" class, which defines the initial stage for the application
        // Overriding is when a child class has its method implementation for the method already present in the parent class

        Parent root = FXMLLoader.load(getClass().getResource("Design.fxml"));

        // load the FXML file which specifies the layout and components of the user interface
        // FXMLLoader is a class in JavaFX that is used to load user interface layouts from FXML files.
        // getClass() is a method that returns the Class object that represents the class of the current object.
        // getResource() is a method that loads a resource (in this case, the FXML file) from the classpath.

        primaryStage.setTitle("Praktikum Aufgabe 2");
        // set the title of the primary stage of the application to "Praktikum Aufgabe 2"

        primaryStage.setScene(new Scene(root));
        // set the scene of the primary stage to a new "Scene" object
        // The individual items held within the JavaFX scene graph are known as nodes. Each node is classified as either a branch node (meaning that it can have children), or a leaf node (meaning that it cannot have children). The first node in the tree is always called the root node, and it never has a parent.

        primaryStage.show();
        // display the primary stage of the application
    }
}



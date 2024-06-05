package com.example.demo3;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableContent {
    private SimpleStringProperty name;
    // declares a private instance variable for the name property of type SimpleStringProperty
    private SimpleStringProperty value;
    // declares a private instance variable for the value property of type SimpleDoubleProperty

    public TableContent(String name, String value) {
        // constructor that initializes the name and value properties of the TableContent object
        this.name = new SimpleStringProperty(name);
        // initializes the name property with the provided value using SimpleStringProperty
        this.value = new SimpleStringProperty(value);
        // initializes the value property with the provided value using SimpleDoubleProperty
    }


    public String getName() {
        // getter method for the name property
        return name.get();
    }

    public void setName(String name) {
        // setter method for the name property
        this.name.set(name);
    }



    public SimpleStringProperty nameProperty() {
        // getter method for the name property as a SimpleStringProperty object
        return name;
    }


    public String getValue() {
        // getter method for the value property
        return value.get();
    }

    public void setValue(String value) {
        // setter method for the value property
        this.value.set(value);
    }


    public SimpleStringProperty valueProperty() {
        // getter method for the value property as a SimpleDoubleProperty object
        return value;
    }
}

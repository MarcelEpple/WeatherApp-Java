package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class Controller {

    @FXML
    private Button buttonSend;

    @FXML
    private TableColumn<TableContent, String> columnName;

    @FXML
    private TableColumn<TableContent, String> columnValue;

    @FXML
    private ComboBox<String> comboBoxResponse;

    @FXML
    private Label labelParameters;

    @FXML
    private Label labelResponse;

    @FXML
    private Label labelURL;

    @FXML
    private TableView<TableContent> tableView;

    @FXML
    private TextArea textAreaResponse;

    @FXML
    private TextField textFieldURL;



    @FXML
    public void btnSendClicked() throws IOException {
        String urlStr2 = textFieldURL.getText();
        //API CALL
        String APIresponse = IOUtils.toString(new URL(urlStr2), StandardCharsets.UTF_8);
        //Call Logger and create log file with log
        APILogger.log(urlStr2);
        String[] latLon = APIcallLatLon.getLatLon(urlStr2);
        // use the URLparser class to validate and extract the base URL and AppID
        String[] result = URLparser.validateURL(urlStr2);

        TableContent content1 = new TableContent("Base URL", result[0]);
        TableContent content2 = new TableContent("AppID", result[1]);
        TableContent content3 = new TableContent("Exclude", result[2]);
        TableContent content4 = new TableContent("Latitude", latLon[0]);
        TableContent content5 = new TableContent("Longitude", latLon[1]);

        //Paste Base Url in Textfield
        textFieldURL.setText(result[0]);

        // Sets up how the data in a table view will be displayed in two columns, "columnName" and "columnValue".
        // Sets how the date will be displayed and binds properties of data to the calls in cName & cValue
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnValue.setCellValueFactory(cellData -> cellData.getValue().valueProperty());

        // add the extracted data to the table
        tableView.getItems().clear();
        tableView.getItems().addAll(content1, content2, content3, content4, content5);

        //Gson Pretty Print class called. Returns Answer String
        String answer = gsonPrettyPrint.getPrettyJson(urlStr2);
        textAreaResponse.setText(answer);

        // Call the getChildren() method of the JsonParser class and print the children to the console
        List<String> childrenList = List.of(JsonParse.getChildren(APIresponse));
        String[] children = childrenList.toArray(new String[0]);
        for (String child : children) {
            comboBoxResponse.getItems().add(child);
        }


        comboBoxResponse.setOnAction((ActionEvent event) -> {
            String selectedOption = comboBoxResponse.getSelectionModel().getSelectedItem();
            System.out.println("Selected option: " + selectedOption);
            ComboBoxSelection comboboxselection = new ComboBoxSelection();

            //ComboBoxSelection selection = new ComboBoxSelection(selectedOption);
            String value = comboboxselection.getValue(selectedOption, APIresponse);
            textAreaResponse.setText(value);
        });

    }

    @FXML
    public void keyTyped(KeyEvent event) {
        // This code will be executed every time the user types a key in the text field
        String urlStr2 = textFieldURL.getText();
        boolean isValid = URLValidator.isValidURL(urlStr2);
        if (isValid == true) {
            buttonSend.setDisable(false);
        }
        if (isValid == false) {
            buttonSend.setDisable(true);
        }
    }

    @FXML
    public void initialize() {
        textFieldURL.setOnKeyTyped(this::keyTyped);

    }
}

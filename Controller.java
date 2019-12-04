package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.Arrays;

public class Controller {
    private String[][] Dictionary;
    private String[][] Dictionary2;
    private int[] result2 = {0, 0};
    private int result = 0;
    private int time = 0;
    private int time2 = 0;
    private String word;
    private int count = 0;
    private ObservableList<TableData> tableData = FXCollections.observableArrayList();
    private ObservableList<TableData> tableData2 = FXCollections.observableArrayList();
    @FXML
    private TableView<TableData> tbData;
    @FXML
    public TableColumn<TableData, Integer> ID;
    @FXML
    public TableColumn<TableData, String> Bin;
    @FXML
    public TableColumn<TableData, String> Seq;
    @FXML
    private TableView<TableData> tbData2;
    @FXML
    public TableColumn<TableData, Integer> ID2;
    @FXML
    public TableColumn<TableData, String> Bin2;
    @FXML
    public TableColumn<TableData, String> Seq2;
    @FXML
    public Text Definition = new Text();
    @FXML
    public TextField input = new TextField();
    @FXML
    public void initialize() {
        Dictionary = Methods.populate();
        Dictionary2 = Methods.Sort(Dictionary);
        Seq.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Bin.setCellValueFactory(new PropertyValueFactory<>("Seq"));
        ID.setCellValueFactory(new PropertyValueFactory<>("Bin"));
        Seq2.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Bin2.setCellValueFactory(new PropertyValueFactory<>("Seq"));
        ID2.setCellValueFactory(new PropertyValueFactory<>("Bin"));
        tbData.setItems(tableData);
        tbData2.setItems(tableData2);
    }

    public void onEnter(ActionEvent actionEvent) {
        word = input.getText();
        long startTime = System.nanoTime();
        result = Methods.SeqSearch(Dictionary, word);
        long timeElapsed = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        result2 = Methods.BinSearch(Dictionary2, word);
        long timeElapsed2 = System.nanoTime() - startTime;
        Definition.setText(Dictionary[1][result]);
        Definition.setTextAlignment(TextAlignment.CENTER);
        count++;
        tableData.add(new TableData((result+1), (result2[1]-1), count));
        tableData2.add(new TableData((int) timeElapsed, (int) timeElapsed2, count));
    }
}

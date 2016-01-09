import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


/**
 * Näitena on kasutatud Oraclei tabel koodi https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
 */


public class Tabel2 {
    static VBox vBox = new VBox();
    static HBox hb = new HBox();
    public static TableView<Person> table = new TableView<>();
    public ObservableList<Person> data = FXCollections.observableArrayList();
    static String n;
    private IntegerProperty index = new SimpleIntegerProperty();
    public Insuliin x = new Insuliin ();

    public Tabel2() {
        LoeXML a = new LoeXML();
        data = a.getAndmed();
        table.setItems(data);
        setupStage();
    }

    private void kustuta() {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            table.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }

    private void setupStage() {


        table.setEditable(true);

        Callback<TableColumn<Person, String>,
                TableCell<Person, String>> cellFactory
                = (TableColumn<Person, String> p) -> new EditingCell();

        TableColumn<Person, String> toitCol = new TableColumn<>("Toit");
        toitCol.setMinWidth(100);
        toitCol.setCellValueFactory(
                new PropertyValueFactory<>("toit"));
        toitCol.setCellFactory(cellFactory);
        toitCol.setOnEditCommit(
                (CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setToit(t.getNewValue());
                });

        TableColumn<Person, String> kogusCol = new TableColumn<>("Kogus");
        kogusCol.setMinWidth(100);
        kogusCol.setCellValueFactory(
                new PropertyValueFactory<>("kogus"));
        kogusCol.setCellFactory(cellFactory);
        kogusCol.setOnEditCommit(
                (CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setKogus(t.getNewValue());
                });

        TableColumn<Person, String> yhikCol =  new TableColumn<>("Ühik");
        yhikCol.setMinWidth(100);
        yhikCol.setCellValueFactory(
                new PropertyValueFactory<>("yhik"));
        yhikCol.setCellFactory(cellFactory);
        yhikCol.setOnEditCommit(
                (CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYhik(t.getNewValue());
                });

        table.setItems(data);
        table.getColumns().addAll(toitCol, kogusCol, yhikCol);



        final TextField addToit = new TextField();
        addToit.setPromptText("Toit");
        addToit.setMaxWidth(toitCol.getPrefWidth());
        //addToit.setText("kala");
        final TextField addKogus = new TextField();
        addKogus.setMaxWidth(kogusCol.getPrefWidth());
        addKogus.setPromptText("Kogus");
        //addKogus.setText("100");
        final TextField addYhik = new TextField();
        addYhik.setMaxWidth(yhikCol.getPrefWidth());
        addYhik.setPromptText("Ühik");
        //addYhik.setText("g");



        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Person(
                            addToit.getText(),
                            addKogus.getText(),
                            addYhik.getText())

            );

            addToit.clear();
            addKogus.clear();
            addYhik.clear();
            KirjutaXML.write(data);



        });



        final Button deleteButton = new Button("Kustuta");
        deleteButton.setOnAction((ActionEvent e) -> {
            kustuta();
            KirjutaXML.write(data);
        });

        hb.getChildren().addAll(addToit, addKogus, addYhik, addButton,deleteButton);
        hb.setSpacing(3);

        vBox.setSpacing(5);

        vBox.getChildren().addAll(table, hb);



    }



    class EditingCell extends TableCell<Person, String> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());

                    }
                    setText(null);
                    setGraphic(textField);

                } else {
                    setText(getString());
                    setGraphic(null);
                    KirjutaXML.write(data);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.focusedProperty().addListener(
                    (ObservableValue<? extends Boolean> arg0,
                     Boolean arg1, Boolean arg2) -> {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                    });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }



}
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Tabel extends Application {


    private final TableView<Person> table = new TableView<>();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                   /* new Person("Kartul", "20", "tk"),
                    new Person("Liha", "50", "tk"),
                    new Person("Kaste", "10", "g"),
                    new Person("Leib", "25", "viil"),
                    new Person("Mahl", "15", "klaas 200 ml")
                    */
            );


    public ObservableList<Person> data() {
        return data;
    }

    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(new Group());
        stage.setTitle("Toidu tabel");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Toidu tabel");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        Callback<TableColumn<Person, String>,
                TableCell<Person, String>> cellFactory
                = (TableColumn<Person, String> p) -> new EditingCell();

        TableColumn<Person, String> toitCol =
                new TableColumn<>("Toit");
        TableColumn<Person, String> kogusCol =
                new TableColumn<>("Kogus");
        TableColumn<Person, String> yhikCol =
                new TableColumn<>("Ühik");

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

        yhikCol.setMinWidth(50);
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
        addToit.setText("kala");
        final TextField addKogus = new TextField();
        addKogus.setMaxWidth(kogusCol.getPrefWidth());
        addKogus.setPromptText("Kogus");
        addKogus.setText("100");
        final TextField addYhik = new TextField();
        addYhik.setMaxWidth(yhikCol.getPrefWidth());
        addYhik.setPromptText("Ühik");
        addYhik.setText("g");


        String toit;
        String kogus;
        String yhik;

        toit = addToit.getText();
        kogus = addKogus.getText();
        yhik = addYhik.getText();

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Person(
                            addToit.getText(),
                            addKogus.getText(),
                            addYhik.getText())
            );
            System.out.println(toit);
            addToit.clear();
            addKogus.clear();
            addYhik.clear();
            WriteXMLFile.write(data);

        });

        hb.getChildren().addAll(addToit, addKogus, addYhik, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
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
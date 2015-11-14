import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//http://docs.oracle.com/javafx/2/ui_controls/table-view.htm

public class ToiduTabel extends Application {



    @Override
    public void start(Stage lava) throws Exception {

        TableView tabel = new TableView();
        ObservableList<Andmed> data = FXCollections.observableArrayList(

                new Andmed("Kartul", "20", "tk"),
                new Andmed("Liha", "50", "tk"),
                new Andmed("Kaste", "10", "g"),
                new Andmed("Leib", "25", "viil"),
                new Andmed("Mahl", "15", "klaas 200 ml")
        );

// Pealkiri!

        Label label = new Label("TOIDU SÜSIVESIKUD");
        label.setFont(new Font("Arial", 20));

// Tabeli veergune nimetamine
        tabel.setEditable(true);

        TableColumn toit = new TableColumn("Toit"); // loob Tabeli veeru toit
        toit.setMinWidth(100);
        toit.setCellValueFactory(                       //
                new PropertyValueFactory<Andmed,String>("toit")
        );toit.setCellFactory(TextFieldTableCell.forTableColumn());
        toit.setOnEditCommit(
                new EventHandler<CellEditEvent<Andmed, String>>() {
                    @Override
                    public void handle(CellEditEvent<Andmed, String> t) {
                        ((Andmed) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setToit(t.getNewValue());
                    }
                }
        );


        TableColumn sysivesikud = new TableColumn("SÜ");
        sysivesikud.setMinWidth(50);
        sysivesikud.setCellValueFactory(
                new PropertyValueFactory<Andmed, Integer>("susivesikud")
        );
        sysivesikud.setCellFactory(TextFieldTableCell.forTableColumn());
        sysivesikud.setOnEditCommit(
                new EventHandler<CellEditEvent<Andmed, String>>() {
                    @Override
                    public void handle(CellEditEvent<Andmed, String> t) {
                        ((Andmed) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setSusivesikud(t.getNewValue());
                    }
                }
        );
        TableColumn yhik = new TableColumn("Ühik");
        yhik.setMinWidth(20);
        yhik.setCellValueFactory(
                new PropertyValueFactory<Andmed, String>("ühik")
        );
        yhik.setCellFactory(TextFieldTableCell.forTableColumn());
        yhik.setOnEditCommit(
                new EventHandler<CellEditEvent<Andmed, String>>() {
                    @Override
                    public void handle(CellEditEvent<Andmed, String> t) {
                        ((Andmed) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setUhik(t.getNewValue());
                    }
                }
        );
        //TableColumn firstEmailCol = new TableColumn("Primary");
        //TableColumn secondEmailCol = new TableColumn("Secondary");
        //secondEmailCol.setVisible(true);

        //yhik.getColumns().addAll(firstEmailCol, secondEmailCol);
        tabel.setItems(data);                                                                                               // lisab andemd "data" tabeli "table" k�lge
        tabel.getColumns().addAll(toit, sysivesikud, yhik);


// Allpool osas Vbox uue kliendi lisamine
        final TextField addToit = new TextField();
        addToit.setPromptText("Toidu nimetus");
        addToit.setMaxWidth(toit.getPrefWidth());
        final TextField addSysivesikud = new TextField();
        addSysivesikud.setMaxWidth(sysivesikud.getPrefWidth());
        addSysivesikud.setPromptText("Süsivesikute hulk");
        final TextField addYhik = new TextField();
        addYhik.setMaxWidth(yhik.getPrefWidth());
        addYhik.setPromptText("Ühik");

        final Button lisaNupp = new Button("Lisa");
        lisaNupp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Andmed(
                        addToit.getText(),
                        addSysivesikud.getText(),
                        addYhik.getText()
                ));
                addToit.clear();
                addSysivesikud.clear();
                addYhik.clear();
            }
        });


        final HBox hb = new HBox();
        hb.setSpacing(3);
        hb.getChildren().addAll(addToit, addSysivesikud, addYhik, lisaNupp);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, tabel, hb);

        // lava loomine
        Scene scene = new Scene(new Group()); // keegi v�iks seletada, mida selline "new Group()" kasutamine t�hendab?
        lava.setTitle("Toitude süsivesikute sisaldamise tabel");
        //stage.setWidth(450);
        //stage.setHeight(550);
        ((Group) scene.getRoot()).getChildren().addAll(vbox); // ja keegi seletaks siin mida see "((Group) scene.getRoot())" teeb v�i kuidas seda meie �pituga kirjeldada.
        lava.setScene(scene);
        lava.show();
    }
    public static class Andmed {
        private final SimpleStringProperty toit; // neid oleks ka vaja lahti seletada
        private final SimpleStringProperty susivesik;
        private final SimpleStringProperty uhik;

        private Andmed (String toiduTingimus, String susivesikuTingimus, String uhikuTingimus) {
            this.toit = new SimpleStringProperty(toiduTingimus); // ja samuti neid
            this.susivesik = new SimpleStringProperty(susivesikuTingimus);
            this.uhik = new SimpleStringProperty(uhikuTingimus);
        }

        public String getToit() {
            return toit.get();
        }
        public void setToit(String toiduTingimus) {
            toit.set(toiduTingimus);
        }

        public String getSusivesik() {
            return susivesik.get();
        }
        public void setSusivesikud(String susivesikuTingimus) {
            susivesik.set(susivesikuTingimus);
        }

        public String getUhik() {
            return uhik.get();
        }
        public void setUhik(String uhikuTingimus) {
            uhik.set(uhikuTingimus);
        }

    }
}

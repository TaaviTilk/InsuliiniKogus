import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * Created by Taavi Tilk on 30.12.2015.
 */
public class PoolitaAken {
    static Stage lava = new Stage();;
    static Tabel2 tabel2;
    static Scene scene;
    static SplitPane splitPane;

    public PoolitaAken() {

        setupScene();
        //setupClose();
    }

    private void setupScene() {

        splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        scene = new Scene(splitPane, 800, 600);

        Insuliin insuliin = new Insuliin();
        tabel2 = new Tabel2();

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        tab1.setText("Toidud");
        tab2.setText("Kasutajad");
        tab1.setContent(tabel2);
        tabPane.getTabs().addAll(tab1, tab2);

        splitPane.getItems().addAll(insuliin.vBox, tabel2.vBox);
        splitPane.setDividerPositions(0.5f);

        lava.setScene(scene);
        lava.setTitle("ülemine ja alumine");
        lava.show();

    }


}

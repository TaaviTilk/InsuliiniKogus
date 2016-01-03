import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

/**
 * Created by Taavi Tilk on 30.12.2015.
 */
public class SplitWindow {
    static Stage lava = new Stage();;

    static Scene scene;
    static SplitPane splitPane;

    public SplitWindow() {

        setupScene();
        //setupClose();
    }

    private void setupScene() {

        splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);
        scene = new Scene(splitPane, 800, 600);

        Insuliin insuliin = new Insuliin();
        Tabel2 tabel = new Tabel2();

        splitPane.getItems().addAll(insuliin.vBox, tabel.vBox);
        splitPane.setDividerPositions(0.5f);

        lava.setScene(scene);
        lava.setTitle("ülemine ja alumine");
        lava.show();

    }


}

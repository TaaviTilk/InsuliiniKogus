import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

/**
 * Created by Taavi Tilk on 30.12.2015.
 */
public class MainWindow{
    static Stage lava = new Stage();;

    static Scene scene;
    static SplitPane splitPane;

    public MainWindow() {

        setupScene();
        //setupClose();
    }

    private void setupScene() {

        splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);
        scene = new Scene(splitPane, 800, 600);

        Ylemine ylemine = new Ylemine();
        Keskmine keskmine = new Keskmine();

        splitPane.getItems().addAll(ylemine.vb, keskmine.hBox);
        splitPane.setDividerPositions(0.5f);

        lava.setScene(scene);
        lava.setTitle("ülemine ja alumine");
        lava.show();

    }


}

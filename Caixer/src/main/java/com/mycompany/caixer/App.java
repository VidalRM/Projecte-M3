package com.mycompany.caixer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static String idioma="";
    
    public static ArrayList<compte> compteE = new ArrayList<>();
    
    private static Stage stageLocal;

    @Override
    public void start(Stage stage) throws IOException {
        stageLocal = stage;
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
    }
    
    static void almacenaUsuarios() {
        compteE.add(new compte("vidal", "1234", 6000));
        compteE.add(new compte("paco", "1234", 3000));
        compteE.add(new compte("asd", "asd", 1000));

    }
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stageLocal.sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

    }

    public static compte inicia;

}

package com.mycompany.caixer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static String idioma="";
    
    private static Stage stageLocal;

    @Override
    public void start(Stage stage) throws IOException {
        stageLocal = stage;
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();
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
        movimientos.cargarMovs();
        compte.cargarDatos();
        launch();

    }

    public static compte inicia;

}

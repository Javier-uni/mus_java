package main.java.mus.gui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class InterfazMusFX extends Application {

    private TextField[] camposCarta = new TextField[4];
    private ImageView[] imagenesCarta = new ImageView[4];
    private TextArea areaResultado;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        // Entrada de cartas
        HBox cartasInput = new HBox(10);
        cartasInput.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
            camposCarta[i] = new TextField();
            camposCarta[i].setPromptText("Carta " + (i + 1));
            camposCarta[i].setPrefWidth(80);
            cartasInput.getChildren().add(camposCarta[i]);
        }

        // Imágenes
        HBox cartasGraficas = new HBox(10);
        cartasGraficas.setAlignment(Pos.CENTER);
        for (int i = 0; i < 4; i++) {
            imagenesCarta[i] = new ImageView();
            imagenesCarta[i].setFitWidth(80);
            imagenesCarta[i].setFitHeight(120);
            cartasGraficas.getChildren().add(imagenesCarta[i]);
        }

        // Botón calcular
        Button calcularBtn = new Button("Calcular probabilidades");
        calcularBtn.setOnAction(e -> procesarCartas());

        // Área de salida
        areaResultado = new TextArea();
        areaResultado.setEditable(false);
        areaResultado.setPrefHeight(150);

        root.getChildren().addAll(new Label("Introduce las cartas (Ej: AsOros, 3Copas...)"), cartasInput, cartasGraficas, calcularBtn, areaResultado);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Probabilidades Mus - Combinatoria de Mano");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void procesarCartas() {
        try {
            String[] entradas = new String[4];
            for (int i = 0; i < 4; i++) {
                entradas[i] = camposCarta[i].getText().trim();
                // Asignar imagen si las tienes
                String path = "/cartas/" + entradas[i] + ".png"; // Ej: /cartas/AsOros.png
                Image img = new Image(getClass().getResourceAsStream(path));
                imagenesCarta[i].setImage(img);
            }

            // Suponiendo que tienes algo como:
            // public static List<Double> combinatoriaDeMano(String c1, String c2, String c3, String c4)
            List<Double> resultados = combinatoria.combinatoriaDeMano(entradas[0], entradas[1], entradas[2], entradas[3]);

            areaResultado.clear();
            areaResultado.appendText("Probabilidades estimadas:\n");
            areaResultado.appendText("Grande: " + resultados.get(0) + "\n");
            areaResultado.appendText("Chica: " + resultados.get(1) + "\n");
            areaResultado.appendText("Pares: " + resultados.get(2) + "\n");
            areaResultado.appendText("Juego: " + resultados.get(3) + "\n");

        } catch (Exception e) {
            areaResultado.setText("Error procesando cartas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

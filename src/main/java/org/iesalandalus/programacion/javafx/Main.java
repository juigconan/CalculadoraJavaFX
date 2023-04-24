package org.iesalandalus.programacion.javafx;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.javafx.css.LocalizadorRecursos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	TextField tfCabecera = new TextField();

	Button bt1 = new Button("1");
	Button bt2 = new Button("2");
	Button bt3 = new Button("3");
	Button bt4 = new Button("4");
	Button bt5 = new Button("5");
	Button bt6 = new Button("6");
	Button bt7 = new Button("7");
	Button bt8 = new Button("8");
	Button bt9 = new Button("9");
	Button bt0 = new Button("0");
	Button btMas = new Button("+");
	Button btMenos = new Button("-");
	Button btDividir = new Button("/");
	Button btMultiplicar = new Button("X");
	Button btIgual = new Button("=");
	Button btClear = new Button("C");
	boolean igualPulsado = false;
	List<Integer> numeros = new ArrayList<>();
	List<Character> simbolos = new ArrayList<>();
	int total = 0;

	private void mostrarCabecera(ActionEvent e) {
		if (igualPulsado) {
			tfCabecera.clear();
			igualPulsado = false;
		}
		if (e.getSource() == bt0) {
			tfCabecera.appendText("0");
		} else if (e.getSource() == bt1) {
			tfCabecera.appendText("1");
		} else if (e.getSource() == bt2) {
			tfCabecera.appendText("2");
		} else if (e.getSource() == bt3) {
			tfCabecera.appendText("3");
		} else if (e.getSource() == bt4) {
			tfCabecera.appendText("4");
		} else if (e.getSource() == bt5) {
			tfCabecera.appendText("5");
		} else if (e.getSource() == bt6) {
			tfCabecera.appendText("6");
		} else if (e.getSource() == bt7) {
			tfCabecera.appendText("7");
		} else if (e.getSource() == bt8) {
			tfCabecera.appendText("8");
		} else if (e.getSource() == bt9) {
			tfCabecera.appendText("9");
		} else if (e.getSource() == btMas) {
			tfCabecera.appendText(" + ");
			simbolos.add('+');
		} else if (e.getSource() == btMenos) {
			tfCabecera.appendText(" - ");
			simbolos.add('-');
		} else if (e.getSource() == btMultiplicar) {
			tfCabecera.appendText(" X ");
			simbolos.add('X');
		} else if (e.getSource() == btDividir) {
			tfCabecera.appendText(" / ");
			simbolos.add('/');
		} else if (e.getSource() == btClear) {
			tfCabecera.clear();
		} else if (e.getSource() == btIgual) {
			tfCabecera.setText(calculos());
			simbolos.clear();
			igualPulsado = true;
		} else {
			throw new IllegalArgumentException("ERROR: Botón no válido.");
		}
	}

	private void conseguirNumeros() {
		
		if (tfCabecera.getText().length() != 0) {
			String[] listaNumeros = tfCabecera.getText().split(" [+-/X] ");
			for (String numero : listaNumeros) {
				numeros.add(Integer.parseInt(numero));
			} 
		}else {
			numeros.add(0);
		}
	}

	private String calculos() {
		conseguirNumeros();
		numeros.clear();
		return Integer.toString(total);
	}

	@Override
	public void start(Stage escenarioPrincipal) {

		try {
			VBox raiz = new VBox();
			raiz.setPadding(new Insets(12));

			tfCabecera.setMinHeight(50);
			tfCabecera.setEditable(false);
			tfCabecera.setAlignment(Pos.BASELINE_RIGHT);
			tfCabecera.setFont(Font.font(27));

			TilePane tpPanel = new TilePane();
			tpPanel.setPrefColumns(4);

			btMas.setId("btMas");
			bt0.setId("bt0");

			bt0.setOnAction(this::mostrarCabecera);
			bt1.setOnAction(this::mostrarCabecera);
			bt2.setOnAction(this::mostrarCabecera);
			bt3.setOnAction(this::mostrarCabecera);
			bt4.setOnAction(this::mostrarCabecera);
			bt5.setOnAction(this::mostrarCabecera);
			bt6.setOnAction(this::mostrarCabecera);
			bt7.setOnAction(this::mostrarCabecera);
			bt8.setOnAction(this::mostrarCabecera);
			bt9.setOnAction(this::mostrarCabecera);
			btClear.setOnAction(this::mostrarCabecera);
			btDividir.setOnAction(this::mostrarCabecera);
			btMultiplicar.setOnAction(this::mostrarCabecera);
			btMas.setOnAction(this::mostrarCabecera);
			btMenos.setOnAction(this::mostrarCabecera);
			btIgual.setOnAction(this::mostrarCabecera);

			tpPanel.getChildren().addAll(bt1, bt2, bt3, btDividir, bt4, bt5, bt6, btMultiplicar, bt7, bt8, bt9, btMenos,
					bt0, btClear, btIgual, btMas);

			Label lbRotada = new Label();
			lbRotada.setText("Hola mundo desde JavaFX!!!!");
			lbRotada.setFont(Font.font("Arial", 40));
			lbRotada.setMinWidth(150);

			raiz.getChildren().addAll(tfCabecera, tpPanel);
			Scene escena = new Scene(raiz, 360, 410);
			escena.getStylesheets().add(LocalizadorRecursos.class.getResource("MiEstilo.css").toExternalForm());
			escenarioPrincipal.setTitle("Calculadora");
			escenarioPrincipal.setScene(escena);
			escenarioPrincipal.setResizable(false);
			escenarioPrincipal.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

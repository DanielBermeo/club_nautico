package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelo.Amarre;
import fes.aragon.repository.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AgregarAmarreController implements Initializable {

	@FXML
	private TextField txtCuota;

	@FXML
	private ComboBox<String> cmbAno;

	@FXML
	private Button btnCancelar;

	@FXML
	private ComboBox<String> cmbDia;

	@FXML
	private TextField txtAmarre;

	@FXML
	private Button btnRegistrar;

	@FXML
	private ComboBox<String> cmbMes;

	@FXML
	void aventCancelar(ActionEvent event) {

		Stage escenario = (Stage) btnCancelar.getScene().getWindow();
		Alert confirmacion = new Alert(AlertType.CONFIRMATION);
		confirmacion.setContentText("¿Seguro de cancelar la insercion?");
		confirmacion.setTitle("¡Cuidado!");
		confirmacion.showAndWait();
		ButtonType respuesta = confirmacion.getResult();

		if (respuesta == ButtonType.OK) {
			escenario.close();
		}
	}

	@FXML
	void eventRegistrar(ActionEvent event) {

		Stage escenario = (Stage) btnRegistrar.getScene().getWindow();
		Alert alerta = new Alert(AlertType.INFORMATION);
		ArrayList<String> meses = new ArrayList<>();
		meses.add("Enero");
		meses.add("Febrero");
		meses.add("Marzo");
		meses.add("Abril");
		meses.add("Mayo");
		meses.add("Junio");
		meses.add("Julio");
		meses.add("Agosto");
		meses.add("Septiembre");
		meses.add("Octubre");
		meses.add("Noviembre");
		meses.add("Diciembre");

		String dia, mes, ano;
		dia = cmbDia.getValue();
		mes = cmbMes.getValue();
		ano = cmbAno.getValue();

		if (meses.indexOf(mes) + 1 < 10) {
			mes = "0" + (meses.indexOf(mes) + 1);
		} else
			mes = (meses.indexOf(mes) + 1) + "";
		String fecha = ano + "-" + mes + "-" + dia;

		Amarre nuevoAmarre = new Amarre(Integer.parseInt(txtAmarre.getText()), fecha,
				Double.parseDouble(txtCuota.getText()), 1);

		try {
			Conexion cnn = new Conexion();

			if (cnn.consultarEstadoAmarre(nuevoAmarre) == 0) {

				alerta.setContentText("El amarre se encuentra ocupado, la cuota ya fue asignada y pactada");
				alerta.showAndWait();
				
			} else {
				cnn.insertarAmarre(nuevoAmarre);
				cnn.cerrarConexion();
				escenario.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<String> meses = new ArrayList<>();
		ArrayList<String> dias = new ArrayList<>();
		ArrayList<String> anos = new ArrayList<>();

		ObservableList<String> listaMeses = FXCollections.observableArrayList();
		ObservableList<String> listaDias = FXCollections.observableArrayList();
		ObservableList<String> listaAnos = FXCollections.observableArrayList();

		meses.add("Enero");
		meses.add("Febrero");
		meses.add("Marzo");
		meses.add("Abril");
		meses.add("Mayo");
		meses.add("Junio");
		meses.add("Julio");
		meses.add("Agosto");
		meses.add("Septiembre");
		meses.add("Octubre");
		meses.add("Noviembre");
		meses.add("Diciembre");

		for (int i = 1; i < 32; i++) {
			dias.add("" + i);
		}

		for (int i = 2023; i < 2050; i++) {
			anos.add("" + i);
		}

		for (String dia : dias) {
			listaDias.add(dia);
		}

		for (String mes : meses) {
			listaMeses.add(mes);
		}

		for (String ano : anos) {
			listaAnos.add(ano);
		}
		cmbMes.setItems(listaMeses);
		cmbAno.setItems(listaAnos);
		cmbDia.setItems(listaDias);

	}

}

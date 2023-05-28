package fes.aragon.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelo.Amarre;
import fes.aragon.modelo.AmarreOcupado;
import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Salida;
import fes.aragon.repository.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;


public class RegistrarSalidaController implements Initializable {

    @FXML
    private ComboBox<AmarreOcupado> cmbBarco;

    @FXML
    private TextField txtDestino;

    @FXML
    private ComboBox<String> cmbAno;

    @FXML
    private Button btnCancelar;

    @FXML
    private ComboBox<String> cmbDia;

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
		mes =  cmbMes.getValue();
		ano = cmbAno.getValue();
		if ((Integer.parseInt(dia) > 28 && meses.indexOf(mes) == 1)||(meses.indexOf(mes) % 2 == 1 && Integer.parseInt(dia)> 30)) {
			
			alerta.setContentText("Valor de fecha no valido");
			alerta.setTitle("Error");
			alerta.showAndWait();
		} else {
			
			if(meses.indexOf(mes)+1 < 10) {
				mes ="0"+ (meses.indexOf(mes)+1);
			}else
				mes = (meses.indexOf(mes)+1) + "";
			String fecha = ano + "-"  + mes +"-"+dia;
			
			try {
				Salida salida = new Salida(fecha,txtDestino.getText(),cmbBarco.getValue().getBarco().getMatricula());
				Conexion cnn = new Conexion();
				cnn.registrarSalida(salida,cmbBarco.getValue());
				cnn.cerrarConexion();
				escenario.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
		
		try {
			Conexion cnn = new Conexion();
			ArrayList<AmarreOcupado> barcos = cnn.getAmarresOcupados();
			ObservableList<AmarreOcupado> barcosDentro = FXCollections.observableArrayList();
			for (AmarreOcupado barco : barcos) {
				barcosDentro.add(barco);
			}
			cmbBarco.setItems(barcosDentro);
			
			cnn.cerrarConexion();
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}



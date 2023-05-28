package fes.aragon.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.ResourceBundle;

import fes.aragon.modelo.Amarre;
import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Usuario;
import fes.aragon.repository.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CrearEntradaController implements Initializable {

	  @FXML
	    private Button btnRegAmarre;

	@FXML
	private ComboBox<String> cmbAno;

	@FXML
	private ComboBox<String> cmbDia;

	@FXML
	private Button btnCancelar;

	 @FXML
	    private ComboBox<Amarre> cmbAmarre;

	 @FXML
	    private ComboBox<Barco> cmbMatricula;


	@FXML
	private Button btnRegistrar;

	@FXML
	private ComboBox<String> cmbMes;

	@FXML
	void eventRegistrar(ActionEvent event)  {

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
			Amarre amarre = cmbAmarre.getValue();
			Barco barco = cmbMatricula.getValue();
			if(meses.indexOf(mes)+1 < 10) {
				mes ="0"+ (meses.indexOf(mes)+1);
			}else
				mes = (meses.indexOf(mes)+1) + "";
			String fecha = ano + "-"  + mes +"-"+dia;
			
			try {
				Conexion cnn = new Conexion();
				if(cnn.estaDentroBarco(barco)) {
					alerta.setContentText("Parece que el barco que intentas registrar ya se encunetra en un amarre registrado");
					alerta.showAndWait();
				}else {
					cnn.registrarEntrada(barco,amarre,fecha);
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
				
	}

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
    void RegistrarAmarre(ActionEvent event) {
    	cmbDia.setValue(null);
    	cmbMes.setValue(null);
    	cmbAno.setValue(null);
    	cmbMatricula.setValue(null);
    	cmbAmarre.setValue(null);

    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/AgregarAmarre.fxml"));
			Scene escena = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(escena);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Amarre> amarres = cnn.getAmarresDispobibles();
			ObservableList<Amarre> listaAmarres = FXCollections.observableArrayList();
			for (Amarre amarre : amarres) {
				listaAmarres.add(amarre);
			}
			cmbAmarre.setItems(listaAmarres);
			
			cnn.cerrarConexion();
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
		// TODO Auto-generated method stub
		
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
			ArrayList<Amarre> amarres = cnn.getAmarresDispobibles();
			ObservableList<Amarre> listaAmarres = FXCollections.observableArrayList();
			for (Amarre amarre : amarres) {
				listaAmarres.add(amarre);
			}
			cmbAmarre.setItems(listaAmarres);
			
			ArrayList<Barco> barcos = cnn.consultarTodosBarcos();
			ObservableList<Barco> listaBarcos = FXCollections.observableArrayList();
			for (Barco barco : barcos) {
				listaBarcos.add(barco);
			}
			cmbMatricula.setItems(listaBarcos);
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

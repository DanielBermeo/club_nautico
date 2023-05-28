package fes.aragon.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import fes.aragon.modelo.Usuario;
import fes.aragon.repository.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;

public class AgregarUsuarioController implements Initializable {
	@FXML
	private TextField txtNombre = new TextField();

	@FXML
	private RadioButton rbtnPatron = new RadioButton();

	@FXML
	private TextField txtTelefono = new TextField();

	@FXML
	private TextField txtEmail = new TextField();

	@FXML
	private Button btnCancelar = new Button();

	@FXML
	private ComboBox<Usuario> cmbSocio = new ComboBox<>();

	@FXML
	private TextField txtApPat = new TextField();

	@FXML
	private Button btnAgregar = new Button();

	@FXML
	private TextField txtApMat = new TextField();

	@FXML
	void evntCancelarInsercion(ActionEvent event) {

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
	void eventAgregarUsuario(ActionEvent event) {

		
		Usuario u = new Usuario(txtNombre.getText(),txtApPat.getText(),txtApMat.getText(),txtTelefono.getText(),txtEmail.getText());
		Stage escenario = (Stage) btnAgregar.getScene().getWindow();
		Alert confirmacion = new Alert(AlertType.CONFIRMATION);
		confirmacion.setContentText("¿Seguro de registrar al usuario: " + u.getFullName());
		confirmacion.showAndWait();
		ButtonType respuesta = confirmacion.getResult();

		if (respuesta == ButtonType.OK) {
			
			try {
				Conexion cnn = new Conexion();
				int idUsuario = cnn.InsertarUsuario(u);
				int idSocio;
				cnn = new Conexion();
				if (idUsuario != 0) {
					if (rbtnPatron.selectedProperty().getValue()) {
						if (cmbSocio.getValue().getIdContacto() == 0) {
							// El patron y el socio son el mismo
							idSocio = cnn.InsertarSocio(idUsuario);
							
						}else {
							// El patron escoge un socio
							idSocio = cnn.getIdSocio(cmbSocio.getValue().getIdContacto());
						}
						cnn.InsertarPatron(idUsuario, idSocio);
						
					} else {
						if (cmbSocio.getValue() != null) {
							// El contacto solo es socio
							cnn.InsertarSocio(idUsuario);
						}
					}
				}
				cnn.cerrarConexion();
				escenario.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Conexion cnn;
		rbtnPatron.setDisable(true);
		
		cmbSocio.getSelectionModel().selectedItemProperty()
		.addListener(new ChangeListener<Object>() {

					@Override
					public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
						// TODO Auto-generated method stub
						rbtnPatron.setDisable(false);
					}
		});
		ObservableList<Usuario> listaContactos = FXCollections.observableArrayList();
		ArrayList<Usuario> lista;
		try {

			cnn = new Conexion();


			lista = cnn.consultarTodosSocios();
			listaContactos.add(new Usuario(0, "Este usuario ", "es ", "Socio", "", ""));
			for (Usuario contacto : lista) {
				listaContactos.add(contacto);
			}
			cmbSocio.setItems(listaContactos);

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

package fes.aragon.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Entrada;
import fes.aragon.modelo.Salida;
import fes.aragon.modelo.Usuario;
import fes.aragon.repository.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InterfazProyectoController implements Initializable {

	@FXML
    private TableView<Usuario> tblTabla_Us ;
	
    @FXML
    private TableView<Barco> tblBarcos;
	
    @FXML
    private TableView<Entrada> tblEntradas;
    
    @FXML
    private TableView<Salida> tblSalidas;
    
    @FXML
    private Button btnBuscar_Sal;

    @FXML
    private Button btnRegistrarSalida;

    @FXML
    private RadioButton rdbtnPatron_Us;

    @FXML
    private TableColumn<Salida, String> clmDestino_Sal;

    @FXML
    private TextField txtBuscar_Us = new TextField();

    @FXML
    private TextField txtMatricula_Bar;

    @FXML
    private Button btnSeleccionar_Us;

    @FXML
    private TableColumn<Barco, String> clmNombre_Bar;

    @FXML
    private TextField txtNombre_Bar;

    @FXML
    private Button btnBuscar_Ent;

    @FXML
    private TableColumn<Usuario, String> clmNombre_Us;

    @FXML
    private Button btnSeleccionar_Bar;

    @FXML
    private Button btnVerTodos_Us;

    @FXML
    private TextField txtEmail_Us;

    @FXML
    private Button btnGuardar_Us = new Button();

    @FXML
    private Button btnGuardarCambios_Bar;

    @FXML
    private TableColumn<Entrada, Integer> clmNumeroAmarre_Ent;

    @FXML
    private TableColumn<Salida, String> clmMatricula_Sal;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private TableColumn<Salida, String> clmFechaSalida_Sal;

    @FXML
    private Button btnBuscar_Us;

    @FXML
    private TableColumn<Entrada, String> clmFechaLlegada_Ent;

    @FXML
    private ComboBox<?> cmbPatron_Bar;

    @FXML
    private Button btnLimpiarBusqueda;

    @FXML
    private TextField txtBuscar_Bar;

    @FXML
    private TableColumn<Usuario, String> clmSocio_Us;

    @FXML
    private TextField txtApellidoPaterno_Us;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Ent  = new ComboBox<String>();

    @FXML
    private TextField txtBuscar_Sal;

    @FXML
    private TextField txtNombre_Us;

    @FXML
    private Button btnVerTodos_Ent;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Sal  = new ComboBox<String>();

    @FXML
    private ComboBox<?> cmbDueño_Bar;

    @FXML
    private TableColumn<Usuario, String> clmEmail_Us;

    @FXML
    private TableColumn<Barco, String> clmMatricula_Bar;

    @FXML
    private Button btnBuscar_Bar;

    @FXML
    private TextField txtTelefono_Us;

    @FXML
    private TextField txtBuscar_Ent;

    @FXML
    private TableColumn<Barco, String> clmPatron_Bar;

    @FXML
    private TableColumn<Usuario, String> clmPatron_Us;

    @FXML
    private Button btnAgregarNuevo_Us;

    @FXML
    private Button btnVerTodos_Sal;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Us = new ComboBox<String>();

    @FXML
    private Button btnAgregarNuevo_Bar = new Button();

    @FXML
    private ComboBox<?> cmbSocio;

    @FXML
    private TableColumn<Entrada, String> clmMatricula_Ent;

    @FXML
    private Button btnCrearEntrada;

    @FXML
    private ComboBox<String> cmbFecha_Sal =  new ComboBox<String>();

    @FXML
    private TableColumn<Barco, String> clmDueño_Bar;

    @FXML
    private Button btnVerTodos_Bar = new Button();

    @FXML
    private Button btnEliminarBarco_Bar;

    @FXML
    private ComboBox<String> cmbFecha_Ent  = new ComboBox<String>();

    @FXML
    private TableColumn<Usuario, String> clmTelefono_Us;

    @FXML
    private Button btnLimpiarBusqueda_Sal;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Bar = new ComboBox<String>();

    @FXML
    private TextField txtApellidoMaterno_Us;

 

    @FXML
    void eventoBuscar_Us(ActionEvent event) {
    	
    	
    	//Posible mejora agregar por nombre y apellidos
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Usuario> usuarios = cnn.consultarUsuarios(cmbRubroBusqueda_Us.getValue().toLowerCase(),txtBuscar_Us.getText());
			this.tblTabla_Us.setItems(FXCollections.observableArrayList(usuarios));
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoAgregarNuevo_Us(ActionEvent event) {
    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/AgregarUsuario.fxml"));
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
    }

    @FXML
    void eventoSeleccionar_Us(ActionEvent event) {

    }

    @FXML
    void eventoEliminarUsuario(ActionEvent event) {

    }

    @FXML
    void eventoGuardar_Us(ActionEvent event) {
    	
    }

    @FXML
    void eventoSocio_Us(ActionEvent event) {

    }

    @FXML
    void eventoPatron_Us(ActionEvent event) {

    }

    @FXML
    void eventoVerTodos_Us(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Usuario> usuarios = cnn.consultarTodosUsuarios();
			this.tblTabla_Us.setItems(FXCollections.observableArrayList(usuarios));
			cmbRubroBusqueda_Us.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


    @FXML
    void eventoVerTodos_Bar(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Barco> barcos = cnn.consultarTodosBarcos();
			this.tblBarcos.setItems(FXCollections.observableArrayList(barcos));
			cmbRubroBusqueda_Bar.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoAgregarNuevo_Bar(ActionEvent event) {

    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/AgregarBarco.fxml"));
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
    }

    @FXML
    void eventoSeleccionar_Bar(ActionEvent event) {

    }

    @FXML
    void eventoEliminarBarco(ActionEvent event) {

    }

    @FXML
    void eventoGuardarCambios_Bar(ActionEvent event) {

    }

    @FXML
    void eventoBuscar_Bar(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Barco> barcos = cnn.consultarBarcos(cmbRubroBusqueda_Bar.getValue().toLowerCase(), txtBuscar_Bar.getText());
			this.tblBarcos.setItems(FXCollections.observableArrayList(barcos));
			cmbRubroBusqueda_Bar.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @FXML
    void eventoVerTodos_Ent(ActionEvent event) {

    	try {
			Conexion cnn = new Conexion();
			ArrayList<Entrada> entradas = cnn.consultarTodasEntradas();
			this.tblEntradas.setItems(FXCollections.observableArrayList(entradas));
			cmbRubroBusqueda_Ent.setValue(null);
			cmbFecha_Ent.setValue(null);
			txtBuscar_Ent.setText("");
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoCrearEntrada(ActionEvent event) {

    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/CrearEntrada.fxml"));
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
    }

    @FXML
    void eventoLimpiarBusqueda(ActionEvent event) {

    	txtBuscar_Ent.setText("");
    	cmbRubroBusqueda_Ent.setValue(null);
    	cmbFecha_Ent.setValue(null);
    	tblEntradas.setItems(null);
    
    	
    }

    @FXML
    void eventoBuscar_Ent(ActionEvent event) {

    	ArrayList<String> rubroBusEnt = new ArrayList<>();
		rubroBusEnt.add("Matricula");
		rubroBusEnt.add("Num. Amarre");
		
    	try {
			Conexion cnn = new Conexion();
			int desicion = rubroBusEnt.indexOf(cmbRubroBusqueda_Ent.getValue());
			String cadDesicion, busqueda, filtroFecha = "";
			if(desicion == 0) {
				cadDesicion = "num_mta like ";
				busqueda = "'%" + txtBuscar_Ent.getText() + "%'";
			}else {
				cadDesicion = "num_ams = ";
				busqueda ="" + Integer.parseInt(txtBuscar_Ent.getText());
			}
			
			if(cmbFecha_Ent.getValue() != null) {
				filtroFecha =" and fecha_llegada = '" + cmbFecha_Ent.getValue() + "'";
			}
			ArrayList<Entrada> entradas = cnn.consultarEntradas(cadDesicion,busqueda,filtroFecha);
			this.tblEntradas.setItems(FXCollections.observableArrayList(entradas));
			
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @FXML
    void eventoVerTodos_Sal(ActionEvent event) {

    	try {
			Conexion cnn = new Conexion();
			ArrayList<Salida> salidas = cnn.consultarTodasSalidas();
			this.tblSalidas.setItems(FXCollections.observableArrayList(salidas));
			cmbRubroBusqueda_Sal.setValue(null);
			cmbFecha_Sal.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoRegistrarSalida(ActionEvent event) {

    }

    @FXML
    void eventoLimpiarBusqueda_Sal(ActionEvent event) {

    }

    @FXML
    void eventoBuscar_Sal(ActionEvent event) {
    	ArrayList<String> rubroBusSal = new ArrayList<>();
		rubroBusSal.add("Matricula");
		rubroBusSal.add("Destino");
		
    	try {
			Conexion cnn = new Conexion();
			int desicion = rubroBusSal.indexOf(cmbRubroBusqueda_Sal.getValue());
			String cadDesicion, busqueda, filtroFecha = "";
			if(desicion == 0) {
				cadDesicion = "num_mta like ";
				busqueda = "'%" + txtBuscar_Sal.getText() + "%'";
			}else {
				cadDesicion = "destino like ";
				busqueda ="'%" + txtBuscar_Sal.getText()+"%'";
			}
			
			if(cmbFecha_Sal.getValue() != null) {
				filtroFecha =" and fecha_salida = '" + cmbFecha_Sal.getValue() + "'";
			}
			ArrayList<Salida> salidas = cnn.consultarSalidas(cadDesicion,busqueda,filtroFecha);
			this.tblSalidas.setItems(FXCollections.observableArrayList(salidas));
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Conexion cnn;
		
		txtBuscar_Us.setOnMouseClicked(event ->{
			txtBuscar_Us.setText("");
		});
		
		txtBuscar_Bar.setOnMouseClicked(event ->{
			txtBuscar_Bar.setText("");
		});
		
		txtBuscar_Ent.setOnMouseClicked(event ->{
			txtBuscar_Ent.setText("");
		});
		
		txtBuscar_Sal.setOnMouseClicked(event ->{
			txtBuscar_Sal.setText("");
		});
		
		ObservableList<String>  rubrosUsu = FXCollections.observableArrayList();
		ArrayList<String> rubroBusUsu = new ArrayList<>();
		rubroBusUsu.add("Nombre");
		rubroBusUsu.add("Telefono");
		rubroBusUsu.add("Email");
		for (String cadena : rubroBusUsu) {
			rubrosUsu.add(cadena);
		}
		cmbRubroBusqueda_Us.setItems(rubrosUsu);
		
		ObservableList<String>  rubrosBar = FXCollections.observableArrayList();
		ArrayList<String> rubroBusBar = new ArrayList<>();
		rubroBusBar.add("Nombre");
		rubroBusBar.add("Matricula");
		for (String cadena : rubroBusBar) {
			rubrosBar.add(cadena);
		}
		cmbRubroBusqueda_Bar.setItems(rubrosBar);
		
		ObservableList<String>  rubrosEnt = FXCollections.observableArrayList();
		ArrayList<String> rubroBusEnt = new ArrayList<>();
		rubroBusEnt.add("Matricula");
		rubroBusEnt.add("Num. Amarre");
		for (String cadena : rubroBusEnt) {
			rubrosEnt.add(cadena);
		}
		cmbRubroBusqueda_Ent.setItems(rubrosEnt);
		
		ObservableList<String>  rubrosSal = FXCollections.observableArrayList();
		ArrayList<String> rubroBusSal = new ArrayList<>();
		rubroBusSal.add("Matricula");
		rubroBusSal.add("Destino");
		for (String cadena : rubroBusSal) {
			rubrosSal.add(cadena);
		}
		cmbRubroBusqueda_Sal.setItems(rubrosSal);
		
		ObservableList<String> fechasEntrada = FXCollections.observableArrayList();
		ArrayList<String> fechasE;
		ObservableList<String> fechasSalida = FXCollections.observableArrayList();
		ArrayList<String> fechasS;
		try {
			
			cnn = new Conexion();
			fechasE = cnn.consultarFechaEntradas();
			for (String entrada : fechasE) {
				fechasEntrada.add(entrada);
			}
			cmbFecha_Ent.setItems(fechasEntrada);
			
			fechasS = cnn.consultarFechaSalida();
			for (String salida : fechasS) {
				fechasSalida.add(salida);
			}
			cmbFecha_Sal.setItems(fechasSalida);
			cnn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		clmNombre_Us.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		clmTelefono_Us.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		clmEmail_Us.setCellValueFactory(new PropertyValueFactory<>("email"));
		clmSocio_Us.setCellValueFactory(new PropertyValueFactory<>("socio"));
		clmPatron_Us.setCellValueFactory(new PropertyValueFactory<>("patron"));
		
		clmNombre_Bar.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		clmMatricula_Bar.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		clmPatron_Bar.setCellValueFactory(new PropertyValueFactory<>("nomPatron"));
		clmDueño_Bar.setCellValueFactory(new PropertyValueFactory<>("nomDueno"));
		
		clmMatricula_Ent.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		clmFechaLlegada_Ent.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		clmNumeroAmarre_Ent.setCellValueFactory(new PropertyValueFactory<>("numAmarre"));
		
		clmMatricula_Sal.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		clmFechaSalida_Sal.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		clmDestino_Sal.setCellValueFactory(new PropertyValueFactory<>("destino"));
	
		
	}
    

}
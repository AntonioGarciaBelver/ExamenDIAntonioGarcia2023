package com.mycompany.exameninterfacesantoniogarcia2023;

import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Alumno;
import net.sf.jasperreports.engine.JRException;

public class PrimaryController implements Initializable {

    List<Alumno> alumnos = new ArrayList();
    Alumno alumnoActual = new Alumno();
    Informe informe = new Informe();
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private Button btnAñadir;
    @FXML
    private Label info;
    @FXML
    private TableView<Alumno> tabla;
    @FXML
    private TableColumn<Alumno, String> cNombre;
    @FXML
    private TableColumn<Alumno, String> cApellidos;
    @FXML
    private TableColumn<Alumno, Double> cAD;
    @FXML
    private TableColumn<Alumno, Double> cSGE;
    @FXML
    private TableColumn<Alumno, Double> cDI;
    @FXML
    private TableColumn<Alumno, Double> cPMDM;
    @FXML
    private TableColumn<Alumno, Double> cPSP;
    @FXML
    private TableColumn<Alumno, Double> cEIE;
    @FXML
    private TableColumn<Alumno, Double> cHLC;

    @FXML
    private TextField txtPMDM;
    @FXML
    private TextField txtPSP;
    @FXML
    private TextField txtEIE;
    @FXML
    private TextField txtHLC;
    @FXML
    private TextField txtAD;
    @FXML
    private TextField txtSGE;
    @FXML
    private TextField txtDI;
    @FXML
    private Button btnDescargar;
    @FXML
    private Button btnSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        cApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        cAD.setCellValueFactory(new PropertyValueFactory("AD"));
        cSGE.setCellValueFactory(new PropertyValueFactory("SGE"));
        cDI.setCellValueFactory(new PropertyValueFactory("DI"));
        cPMDM.setCellValueFactory(new PropertyValueFactory("PMDM"));
        cPSP.setCellValueFactory(new PropertyValueFactory("PSP"));
        cEIE.setCellValueFactory(new PropertyValueFactory("EIE"));
        cHLC.setCellValueFactory(new PropertyValueFactory("HLC"));

        actualizarTabla();

    }

    private void actualizarTabla() {
        if(alumnos.size()==0){
            alumnos = llenarAlumnos();
        }
        ObservableList<Alumno> alumnos1 = FXCollections.observableArrayList();
        alumnos1.addAll(alumnos);

        tabla.getItems().clear();
        tabla.getItems().addAll(alumnos1);
    }

    @FXML
    private void añadirAlumno(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        Double AD = Double.parseDouble(txtAD.getText());
        Double SGE = Double.parseDouble(txtSGE.getText());
        Double DI = Double.parseDouble(txtDI.getText());
        Double PMDM = Double.parseDouble(txtPMDM.getText());
        Double PSP = Double.parseDouble(txtPSP.getText());
        Double EIE = Double.parseDouble(txtEIE.getText());
        Double HLC = Double.parseDouble(txtHLC.getText());
        
        alumnoActual.setNombre(nombre);
        alumnoActual.setApellidos(apellidos);

        if(AD>=0. && AD<=10.0){
            alumnoActual.setAD(AD);
        }else{
            info.setText("Ingresa una nota de AD mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        if(SGE>=0. && SGE<=10.0){
            alumnoActual.setSGE(SGE);
        }else{
            info.setText("Ingresa una nota de SGE mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        if(DI>=0. && DI<=10.0){
            alumnoActual.setDI(DI);
        }else{
            info.setText("Ingresa una nota de DI mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        if(PMDM>=0. && PMDM<=10.0){
            alumnoActual.setPMDM(PMDM);
        }else{
            info.setText("Ingresa una nota de PMDM mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        if(PSP>=0. && PSP<=10.0){
            alumnoActual.setPSP(PSP);
        }else{
            info.setText("Ingresa una nota de PSP mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        if(EIE>=0. && EIE<=10.0){
            alumnoActual.setEIE(EIE);
        }else{
            info.setText("Ingresa una nota de EIE mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        if(HLC>=0. && HLC<=10.0){
            alumnoActual.setHLC(HLC);
        }else{
            info.setText("Ingresa una nota de HLC mayor a 0 o menor a 10 por favor!");
            info.setStyle("-fx-background-color:#FF0000; -fx-text-fill:white; -fx-font-weight: bold");
        }
        
        alumnos.add(alumnoActual);
        
        actualizarTabla();

    }

    @FXML
    private void descargarNotas(ActionEvent event) {
        try {
            informe.showReport();
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(com.mycompany.exameninterfacesantoniogarcia2023.PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            informe.pdfReport();
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(com.mycompany.exameninterfacesantoniogarcia2023.PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

    private List<Alumno> llenarAlumnos() {

        Alumno alumno1 = new Alumno();
        Alumno alumno2 = new Alumno();
        Alumno alumno3 = new Alumno();

        alumno1.setNombre("Francisco");
        alumno1.setApellidos("Romero");
        alumno1.setDI(9.0);
        alumno1.setEIE(7.5);
        alumno1.setHLC(9.0);
        alumno1.setPMDM(9.0);
        alumno1.setSGE(9.0);
        alumno1.setAD(9.0);
        alumno1.setPSP(4.0);

        alumno2.setNombre("Antonio");
        alumno2.setApellidos("Garcia");
        alumno2.setDI(7.0);
        alumno2.setHLC(7.0);
        alumno2.setPMDM(7.0);
        alumno2.setSGE(7.0);
        alumno2.setAD(3.0);
        alumno2.setEIE(1.5);
        alumno2.setPSP(8.0);

        alumno3.setNombre("Loren");
        alumno3.setApellidos("Lynch");
        alumno3.setDI(7.0);
        alumno3.setEIE(7.0);
        alumno3.setHLC(7.0);
        alumno3.setPMDM(7.0);
        alumno3.setSGE(7.0);
        alumno3.setAD(7.0);
        alumno3.setPSP(8.0);

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);

        return alumnos;
    }

    @FXML
    private void mostrarDialogo(MouseEvent event) {
        Alumno alumno = tabla.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alumno " + alumno.getNombre() + " " + alumno.getApellidos());
        alert.setHeaderText("Nota media y numero de modulos suspensos");
        alert.setContentText("Media: "+getMedia(alumno)+ "\nSuspensos: "+getSuspensos(alumno));

        alert.showAndWait();
    }

    private String getMedia(Alumno a) {
        Double media = 0.0;
        media = (a.getAD()+a.getDI()+a.getEIE()+a.getHLC()+a.getPMDM()+a.getPSP()+a.getSGE())/7;
        
        DecimalFormat df = new DecimalFormat("#.##");
        String resultado = df.format(media);
        
        return resultado;
    }
    
    private Integer getSuspensos(Alumno a){
        int suspensos = 0;
        if(a.getAD()<5.0){
            suspensos++;
        }
        if(a.getDI()<5.0){
            suspensos++;
        }
        if(a.getEIE()<5.0){
            suspensos++;
        }
        if(a.getPMDM()<5.0){
            suspensos++;
        }
        if(a.getPSP()<5.0){
            suspensos++;
        }
        if(a.getSGE()<5.0){
            suspensos++;
        }
        if(a.getHLC()<5.0){
            suspensos++;
        }
        return suspensos;
    }

}

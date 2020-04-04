package it.polito.tdp.lab04;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.*;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model=new Model();
	private ObservableList<Corso>list=FXCollections.observableArrayList();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cbxCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnOk;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscriviti;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnClear;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	txtRisultato.clear();
    	String matricola=txtMatricola.getText();
    	int matricolaStudente;
    	try {
            matricolaStudente = Integer.parseInt(matricola);
        } catch (NumberFormatException e) {
            txtRisultato.setText("Devi inserire una matricola!");
    		return;
    	}
    	Studente s=new Studente(matricolaStudente);
    	if(!this.model.esisteStudente(matricolaStudente)) {
            txtRisultato.appendText("Matricola non presente!\n");
            return ;
        }
    	
    		for(Corso c:this.model.getCorsiStudenti(s)) {
    			txtRisultato.appendText(c.toStringSpazi()+"\n");
    		}
        }

    @FXML
    void doCercaIscritti(ActionEvent event) {
        txtRisultato.clear(); 
    	Corso c=cbxCorsi.getValue();
         if(c.getNomeCorso().compareTo("")!=0) {
         for(Studente s:this.model.getIscrittiCorso(c)) {
        	 txtRisultato.appendText(s.toString()+"\n");
           }
         }else
    	   txtRisultato.setText("Corso non selezionato!");
    	
    }

    @FXML
    void doClear(ActionEvent event) {
        this.txtRisultato.clear();
    }

    @FXML
    void doIscrivi(ActionEvent event) {
        txtRisultato.clear();
        Corso c=cbxCorsi.getValue();
        List<Integer>studenti=new LinkedList<Integer>();
        String matricola=txtMatricola.getText();
    	int matricolaStudente;
    	try {
            matricolaStudente = Integer.parseInt(matricola);
        } catch (NumberFormatException e) {
            txtRisultato.setText("Devi inserire una matricola!");
    		return;
    	}
        if(c.getNomeCorso().compareTo("")!=0) {
        	for(Studente s: this.model.getIscrittiCorso(c)) {
        		studenti.add(s.getMatricola());
        	}
        }
        if(studenti.contains(matricolaStudente)) {
        	txtRisultato.setText("Studente già iscritto a questo corso!\n");
        }else {
        	Studente s=new Studente(matricolaStudente);
        	if(this.model.inscriviStudenteACorso(s, c)) {
        		txtRisultato.setText("Studente iscritto al corso!\n");
        	}
        }
    	
    }

    @FXML
    void doOk(ActionEvent event) {
    	txtRisultato.clear();
    	int matricola=Integer.parseInt(txtMatricola.getText());
    	String nome="";
    	String cognome="";
    	boolean trovato=false;
    	for(Studente s:this.model.getElencoStudenti()) {
    		if(s.getMatricola()==matricola) {
    			trovato=true;
    			nome=s.getNome();
    			cognome=s.getCognome();
    	  }
        }
    	if(trovato) {
    		txtNome.setText(nome);
			txtCognome.setText(cognome);
    	}else
    		txtRisultato.setText("Matricola non trovata!");
    }

    @FXML
    void initialize() {
        assert cbxCorsi != null : "fx:id=\"cbxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscriviti != null : "fx:id=\"btnIscriviti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        list.addAll(this.model.getElencoCorsi());
        cbxCorsi.setItems(list);
    }
}

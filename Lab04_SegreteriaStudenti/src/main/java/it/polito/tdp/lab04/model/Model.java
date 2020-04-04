package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

import java.util.*;

public class Model {

	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		corsoDao=new CorsoDAO();
		studenteDao=new StudenteDAO();
	}
	public List<Corso>getElencoCorsi(){
		return corsoDao.getTuttiICorsi();
	}
	public List<Studente>getElencoStudenti(){
		return studenteDao.getTuttiGliStudenti();
	}
	public List<Studente>getIscrittiCorso(Corso c){
		return corsoDao.getStudentiIscrittiAlCorso(c);
	}
	public List<Corso>getCorsiStudenti(Studente s){
		return studenteDao.getCorsiStudente(s);
	}
	public boolean esisteStudente(int matricola) {
        return studenteDao.esisteStudente(matricola);
    }
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return corsoDao.inscriviStudenteACorso(studente, corso);
	}
	
}

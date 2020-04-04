package it.polito.tdp.lab04.model;

public class Corso {

	private String codins;
	private int crediti;
	private String nomeCorso;
	private int pd;
	public Corso(String codins, int crediti, String nomeCorso, int pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nomeCorso = nomeCorso;
		this.pd = pd;
	}
	public Corso(String nomeCorso) {
		this.nomeCorso=nomeCorso;
	}
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return nomeCorso;
	}
	public String toStringSpazi() {
		return String.format("%-10s ", codins)+ " " + String.format("%-4s ", crediti) + " " + String.format("%-52s ", nomeCorso) + " " + String.format("%-4s ", pd);
	}
	
}

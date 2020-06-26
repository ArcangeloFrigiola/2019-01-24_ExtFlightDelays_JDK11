package it.polito.tdp.extflightdelays.model;

public class Event implements Comparable<Event>{
	
	private String statoProvenienza;
	private int giorno;
	private int numeroTuristi;
	/**
	 * @param statoProvenienza
	 * @param giorno
	 */
	public Event(String statoProvenienza, int nT, int giorno) {
		super();
		this.statoProvenienza = statoProvenienza;
		this.giorno = giorno;
		this.numeroTuristi= nT;
	}
	public String getStatoProvenienza() {
		return statoProvenienza;
	}
	public int getGiorno() {
		return giorno;
	}
	
	public int getNumeroTuristi() {
		return this.numeroTuristi;
	}
	
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.getGiorno()-o.getGiorno();
	}
	
	
	
}

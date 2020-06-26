package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import javafx.scene.control.TextField;

public class Simulazione {
	
	//PARAMETRI DELLA SIMULAZIONE
	private int turisti;
	private int giorni;
	private Graph<String, DefaultWeightedEdge> grafo;
	private PriorityQueue<Event> queue = new PriorityQueue<>();
	
	//PARAMETRI DA CALCOLARE
	private Map<String, Integer> mappaStatiTuristi;

	public void initialize(Graph<String, DefaultWeightedEdge> g, String value, int t, int gg) {
		
		this.grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		this.grafo = g;
		
		this.giorni = gg;
		this.turisti = t;
		this.mappaStatiTuristi = new HashMap<>();
		
		for(String s: this.grafo.vertexSet()) {
			
			this.mappaStatiTuristi.put(s, 0);
		}
		
		this.mappaStatiTuristi.replace(value, this.turisti);
		this.queue.add(new Event(value, this.turisti, 1));
		
	}

	public void run() {
		
		while(!this.queue.isEmpty()) {
			
			Event e = this.queue.poll();
			processEvent(e);
		}
		
		
	}

	private void processEvent(Event e) {
		
		if(e.getGiorno()==this.giorni) {
			return;
		}else {
			
			for(int i=0; i<e.getNumeroTuristi(); i++) {
				
				List<StatoPeso> temp = new ArrayList<>(getStatiCollegati(e.getStatoProvenienza()));
				
			}
		}
	}

	public Map<String, Double> getRisultatoSimluazione() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<StatoPeso> getStatiCollegati(String stato) {
		
		List<String> listaStati = new ArrayList<>(Graphs.successorListOf(this.grafo, stato));
		List<StatoPeso> stati = new ArrayList<>();

		for (String s : listaStati) {

			double peso = this.grafo.getEdgeWeight(this.grafo.getEdge(stato, s));
			StatoPeso temp = new StatoPeso(s, peso);
			stati.add(temp);

		}

		return stati;
	}

}

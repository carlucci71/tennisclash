package tc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Esito implements Comparable<Esito> {
	public Esito(Integer totale) {
		super();
		this.totale = totale;
	}
	private Integer totale;
	private List<EnumOggetti> oggetti=new ArrayList();
	private Map<String, Integer> valori=new LinkedHashMap();
	private List<Map<String,Object>> caratteristiche=new ArrayList<Map<String,Object>>();
	public List<EnumOggetti> getOggetti() {
		return oggetti;
	}
	public void setOggetti(List<EnumOggetti> oggetti) {
		this.oggetti = oggetti;
	}
	public Map<String, Integer> getValori() {
		return valori;
	}
	public void setValori(Map<String, Integer> valori) {
		this.valori = valori;
	}

	public Esito aggiungiOggetto(EnumOggetti oggetto) {
		oggetti.add(oggetto);
		return this;
	}
	public Esito aggiungiCaratteristiche(Map<String,Object> caratteristica) {
		caratteristiche.add(caratteristica);
		return this;
	}
	public Esito aggiungiValori(String key, Integer valore) {
		valori.put(key,valore);
		return this;
	}
	public int compareTo(Esito o) {
		return -1;
	}
	@Override
	public String toString() {
		String ret = "";
		ret = ret + "---------------------------------------------------------------------------------------------------------------------\n";
		ret = ret + "Totale valori: " + totale + ":";
		ret = ret + "\n";
		Iterator<String> iterator = valori.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			ret = ret + "\t" +  key + ":" + valori.get(key); 
			ret = ret + "\n";
		}
		ret = ret + "Oggetti: \n";
		for (int i=0;i<oggetti.size();i++) {
			ret = ret + "\t" +  oggetti.get(i) + " (" + caratteristiche.get(i).get("livello") + ")";
			ret = ret + " --> ";
			ret = ret + caratteristiche.get(i).get("attuale") + " ";
			ret = ret + "\n";
		}

		return ret;
	}
	public Integer getTotale() {
		return totale;
	}
	public void setTotale(Integer totale) {
		this.totale = totale;
	}
}

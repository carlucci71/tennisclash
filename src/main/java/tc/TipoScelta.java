package tc;

import java.util.Map;
import java.util.TreeMap;

public class TipoScelta {
	public TipoScelta(EnumTipoScelta enumTipoScelta, EnumOggetti oggetto) {
		super();
		this.enumTipoScelta = enumTipoScelta;
		this.oggetto=oggetto;
	}
	private EnumTipoScelta enumTipoScelta;
	private EnumOggetti oggetto;
	private Map<Integer, Map<EnumAbilita, Integer>> caratteristiche=new TreeMap();
	
	public EnumTipoScelta getEnumTipoScelta() {
		return enumTipoScelta;
	}
	public EnumOggetti getOggetto() {
		return oggetto;
	}
	public Map<Integer, Map<EnumAbilita, Integer>> getCaratteristiche() {
		return caratteristiche;
	}
	public void setCaratteristiche(Map<Integer, Map<EnumAbilita, Integer>> caratteristiche) {
		this.caratteristiche = caratteristiche;
	}
	@Override
	public String toString() {
		return "[" + enumTipoScelta + ":" + oggetto + " " + caratteristiche + "] \n";
	}
}

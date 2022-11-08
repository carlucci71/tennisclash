package tc;

public enum EnumRacchette implements EnumOggetti{
	La_pantera("The_Panther"), 
	L_aquila("The_Eagle"), 
	Il_patriota("The_Patriot"), 
	L_entroterra("The_Outback"), 
	Il_samurai("The_Samurai"), 
	Il_martello("The_Hammer"), 
	Bersaglio("The_Bullseye"), 
	Zeus("Zeus");
	
	private String nome;
	private EnumRacchette(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumRacchette from(String s) {
		EnumRacchette[] values = EnumRacchette.values();
		for (EnumRacchette value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
}

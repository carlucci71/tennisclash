package tc;

public enum EnumPolsino implements EnumOggetti{
	Il_razzo("The_Rocket"), 
	Il_Tomahawk("The_Tomahawk"), 
	Bandiera_pirata("Jolly_Roger"), 
	Il_pappagallo_ara("The_Macaw"), 
	Il_koi("The_Koi"), 
	L_orso_Kodiac("The_Kodiak"), 
	Il_gladiatore("The_Gladiator"), 
	Lo_scudo("The_Shield");
	
	private String nome;
	private EnumPolsino(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumPolsino from(String s) {
		EnumPolsino[] values = EnumPolsino.values();
		for (EnumPolsino value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
}

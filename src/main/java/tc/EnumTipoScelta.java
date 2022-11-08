package tc;

public enum EnumTipoScelta {
	Personaggio("Characters"),
	Racchetta("Rackets"),
	Grip("Grips"),
	Scarpa("Shoes"),
	Polsino("Wristbands"),
	Nutrizione("Nutritions"),
	Allenamento("Workouts");

	private String nome;
	private EnumTipoScelta(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumTipoScelta from(String s) {
		EnumTipoScelta[] values = EnumTipoScelta.values();
		for (EnumTipoScelta value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
	
}

package tc;

public enum EnumAllenamento implements EnumOggetti{
	Fascia_di_resistenza("Resistance_Band"), 
	Resistenza("Endurance"), 
	Sprint("Sprint"), 
	Pilometria("Plyometrics"), 
	Powerlifting("Powerlifting"), 
	Sollevamento_pesi("Weight_lifting"), 
	Arrampicatore("Mountain_Climber"), 
	Affondi("Lunges");

	private String nome;
	private EnumAllenamento(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumAllenamento from(String s) {
		EnumAllenamento[] values = EnumAllenamento.values();
		for (EnumAllenamento value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
	
}

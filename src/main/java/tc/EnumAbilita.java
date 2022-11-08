package tc;

public enum EnumAbilita {
	Agilita("Agility"),
	Resistenza("Stamina"),
	Servizio("Serve"),
	Volley("Volley"),
	Diritto("Forehand"),
	Rovescio("Backhand");

	private String nome;
	private EnumAbilita(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumAbilita from(String s) {
		EnumAbilita[] values = EnumAbilita.values();
		for (EnumAbilita value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
}

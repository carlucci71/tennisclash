package tc;

public enum EnumGrip implements EnumOggetti{
	Il_guerriero("The_Warrior"), 
	L_artiglio("The_Talon"), 
	Il_machete("The_Machete"), 
	Il_cobra("The_Cobra"), 
	La_katana("The_Katana"), 
	La_fucina("The_Forge"), 
	Grip_tattico("Tactical_Grip"), 
	Iltitano("The_Titan");

	private String nome;
	private EnumGrip(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumGrip from(String s) {
		EnumGrip[] values = EnumGrip.values();
		for (EnumGrip value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
	
}

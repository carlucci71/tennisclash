package tc;

public enum EnumScarpe implements EnumOggetti{
	La_piuma("The_Feather"), 
	Il_cacciatore("The_Hunter"), 
	Il_rapace("The_Raptor"), 
	Il_piragna("The_Piranha"), 
	La_shuriken("The_Shuriken"), 
	L_incudine("The_Anvil"), 
	La_balistica("The_Ballistic"), 
	PercorsiDiAde("The_Hades_Treads");
	
	private String nome;
	private EnumScarpe(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumScarpe from(String s) {
		EnumScarpe[] values = EnumScarpe.values();
		for (EnumScarpe value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
}

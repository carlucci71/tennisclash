package tc;

public enum EnumPersonaggi implements EnumOggetti{
	Victoria("Viktoria"), 
	Mei_Li("Mei-Li"), 
	Diana("Diana"), 
	Kaito("Kaito"), 
	Leo("Leo"), 
	Florence("Florence"), 
	Hope("Hope"), 
	Jonah("Jonah"), 
	Luc("Luc"),
	Omar("Omar"),
	Abeke("Abeke"),
	Anton("Anton");
	
	
	private String nome;
	private EnumPersonaggi(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumPersonaggi from(String s) {
		EnumPersonaggi[] values = EnumPersonaggi.values();
		for (EnumPersonaggi value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
	
	
}

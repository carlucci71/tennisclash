package tc;

public enum EnumNutrizione implements EnumOggetti{
	Carico_di_carboidrati("Carboload"), 
	Proteina_magra("Lean_Protein"), 
	Macrobiotico("Macrobiotic"), 
	Idratazione_aumentata("Increased_Hydration"), 
	Dieta_vegana("Vegan_Diet"), 
	Dieta_keto("Keto_Sourcing"), 
	Antiossidanti("Antioxidants"), 
	Neutral_energy("Natural_Energy");
	
	private String nome;
	private EnumNutrizione(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}

	public static EnumNutrizione from(String s) {
		EnumNutrizione[] values = EnumNutrizione.values();
		for (EnumNutrizione value : values) {
			if (value.getNome().equals(s)) return value;
		}
		return null;
	}
}

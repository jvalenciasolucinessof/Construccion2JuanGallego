package app.dto;

public class PetDto {
	private String namePet;
	private PersonDto ownerDocument;
	private int agePet;
	private long idPet; 
	private String species;
	private String race; 
	private String characteristics; 
	private int weight;

	
	public PetDto(String namePet, int agePet, String species, String race, String characteristics,
			int weight) {
		super();
		this.namePet = namePet;
		this.agePet = agePet;
		this.species = species;
		this.race = race;
		this.characteristics = characteristics;
		this.weight = weight;
	}
	public PetDto(long idPet) {
		this.idPet = idPet;
	}
	
	public String getNamePet() {
		return namePet;
	}
	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}
	public PersonDto getOwnerDocument() {
		return ownerDocument;
	}
	public void setOwnerDocument(PersonDto ownerDocument) {
		this.ownerDocument = ownerDocument;
	}
	public int getAgePet() {
		return agePet;
	}
	public void setAgePet(int agePet) {
		this.agePet = agePet;
	}
	public long getIdPet() {
		return idPet;
	}
	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	} 	
}

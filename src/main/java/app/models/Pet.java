package app.models;

public class Pet {
	private String namePet;
	private Person ownerDocument;
	private int agePet;
	private int idPet; 
	private String species;
	private String race; 
	private String characteristics; 
	private int weight;
	
	public String getNamePet() {
		return namePet;
	}
	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}
	public Person getOwnerDocument() {
		return ownerDocument;
	}
	public void setOwnerDocument(Person ownerDocument) {
		this.ownerDocument = ownerDocument;
	}
	public int getAgePet() {
		return agePet;
	}
	public void setAgePet(int agePet) {
		this.agePet = agePet;
	}
	public int getIdPet() {
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

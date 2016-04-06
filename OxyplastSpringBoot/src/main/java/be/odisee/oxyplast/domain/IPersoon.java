package be.odisee.oxyplast.domain;

public interface IPersoon {
	
	public int getID(String naam);
	public void setNaam(String naam);
	public String getNaam();
}

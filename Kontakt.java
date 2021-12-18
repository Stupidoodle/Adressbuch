 

public class Kontakt {
    private String name, vorname, adresse, telefonnummer;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public Kontakt(String pNummer, String pName, String pVorname, String pAdresse) {
        telefonnummer = pNummer;
        name = pName;
        vorname = pVorname;
        adresse = pAdresse;
    }

    @Override
    public String toString() {
    	return "Vorname: " + vorname + ", Name: " + name + ", Nummer: " + telefonnummer + ", Adresse: " + adresse;
    }
}

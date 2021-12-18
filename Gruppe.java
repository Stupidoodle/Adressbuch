 

public class Gruppe {
    private String name;
    private List<Kontakt> kontakte;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kontakt> getKontakte() {
        return kontakte;
    }
    
    public Gruppe(String pName) {
        name = pName;
        kontakte = new List<Kontakt>();
    }
    
    public void addKontakt(Kontakt pKontakt) {
        kontakte.toFirst();
        while (kontakte.hasAccess()) {
            if (pKontakt.getVorname().compareTo(kontakte.getContent().getVorname()) > 0) {
                kontakte.insert(pKontakt);
                return;
            }
            kontakte.next();
        }
        kontakte.append(pKontakt);
    }
    
    public void removeKontakt(Kontakt pKontakt) {
        kontakte.toFirst();
        while (kontakte.hasAccess()) {
            if (kontakte.getContent() == pKontakt) {
                kontakte.remove();
                return;
            }
            kontakte.next();
        }
    }

	public boolean contains(Kontakt pKontakt) {
		kontakte.toFirst();
		while (kontakte.hasAccess()) {
			 if (kontakte.getContent() == pKontakt)
	                return true;
			kontakte.next();
		}
		return false;
	}
}

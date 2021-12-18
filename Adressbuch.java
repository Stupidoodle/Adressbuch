 

public class Adressbuch {
	private List<Kontakt> kontakte;
	private List<Gruppe> gruppen;

	public Adressbuch() {
		kontakte = new List<Kontakt>();
		gruppen = new List<Gruppe>();
	}

	public boolean erstelleGruppe(String pName) {
		if (pName != null) {
			//prft, ob der Name bereits vorhanden ist
			gruppen.toFirst();
			while (gruppen.hasAccess()) {
				if (gruppen.getContent().getName().equals(pName)) 
					return false;
				gruppen.next();
			}
			
			//Ordnet die neue Gruppe lexikalisch ein
			gruppen.toFirst();
			while (gruppen.hasAccess()) {
				if (pName.compareTo(gruppen.getContent().getName()) < 0) {
					gruppen.insert(new Gruppe(pName));
					return true;
				}
				gruppen.next();
			}
			gruppen.append(new Gruppe(pName));
			return true;
		}
		return false;
	}

	public Gruppe getGruppe(String pName) {
		kontakte.toFirst();
		while (gruppen.hasAccess()) {
			if (gruppen.getContent().getName().equals(pName))
				return gruppen.getContent();
			gruppen.next();
		}
		return null;
	}

	public void removeGruppe(String pName) {
		kontakte.toFirst();
		while (gruppen.hasAccess()) {
			if (gruppen.getContent().getName().equals(pName))
				gruppen.remove();
			gruppen.next();
		}
	}

	public void addKontakt(Kontakt pKontakt) {
		kontakte.toFirst();
		while (kontakte.hasAccess()) {
			if (pKontakt.getVorname().compareTo(kontakte.getContent().getVorname()) < 0) {
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

	public Kontakt getKontaktName(String pName) {
		kontakte.toFirst();
		while (kontakte.hasAccess()) {
			if (kontakte.getContent().getName().equals(pName)) {
				return kontakte.getContent();
			}
			kontakte.next();
		}
		return null;
	}

	public Kontakt getKontaktVorname(String pName) {
		kontakte.toFirst();
		while (kontakte.hasAccess()) {
			if (kontakte.getContent().getVorname().equals(pName)) {
				return kontakte.getContent();
			}
			kontakte.next();
		}
		return null;
	}

	public List<Kontakt> getKontakte() {
		return kontakte;
	}

	public List<Gruppe> getGruppen() {
		return gruppen;
	}
}

 

import sum.komponenten.*;
import sum.ereignis.*;

public class AdressbuchGUI extends EBAnwendung {
	// Objekte
	private Etikett hatEtikettNeuerKontakt;
	private Etikett hatEtikettVorname;
	private Etikett hatEtikettNachname;
	private Etikett hatEtikettTelefonnummer;
	private Etikett hatEtikettAdresse;
	private Etikett hatEtikettAlleKontakte;
	private Etikett hatEtikettAlleGruppen;
	private Etikett hatEtikettKontakteDerGruppe;
	private Knopf hatKnopfKontaktLoeschen;
	private Knopf hatKnopfKontaktHinzufuegen;
	private Knopf hatKnopfGruppeLoeschen;
	private Knopf zweiterKnopfKontaktLoeschen;
	private Tabelle tabKontakte;
	private Tabelle tabGruppen;
	private Tabelle tabGruppenkontakte;
	private Textfeld tFVorname;
	private Textfeld tFName;
	private Textfeld tFNummer;
	private Textfeld tFAdresse;
	private Textfeld tFGruppenname;
	private Knopf bGruppeHinzufuegen;
	private Etikett hatEtikettGruppenname;
	private Etikett hatEtikettGruppe;
	private Knopf bKontaktZuGruppe;
	// Attribute
	private int selectedTab;
	private Kontakt selectedKontakt;
	private Gruppe selectedGruppe;
	private Adressbuch buch;

	/**
	 * Konstruktor
	 */
	public AdressbuchGUI() {
		// Initialisierung der Oberklasse
		super(1715, 1020);

		hatEtikettNeuerKontakt = new Etikett(150, 60, 100, 25, "Neuer Kontakt");
		hatEtikettNeuerKontakt.setzeAusrichtung(Ausrichtung.LINKS);

		// Kontaktetikette
		hatEtikettVorname = new Etikett(60, 120, 100, 25, "Vorname:");
		hatEtikettVorname.setzeAusrichtung(Ausrichtung.LINKS);

		hatEtikettNachname = new Etikett(60, 160, 100, 25, "Nachname:");
		hatEtikettNachname.setzeAusrichtung(Ausrichtung.LINKS);

		hatEtikettTelefonnummer = new Etikett(60, 200, 100, 25, "Telefonnummer:");
		hatEtikettTelefonnummer.setzeAusrichtung(Ausrichtung.LINKS);

		hatEtikettAdresse = new Etikett(60, 240, 100, 25, "Adresse:");
		hatEtikettAdresse.setzeAusrichtung(Ausrichtung.LINKS);

		// Kontakttextfelder
		tFVorname = new Textfeld(200, 120, 100, 25, "");
		tFVorname.setzeAusrichtung(Ausrichtung.LINKS);

		tFName = new Textfeld(200, 160, 100, 25, "");
		tFName.setzeAusrichtung(Ausrichtung.LINKS);

		tFNummer = new Textfeld(200, 200, 100, 25, "");
		tFNummer.setzeAusrichtung(Ausrichtung.LINKS);

		tFAdresse = new Textfeld(200, 240, 100, 25, "");
		tFAdresse.setzeAusrichtung(Ausrichtung.LINKS);

		// Kontaktspeicherknopf
		hatKnopfKontaktHinzufuegen = new Knopf(360, 200, 140, 25, "Kontakt speichern");
		hatKnopfKontaktHinzufuegen.setzeBearbeiterGeklickt("hatKnopfKontaktHinzufuegenGeklickt");

		// Gruppen hinzufuegen
		hatEtikettGruppe = new Etikett(580, 60, 100, 25, "Neue Gruppe:");
		hatEtikettGruppe.setzeAusrichtung(Ausrichtung.LINKS);

		hatEtikettGruppenname = new Etikett(540, 120, 100, 25, "Gruppenname:");
		hatEtikettGruppenname.setzeAusrichtung(Ausrichtung.LINKS);

		tFGruppenname = new Textfeld(680, 120, 100, 25, "");
		tFGruppenname.setzeAusrichtung(Ausrichtung.LINKS);

		bGruppeHinzufuegen = new Knopf(820, 200, 140, 25, "Gruppe speichern");
		bGruppeHinzufuegen.setzeBearbeiterGeklickt("bGruppeHinzufuegen");

		bKontaktZuGruppe = new Knopf(668, 486, 134, 37, "Kontakt hinzufügen");
		bKontaktZuGruppe.setzeBearbeiterGeklickt("bKontaktZuGruppe");

		// Tabellen
		tabKontakte = new Tabelle(50, 419, 302, 418, 0, 4);
		tabKontakte.setzeBearbeiterMarkierungGeaendert("tabKontakteMarkierungGeaendert");
		tabKontakte.setzeSpaltentitelAn("Vorname", 1);
		tabKontakte.setzeSpaltentitelAn("Name", 2);
		tabKontakte.setzeSpaltentitelAn("Telefonnummer", 3);
		tabKontakte.setzeSpaltentitelAn("Adresse", 4);

		tabGruppen = new Tabelle(532, 422, 128, 414, 0, 1);
		tabGruppen.setzeBearbeiterMarkierungGeaendert("tabGruppenMarkierungGeaendert");
		tabGruppen.setzeSpaltentitelAn("Gruppenname", 1);

		tabGruppenkontakte = new Tabelle(846, 420, 291, 417, 0, 4);
		tabGruppenkontakte.setzeBearbeiterMarkierungGeaendert("tabGruppenkontakteMarkierungGeaendert");
		tabGruppenkontakte.setzeSpaltentitelAn("Vorname", 1);
		tabGruppenkontakte.setzeSpaltentitelAn("Name", 2);
		tabGruppenkontakte.setzeSpaltentitelAn("Telefonnummer", 3);
		tabGruppenkontakte.setzeSpaltentitelAn("Adresse", 4);

		hatEtikettAlleKontakte = new Etikett(109, 344, 100, 25, "Alle Kontakte:");
		// Ausrichtung
		hatEtikettAlleKontakte.setzeAusrichtung(Ausrichtung.LINKS);
		hatEtikettAlleGruppen = new Etikett(539, 342, 100, 25, "Alle Gruppen:");
		// Ausrichtung
		hatEtikettAlleGruppen.setzeAusrichtung(Ausrichtung.LINKS);
		hatEtikettKontakteDerGruppe = new Etikett(843, 343, 121, 27, "Kontakte der Gruppe:");
		// Ausrichtung
		hatEtikettKontakteDerGruppe.setzeAusrichtung(Ausrichtung.LINKS);
		hatKnopfKontaktLoeschen = new Knopf(370, 427, 120, 36, "Kontakt löschen");
		hatKnopfKontaktLoeschen.setzeBearbeiterGeklickt("hatKnopfKontaktLoeschenGeklickt");
		hatKnopfGruppeLoeschen = new Knopf(668, 426, 114, 37, "Gruppe löschen");
		hatKnopfGruppeLoeschen.setzeBearbeiterGeklickt("hatKnopfGruppeLoeschenGeklickt");
		zweiterKnopfKontaktLoeschen = new Knopf(1154, 418, 114, 38, "Kontakt löschen");
		zweiterKnopfKontaktLoeschen.setzeBearbeiterGeklickt("zweiterKnopfKontaktLoeschenGeklickt");

		buch = new Adressbuch();
		selectedTab = -1;
	}

	
	
	public void bKontaktZuGruppe() {
		if (selectedTab != 2 && selectedGruppe != null && selectedKontakt != null) {
			if (!selectedGruppe.contains(selectedKontakt))
				selectedGruppe.addKontakt(selectedKontakt);
			tabGruppenkontakte.setzeZeilenanzahl(tabGruppenkontakte.zeilenanzahl() + 1);
			updateGruppenkontakte();
			tabKontakte.markiereNichts();
			tFVorname.setzeInhalt("");
			tFName.setzeInhalt("");
			tFNummer.setzeInhalt("");
			tFAdresse.setzeInhalt("");
		}
	}

	public void bGruppeHinzufuegen() {
		if (selectedGruppe != null) {
			selectedGruppe.setName(tFGruppenname.inhaltAlsText());
		} else {
			if (buch.erstelleGruppe(tFGruppenname.inhaltAlsText()))
				tabGruppen.setzeZeilenanzahl(tabGruppen.zeilenanzahl() + 1);
		}
		updateGruppen();
		tFGruppenname.setzeInhalt("");
		tabGruppen.markiereNichts();
	}

	/**
	 * Speichert die Kontaktdaten. Wenn kein Kontakt ausgewählt ist, wird ein neuer
	 * erstellt.
	 */
	public void hatKnopfKontaktHinzufuegenGeklickt() {
		if (selectedKontakt != null) {
			selectedKontakt.setAdresse(tFAdresse.inhaltAlsText());
			selectedKontakt.setName(tFName.inhaltAlsText());
			selectedKontakt.setVorname(tFVorname.inhaltAlsText());
			selectedKontakt.setTelefonnummer(tFNummer.inhaltAlsText());
		} else {
			
			buch.addKontakt(new Kontakt(tFNummer.inhaltAlsText(), tFName.inhaltAlsText(), tFVorname.inhaltAlsText(),
					tFAdresse.inhaltAlsText()));
			tabKontakte.setzeZeilenanzahl(tabKontakte.zeilenanzahl() + 1);
		}
		if (selectedTab != 0) updateGruppenkontakte();
		updateKontakte();
		
		tFVorname.setzeInhalt("");
		tFName.setzeInhalt("");
		tFNummer.setzeInhalt("");
		tFAdresse.setzeInhalt("");
		tabKontakte.markiereNichts();
	}

	//Tabellenupdates:

	/**
	 * Aktualisiert die Gruppentabelle
	 */
	public void updateGruppen() {
		tabGruppen.gibFrei();
		buch.getGruppen().toFirst();
		int z = 1;
		while (buch.getGruppen().hasAccess()) {
			tabGruppen.setzeInhaltAn(buch.getGruppen().getContent().getName(), z, 1);
			z++;
			buch.getGruppen().next();
		}
	}

	
	/**
	 * Aktualisiert die Kontakttabelle
	 */
	public void updateKontakte() {
		tabKontakte.gibFrei();
		int i = 1;
		buch.getKontakte().toFirst();
		Kontakt k = null;
		while (buch.getKontakte().hasAccess()) {
			k = buch.getKontakte().getContent();
			tabKontakte.setzeInhaltAn(k.getVorname(), i, 1);
			tabKontakte.setzeInhaltAn(k.getName(), i, 2);
			tabKontakte.setzeInhaltAn(k.getTelefonnummer(), i, 3);
			tabKontakte.setzeInhaltAn(k.getAdresse(), i, 4);
			buch.getKontakte();
		}
	}

	/**
	 * Aktualisiert die Gruppenkontakttabelle
	 */
	public void updateGruppenkontakte() {
		tabGruppenkontakte.gibFrei();
		selectedGruppe.getKontakte().toFirst();
		int z = 1;
		while (selectedGruppe.getKontakte().hasAccess()) {
			Kontakt k = selectedGruppe.getKontakte().getContent();
			tabGruppenkontakte.setzeInhaltAn(k.getVorname(), z, 1);
			tabGruppenkontakte.setzeInhaltAn(k.getName(), z, 2);
			tabGruppenkontakte.setzeInhaltAn(k.getTelefonnummer(), z, 3);
			tabGruppenkontakte.setzeInhaltAn(k.getAdresse(), z, 4);
			z++;
			selectedGruppe.getKontakte().next();
		}
	}

	//Ausgewählte Zeile wird erkannt:
	
	/**
	 * Wählt den Kontakt nach der ausgewählten Zeile in der Tabelle Kontakte
	 */
	public void selectKontakt() {
		buch.getKontakte().toFirst();
		for (int i = 1; i < tabKontakte.zeilenanzahl() + 1; i++) {
			if (tabKontakte.istZeileMarkiert(i)) {
				selectedKontakt = buch.getKontakte().getContent();
				tFVorname.setzeInhalt(selectedKontakt.getVorname());
				tFAdresse.setzeInhalt(selectedKontakt.getAdresse());
				tFNummer.setzeInhalt(selectedKontakt.getTelefonnummer());
				tFName.setzeInhalt(selectedKontakt.getName());
				return;
			}
			buch.getKontakte().next();
		}
	}

	/**
	 * Wählt den Kontakt nach der ausgewählten Zeile in der Tabelle Kontakte
	 */
	public void selectGruppe() {
		buch.getGruppen().toFirst();
		for (int i = 1; i < tabGruppen.zeilenanzahl() + 1; i++) {
			if (tabGruppen.istZeileMarkiert(i)) {
				selectedGruppe = buch.getGruppen().getContent();
				tFGruppenname.setzeInhalt(selectedGruppe.getName());
				return;
			}
			buch.getGruppen().next();
		}
	}

	/**
	 * Wählt den Kontakt nach der ausgewählten Zeile in der Tabelle Kontakte
	 */
	public void selectGruppenkontakt() {
		if (selectedGruppe != null) {
			selectedGruppe.getKontakte().toFirst();
			for (int i = 1; i < tabGruppenkontakte.zeilenanzahl() + 1; i++) {
				if (tabGruppenkontakte.istZeileMarkiert(i)) {
					selectedKontakt = selectedGruppe.getKontakte().getContent();
					tFVorname.setzeInhalt(selectedKontakt.getVorname());
					tFAdresse.setzeInhalt(selectedKontakt.getAdresse());
					tFNummer.setzeInhalt(selectedKontakt.getTelefonnummer());
					tFName.setzeInhalt(selectedKontakt.getName());
					return;
				}
				selectedGruppe.getKontakte().next();
			}
		}
	}

	//Löschknöpfe:
	
	/**
	 * Löscht den ausgewählten Kontakt aus der alle Kontakte Liste
	 */
	public void hatKnopfKontaktLoeschenGeklickt() {
		if (selectedKontakt != null && selectedTab == 0) {
			int i = 0;
			buch.getKontakte().toFirst();
			while (buch.getKontakte().hasAccess() && buch.getKontakte().getContent() != selectedKontakt) {
				buch.getKontakte().next();
			}
			if (buch.getKontakte().hasAccess())
				buch.getKontakte().remove();
			tabKontakte.entferneZeileAn(i);
			selectedKontakt = null;
		}
	}

	/**
	 * Löscht die ausgewählte Gruppe
	 */
	public void hatKnopfGruppeLoeschenGeklickt() {
		if (selectedGruppe != null) {
			int i = 0;
			buch.getGruppen().toFirst();
			while (buch.getGruppen().hasAccess() && buch.getGruppen().getContent() != selectedGruppe) {
				buch.getGruppen().next();
			}
			if (buch.getGruppen().hasAccess())
				buch.getGruppen().remove();
			tabGruppen.entferneZeileAn(i);
			selectedGruppe = null;
		}
	}

	/**
	 * Löscht den ausgewählen Kontakt aus der Gruppe, jedoch nicht insgesamt
	 */
	public void zweiterKnopfKontaktLoeschenGeklickt() {
		if (selectedGruppe != null && selectedKontakt != null && selectedTab == 2) {
			int i = 0;
			selectedGruppe.getKontakte().toFirst();
			while (selectedGruppe.getKontakte().hasAccess()
					&& selectedGruppe.getKontakte().getContent() != selectedKontakt) {
				selectedGruppe.getKontakte().next();
			}
			if (selectedGruppe.getKontakte().hasAccess())
				selectedGruppe.getKontakte().remove();
			tabGruppenkontakte.entferneZeileAn(i);
			selectedKontakt = null;
		}
	}

	//Tabellenlistener:
	
	/**
	 * Listener, wählt die angeklickte Zeile aus und selektiert die Tabelle Kontakte
	 */
	public void tabKontakteMarkierungGeaendert() {
		selectedTab = 0;
		selectKontakt();
	}

	/**
	 * Listener, wählt die angeklickte Zeile aus und selektiert die Tabelle Gruppen
	 */
	public void tabGruppenMarkierungGeaendert() {
		selectedTab = 1;
		selectGruppe();
	}

	/**
	 * Listener, wählt die angeklickte Zeile aus und selektiert die Tabelle
	 * Gruppenkontakte
	 */
	public void tabGruppenkontakteMarkierungGeaendert() {
		selectedTab = 2;
		selectGruppenkontakt();
	}

}

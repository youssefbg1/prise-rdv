package tn.medecins.prise_rdv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.medecins.prise_rdv.entity.Creneau;
import tn.medecins.prise_rdv.entity.Medecin;
import tn.medecins.prise_rdv.entity.RendezVous;
import tn.medecins.prise_rdv.entity.Specialite;
import tn.medecins.prise_rdv.entity.StatutCreneau;
import tn.medecins.prise_rdv.entity.StatutRendezVous;
import tn.medecins.prise_rdv.service.CreneauService;
import tn.medecins.prise_rdv.service.MedecinService;
import tn.medecins.prise_rdv.service.RendezVousService;
import tn.medecins.prise_rdv.service.SpecialiteService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PriseRdvApplicationTests {
	@Autowired
	private SpecialiteService specialiteService;

	@Autowired
	private MedecinService medecinService;

	@Autowired
	private CreneauService creneauService;

	@Autowired
	private RendezVousService rendezVousService;

	@Test
	void contextLoads() {
	}

	@Test
	void rendezVousConserveDateHoraireEtStatutsDuCreneau() {
		Specialite specialite = specialiteService.addSpecialite("Cardiologie", "Cœur");
		Medecin medecin = medecinService.addMedecin("Ben Ali", "Amine", "MED002", List.of(specialite));
		LocalDate date = LocalDate.of(2026, 12, 1);
		LocalTime heureDebut = LocalTime.of(10, 0);
		LocalTime heureFin = LocalTime.of(10, 30);
		Creneau creneau = creneauService.addCreneauToMedecin(medecin, date, heureDebut, heureFin);

		RendezVous rendezVous = rendezVousService.addRendezVous(medecin.getId(), creneau);

		assertNotNull(rendezVous);
		assertNotNull(rendezVous.getDateCreation());
		assertNotNull(rendezVous.getCreneau());
		assertEquals(date, rendezVous.getCreneau().getDate());
		assertEquals(heureDebut, rendezVous.getCreneau().getHeureDebut());
		assertEquals(heureFin, rendezVous.getCreneau().getHeureFin());
		assertEquals(StatutRendezVous.PLANIFIE, rendezVous.getStatut());
		assertEquals(StatutCreneau.RESERVE, creneau.getStatut());
		assertEquals(specialite, medecin.getSpecialite());
	}

}

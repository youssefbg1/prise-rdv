package tn.medecins.prise_rdv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.medecins.prise_rdv.entity.Creneau;
import tn.medecins.prise_rdv.entity.Medecin;
import tn.medecins.prise_rdv.entity.RendezVous;
import tn.medecins.prise_rdv.entity.Specialite;
import tn.medecins.prise_rdv.service.CreneauService;
import tn.medecins.prise_rdv.service.MedecinService;
import tn.medecins.prise_rdv.service.RendezVousService;
import tn.medecins.prise_rdv.service.SpecialiteService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class PriseRdvApplication {
	public static void main(String[] args) {
		SpringApplication.run(PriseRdvApplication.class, args);
	}
	@Bean
    CommandLineRunner demo(
			SpecialiteService specialiteService,
			MedecinService medecinService,
			CreneauService creneauService,
			RendezVousService rendezVousService) {
		return args -> {
// 1. Créer une spécialité
			Specialite specialite = specialiteService.addSpecialite(
					"Cardiologie",

					"Spécialité médicale du cœur"

			);
// 2. Créer un médecin avec au moins une spécialité
			Medecin medecin = medecinService.addMedecin(
					"Ben Ali",
					"Amine",
					"MED001",
					List.of(specialite)

			);

// 3. Créer un créneau pour ce médecin
			Creneau creneau = creneauService.addCreneauToMedecin(
					medecin,

					LocalDate.now().plusDays(2),

					LocalTime.of(9, 0),
					LocalTime.of(9, 30)
			);
// 4. Demander au service de créer le rendez-vous
			RendezVous rdv=null;
			try {
				rdv = rendezVousService.addRendezVous(
						medecin.getId(), creneau
				);

				System.out.println("Rendez-vous créé avec succès.");
				System.out.println(rdv);
			} catch (IllegalArgumentException | IllegalStateException e) {
				System.err.println("Erreur : " + e.getMessage());
			}

// 5. Afficher le résultat dans la console
			System.out.println("===== RENDEZ-VOUS CREE =====");
			System.out.println("Identifiant : " + rdv.getId());
			System.out.println("Médecin : "
					+ medecin.getPrenom() + " " + medecin.getNom());
			System.out.println("Spécialité : "
					+ specialite.getNom());
			System.out.println("Date : "
					+ rdv.getCreneau().getDate());
			System.out.println("Horaire : "
					+ rdv.getCreneau().getHeureDebut()

					+ " - "

					+ rdv.getCreneau().getHeureFin());
			System.out.println("Statut : " + rdv.getStatut());
			System.out.println("===========================");
		};
	}
}

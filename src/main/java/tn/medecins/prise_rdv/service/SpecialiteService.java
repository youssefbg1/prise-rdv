package tn.medecins.prise_rdv.service;

import org.springframework.stereotype.Service;
import tn.medecins.prise_rdv.entity.Specialite;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialiteService {
    private final List<Specialite> specialites = new ArrayList<>();
    private Long prochainId = 1L;
    public Specialite addSpecialite(
            String nom,
            String description) {

        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException(
                    "Le nom de la spécialité est obligatoire."
            );
        }

        Specialite specialite = new Specialite(
                prochainId++,
                nom,
                description
        );
        specialites.add(specialite);
        return specialite;
    }
}
package fr.treeptik.service;

import java.util.List;

import fr.treeptik.pojo.Facture;

public interface FactureService {
 void saveFacture(Facture s);
 public List<Facture> findByMontantGreaterThanEqual(Double montant);
 Facture find(Integer id);
 List<Facture> findAllCustom();
}

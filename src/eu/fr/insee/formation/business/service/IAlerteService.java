package eu.fr.insee.formation.business.service;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Alerte;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IAlerteService {

	public List<Alerte> findAll();

	public Alerte findById(Long id) throws EcolisBusinessException;

	public Long createAlerte(Alerte alert) throws EcolisBusinessException;

	public void deleteById(Long id) throws EcolisBusinessException;

	public Alerte updateVilleDepartVilleArriveeById(Long id, String villeDepart, String villeArrivee)
			throws EcolisBusinessException;

}

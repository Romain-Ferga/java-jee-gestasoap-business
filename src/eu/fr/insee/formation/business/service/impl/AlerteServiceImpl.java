package eu.fr.insee.formation.business.service.impl;

import java.util.List;

import javax.jws.WebService;

import eu.fr.insee.formation.business.dao.IAlerteDAO;
import eu.fr.insee.formation.business.dao.impl.AlerteDAOImpl;
import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Alerte;
import eu.fr.insee.formation.business.service.IAlerteService;
import eu.fr.insee.formation.business.utils.GestaConstantesBusiness;

@WebService(serviceName = GestaConstantesBusiness.ALERTE_SERVICE_NAME, endpointInterface = "eu.fr.insee.formation.business.service.IAlerteService")
public class AlerteServiceImpl implements IAlerteService {

	private IAlerteDAO alertDAO = null;

	public AlerteServiceImpl() {

		this.alertDAO = new AlerteDAOImpl();

	}

	@Override
	public List<Alerte> findAll() {

		return this.alertDAO.findAll();

	}

	@Override
	public Alerte findById(Long id) throws EcolisBusinessException {

		return this.alertDAO.findById(id);

	}

	@Override
	public Long createAlerte(Alerte alert) throws EcolisBusinessException {

		return this.alertDAO.createEntity(alert);

	}

	@Override
	public void deleteById(Long id) throws EcolisBusinessException {

		this.alertDAO.deleteEntityById(id);

	}

	@Override
	public Alerte updateVilleDepartVilleArriveeById(Long id, String villeDepart, String villeArrivee)
			throws EcolisBusinessException {

		return this.alertDAO.updateVilleDepartVilleArriveeById(id, villeDepart, villeArrivee);

	}

}

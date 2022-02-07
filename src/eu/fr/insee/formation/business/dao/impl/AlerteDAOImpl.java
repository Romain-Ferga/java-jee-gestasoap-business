package eu.fr.insee.formation.business.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.fr.insee.formation.business.dao.IAlerteDAO;
import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Alerte;

public class AlerteDAOImpl implements IAlerteDAO {

	private List<Alerte> alerteList;

	public AlerteDAOImpl() {
		this.alerteList = new ArrayList<Alerte>();
		Alerte a1 = new Alerte(null, "Douala-Cameroun", "Paris-France", new Date());
		Alerte a2 = new Alerte(null, "Rennes-France", "Nice-France", new Date());
		Alerte a3 = new Alerte(null, "Bruxelles-Belgique", "Munich-Allemagne", new Date());
		Alerte a4 = new Alerte(null, "Budapest-Hongrie", "New-York-USA", new Date());
		this.alerteList.add(a1);
		this.alerteList.add(a2);
		this.alerteList.add(a3);
		this.alerteList.add(a4);
	}

	@Override
	public List<Alerte> findAll() {
		return this.alerteList;
	}

	@Override
	public Alerte findById(Long id) throws EcolisBusinessException {
		for (Alerte alerte : alerteList) {
			if (alerte.getIdAlerte().equals(id)) {
				return alerte;
			}
		}
		return null;
	}

	@Override
	public Long createEntity(Alerte ent) throws EcolisBusinessException {

		ent.setIdAlerte(System.currentTimeMillis());

		this.alerteList.add(ent);

		return ent.getIdAlerte();
	}

	@Override
	public void deleteEntityById(Long id) throws EcolisBusinessException {

		Alerte alerteToDelete = this.findById(id);

		if (alerteToDelete != null) {

			this.alerteList.remove(alerteToDelete);

		}

	}

	@Override
	public List<Alerte> findByVilleDepart(String villeDep) {

		List<Alerte> alerteByVilleDepartList = new ArrayList<Alerte>();

		for (Alerte alerte : alerteList) {

			if (alerte.getVilleDepart().equals(villeDep)) {

				alerteByVilleDepartList.add(alerte);

			}

		}

		return this.alerteList;

	}

	@Override
	public Alerte updateVilleDepartVilleArriveeById(Long id, String villeDepart, String villeArrivee)
			throws EcolisBusinessException {

		Alerte alerteToUpdate = this.findById(id);

		alerteToUpdate.setVilleDepart(villeDepart);

		alerteToUpdate.setVilleArrivee(villeArrivee);

		return alerteToUpdate;

	}

}

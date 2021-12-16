package eu.fr.insee.formation.business.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;

import eu.fr.insee.formation.business.dao.IUtilisateurDAO;
import eu.fr.insee.formation.business.dao.impl.UtilisateurDAOImpl;
import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Utilisateur;
import eu.fr.insee.formation.business.service.IUtilisateurService;
import eu.fr.insee.formation.business.utils.GestaConstantesBusiness;

@WebService(serviceName=GestaConstantesBusiness.USER_SERVICE_NAME,endpointInterface = "eu.fr.insee.formation.business.service.IUtilisateurService")
public class UtilisateurServiceImpl implements IUtilisateurService{

	private IUtilisateurDAO userDAO = null;
	
	public UtilisateurServiceImpl() {
		this.userDAO = new UtilisateurDAOImpl();
	}
	
	@Override
	public Utilisateur findByEmailAndPassword(String email, String password) throws EcolisBusinessException{
		if (StringUtils.isBlank(email) || StringUtils.isBlank(password)){
			throw new EcolisBusinessException("VOUS DEVEZ RENSEINGER LES 2 CHAMPS");
		}
		return userDAO.findByEmailAndPassword(email, password);
	}

	@Override
	public List<Utilisateur> findAuthorsCommentByDateAndPostedAnnonce(Date paramDatePivot, String paramVilleArrivee) throws EcolisBusinessException{
		if (StringUtils.isBlank(paramVilleArrivee) || paramDatePivot == null){
			throw new EcolisBusinessException("VOUS DEVEZ RENSEINGER LES 2 CHAMPS");
		}
		return userDAO.findAuthorsCommentByDateAndPostedAnnonce(paramDatePivot, paramVilleArrivee);
	}

	@Override
	public Utilisateur findByEmail(String email) throws EcolisBusinessException{
		if (StringUtils.isBlank(email)) throw new EcolisBusinessException("VOUS DEVEZ RENSEINGER L'EMAIL");
		return this.userDAO.findByEmail(email);
	}

	@Override
	public List<Utilisateur> findAll() {
		List<Utilisateur> userList = this.userDAO.findAll();
		deleteAssociatedBean(userList);
		return userList;
	}
	
	
	private void deleteAssociatedBean(List<Utilisateur> userList){
		for (Utilisateur utilisateur : userList) {
			utilisateur.setAnnonces(null);
			utilisateur.setComments(null);
			utilisateur.setImages(null);
		}
	}

	@Override
	public Utilisateur findById(Long id) throws EcolisBusinessException {
		Utilisateur utilisateur = this.userDAO.findById(id);
		utilisateur.setAnnonces(null);
		utilisateur.setComments(null);
		utilisateur.setImages(null);
		return utilisateur;
	}

	@Override
	public Long createUser(Utilisateur user) throws EcolisBusinessException {
		Long newUserId = this.userDAO.createEntity(user);
		return newUserId;
	}

}

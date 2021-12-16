package eu.fr.insee.formation.business.dao;

import java.util.Date;
import java.util.List;

import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Message;

public interface IMessageDAO extends ICommunDAO<Message>{

	/**
	 * Modifie le corps des messages d'un utilisateur postés après une certaine date
	 * @param userId : Identifiant de l'utilisateur
	 * @param dtCreation : Date de creation du message
	 * @param newMsg : Nouveau message de l'annonce
	 * @throws EcolisBusinessException
	 */
	public void setMessageBodyByUserIdAndCreatedDate(String newMsg,Integer userId,Date dtCreation) throws EcolisBusinessException;
	
	public List<Message> getMessageByUserEmail(String email) throws EcolisBusinessException;
}

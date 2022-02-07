package eu.fr.insee.formation.business.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.fr.insee.formation.business.dao.IMessageDAO;
import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Annonce;
import eu.fr.insee.formation.business.entity.Message;

public class MessageDAOImpl implements IMessageDAO {

	private List<Message> messageList;

	public MessageDAOImpl() {

		this.messageList = new ArrayList<Message>();

		Message m1 = new Message(new Annonce(), new Date());
		Message m2 = new Message(new Annonce(), new Date());
		Message m3 = new Message(new Annonce(), new Date());
		Message m4 = new Message(new Annonce(), new Date());

		this.messageList.add(m1);
		this.messageList.add(m2);
		this.messageList.add(m3);
		this.messageList.add(m4);

	}

	@Override
	public List<Message> findAll() {

		return this.messageList;

	}

	@Override
	public Message findById(Long id) throws EcolisBusinessException {

		for (Message message : this.messageList) {

			if (message.getIdMessage().equals(id))
				return message;

		}

		return null;
	}

	@Override
	public Long createEntity(Message ent) throws EcolisBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntityById(Long id) throws EcolisBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMessageBodyByUserIdAndCreatedDate(String newMsg, Integer userId, Date dtCreation)
			throws EcolisBusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Message> getMessageByUserEmail(String email) throws EcolisBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}

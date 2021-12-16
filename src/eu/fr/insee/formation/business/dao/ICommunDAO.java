package eu.fr.insee.formation.business.dao;

import java.util.List;

import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;

public interface ICommunDAO<E> {

	/**
	 * Retourne la liste des entités
	 * @return
	 */
	public List<E> findAll();
	/**
	 * Retourne une entité par son identifiant
	 * @param id : Identifiant pour lequel on souhaite retourner l'entité
	 * @return
	 * @throws EcolisBusinessException
	 */
	public E findById(Long id) throws EcolisBusinessException;
	/**
	 * Permet de créer une nouvelle entité
	 * @param ent
	 * @return
	 * @throws EcolisBusinessException
	 */
	public Long createEntity(E ent) throws EcolisBusinessException;
	/**
	 * Permet de supprimer une entité par son identifiant
	 * @param id : Identifiant de l'entité à supprimer
	 * @throws EcolisBusinessException
	 */
	public void deleteEntityById(Long id) throws EcolisBusinessException;
}

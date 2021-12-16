package eu.fr.insee.formation.business.service;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Utilisateur;

/**
 * 
 * @author CHZOME
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface IUtilisateurService {

	/**
     * recupere un utilisateur par son login et son password
     * @param login : Login de l'utilisateur qu'on souhaite recuperer
     * @param password : Password de l'utilisateur qu'on souhaite recuperer
     * @return : Utilisateur recherche
     */
	public Utilisateur findByEmailAndPassword(String login,String password) throws EcolisBusinessException ;
    /**
     * Remonte les auteurs de comment postes apres une date et ayant deposé une annonce pour ville arrivee donnée
     * @param pDatePivot : Date pivot de depot du commentaire
     * @param pVilleArrivee : Ville d'arrivée
     * @return
     */
    public List<Utilisateur> findAuthorsCommentByDateAndPostedAnnonce(Date paramDatePivot,String paramVilleArrivee) throws EcolisBusinessException;
    /**
     * Recupere un utilisateur par son email
     * @param email
     * @return
     */
    public Utilisateur findByEmail(String email) throws EcolisBusinessException;
    
    /**
     * Recupere un utilisateur par son id
     * @param id : Identifiant de l'utilisateur qu'on souhaite recuperer
     * @return
     * @throws EcolisBusinessException
     */
    public Utilisateur findById(Long id) throws EcolisBusinessException;
    /**
     * Remonte tous les utilisateurs
     * @return
     */
	List<Utilisateur> findAll();
	/**
	 * Cree un nouvel utilisateur
	 * @param user  : Utilisateur à créer
	 * @return  : Retourne l'identifiant de l'utilisateur en cours de création
	 * @throws EcolisBusinessException
	 */
	public Long createUser(Utilisateur user) throws EcolisBusinessException;
}

package eu.fr.insee.formation.business.dao;

import java.util.Date;
import java.util.List;

import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Utilisateur;

public interface IUtilisateurDAO extends ICommunDAO<Utilisateur> {
	/**
     * recupere un utilisateur par son login et son password
     * @param email : Login de l'utilisateur qu'on souhaite recuperer
     * @param password : Password de l'utilisateur qu'on souhaite recuperer
     * @return : Utilisateur recherche
     */
    public Utilisateur findByEmailAndPassword(String email,String password);
    /**
     * Remonte les auteurs de comment postés après une date et ayant déposé une annonce pour ville arrivee donnée
     * @param pDatePivot : Date pivot de depot du commentaire
     * @param pVilleArrivee : Ville d'arrivée
     * @return
     */
    public List<Utilisateur> findAuthorsCommentByDateAndPostedAnnonce(Date paramDatePivot,String paramVilleArrivee);
    
    public Utilisateur findByEmail(String email);
    
    
    /**
     * Renvoie tous les utilisateurs possedant un telephone et dont l'adresse mail est d'un domaine donné
     * @param domaineP : Domaine pour lequel on recherche des utilisateurs
     * @return
     * @throws EcolisBusinessException
     */
    public List<Utilisateur> getUtilisateurParDomaineEtPossedantTel(String domaineP) throws EcolisBusinessException;
}

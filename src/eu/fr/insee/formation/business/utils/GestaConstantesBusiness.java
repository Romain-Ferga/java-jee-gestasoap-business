package eu.fr.insee.formation.business.utils;
/**
 * Classe de constantes
 * @author CHZOME
 *
 */
public class GestaConstantesBusiness {

	public final static String SERVER_IP = "127.0.0.1";
    public final static Integer SERVER_PORT = 9898;
    public final static String URL_USER_PATH = "http://"+SERVER_IP+":"+SERVER_PORT+"/gestache/users?wsdl";
    public final static String URL_ALERTE_PATH = "http://"+SERVER_IP+":"+SERVER_PORT+"/gestache/alertes?wsdl";
    public final static String TARGET_NAMESPACE = "http://impl.service.business.formation.insee.fr.eu/";
    public final static String USER_SERVICE_NAME = "utilisateurServiceBean";
    public final static String ALERTE_SERVICE_NAME = "alerteServiceBean";
    public final static String LOGIN_ADMIN_USER = "admin";
    public final static String PWD_ADMIN_USER = "admin";
}

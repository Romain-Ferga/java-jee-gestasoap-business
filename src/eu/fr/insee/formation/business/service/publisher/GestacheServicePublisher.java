package eu.fr.insee.formation.business.service.publisher;

/**
 * 
 * @author CHZOME
 *
 */

import javax.xml.ws.Endpoint;

import eu.fr.insee.formation.business.service.impl.AlerteServiceImpl;
import eu.fr.insee.formation.business.service.impl.UtilisateurServiceImpl;
import eu.fr.insee.formation.business.utils.GestaConstantesBusiness;

public class GestacheServicePublisher {

	public static void main(String[] args) {

		System.out.println("Beginning to publish Gesta Service now");

		Endpoint.publish("http://" + GestaConstantesBusiness.SERVER_IP + ":" + GestaConstantesBusiness.SERVER_PORT
				+ "/gestache/users", new UtilisateurServiceImpl());

		System.out.println("Users Done publishing...");

		Endpoint.publish("http://" + GestaConstantesBusiness.SERVER_IP + ":" + GestaConstantesBusiness.SERVER_PORT
				+ "/gestache/alertes", new AlerteServiceImpl());

		System.out.println("Alerts Done publishing...");

	}
}

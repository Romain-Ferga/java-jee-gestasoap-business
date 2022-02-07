package eu.fr.insee.formation.business.service.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.fr.insee.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.insee.formation.business.entity.Alerte;
import eu.fr.insee.formation.business.service.IAlerteService;
import eu.fr.insee.formation.business.utils.GestaConstantesBusiness;

public class AlerteServiceTest {

	private Service service;

	@Before
	public void initService() throws MalformedURLException {

		URL url = new URL(GestaConstantesBusiness.URL_ALERTE_PATH);

		QName qname = new QName(GestaConstantesBusiness.TARGET_NAMESPACE, GestaConstantesBusiness.ALERTE_SERVICE_NAME);

		this.service = Service.create(url, qname);

	}

	@Test
	public void testGetAllAlerts() {

		IAlerteService alerteSoapService = service.getPort(IAlerteService.class);

		List<Alerte> alertList = alerteSoapService.findAll();

		Assert.assertTrue(alertList.size() > 0);

		System.out.println("List ==>" + alertList);

	}

	@Test
	public void testGetAlertById() throws EcolisBusinessException {

		IAlerteService alertSoapService = service.getPort(IAlerteService.class);

		Alerte alert = alertSoapService.findById(1644253828355L);

		Assert.assertTrue(alert != null && alert.getVilleDepart().equals("Douala-Cameroun")
				&& alert.getVilleArrivee().equals("Paris-France"));

		System.out.println("Alert  ==>" + alert);

	}

	@Test
	public void testAddAlert() throws EcolisBusinessException {

		IAlerteService alertSoapService = service.getPort(IAlerteService.class);

		Alerte alert1 = new Alerte();

		alertSoapService.createAlerte(alert1);

		Assert.assertNotNull(alert1.getIdAlerte());

	}

	@Test
	public void testUpdateVilleDepartVilleArriveeById() throws EcolisBusinessException { // TODO: J'ai une sacrée sale
																							// erreur SOAPFaultException
																							// , mais pourtant ca marche
																							// dans SOAP UI..

		Long id = 1644255270798L;

		String villeDepart = "Asnières - France";

		String villeArrivee = "Surènes - France";

		IAlerteService alertSoapService = service.getPort(IAlerteService.class);

		alertSoapService.updateVilleDepartVilleArriveeById(id, villeDepart, villeArrivee);

		Alerte alert = alertSoapService.findById(id);

		Assert.assertTrue(alert.getVilleDepart().equals(villeDepart));

		Assert.assertTrue(alert.getVilleArrivee().equals(villeArrivee));

	}

}

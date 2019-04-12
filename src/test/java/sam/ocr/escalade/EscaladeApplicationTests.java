package sam.ocr.escalade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sam.ocr.escalade.controller.SiteController;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.service.SiteService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EscaladeApplicationTests {

	@Autowired
	SiteController siteController;

	@Autowired
	SiteService siteService;

	@Test
	public void testControllerSetup() {
		Assert.assertTrue("Controller correctement initialisé", siteController != null);
	}

	@Test
	public void testSiteService() {

		List<Site> sites = siteService.getSitesMisEnAvant();

		Assert.assertTrue("Sites créés en DB", sites.size() > 0);

	}

}

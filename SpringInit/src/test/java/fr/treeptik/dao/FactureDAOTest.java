package fr.treeptik.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.pojo.Facture;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextTest.xml")
public class FactureDAOTest {

	@Autowired
	private FactureDAO factureDAO;
	@Test
	public void testFindByMontantGreaterThanEqual(){
		List<Facture> factures = factureDAO.findByMontantGreaterThanEqual(1.00);
		Assert.assertNotNull(factures);
		Assert.assertEquals(2, factures.size());
	}
	
}

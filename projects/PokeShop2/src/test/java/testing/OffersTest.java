package testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.models.Offers;
import com.revature.services.PokeOfferService;

public class OffersTest {
	public static PokeOfferService pos = new PokeOfferService();
	
	@Test
	void changeOfferStatusTest(Offers o) throws SQLException, IOException{
		assertNotNull(pos.ChangeOfferStatus(o));
	}
	@Test
	void createOfferTest(Offers o) throws SQLException, IOException{
		assertNotNull(pos.makeAnOffer(o));
	}

}

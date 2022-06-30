package testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.services.PokemonService;

class PokemonTest {
	
	public static PokemonService ps = new PokemonService();
	
	@BeforeAll
	public static void createPokemon() {
		
	}
	@AfterAll
	public static void deletePokemon() {
		
	}
	@Test
	void getPokemonTest() throws SQLException, IOException{
		assertNotNull(ps.getPokemon());
	}
	@Test
	void checkEqual() {
		assertNotNull(ps.equals(ps));
	}
	@Test
	void checkDelete() throws IOException {
		assertNotNull(ps.deletePokemon(0));
	}

}

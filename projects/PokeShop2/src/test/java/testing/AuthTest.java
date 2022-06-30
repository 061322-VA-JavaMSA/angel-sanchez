package testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import org.junit.jupiter.api.Test;

import com.revature.models.User;
import com.revature.services.AuthService;

public class AuthTest {
	public static AuthService as = new AuthService();
	
	@Test
	void loginTest(User u) throws SQLException, IOException, LoginException{
		assertNotNull(as.login(null,null));
	}
	@Test
	void checkAdminTest(User u) throws IOException{
		assertNotNull(as.checkAdmin(null));
	}
	@Test
	void checkIdTest(User u) throws IOException{
		assertNotNull(as.checkId(null));
	}

}

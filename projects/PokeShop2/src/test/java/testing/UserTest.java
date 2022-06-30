package testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.revature.models.User;

public class UserTest {
	@Test
	public void usersTest() {
		User u = new User();
		u.setUsername("");
		assertNotNull(u);
	}

}

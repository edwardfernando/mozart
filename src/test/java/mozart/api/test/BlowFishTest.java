package mozart.api.test;

import junit.framework.TestCase;

import org.mindrot.jbcrypt.BCrypt;

public class BlowFishTest extends TestCase {

	public void test() {
		String salt = "$2a$10$if9Ias8VSfrqNdC0jTyKqO";

		String hashed = BCrypt.hashpw("edward", salt);
		System.out.println("Hashed : " + hashed);

		System.out.println("Matched : " +
		                   BCrypt.checkpw(
		                       "edward",
		                       "$2a$10$if9Ias8VSfrqNdC0jTyKqOW004qqR1HEiKHlauskkMZIfvMdeZtHi"));
		System.out.println("Matched : " +
		                   BCrypt.checkpw(
		                       "Edward",
		                       "$2a$10$if9Ias8VSfrqNdC0jTyKqOW004qqR1HEiKHlauskkMZIfvMdeZtHi"));
		System.out.println("Matched : " +
		                   BCrypt.checkpw(
		                       "edward ",
		                       "$2a$10$if9Ias8VSfrqNdC0jTyKqOW004qqR1HEiKHlauskkMZIfvMdeZtHi"));
	}

}

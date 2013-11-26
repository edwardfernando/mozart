package mozart.api.test;

import junit.framework.TestCase;

import org.mindrot.jbcrypt.BCrypt;

public class BlowFishTest extends TestCase {

	public void test() {
		System.out.println(BCrypt.checkpw(
		    "edward.fer@gmail.com",
		    "$2a$10$sj6mSHUGjP3vXshjPKod2eXh7CTe7i1QX6CaqG0Y3MNQRgYrOqwoW"));

		// System.out.println("Matched : " +
		// BCrypt.checkpw(
		// "edward",
		// "$2a$10$if9Ias8VSfrqNdC0jTyKqOW004qqR1HEiKHlauskkMZIfvMdeZtHi"));
		// System.out.println("Matched : " +
		// BCrypt.checkpw(
		// "Edward",
		// "$2a$10$if9Ias8VSfrqNdC0jTyKqOW004qqR1HEiKHlauskkMZIfvMdeZtHi"));
		// System.out.println("Matched : " +
		// BCrypt.checkpw(
		// "edward ",
		// "$2a$10$if9Ias8VSfrqNdC0jTyKqOW004qqR1HEiKHlauskkMZIfvMdeZtHi"));
	}

}

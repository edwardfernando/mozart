package api.mozart.dao;

import java.net.UnknownHostException;

import junit.framework.TestCase;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class TestMongoDB extends TestCase {

	public void testMongoDB() {
		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("ourFirstDB");

			boolean auth = db.authenticate("root", "root".toCharArray());
			if (auth) {
				System.out.println("Trying to insert");
				DBCollection table = db.getCollection("user");

				BasicDBObject doc = new BasicDBObject();
				doc.put("name", "Edward Fernando");
				doc.put("DOB", "21-01-1987");

				table.insert(doc);
			} else {
				System.out.println("not auth");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}

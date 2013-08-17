package api.mozart.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import api.mozart.model.Instrument;

@Component
public class InstrumentService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "person";

	public void add(Instrument ins) {
		if (!mongoTemplate.collectionExists(COLLECTION_NAME)) {
			mongoTemplate.createCollection(Instrument.class);
		}

		ins.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(ins, COLLECTION_NAME);
	}

	public List<Instrument> list() {
		return mongoTemplate.findAll(Instrument.class, COLLECTION_NAME);
	}

	public void delete(Instrument ins) {
		mongoTemplate.remove(ins, COLLECTION_NAME);
	}

	public void update(Instrument ins) {
		mongoTemplate.insert(ins, COLLECTION_NAME);
	}
}

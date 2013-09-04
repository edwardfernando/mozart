package mozart.api.controller;

import mozart.api.model.Campaign;
import mozart.api.model.CollectionWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campaign")
public class CampaignController extends mozart.api.controller.Controller<Campaign> {

	@Override
	public Campaign loadById(String id) {
		return null;
	}

	@Override
	public void save(Campaign model) {

	}

	@Override
	public Campaign update(Campaign model) {
		return null;
	}

	@Override
	public void delete(Campaign model) {

	}

	@Override
	public CollectionWrapper loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

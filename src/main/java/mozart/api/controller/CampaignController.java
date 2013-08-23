package mozart.api.controller;

import java.util.List;

import mozart.api.model.Campaign;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/campaign")
public class CampaignController implements mozart.api.controller.Controller<Campaign> {

	@Override
	public List<Campaign> loadAll() {
		return null;
	}

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

}

package mozart.api.controller.crud;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mozart.api.model.Campaign;
import mozart.api.service.CampaignService;
import mozart.core.api.Controller;
import mozart.core.api.config.ControllerConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/c/campaign")
@Produces(MediaType.APPLICATION_JSON)
public class CampaignController extends Controller<Campaign> {

	@Autowired
	private CampaignService service;

	@Override
	protected ControllerConfig<Campaign> getConfig() {
		return new ControllerConfig<Campaign>().build(service, Campaign.class);
	}

}

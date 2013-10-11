package mozart.api.controller.crud;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mozart.api.controller.Controller;
import mozart.api.model.AdvertiserType;
import mozart.api.service.advertiser.AdvertiserTypeService;
import mozart.common.config.ControllerConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/crud/advertiser/type")
@Produces(MediaType.APPLICATION_JSON)
public class AdvertiserTypeController extends Controller<AdvertiserType> {

	@Autowired
	private AdvertiserTypeService service;

	@Autowired
	private ControllerConfig<AdvertiserType> config;

	@Override
	protected ControllerConfig<AdvertiserType> getConfig() {
		return config.build(service, AdvertiserType.class);
	}
}

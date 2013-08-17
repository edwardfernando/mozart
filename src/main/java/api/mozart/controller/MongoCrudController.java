package api.mozart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import api.mozart.model.Brand;
import api.mozart.model.Instrument;
import api.mozart.service.InstrumentService;

@Controller
@RequestMapping("/crud/instrument")
public class MongoCrudController {

	@Autowired
	private InstrumentService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("instrumentList", service.list());
		return "instrument";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Instrument ins, ModelMap model) {
		if (StringUtils.hasText(ins.getId())) {
			service.update(ins);
		} else {
			Brand yamaha = new Brand();
			yamaha.setName("Yamaha");
			yamaha.setManufacture("Yamaha Japan");

			Brand bach = new Brand();
			bach.setName("Bach");
			bach.setManufacture("Bach USA");

			ins.getBrands().add(yamaha);
			ins.getBrands().add(bach);

			service.add(ins);
		}
		return "redirect:/crud/instrument/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute Instrument ins, ModelMap model) {
		service.delete(ins);
		return "redirect:/crud/instrument/";
	}
}

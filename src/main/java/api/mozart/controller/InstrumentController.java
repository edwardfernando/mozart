package api.mozart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import api.mozart.model.Brand;
import api.mozart.model.Instrument;

@Controller
@RequestMapping("/instrument")
public class InstrumentController {

	@RequestMapping(value = "{instrument}", method = RequestMethod.GET)
	public String getFruit(@PathVariable String instrument, ModelMap model) {
		Instrument ins = new Instrument();
		ins.setKey("A");
		ins.setName(instrument);
		ins.setQuality(1000);

		Brand yamaha = new Brand();
		yamaha.setName("Yamaha");
		yamaha.setManufacture("Yamaha Japan");

		Brand bach = new Brand();
		bach.setName("Bach");
		bach.setManufacture("Bach USA");

		ins.getBrands().add(yamaha);
		ins.getBrands().add(bach);

		model.addAttribute("model", ins);

		return "list";
	}

}

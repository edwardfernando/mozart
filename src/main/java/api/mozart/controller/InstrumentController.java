package api.mozart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import api.mozart.model.Instrument;

@Controller
@RequestMapping("/instrument")
public class InstrumentController {

	@RequestMapping(value = "{instrument}", method = RequestMethod.GET)
	public String getFruit(@PathVariable String instrument, ModelMap model) {
		System.out.println("masuk");

		Instrument ins = new Instrument();
		ins.setKey("A");
		ins.setName(instrument);
		ins.setQuality(1000);

		model.addAttribute("model", ins);

		return "list";
	}

}

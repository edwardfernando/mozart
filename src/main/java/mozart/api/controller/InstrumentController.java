package mozart.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mozart.api.model.Brand;
import mozart.api.model.Instrument;
import mozart.api.wrapper.InstrumentsWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/instrument")
public class InstrumentController {

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String getFruit(ModelMap model) {
		Instrument flute = new Instrument();
		flute.setId(UUID.randomUUID().toString());
		flute.setKey("A");
		flute.setName("Flute");
		flute.setQuality(1000);

		Brand yamaha = new Brand();
		yamaha.setName("Yamaha");
		yamaha.setManufacture("Yamaha Japan");

		Brand bach = new Brand();
		bach.setName("Bach");
		bach.setManufacture("Bach USA");

		flute.getBrands().add(yamaha);
		flute.getBrands().add(bach);

		Instrument digitalPiano = new Instrument();
		digitalPiano.setId(UUID.randomUUID().toString());
		digitalPiano.setKey("B");
		digitalPiano.setName("Digital Piano");
		digitalPiano.setQuality(1000);

		Brand korg = new Brand();
		korg.setName("Korg");
		korg.setManufacture("Korg Japan");

		Brand roland = new Brand();
		roland.setName("Roland");
		roland.setManufacture("Roland USA");

		digitalPiano.getBrands().add(korg);
		digitalPiano.getBrands().add(roland);

		InstrumentsWrapper wrapper = new InstrumentsWrapper();
		wrapper.getInstruments().add(flute);
		wrapper.getInstruments().add(digitalPiano);

		model.addAttribute("model", wrapper);

		return "list";
	}

	@RequestMapping("/guitar")
	public String methodLuUntukPiano(ModelMap map) {
		List<Instrument> guitarList = new ArrayList<Instrument>();

		Instrument guitar1 = new Instrument();
		guitar1.setName("Guitar Rock");

		Instrument guitar2 = new Instrument();
		guitar2.setName("Guitar Blues");

		guitarList.add(guitar1);
		guitarList.add(guitar2);

		map.put("guitarListGue", guitarList);
		map.put("model", new Instrument());
		return "guitar_page";
	}

	@RequestMapping("/guitar/save")
	public String saveGuitar(@ModelAttribute Instrument ins) {
		System.out.println("Name :: " + ins.getName());
		return "guitar_page";
	}
}

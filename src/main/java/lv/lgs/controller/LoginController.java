package lv.lgs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lv.lgs.entity.Color;
import lv.lgs.serviceImplementation.CarModelServiceImpl;
import lv.lgs.serviceImplementation.CarServiceImpl;
import lv.lgs.serviceImplementation.ColorServiceImpl;
import lv.lgs.serviceImplementation.MotordeportServiceImpl;
import lv.lgs.serviceImplementation.TranspTypeServiceImpl;

@Controller

public class LoginController {

	@Autowired
	private CarServiceImpl carServicseImpl;
	@Autowired
	private ColorServiceImpl colorServicseImpl;
	@Autowired
	private CarModelServiceImpl carModelServiceImpl;
	@Autowired
	private MotordeportServiceImpl motordeportServiceImpl;
	@Autowired
	TranspTypeServiceImpl transpTypeServiceImpl;

	@RequestMapping(value = "/")
	// це GET !!!!!!! ловить /, повертає текстове значення "index", і відркиває
	// першу сторінку "index" (через файл tiles.xml -- <definition name="index")
	public String index(Model model) {

		model.addAttribute("deports", motordeportServiceImpl.readAllDeports());
		model.addAttribute("types", transpTypeServiceImpl.readAllTtypes());
		model.addAttribute("models", carModelServiceImpl.readAllCarModels());
		// зязується з items="${models}" у jsp
		model.addAttribute("cars", carServicseImpl.readAll());
		model.addAttribute("colors", colorServicseImpl.readAllColors());
		return "index";
		// назва JSP бо метот GET
	}

	@RequestMapping(value = "/about")
	// це GET !!!!!!!
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/services") // це GET !!!!!!!
	public String services() {
		return "services";
	}

	@RequestMapping(value = "/passTransp") // це GET !!!!!!!
	public String passTransp() {
		return "passTransp";
	}

	@RequestMapping(value = "/freigTransp") // це GET !!!!!!!
	public String freigTransp() {
		return "freigTransp";
	}

	@RequestMapping(value = "/cargoIns") // це GET !!!!!!!
	public String cargoIns() {
		return "cargoIns";
	}

	// @RequestMapping(value = "/sitemap/not_int") // це GET !!!!!!!
	// public String sitemapNotInt(Model model) {
	//
	// model.addAttribute("Cars", carServicseImpl.readAll());
	// return "sitemap";
	// }

	@RequestMapping(value = "/sitemap") // це GET !!!!!!!
	public String sitemap(Model model) {

		model.addAttribute("Cars", carServicseImpl.readAll());
		model.addAttribute("colors", colorServicseImpl.readAllColors());
		return "sitemap";
		// якщо хочемо перезапустити сторінку требо прописати ще один такий
		// самий гет з додатковим параметром або параметр прописати через слеш в
		// @RequestMapping
		// тоді воно вибере варіант який йому необхідний

	}

	@RequestMapping(value = "/sitemap", method = RequestMethod.POST)
	// ловить і відркиває форму зі сторінки індекс -- form action з методом post
	// занесення даних у базу даних
	public String create(
			// прихід параметрів з сайту
			@RequestParam(name = "id"/* , defaultValue="0" */) int id,
			// якщо id = 0(не передається підчас апдейту) тоді зберігає, якщо ні
			// тоді бере id і перезаписує на її місці дані!!!!
			@RequestParam(name = "carModel") String carModelInput,
			@RequestParam(name = "transpType") String transpTypeInput,
			@RequestParam(name = "motordepot") String motordepotInput, @RequestParam(name = "color") String colorInput,
			@RequestParam(name = "capT") String capTInput, @RequestParam(name = "seatsCount") String seatsCountInput,
			@RequestParam(name = "regNumber") String regNumberInput,
			@RequestParam(name = "outputYear") String outputYearInput)

	{

		try {
			if ((!carModelInput.isEmpty()) || (!transpTypeInput.isEmpty()) || (!motordepotInput.isEmpty())
					|| (!motordepotInput.isEmpty()) || (!regNumberInput.isEmpty()))

				// як прописати чараз метод валідації???
				// ловить помилку якщо вводяться не числові значеня
				Integer.parseInt(seatsCountInput);
			Integer.parseInt(capTInput);
			Integer.parseInt(outputYearInput);
		} catch (NumberFormatException e) {
			// зсилка з параметром, спрацьовує коли вноситься не числове
			// значення перенаправляє в місце де спрацьовує тест
			// test="${param.wrongtype, wrongtype - назва
			return "redirect:/sitemap?wrongtype=true";

		} catch (NullPointerException e) {
			return "redirect:/sitemap?wrongtype=true";
		}

		String validR = carServicseImpl.createUpdataCar(id, carModelInput, transpTypeInput, motordepotInput, capTInput,
				seatsCountInput, regNumberInput, outputYearInput, colorInput);
		// валідація
		if (validR == null) {
			return "redirect:/sitemap";
			// redirect повертається на метод з параметром GET (там де метод
			// POST не має бути моделі)
		} else {
			return validR;
		}
	}

	@RequestMapping(value = "/sitemap/deleteAll", method = RequestMethod.POST)
	public String deleteAll() {

		carServicseImpl.deleteAll();
		transpTypeServiceImpl.deleteAll();
		motordeportServiceImpl.deleteAll();
		carServicseImpl.deleteAll();
		colorServicseImpl.deleteAll();
		carModelServiceImpl.deleteAll();
		return "redirect:/sitemap";

	}

	// при натиску апдате виводить дані у форму як дефолтні привязка по полю (те
	// що в дужках в jsp) --id (чи має називатись id??)!!!!
	@RequestMapping(value = "/sitemap/update/{id}")
	public String update(@PathVariable String id, Model model) {
		// моделі
		model.addAttribute("car", carServicseImpl.findById(id));
		model.addAttribute("Cars", carServicseImpl.readAll());
		return "sitemap";

	}

	@RequestMapping(value = "/sitemap/delete/{id}")
	public String delete(@PathVariable String id // для того щоб зловити id
	) {
		carServicseImpl.delete(id);
		return "redirect:/sitemap";

	}

	@RequestMapping(value = "/sitemap/color", method = RequestMethod.POST)
	public String select(@RequestParam(name = "dd") int id) {
		colorServicseImpl.findById(id);
		return "redirect:/sitemap";

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String selectCar(@RequestParam(name = "model") int modelId, @RequestParam(name = "type") int typeId,
			@RequestParam(name = "deport") int deportId, @RequestParam(name = "carPropertis") String carId,
			@RequestParam(name = "color") int colorId

	) {

		carModelServiceImpl.findById(modelId);
		transpTypeServiceImpl.findById(typeId);
		motordeportServiceImpl.findById(deportId);
		carServicseImpl.findById(carId);
		colorServicseImpl.findById(colorId);
		return "redirect:/sitemap";

	}

	// @RequestMapping(value = "/sitemap/find", method=RequestMethod.POST)
	// public String find(
	// @RequestParam(name = "regNumber") String regNumberInput
	//
	//
	// ){
	// carServicseImpl.findByRegNum(regNumberInput);
	// return "redirect:/sitemap";
	//
	// }

	// @RequestMapping(value = "/", method = RequestMethod.POST)
	// public String Selection(
	/// * @RequestParam(name = "MyInput") String innnnput) {
	// System.out.println(innnnput);*/
	//
	// @RequestParam(name = "carModel") String carModelInput,
	// @RequestParam(name = "transpType") String transpTypeInput,
	// @RequestParam(name = "motordepot") String motordepotInput,
	// @RequestParam(name = "capT") String capTInput,
	// @RequestParam(name = "seatsCount") String seatsCountInput,
	// @RequestParam(name = "regNumber") String regNumberInput,
	// @RequestParam(name = "outputYear") String outputYearInput,
	// @RequestParam(name = "color") String colorInput,
	// @RequestParam(name = "mydate") String mydateInput,
	// @RequestParam(name = "from") String fromInput,
	// @RequestParam(name = "to") String toInput)
	// {
	//
	// return "redirect:/"; //повертає нове значення на сайт /??
	// // }
	//
}

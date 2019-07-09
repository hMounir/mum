package edu.mum.cs544.controller;

import javax.annotation.Resource;

import edu.mum.cs544.service.CarService;
import edu.mum.cs544.domain.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value = "/car")
public class CarController {

	@Resource
	private CarService carService;

	@GetMapping("/car/")
	public String redirectRoot() {
		return "redirect:/cars";
	}

	@GetMapping("/car/cars")
	public String getAll(Model model) {
		model.addAttribute("cars", carService.getAll());
		return "carList";
	}

	@PostMapping("/car/cars")
	public String add(Car car) {
		carService.add(car);
		return "redirect:/cars";
	}

	@GetMapping("/car/cars/add")
	public String viewAdd(@ModelAttribute Car car, Model model) {
		model.addAttribute("msg", "Add");
		return "carDetail";
	}

	@GetMapping("/car/cars/{id}")
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("car", carService.get(id));
		model.addAttribute("msg", "Update");
		return "carDetail";
	}

	@PostMapping("/car/cars/{id}")
	public String update(Car car, @PathVariable int id) {
		carService.update(car); // car.id already set by binding
		return "redirect:/cars";
	}

	@PostMapping(value="/car/cars/delete")
	public String delete(int carId) {
		carService.delete(carId);
		return "redirect:/cars";
	}
}

package com.lance.dojoandninja.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lance.dojoandninja.models.Dojo;
import com.lance.dojoandninja.models.Ninja;
import com.lance.dojoandninja.services.DojoService;
import com.lance.dojoandninja.services.NinjaService;



@Controller
public class MainController {

	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	
	//================Routes for New Dojo===================
	
	@GetMapping("dojos/new")
	public String home(@ModelAttribute Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojo/add")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
							BindingResult res, Model model) {
		if(res.hasErrors()) {
			return "newdojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
		
	}
	
	//================Routes for New Ninja===================
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newninja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, @RequestParam("dojo") String id,
			BindingResult res) {
		if(res.hasErrors()) {
			return "newninja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + id ;
		}		
	}

	
	//=========Routes to display Ninjas in a Dojo================
	
	@GetMapping("/dojos/{id}")
	public String displayNinjas(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo.ni", dojoService.findOneDojo(id));
		return "dojopage.jsp";
	}
	
	
}

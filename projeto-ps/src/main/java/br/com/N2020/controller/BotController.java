package br.com.N2020.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.N2020.model.BotModel;
import br.com.N2020.repository.BotRepository;



@Controller
@RequestMapping("/bot")
public class BotController {

	private static final String BOT_FOLDER = "/bot";
	
	@Autowired
	public BotRepository repository;
	
	@GetMapping("/form")
	public String open(@RequestParam String page, 
					   @RequestParam(required = false) Long idBot,
					   @ModelAttribute("botModel") BotModel botModel, 
					   Model model) {
		
		if("bot-editar".equals(page)) {
			model.addAttribute("botModel", repository.findById(idBot).get());
		}
		
		return BOT_FOLDER + page;
		
	}
	
	@GetMapping()
	public String findAll(Model model) {
		model.addAttribute("bots", repository.findAll());
		return BOT_FOLDER + "bots";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("bot",repository.findById(id).get());	
		return BOT_FOLDER + "bot_detalhe";
	}
	
	@PostMapping()
	public String save(@Valid BotModel botModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return BOT_FOLDER + "bot-novo";
		}
		
		repository.save(botModel);
		redirectAttributes.addFlashAttribute("messages", "Bot cadastrado com sucesso!");
		
		return "redirect:/bot";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") long id, @Valid BotModel botModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return BOT_FOLDER + "bot-editar";
		}
		
		botModel.setIdBot(id);
		repository.save(botModel);
		redirectAttributes.addFlashAttribute("messages", "Bot alterado com sucesso!");
		
		return "redirect:/bot";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Bot excluido com sucesso!");

		return "redirect:/bot";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

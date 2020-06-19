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

import br.com.N2020.model.SegmentoModel;
import br.com.N2020.repository.BotRepository;
import br.com.N2020.repository.SegmentoRepository;


@Controller
@RequestMapping("/segmento")
public class SegmentoController {

	private static final String SEGMENTO_FOLDER = "segmento/";
	
	@Autowired
	public BotRepository botRepository;
	
	@Autowired
	public SegmentoRepository segmentoRepository;
	
	@GetMapping("/form")
	public String open(@RequestParam String page, 
					   @RequestParam(required = false) Long id,
					   @ModelAttribute("segmentoModel") SegmentoModel segmentoModel, 
					   Model model) {
		
		if("segmento-editar".equals(page)) {
			model.addAttribute("segmentoModel", segmentoRepository.findById(id).get());
		}
		
		model.addAttribute("bots", botRepository.findAll());
		
		
		return SEGMENTO_FOLDER + page;
	}

	@GetMapping()
	public String findAll(Model model) {

		model.addAttribute("segmentos", segmentoRepository.findAll());
		return SEGMENTO_FOLDER +  "segmentos";
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("segmento", segmentoRepository.findById(id).get());
		return SEGMENTO_FOLDER +  "segmento-detalhe";
	}
	
	@PostMapping()
	public String save(@Valid SegmentoModel segmentoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("bots", botRepository.findAll());
			
			return SEGMENTO_FOLDER + "segmento-novo";
		}
		
		segmentoRepository.save(segmentoModel);
		redirectAttributes.addFlashAttribute("messages", "segmento cadastrado com sucesso!");
		
		return "redirect:/segmento";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") long id, @Valid SegmentoModel segmentoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("bots", botRepository.findAll());
			
			return SEGMENTO_FOLDER + "segmento-editar";
		}
		
		segmentoModel.setIdSegmento(id);
		segmentoRepository.save(segmentoModel);
		redirectAttributes.addFlashAttribute("messages", "segmento alterado com sucesso!");
		
		return "redirect:/segmento";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		
		segmentoRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "segmento excluído com sucesso!");

		return "redirect:/segmento";
	}
	
}

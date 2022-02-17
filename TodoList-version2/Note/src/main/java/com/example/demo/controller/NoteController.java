package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.model.Note;
import com.example.demo.service.NoteService;

@Controller
public class NoteController {
	@Autowired
	NoteService noteService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/notes";
	}

	@GetMapping("/notes")
	public String index(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("notelist", null);
		
		if(model.asMap().get("success") != null)
			redirect.addFlashAttribute("success",model.asMap().get("success").toString());
		return "redirect:/notes/page/1";
	}
	
	@GetMapping("/notes/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("notelist");
		int pagesize = 3;
		List<Note> list =(List<Note>) noteService.findAll();
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("notelist", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/notes/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("notes", pages);

		return "list";
	}

	@GetMapping("/notes/create")
	public String add(Model model) {
		model.addAttribute("note", new Note());
		return "form";
	}

	@PutMapping(value = "/notes/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("note", noteService.findOne(id));
		return "form";
	}

	@PostMapping("/notes")
	public String save(@Validated Note note, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		noteService.save(note);
		redirect.addFlashAttribute("success", "Saved note successfully!");
		return "redirect:/notes";
	}

	@DeleteMapping(value = "/notes/{id}")
	public String delete(@PathVariable() long id, RedirectAttributes redirect) {
		noteService.delete(id);
		redirect.addFlashAttribute("success", "Deleted note successfully!");
		return "redirect:/notes";
	}

	@PostMapping(value = "/notes/search/{pageNumber}")	
	public String search(@RequestParam("s") String s, Model model, HttpServletRequest request,	
			@PathVariable int pageNumber) {	
		if (s.equals("")) {	
			return "redirect:/notes";	
		}	
		List<Note> list = noteService.search(s);	
		if (list == null) {	
			return "redirect:/notes";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("notelist");	
		int pagesize = 3;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		final int goToPage = pageNumber - 1;	
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
			pages.setPage(goToPage);	
		}	
		request.getSession().setAttribute("notelist", pages);	
		int current = pages.getPage() + 1;	
		int begin = Math.max(1, current - list.size());	
		int end = Math.min(begin + 5, pages.getPageCount());	
		int totalPageCount = pages.getPageCount();	
		String baseUrl = "/notes/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("notes", pages);	
		return "list";	
	}

}

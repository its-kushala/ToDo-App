package Todo.example.ToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Todo.example.ToDo.App.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService service;
	
	@GetMapping(("/", "viewToDoList"))  
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAllAttributes("list", service.getAllToDoItems());
		model.addAllAttributes("msg", message);
		
		return "ViewToDoList";
		
	}
	
	@PostMapping("/updateToDoStatus/{id}")
	public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Update Success");
			return "redirect:/viewToDOList";
		}
		redirectAttributes.addFlashAttribute("message", "Update Failure");
		return "redirect:/viewToDoList";
	}
	
	@GetMapping("/addToDoItem")
	public String addToDoItem(Model model) {
		model.addAttribute("todo", new ToDo());
		
		return "AddToDoItem";
	}
	
	@PostMapping("/saveToDoItem")
	public String saveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
		if (services.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
			return "redirect:/viewToDoList";
		}
		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirct:/addToDoItem";
	}
	
	@GetMapping("/editToDoItem/{id}")
	public String editToDoItem(@PathVariable Long id) {
		model.addAttribute("todo", service.getToDoItemById(id));
		
		return "EditToDoItem";
	}
	
	@PostMapping("/editSaveToDoItem")
	public String editSaveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirct:/viewToDoList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/editToDoItem/" + todo.getId();
	}
	
	@GetMapping("/deleteToDoItem/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(service.deleteToDoItem(id)) {
			redirctAttributes.addFlashAttribute("message", "Delete Success");
		}
		redirctAttributes.addFlashAttribute("message", "Delete Failure");
		return "
	}
}

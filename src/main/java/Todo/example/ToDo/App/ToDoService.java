package Todo.example.ToDo.App;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Todo.example.ToDo.App.model.ToDo;

@Service
public class ToDoService {

	@Autowired
	IToDoRepo repo;
	
	public List<ToDo> getAllToDoItems(){
		ArrayList<ToDo> todoList = new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		
		return todoList;
	}
	public ToDo getToDoItemById(Long id){
		return repo.findById(id).get();
		
	}
	public boolean updateStatus(Long id) {
		ToDo todo = getToDoItemById(id);
		todo.setStatus("Completed");
		
		return saveOrUpdateToDoItem(todo);
	}
	
	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updateObj = repo.save(todo);
		
		if(getToDoItemById(updateObj.getId()) != null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);
		
		if(getToDoItemById(id) != null) {
			return true;
		}
		return false;
	}
}

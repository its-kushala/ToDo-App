package Todo.example.ToDo.App;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Todo.example.ToDo.App.model.ToDo;

@Service
public class ToDoService2 {

	@Autowired
	IToDoRepo repo;
	
	List<ToDo> getAllToDoItems(){

	}
	ToDo getToDoItemById()
	{
		
	}
	boolean updateStatus() {
		 
	}
	
	boolean saveOrUpdateToDoItem() {
		
	}
	
	boolean deleteToDoItem() {
		
	}
}

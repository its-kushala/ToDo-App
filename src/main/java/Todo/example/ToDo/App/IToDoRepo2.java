package Todo.example.ToDo.App;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Todo.example.ToDo.App.model.ToDo;

@Repository
public interface IToDoRepo2 extends JpaRepository<ToDo, Long>{
	

}

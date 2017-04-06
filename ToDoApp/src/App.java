import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by georgezsiga on 4/6/17.
 */
public class App {

  public static void main(String[] args) {
    ArgumentHandler handler = new ArgumentHandler(args);
    ToDoList list = new ToDoList();

    if (handler.contains("l")) {
      list.listTheTasks();
    } else if (handler.contains("a")){
      String taskName = args[1].toString();
      list.taskList.add(taskName);
      try{
        Path filePath = Paths.get("files/data.txt");
        Files.write(filePath, list.taskList);
      } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Uh-oh, could not write the file!");
      }
      System.out.println("Your task: '" + taskName + "' has been added to your task list");
    } else {
      handler.noArgument();
    }
  }
}

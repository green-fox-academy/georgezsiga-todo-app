import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by georgezsiga on 4/6/17.
 */
public class App {
  String[] args;
  String taskName;

  public App(String[] args) {
    this.args = args;
  }

  public boolean contains(String argument) {
    if (args.length > 0) {
      for (String arg : args) {
        if (arg.startsWith("-") && arg.contains(argument)) {
          return true;
        }
      }
    }
    return false;
  }

  public String taskNameMethod() {
    this.taskName = args[1];
    return taskName;
  }

  public void noArgument() {
    System.out.println();
    System.out.println("Java ToDo application");
    System.out.println("=====================");
    System.out.println();
    System.out.println("Command line arguments:");
    System.out.println(" -l  Lists all the tasks");
    System.out.println(" -a  Adds a new task");
    System.out.println(" -r  Removes a task");
    System.out.println(" -c  Completes a task");
    System.out.println();
    System.out.println("So, what do you want to do?");
    System.out.println();
  }

  public static void main(String[] args) {
    App handler = new App(args);
    ToDoList list = new ToDoList();

    if (handler.contains("l")) {
      list.listTheTasks();
    } else if (handler.contains("a")){
      String taskName = handler.taskNameMethod();
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/6/17.
 */
public class App {

  private String[] args;
  private String taskName;
  private int taskNumber;

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
    if (args.length == 1) {
      System.out.println("Unable to add, no task provided");
      System.exit(0);
    } else {
      this.taskName = args[1];
    }
    return taskName;
  }

  public int taskNumberMethod(String typeOfArgument) {
    ToDoList list = new ToDoList();
    ArrayList<String> list2 = list.readFromFile();
    try {
      if (args.length == 1) {
        System.out.println("Unable to " + typeOfArgument + ", no index provided");
        System.exit(0);
      } else if (Integer.parseInt(args[1]) < -1) {
        System.out.println();
      } else if (list2.size() < Integer.parseInt(args[1])) {
        System.out.println("Unable to " + typeOfArgument + ": index is out of bound");
        System.exit(0);
      } else {
        taskNumber = Integer.parseInt(args[1]);
      }
    } catch (NumberFormatException e) {
      System.out.println("Unable to " + typeOfArgument + ": index is not a number");
      System.exit(0);
    }
    return taskNumber;
  }

  public void noArgument() {
    try {
      Path filePath = Paths.get("files/userManual.txt");
      List<String> lines = Files.readAllLines(filePath);
      for (int i = 0; i < lines.size(); i++) {
        System.out.println(lines.get(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    App handler = new App(args);
    ToDoList list = new ToDoList();
    ToDo todo = new ToDo();
    if (handler.contains("l")) {
      if (handler.contains("lu")) {
        list.unDoneTasks();
      } else if (handler.contains("lf")) {
        list.doneTasks();
      } else {
        list.listTheTasks();
      }
    } else if (handler.contains("a")) {
      String taskName = handler.taskNameMethod();
      todo.addNewTask(taskName);
    } else if (handler.contains("r")) {
      int number = handler.taskNumberMethod("remove");
      todo.removeTask(number);
    } else if (handler.contains("c")) {
      int number = handler.taskNumberMethod("check");
      todo.replaceTask(number, "[x]");
    } else if (handler.contains("u")) {
      int number = handler.taskNumberMethod("check");
      todo.replaceTask(number, "[ ]");
    } else if (handler.args.length < 1) {
      handler.noArgument();
    } else {
      System.out.println("Unsupported argument");
      handler.noArgument();
    }
  }
}

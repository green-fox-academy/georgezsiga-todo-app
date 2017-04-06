
/**
 * Created by georgezsiga on 4/6/17.
 */
public class App {
  String[] args;
  String taskName;
  int taskNumber;

  public App(String[] args) {
    this.args = args;
  }

  public boolean contains(String argument) {
    if (args.length > 0) {
      for (String arg : args) {
        if (arg.startsWith("-") && arg.contains(argument)) {
          return true;
        } else {
          System.out.println("Unsupported argument");
          System.exit(0);
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

  public int taskNumberMethod() {
    try {
      if (args.length == 1) {
        System.out.println("Unable to remove, no index provided");
        System.exit(0);
      } else if (Integer.parseInt(args[1]) < -1) {

      } else if (args.length < Integer.parseInt(args[1])) {
        System.out.println("Unable to remove: index is out of bound");
        System.exit(0);
      } else {
        taskNumber = Integer.parseInt(args[1]);
      }
    } catch (NumberFormatException e) {
      System.out.println("Unable to remove: index is not a number");
      System.exit(0);
    }
    return taskNumber;
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
      list.addNewTask(taskName);
    } else if (handler.contains("r")) {
      int number = handler.taskNumberMethod();
      list.removeTask(number);
    } else {
      handler.noArgument();
    }
  }
}

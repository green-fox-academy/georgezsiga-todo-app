import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/6/17.
 */
public class ArgumentHandler {

  String[] args;

  public ArgumentHandler(String[] args) {
    this.args = args;
  }

  public String getDirectory() {
    if (args.length > 0 && !args[0].startsWith("-")) {
      return args[0];
    }
    return ".";
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

  public void listTheTasks() {
      try {
        Path filePath = Paths.get("files/data.txt");
        List<String> lines = Files.readAllLines(filePath);
        if (lines.size() == 0) {
          System.out.println("Good job, no ToDo`s for today! Go and have some fun!");
        } else {
          for (int i = 0; i < lines.size(); i++) {
            System.out.println(" " + i + " " + lines.get(i));
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  public void addNewTask() {
    String taskName = args[1].toString();
    List<String> taskList = new ArrayList();
    taskList.add(taskName);
    try{
      Path filePath = Paths.get("files/data.txt");
      Files.write(filePath, taskList);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Uh-oh, could not write the file!");
    }
    System.out.println("Your task: '" + taskName + "' has been added to your task list");
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



}

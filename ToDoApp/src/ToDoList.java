
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by georgezsiga on 4/6/17.
 */
public class ToDoList {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public ArrayList<String> taskList;

  public ToDoList() {
    this.taskList = new ArrayList<>();
  }

  public ArrayList<String> getTaskList() {
    return taskList;
  }

  public ArrayList<String> readFromFile() {
    try {
      Path filePath = Paths.get("files/" + "data" + ".txt");
      List<String> lines = Files.readAllLines(filePath);
      for (int i = 0; i < lines.size(); i++) {
        taskList.add(i, lines.get(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return taskList;
  }

  public void printToFile() {
    try {
      Path filePath = Paths.get("files/data.txt");
      Files.write(filePath, getTaskList());
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Uh-oh, could not write the file!");
    }
    System.out.println("Your tasklist has been refreshed");
  }

  public void listTasks(String check) {
    try {
      Path filePath = Paths.get("files/data.txt");
      List<String> lines = Files.readAllLines(filePath);
      int counter = 1;
      if (lines.size() == 0) {
          System.out.println();
        System.out.println(ANSI_CYAN + "Good job, no ToDo`s for today! Go and have some fun!" + ANSI_RESET);
          System.out.println();
      } else {
        if (check == "[x]") {
          System.out.println();
          System.out.println(ANSI_CYAN + "The tasks you already finished with:" + ANSI_RESET);
          System.out.println();
          for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("[x]")) {
              System.out.println(ANSI_CYAN + " " + counter + " - " + ANSI_RESET + ANSI_GREEN + lines.get(i) + ANSI_RESET);
              counter += 1;
            }
          }
        } else if (check == "[ ]") {
          System.out.println();
          System.out.println(ANSI_CYAN + "Your unfinished tasks:" + ANSI_RESET);
          System.out.println();
          for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("[ ]")) {
              System.out.println(ANSI_CYAN + " " + counter + " - " + ANSI_RESET + ANSI_BLUE + lines.get(i) + ANSI_RESET);
              counter += 1;
            }
          }
        } else {
          System.out.println();
          System.out.println(ANSI_CYAN + "Your actual tasklist:" + ANSI_RESET);
          System.out.println();
          for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("[x]")) {
              System.out.println(ANSI_CYAN + " " + (i+1) + " - " + ANSI_RESET + ANSI_GREEN + lines.get(i) + ANSI_RESET);
            } else {
              System.out.println(ANSI_CYAN + " " + (i + 1) + " - " + ANSI_RESET + ANSI_BLUE + lines.get(i) + ANSI_RESET);
            }
          }
        }
          System.out.println();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

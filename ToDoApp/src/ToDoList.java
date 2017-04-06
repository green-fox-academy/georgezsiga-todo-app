
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

  public ArrayList<String> taskList;

  public ToDoList() {
    this.taskList = new ArrayList<>();
  }

  public ArrayList<String> getTaskList() {
    return taskList;
  }

  public ArrayList<String> readFromFile() {
    try {
      Path filePath = Paths.get("files/data.txt");
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

  public void listTheTasks() {
    try {
      Path filePath = Paths.get("files/data.txt");
      List<String> lines = Files.readAllLines(filePath);
      if (lines.size() == 0) {
        System.out.println("Good job, no ToDo`s for today! Go and have some fun!");
      } else {
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(" " + (i+1) + " - " + lines.get(i));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void unDoneTasks() {
    try {
      Path filePath = Paths.get("files/data.txt");
      List<String> lines = Files.readAllLines(filePath);
      int counter = 1;
      if (lines.size() == 0) {
        System.out.println("Good job, no ToDo`s for today! Go and have some fun!");
      } else {
        System.out.println("Your unfinished tasks:");
        System.out.println();
        for (int i = 0; i < lines.size(); i++) {
          if (lines.get(i).startsWith("[ ]")) {
            System.out.println(" " + counter + " - " + lines.get(i));
            counter += 1;
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void doneTasks() {
    try {
      Path filePath = Paths.get("files/data.txt");
      List<String> lines = Files.readAllLines(filePath);
      int counter = 1;
      if (lines.size() == 0) {
        System.out.println("Good job, no ToDo`s for today! Go and have some fun!");
      } else {
        System.out.println("The tasks you already finished with:");
        System.out.println();
        for (int i = 0; i < lines.size(); i++) {
          if (lines.get(i).startsWith("[x]")) {
            System.out.println(" " + counter + " - " + lines.get(i));
            counter += 1;
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

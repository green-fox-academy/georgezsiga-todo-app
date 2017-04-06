
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

  private ArrayList<String> taskList;

  public ToDoList() {
    this.taskList = new ArrayList<>();
  }

  public ArrayList<String> getTaskList() {
    return taskList;
  }

  public void addNewTask(String string) {
    readFromFile();
    String string2 = " " + string;
    taskList.add(string2);
    System.out.println("Your task: '" + string + "' has been added to your task list");
    printToFile();
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

  public int removeTask(int number) {
    readFromFile();
    int indexNumber = number -1;
    taskList.remove(indexNumber);
    System.out.println(
        "The task at this position: '" + number + "' has been removed from your task list");
    printToFile();
    return indexNumber;
  }

  public int replaceTask(int number) {
    readFromFile();
    int indexNumber = number -1;
    String string = taskList.get(indexNumber);
    String check = string.substring(0,1);
    String string2 = string.substring(1);
    string = "x" + string2;
    taskList.set(indexNumber, string);
    System.out.println(
        "The task at this position: '" + number + "' has been checked as done in your task list");
    printToFile();
    return indexNumber;
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
          String string = lines.get(i);
          String check = string.substring(0,1);
          String string2 = string.substring(1);
            System.out.println(" " + (i+1) + " -[" + check + "] " + string2);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}

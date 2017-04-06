
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

  public ArrayList<String> addNewTask(String string) {
    taskList.add(taskList.size(), string);
    System.out.println("Your task: '" + string + "' has been added to your task list");
    System.out.println(taskList);
    return taskList;
  }

  public ArrayList<String> removeTask(int number) {
    taskList.remove(number);
    System.out.println("The task at this position: '" + number + "' has been added to your task list");
    System.out.println(taskList);
    return taskList;
  }

  public void printToFile() {
    try{
      Path filePath = Paths.get("files/data.txt");
      Files.write(filePath, getTaskList());
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Uh-oh, could not write the file!");
    }
//    System.out.println("Your task: '" + string + "' has been added to your task list");
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

}

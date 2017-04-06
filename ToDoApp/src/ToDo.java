/**
 * Created by georgezsiga on 4/6/17.
 */
public class ToDo {

  ToDoList list = new ToDoList();

  public void addNewTask(String string) {
    list.readFromFile();
    String string2 = "[ ] " + string;
    list.taskList.add(string2);
    System.out.println("Your task: '" + string + "' has been added to your task list");
    list.printToFile();
  }

  public void removeTask(int number) {
    list.readFromFile();
    int indexNumber = number - 1;
    list.taskList.remove(indexNumber);
    System.out.println(
        "The task at this position: '" + number + "' has been removed from your task list");
    list.printToFile();
  }

  public void replaceTask(int number) {
    list.readFromFile();
    int indexNumber = number - 1;
    String string = list.taskList.get(indexNumber);
    String string2 = string.substring(3);
    string = "[x]" + string2;
    list.taskList.set(indexNumber, string);
    System.out.println(
        "The task at this position: '" + number + "' has been checked as done in your task list");
    list.printToFile();
  }

}

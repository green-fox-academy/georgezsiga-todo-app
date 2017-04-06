/**
 * Created by georgezsiga on 4/6/17.
 */
public class ToDo {

  private ToDoList list = new ToDoList();

  private void addNewTask(String string) {
    list.readFromFile();
    String string2 = "[ ] " + string;
    list.taskList.add(string2);
    System.out.println("Your task: '" + string + "' has been added to your task list");
    list.printToFile();
  }

  private void removeTask(int number) {
    list.readFromFile();
    int indexNumber = number - 1;
    list.taskList.remove(indexNumber);
    System.out.println(
        "The task at this position: '" + number + "' has been removed from your task list");
    list.printToFile();
  }

  private void replaceTask(int number, String check) {
    list.readFromFile();
    int indexNumber = number - 1;
    String string = list.taskList.get(indexNumber);
    String string2 = string.substring(3);
    string = check + string2;
    list.taskList.set(indexNumber, string);
    System.out.println(
        "The task at this position: '" + number + "' has been checked in your task list");
    list.printToFile();
  }

}

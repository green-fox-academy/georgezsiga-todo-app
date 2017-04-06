/**
 * Created by georgezsiga on 4/6/17.
 */
public class App {

  public static void main(String[] args) {
    ArgumentHandler handler = new ArgumentHandler(args);

    if (handler.contains("l")) {
      handler.listTheTasks();
    } else if (handler.contains("a")){
      handler.addNewTask();
    } else {
      handler.noArgument();
    }
  }
}

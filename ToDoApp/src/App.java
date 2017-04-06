/**
 * Created by georgezsiga on 4/6/17.
 */
public class App {

  public static void main(String[] args) {
    ArgumentHandler handler = new ArgumentHandler(args);
    App app = new App();

    if (handler.contains("l")) {
      handler.listTheTasks();
    } else {
      handler.noArgument();
    }
  }
}

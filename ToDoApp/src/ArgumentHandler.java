import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        if (arg.startsWith("-") && arg.contains(argument))
          return true;
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
}

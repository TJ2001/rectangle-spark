import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/answer", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/answer.vtl");
      String length = request.queryParams("side-one");
      Integer lengthInt = Integer.parseInt(length);
      String width = request.queryParams("side-two");
      Integer widthInt = Integer.parseInt(width);
      Rectangle rectangle = new Rectangle( lengthInt, widthInt);
      model.put("side-one", length);
      model.put("side-two", width);
      boolean answer = rectangle.isSquare();
      model.put("answer", answer);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}












//     Console console = System.console();
//
//     System.out.println("Enter one side length");
//     int sideOne = Integer.parseInt(console.readLine());
//
//     System.out.println("Enter another side length");
//     int sideTwo = Integer.parseInt(console.readLine());
//
//     Rectangle rectangle = new Rectangle(sideOne,sideTwo);
//
//     System.out.println("Is your rectangle a square. too?" + rectangle.isSquare());
//   }
// }

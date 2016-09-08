import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();

    System.out.println("Enter one side length");
    int sideOne = Integer.parseInt(console.readLine());

    System.out.println("Enter another side length");
    int sideTwo = Integer.parseInt(console.readLine());

    Rectangle rectangle = new Rectangle(sideOne,sideTwo);

    System.out.println("Is your rectangle a square. too?" + rectangle.isSquare());
  }
}

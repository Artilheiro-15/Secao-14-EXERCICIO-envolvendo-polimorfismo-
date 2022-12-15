import entities.Employee;
import entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    List<Employee> list = new ArrayList<>();

    System.out.println("====================================");
    System.out.print("Enter the number of products: ");
    int N = sc.nextInt();

    for (int i = 1; i <= N; i++) {
      System.out.println("Product #" + i + " data: ");
      System.out.print("Outsorced (y/n)? ");
      char ch = sc.next().charAt(0);
      System.out.print("Name: ");
      sc.nextLine();
      String name = sc.nextLine();
      System.out.print("Hours: ");
      int hours = sc.nextInt();
      System.out.print("Value per hour: ");
      double valuePerHour = sc.nextDouble();
      System.out.println("====================================");
      if (ch == 'y') {
        System.out.println("Additional charge: ");
        double additionalCharge = sc.nextDouble();
        System.out.println("====================================");
        // nesse momento eu ja tenho todos os dados do funcionario tercerizado entao ja posso declarar e istanciar...
        // nas duas linas abaixo eu istanciei eu funcionario tarcerizado e add na lista de funcionarios
        Employee emp = new OutsourcedEmployee(
          name,
          hours,
          valuePerHour,
          additionalCharge
        );
        list.add(emp);
      } else {
        //na lina abaixo eu istanciei um funcionario sem ser tercerizado e add na lista de funcionarios
        Employee emp = new Employee(name, hours, valuePerHour);
        list.add(emp);
      }
    }
    System.out.println();
    System.out.println("PAYMENTS: ");
    for (Employee emp : list) {
      System.out.println(
        emp.getName() + " - $ " + String.format("%.2f", emp.payment())
      );
    }
    System.out.println("====================================");
    sc.close();
  }
}

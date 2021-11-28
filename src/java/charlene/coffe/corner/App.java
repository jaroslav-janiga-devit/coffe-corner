package charlene.coffe.corner;

import charlene.coffe.corner.management.CashRegister;
import charlene.coffe.corner.utils.parser.InputParser;

public class App {
    public static void main(String[] args) {
        String input = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";

        CashRegister cashRegister = new CashRegister();
        InputParser.parseInputItems(input)
                .forEach(cashRegister::addMenuItem);
        System.out.println(cashRegister.printReceipt());
    }
}

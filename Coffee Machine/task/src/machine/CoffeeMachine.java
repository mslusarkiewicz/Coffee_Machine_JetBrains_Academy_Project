package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int waterMachineHas = 400;
    int milkMachineHas = 540;
    int coffeeBeansMachineHas = 120;
    int cupsMachineHas = 9;
    int moneyMachineHas = 550;

    public static void main(String[] args) {

        CoffeeMachine cm = new CoffeeMachine();
        Recipe espresso = new Recipe(250, 0, 16, 4);
        Recipe latte = new Recipe(350, 75, 20, 7);
        Recipe cappuccino = new Recipe(200, 100, 12, 6);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

        String activity = "menu";

        while (!(activity.equals("exit"))) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            activity = scanner1.nextLine();
            switch (activity) {

                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String recipeNumber = scanner2.nextLine();
                    switch (recipeNumber) {
                        case "1":
                            buyCoffee(cm, espresso);
                            break;
                        case "2":
                            buyCoffee(cm, latte);
                            break;
                        case "3":
                            buyCoffee(cm, cappuccino);
                            break;
                        case "back":
                            break;
                    }break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    cm.waterMachineHas += scanner3.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    cm.milkMachineHas += scanner3.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    cm.coffeeBeansMachineHas += scanner3.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cm.cupsMachineHas += scanner3.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + cm.moneyMachineHas);
                    cm.moneyMachineHas = 0;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:\n" + cm.waterMachineHas + " of water\n" + cm.milkMachineHas + " of milk\n" + cm.coffeeBeansMachineHas + " of coffee beans\n" + cm.cupsMachineHas + " of disposable cups\n" + "$" +cm.moneyMachineHas + " of money\n");
                    break;
            }

        }
    }

    public static void buyCoffee(CoffeeMachine coffeeMachine, Recipe recipe) {
        if (coffeeMachine.waterMachineHas < recipe.water) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeMachine.milkMachineHas < recipe.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeMachine.coffeeBeansMachineHas < recipe.coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (coffeeMachine.cupsMachineHas < 1) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMachine.waterMachineHas -= recipe.water;
            coffeeMachine.milkMachineHas -= recipe.milk;
            coffeeMachine.coffeeBeansMachineHas -= recipe.coffeeBeans;
            coffeeMachine.cupsMachineHas -= 1;
            coffeeMachine.moneyMachineHas += recipe.cost;
        }
    }
}

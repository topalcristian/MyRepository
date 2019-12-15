public class ShoppingBagTest {

    public static void main(String [] args){

        ShoppingBag shoppingBag = new ShoppingBag();
       // ShoppingBag.Product innerObject = shoppingBag.new Product();

        Item apple = shoppingBag.new Product("Apple", 2.0, "More red than green.");
        Item smoothie = shoppingBag.new Product("Basic Green Smoothie", 7, "Just a basic smoothie for the basic gals.");
        Item chocolate = shoppingBag.new Product("Choco Choci", 1.99, "No sugar, no fat, so super not sad");
        Item pasta = shoppingBag.new Product("Penne", 4, "Andiamo, grazzie e tutti");
        Item apple2 = shoppingBag.new Product("Apple", 2.0, "Tastes like a MacBook but feels more like a IPhone.");
        Item apple3 = shoppingBag.new Product("Apple", 2.0, "Tastes like a MacBook but feels more like a IPhone.");
        Item smoothie2 = shoppingBag.new Product("Basic Green Smoothie", 7, "Just a basic smoothie for the basic gals.");
        Item chocolate2 = shoppingBag.new Product("Choco Choci", 1.99, "No sugar, no fat, so super not sad");
        Item pasta2 = shoppingBag.new Product("Penne", 4, "Andiamo, grazzie e tutti");

        shoppingBag.add(apple);
        shoppingBag.add(apple2);
        shoppingBag.add(apple3);
        shoppingBag.add(chocolate);
        shoppingBag.add(chocolate2);
        shoppingBag.add(smoothie);
        shoppingBag.add(smoothie2);
        shoppingBag.add(pasta);
        shoppingBag.add(pasta2);

        System.out.println("Total price for apples: " + shoppingBag.totalPriceForProduct("Apple"));
        System.out.println("Total price for green smoothies: " + shoppingBag.totalPriceForProduct("Basic Green Smoothie"));
        System.out.println("Total price for pasta: " + shoppingBag.totalPriceForProduct("Penne"));
        System.out.println("Total price for chocolate: " + shoppingBag.totalPriceForProduct("Choco Choci"));
    }
}

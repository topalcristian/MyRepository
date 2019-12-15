import java.util.ArrayList;

public class ShoppingBag {

    // list in which all the items are stored
    private ArrayList<Item> shoppingList;

    // inner class
    class Product implements Item {

        private String name;
        private double price;
        private String bioInfo;

        public Product(String name, double price, String bio_info){

            this.name = name;
            this.price = price;
            this.bioInfo = bioInfo;

        }


        public String getName(){ return name; }

        public double getPrice(){ return price; }

        public String getBioInfo(){ return bioInfo; }
    }


    public ShoppingBag(){

        this.shoppingList = new ArrayList<>();
    }


    public void add(Item item){

        shoppingList.add(item);
    }


    public double totalPriceForProduct(String name){
        int count = 0;
        Product product = null;
        double totalPrice = 0;

        // go through list and if there is the product which we are looking for, then count how often it appears
        for(int i=0; i<shoppingList.size();i++){
            Product tmpProduct = (Product) shoppingList.get(i);

            if(tmpProduct.getName() == name){
                count++;
                product = (Product) shoppingList.get(i);

            }
        }
        if(product == null){
            return 0;
        }
        // price of a specific product times the amount it appears in the list
        totalPrice = product.getPrice()*count;
        return totalPrice;

    }
}

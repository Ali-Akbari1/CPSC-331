
public class Tuple{

    // Instance variables
    private String brand; 
    private int originalPrice; 
    private int discount;

    // Constructor for Tuple Class
    public Tuple(String brand, int originalPrice, int discount){ 
        this.brand = brand; 
        this.originalPrice = originalPrice;
        this.discount = discount; 

    }

    // toString method
    public String toString() {
        return "(" + "'" + brand + "'" +  ", " + originalPrice + ", " + discount + ")";
    }


    // Getter method for original price
    public int getOriginalPrice(){
        return originalPrice;
    }

    // Getter method for discount
    public int getDiscount(){
        return discount;
    }
}


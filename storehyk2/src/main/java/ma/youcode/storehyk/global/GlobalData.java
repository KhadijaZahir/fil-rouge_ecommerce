package ma.youcode.storehyk.global;


import ma.youcode.storehyk.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    //create global variable   intializing the variable cart
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }

}

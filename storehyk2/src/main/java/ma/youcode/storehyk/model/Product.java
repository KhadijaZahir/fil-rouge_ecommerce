package ma.youcode.storehyk.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    //@Data annotation Lombok to automatically generate:Setters toString constructor Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name;
    //Lazy Loading
    //Advantages:
    //Initial load time much smaller than in the other approach
    //Less memory consumption than in the other approach
    //Disadvantages:
    //Delayed initialization might impact performance during unwanted moments
    //In some cases you need to handle lazily-initialized objects with a special care or you might end up with an exception
    //Eager Loading:
    //Advantages:
    //No delayed initialization related performance impacts
    //Disadvantages:
    //Long initial loading time
    //Loading too much unnecessary data might impact performance
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    private double price;

    private double weight;

    private String description;

    private String imageName;

}


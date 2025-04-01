package src.main.java.com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "price_grid")
public class PriceGridmodal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int heightTo;
    private int widthTo;
    private double price;

    // Constructors
    public PriceGridmodal() {}

    public PriceGridmodal(int heightTo, int widthTo, double price) {
        this.heightTo = heightTo;
        this.widthTo = widthTo;
        this.price = price;
    }

    // Getters and Setters
    public int getHeightTo() { return heightTo; }
    public void setHeightTo(int heightTo) { this.heightTo = heightTo; }

    public int getWidthTo() { return widthTo; }
    public void setWidthTo(int widthTo) { this.widthTo = widthTo; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import DBofrestaurant.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author anzhela
 */
public class FoodData{
   
    private int id;
    private String category;
    private String name;
    private String compound;
    private double price;

    public FoodData(int id, String category,String name , String compound,
            double price) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.compound = compound;
        this.price = price;
    }

    public FoodData() {

    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return (name + "        " + price);
    }
}

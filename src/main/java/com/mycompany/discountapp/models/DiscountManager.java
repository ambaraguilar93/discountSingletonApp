/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.discountapp.models;

/**
 *
 * @author ambar
 */
public class DiscountManager {
    
    private static DiscountManager instance;
    
    private double globalDiscount = 0.10; 
    
    private String validCoupon = "PROMO15";
    private double couponDiscountPercent = 0.15; 

    private String discountedCategory = "Polera";
    private double discountedCategoryPercent = 0.05; 

    private DiscountManager() {
    }
    
    public static DiscountManager getInstance(){
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }
    
    public double calculateProduct(double basePrice, int quantity){
        
        double totalPrice = basePrice * quantity;
        
        return totalPrice;
    }
    
    public double applyDiscount(double totalPrice, String category, String couponCode){
        
        double totalDiscountPercent = 0.0;
        
        //Descuento general de la tienda
        totalDiscountPercent += globalDiscount;
        
        //Decuento aplicado por categoria
        if (category != null && category.equalsIgnoreCase(discountedCategory)) {
            totalDiscountPercent += discountedCategoryPercent;
        }
        
        //Descuento aplicado por cupon
        if (couponCode != null && couponCode.equalsIgnoreCase(validCoupon)) {
            totalDiscountPercent += couponDiscountPercent;
        }
        
        //Descuento final
        return totalPrice * (1 - totalDiscountPercent);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.discountapp.view;

import com.mycompany.discountapp.models.DiscountManager;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ambar
 */
public class Menu {
    
    private final Scanner scanner;
    
    public Menu(){
        this.scanner = new Scanner(System.in);
    }
    
    public void showMenu(){
        while(true){
            System.out.println("Bienvenido/a al sistema de pedidos Online");
            System.out.println("1. Hacer una compra");
            System.out.println("2. Salir");
            System.out.println("Seleccione una opcion: ");
            
            try{
                String opcion = scanner.nextLine();
                switch(opcion){
                    case "1":
                        makePurchase();
                        break;
                    case "2":
                        System.out.println("Gracias por usar nuestro sistema.");
                        return;
                    default:
                        System.out.println("Opcion invalida, intente nuevamente.");
                }
                
            } catch(InputMismatchException e){
                System.out.println("Entrada invalida. Ingrese un numero.");
                scanner.nextLine();
            }
  
        }
    }
    
    public void makePurchase(){
        String producto = "";
        while(true){

            System.out.println("Productos disponibles");
            System.out.println("1. Poleras");
            System.out.println("2. Pantalones");
            System.out.println("3. Zapatos");
            System.out.println("4. Chalecos");
            System.out.println("Seleccione un producto de la lista: ");
            
            try{
                int productoSeleccionado;
                productoSeleccionado = scanner.nextInt();
        
        
                switch(productoSeleccionado){
        
                    case 1:
                        producto = "Polera";
                        break;
                    case 2:
                        producto = "Pantalon";
                        break;
                    case 3:
                        producto = "Zapatos";
                        break;
                    case 4:
                        producto = "Chaleco";
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                        return;
                }
            } catch(InputMismatchException e){
                System.out.println("Entrada invalida. Ingrese un numero.");
                scanner.nextLine();
            }
        
              
        double precioBase;

        while (true) {
            System.out.println("Ingrese el precio de " + producto);

        try {
            precioBase = scanner.nextDouble();

            if (precioBase <= 0) {
                System.out.println("El precio no puede ser 0 o menor.");
                continue; 
            }
            break; 

        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Ingrese un numero.");
            scanner.nextLine(); 
        }
    }
        
        int cantidadProducto;
        while(true){
            System.out.println("Ingrese cantidad de "+producto+ " que desea: ");
            
            try {          
                
                cantidadProducto = scanner.nextInt();
                scanner.nextLine();
            
                if (cantidadProducto <= 0) {
                System.out.println("La cantidad de productos no puede ser 0 o menor.");
                continue;
            }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Ingrese un numero.");
                scanner.nextLine(); 
            }
               
        }
        
        String cupon;
        while (true) {
            System.out.println("Ingrese cupon de descuento: ");
            cupon = scanner.nextLine();

            if (cupon.equals("PROMO15") || cupon.isEmpty()) {
                break; 
            } else {
                System.out.println("El cupón no es válido.");
            }
        }
        
        
        DiscountManager discount = DiscountManager.getInstance();
        
        double totalPrice = discount.calculateProduct(precioBase, cantidadProducto);
        
        double finalPrice = discount.applyDiscount(totalPrice, producto, cupon );
        
        
        
        System.out.println("Compra realizada.");
        System.out.println("Producto seleccionado: "+producto);
        System.out.println("Precio base: " +precioBase);
        System.out.println("Cantidad de "+producto+"s compradas: "+cantidadProducto);
        System.out.println("Precio total: "+totalPrice);
        System.out.println("Total a pagar con descuentos: "+finalPrice );
        
        
    }
}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiinteractorclasses;

import static java.lang.Math.pow;

/**
 *
 * @author GeorgeK
 */
public class Product {
   private String name ;
   private double price ;
    private int points ;
    public Product(){
        name="";
        points=-1;
        price=-1;
    };
    public Product(String productName,int productPoints,double productPrice){
        name=productName;
        points=productPoints;
        price=productPrice;
    }
    public void setName(String productName){name=productName;return;}
    public void setPrice(double productPrice){price=productPrice;return;}
    public void setPoints(int productPoints){points=productPoints;return;}
    public String getName(){return name;}
    public int getPoints(){return points;}
    public double getPrice(){return price;}
    public void setProduct(Product product){
        name=product.getName();
        points=product.getPoints();
        price=product.getPrice();
    }
    public int pointsFromString(String points){
       int pointLength = points.length();
       int convertedString=0;
       for(int i=0;i<pointLength;i++){
           if(points.charAt(i)<48||points.charAt(i)>57)
               return -1;
       }
       for(int i=pointLength-1;i>-1;i--){
         //  System.out.println(points.charAt(i)+"/"+(points.charAt(i)-48)+"/"+((pointLength-1-i)));
           //System.out.println();
           convertedString=(int) (convertedString+((points.charAt(i)-48)*(pow(10,(pointLength-1-i)))));
       }
       return convertedString;
    }
}
       
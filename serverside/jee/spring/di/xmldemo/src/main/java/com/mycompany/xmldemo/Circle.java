package com.mycompany.xmldemo;


public class Circle implements IShape {



    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }


    public void afterInit(){
        System.out.println("inside afterInit of Circle"+radius);
    }

    public void onDestroy(){
        System.out.println("inside Circle onDestroy");
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

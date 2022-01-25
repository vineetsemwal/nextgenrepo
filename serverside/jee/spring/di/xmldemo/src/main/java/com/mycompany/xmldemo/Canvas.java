package com.mycompany.xmldemo;


public class Canvas {


    private IShape shape;

    public void setShape(IShape shape){
        this.shape = shape;
    }

    public void drawShape(){
        double area= shape.area();
        System.out.println("drawing shape"+area +" "+shape.getClass().getSimpleName());
    }

    public void afterInit(){
        System.out.println("inside afterInit of Canvas"+shape);
    }

    public void onDestroy(){
        System.out.println("inside Canvas onDestroy");
    }



}

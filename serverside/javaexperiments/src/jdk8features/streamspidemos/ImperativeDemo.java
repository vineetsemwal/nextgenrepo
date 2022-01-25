package jdk8features.streamspidemos;

import java.util.Arrays;
import java.util.List;

public class ImperativeDemo {


    public static void main(String args[]){

    }

    /**
     *
     * input : List<String>
     *
     *  total length of all even length strings
     */
    public int totalEvenLength( List<String>list){
        int totalLength=0;
        for(String str:list){
            if(str.length()%2==0){
                totalLength=totalLength+str.length();
            }
        }
        return totalLength;
    }




}

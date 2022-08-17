package com.company;

public class Main {

    public static void main(String[] args) {
        String str[] ;
        int count = 0;
        for (int i = 9; i <20 ; i++){
            if(i>0 && i<10){
                count++;
            }
            str = String.valueOf(i).split("");
            for (int j = 0; j < str.length-1 ; j++) {
                if (str[0].equals(str[str.length-1]) ) {
                    count++;
                    break;
                }
            }

        }
        System.out.println(count);
    }

}

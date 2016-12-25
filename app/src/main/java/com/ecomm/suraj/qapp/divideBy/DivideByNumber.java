package com.ecomm.suraj.qapp.divideBy;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by surajbokankar on 22/12/16.
 */

public class DivideByNumber {
    private static final String TAG = "DivideByNumber";
    static DivideByNumber divideByNumber;
    public DivideByNumber(){

    }

    public  static DivideByNumber getInstance(){
        if(divideByNumber==null){
            divideByNumber=new DivideByNumber();
        }
        return divideByNumber;
    }


    public boolean divideByTwo(int number){
        boolean isDivideByTwo=false;
        try{

            int[] numberArray={0,2,4,6,8};
            double lastGeneratedDoubleNUmber=(double)number;
            int unitDigit=lastDigit(lastGeneratedDoubleNUmber);
            for(int s:numberArray){
                if(s==unitDigit){
                    isDivideByTwo=true;
                }
            }
            }catch (Exception e){
            e.printStackTrace();
            Log.i(TAG, "dovideByTwo: Error="+e.getMessage());
        }
        return  isDivideByTwo;
    }


    public int lastDigit(double number){
        double digit;
        if(number<0){
            digit=Math.abs(number)%10;
        }else{
            digit=number%10;
        }
        return  (int)digit;
    }


    public int sumOfDigit(int number){
        int sum=0;
        while (number>0){
            int num=number%10;
            sum=sum+num;
            number=number/10;
        }
    return  sum;
    }


    public boolean divideByThree(int number){
        boolean isDivideByThree=false;
        try{
            int sum=0;
           sum=sumOfDigit(number);
            int divisor=sum%3;
            if(divisor==0){
                isDivideByThree=true;
            }
        }catch (Exception e){
            Log.i(TAG, "divideByThree: Error="+e.getMessage());
        }
        return  isDivideByThree;
    }


    public boolean divideByFour(int d){

        boolean isDivideByFour=false;
        try{

            String numberInText=String.valueOf(d);
            String lastTwoDigit=numberInText.substring(numberInText.length()-2,numberInText.length());
            Log.i(TAG, "divideByFour: Last Two Digit="+lastTwoDigit);
            int digit=Integer.parseInt(lastTwoDigit);
            if(digit%4==0){
                isDivideByFour=true;
            }

        }catch (Exception e){
            Log.i(TAG, "divideByFour: Error="+e.getMessage());
        }
        return  isDivideByFour;
    }


    public boolean divideByFive(int number){
       boolean isDivideByFive=false;
        try{
             double lastGeneratedDoubleNUmber=(double)number;
            int unitDigit=lastDigit(lastGeneratedDoubleNUmber);
            if(unitDigit==0||unitDigit==5){
                isDivideByFive=true;
            }

        }catch (Exception e){
            Log.i(TAG, "divideByFive: error="+e.getMessage());
            e.printStackTrace();
        }
        return  isDivideByFive;
    }


    public boolean divideBySix(int number){
        boolean isDivideBySix=false;
        try{

            boolean isDividedByTwo=divideByTwo(number);
            boolean isDividedByThree=divideByThree(number);
            if(isDividedByThree&&isDividedByTwo){
                isDivideBySix=true;
            }
        }catch (Exception e){
            Log.i(TAG, "divideBySix: Error="+e.getMessage());
        }
        return  isDivideBySix;
    }

    public boolean divideByEight(int number){
        boolean isDividedByEight=false;
        try{
            String valueOfNumber=String.valueOf(number);
            String lastThreeDigit=valueOfNumber.substring(valueOfNumber.length()-3,valueOfNumber.length());
            int   divisor=Integer.parseInt(lastThreeDigit);
            int  afterDivisionNumber=divisor%8;
            if(afterDivisionNumber==0){
              isDividedByEight=true;
            }
        }catch (Exception e){
            Log.i(TAG, "divideByEight: Error="+e.getMessage());
        }
        return  isDividedByEight;
    }


    public boolean divideByNine(int number){
        boolean isDivideByNine=false;
        try{
         int sum=sumOfDigit(number);
            int divisor=sum%9;
            if(divisor==0){
                isDivideByNine=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.i(TAG, "divideByNine: Error="+e.getMessage());
        }
       return  isDivideByNine;
    }


    public boolean divideByTen(int number){
        boolean isDivideByTen=false;
        try {
            double d=(double)number;
           int unitDigit=lastDigit(d);
            if(unitDigit==0&&unitDigit==10){
                isDivideByTen=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.i(TAG, "divideByTen: Error="+e.getMessage());
        }
        return isDivideByTen;
    }


    public  boolean divideByEleven(int number){
        boolean isDividedByEleven=false;
         int Even=0,Odd=0;
        try{
            while (number>0){
                int x=number%10;
                if(x%2==0){
                    Even=Even+x;
                }else{
                    Odd=Odd+x;
                }
                number=number/10;
            }
            int diffOfNumberSum=Even-Odd;
            if((diffOfNumberSum/11)==0){
                isDividedByEleven=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.i(TAG, "divideByEleven: Error="+e.getMessage());
        }
        return  isDividedByEleven;
    }



    public  String numberDivisibleOutput(ArrayList<String> optionList, int number){

        String responseString=null;
        StringBuilder responseBuilder=new StringBuilder();
        for(String s:optionList){
            switch (s){
                case "DivideBy Two":
                    boolean response=divideByTwo(number);
                    if(response){
                        responseBuilder.append("DividedByTwo = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Two").append("\n");
                    }
                    break;

                case "DivideBy Three":
                    boolean responseThree=divideByThree(number);
                    if(responseThree){
                        responseBuilder.append("DividedBy Three = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Three").append("\n");
                    }
                    break;

                case "DivideBy Four":
                    boolean responseFour=divideByFour(number);
                    if(responseFour){
                        responseBuilder.append("DividedBy Four = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Four").append("\n");
                    }
                    break;

                case "DivideBy Five":
                    boolean responseFive=divideByFive(number);
                    if(responseFive){
                        responseBuilder.append("DividedBy Five = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Five").append("\n");
                    }
                    break;

                case "DivideBy Six":
                    boolean responseSix=divideBySix(number);
                    if(responseSix){
                        responseBuilder.append("DividedBy Six = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Six").append("\n");
                    }
                    break;
                case "DivideBy Eight":
                    boolean responseEight=divideByEight(number);
                    if(responseEight){
                        responseBuilder.append("DividedBy Eight = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Eight").append("\n");
                    }
                    break;
                case "DivideBy Nine":
                    boolean responseNine=divideByNine(number);
                    if(responseNine){
                        responseBuilder.append("DividedBy Nine = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Nine").append("\n");
                    }
                    break;
                case "DivideBy Ten":
                    boolean responseTen=divideByTen(number);
                    if(responseTen){
                        responseBuilder.append("DividedBy Ten = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Ten").append("\n");
                    }
                    break;
                case "DivideBy Eleven":
                    boolean responseEleven=divideByEleven(number);
                    if(responseEleven){
                        responseBuilder.append("DividedBy Eleven = True").append("\n");
                    }else{
                        responseBuilder.append("NotDivided Eleven").append("\n");
                    }
                    break;
            }
        }


        responseString=responseBuilder.toString();

        return responseString;

    }



}

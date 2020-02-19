package com.dileep.CleanCode;

import java.io.*;


public class App {
    public static void main(String args[]) throws IOException{
        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
        System.out.append("What operation you want to preform.......\n");
        System.out.append("1.Interest Calculation\n2.Construction cost Estimation\nEnter your option : ");
        int op = Integer.parseInt(brin.readLine());
        if(op == 1){
            Interest i = new Interest();
            double interest = 0;
            System.out.append("\n1.Simple Interest\n2.Compond Interest\nEnter your option : ");
            int typeofInterest = Integer.parseInt(brin.readLine());
            double principal,rateofInterest,time,noOfTimesPerYear;
            System.out.append("\nEnter Principal Amount : ");
            principal = Double.parseDouble(brin.readLine());
            System.out.append("\nEnter Rate of Interest : ");
            rateofInterest = Double.parseDouble(brin.readLine());
            System.out.append("\nEnter Time period : ");
            time = Double.parseDouble(brin.readLine());
            if(typeofInterest == 2){
                System.out.append("\nEnter number of times interest to be calculated : ");
                noOfTimesPerYear = Double.parseDouble(brin.readLine());
                interest = i.compoundInterest(principal,time,rateofInterest,noOfTimesPerYear);
            }
            else {
                interest = i.simpleInterest(principal,time,rateofInterest);
            }
            System.out.append("\nTotal Interest : " + interest+" INR.\n");
            System.out.append("Total Amount : " + (principal+interest) + " INR.\n");
        }
        else{
            Estimation est = new Estimation();
            System.out.append("Enter the Area of the House : ");
            double area = Double.parseDouble(brin.readLine());
            System.out.append("\nMaterial Standards - Cost per Square Feet \n1.Normal Standard - 1200INR\n2.Above Standard - 1500INR\n3.High Standard - 1800INR\n4.High Standard with fully Automated - 2500INR\n");
            System.out.append("\nEnter  your option : ");
            int standard = Integer.parseInt(brin.readLine());

            System.out.append("Do you want Fully Automated home?(y/n)");
            String str = brin.readLine();
            boolean fullyautomated = false;
            if(str.charAt(0) == 'y')
                fullyautomated = true;
            double estimatedcost = est.estimateHouse(area, standard, fullyautomated);
            System.out.append("Estimated cost for Construction is "+estimatedcost + " INR\n");
        }
        brin.close();
    }
}
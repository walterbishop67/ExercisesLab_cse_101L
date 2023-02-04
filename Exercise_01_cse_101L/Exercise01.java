import java.util.Scanner;

public class Exercise01{
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("=>Question 1:");
        int a =1;
        System.out.println("a\ta^2\ta^3");
        System.out.println(a+"\t"+a*a+"\t"+a*a*a++);
        System.out.println(a+"\t"+a*a+"\t"+a*a*a++);
        System.out.println(a+"\t"+a*a+"\t"+a*a*a++);
        System.out.println(a+"\t"+a*a+"\t"+a*a*a++);
        System.out.println("____________________________________________");


        System.out.println("=>Question 2:");
        System.out.println((9.5*4.5-2.5*3)/(45.5-3.5));
        System.out.println("____________________________________________");


        System.out.println("=>question 3:");
        double result1=4*(1.0-1.0/3+1.0/5-1.0/7+1.0/9-1.0/11);
        double result2=4*(1.0-1.0/3+1.0/5-1.0/7+1.0/9-1.0/11+1.0/13);
        System.out.println("PI1:"+result1+"\t"+"PI2:"+result2);
        System.out.println("____________________________________________");


        System.out.println("=>Question 4");
        double radius=5.5;
        double area2=result2*radius*radius,area1=result1*radius*radius;
        double permiter2 =2*result2*radius,permiter1=2*result1*radius;
        System.out.println("Area for PI1:"+area1+"\t"+"Permiter for PI1:"+permiter1);
        System.out.println("Area for PI2:"+area2+"\t"+"Permiter for PI2:"+permiter2);
        System.out.println("____________________________________________");


        System.out.println("=>Question 5");
        double a1=3.4 , b=50.2 , c=2.1 , d=0.55 , e=44.5 , f=5.9 ;
        double x=(e*d-b*f)/(a1*d-b*c);
        double y=(a1*f-e*c)/(a1*d-b*c);
        System.out.println("x:"+x+" y:"+y);
        System.out.println("First equation result(e) is:"+(a1*x+b*y)+"\n"+"Secand equation result(f) is :"+(c*x+d*y));
        System.out.println("____________________________________________");


        System.out.println("=>Question 6");
        System.out.println("Enter a celcius degree:");
        double celcius= input.nextDouble();
        double fahrenheit=9.0/5*celcius+32;
        System.out.println("In fahrenheit:"+fahrenheit);
        System.out.println("____________________________________________");

        System.out.println("=>Question 7");
        System.out.println("Enter a radius value:");
        double radius2 = input.nextDouble();
        System.out.println("Enter a lenght value:");
        double lenght= input.nextDouble();
        //I use real PI in this question and it can be replaced with the pi of 3rd question.
        double area=radius2*radius2*Math.PI;
        System.out.println("Area of cylinder:"+area);
        System.out.println("Volume of cylinder:"+area*lenght);
        System.out.println("____________________________________________");


        System.out.println("=>Question 8");
        System.out.println("Enter a random number between 0 and 1000:");
        int number= input.nextInt();
        int digit3 =number/100;
        int b2=number%100;
        int digit2=b2/10;
        int digit1=b2%10;
        System.out.println("Total of the digits:"+(digit1+digit2+digit3));
        System.out.println("____________________________________________");


        System.out.println("=>Question 9");
        System.out.println("Enter a random minute:");
        int minute=input.nextInt();
        int totalDay=minute/1440;
        int year=totalDay/365;
        int day=totalDay%365;
        System.out.println("year:"+year+" "+"day:"+day);
        System.out.println("____________________________________________");


        System.out.println("=>Question 10:");
        double moneyf,total1;
        System.out.print("Choose amount of money:");
        moneyf=input.nextDouble();
        total1=moneyf*(1+0.05/12);
        total1=(total1+moneyf)*(1+0.05/12);
        total1=(total1+moneyf)*(1+0.05/12);
        total1=(total1+moneyf)*(1+0.05/12);
        total1=(total1+moneyf)*(1+0.05/12);
        total1=(total1+moneyf)*(1+0.05/12);
        System.out.println("Total money after six months:"+total1);



        System.out.println("____________________________________________");


        System.out.println("=>question 11");
        System.out.print("Enter weight in pounds : ");
        double pound = input.nextDouble();
        System.out.print("Enter height in inches: ");
        double inches = input.nextDouble();
        double kilogram = pound*0.45359237;
        double metre = inches*0.0254;
        double BMI=kilogram / (metre * metre);
        System.out.println("Your BMI:"+BMI);
        System.out.println("____________________________________________");


        System.out.println("=>question 12");
        System.out.print("Enter value of x1: ");
        double x1= input.nextDouble();
        System.out.print("Enter value of y1: ");
        double y1= input.nextDouble();
        System.out.print("Enter value of x2: ");
        double x2= input.nextDouble();
        System.out.print("Enter value of y2: ");
        double y2= input.nextDouble();
        double distance = Math.pow(x2-x1,2)+Math.pow(y2-y1,2);
        distance = Math.pow(distance,0.5);
        System.out.println("Distance of two entered point:"+distance);
        System.out.println("____________________________________________");


        System.out.println("=>Question 13");
        System.out.println("Enter value of x1:");
        double X1 = input.nextDouble();
        System.out.println("Enter value of y1:");
        double Y1 = input.nextDouble();
        System.out.println("Enter value of x2:");
        double X2= input.nextDouble();
        System.out.println("Enter value of y2:");
        double Y2 = input.nextDouble();
        System.out.println("Enter value of x3:");
        double X3= input.nextDouble();
        System.out.println("Enter value of y3:");
        double Y3 = input.nextDouble();
        double side1 = Math.pow(X2-X1,2)+Math.pow(Y2-Y1,2);
        side1=Math.pow(side1,0.5);
        double side2 = Math.pow(X3-X2,2)+Math.pow(Y3-Y2,2);
        side2=Math.pow(side2,0.5);
        double side3 = Math.pow(X3-X1,2)+Math.pow(Y3-Y1,2);
        side3=Math.pow(side3,0.5);
        double s = (side1+side2+side3)/2;
        double area3=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        System.out.println("Area of triangle is:"+area3);

    }
}
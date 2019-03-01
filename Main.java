package com.surya;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static ArrayList<Taxi> taxis=new ArrayList<Taxi>();
    static ArrayList<Booking> bookings=new ArrayList<Booking>();
    public static void main(String[] args) {

        taxis.add(new Taxi(4584));
        taxis.add(new Taxi(4587));
        taxis.add(new Taxi(4607));
        taxis.add(new Taxi(4576));
        displayinformation();
        boolean quit=false;
        while(!quit)
        {
            System.out.println("Enter your choice");
            int User_choice=scanner.nextInt();
            switch(User_choice)
            {
                case 1:Tobook();
                       break;
                case 2:Todisplay();
                       break;
                case 3:quit=true;
                        break;
                default:
                    System.out.println("choose correct choice");
            }
        }



    }

    public static void Tobook(){
        System.out.println("*****************Welcome to Surya Cabs**************");
        System.out.println("enter customer ID");
        int cusID=scanner.nextInt();
        System.out.println("enter pickup point");
        char pickuppoint=scanner.next().charAt(0);
        System.out.println("enter drop point");
        char  droppoint=scanner.next().charAt(0);
        System.out.println("enter pickup time");
        int pickuptime=scanner.nextInt();
        Booking booking=new Booking(cusID,pickuppoint,droppoint,pickuptime);
        System.out.println("check test");
        Taxi taxi=booking.is_available(taxis);
        if(taxi!=null)
        {
            System.out.println(taxi.getTaxiNo() +" taxi number is allocated ");
            booking.calculate_Bill();
            booking.droptime();
            int taxi_position=taxis.indexOf(taxi);
            taxis.get(taxi_position).totalEarning(booking.getPickupPoint(),booking.getDropPoint());

        }
        else
        {
            System.out.println("No taxi available.Booking rejected");
        }

        bookings.add(booking);
    }

    public static void Todisplay(){
        System.out.println("Taxi information");
        for(Taxi taxi:taxis)
        {
            System.out.println("Taxi number"+taxi.getTaxiNo()+"\n"+
                               "taxi location"+taxi.getInitialPoint()+"\n"+
                               "taxi available time"+taxi.getAvailabilityTime()+"\n"+
                                "taxi earnings"+taxi.getEarnings());
        }
        System.out.println("booking information");
        for(Booking booking:bookings)
        {
            System.out.println("customer id  "+booking.getCustomerId()+"\n"+
                                "pickup point "+booking.getPickupPoint()+"\n"+
                                "drop point "+booking.getDropPoint()+"\n"+
                                 "pickup time "+booking.getPickupTime()+"\n"+
                                  "drop time "+booking.getDropTime()+"\n"+
                                  "bill amount"+booking.getBillAmount());
        }


    }

    public static void displayinformation(){
        System.out.println("1->book\n"+
                            "2->display\n"+
                            "3->exit\n" );
    }
}

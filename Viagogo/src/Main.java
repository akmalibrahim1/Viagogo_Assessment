import java.util.Scanner;

/**
 * Created by akmalibrahim on 5/6/17.
 */
public class Main {
    public static void main (String [] args) {
        EventLocater el = new EventLocater();
        el.seedData();
        Scanner scan = new Scanner(System.in);

        boolean xflag = true;
        while(xflag == true) {
            System.out.println("\nPlease enter the x coordinate of your location between numbers -10 and 10: ");
            int x = scan.nextInt();


            if(x >= -10 && x <=10) {
                boolean yflag = true;
                while(yflag == true) {
                    System.out.println("\nPlease enter the y coordinate of your location between numbers -10 and 10: ");
                    int y = scan.nextInt();
                    if (y >= -10 && y <= 10) {
                        EventLocater.EventDistance [] ed = el.findEvents(x, y);
                        System.out.println("\n The closest events to ("+ x + "," + y +") are : ");
                        for(int i = 0; i < ed.length; i++) {
                            System.out.println("Event " + ed[i].event.getID() + " - " + ed[i].event.getCheapestTicket()
                                    + ", Distance " + ed[i].dist);

                        }
                        System.out.println("\nSelect y to do a different search or n to quit\n");
                        boolean qflag = true;
                        while(qflag == true) {
                            String check = scan.nextLine();
                            if(check.equals("y")) {
                                qflag = false;
                                yflag = false;
                            } else if (check.equals("n")) {
                                System.out.println("Thank you");
                                qflag = false;
                                yflag = false;
                                xflag = false;
                            } else {
                                System.out.println("Please select y or n");
                            }
                        }
                    }
                }
            }
        }
    }
}


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static Service service;

    public static void main(final String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        service = (Service) ctx.getBean("Service");
        int ans;
        Scanner in = new Scanner(System.in);
        while (true){
            writeMenu();
            ans = in.nextInt();
            switch (ans){
                case 1:
                    service.showAllFlights();
                    break;
                case 2:
                    service.addNewFlight();
                    break;
                case 3:
                    service.reserveSeat();
                    break;
                case 4:
                    service.task();
                    break;
            }
        }
    }

    private static void writeMenu() {
        System.out.println("1 - show all flights");
        System.out.println("2 - add new flight");
        System.out.println("3 - reserve seat");
        System.out.println("4 - task");
    }



}

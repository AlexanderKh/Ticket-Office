import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(final String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        Programme service = (Programme) ctx.getBean("MainClass");
        service.ex();

    }

}

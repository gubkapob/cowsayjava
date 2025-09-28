package local.rnd;

import local.rnd.cow.controller.CowController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalSaysJavaApp implements CommandLineRunner {

    private final CowController controller;

    @Autowired
    public AnimalSaysJavaApp(CowController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(AnimalSaysJavaApp.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        // старт контроллера — он уже реализует цикл чтения со stdin
        controller.runConsole();
    }
}


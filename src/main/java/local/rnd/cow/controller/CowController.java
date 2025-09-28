package local.rnd.cow.controller;

import local.rnd.cow.model.CowMessageModel;
import local.rnd.cow.service.CowBubbleServiceImpl;
import local.rnd.cow.view.CowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class CowController {

    private final CowBubbleServiceImpl cowBubbleService;
    private final CowView cowView;

    @Autowired
    public CowController(CowBubbleServiceImpl cowBubbleService, CowView cowView) {
        this.cowBubbleService = cowBubbleService;
        this.cowView = cowView;
    }

    /**
     * Консольный цикл — читает строки из stdin и рисует корову.
     * Команда "exit" или CTRL+D завершает работу.
     */
    public void runConsole() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            System.out.println("cowsay — введите текст (наберите 'exit' или CTRL+D для выхода):");

            while (true) {
                System.out.print("> ");
                line = reader.readLine();

                if (line == null) {
                    System.out.println("--> lines eq null <-- Program exiting!");
                    break;
                }

                if ("exit".equalsIgnoreCase(line.trim())) {
                    System.out.println("Bye!");
                    break;
                }

                CowMessageModel message = new CowMessageModel(line);
                List<String> wrapped = CowBubbleServiceImpl.wrap(message);
                cowView.renderSpeechBubble(wrapped);
                cowView.renderAnimal();

            }
        } catch (Exception e) {
            System.err.println("Error in console loop: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

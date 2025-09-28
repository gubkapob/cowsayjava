package local.rnd.cow.view;

import local.rnd.viewmain.AnimalAbstract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CowView extends AnimalAbstract {
    
    @Override
    public void renderSpeechBubble(List<String> lines) {
        int maxLen = lines.stream().mapToInt(String::length).max().orElse(0);

        //upper zone
        System.out.print(" ");
        for (int i = 0; i < maxLen + 2; i++) System.out.print("_");
        System.out.println();

        //bubble context
        for (int i = 0; i < lines.size(); i++) {

            String s = lines.get(i);
            String borderLeft = "";
            String borderRight = "";

            if (lines.size() == 1) {
                borderLeft = "<";
                borderRight = ">";
            } else if (i == 0) {
                borderLeft = "/";
                borderRight = "\\";
            } else if (i == lines.size() - 1) {
                borderLeft = "\\";
                borderRight = "/";
            } else {
                borderLeft = "|";
                borderRight = "|";
            }

            System.out.printf("%s %-" + maxLen + "s %s%n", borderLeft, s, borderRight);

        }

        //lower zone
        System.out.print(" ");
        for (int i = 0; i < maxLen +2; i++) System.out.print("-");
        System.out.println();

    }

    @Override
    public void renderAnimal() {
        System.out.println("        \\   ^__^");
        System.out.println("         \\  (oo)\\_______");
        System.out.println("            (__)\\       )\\/\\");
        System.out.println("                ||----w |");
        System.out.println("                ||     ||");
    }
}

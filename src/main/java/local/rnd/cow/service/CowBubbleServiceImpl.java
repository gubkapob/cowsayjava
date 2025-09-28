package local.rnd.cow.service;

import local.rnd.cow.model.CowMessageModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CowBubbleServiceImpl implements CowBubbleService {

    /**
     * Максимальная ширина строки внутри облака
     */
    private static final int MAX_WIDTH = 40;

    /**
     * Разбивает текст на строки для "речевого облачка".
     */
    public static List<String> wrap(CowMessageModel message) {
        String text = message.getText();
        List<String> lines = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            lines.add("");
            return lines;
        }

        String[] words = text.split("\s+");
        StringBuilder line = new StringBuilder();
        for (String w : words) {
            if (line.length() + w.length() + (line.isEmpty() ? 0 : 1) > MAX_WIDTH) {
                lines.add(line.toString());
                line = new StringBuilder(w);
            } else {
                if (!line.isEmpty()) line.append(' ');
                line.append(w);
            }
        }
        if (!line.isEmpty()) lines.add(line.toString());
        return lines;
    }
}

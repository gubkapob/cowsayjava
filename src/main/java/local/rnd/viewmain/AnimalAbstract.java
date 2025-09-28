package local.rnd.viewmain;

import java.util.List;

public abstract class AnimalAbstract {

    /**
     * Метод рисует облако, окружающее текст.
     * */
    public abstract void renderSpeechBubble(List<String> lines);

    /**
     * Метод рисует животное.
     * */
    public abstract void renderAnimal();

}

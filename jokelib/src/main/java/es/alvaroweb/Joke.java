package es.alvaroweb;

import java.util.Random;

public class Joke {
    private final static String[] JOKES = {
            "What did one wall say to the other wall? - We will meet at the corner.",
            "What kind of bagel can fly? A plain bagel",
            "Where did Mary go after the explosion? EVERYWHERE",
            "What was a more important version than the first telephone? The second one",
            "A man walks into a zoo. The only animal in the entire zoo is a dog. It's a shitzhu",
            "Bill Gates farted in an apple store stank up the entire place. But it's their own fault for not having windows"
    };

    private final static Random RANDOM = new Random();

    public static String getJoke(){
        int random = RANDOM.nextInt(JOKES.length);
        return JOKES[random];
    }
}

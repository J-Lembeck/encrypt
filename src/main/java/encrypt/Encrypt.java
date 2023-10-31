package encrypt;

public class Encrypt {
	public static String encryptThis(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }

        String[] words = message.split(" ");
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                encryptedMessage.append(" ");
            }

            String word = words[i];
            if (word.length() >= 1) {
                char firstChar = word.charAt(0);
                int asciiValue = (int) firstChar;
                encryptedMessage.append(asciiValue);

                if (word.length() > 1) {
                    char lastChar = word.charAt(word.length() - 1);
                    char secondChar = word.charAt(1);

                    encryptedMessage.append(lastChar);
                    if(word.length() > 2) {
                    	String middleChars = word.substring(2, word.length() - 1);
                    	encryptedMessage.append(middleChars);
                    	encryptedMessage.append(secondChar);
                    }                    
                }
            }
        }

        return encryptedMessage.toString();
    }

    public static void main(String[] args) {
        System.out.println(encryptThis("Hello"));
        System.out.println(encryptThis("good"));
        System.out.println(encryptThis("hello world")); 
        System.out.println(encryptThis("casa mesa bola gato rato abac amo bebê cama dado face gira hora jogo kara leão lobo mão nata olho pala quei rei sela toco uva vaso zelo arco bico coco dedo euro fato giro hino jato kiko lama mono nado onça pino quim rosa sopa taco ufo viga zulu avião bala carro dama fogo galo juba lobo maca nene oito pote quim rosa sopa taco urso veio zang abraç cadei dente elef fogo gala juba kiko lava meni noel orla pote quei rolo sara tiro umor veio zelo anda bola carro duna fava gama juba kiwi lava melo nexo onda pote quei rato sura tril urso vela zelo aula bola cama dança flor goma jibo kiko lapa melo nexo orla pote quei rato sara tora urso veio zelo")); 
    }
}


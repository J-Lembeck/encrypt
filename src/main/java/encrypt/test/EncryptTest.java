package encrypt.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import encrypt.Encrypt;

public class EncryptTest {

	//Testa o retorno a partir de uma String vazia.
	@Test
    public void testEncryptThisWithEmptyString() {
        String encrypted = Encrypt.encryptThis("");
        assertEquals("", encrypted);
    }

	//Testa o retorno a partir de uma String com um caracter apenas.
	//Para validar a converção para ASCII
    @Test
    public void testEncryptThisWithSingleDigit() {
        String encrypted = Encrypt.encryptThis("a");
        assertEquals("97", encrypted);
    }

    //Testa o retorno a partir de uma String com dois caracteres.
    //Para testar a troca entre o segundo caracter e o último.
    @Test
    public void testEncryptThisWithTwoDigits() {
        String encrypted = Encrypt.encryptThis("ab");
        assertEquals("97b", encrypted);
    }
    
    //Testa o retorno a partir de uma String com uma palavra com mais de 2 caracteres.
    @Test
    public void testEncryptThisWithOneWord() {
        String encrypted = Encrypt.encryptThis("Word");
        assertEquals("87dro", encrypted);
    }
    
    //Testa o retorno a partir de uma String com duas palavras com mais de 2 caracteres.
    @Test
    public void testEncryptThisWithTwoWords() {
        String encrypted = Encrypt.encryptThis("Two Words");
        assertEquals("84ow 87srdo", encrypted);
    }

    //Testa o retorno a partir de uma String com caracteres especiais.
    @Test
    public void testEncryptThisWithSpecialCharacters() {
        String encrypted = Encrypt.encryptThis("123$%^&");
        assertEquals("49&3$%^2", encrypted);
    }
    
    //Testa o retorno a partir de uma String com 1000 caracteres.
    //Para garantir que nao ocorra erros no loop.
    @Test
    public void testEncryptThisWithAThousandCharacters() {
    	String thousandCharacters = this.createAlphabeticalString(1000);
        String encrypted = Encrypt.encryptThis(thousandCharacters);
        assertEquals("97lcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkb", encrypted);
    }
    
    //Testa o retorno a partir de uma String com 100 palavras com mais de 2 caracteres.
    //Para garantir que nao ocorra erros no loop.
    public void testEncryptThisWithAOneHundredWords() {
        String encrypted = Encrypt.encryptThis("casa mesa bola gato rato abac amo bebê cama dado face gira hora jogo kara leão lobo mão nata olho pala quei rei sela toco uva vaso zelo arco bico coco dedo euro fato giro hino jato kiko lama mono nado onça pino quim rosa sopa taco ufo viga zulu avião bala carro dama fogo galo juba lobo maca nene oito pote quim rosa sopa taco urso veio zang abraç cadei dente elef fogo gala juba kiko lava meni noel orla pote quei rolo sara tiro umor veio zelo anda bola carro duna fava gama juba kiwi lava melo nexo onda pote quei rato sura tril urso vela zelo aula bola cama dança flor goma jibo kiko lapa melo nexo orla pote quei rato sara tora urso veio zelo");
        assertEquals("99asa 109ase 98alo 103ota 114ota 97cab 97om 98êbe 99ama 100oda 102eca 103ari 104aro 106ogo 107ara 108oãe 108obo 109oã 110ata 111ohl 112ala 113ieu 114ie 115ale 116oco 117av 118osa 122ole 97ocr 98oci 99oco 100ode 101oru 102ota 103ori 104oni 106ota 107oki 108ama 109ono 110oda 111açn 112oni 113miu 114aso 115apo 116oca 117of 118agi 122ulu 97oiãv 98ala 99orra 100ama 102ogo 103ola 106abu 108obo 109aca 110ene 111oti 112eto 113miu 114aso 115apo 116oca 117osr 118oie 122gna 97çrab 99idea 100ente 101fel 102ogo 103ala 106abu 107oki 108ava 109ine 110leo 111alr 112eto 113ieu 114olo 115ara 116ori 117rom 118oie 122ole 97adn 98alo 99orra 100anu 102ava 103ama 106abu 107iwi 108ava 109ole 110oxe 111adn 112eto 113ieu 114ota 115aru 116lir 117osr 118ale 122ole 97alu 98alo 99ama 100ança 102rol 103amo 106obi 107oki 108apa 109ole 110oxe 111alr 112eto 113ieu 114ota 115ara 116aro 117osr 118oie 122ole", encrypted);
    }
    
    //Função para criar uma String com um numero informado de caracteres em ordem alfabética
    public String createAlphabeticalString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("O comprimento da string deve ser maior que 0.");
        }

        StringBuilder stringBuilder = new StringBuilder(length);
        char currentChar = 'a';
        
        for (int i = 0; i < length; i++) {
            stringBuilder.append(currentChar);
            currentChar++;

            if (currentChar > 'z') {
                currentChar = 'a';
            }
        }

        return stringBuilder.toString();
    }
}

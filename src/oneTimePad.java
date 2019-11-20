import java.util.Random;
import java.util.Scanner;
// Этот пример подсмотрел, есть вопрос.
public class oneTimePad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input text: ");
        String text = scanner.nextLine();//считываем текст с клавиатуры и присваиваем этот текст переменной String
        char[] achText = text.toCharArray();//преобразуем text в массив символов
        char[] achKey = new char[achText.length];//создаем массив для будущего ключа длиной равной основному(шифруемому) тексту
        char[] achResult = new char[achText.length];// массив для будущего зашифрованного текста
        Random random = new Random();

        for (int i = 0; i < achText.length; i++) {
            achKey[i] = (char) random.nextInt(Character.MAX_VALUE);// создание ключа, наполнение случайными символами. Евгений , объясните пожалуйста смысл параметра Character.MAX_VALUE. Смысл понятен интуитивно.
            achResult[i] = (char) (achText[i] ^ achKey[i]);// шифрование с использованием исключающего ИЛИ
        }

        System.out.println("Text: " + String.valueOf(achText));
        System.out.println("Key: " + String.valueOf(achKey));
        System.out.println("Result: " + String.valueOf(achResult));
//расшифровка
        char[] achDecrypt = new char[achText.length];
        for (int i = 0; i < achText.length; i++) {
            achDecrypt[i] = (char) (achResult[i] ^ achKey[i]);// Расшифровка также как и шифровка методом побитового XOR
        }

        System.out.println("Decrypt: " + String.valueOf(achDecrypt));
    }

}

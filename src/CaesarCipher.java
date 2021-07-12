import edu.duke.*;

public class CaesarCipher {

    public String encrypt(String input, Integer key){
        StringBuilder message = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);

        for (int i = 0; i < input.length(); i++){
            char currChar = message.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));

            if (idx != -1){

                char newChar = shiftedAlphabet.charAt(idx);

                if(Character.isUpperCase(currChar)){
                    message.setCharAt(i, newChar);
                }
                else{
                    message.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }

        return message.toString();
    }

    public String encryptTwoKeys(String input, Integer key1, Integer key2){
        StringBuilder message = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);

        for (int i = 0; i < input.length(); i++){
            char currChar = message.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));

            if (idx != -1){
                if ((i+1)%2 != 0){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    if (Character.isUpperCase(currChar)){
                        message.setCharAt(i, newChar);
                    }
                    else{
                        message.setCharAt(i, Character.toLowerCase(newChar));
                    }
                }
                else{
                    char newChar = shiftedAlphabet2.charAt(idx);
                    if (Character.isUpperCase(currChar)){
                        message.setCharAt(i, newChar);
                    }
                    else{
                        message.setCharAt(i, Character.toLowerCase(newChar));
                    }
                }
            }
        }
        return message.toString();
    }

    public void testCaesar(){
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));

    }

    public static void main(String[] args) {
        CaesarCipher CC = new CaesarCipher();
        CC.testCaesar();
    }
}

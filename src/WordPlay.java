import edu.duke.*;

public class WordPlay {


    public Boolean isVowel(Character ch){

        char temp = Character.toLowerCase(ch);

        if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){
            return true;
        }
        else{
            return false;
        }

    }

    public String replaceVowels(String phrase, Character ch){

        for (int i = 0; i < phrase.length(); i++){
            if(isVowel(phrase.charAt(i))){
                phrase = phrase.replace(phrase.charAt(i), ch);
            }
        }
        return phrase;
    }

    public String  emphasize(String phrase, Character ch){
        StringBuilder sb = new StringBuilder(phrase);
        ch = Character.toLowerCase(ch);
        int currInd = 1;

        for (int i = 0; i < sb.length(); i++){
            char temp = Character.toLowerCase(sb.charAt(i));
            if(temp == ch){
                if (currInd % 2 == 0){
                    sb.setCharAt(i, '+');
                }
                else{
                    sb.setCharAt(i, '*');
                }
            }
            currInd++;
        }

        return sb.toString();
    }

    public void tester(){
        //System.out.println(isVowel('x'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }

    public static void main(String[] args) {
        WordPlay wp = new WordPlay();
        wp.tester();
    }
}

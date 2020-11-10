package se.iths.annotation;


@FirstLetterToUppercase
public class MakeFirstLetterInLastNameToUppercase implements LastNameProcessor{

    public String processLastName(String text) {
        StringBuilder str = new StringBuilder();
        char[] chars = new char[text.length()];

        for (int i = 0; i <text.length() ; i++) {
            if (i<1){
                chars[i] = Character.toUpperCase(text.charAt(i));
            }else {
                chars[i]=Character.toLowerCase(text.charAt(i));
            }
        }

        for (char aChar : chars) {
                str.append(aChar);
        }
        return str.toString();
    }
}

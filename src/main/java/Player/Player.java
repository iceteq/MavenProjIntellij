package Player;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.plaf.basic.BasicIconFactory;

public class Player extends BasicCharacter {


    // patterns that names must follow
    public static final String THREE_CONSONANTS_IN_A_ROW = "[b-df-hj-np-tv-z]{3}";
    public static final String THREE_VOWELS_IN_A_ROW = "[AEIOUaeiou]{3}";
    public static final String AT_LEAST_ONE_CONSONANT = "[b-df-hj-np-tv-z]{1}";
    public static final String AT_LEAST_ONE_VOWEL = "[AEIOUaeiou]{1}";
    public static final String FIRST_LETTER_LOWER_CASE = "^[a-z].*";



    /**
     * A player has no profession, so this method
     * only sets level and updates the max hp
     * if it had been a knight for example, it should then also
     * update the healing ability.
     * @param level
     */
    @Override
    public void setLevelAndOtherStats(int level) {
        this.level = level;
        setMaxHealthWithRegardToLevel();
    }

    @Override
    public Object getName() {
        return this.name;
    }
    @Override
    public void setName(String name) {
        // checks what rules name breaks
        if (name == null){
            throw new NullPointerException("name can't be null");
        }
        if (name == ""){
            System.out.println("Error: please choose a name");
            return;
        }
        if  (matchesPattern(THREE_CONSONANTS_IN_A_ROW, name)){
            System.err.println("Error: 3 consonants in a row");
            return;
        }
        if (matchesPattern(THREE_VOWELS_IN_A_ROW, name)) {
            System.err.println("Error: 3 vowels in a row");
            return;
        }
        if (!matchesPattern(AT_LEAST_ONE_CONSONANT, name)) {
            System.err.println("Error: no consonant");
            return;
        }
        if (!matchesPattern(AT_LEAST_ONE_VOWEL, name)){
            System.err.println("Error: no vowel");
            return;
        }
        if (matchesPattern(FIRST_LETTER_LOWER_CASE, name)){
            System.err.println("Error: must have capital letter");
            return;
        }

        if (name.length() > 1 && name.length() < 11)
            this.name = name;
    }


    boolean matchesPattern(String pattern, String target){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(target);
        return m.find();
    }
    /**
     * Can be expanded to include things like HP, damage, weapon etc
     * @return
     */
    @Override
    public String toString() {
        return "Player{}";
    }
}

package Player;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.plaf.basic.BasicIconFactory;

public class Player extends BasicCharacter {


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

    /**
     * Can be expanded to include things like HP, damage, weapon etc
     * @return
     */
    @Override
    public String toString() {
        return "Player{}";
    }
}

package Player;

class Player extends BasicCharacter {

    @Override
    public String toString() {
        return "Player{}";
    }

    @Override
    public void setLevelAndOtherStats(int level) {
        this.level = level;
        setMaxHealthWithRegardToLevel();
    }


}

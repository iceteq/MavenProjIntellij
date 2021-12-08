package Player;


public class NPC extends BasicCharacter {
    public NPC(int health) {
        super();
    }

    public NPC() {
    }

    @Override
    public Object getName() {
        return null;
    }

    /**
     * toString is currently a placeholder. Can be extended to include real information about an NPC, like their HP
     * @return
     */
    @Override
    public String toString() {
        return "NPC{}";
    }


    @Override
    public void setName(String name) {

    }
}

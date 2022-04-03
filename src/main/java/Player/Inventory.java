package Player;

import equipment.Carriable;
import java.util.*;

/**
 * Inventory for "Carriable" items.
 * As it looks now, the interface Carriable is simply a way to categorize
 * items that are allowed in the inventory.
 * The interface itself is empty. But in the future, carriable items
 * could have additional characteristics declared in this interface that all carriables should have.
 *
 */
public class Inventory {

    private Carriable[] items;

    /**
     * Vad: Intierar en array med tom array av carriable.
     * @param slots
     */
    public Inventory(int slots) {
        if (slots >= 0) {
            items = new Carriable[slots];
        } else {
            throw new IllegalArgumentException("inventory must have at least one slot");
        }
    }

    /**
     * Vad: lägger till array av carriable items i inventory. Endast för testning.
     * @param items
     */
    Inventory(Carriable[] items) {
        if (items != null) {
            this.items = items;
        }
    }

    public Carriable[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    /**
     * Vad: Tillägg ska ske på första tomma platsen.
     *
     * Varför: Att fylla inventory ska helst inte ändra på positionen
     * av allt annat som ligger där. Smidigast är att då lägga till i slutet.
     *
     * Annat: Hade kunnat bara gå direkt till sista index, och lägga till där.
     * Problemet är att det finns en risk för att det blir tomma platser
     * mitt i allt då. (om andra delar av koden har råkat lämna tomma slots i mitten). Sedan
     * kan man kanske diskutera kostnaden för att iterera över listan bara för att göra
     * tillägg, men det är troligtvis inte ett problem med tanke på storleken av en inventory.
     *
     * @param item
     */
    public void add(Carriable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
    }

    /**
     * Vad: Borttag görs var som helst, och den tomma platsen måste
     * tas över av andra items.
     *
     * Hur: Allt som är framför det borttagna, kommer att behöva flyttas bakåt ett steg.
     *
     * Varför: Att lämna tomma platser gör att inventory snabbt blir rörigt.
     *
     * @param item
     */
    public void remove(Carriable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                items[i] = null;
                for (int j = i; j < (items.length - 1); j++) {
                    items[j] = items[j + 1];
                }
                items[items.length - 1] = null;
                return;
            }
        }
    }

    /**
     * What: reverse order of inventory contents.
     *
     * How: move items to new array, then replacing old with new
     *
     * Why: could be useful in the future, if the inventory gets sorting buttons.
     */
    void reverseOrder() {

        Carriable[] temp = new Carriable[items.length];

        int reverseIterator = items.length - 1;
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[reverseIterator--];

        }
        items = temp;
    }

    /**
     * Vad: Jag har redan skrivit add(Carriable item), som lägger till valt item i slutet.
     * Här kan tilllägg göras på utvald slot.
     *
     * Om slot är tom: bara att placera den på den tomma platsen.
     * Om slot är upptagen: då måste allting annat flyttas åt sidan (åt vänster eller höger).
     *
     * @param targetSlot
     * @param item
     */
    public void putItemInSlot(int targetSlot, Carriable item) {

        // 1. kontrollerar om det öht går att lägga till

        if (targetSlot > items.length || targetSlot < 0) {
            return;
        }
        if (item == null) {
            return;
        }
        if (!this.hasEmptySlot()) {
            return;
        }

        // 2. lägger till item i targetSlot, flyttar undan items om det behövs.

        if (this.getSlotItem(targetSlot) == null) {
            setItemOnSlot(targetSlot, item);
            return;
        } else if (hasEmptySlotAfter(targetSlot)) {
            moveItemsBackAStepFrom(targetSlot);
            setItemOnSlot(targetSlot, item);
        } else if (hasEmptySlotBefore(targetSlot)) {
            moveItemsForwardAStepFrom(targetSlot);
            setItemOnSlot(targetSlot, item);
        }
    }

    /**
     * Hjälpmetod, till för att ge plats när nya items läggs till på upptagen slot.
     * @param slot
     */
    void moveItemsBackAStepFrom(int slot) {

        for (int i = items.length - 1; i > slot; i--) {

            if (items[i] == null) {
                items[i] = items[i - 1];
                items[i - 1] = null;
            }

        }
    }

    /**
     * Hjälpmetod, till för att ge plats när nya items läggs till på upptagen slot.
     * @param slot
     */
    void moveItemsForwardAStepFrom(int slot) {

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                if (i < items.length - 1) {
                    items[i] = items[i + 1];

                    items[i + 1] = null;
                }

            }
        }
    }

    /**
     * Hjälpmetod - kan behövas vid tillägg av item som ännu inte finns i inventory,
     * då inventory kan vara full.
     * @return
     */
    boolean hasEmptySlot() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                return true;
            }
        }
        return false;
    }

    boolean hasEmptySlotAfter(int slot) {
        for (int i = slot; i < items.length; i++) {
            if (items[i] == null) {
                return true;
            }
        }
        return false;
    }

    boolean hasEmptySlotBefore(int slot) {
        for (int i = 0; i < slot; i++) {
            if (items[i] == null) {
                return true;
            }
        }
        return false;
    }

    int getItemSlot(Carriable item) {
        for (int i = 0; i < items.length; i++) {
            if (item.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    Carriable getSlotItem(int slot) {
        if (slot > items.length || slot < 0) {
            return null;
        } else {
            return items[slot];
        }
    }

    private void setItemOnSlot(int slot, Carriable item) {
        items[slot] = item;
    }

    /**
     * Vad: Flyttar ett redan lagrat item, till en annan plats, med minimal förändring
     * av existeriande ordning.
     *
     * Jag hade kunnat bara byta plats på source och destination.
     * Men detta ändrar på ordningen för mycket:
     *
     * Om inventory ser ut så här:
     * 1 - 2 - 3 - 4
     * Och jag flyttar 2an till slutet genom att byta plats (sämre)
     * 1 - 4 - 3 - 2
     * Eller om jag först flyttar bak 3an och 4an (bättre)
     * 1 - 3 - 4 - 2
     * @param src
     * @param dest
     */
    public void moveInventoryItemToOtherSpot(int src, int dest){

        Carriable item = items[src];

        if (item == null)
            return;

        items[src] = null; // needed for "moveItems..." methods below

        if (dest > src){
            moveItemsForwardAStepFrom(dest);
            setItemOnSlot(dest, item);
        } else if (src > dest){
            moveItemsBackAStepFrom(dest);
            setItemOnSlot(dest, item);
        }
    }

    boolean contains(Carriable item) {
        for (int i = 0; i < items.length; i++) {
            if (item.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}

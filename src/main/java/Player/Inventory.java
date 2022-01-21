package Player;

import equipment.Carriable;
import java.util.*;

/**
 * Here will be the items that a character can carry.
 */
public class Inventory {



    private Carriable[] items;

    public Inventory(int slots) {
        if (slots >= 0) {
            items = new Carriable[slots];
        } else {
            throw new IllegalArgumentException("inventory must have at least one slot");
        }
    }

    public Inventory(Carriable[] items) {
        if (items != null) {
            this.items = items;
        }
    }

    public Carriable[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    // implements iterable , iterera när det är tomt
    // max list length
    // add / remove
    public void add(Carriable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
    }

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
     * How: move items to new array, then replacing old with new
     * Why: ...
     */
    public void reverseOrder() {

        Carriable[] temp = new Carriable[items.length];

        int reverseIterator = items.length - 1;
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[reverseIterator--];

        }
        items = temp;
    }

    public void putItemInSlot(int targetSlot, Carriable item) {
        if (targetSlot > items.length || targetSlot < 0) {
            return;
        }
        if (item == null) {
            return;
        }
        if (!this.hasEmptySlot()) {
            return;
        }

        // 1. backward forward should prob be left right
        // 2. shouldnt be able to have empty slots to the left (might be some unnecessary code here)
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

    void moveItemsBackAStepFrom(int slot) {

        for (int i = items.length - 1; i > slot; i--) {

            if (items[i] == null) {
                items[i] = items[i - 1];
                items[i - 1] = null;
            }

        }
    }

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

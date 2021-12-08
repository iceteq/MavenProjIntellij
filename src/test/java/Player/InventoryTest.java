package Player;

import equipment.Armor;
import equipment.Carriable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    Inventory inventory;

    // to be put into inventory as needed
    Carriable fillItem1 = new Armor("fillItem1", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
    Carriable fillItem2 = new Armor("fillItem2", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
    Carriable fillItem3 = new Armor("fillItem3", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);

    @BeforeEach
    void setUp() {
        inventory = new Inventory(3);
    }

    @Test
    void slotsAreSetCorrectly() {
        assertEquals(inventory.getItems().length, 3);
    }

    @Test
    void negativeNumberOfSlots() {

        assertThrows(IllegalArgumentException.class, () -> {
            inventory = new Inventory(-1);
        });
    }

    @Test
    void makeRoomAtGivenSlotByMovingThingsBack() {
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, null});
        inventory.moveItemsBackAStepFrom(0);
        assertTrue(Arrays.equals(new Carriable[]{null, fillItem1, fillItem2}, inventory.getItems()), "tried to move items back");
    }

    @Test
    void makeRoomAtGivenSlotByMovingThingsForward() {
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, null});
        inventory.moveItemsForwardAStepFrom(2);
        assertTrue(Arrays.equals(new Carriable[]{fillItem1, fillItem2, null}, inventory.getItems()), "tried to move items back");
    }

    @Test
    void putItemInChosenSlotWhenThereIsFreeSpaceToTheRight(){
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, null});
        inventory.putItemInSlot(1, fillItem3);
        assertTrue(Arrays.equals(new Carriable[]{fillItem1, fillItem3, fillItem2}, inventory.getItems()));
    }

    @Test
    void putItemInChosenSlotWhenThereIsFreeSpaceToTheLeft(){
        inventory = new Inventory(new Carriable[]{null, fillItem1, fillItem2});
        inventory.putItemInSlot(2, fillItem3);
        assertTrue(Arrays.equals(new Carriable[]{fillItem1, fillItem2, fillItem3}, inventory.getItems()));
    }
    @Test
    void addItemWhenInventoryNotFull() {
        Carriable dummyitem = new Armor("dummyitem", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
        inventory.add(dummyitem);
        assertTrue(Arrays.asList(inventory.getItems()).contains(dummyitem));
    }
    @Test
    void addItemWhenInventoryFull() {
        Carriable dummyitem = new Armor("dummyitem", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        inventory.add(dummyitem);
        assertFalse(Arrays.asList(inventory.getItems()).contains(dummyitem));
    }

    @Test
    void settingZeroSlotsMeansArrayOfItemsIsEmpty() {
        inventory = new Inventory(0);
        assertArrayEquals(new Carriable[]{}, inventory.getItems());
    }

    @Test
    void doesInventoryHaveEmptySlot(){
        inventory = new Inventory(new Carriable[]{fillItem1, null, fillItem2});
        assertEquals(true, inventory.hasEmptySlot());
    }

    @Test
    void doesInventoryNotHaveEmptySlot(){
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        assertEquals(false, inventory.hasEmptySlot());
    }

    @Test
    void removingItemShouldMoveAllItemsForward() {
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        inventory.remove(fillItem2);
        System.out.println(Arrays.toString(inventory.getItems()));
        assertTrue(Arrays.equals(new Carriable[]{fillItem1, fillItem3, null}, inventory.getItems()));
    }

    /**
     * Checks to see if you can fill inventory with items, using array parameter instead of add method,
     */
    @Test
    void fillInventoryWithItems() {
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        assertTrue(Arrays.equals(new Carriable[]{fillItem1, fillItem2, fillItem3}, inventory.getItems()));
    }

    /**
     * Checks to see if you can fill inventory with items, using add method,
     */
    @Test
    void fillInventoryWithItemsUsingAddMethod() {
        inventory.add(fillItem3);
        inventory.add(fillItem2);
        inventory.add(fillItem1);
        assertTrue(Arrays.equals(new Carriable[]{fillItem3, fillItem2, fillItem1}, inventory.getItems()));
    }

    @Test
    void checkIfReversingOrderWorks(){
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        inventory.reverseOrder();
        Carriable expected[] = new Carriable[]{fillItem3, fillItem2, fillItem1};
        assertTrue(Arrays.equals(expected, inventory.getItems()), "\ninventory is \n" + Arrays.toString(inventory.getItems()) + "\n and expected is \n" + Arrays.toString(expected));
    }

    @Test
    void getItemSlot(){
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        assertEquals(1, inventory.getItemSlot(fillItem2));
    }

    @Test
    void containsItemTest(){
        inventory = new Inventory(new Carriable[]{fillItem1, fillItem2, fillItem3});
        assertEquals(true, inventory.contains(fillItem1));
        assertEquals(true, inventory.contains(fillItem2));
        assertEquals(true, inventory.contains(fillItem3));
    }


}
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
    Carriable item1 = new Armor("item1", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
    Carriable item2 = new Armor("item2", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
    Carriable item3 = new Armor("item3", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
    Carriable item4 = new Armor("item4", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);

    // to be used for comparisons.
    Carriable expected[];

    @BeforeEach
    void setUp() {
        inventory = new Inventory(3);
    }

    @Test
    void testInventoryHasThreeSlots() {
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
        inventory = new Inventory(new Carriable[]{item1, item2, null});
        inventory.moveItemsBackAStepFrom(0);
        assertTrue(Arrays.equals(new Carriable[]{null, item1, item2}, inventory.getItems()), "tried to move items back");
    }

    @Test
    void makeRoomAtGivenSlotByMovingThingsForward() {
        inventory = new Inventory(new Carriable[]{item1, item2, null});
        inventory.moveItemsForwardAStepFrom(2);
        assertTrue(Arrays.equals(new Carriable[]{item1, item2, null}, inventory.getItems()), "tried to move items back");
    }

    @Test
    void putItemInChosenSlotWhenThereIsFreeSpaceToTheRight(){
        inventory = new Inventory(new Carriable[]{item1, item2, null});
        inventory.putItemInSlot(1, item3);
        assertTrue(Arrays.equals(new Carriable[]{item1, item3, item2}, inventory.getItems()));
    }

    @Test
    void putItemInChosenSlotWhenThereIsFreeSpaceToTheLeft(){
        inventory = new Inventory(new Carriable[]{null, item1, item2});
        inventory.putItemInSlot(2, item3);
        assertTrue(Arrays.equals(new Carriable[]{item1, item2, item3}, inventory.getItems()));
    }
    @Test
    void addItemWhenInventoryNotFull() {
        Carriable item = new Armor("item", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
        inventory.add(item);
        assertTrue(Arrays.asList(inventory.getItems()).contains(item));
    }
    @Test
    void addItemWhenInventoryFull() {
        Carriable item = new Armor("item", Armor.ArmorType.CLOTH, Armor.ArmorPiece.CHEST);
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        inventory.add(item);
        assertFalse(Arrays.asList(inventory.getItems()).contains(item));
    }

    @Test
    void settingZeroSlotsMeansArrayOfItemsIsEmpty() {
        inventory = new Inventory(0);
        assertArrayEquals(new Carriable[]{}, inventory.getItems());
    }

    @Test
    void doesInventoryHaveEmptySlot(){
        inventory = new Inventory(new Carriable[]{item1, null, item2});
        assertEquals(true, inventory.hasEmptySlot());
    }

    @Test
    void doesInventoryNotHaveEmptySlot(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        assertEquals(false, inventory.hasEmptySlot());
    }

    @Test
    void removingItemShouldMoveItemsForward() {
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        inventory.remove(item2);
        System.out.println(Arrays.toString(inventory.getItems()));
        assertTrue(Arrays.equals(new Carriable[]{item1, item3, null}, inventory.getItems()));
    }

    /**
     * Checks to see if you can fill inventory with items, using array parameter instead of add method,
     */
    @Test
    void fillInventoryWithItems() {
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        assertTrue(Arrays.equals(new Carriable[]{item1, item2, item3}, inventory.getItems()));
    }

    /**
     * Checks to see if you can fill inventory with items, using add method,
     */
    @Test
    void fillInventoryWithItemsUsingAddMethod() {
        inventory.add(item3);
        inventory.add(item2);
        inventory.add(item1);
        assertTrue(Arrays.equals(new Carriable[]{item3, item2, item1}, inventory.getItems()));
    }

    @Test
    void checkIfReversingOrderWorks(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        inventory.reverseOrder();
        Carriable expected[] = new Carriable[]{item3, item2, item1};
        assertTrue(Arrays.equals(expected, inventory.getItems()), "\ninventory is \n" + Arrays.toString(inventory.getItems()) + "\n and expected is \n" + Arrays.toString(expected));
    }

    @Test
    void getItemSlot(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        assertEquals(1, inventory.getItemSlot(item2));
    }

    @Test
    void containsItemTest(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        assertEquals(true, inventory.contains(item1));
        assertEquals(true, inventory.contains(item2));
        assertEquals(true, inventory.contains(item3));
    }

    @Test
    void moveInventoryItemToOtherSpotTest(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        inventory.moveInventoryItemToOtherSpot(0, 2);
        expected = new Carriable[]{item2, item3, item1};
        assertTrue(Arrays.equals(expected, inventory.getItems()), "\ninventory is \n" + Arrays.toString(inventory.getItems()) + "\n and expected is \n" + Arrays.toString(expected));
    }

    @Test
    void moveInventoryItemToOtherSpotTest_moveToLeft(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        inventory.moveInventoryItemToOtherSpot(2, 0);
        expected = new Carriable[]{item3, item1, item2};
        assertTrue(Arrays.equals(expected, inventory.getItems()), "\ninventory is \n" + Arrays.toString(inventory.getItems()) + "\n and expected is \n" + Arrays.toString(expected));
    }
    
    @Test
    void toStringTest(){
        inventory = new Inventory(new Carriable[]{item1, item2, item3});
        assertEquals("[Equipment{name='item1'}, Equipment{name='item2'}, Equipment{name='item3'}]", Arrays.toString(inventory.items));
    }


}
package com.alexaitken.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {
    private Inventory createInventory(Item... items) {
        return new Inventory(items);
    }

    //P1
    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older() {
        Item agedBrie = new Item("Aged Brie", 10, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(26, agedBrie.getQuality());
    }
    //P1b
    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50() {
        Item agedBrie = new Item("Aged Brie", 10, 50);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    //P2
    @Test
    public void should_increase_the_quality_of_aged_brie_by_two_as_it_gets_older() {
        Item agedBrie = new Item("Aged Brie", -8, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(27, agedBrie.getQuality());
        assertEquals(-9, agedBrie.getSellIn());
    }

    //P2b
    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50_with_sellIn_passedby() {
        Item agedBrie = new Item("Aged Brie", -8, 50);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    //P2c
    @Test
    public void should_increase_the_quality_of_aged_brie_limit_value() {
        Item agedBrie = new Item("Aged Brie", -8, 49);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    //P2d
    @Test
    public void should_increase_the_quality_of_aged_brie_by_two_as_it_past_sellIn() {
        Item agedBrie = new Item("Aged Brie", 0, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(27, agedBrie.getQuality());
    }

    //p3
    @Test
    public void should_never_changes_quailty_of_Sulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        sulfuras.setName("Sulfuras, Hand of Ragnaros");
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(80, sulfuras.getQuality());
    }
    //P3
    @Test
    public void should_never_changes_sellIn_of_Sulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(0, sulfuras.getSellIn());
    }

    //P4
    @Test
    public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(21, backStagePass.getQuality());
    }

    //P5
    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 27);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(29, backStagePass.getQuality());
    }
    //P5d
    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_6_days() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(27, backStagePass.getQuality());
        assertEquals(5, backStagePass.getSellIn());
    }
    //P6
    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(28, backStagePass.getQuality());
        assertEquals(4, backStagePass.getSellIn());
    }
    //P6b
    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_over_50_with_limit_sellIn_5() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
        assertEquals(4, backStagePass.getSellIn());
    }
    //P6c
    @Test
    public void should_increase_backstage_passes_above_a_quality_of_50c() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
        assertEquals(4, backStagePass.getSellIn());
    }

    //P6d
    @Test
    public void should_increase_backstage_passes_above_a_quality_of_50d() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
        assertEquals(4, backStagePass.getSellIn());
    }

    //P6e
    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_28() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(28, backStagePass.getQuality());
        assertEquals(0, backStagePass.getSellIn());
    }

    //P6f
    @Test
    public void should_increase_backstage_passes_above_a_quality_of_50() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
        assertEquals(0, backStagePass.getSellIn());
    }

    //P6g
    @Test
    public void should_increase_backstage_passes_above_a_quality_of_49() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
        assertEquals(0, backStagePass.getSellIn());
    }

    //P6h
    @Test
    public void should_increase_backstage_passes_above_a_quality_of_48() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
        assertEquals(0, backStagePass.getSellIn());
    }

    //P7
    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_25() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(0, backStagePass.getQuality());
        assertEquals(-1, backStagePass.getSellIn());
    }

    //P8
    @Test
    public void sellin_negative_and_quality_stay_cero() {
        Item normalItem = new Item("Backstage passes", -8, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
        assertEquals(-9, normalItem.getSellIn());
    }

    //P9
    @Test
    public void should_lower_the_sellIn_by_one_for_normal_items() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(9, normalItem.getSellIn());
    }
    //P9
    @Test
    public void should_lower_the_quality_by_one_for_normal_items() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(19, normalItem.getQuality());
    }
    //P9b
    @Test
    public void should_not_lower_the_quality_below_zero() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }

    //P10
    @Test
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() {
        Item normalItem = new Item("+5 Dexterity Vest", -1, 25);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(23, normalItem.getQuality());
    }

    //P10b
    @Test
    public void sellIn_negative_and_quality_down_to_cero() {
        Item normalItem = new Item("+5 Dexterity Vest", -8, 1);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
        assertEquals(-9, normalItem.getSellIn());
    }

    //P10c
    @Test
    public void sellIn_negative_and_quality_cero() {
        Item normalItem = new Item("+5 Dexterity Vest", -8, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
        assertEquals(-9, normalItem.getSellIn());
    }

    //P10d
    @Test
    public void sellIn_cero_and_quality_down_2() {
        Item normalItem = new Item("+5 Dexterity Vest", 0, 25);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(23, normalItem.getQuality());
        assertEquals(-1, normalItem.getSellIn());
    }

    //DIFERENTE
    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(0, backStagePass.getQuality());
    }


    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_50() {
        Item backStagePassMoreThan10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);//p5b
        Item backStagePass10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);//p5c
        Item backStagePass5DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48); //p6d
        Inventory inventory = createInventory(backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway);
        inventory.updateQuality();
        assertEquals(50, backStagePassMoreThan10DaysAway.getQuality());
        assertEquals(50, backStagePass10DaysAway.getQuality());
        assertEquals(50, backStagePass5DaysAway.getQuality());
    }
}
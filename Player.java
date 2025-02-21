package com.example.mud.Player;

import com.example.mud.Room.Room;
import com.example.mud.Item.Item;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();
    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
    public void addItem(Item item) {
        inventory.add(item);
    }
    public String getInventoryDescription() {
        if (inventory.isEmpty()) {
            return "You are carrying nothing";
        }
        StringBuilder sb = new StringBuilder("You have: ");
        for (Item item : inventory) {
            sb.append(item.getName()).append(" ");
        }
        return sb.toString();
    }
}

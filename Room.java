package com.example.mud.Room;

import com.example.mud.Item.Item;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private String description;
    private Map<String, Room> exits = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();
    public Room(String description) {
        this.description = description;
    }
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }
    public Room getRoomInDirection(String direction) {
        return exits.get(direction);
    }
    public String describe() {
        return description + "Exits: " + exits.keySet();
    }
    public void addItem(Item item) {
        items.put(item.getName(), item);
    }
    public Item getItem(String name) {
        return items.get(name);
    }
    public void removeItem(Item item) {
        items.remove(item.getName());
    }
}

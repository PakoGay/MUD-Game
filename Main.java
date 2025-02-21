package com.example.mud.Main;

import com.example.mud.MUDController.MUDController;
import com.example.mud.Player.Player;
import com.example.mud.Room.Room;
import com.example.mud.Item.Item;

public class Main {
    public static void main(String[] args) {
        Room startRoom = new Room("You are in a dark cave");
        Room secondRoom = new Room("You are in a forest");
        startRoom.setExit("forward", secondRoom);
        secondRoom.setExit("back", startRoom);
        startRoom.addItem(new Item("sword"));
        secondRoom.addItem(new Item("shield"));
        Player player = new Player(startRoom);
        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}


package com.example.mud.MUDController;

import com.example.mud.Player.Player;
import com.example.mud.Room.Room;
import com.example.mud.Item.Item;

import java.util.Scanner;

public class MUDController {
    private final Player player;
    private boolean running;
    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }
    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the MUD game!");
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }
        System.out.println("Game over");
        scanner.close();
    }
    public void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = (parts.length > 1) ? parts[1] : "";
        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                pickUp(argument);
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command");
        }
    }
    private void lookAround() {
        System.out.println(player.getCurrentRoom().describe());
    }
    private void move(String direction) {
        Room nextRoom = player.getCurrentRoom().getRoomInDirection(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved " + direction);
            lookAround();
        } else {
            System.out.println("You cant go that way");
        }
    }
    private void pickUp(String itemName) {
        Room room = player.getCurrentRoom();
        Item item = room.getItem(itemName);
        if (item != null) {
            room.removeItem(item);
            player.addItem(item);
            System.out.println("You picked up " + itemName);
        } else {
            System.out.println("No item named " + itemName);
        }
    }
    private void checkInventory() {
        System.out.println(player.getInventoryDescription());
    }
    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("- look");
        System.out.println("- move (forward, back, left, right).");
        System.out.println("- pick <itemName>");
        System.out.println("- inventory");
        System.out.println("- help");
        System.out.println("- exit");
    }
}


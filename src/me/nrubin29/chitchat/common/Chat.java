package me.nrubin29.chitchat.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Chat {

    private final String name;
    private final ArrayList<AbstractUser> users;
    private final ArrayList<Message> messages;

    public Chat(String name, String... names) {
        this(name, ChatManager.getInstance().getUsers(names));
    }

    private Chat(String name, AbstractUser... users) {
        this.name = name;
        this.users = new ArrayList<AbstractUser>(Arrays.asList(users));
        this.messages = new ArrayList<Message>();
    }

    public String getName() {
        return name;
    }

    public AbstractUser[] getUsers() {
        return users.toArray(new AbstractUser[users.size()]);
    }

    public void addUser(AbstractUser user) {
        users.add(user);
    }

    public Message[] getMessages() {
        return messages.toArray(new Message[messages.size()]);
    }

    public void addMessage(String sender, String chat, String msg, Date when) {
        Message message = new Message(sender, chat, msg, when);
        messages.add(message);
    }
}
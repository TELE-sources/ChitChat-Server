package me.nrubin29.chitchat.server.packethandler;

import me.nrubin29.chitchat.common.Chat;
import me.nrubin29.chitchat.common.ChatManager;
import me.nrubin29.chitchat.common.packet.PacketChatCreate;
import me.nrubin29.chitchat.server.MySQL;

public class PacketChatCreateHandler extends PacketHandler<PacketChatCreate> {

    public PacketChatCreateHandler() {
        super(PacketChatCreate.class);
    }

    @Override
    public void handle(PacketChatCreate packet) {
        Chat chat = new Chat(packet.getChat(), packet.getUsers().split(","));
        ChatManager.getInstance().addChat(chat);
        MySQL.getInstance().saveChat(chat);
    }
}
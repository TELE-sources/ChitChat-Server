package me.nrubin29.chitchat.server.packethandler;

import me.nrubin29.chitchat.common.packet.Packet;

import java.util.ArrayList;

public class PacketHandlerManager {

    private static final PacketHandlerManager instance = new PacketHandlerManager();

    public static PacketHandlerManager getInstance() {
        return instance;
    }

    private final ArrayList<PacketHandler<?>> handlers = new ArrayList<PacketHandler<?>>();

    private PacketHandlerManager() {
        handlers.add(new PacketChatAddUserHandler());
        handlers.add(new PacketChatCreateHandler());
        handlers.add(new PacketChatRemoveUserHandler());
        handlers.add(new PacketMessageHandler());
        handlers.add(new PacketUserDisplayNameChangeHandler());
        handlers.add(new PacketUserPasswordChangeHandler());
        handlers.add(new PacketUserStatusChangeHandler());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T extends Packet> void handle(T packet) {
        for (PacketHandler handler : handlers) {
            if (handler.getPacketClass().equals(packet.getClass())) {
                handler.handle(packet);
            }
        }
    }
}
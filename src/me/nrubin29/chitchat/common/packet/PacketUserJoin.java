package me.nrubin29.chitchat.common.packet;

import me.nrubin29.chitchat.common.AbstractUser;

public class PacketUserJoin extends Packet {

    private static final long serialVersionUID = 3852290317461257132L;

    private String user;

    public PacketUserJoin(AbstractUser user) {
        this.user = user.getName() + ";" + user.getDisplayName();
    }

    public String getUser() {
        return user;
    }
}
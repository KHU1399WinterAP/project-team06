package main.java.socket;

import main.java.gui.Dashboard.ChetRoom.ChetRoom;

public class ChetSyncer extends Thread{
    private final ChetRoom CHET_ROOM;

    public ChetSyncer(ChetRoom chet_room) {
        this.CHET_ROOM = chet_room;
    }
    @Override
    public void run() {
        while (true) {
            String chet = ChetRoom.CLIENT.getResponse();

            if (chet.equals("EXIT"))
                return;

            CHET_ROOM.updateChet(chet);
        }
    }
}

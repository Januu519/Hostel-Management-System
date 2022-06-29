package lk.ijse.HostelManagementSystem.entity;

public class Room {

    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;

    public Room() {
    }

    public Room(String roomId, String roomType, String keyMoney, int qty) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", keyMoney='" + keyMoney + '\'' +
                ", qty=" + qty +
                '}';
    }
}

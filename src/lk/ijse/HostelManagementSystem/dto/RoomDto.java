package lk.ijse.HostelManagementSystem.dto;

public class RoomDto {
    private String roomId;
    private String roomType;
    private String keyMoney;
    private int qty;

    public RoomDto() {
    }

    public RoomDto(String roomId, String roomType, String keyMoney, int qty) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
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

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", keyMoney='" + keyMoney + '\'' +
                ", qty=" + qty +
                '}';
    }
}

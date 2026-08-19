package Model;

import Common.Constant;

public class Classroom implements Comparable<Classroom> {
    private String roomId, building;
    private int capacity;

    public Classroom(String roomId, String building, int capacity) {
        if(roomId.matches(Constant.REGROOMID) 
                && building.matches(Constant.REGBUILDING) 
                && capacity >= 1 && capacity <= 999)
        {
            this.roomId = roomId;
            this.building = building;
            this.capacity = capacity;
        }
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) throws Exception {
        if(roomId.matches(Constant.REGROOMID))
            this.roomId = roomId;
        else
            throw new Exception("err roomId must be not empty");
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        if(building.matches(Constant.REGBUILDING))
            this.building = building;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if(capacity >= 1 && capacity <= 999)
            this.capacity = capacity;
    }

    public Classroom() {
    }

    @Override
    public int compareTo(Classroom classroom) {
        if(capacity < classroom.capacity) return -1;
        else if(capacity == classroom.capacity) return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return String.format("%5s  %10s  %d\n", getRoomId(), 
                getBuilding(), getCapacity());
    }
}
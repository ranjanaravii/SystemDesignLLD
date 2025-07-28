package com.developer.LLD.RestaurantTableReservationSystem;

public class Reservation {
    private final String customerName;
    private int partySize;
    private double startTime; // e.g., 1.5 means 1:30 PM
    private double duration; // in hours
    private Table table; // null if waitlisted

    public Reservation(String customerName, int partySize, double startTime, double duration, Table table) {
        this.customerName = customerName;
        this.partySize = partySize;
        this.startTime = startTime;
        this.duration = duration;
        this.table = table;
    }

    public String getCustomerName() { return customerName; }
    public int getPartySize() { return partySize; }
    public void setPartySize(int partySize) { this.partySize = partySize; }
    public double getStartTime() { return startTime; }
    public void setStartTime(double startTime) { this.startTime = startTime; }
    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }
    public Table getTable() { return table; }
    public void setTable(Table table) { this.table = table; }

    public String getReservationId() {
        return customerName + "_" + startTime;
    }
}


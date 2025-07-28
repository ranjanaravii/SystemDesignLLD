package com.developer.LLD.RestaurantTableReservationSystem;

public class Table {
    private final int tableId;
    private final int size;

    public Table(int tableId, int size) {
        this.tableId = tableId;
        this.size = size;
    }
    
    public int getTableId() { return tableId; }
    public int getSize() { return size; }
}

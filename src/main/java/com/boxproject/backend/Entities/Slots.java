package com.boxproject.backend.Entities;

import jakarta.persistence.*;

@Entity
public class Slots {
    @Id
    @GeneratedValue
    private Integer slot_id;
    private String slot_time;
    private String slot_status_Available_Today;
    private String slot_status_Available_Tomorrow;

    public Integer getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(Integer slot_id) {
        this.slot_id = slot_id;
    }

    public String getSlot_time() {
        return slot_time;
    }

    public void setSlot_time(String slot_time) {
        this.slot_time = slot_time;
    }

    public String getSlot_status_Available_Today() {
        return slot_status_Available_Today;
    }

    public void setSlot_status_Available_Today(String slot_status_Available_Today) {
        this.slot_status_Available_Today = slot_status_Available_Today;
    }

    public String getSlot_status_Available_Tomorrow() {
        return slot_status_Available_Tomorrow;
    }

    public void setSlot_status_Available_Tomorrow(String slot_status_Available_Tomorrow) {
        this.slot_status_Available_Tomorrow = slot_status_Available_Tomorrow;
    }

}

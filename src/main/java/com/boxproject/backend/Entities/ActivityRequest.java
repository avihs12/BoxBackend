package com.boxproject.backend.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ActivityRequest {

    @NotBlank(message = "Please enter a valid Activity name")
    private String activity_name;
    @NotNull(message = "Please enter a valid City name")
    private String activity_city;
    @NotNull(message = "Please enter a valid address name")
    private String activity_address;
    @NotNull(message = "Please enter a valid State")
    private String activity_state;
    @Max(400)
    @Min(150)
    private Integer activity_price;
    @Max(5)
    @Min(1)
    private Integer activity_rating;
    @NotNull(message = "Please enter a valid OwnerName")
    private String activity_owner_name;
    @NotNull(message = "Please enter a valid Mobile Number")
    private long activity_ownwer_mobile;
    @NotNull(message = "Please enter a valid Owner address")
    private String activity_owner_address;
    private Set<Slots> slots;

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_city() {
        return activity_city;
    }

    public void setActivity_city(String activity_city) {
        this.activity_city = activity_city;
    }

    public String getActivity_address() {
        return activity_address;
    }

    public void setActivity_address(String activity_address) {
        this.activity_address = activity_address;
    }

    public String getActivity_state() {
        return activity_state;
    }

    public void setActivity_state(String activity_state) {
        this.activity_state = activity_state;
    }

    public Integer getActivity_price() {
        return activity_price;
    }

    public void setActivity_price(Integer activity_price) {
        this.activity_price = activity_price;
    }

    public Integer getActivity_rating() {
        return activity_rating;
    }

    public void setActivity_rating(Integer activity_rating) {
        this.activity_rating = activity_rating;
    }

    public String getActivity_owner_name() {
        return activity_owner_name;
    }

    public void setActivity_owner_name(String activity_owner_name) {
        this.activity_owner_name = activity_owner_name;
    }

    public long getActivity_ownwer_mobile() {
        return activity_ownwer_mobile;
    }

    public void setActivity_ownwer_mobile(long activity_ownwer_mobile) {
        this.activity_ownwer_mobile = activity_ownwer_mobile;
    }

    public String getActivity_owner_address() {
        return activity_owner_address;
    }

    public void setActivity_owner_address(String activity_owner_address) {
        this.activity_owner_address = activity_owner_address;
    }

    public Set<Slots> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slots> slots) {
        this.slots = slots;
    }
}

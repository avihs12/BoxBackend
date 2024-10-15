package com.boxproject.backend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor(staticName = "build") // Use Lombok's annotation to generate static build method
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue
    private Integer activity_id;
    private String activity_name;
    private String activity_city;
    private String activity_address;
    private String activity_state;
    private Integer activity_price;
    private Integer activity_rating;
    private String activity_owner_name;
    private long activity_ownwer_mobile;
    private String activity_owner_address;

    @OneToMany(targetEntity = Slots.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_slot", referencedColumnName = "activity_id")
    private Set<Slots> slots;

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

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

	public static Activity build(int i, String activity_name2, String activity_city2, String activity_address2,
			String activity_state2, Integer activity_price2, Integer activity_rating2, String activity_owner_name2,
			long activity_ownwer_mobile2, String activity_owner_address2, Set<Slots> slots2) {
		// TODO Auto-generated method stub
		return null;
	}
}
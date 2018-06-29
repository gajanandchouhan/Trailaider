package com.trailaider.app.data.model.userprofile;

import com.trailaider.app.data.model.trek.TrekResponseData;

import java.util.List;

/**
 * Created by gajanand on 28/1/18.
 */

public class UserProfileData {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone_no;
    private String dob;
    private String gender;
    private String user_image;
    private String city;
    private String pincode;
    private String unit;
    private String weight;
    private String height;
    private String total_friends;
    private String total_mutual_friends;
    List<FriendModel> friends;
    List<FriendModel> mutual_friends;
    List<FriendModel> pending_friends;
    private List<TrekResponseData> treks;
    private String is_request_sent;
    private String is_already_friend;
    private String total_pending_friends;

    public void setTreks(List<TrekResponseData> treks) {
        this.treks = treks;
    }

    public List<TrekResponseData> getTreks() {
        return treks;
    }

    public String getTotal_friends() {
        return total_friends;
    }

    public void setTotal_friends(String total_friends) {
        this.total_friends = total_friends;
    }

    public List<FriendModel> getPending_friends() {
        return pending_friends;
    }

    public void setPending_friends(List<FriendModel> pending_friends) {
        this.pending_friends = pending_friends;
    }

    public String getTotal_pending_friends() {
        return total_pending_friends;
    }

    public void setTotal_pending_friends(String total_pending_friends) {
        this.total_pending_friends = total_pending_friends;
    }

    public String getIs_request_sent() {
        return is_request_sent;
    }

    public void setIs_request_sent(String is_request_sent) {
        this.is_request_sent = is_request_sent;
    }

    public String getIs_already_friend() {
        return is_already_friend;
    }

    public void setIs_already_friend(String is_already_friend) {
        this.is_already_friend = is_already_friend;
    }

    public String getTotal_mutual_friends() {
        return total_mutual_friends;
    }

    public void setTotal_mutual_friends(String total_mutual_friends) {
        this.total_mutual_friends = total_mutual_friends;
    }

    public List<FriendModel> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendModel> friends) {
        this.friends = friends;
    }

    public List<FriendModel> getMutual_friends() {
        return mutual_friends;
    }

    public void setMutual_friends(List<FriendModel> mutual_friends) {
        this.mutual_friends = mutual_friends;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTotal_friend() {
        return total_friends;
    }

    public void setTotal_friend(String total_friend) {
        this.total_friends = total_friend;
    }
}

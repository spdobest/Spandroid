package spandroid.dev.room.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    boolean isChecked;
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "emailId")
    private String emailId;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "mobile_number")
    private String mobileNumber;
    @ColumnInfo(name = "address")
    private String address;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.
}

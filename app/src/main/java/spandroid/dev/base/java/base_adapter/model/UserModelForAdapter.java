package spandroid.dev.base.java.base_adapter.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by root on 5/22/18.
 */

public class UserModelForAdapter implements Parcelable {
    String name;
    String profileImage;
    String mobileNumber;

    public static Creator<UserModelForAdapter> getCREATOR() {
        return CREATOR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.profileImage);
        dest.writeString(this.mobileNumber);
    }

    public UserModelForAdapter(String name, String profileImage, String mobileNumber) {
        this.name = name;
        this.profileImage = profileImage;
        this.mobileNumber = mobileNumber;
    }

    public UserModelForAdapter() {
    }

    protected UserModelForAdapter(Parcel in) {
        this.name = in.readString();
        this.profileImage = in.readString();
        this.mobileNumber = in.readString();
    }

    public static final Parcelable.Creator<UserModelForAdapter> CREATOR = new Parcelable.Creator<UserModelForAdapter>() {
        @Override
        public UserModelForAdapter createFromParcel(Parcel source) {
            return new UserModelForAdapter(source);
        }

        @Override
        public UserModelForAdapter[] newArray(int size) {
            return new UserModelForAdapter[size];
        }
    };
}

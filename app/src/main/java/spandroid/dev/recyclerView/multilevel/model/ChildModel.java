package spandroid.dev.recyclerView.multilevel.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sibaprasad on 27/02/18.
 */

public class ChildModel implements Parcelable {
    public static final Creator<ChildModel> CREATOR = new Creator<ChildModel>() {
        @Override
        public ChildModel createFromParcel(Parcel source) {
            return new ChildModel(source);
        }

        @Override
        public ChildModel[] newArray(int size) {
            return new ChildModel[size];
        }
    };
    String title;
    boolean isChecked;
    int imageType;

    public ChildModel() {
    }

    protected ChildModel(Parcel in) {
        this.title = in.readString();
        this.isChecked = in.readByte() != 0;
        this.imageType = in.readInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getImageType() {
        return imageType;
    }

    public void setImageType(int imageType) {
        this.imageType = imageType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        dest.writeInt(this.imageType);
    }
}

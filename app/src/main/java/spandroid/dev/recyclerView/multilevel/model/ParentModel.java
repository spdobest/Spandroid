package spandroid.dev.recyclerView.multilevel.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by sibaprasad on 27/02/18.
 */

public class ParentModel implements Parcelable {
    public static final Creator<ParentModel> CREATOR = new Creator<ParentModel>() {
        @Override
        public ParentModel createFromParcel(Parcel source) {
            return new ParentModel(source);
        }

        @Override
        public ParentModel[] newArray(int size) {
            return new ParentModel[size];
        }
    };
    String title;
    List<ChildModel> listChild;
    boolean isChecked;

    public ParentModel() {
    }

    protected ParentModel(Parcel in) {
        this.title = in.readString();
        this.listChild = in.createTypedArrayList(ChildModel.CREATOR);
        this.isChecked = in.readByte() != 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildModel> getListChild() {
        return listChild;
    }

    public void setListChild(List<ChildModel> listChild) {
        this.listChild = listChild;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeTypedList(this.listChild);
        dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }
}

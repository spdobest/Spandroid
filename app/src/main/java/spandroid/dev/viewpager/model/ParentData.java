package spandroid.dev.viewpager.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by root on 1/12/18.
 */

public class ParentData implements Parcelable {

    public static final Creator<ParentData> CREATOR = new Creator<ParentData>() {
        @Override
        public ParentData createFromParcel(Parcel source) {
            return new ParentData(source);
        }

        @Override
        public ParentData[] newArray(int size) {
            return new ParentData[size];
        }
    };
    String title;
    List<ChildModel> mListChild;

    public ParentData() {
    }

    protected ParentData(Parcel in) {
        this.title = in.readString();
        this.mListChild = in.createTypedArrayList(ChildModel.CREATOR);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildModel> getmListChild() {
        return mListChild;
    }

    public void setmListChild(List<ChildModel> mListChild) {
        this.mListChild = mListChild;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeTypedList(this.mListChild);
    }
}

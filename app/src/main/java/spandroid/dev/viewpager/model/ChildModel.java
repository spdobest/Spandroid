package spandroid.dev.viewpager.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by root on 1/12/18.
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
    String tabTitle;
    List<String> childListData;

    public ChildModel() {
    }

    protected ChildModel(Parcel in) {
        this.tabTitle = in.readString();
        this.childListData = in.createStringArrayList();
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public List<String> getChildListData() {
        return childListData;
    }

    public void setChildListData(List<String> childListData) {
        this.childListData = childListData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tabTitle);
        dest.writeStringList(this.childListData);
    }
}

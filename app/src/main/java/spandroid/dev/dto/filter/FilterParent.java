package spandroid.dev.dto.filter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Venkatesh on 6/14/16.
 */
public class FilterParent implements Serializable {

    String id;
    String name;
    boolean isSelected;
    List<FilterChild> filterList;
    boolean isSingleCheck;

    // constructor with zero parameter
    public FilterParent() {
    }

    // constructor with parameter
    public FilterParent(String _id, String name, List<FilterChild> filterList, boolean _isChecked, boolean _isSingleCheck) {
        this.name = name;
        this.filterList = filterList;
        this.id = _id;
        this.isSelected = _isChecked;
        this.isSingleCheck = _isSingleCheck;
    }

    public FilterParent(String id, String name, String esFilterName, List<FilterChild> filterList, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.filterList = filterList;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilterChild> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FilterChild> filterList) {
        this.filterList = filterList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean checked) {
        isSelected = checked;
    }

    public boolean isSingleCheck() {
        return isSingleCheck;
    }

    public void setSingleCheck(boolean checked) {
        isSingleCheck = checked;
    }

}

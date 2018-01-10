package spandroid.dev.dto.filter;

import java.io.Serializable;

/**
 * Created by Venkatesh on 6/14/16.
 */
public class FilterChild implements Serializable {

    int id;
    String name;
    boolean isChecked;
    String content;

    public FilterChild(int id, String name, boolean isChecked, String cont) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
        this.content = cont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void switchingIsChecked() {
        if (isChecked()) {
            setChecked(false);
        } else {
            setChecked(true);
        }
    }
}


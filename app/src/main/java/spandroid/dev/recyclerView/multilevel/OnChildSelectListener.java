package spandroid.dev.recyclerView.multilevel;

import spandroid.dev.recyclerView.multilevel.model.ChildModel;

/**
 * Created by sibaprasad on 27/02/18.
 */

public interface OnChildSelectListener {
    void onChildSelect(int position, ChildModel childModel, int parentPosition);
}

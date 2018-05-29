package spandroid.dev.base.java.base_adapter;

import android.content.Context;
import android.view.ViewGroup;

import spandroid.dev.R;
import spandroid.dev.base.java.base_adapter.listeners.OnRecyclerObjectClickListener;
import spandroid.dev.base.java.base_adapter.model.UserModelForAdapter;
import spandroid.dev.base.java.base_adapter.viewholder.UserViewHolder;

public class UsersAdapter extends GenericRecyclerAdapter<UserModelForAdapter, OnRecyclerObjectClickListener<UserModelForAdapter>, UserViewHolder> {

//    https://homepages.cae.wisc.edu/~ece533/images/

    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    public UsersAdapter(Context context) {
        super(context);
    }

    /**
     * To be implemented in as specific adapter
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflate(R.layout.itemview_user_adapter, parent));
    }
}
package spandroid.dev.base.java.base_adapter.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import spandroid.dev.R;
import spandroid.dev.base.java.base_adapter.listeners.OnRecyclerObjectClickListener;
import spandroid.dev.base.java.base_adapter.model.UserModelForAdapter;

public class UserViewHolder extends BaseViewHolder<UserModelForAdapter, OnRecyclerObjectClickListener<UserModelForAdapter>> {

    private TextView name;
    private ImageView avatar;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tvUserName);
        avatar = itemView.findViewById(R.id.imageProfileImage);
    }

    /**
     * Bind data to the item and set listener if needed.
     *
     * @param item     object, associated with the item.
     * @param listener listener a listener {@link BaseRecyclerListener} which has to b set at the item (if not `null`).
     */
    @Override
    public void onBind(final UserModelForAdapter item, final @Nullable OnRecyclerObjectClickListener<UserModelForAdapter> listener) {
        // set all data
        name.setText(item.getName());

        Glide.with(itemView.getContext())
                .load(item.getProfileImage())
                //.centerCrop()
                //.crossFade()
                .into(avatar);
        // set listener if needed
        // you can set it at any of the views instead of whole itemView if you wish
        if (listener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(item);
                }
            });
        }
    }
}
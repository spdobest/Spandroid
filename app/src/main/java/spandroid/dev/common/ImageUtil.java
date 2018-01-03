/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.common;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class ImageUtil {

   /* public static Drawable changeTintColor(Context ctx, Drawable icon, int color) {
        icon.setColorFilter(ContextCompat.getColor(ctx, color), PorterDuff.Mode.SRC_ATOP);
        return icon;
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {
        BadgeDrawable badge; // Reuse drawable if possible
        Drawable      reuse = icon.findDrawableByLayerId( R.id.intent_data_id); //getting the layer 2
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }
        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.main_content, badge);
    }*/
}

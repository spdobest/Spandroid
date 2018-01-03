package spandroid.dev.common;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class ShareUtil {

   public static void shareDetail(Context ctx/*, ProductDetailWrapper productDetail*/) {

        String shareData = "Check out " + /*productDetail.productName*/"" + " on Craftsvilla" + "\n"
                + "http://www.craftsvilla.com/catalog/product/view/id/"
                + /*productDetail.productId*/"" + "/s/" + ""/*productDetail.productName*/ + "/";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, ""/*productDetail.productName*/);
        share.putExtra(Intent.EXTRA_TEXT, shareData);
        ctx.startActivity(Intent.createChooser(share, "Share Via"));
    }
}

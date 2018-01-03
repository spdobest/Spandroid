package spandroid.dev.utils;

import android.text.TextUtils;

import com.angelbroking.financialplanning.AppContext;
import com.angelbroking.financialplanning.R;

/**
 * Created by root on 12/12/17.
 */

public class ValidationUtils {

    public static String validatePassword(String newPassword, String confirmPassword, String userId, String oldPassword) {
        String message = "";

        if (newPassword != null && newPassword.trim().length() > 0) {

            if (userId.equalsIgnoreCase(newPassword) == false) {

                // TODO: 10/5/17 This validation is removed because special character filter is applied to both password fields
                if (ApplicationUtils.isValidPasswordAllowed(newPassword)) {

                    if (TextUtils.isEmpty(confirmPassword) == false) {

                        if (TextUtils.isEmpty(oldPassword) == false && oldPassword.equalsIgnoreCase(newPassword) == false) {

                            if (newPassword.trim().equalsIgnoreCase(confirmPassword.trim())) {
                                message = "";
                            } else {
                                message = AppContext.getInstance().getResources().getString(R.string.error_input_password_mismatch);
                            }
                        } else {
                            message = AppContext.getInstance().getResources().getString(R.string.error_input_password_same_as_old);
                        }
                    } else {
                        message = AppContext.getInstance().getResources().getString(R.string.error_input_confirm_password);
                    }
                } else {
                    message = AppContext.getInstance().getResources().getString(R.string.error_input_password_rule);
                }
            } else {
                message = AppContext.getInstance().getResources().getString(R.string.error_input_password_match_client_Id);
            }
        } else {
            message = AppContext.getInstance().getResources().getString(R.string.error_input_new_password);
        }
        return message;
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}

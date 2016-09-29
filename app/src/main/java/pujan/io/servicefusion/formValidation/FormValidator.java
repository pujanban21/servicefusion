package pujan.io.servicefusion.formValidation;

import android.app.Activity;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pujan on 9/29/2016.
 */
public class FormValidator {
    private static String TAG = "FormValidator";

    private static String EMAIL_VALIDATOR = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static int PASSWORD_VALIDATOR = 6;
    private String mEmail;
    private String mPassword;
    private Activity mActivity;
    private boolean mNotify = false;

    public FormValidator(Activity activity){
        mActivity = activity;
    }

    public boolean validateForm(String email, String password){
        mEmail = email;
        mPassword = password;

        Pattern pattern = Pattern.compile(EMAIL_VALIDATOR, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mEmail);

        if (!matcher.matches() || mEmail.length()<=0) {
            Toast.makeText(mActivity, "Invalid Email", Toast.LENGTH_SHORT).show();
        }else if (mPassword.length() < PASSWORD_VALIDATOR) {
            Toast.makeText(mActivity, "Password length must be greater than 5 characters",
                    Toast.LENGTH_SHORT).show();
        }else {
            mNotify = true;
        }
        return mNotify;
    }

}

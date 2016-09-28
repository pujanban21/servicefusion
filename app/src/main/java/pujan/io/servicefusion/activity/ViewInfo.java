package pujan.io.servicefusion.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import pujan.io.servicefusion.R;
import pujan.io.servicefusion.components.RobotCondensedBold;
import pujan.io.servicefusion.components.RobotoCondensedRegular;
import pujan.io.servicefusion.models.UserInfo;

/**
 * Created by pujan on 9/27/2016.
 */
public class ViewInfo extends Activity {
    private static String TAG = "ViewInfo";

    private RobotCondensedBold addNewUser;
    private RobotoCondensedRegular viewFirstName;
    private RobotoCondensedRegular viewLastName;
    private RobotoCondensedRegular viewDateOfBirth;
    private RobotoCondensedRegular viewZipCode;
    private RobotoCondensedRegular viewEmail;

    private UserInfo mUserInfo;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_info);
        mUserInfo = UserInfo.getInstance();
        viewFirstName = (RobotoCondensedRegular) findViewById(R.id.view_first_name_fill);
        viewLastName = (RobotoCondensedRegular) findViewById(R.id.view_last_name_fill);
        viewDateOfBirth = (RobotoCondensedRegular) findViewById(R.id.view_date_of_birth_fill);
        viewZipCode = (RobotoCondensedRegular) findViewById(R.id.view_zip_code_fill);
        viewEmail = (RobotoCondensedRegular) findViewById(R.id.view_email_fill);

        viewFirstName.setText(mUserInfo.getFirstName());
        viewLastName.setText(mUserInfo.getLastName());
        viewDateOfBirth.setText(mUserInfo.getDateOfBirth());
        viewZipCode.setText(String.valueOf(mUserInfo.getZipCode()));
        viewEmail.setText(mUserInfo.getEmail());

        addNewUser = (RobotCondensedBold) findViewById(R.id.add_new_user);
        addNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
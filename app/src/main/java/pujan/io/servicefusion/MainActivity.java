package pujan.io.servicefusion;

import android.content.DialogInterface;
import android.graphics.Point;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import pujan.io.servicefusion.authManager.AuthManager;
import pujan.io.servicefusion.interfaces.AuthCallBacks;
import pujan.io.servicefusion.models.UserInfo;
import pujan.io.servicefusion.utility.FirebaseUtility;

public class MainActivity extends AppCompatActivity implements AuthCallBacks {
    private static final String TAG ="MainActivity";

    private String mEmail;
    private String mPassword;
    private String mFirstName;
    private String mLastName;
    private int mZipCode;
    private String mDateOfBirth;
    private String mUID;

    private EditText mEmailText;
    private EditText mPasswordText;
    private EditText mFirstNameText;
    private EditText mLastNameText;
    private EditText mZipCodeText;
    private EditText mDateOfBirthText;
    private TextView mSave;

    private UserInfo mUserInfo;
    private AuthCallBacks mAuthCallBacks;
    private AuthManager mAuthManager;
    private FirebaseUtility mFirebaseUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mAuthManager = new AuthManager(this);
        mAuthManager.SetCallBackAuth(this);

        mEmailText = (EditText) findViewById(R.id.email_fill);
        mPasswordText =(EditText) findViewById(R.id.password_fill);
        mFirstNameText = (EditText) findViewById(R.id.first_name_fill);
        mLastNameText = (EditText) findViewById(R.id.last_name_fill);
        mZipCodeText = (EditText) findViewById(R.id.zip_code_fill);
        mDateOfBirthText = (EditText) findViewById(R.id.date_of_birth_fill);
        mSave = (TextView) findViewById(R.id.save_button);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmail = mEmailText.getText().toString();
                mPassword = mPasswordText.getText().toString();
                mFirstName = mFirstNameText.getText().toString();
                mLastName = mLastNameText.getText().toString();
                mZipCode = Integer.valueOf(mZipCodeText.getText().toString());
                mDateOfBirth = mDateOfBirthText.getText().toString();
                Log.d(TAG,mEmail + " " + mPassword);
                mAuthManager.createUser(mEmail,mPassword);
            }
        });


    }

    @Override
    public void onAuth() {
        mFirebaseUtility = new FirebaseUtility();
        mUID = mFirebaseUtility.getUID();
        Log.d(TAG, mUID);
        mUserInfo = new UserInfo(mFirstName, mLastName,mDateOfBirth,
                mZipCode, mEmail,mUID);
        mFirebaseUtility.currentUserRef().updateChildren(mUserInfo.storeInfo());
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}

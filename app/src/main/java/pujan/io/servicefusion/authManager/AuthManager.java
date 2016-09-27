package pujan.io.servicefusion.authManager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import pujan.io.servicefusion.interfaces.AuthCallBacks;

/**
 * Created by pujan on 9/26/2016.
 */
public class AuthManager{
    private static final String TAG = "AuthManager";

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private OnCompleteListener<AuthResult> authResultOnCompleteListener;
    private FirebaseAuth mAuth;
    private Activity mActivity;

    private AuthCallBacks mAuthCallBacks;

    public AuthManager(Activity activity){
        mAuth = FirebaseAuth.getInstance();
        mActivity = activity;
        mAuthCallBacks = new AuthCallBacks() {
            @Override
            public void onAuth() {
                //Do nothing
            }

            @Override
            public void onError() {
                //Do nothing
            }
        };
    }
    public void SetCallBackAuth(AuthCallBacks authCallBacks){
        mAuthCallBacks = authCallBacks;
    }

    public void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //TODO, show user info
                    mAuthCallBacks.onAuth();

                } else{
                    Toast.makeText(mActivity, "Sign up Failed",Toast.LENGTH_SHORT).show();
                    mAuthCallBacks.onError();
                }
            }
        });
    }

    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //TODO, show user info
                    mAuthCallBacks.onAuth();
                } else{
                    Toast.makeText(mActivity, "Invalid Email or Password",
                            Toast.LENGTH_SHORT).show();
                    mAuthCallBacks.onError();
                }
            }
        });
    }
}

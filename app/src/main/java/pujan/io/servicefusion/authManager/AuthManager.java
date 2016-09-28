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

    /**
     *
     * @param authCallBacks
     */
    public void setCallBackAuth(AuthCallBacks authCallBacks){
        mAuthCallBacks = authCallBacks;
    }

    /**
     *
     * @param email
     * @param password
     */
    public void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    mAuthCallBacks.onAuth();
                } else{
                    mAuthCallBacks.onError();
                }
            }
        });
    }

    /**
     *
     * @param email
     * @param password
    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(mActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    mAuthCallBacks.onAuth();
                } else{
                    mAuthCallBacks.onError();
                }
            }
        });
    }
    */
}

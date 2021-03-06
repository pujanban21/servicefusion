package pujan.io.servicefusion.utility;

import android.util.Log;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by pujan on 9/26/2016.
 */
public class FirebaseUtility{
    private static final String TAG = "FirebaseUtility";

    private String mUID;

    private Firebase mRef;
    public FirebaseUtility(){
        mRef =  new Firebase("https://servicefusion-ff8a0.firebaseio.com/");
    }

    //Get reference of the firebase root node
    private Firebase getRef(){
        return mRef;
    }

    public Firebase userRef(){
        return getRef().child("users");
    }

    //Store the current user information under the UID of the current user
    public Firebase currentUserRef(){
        mUID = getUID();
        return userRef().child(mUID);
    }

    //Get the UID of the user generated by firebase upon email/password authentication
    public String getUID(){
        try {
            return FirebaseAuth.getInstance().getCurrentUser().getUid();
        }
        catch(Exception e){
            Log.e(TAG, e.toString());
            return null;
        }
    }
}

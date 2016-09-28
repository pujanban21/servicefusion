package pujan.io.servicefusion.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pujan on 9/26/2016.
 */
public class UserInfo {
    private static final String TAG = "UserInfo";
    private String mFirstName;
    private String mLastName;
    private String mDateOfBirth;
    private String mZipCode;
    private String mEmail;

    private static UserInfo instance = null;
    //Default Constructor
    private UserInfo(){}

    //Lazy Singleton pattern
    public static UserInfo getInstance(){
        if(instance == null){
            instance = new UserInfo();
        }
        return instance;
    }

    /*
    public UserInfo(String firstName ,String lastName, String dateOfBirth, int zipCode, String email, String uID){
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mDateOfBirth = dateOfBirth;
        this.mZipCode = zipCode;
        this.mEmail = email;
    }*/

    //Hash Map to store the information into firebase
    public Map<String, Object> storeInfo(){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("FirstName", getFirstName());
        userInfo.put("LastName", getLastName());
        userInfo.put("DateOfBirth", getDateOfBirth());
        userInfo.put("ZipCode", getZipCode());
        userInfo.put("Email", getEmail());

        return userInfo;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getFirstName(){return mFirstName;}

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String mDateOfBirth) {
        this.mDateOfBirth = mDateOfBirth;
    }

    public String  getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String mZipCode) {
        this.mZipCode = mZipCode;
    }

}

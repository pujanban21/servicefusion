package pujan.io.servicefusion.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pujan on 9/23/2016.
 */
public class UserInfo {
    private static final String TAG = "UserInfo";
    private String mFirstName;
    private String mLastName;
    private String mDateOfBirth;
    private int mZipCode;
    private String mEmail;

    //Default Constructor
    public UserInfo(){

    }
    public UserInfo(String firstName ,String lastName, String dateOfBirth, int zipCode, String email, String uID){
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mDateOfBirth = dateOfBirth;
        this.mZipCode = zipCode;
        this.mEmail = email;
    }

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

    public int getZipCode() {
        return mZipCode;
    }

    public void setZipCode(int mZipCode) {
        this.mZipCode = mZipCode;
    }

}

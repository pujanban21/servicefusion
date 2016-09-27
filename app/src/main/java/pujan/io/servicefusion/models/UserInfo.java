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

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    private String mUID;


    public UserInfo(String firstName ,String lastName, String dateOfBirth, int zipCode, String email, String uID){
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mDateOfBirth = dateOfBirth;
        this.mZipCode = zipCode;
        this.mEmail = email;
        this.mUID = uID;
    }

    public Map<String, Object> storeInfo(){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("FirstName", getmFirstName());
        userInfo.put("LastName", getmLastName());
        userInfo.put("DateOfBirth", getmDateOfBirth());
        userInfo.put("ZipCode", getmZipCode());
        userInfo.put("Email", getmEmail());

        return userInfo;
    }

    public String getmFirstName(){return mFirstName;}

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmDateOfBirth() {
        return mDateOfBirth;
    }

    public void setmDateOfBirth(String mDateOfBirth) {
        this.mDateOfBirth = mDateOfBirth;
    }

    public int getmZipCode() {
        return mZipCode;
    }

    public void setmZipCode(int mZipCode) {
        this.mZipCode = mZipCode;
    }

}

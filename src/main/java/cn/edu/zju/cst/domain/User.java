package cn.edu.zju.cst.domain;

/**
 * Created by DEAN on 2017/10/26.
 */
public class User {
    private int id;
    private String userAccount;
    private String userPassword;
    private String userIdentity;
    private String userPhone;
    private String userEmail;
    private String userType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (userAccount != null ? !userAccount.equals(user.userAccount) : user.userAccount != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userIdentity != null ? !userIdentity.equals(user.userIdentity) : user.userIdentity != null) return false;
        if (userPhone != null ? !userPhone.equals(user.userPhone) : user.userPhone != null) return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        return userType != null ? userType.equals(user.userType) : user.userType == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userIdentity != null ? userIdentity.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}

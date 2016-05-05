package matt.com.soundrolling.WebApi.models.login.sign_up;

/**
 * Created by prateekarora on 05/05/16.
 */
public class SignUpParams {
    String email;
    String f_name;
    String l_name;
    String country;
    String password;
    String signup_type;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignup_type() {
        return signup_type;
    }

    public void setSignup_type(String signup_type) {
        this.signup_type = signup_type;
    }
}

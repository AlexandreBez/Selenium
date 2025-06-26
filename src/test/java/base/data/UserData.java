package base.data;

/**
 * 	User data class for easy and quick maintains as well for better code legibility
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0
 */
public class UserData {
	
    /** 
     * Variable for all the properties of the user Object
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
     */
    public String userID, password, firstName, lastName, email, phone, address1, address2, city, state, zip, country;

    /**
     * Instantiates a new user data object
     * @param userID the user ID
     * @param password the password
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email
     * @param phone the phone
     * @param address1 the address 1
     * @param address2 the address 2
     * @param city the city
     * @param state the state
     * @param zip the zip
     * @param country the country
	 * @author Lucas Alexandre Bez Piancoski
	 * @since 1.0
     */
    public UserData( String userID, String password, String firstName, String lastName, String email, String phone, String address1, String address2, String city, String state, String zip, String country) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}

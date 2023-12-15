public class Contact {
    private final String contactID; // Unique ID, non-updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with validation as per requirements
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Check contactID is not null, not empty, and less than or equal to 10 characters
        if (contactID == null || contactID.isEmpty() || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        // Similar validation for firstName, lastName, and address with their respective limits
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        // Phone number must be exactly 10 digits
        if (phone == null || phone.isEmpty() || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address is too long");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters for all fields
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for fields except contactID, as it is non-updatable
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty() || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Address is too long");
        }
        this.address = address;
    }
}

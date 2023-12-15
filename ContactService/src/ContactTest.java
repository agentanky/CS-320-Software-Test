import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdCannotBeNull() {
        new Contact(null, "Ankur", "Tandan", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdCannotBeLongerThan10Characters() {
        new Contact("0123456789A", "Ankur", "Tandan", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameCannotBeNull() {
        new Contact("0123456789", null, "Tandan", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameCannotBeLongerThan10Characters() {
        new Contact("0123456789", "AnkurAnkurTand", "Tandan", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameCannotBeNull() {
        new Contact("0123456789", "Ankur", null, "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameCannotBeLongerThan10Characters() {
        new Contact("0123456789", "Ankur", "TandanTandan", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneCannotBeNull() {
        new Contact("0123456789", "Ankur", "Tandan", null, "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneMustBe10Digits() {
        new Contact("0123456789", "Ankur", "Tandan", "123456789", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneMustBeNumeric() {
        new Contact("0123456789", "Ankur", "Tandan", "123456789A", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressCannotBeNull() {
        new Contact("0123456789", "Ankur", "Tandan", "1234567890", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressCannotBeLongerThan30Characters() {
        new Contact("0123456789", "Ankur", "Tandan", "1234567890", "123 Main Street, Apt 101, Springfield");
    }

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("0123456789", "Ankur", "Tandan", "1234567890", "123 Main St");
        assertEquals("0123456789", contact.getContactID());
        assertEquals("Ankur", contact.getFirstName());
        assertEquals("Tandan", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
}

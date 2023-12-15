import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact contactAnkur;
    private Contact contactMichael;

    @Before
    public void setUp() {
        service = new ContactService();
        contactAnkur = new Contact("A123456789", "Ankur", "Tandan", "1234567890", "123 Main St");
        contactMichael = new Contact("M123456789", "Michael", "Jordan", "0987654321", "456 Elm St");
    }

    @Test
    public void testAddContact() {
        service.addContact(contactAnkur);
        assertEquals(contactAnkur, service.getContact(contactAnkur.getContactID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactWithDuplicateId() {
        service.addContact(contactAnkur);
        // Attempting to add another contact with the same ID should throw an exception
        service.addContact(new Contact("A123456789", "Michael", "Jordan", "0987654321", "456 Elm St"));
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contactMichael);
        service.deleteContact(contactMichael.getContactID());
        assertNull(service.getContact(contactMichael.getContactID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentContact() {
        // Attempting to delete a non-existent contact should throw an exception
        service.deleteContact("nonexistent");
    }

    @Test
    public void testUpdateContact() {
        service.addContact(contactAnkur);
        String newFirstName = "Mike";
        String newLastName = "Jordan";
        String newPhone = "0987654321";
        String newAddress = "456 Elm St";
        service.updateContact(contactAnkur.getContactID(), newFirstName, newLastName, newPhone, newAddress);
        
        Contact updatedContact = service.getContact(contactAnkur.getContactID());
        assertNotNull(updatedContact);
        assertEquals(newFirstName, updatedContact.getFirstName());
        assertEquals(newLastName, updatedContact.getLastName());
        assertEquals(newPhone, updatedContact.getPhone());
        assertEquals(newAddress, updatedContact.getAddress());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentContact() {
        // Attempting to update a non-existent contact should throw an exception
        service.updateContact("nonexistent", "Mike", "Jordan", "0987654321", "456 Elm St");
    }
}

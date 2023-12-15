import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact to the service
    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists or is null");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Deletes a contact from the service by ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contacts.remove(contactID);
    }

    // Updates a contact's fields by ID
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contactToUpdate = contacts.get(contactID);
        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        if (firstName != null && !firstName.isEmpty()) {
            contactToUpdate.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            contactToUpdate.setLastName(lastName);
        }
        if (phone != null && !phone.isEmpty()) {
            contactToUpdate.setPhone(phone);
        }
        if (address != null && !address.isEmpty()) {
            contactToUpdate.setAddress(address);
        }
    }
    
    // Getter to retrieve contact by ID, useful for testing
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}

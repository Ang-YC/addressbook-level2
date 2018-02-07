package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "13, Computing Drive, COM1-02-06, 117417";
    private static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    private static final String SEPARATOR = ",";

    private static final int PARTS_COUNT = 4;
    private static final int PART_BLOCK      = 0;
    private static final int PART_STREET     = 1;
    private static final int PART_UNIT       = 2;
    private static final int PART_POSTALCODE = 3;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        // Split into different parts of address
        String[] addressParts = trimmedAddress.split(SEPARATOR);
        block  = new Block(addressParts[PART_BLOCK].trim());
        street = new Street(addressParts[PART_STREET].trim());
        unit   = new Unit(addressParts[PART_UNIT].trim());
        postalCode = new PostalCode(addressParts[PART_POSTALCODE].trim());
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    private static boolean isValidAddress(String test) {
        String[] addressParts = test.split(SEPARATOR);
        return (addressParts.length == PARTS_COUNT);
    }

    public String getValue() {
        return this.toString();
    }

    @Override
    public String toString() {
        String[] addressParts = new String[PARTS_COUNT];
        addressParts[PART_BLOCK] = this.block.getBlock();
        addressParts[PART_STREET] = this.street.getStreet();
        addressParts[PART_UNIT] = this.unit.getUnit();
        addressParts[PART_POSTALCODE] = this.postalCode.getPostalCode();
        return String.join(SEPARATOR + " ", addressParts);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(other.toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

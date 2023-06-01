package U2W1D4THEORYJPA.exception;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException(int id) {
		super("Item with id" + id + "not found");
	}

	public ItemNotFoundException(String name) {
		super("Item with name" + name + "not found");
	}
}

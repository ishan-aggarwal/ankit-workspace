package abhimanyu;

@FunctionalInterface
public interface Password {
	abstract boolean isValid(String password);
}
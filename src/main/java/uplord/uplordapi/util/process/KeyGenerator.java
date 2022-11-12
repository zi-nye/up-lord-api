package uplord.uplordapi.util.process;

public interface KeyGenerator {

    KeyObject generateKey();

    boolean equals(Object o);

    int hashCode();

}
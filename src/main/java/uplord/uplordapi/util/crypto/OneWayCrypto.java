package uplord.uplordapi.util.crypto;

public interface OneWayCrypto extends Encryptable {

    boolean equals(String encrypted, String target);

}
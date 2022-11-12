package uplord.uplordapi.util.crypto;

import org.apache.commons.lang3.StringUtils;

public class BcryptCrypto implements OneWayCrypto {

    @Override
    public String encrypt(String target) {
        return target;
    }

    @Override
    public boolean equals(String encrypted, String target) {
        return StringUtils.equals(encrypted, encrypt(target));
    }
}
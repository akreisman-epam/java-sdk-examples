package com.hyperwallet.example.prepaidcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletPrepaidCard;
import com.hyperwallet.clientsdk.util.HyperwalletEncryption;
import com.hyperwallet.example.HyperwalletEncriptionConfig;
import com.hyperwallet.example.Util;

public class UpdatePrepaidCard {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String userToken = (args.length > i) ? args[i++] : "usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75";
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String prepaidCardToken = (args.length > i) ? args[i++] : "trm-02d27299-55bf-4a13-b37e-3ab246efd95a";
        String encryptionEnabled = (args.length > i) ? args[i++] : "false";

        HyperwalletEncryption hyperwalletEncryption = null;
        if (Boolean.parseBoolean(encryptionEnabled)) {
            hyperwalletEncryption = new HyperwalletEncryption.HyperwalletEncryptionBuilder()
                    .clientPrivateKeySetLocation(HyperwalletEncriptionConfig.CLIENT_PRIVATE_KEYSET_PATH)
                    .hyperwalletKeySetLocation(HyperwalletEncriptionConfig.HYPERWALLET_KEYSET_PATH)
                    .build();
        }
        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken,
                hyperwalletEncryption);

        HyperwalletPrepaidCard prepaidCard = new HyperwalletPrepaidCard()
                .token(prepaidCardToken)
                .userToken(userToken)
                .cardPackage("11111111");

        HyperwalletPrepaidCard
                updatedPrepaidCard =
                client.updatePrepaidCard(prepaidCard);

        Util.print(updatedPrepaidCard);
    }
}

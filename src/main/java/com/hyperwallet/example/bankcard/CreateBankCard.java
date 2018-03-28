package com.hyperwallet.example.bankcard;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletBankCard;
import com.hyperwallet.example.Util;

public class CreateBankCard {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-0fb6d624-f18d-480d-b1e7-f48f534bbd75";
        String cardNumber = (args.length > i) ? args[i++] : "4216701111100121";

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             programToken);

        HyperwalletBankCard bankCard = new HyperwalletBankCard()
            .userToken(userToken)
            .cardNumber(cardNumber)
            .dateOfExpiry(Util.parseDate("2020-01-01T00:00:00 UTC"))
            .transferMethodCountry("US")
            .transferMethodCurrency("USD");

        HyperwalletBankCard createdBankCard = client.createBankCard(bankCard);

        Util.print(createdBankCard);
    }

}

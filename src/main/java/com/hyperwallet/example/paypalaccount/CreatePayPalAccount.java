package com.hyperwallet.example.paypalaccount;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletPayPalAccount;
import com.hyperwallet.clientsdk.model.HyperwalletTransferMethod;
import com.hyperwallet.example.Util;

public class CreatePayPalAccount {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d";
        String userEmail = (args.length > i) ? args[i++] : "user@domain.com";

        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken);

        HyperwalletPayPalAccount payPalAccount = new HyperwalletPayPalAccount()
                .userToken(userToken)
                .type(HyperwalletTransferMethod.Type.PAYPAL_ACCOUNT)
                .transferMethodCountry("US")
                .transferMethodCurrency("USD")
                .email(userEmail);


        HyperwalletPayPalAccount createdPayPalAccount = client.createPayPalAccount(payPalAccount);

        Util.print(createdPayPalAccount);
    }
}

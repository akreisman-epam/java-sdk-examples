package com.hyperwallet.example.papercheck;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletPaperCheck;
import com.hyperwallet.clientsdk.model.HyperwalletTransferMethod;
import com.hyperwallet.clientsdk.model.HyperwalletUser;
import com.hyperwallet.example.Util;

public class CreatePaperCheck {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String username = args[i++];
        String password = args[i++];
        String programToken = (args.length > i) ? args[i++] : "prg-44a64920-45fc-4578-a7f9-e14813b3ed54";
        String userToken = (args.length > i) ? args[i++] : "usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d";


        Hyperwallet client = new Hyperwallet(username,
                password,
                programToken);

        HyperwalletPaperCheck paperCheck = new HyperwalletPaperCheck()
                .userToken(userToken)
                .bankAccountRelationship(HyperwalletTransferMethod.BankAccountRelationship.SELF)
                .profileType(HyperwalletUser.ProfileType.INDIVIDUAL)
                .isDefaultTransferMethod(true)
                .transferMethodCountry("US")
                .transferMethodCurrency("USD");


        HyperwalletPaperCheck createdPaperCheck = client.createPaperCheck(paperCheck);

        Util.print(createdPaperCheck);
    }
}

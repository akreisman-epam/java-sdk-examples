package com.hyperwallet.example.papercheck;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletBankCard;
import com.hyperwallet.clientsdk.model.HyperwalletPaperCheck;
import com.hyperwallet.clientsdk.model.HyperwalletPrepaidCard;
import com.hyperwallet.clientsdk.model.HyperwalletTransferMethod;
import com.hyperwallet.clientsdk.model.HyperwalletUser;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CreatePaperCheck {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletPaperCheck paperCheck = new HyperwalletPaperCheck()
            .userToken("usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d")
            .bankAccountRelationship(HyperwalletTransferMethod.BankAccountRelationship.SELF)
            .profileType(HyperwalletUser.ProfileType.INDIVIDUAL)
            .isDefaultTransferMethod(true)
            .transferMethodCountry("US")
            .transferMethodCurrency("USD");


        HyperwalletPaperCheck createdPaperCheck = client.createPaperCheck(paperCheck);

        System.out.println(ToStringBuilder.reflectionToString(createdPaperCheck, new MultilineRecursiveToStringStyle()));
    }

}

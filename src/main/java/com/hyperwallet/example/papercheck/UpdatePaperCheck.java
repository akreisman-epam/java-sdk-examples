package com.hyperwallet.example.papercheck;

import com.hyperwallet.clientsdk.Hyperwallet;
import com.hyperwallet.clientsdk.model.HyperwalletBankCard;
import com.hyperwallet.clientsdk.model.HyperwalletPaperCheck;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UpdatePaperCheck {

    public static void main(String[] args) throws Exception {
        String username = System.getProperty("HYPERWALLET_USERNAME");
        String password = System.getProperty("HYPERWALLET_PASSWORD");

        Hyperwallet client = new Hyperwallet(username,
                                             password,
                                             "prg-44a64920-45fc-4578-a7f9-e14813b3ed54");

        HyperwalletPaperCheck paperCheck = new HyperwalletPaperCheck()
            .token("trm-b379ca8e-973a-47d4-a79c-eaaf2af89ee6")
            .userToken("usr-b4a1f0bd-cbf7-4467-aa6f-4445dea7e67d")
            .addressLine1("11111111");

        HyperwalletPaperCheck
            updatedPaperCheck =
            client.updatePaperCheck(paperCheck);

        System.out.println(ToStringBuilder.reflectionToString(updatedPaperCheck, new MultilineRecursiveToStringStyle()));
    }
}

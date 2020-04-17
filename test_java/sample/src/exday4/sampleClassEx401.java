package exday4;

import IEmail;

public class sampleClassEx401{
    
    public static void main(String[] args){
        CellPhone cp = new CellPhone("hoge@hoge","090");
        cp.call("011");
        cp.sendMail("fuga@email");
        IPhone phone = (IPhone)cp;
        phone.call("011-112");
        IEmail mail = (IEmail)cp;
        mail.sendMail("bar@email");
    }
}
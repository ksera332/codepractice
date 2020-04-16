package exday4;

public class CellPhone implements IPhone,IEmail{
    private String mailAddress;
    private String number;

    public CellPhone(String mailAddress,String number){
        this.mailAddress = mailAddress;
        this.number = number;
    }
    public void sendMail(String address){
        System.out.println(address + "に、" + this.mailAddress  + "からメール");
    }
    public void call(String number){
        System.out.println(number + "に、" + this.number + "から電話");
    }
}
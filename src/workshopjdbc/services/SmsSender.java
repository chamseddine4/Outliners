/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.services;

import workshopjdbc.entities.participation_prive;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACf99bdcbefcc5f85375f57b8ca283c6ca";
    public static final String AUTH_TOKEN = "21fa7909d61382303889921d654f762e";

   public static void send(participation_prive p) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21620688495"),
          new com.twilio.type.PhoneNumber("+19378218125"),
              "Le Nombre de Prise en charge est : "+p.getNbrPrisecharge()+"  "+ java.time.LocalDate.now() +"")
            .create();

        System.out.println(message.getSid());
    }
   
    public static void main(String[] args){
            participation_prive u = new participation_prive(3, 20688495, 5 );
        send(u);
       
       
       
    }
}
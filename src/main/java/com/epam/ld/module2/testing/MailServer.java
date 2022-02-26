package com.epam.ld.module2.testing;

/**
 * Mail server class.
 */
public class MailServer {

    /**
     * Send notification.
     *
     * @param addresses  the addresses
     * @param messageContent the message content
     */
    public void send(String addresses, String messageContent) throws Exception {
        if(messageContent==null) throw new Exception("There is no message to send!");
        if(addresses==null) throw new Exception("Отправка сообщения невозможна! Адрес отсутствует");
        System.out.println("Message was send to "+ addresses);
    }
}

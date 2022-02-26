package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


public class MailServerTest {
    @Tag("slow")
    @ParameterizedTest
    @ValueSource(strings = {"Lenina", "Mira", "Baker", "Titova"})
    public void getClientAddressTest(String addre){
        Client client = new Client(addre);
        String address = client.getAddresses();
        assertEquals(addre, address);
    }

    @Test
    @Tag("integration")
    public void sendMessageTest() throws Exception {
        MailServer mailServer = new MailServer();
        TemplateEngine templateEngine = new TemplateEngine();
        Client client = new Client("Lenina");
        Template template = new Template("Egor", "Bobrov");
        Messenger messenger = new Messenger(mailServer, templateEngine);
        messenger.sendMessage(client, template);
        //fail("Not implementation");
    }

    @Test
    @Tag("integration")
    public void createMessengerTest(){
        MailServer mailServer = new MailServer();
        TemplateEngine templateEngine = new TemplateEngine();
        Client client = new Client("Lenina");
        Template template = new Template("Egor", "Bobrov");
        Messenger messenger = new Messenger(mailServer, templateEngine);
        assertNotNull(messenger);
    }

    @Test
    @Tag("integration")
    public void updateAndSendMessageTest() throws Exception {

        MailServer mailServer = new MailServer();
        mailServer.send("Lenin", "message");
    }

    @Test
    @Tag("integration")
    @TransactionalDevTestConfig
    @interface TransactionalDevTestConfig { }//Образец как можно использовать обобщающую аннотацию, для избежания повторяющегося кода


    @TempDir
    File anotherTempDir;

    @Test
    void givenFieldWithTempDirectoryFile_whenWriteToFile_thenContentIsCorrect() throws IOException {
        File letters = new File(anotherTempDir, "letters.txt");
        Files.write(letters.toPath(), Collections.singleton("lines"));
    }
// ТАк бы выглядел тестовый метод с
//
//      @Mock
//      Template template;
//    @Test
//    public void generateTemplateTest(){
//        assertNotNull(template);
//    }
}

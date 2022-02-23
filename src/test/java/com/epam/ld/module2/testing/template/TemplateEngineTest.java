package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TemplateEngineTest {
    @Test
    public void generateTemplateTest(){
        Template template = new Template("Igor" , "Lyakhov");
        assertNotNull(template);
    }

    @Test
    public void getClientAddressTest(){
        Client client = new Client("Lenina");
        String address = client.getAddresses();
        assertEquals("Lenina", address);
    }

    @Test
    public void setClientAddressTest(){
        Client client = new Client("Lenina");
        client.setAddresses("Mira");
        String address = client.getAddresses();
        assertEquals("Mira", address);
    }

    @Test
    public void generateMessageTest() throws Exception {
        TemplateEngine templateEngine = new TemplateEngine();
        Template template = new Template("Igor", "Lyakhov");
        Client client = new Client("Lenina");
        String message = templateEngine.generateMessage(template,client);
        assertEquals("Hello, my name is Igor!!!", message);
    }

    @Test
    public void withoutOneValuesTemplateTest(){
        TemplateEngine templateEngine = new TemplateEngine();
        Template template = new Template("Igor", null);
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            templateEngine.generateMessage(template,new Client("Lenina"));
        });
    }

    @Test
    public void extraValuesInTemplateTest() throws Exception {
        TemplateEngine templateEngine = new TemplateEngine();
        Template template = new Template("Igor", "Lyakhov");
        Client client = new Client("Lenina");
        String message = templateEngine.generateMessage(template,client);
        assertEquals("Hello, my name is Igor!!!", message);
    }

    @Test
    public void supportBracketValuesTest(){
        fail("Not implementation");
    }
}

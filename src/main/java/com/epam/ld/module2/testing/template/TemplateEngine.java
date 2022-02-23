package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) throws Exception {
        if(template.getName()==null||template.getSurname()==null){
            throw new Exception("Bull shit");
        }
       return new String(Files.readAllBytes(Paths.get("C:\\Users\\Igorj\\Desktop\\messenger\\src\\text.txt")))
               .replace("#{Name}", template.getName()).replace("#{SurName}", template.getSurname());
    }
}

package com.lbnbhl.javaWeb;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * @autor wwl
 * @date 2022/9/1-20:24
 */
public class xmlTest {
    @Test
    public void dom4jTest() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("./src/main/resources/static/xmlTest.xml");
        List<Element> elements = read.getRootElement().elements();
        for (Element element : elements) {
            Element name = element.element("name");
            Element autor = element.element("autor");
            Element price = element.element("price");
            System.out.println(name.getText()+autor.getText()+price.getText());
        }
        System.out.println(read);
    }
}

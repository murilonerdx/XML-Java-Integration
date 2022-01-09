package com.murilonerdx;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fabrica.newDocumentBuilder();

        Document document = builder.parse("src/com/murilonerdx/vendas.xml");
        NodeList formaDePagamentos = document.getElementsByTagName("formaDePagamento");
        Element item = (Element) formaDePagamentos.item(0);

        String formaDePagamento = item.getTextContent();

        System.out.println(formaDePagamento);
    }
}

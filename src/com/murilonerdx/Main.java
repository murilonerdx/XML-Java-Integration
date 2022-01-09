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
        lerUmItem();

        lerMuitosItems();

        lerObjetoItem();

        pegarMoeda();

        lerTodosDados();

    }

    public static void lerUmItem() throws IOException, SAXException, ParserConfigurationException {
        Document document = factoryBuilder().parse("src/com/murilonerdx/vendas.xml");
        NodeList formaDePagamentos = document.getElementsByTagName("formaDePagamento");
        Element item = (Element) formaDePagamentos.item(0);

        String formaDePagamento = item.getTextContent();

        System.out.println(formaDePagamento);
    }

    public static void lerMuitosItems() throws IOException, SAXException, ParserConfigurationException {
        Document document = factoryBuilder().parse("src/com/murilonerdx/vendas.xml");

        NodeList produtos = document.getElementsByTagName("nome");

        for (int i = 0; i < produtos.getLength(); i++) {
            Element produto = (Element) produtos.item(i);
            String nome = produto.getTextContent();
            System.out.println(nome);

        }
    }

    public static void lerObjetoItem() throws IOException, SAXException, ParserConfigurationException{
        Document document = factoryBuilder().parse("src/com/murilonerdx/vendas.xml");
        NodeList produtos = document.getElementsByTagName("produto");

        for(int i = 0;i < produtos.getLength();i++) {
            Element produto = (Element) produtos.item(i);
            String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
            double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
            Produto prod = new Produto(nome, preco);

            System.out.println(prod);
        }
    }

    public static void pegarMoeda() throws IOException, SAXException, ParserConfigurationException {
        Document document = factoryBuilder().parse("src/com/murilonerdx/vendas.xml");

        Element venda = document.getDocumentElement();
        String moeda = venda.getAttribute("moeda");
        System.out.println(moeda);
    }

    public static void lerTodosDados() throws ParserConfigurationException, IOException, SAXException {
        Document document = factoryBuilder().parse("src/com/murilonerdx/vendas.xml");

        NodeList produtos = document.getElementsByTagName("produto");

        for(int i =0; i < produtos.getLength(); i++) {
            Element produto = (Element) produtos.item(i);
            String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
            String preco = produto.getElementsByTagName("preco").item(0).getTextContent();

            System.out.println("-----------");
            System.out.println("Nome do produto: "+ nome);
            System.out.println("Preco do produto: "+ preco);
            System.out.println("-----------");
        }
    }

    public static DocumentBuilder factoryBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        return fabrica.newDocumentBuilder();
    }
}

package com.service.nanodataxml;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.service.nanodataxml.model.shared.UtilNfe;
import org.springframework.boot.SpringApplication;
import com.service.nanodataxml.model.entity.NfeProc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;

import java.io.File;

@SpringBootApplication
public class NanodataXmlApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(NanodataXmlApplication.class, args);
//
//
//		File inputFile =  new File("C:\\dev\\Java\\xml\\file_teste_01.xml");
//
//		XmlMapper xmlMapper = new XmlMapper();
//		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//		NfeProc nfeProc = xmlMapper.readValue(inputFile, NfeProc.class);
//		NfeProcDTO dto = UtilNfe.fromNfeProc(nfeProc);
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
//		Document doc = docBuilder.parse(inputFile);
//		doc.getDocumentElement().normalize();
//		NodeList nList = doc.getElementsByTagName("infNFe");
//		System.out.println("doc.toString()");
//		System.out.println(nList.getLength());
//
//		for (int temp = 0; temp < nList.getLength(); temp++) {
//			Node nNode = nList.item(temp);
//			System.out.println("\nCurrent Element: " + nNode.getNodeName());
//
//			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//				Element eElement = (Element) nNode;
//				System.out.println("id: " + eElement.getAttribute("Id"));
//				System.out.println("cUF: " + eElement.getElementsByTagName("cUF").item(0).getTextContent());
//				System.out.println("nNF: " + eElement.getElementsByTagName("nNF").item(0).getTextContent());
//				System.out.println("cUF: " + eElement.getElementsByTagName("cUF").item(0).getTextContent());
//				System.out.println("CNPJ: " + eElement.getElementsByTagName("CNPJ").item(0).getTextContent());
//				System.out.println("xFant: " + eElement.getElementsByTagName("xFant").item(0).getTextContent());
//				System.out.println("CNPJ: " + eElement.getElementsByTagName("CNPJ").item(1).getTextContent());
//				System.out.println("xNome: " + eElement.getElementsByTagName("xNome").item(0).getTextContent());
//				System.out.println("vTotTrib: " + eElement.getElementsByTagName("vTotTrib").item(0).getTextContent());
//				System.out.println("vNF: " + eElement.getElementsByTagName("vNF").item(0).getTextContent());
//
//			}
//		}


	}

}

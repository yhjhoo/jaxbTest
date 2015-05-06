package prince.jaxb.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.junit.Test;

import prince.jaxb.module.Book;
import prince.jaxb.module.Customer;
import prince.jaxb.module.Customer1;


public class Application {
	@Test
	public void objToXml() {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("suo");
		customer.setAge(29);
		List<Book> bookList = new ArrayList<Book>();
		Book b1 = new Book();
		b1.setId(1);
		b1.setName("Test Book");
		b1.setDesc("Book Desc");
		bookList.add(b1 );
		
		customer.setBookList(bookList );

		try {
			File file = new File("file2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void objToXml_withoutAnnotation() {
		Customer1 customer = new Customer1();
		customer.setId(100);
		customer.setName("suo");
		customer.setAge(29);
		List<Book> bookList = new ArrayList<Book>();
		Book b1 = new Book();
		b1.setId(1);
		b1.setName("Test Book");
		b1.setDesc("Book Desc");
		bookList.add(b1 );
		
		customer.setBookList(bookList );

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			JAXBElement<Customer1> rootElement = new JAXBElement<Customer1>(new QName("customer"), Customer1.class, customer);
			jaxbMarshaller.marshal(rootElement, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUnXml() {  
        try {  
            File file = new File("file1.xml");  
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);  
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);  
            System.out.println(customer);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
    } 
}

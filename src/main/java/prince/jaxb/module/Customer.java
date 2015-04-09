package prince.jaxb.module;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Customer {
	
	private String name;
	private int age;
	private int id;
	
//	@XmlElementWrapper(name = "bookList")
	  // XmlElement sets the name of the entities
//	
	private List<Book> bookList;
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ",name=" + name + ",age=" + age + "]";
	}

	@XmlElementWrapper(name = "bookList", namespace="http://www.javalinux.me/book")
	@XmlElement(name = "book")
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}

@javax.xml.bind.annotation.XmlSchema (
//  namespace = "http://www.example.com/MYPO1"
  xmlns = {
    @javax.xml.bind.annotation.XmlNs(prefix = "po",
               namespaceURI="http://www.example.com/myPO1"),

    @javax.xml.bind.annotation.XmlNs(prefix="b",
               namespaceURI="http://www.javalinux.me/book")
  }
)


/**
 * @author yhjhoo
 *
 */
package prince.jaxb.module;
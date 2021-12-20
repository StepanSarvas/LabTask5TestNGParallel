package ReadXML;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "searchData")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchData {

    @XmlElement(name="keyword")
    private String keyword;
    @XmlElement(name="brandName")
    private String brandName;
    @XmlElement(name="priceValidation")
    private String priceValidation;

    public String getKeyword() { return keyword; }

    public String getBrandName() { return brandName; }

    public String getPriceValidation() { return priceValidation; }

    @Override
    public String toString() {
        return "SearchData{" +
                "keyword='" + keyword + '\'' +
                ", brandName='" + brandName + '\'' +
                ", priceValidation=" + priceValidation +
                ", getKeyword='" + keyword + '\'' +
                ", getBrandName='" + brandName + '\'' +
                ", getPriceValidation=" + priceValidation +
                '}';
    }

}

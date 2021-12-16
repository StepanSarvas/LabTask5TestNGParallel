package parsers.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement( name = "searchData" )
public class DataModel {

    @XmlElement
    public String keyword;

    @XmlElement
    public String brandName;

    @XmlElement
    public String priceValidation;

    public String getKeyword() {
        return keyword;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getPriceValidation() {
        return priceValidation;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "keyword='" + keyword + '\'' +
                ", brandName='" + brandName + '\'' +
                ", priceValidation='" + priceValidation + '\'' +
                '}';
    }
}

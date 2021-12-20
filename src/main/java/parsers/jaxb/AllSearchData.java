package parsers.jaxb;

import ReadXML.SearchData;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Arrays;
import java.util.List;


@XmlRootElement(name = "allSearchData")
//@XmlAccessorType(XmlAccessType.FIELD)
public class AllSearchData {

    @XmlElement(name = "searchData")
    private List<SearchData> allSearchData;

    public List<SearchData> getAllSearchData() {
        return allSearchData;
    }

    @Override
    public String toString() {
        return "AllSearchData{" +
                "allSearchData=" + Arrays.asList(allSearchData) +
                '}';
    }
}


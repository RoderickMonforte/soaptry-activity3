package gov.weather;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Created by student on 2/25/17.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub service = (NdfdXMLBindingStub) new NdfdXMLLocator
                ().getndfdXMLPort();

        String response = service.latLonListZipCode("53590");
        String result = unmarshalResponse(response);

        assertEquals("Result is not equal to expected","???",result);
    }

    private String unmarshalResponse(String response) {
        DwmlType dwmlType = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            dwmlType = (DwmlType) jaxbUnmarshaller.unmarshal(new
                    StringReader(response));
         } catch (JAXBException e) {
            e.printStackTrace();
        }
        return dwmlType.getLatLonList();
    }


}
package wgcv.me.controlgarita;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by wgcv on 20/09/15.
 */
public class Ciudadela {
    //Namespace of the Webservice - can be found in WSDL
    private static String NAMESPACE = "http://ciudadela.ControlGarita.com";
    //Webservice URL - WSDL File location
    private static String URL = "http://192.168.1.10:8080/ControlGarita/services/Ciudadela?WSDL";
    //SOAP Action URI again Namespace + Web method name
    private static String SOAP_ACTION = "http://ciudadela.ControlGarita.com";
    public static void crear(String usuario, String webMethName){
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo pUsuario = new PropertyInfo();
        // Set Name
        pUsuario.setName("usuario");
        // Set Value
        pUsuario.setValue(usuario);
        // Set dataType
        pUsuario.setType(String.class);
        // Add the property to request object
        request.addProperty(pUsuario);
        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to resTxt variable static variable

        } catch (Exception e) {
            //Print error
            e.printStackTrace();
            //Assign error message to resTxt
        }
    }
    public static void abrir(){
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, "abrir");

        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+"abrir", envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to resTxt variable static variable

        } catch (Exception e) {
            //Print error
            e.printStackTrace();
            //Assign error message to resTxt
        }
    }
    public static String solicitudes(String usuario, String webMethName) {
        String resTxt = null;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo pUsuario = new PropertyInfo();
        // Set Name
        pUsuario.setName("usuario");
        // Set Value
        pUsuario.setValue(usuario);
        // Set dataType
        pUsuario.setType(String.class);
        // Add the property to request object
        request.addProperty(pUsuario);
        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to resTxt variable static variable
            resTxt = response.toString();

        } catch (Exception e) {
            //Print error
            e.printStackTrace();
            //Assign error message to resTxt
            resTxt = "Error occured";
        }
        //Return resTxt to calling object
        return resTxt;
    }
}

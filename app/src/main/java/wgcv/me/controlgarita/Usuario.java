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
public class Usuario {
    //Namespace of the Webservice - can be found in WSDL
    private static String NAMESPACE = "http://usuario.ControlGarita.com";
    //Webservice URL - WSDL File location
    private static String URL = "http://192.168.1.10:8080/ControlGarita/services/Usuario?WSDL";
    //SOAP Action URI again Namespace + Web method name
    private static String SOAP_ACTION = "http://usuario.ControlGarita.com";

    public static String login(String correo,String password, String webMethName) {
        String resTxt = null;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo pCorreo = new PropertyInfo();
        // Set Name
        pCorreo.setName("correo");
        // Set Value
        pCorreo.setValue(correo);
        // Set dataType
        pCorreo.setType(String.class);
        // Add the property to request object
        request.addProperty(pCorreo);
        PropertyInfo pPassword = new PropertyInfo();
        // Set Name
        pPassword.setName("password");
        // Set Value
        pPassword.setValue(password);
        // Set dataType
        pPassword.setType(String.class);
        // Add the property to request object
        request.addProperty(pPassword);
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
    } public static String esresidente(String correo, String webMethName) {
        String resTxt = null;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo pCorreo = new PropertyInfo();
        // Set Name
        pCorreo.setName("correo");
        // Set Value
        pCorreo.setValue(correo);
        // Set dataType
        pCorreo.setType(String.class);
        // Add the property to request object
        request.addProperty(pCorreo);

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
    public static void registrar(String correo, String password, String webMethName) {
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo pCorreo = new PropertyInfo();
        // Set Name
        pCorreo.setName("correo");
        // Set Value
        pCorreo.setValue(correo);
        // Set dataType
        pCorreo.setType(String.class);
        // Add the property to request object
        request.addProperty(pCorreo);
        PropertyInfo pPassword = new PropertyInfo();
        // Set Name
        pPassword.setName("clave");
        // Set Value
        pPassword.setValue(password);
        // Set dataType
        pPassword.setType(String.class);
        // Add the property to request object
        request.addProperty(pPassword);

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
        //Return resTxt to calling object
    }
}

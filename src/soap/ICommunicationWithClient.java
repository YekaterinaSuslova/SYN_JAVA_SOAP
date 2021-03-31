package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

// Указываем специальную аннотацию, что интерфейс будет работать в web-технологии SOAP
@WebService
public interface ICommunicationWithClient {

    // Указываем специальную аннотацию, что метод будет работать в web-технологии SOAP
    @WebMethod
    public Answer example(double x, double a, double b);
}

package soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

// Указываем специальные аннотации, что класс будет работать в web-технологии SOAP
@WebService
@SOAPBinding(style = Style.RPC)

public class CommunicationWithClient implements ICommunicationWithClient {

    // Решение квадратного уровнения
    @Override
    public Answer example(double x, double a, double b) {
        double y = 0;

        if (x > 5) {
            y = (5 * a * b) / (x * x + a * a);
        } else {
            y = 4 * (a + b - x) * (a + b - x);
        }

        Answer otvet = new Answer(y);
        return otvet;
    }

}

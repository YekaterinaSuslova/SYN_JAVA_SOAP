package soap;

import java.io.Serializable;

// Указываем через Serializable что класс будет способен работать в web-технологии SOAP
// ДЛЯ КАЖДОГО ПОЛЯ НУЖНЫ СЕТТЕРЫ И ГЕТТЕРЫ, А ТАКЖЕ ОБЪЗАТЕЛЕН ПУСТОЙ КОНСТРУКТОР !
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private double y;
    

    public Answer() {
    }

    public Answer(double y) {
        this.y = y;
    }

    public void setY(double y) {
        this.y = y;
    }

   
    public double getY() {
        return y;
    }

    

    @Override
    public String toString() {
        return "y=" + y;
    }

}

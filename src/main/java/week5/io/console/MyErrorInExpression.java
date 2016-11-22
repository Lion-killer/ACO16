package week5.io.console;

/**
 * Created by bilousyv on 21.11.2016.
 */
public class MyErrorInExpression extends Throwable {

    public MyErrorInExpression() {
    }

    public MyErrorInExpression(String message) {
        super(message);
    }
}

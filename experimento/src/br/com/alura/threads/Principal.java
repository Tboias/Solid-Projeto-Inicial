import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

public class Principal implements UncaughtExceptionHandler {

    public static void main(String[] args) {
        Properties properties = new Properties();
        Thread thread = new Thread(new LeitorPropriedades(properties, "arquivo1.txt"));
        thread.setUncaughtExceptionHandler(new Principal());
        thread.start();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("Exceção " + e + "capturada na Thread "+ t.getName());

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTraceTest {
    public int add(int a, int b) throws IOException {
        if (a == 1) {
            throw new IOException("异常");
        }

        return a + b;
    }


    public static void main(String[] args) throws IOException {
        BTraceTest traceTest = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String arg = reader.readLine();

            int a = Integer.parseInt(arg);

            //int a  = (int)Math.round(Math.random()*1000);
            int b = (int) Math.round(Math.random() * 1000);
            try {
                System.out.println(traceTest.add(a, b));
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
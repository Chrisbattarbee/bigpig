package Experimental;

import java.nio.ByteBuffer;

public class BigFoo {
    private static int byteArrToInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    public static int fooByte(byte[] n, byte[] m, byte[] x) {
        return foo(byteArrToInt(n), byteArrToInt(m), byteArrToInt(x));
    }

    public static int foo(int n, int m, int x) {
        if (n == 123) {
            return 1000;
        }
        for (int z = 0; z < 3; z++) {
            if (n < m) {
                x *= n;
            } else {
                x += 1;
            }
            if (x % 3931 == 0) {
                return x;
            }
            n += 1;
        }
        return 0;
    }
}

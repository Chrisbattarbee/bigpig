package utils;

import com.google.protobuf.ByteString;

import java.io.*;

public class ByteStringManipulation {

    public static final String HOST_NAME = "co-ordinator";
    public static final int PORT_NUMBER = 8080;

    public static ByteString objectToByteString(Object o) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        // Make our object writer and write our serialized object to it
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Flush all the bytes
        try {
            byteStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ByteString.copyFrom(byteStream.toByteArray());
    }

    public static Object byteStringToObject(ByteString byteString) {
        byte[] serializedValue = new byte[byteString.size()];
        byteString.copyTo(serializedValue, 0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedValue);
        try {
            ObjectInputStream stream = new ObjectInputStream(byteArrayInputStream);
            return stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ByteString serializeException(Exception ex) {
        byte exceptionFlag = ex != null ? (byte) 1 : 0;
        byte[] exceptionBytes = new byte[1];
        if(ex != null) {
            byte[] serializedException = objectToByteString(ex).toByteArray();
            int len = serializedException.length;
            exceptionBytes = new byte[len + 1];
            System.arraycopy(serializedException, 0, exceptionBytes, 1, len);
        }
        exceptionBytes[0] = exceptionFlag;
        return ByteString.copyFrom(exceptionBytes);
    }

    public static Exception deserializeException(ByteString bytes) {
        boolean isException = bytes.byteAt(0) != 0;
        if(isException) {
            Exception ex = (Exception) byteStringToObject(bytes.substring(1));
            return ex;
        }
        return null;
    }
}

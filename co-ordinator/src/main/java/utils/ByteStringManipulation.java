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

}

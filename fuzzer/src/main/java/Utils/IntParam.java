package Utils;

import java.nio.ByteBuffer;

public class IntParam implements ConvertibleParam {

    public IntParam(int val) {
        this.val = val;
    }

    private int val;

    public int getVal() {
        return val;
    }

    @Override
    public byte[] toByteArray() {
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt(val);
        return buf.array();
    }

    @Override
    public String fromByteArray(byte[] arr) {
        return Integer.toString(ByteBuffer.wrap(arr).getInt());
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}

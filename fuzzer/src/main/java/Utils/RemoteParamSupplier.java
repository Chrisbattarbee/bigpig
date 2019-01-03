package Utils;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RemoteParamSupplier {
    private final List<LinkedBlockingQueue<byte[]>> valuesPerParam;
    private final Supplier<Object[][]> paramSupplier;
    private final MethodInfo methodInfo;
    private final Thread updateTask;
    public RemoteParamSupplier(MethodInfo methodInfo, Supplier<Object[][]> paramSupplier) {
        this.valuesPerParam = new ArrayList<>();
        for(int i = 0; i < methodInfo.getParams().length; i++) {
            this.valuesPerParam.add(new LinkedBlockingQueue<>());
        }
        this.paramSupplier = paramSupplier;
        this.methodInfo = methodInfo;
        updateTask = new Thread(() -> {
            while(true) {
                addToQueues();
            }
        });
        updateTask.start();
    }

    public byte[] getParamValueOrNull(int i) {
        return valuesPerParam.get(i).poll();
    }

    private void addToQueues() {
        Object[][] params = transpose(paramSupplier.get());
        System.out.println(Arrays.toString(params));
        for(int i = 0; i < params.length; i++) {
            FuzzingUtils.ProcessedParam processedParam = FuzzingUtils.processParam(methodInfo.getParams()[i].getType(),
                                                                                   params[i]);
            System.out.println(Arrays.toString(processedParam.getConvertibleParams().get(0).toByteArray()));
            valuesPerParam.get(i).addAll(processedParam.getConvertibleParams().stream()
                    .map(ConvertibleParam::toByteArray).collect(Collectors.toList()));
            System.out.println("SIZE" + valuesPerParam.get(i).size());
        }
    }

    private Object[][] transpose(Object[][] arr) {
        Object[][] res = new Object[arr[0].length][arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                res[j][i] = arr[i][j];
            }
        }
        return res;
    }
}

package Utils;

import jwp.fuzz.ByteArrayParamGenerator;
import jwp.fuzz.ParamGenerator;
import jwp.fuzz.ParamProvider;
import jwp.fuzz.SeedContainer;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class FuzzingUtils {

    private static ParamGenerator byteArrayGeneratorFromSeeds(List<ConvertibleParam> seeds) {
        List<byte[]> byteArrs = seeds.stream().map(ConvertibleParam::toByteArray).collect(Collectors.toList());
        return ByteArrayParamGenerator.suggested(byte[].class, ByteArrayParamGenerator.Config.builder()
                .initialValues(byteArrs).build());
    }


    public static ParamProvider getParamProvider(MethodInfo methodInfo, Object[][] seeds, boolean[] suggested) {
        ParamGenerator[] generators = new ParamGenerator[methodInfo.getParams().length];
        for (int i = 0; i < generators.length; i++) {
            ProcessedParam param = processParam(methodInfo.getParams()[i].getType(), seeds[i]);
            generators[i] = suggested[i] ? ParamGenerator.suggestedWithSeeds(param.type, param.seedContainer)
                    : byteArrayGeneratorFromSeeds(param.convertibleParams);
        }
        return new ParamProvider.Suggested(generators);
    }

    public static ParamProvider getParamProviderWithExternal(MethodInfo methodInfo, RemoteParamSupplier supplier) {
        ParamGenerator[] generators = new ParamGenerator[methodInfo.getParams().length];
        for(int i = 0; i < generators.length; i++) {
            final int cur = i;
            ByteArrayParamGenerator.Config config = ByteArrayParamGenerator.Config.builder()
                    .externalParamSupplier(() -> supplier.getParamValueOrNull(cur)).build();
            generators[i] = ByteArrayParamGenerator.suggested(byte[].class, config);
        }
        return new ParamProvider.Suggested(generators);
    }

    public static ProcessedParam processParam(MethodInfo.PrimitiveType type, Object[] vals) {

        switch (type) {
            case INT:
                int[] intSeeds = new int[vals.length];
                for (int i = 0; i < intSeeds.length; i++) {
                    try {
                        intSeeds[i] = (int) vals[i];
                    } catch (ClassCastException e)
                    {
                        byte[] bytes = new byte[4];
                        for(int j = 0;  j < 4; j++) {
                            bytes[j] = (byte) ((Object[])vals[i])[j];
                        }
                        int res = ByteBuffer.wrap(bytes).getInt();
                        intSeeds[i] = res;
                    }
                }
                return new ProcessedParam(Arrays.stream(intSeeds).mapToObj(IntParam::new).collect(Collectors.toList()),
                        new SeedContainer(intSeeds), ptypeToClass.get(type));
            case BYTE:
                break;
            case CHAR:
                break;
            case LONG:
                break;
            case FLOAT:
                break;
            case SHORT:
                break;
            case DOUBLE:
                break;
            case STRING:
                break;
            case BOOLEAN:
                break;
        }
        return null;
    }

    public static class ProcessedParam {
        private final List<ConvertibleParam> convertibleParams;
        private final SeedContainer seedContainer;
        private final Class<?> type;

        public ProcessedParam(List<ConvertibleParam> convertibleParams, SeedContainer seedContainer, Class<?> type) {
            this.convertibleParams = convertibleParams;
            this.seedContainer = seedContainer;
            this.type = type;
        }

        public Class<?> getType() {
            return type;
        }

        public List<ConvertibleParam> getConvertibleParams() {
            return convertibleParams;
        }

        public SeedContainer getSeedContainer() {
            return seedContainer;
        }
    }

    private static Dictionary<MethodInfo.PrimitiveType, Class<?>> ptypeToClass
            = new Hashtable<MethodInfo.PrimitiveType, Class<?>>() {{
        put(MethodInfo.PrimitiveType.INT, Integer.TYPE);
        put(MethodInfo.PrimitiveType.LONG, Long.TYPE);
        put(MethodInfo.PrimitiveType.SHORT, Short.TYPE);
        put(MethodInfo.PrimitiveType.BYTE, Byte.TYPE);
        put(MethodInfo.PrimitiveType.CHAR, Character.TYPE);
        put(MethodInfo.PrimitiveType.FLOAT, Float.TYPE);
        put(MethodInfo.PrimitiveType.DOUBLE, Double.TYPE);
        put(MethodInfo.PrimitiveType.BOOLEAN, Boolean.TYPE);
        put(MethodInfo.PrimitiveType.STRING, String.class);

    }};

}

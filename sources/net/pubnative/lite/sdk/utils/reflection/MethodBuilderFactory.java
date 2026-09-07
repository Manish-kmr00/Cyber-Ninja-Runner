package net.pubnative.lite.sdk.utils.reflection;

/* JADX INFO: loaded from: classes12.dex */
public class MethodBuilderFactory {
    protected static MethodBuilderFactory instance = new MethodBuilderFactory();

    @Deprecated
    public static void setInstance(MethodBuilderFactory methodBuilderFactory) {
        instance = methodBuilderFactory;
    }

    public static ReflectionUtils.MethodBuilder create(Object obj, String str) {
        return instance.internalCreate(obj, str);
    }

    protected ReflectionUtils.MethodBuilder internalCreate(Object obj, String str) {
        return new ReflectionUtils.MethodBuilder(obj, str);
    }
}

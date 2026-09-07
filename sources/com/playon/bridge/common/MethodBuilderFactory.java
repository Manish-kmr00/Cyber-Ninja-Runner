package com.playon.bridge.common;

/* JADX INFO: loaded from: classes5.dex */
public class MethodBuilderFactory {
    protected static MethodBuilderFactory instance = new MethodBuilderFactory();

    public static Reflection.MethodBuilder create(Object obj, String str) {
        return instance.internalCreate(obj, str);
    }

    protected Reflection.MethodBuilder internalCreate(Object obj, String str) {
        return new Reflection.MethodBuilder(obj, str);
    }
}

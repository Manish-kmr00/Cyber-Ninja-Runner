package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public final class UInt32Value extends AbstractC3169a0 implements F0 {
    private static final UInt32Value DEFAULT_INSTANCE;
    private static volatile N0 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    static {
        UInt32Value uInt32Value = new UInt32Value();
        DEFAULT_INSTANCE = uInt32Value;
        AbstractC3169a0.registerDefaultInstance(UInt32Value.class, uInt32Value);
    }

    private UInt32Value() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0;
    }

    public static UInt32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C3200k1 newBuilder() {
        return (C3200k1) DEFAULT_INSTANCE.createBuilder();
    }

    public static UInt32Value of(int i) {
        C3200k1 c3200k1NewBuilder = newBuilder();
        c3200k1NewBuilder.c();
        ((UInt32Value) c3200k1NewBuilder.b).setValue(i);
        return (UInt32Value) c3200k1NewBuilder.a();
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UInt32Value) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt32Value parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static N0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
    public final Object dynamicMethod(Z z, Object obj, Object obj2) {
        switch (AbstractC3197j1.f2288a[z.ordinal()]) {
            case 1:
                return new UInt32Value();
            case 2:
                return new C3200k1();
            case 3:
                return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                N0 v = PARSER;
                if (v == null) {
                    synchronized (UInt32Value.class) {
                        v = PARSER;
                        if (v == null) {
                            v = new V();
                            PARSER = v;
                        }
                        break;
                    }
                }
                return v;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getValue() {
        return this.value_;
    }

    public static C3200k1 newBuilder(UInt32Value uInt32Value) {
        return (C3200k1) DEFAULT_INSTANCE.createBuilder(uInt32Value);
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
        return (UInt32Value) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static UInt32Value parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
    }

    public static UInt32Value parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
    }

    public static UInt32Value parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
    }

    public static UInt32Value parseFrom(byte[] bArr) throws C3211o0 {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UInt32Value parseFrom(byte[] bArr, H h) throws C3211o0 {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
    }

    public static UInt32Value parseFrom(InputStream inputStream) throws IOException {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt32Value parseFrom(InputStream inputStream, H h) throws IOException {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static UInt32Value parseFrom(AbstractC3229w abstractC3229w) throws IOException {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
    }

    public static UInt32Value parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
        return (UInt32Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
    }
}

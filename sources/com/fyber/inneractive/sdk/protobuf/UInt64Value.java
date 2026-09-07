package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes11.dex */
public final class UInt64Value extends AbstractC3169a0 implements F0 {
    private static final UInt64Value DEFAULT_INSTANCE;
    private static volatile N0 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;

    static {
        UInt64Value uInt64Value = new UInt64Value();
        DEFAULT_INSTANCE = uInt64Value;
        AbstractC3169a0.registerDefaultInstance(UInt64Value.class, uInt64Value);
    }

    private UInt64Value() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0L;
    }

    public static UInt64Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C3206m1 newBuilder() {
        return (C3206m1) DEFAULT_INSTANCE.createBuilder();
    }

    public static UInt64Value of(long j) {
        C3206m1 c3206m1NewBuilder = newBuilder();
        c3206m1NewBuilder.c();
        ((UInt64Value) c3206m1NewBuilder.b).setValue(j);
        return (UInt64Value) c3206m1NewBuilder.a();
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UInt64Value) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt64Value parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static N0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(long j) {
        this.value_ = j;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
    public final Object dynamicMethod(Z z, Object obj, Object obj2) {
        switch (AbstractC3203l1.f2290a[z.ordinal()]) {
            case 1:
                return new UInt64Value();
            case 2:
                return new C3206m1();
            case 3:
                return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0003", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                N0 v = PARSER;
                if (v == null) {
                    synchronized (UInt64Value.class) {
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

    public long getValue() {
        return this.value_;
    }

    public static C3206m1 newBuilder(UInt64Value uInt64Value) {
        return (C3206m1) DEFAULT_INSTANCE.createBuilder(uInt64Value);
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
        return (UInt64Value) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static UInt64Value parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
    }

    public static UInt64Value parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
    }

    public static UInt64Value parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
    }

    public static UInt64Value parseFrom(byte[] bArr) throws C3211o0 {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UInt64Value parseFrom(byte[] bArr, H h) throws C3211o0 {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
    }

    public static UInt64Value parseFrom(InputStream inputStream) throws IOException {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt64Value parseFrom(InputStream inputStream, H h) throws IOException {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static UInt64Value parseFrom(AbstractC3229w abstractC3229w) throws IOException {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
    }

    public static UInt64Value parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
        return (UInt64Value) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
    }
}

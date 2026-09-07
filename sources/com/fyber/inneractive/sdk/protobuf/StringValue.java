package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class StringValue extends AbstractC3169a0 implements F0 {
    private static final StringValue DEFAULT_INSTANCE;
    private static volatile N0 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private String value_ = "";

    static {
        StringValue stringValue = new StringValue();
        DEFAULT_INSTANCE = stringValue;
        AbstractC3169a0.registerDefaultInstance(StringValue.class, stringValue);
    }

    private StringValue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    public static StringValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C3191h1 newBuilder() {
        return (C3191h1) DEFAULT_INSTANCE.createBuilder();
    }

    public static StringValue of(String str) {
        C3191h1 c3191h1NewBuilder = newBuilder();
        c3191h1NewBuilder.c();
        ((StringValue) c3191h1NewBuilder.b).setValue(str);
        return (StringValue) c3191h1NewBuilder.a();
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StringValue) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StringValue parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static N0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueBytes(AbstractC3221s abstractC3221s) {
        abstractC3221s.getClass();
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.value_ = abstractC3221s.f();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
    public final Object dynamicMethod(Z z, Object obj, Object obj2) {
        switch (AbstractC3188g1.f2285a[z.ordinal()]) {
            case 1:
                return new StringValue();
            case 2:
                return new C3191h1();
            case 3:
                return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                N0 v = PARSER;
                if (v == null) {
                    synchronized (StringValue.class) {
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

    public String getValue() {
        return this.value_;
    }

    public AbstractC3221s getValueBytes() {
        return AbstractC3221s.a(this.value_);
    }

    public static C3191h1 newBuilder(StringValue stringValue) {
        return (C3191h1) DEFAULT_INSTANCE.createBuilder(stringValue);
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
        return (StringValue) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static StringValue parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
    }

    public static StringValue parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
    }

    public static StringValue parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
    }

    public static StringValue parseFrom(byte[] bArr) throws C3211o0 {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StringValue parseFrom(byte[] bArr, H h) throws C3211o0 {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
    }

    public static StringValue parseFrom(InputStream inputStream) throws IOException {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StringValue parseFrom(InputStream inputStream, H h) throws IOException {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static StringValue parseFrom(AbstractC3229w abstractC3229w) throws IOException {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
    }

    public static StringValue parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
        return (StringValue) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
    }
}

package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.protobuf.AbstractC3169a0;
import com.fyber.inneractive.sdk.protobuf.AbstractC3171b;
import com.fyber.inneractive.sdk.protobuf.AbstractC3221s;
import com.fyber.inneractive.sdk.protobuf.AbstractC3229w;
import com.fyber.inneractive.sdk.protobuf.C3211o0;
import com.fyber.inneractive.sdk.protobuf.F0;
import com.fyber.inneractive.sdk.protobuf.H;
import com.fyber.inneractive.sdk.protobuf.N0;
import com.fyber.inneractive.sdk.protobuf.V;
import com.fyber.inneractive.sdk.protobuf.Z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes11.dex */
public final class IgniteResponseOuterClass$IgniteResponse extends AbstractC3169a0 implements F0 {
    public static final int CLIENTID_FIELD_NUMBER = 1;
    public static final int CLIENTSECRET_FIELD_NUMBER = 2;
    private static final IgniteResponseOuterClass$IgniteResponse DEFAULT_INSTANCE;
    private static volatile N0 PARSER;
    private int bitField0_;
    private String clientId_ = "";
    private String clientSecret_ = "";

    static {
        IgniteResponseOuterClass$IgniteResponse igniteResponseOuterClass$IgniteResponse = new IgniteResponseOuterClass$IgniteResponse();
        DEFAULT_INSTANCE = igniteResponseOuterClass$IgniteResponse;
        AbstractC3169a0.registerDefaultInstance(IgniteResponseOuterClass$IgniteResponse.class, igniteResponseOuterClass$IgniteResponse);
    }

    private IgniteResponseOuterClass$IgniteResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientId() {
        this.bitField0_ &= -2;
        this.clientId_ = getDefaultInstance().getClientId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientSecret() {
        this.bitField0_ &= -3;
        this.clientSecret_ = getDefaultInstance().getClientSecret();
    }

    public static IgniteResponseOuterClass$IgniteResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static q newBuilder() {
        return (q) DEFAULT_INSTANCE.createBuilder();
    }

    public static IgniteResponseOuterClass$IgniteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static N0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.clientId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.clientId_ = abstractC3221s.f();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientSecret(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.clientSecret_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientSecretBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.clientSecret_ = abstractC3221s.f();
        this.bitField0_ |= 2;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
    public final Object dynamicMethod(Z z, Object obj, Object obj2) {
        switch (p.f1853a[z.ordinal()]) {
            case 1:
                return new IgniteResponseOuterClass$IgniteResponse();
            case 2:
                return new q();
            case 3:
                return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"bitField0_", "clientId_", "clientSecret_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                N0 v = PARSER;
                if (v == null) {
                    synchronized (IgniteResponseOuterClass$IgniteResponse.class) {
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

    public String getClientId() {
        return this.clientId_;
    }

    public AbstractC3221s getClientIdBytes() {
        return AbstractC3221s.a(this.clientId_);
    }

    public String getClientSecret() {
        return this.clientSecret_;
    }

    public AbstractC3221s getClientSecretBytes() {
        return AbstractC3221s.a(this.clientSecret_);
    }

    public boolean hasClientId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasClientSecret() {
        return (this.bitField0_ & 2) != 0;
    }

    public static q newBuilder(IgniteResponseOuterClass$IgniteResponse igniteResponseOuterClass$IgniteResponse) {
        return (q) DEFAULT_INSTANCE.createBuilder(igniteResponseOuterClass$IgniteResponse);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(byte[] bArr) throws C3211o0 {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(byte[] bArr, H h) throws C3211o0 {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(InputStream inputStream) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(InputStream inputStream, H h) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(AbstractC3229w abstractC3229w) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
    }

    public static IgniteResponseOuterClass$IgniteResponse parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
        return (IgniteResponseOuterClass$IgniteResponse) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
    }
}

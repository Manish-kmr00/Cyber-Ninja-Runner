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

/* JADX INFO: loaded from: classes.dex */
public final class IgniteRequestOuterClass$IgniteRequest extends AbstractC3169a0 implements F0 {
    public static final int APPID_FIELD_NUMBER = 1;
    public static final int APPSIGNATURE_FIELD_NUMBER = 3;
    public static final int BUNDLE_FIELD_NUMBER = 2;
    private static final IgniteRequestOuterClass$IgniteRequest DEFAULT_INSTANCE;
    public static final int IGNITEPACKAGENAME_FIELD_NUMBER = 4;
    public static final int IGNITEVERSIONNAME_FIELD_NUMBER = 5;
    private static volatile N0 PARSER = null;
    public static final int SDKVERSION_FIELD_NUMBER = 6;
    private int bitField0_;
    private String appId_ = "";
    private String bundle_ = "";
    private String appSignature_ = "";
    private String ignitePackageName_ = "";
    private String igniteVersionName_ = "";
    private String sdkVersion_ = "";

    static {
        IgniteRequestOuterClass$IgniteRequest igniteRequestOuterClass$IgniteRequest = new IgniteRequestOuterClass$IgniteRequest();
        DEFAULT_INSTANCE = igniteRequestOuterClass$IgniteRequest;
        AbstractC3169a0.registerDefaultInstance(IgniteRequestOuterClass$IgniteRequest.class, igniteRequestOuterClass$IgniteRequest);
    }

    private IgniteRequestOuterClass$IgniteRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppId() {
        this.bitField0_ &= -2;
        this.appId_ = getDefaultInstance().getAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppSignature() {
        this.bitField0_ &= -5;
        this.appSignature_ = getDefaultInstance().getAppSignature();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBundle() {
        this.bitField0_ &= -3;
        this.bundle_ = getDefaultInstance().getBundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIgnitePackageName() {
        this.bitField0_ &= -9;
        this.ignitePackageName_ = getDefaultInstance().getIgnitePackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIgniteVersionName() {
        this.bitField0_ &= -17;
        this.igniteVersionName_ = getDefaultInstance().getIgniteVersionName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSdkVersion() {
        this.bitField0_ &= -33;
        this.sdkVersion_ = getDefaultInstance().getSdkVersion();
    }

    public static IgniteRequestOuterClass$IgniteRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static o newBuilder() {
        return (o) DEFAULT_INSTANCE.createBuilder();
    }

    public static IgniteRequestOuterClass$IgniteRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static N0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.appId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.appId_ = abstractC3221s.f();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppSignature(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.appSignature_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppSignatureBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.appSignature_ = abstractC3221s.f();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBundle(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.bundle_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBundleBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.bundle_ = abstractC3221s.f();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgnitePackageName(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.ignitePackageName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgnitePackageNameBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.ignitePackageName_ = abstractC3221s.f();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteVersionName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.igniteVersionName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteVersionNameBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.igniteVersionName_ = abstractC3221s.f();
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkVersion(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.sdkVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkVersionBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.sdkVersion_ = abstractC3221s.f();
        this.bitField0_ |= 32;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
    public final Object dynamicMethod(Z z, Object obj, Object obj2) {
        switch (n.f1852a[z.ordinal()]) {
            case 1:
                return new IgniteRequestOuterClass$IgniteRequest();
            case 2:
                return new o();
            case 3:
                return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005", new Object[]{"bitField0_", "appId_", "bundle_", "appSignature_", "ignitePackageName_", "igniteVersionName_", "sdkVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                N0 v = PARSER;
                if (v == null) {
                    synchronized (IgniteRequestOuterClass$IgniteRequest.class) {
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

    public String getAppId() {
        return this.appId_;
    }

    public AbstractC3221s getAppIdBytes() {
        return AbstractC3221s.a(this.appId_);
    }

    public String getAppSignature() {
        return this.appSignature_;
    }

    public AbstractC3221s getAppSignatureBytes() {
        return AbstractC3221s.a(this.appSignature_);
    }

    public String getBundle() {
        return this.bundle_;
    }

    public AbstractC3221s getBundleBytes() {
        return AbstractC3221s.a(this.bundle_);
    }

    public String getIgnitePackageName() {
        return this.ignitePackageName_;
    }

    public AbstractC3221s getIgnitePackageNameBytes() {
        return AbstractC3221s.a(this.ignitePackageName_);
    }

    public String getIgniteVersionName() {
        return this.igniteVersionName_;
    }

    public AbstractC3221s getIgniteVersionNameBytes() {
        return AbstractC3221s.a(this.igniteVersionName_);
    }

    public String getSdkVersion() {
        return this.sdkVersion_;
    }

    public AbstractC3221s getSdkVersionBytes() {
        return AbstractC3221s.a(this.sdkVersion_);
    }

    public boolean hasAppId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasAppSignature() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasBundle() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIgnitePackageName() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasIgniteVersionName() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasSdkVersion() {
        return (this.bitField0_ & 32) != 0;
    }

    public static o newBuilder(IgniteRequestOuterClass$IgniteRequest igniteRequestOuterClass$IgniteRequest) {
        return (o) DEFAULT_INSTANCE.createBuilder(igniteRequestOuterClass$IgniteRequest);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(byte[] bArr) throws C3211o0 {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(byte[] bArr, H h) throws C3211o0 {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(InputStream inputStream) throws IOException {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(InputStream inputStream, H h) throws IOException {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(AbstractC3229w abstractC3229w) throws IOException {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
    }

    public static IgniteRequestOuterClass$IgniteRequest parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
        return (IgniteRequestOuterClass$IgniteRequest) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
    }
}

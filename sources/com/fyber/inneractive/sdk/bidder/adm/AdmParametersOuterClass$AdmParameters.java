package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.protobuf.AbstractC3169a0;
import com.fyber.inneractive.sdk.protobuf.AbstractC3171b;
import com.fyber.inneractive.sdk.protobuf.AbstractC3174c;
import com.fyber.inneractive.sdk.protobuf.AbstractC3221s;
import com.fyber.inneractive.sdk.protobuf.AbstractC3229w;
import com.fyber.inneractive.sdk.protobuf.C3211o0;
import com.fyber.inneractive.sdk.protobuf.F0;
import com.fyber.inneractive.sdk.protobuf.H;
import com.fyber.inneractive.sdk.protobuf.InterfaceC3202l0;
import com.fyber.inneractive.sdk.protobuf.N0;
import com.fyber.inneractive.sdk.protobuf.U;
import com.fyber.inneractive.sdk.protobuf.V;
import com.fyber.inneractive.sdk.protobuf.Z;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AdmParametersOuterClass$AdmParameters extends AbstractC3169a0 implements F0 {
    public static final int ABEXPERIMENTS_FIELD_NUMBER = 33;
    public static final int ADCOMPLETIONURL_FIELD_NUMBER = 24;
    public static final int ADDOMAIN_FIELD_NUMBER = 29;
    public static final int ADDURATION_FIELD_NUMBER = 25;
    public static final int ADEXPIRATIONINTERVAL_FIELD_NUMBER = 13;
    public static final int ADHEIGHT_FIELD_NUMBER = 5;
    public static final int ADNETWORKID_FIELD_NUMBER = 12;
    public static final int ADNETWORKNAME_FIELD_NUMBER = 11;
    public static final int ADTYPE_FIELD_NUMBER = 14;
    public static final int ADUNITDISPLAYTYPE_FIELD_NUMBER = 8;
    public static final int ADUNITID_FIELD_NUMBER = 6;
    public static final int ADUNITTYPE_FIELD_NUMBER = 7;
    public static final int ADVERTISEDAPPID_FIELD_NUMBER = 18;
    public static final int ADWIDTH_FIELD_NUMBER = 4;
    public static final int APPBUNDLEID_FIELD_NUMBER = 23;
    public static final int ATTRIBUTIONCLICKURL_FIELD_NUMBER = 45;
    public static final int ATTRIBUTIONIMPRESSIONURL_FIELD_NUMBER = 44;
    public static final int AUTOSTOREKITSTATE_FIELD_NUMBER = 42;
    public static final int BRANDBIDDERCTATEXT_FIELD_NUMBER = 40;
    public static final int BRANDBIDDERDONTSHOWENDCARD_FIELD_NUMBER = 39;
    public static final int CAMPAIGNID_FIELD_NUMBER = 31;
    public static final int CONTENTID_FIELD_NUMBER = 9;
    public static final int CREATIVEID_FIELD_NUMBER = 30;
    public static final int CREATIVETYPE_FIELD_NUMBER = 26;
    public static final int CUSTOMPRODUCTPAGEID_FIELD_NUMBER = 43;
    private static final AdmParametersOuterClass$AdmParameters DEFAULT_INSTANCE;
    public static final int ERRORMESSAGE_FIELD_NUMBER = 3;
    public static final int IGNITEINSTALLURL_FIELD_NUMBER = 36;
    public static final int IGNITELAUNCHERACTIVITY_FIELD_NUMBER = 37;
    public static final int IGNITEMODE_FIELD_NUMBER = 35;
    public static final int MARKUPURL_FIELD_NUMBER = 1;
    public static final int MRAIDVIDEOOMSIGNAL_FIELD_NUMBER = 41;
    public static final int MRCDATA_FIELD_NUMBER = 32;
    private static volatile N0 PARSER = null;
    public static final int PRICINGVALUE_FIELD_NUMBER = 28;
    public static final int PUBLISHERID_FIELD_NUMBER = 10;
    public static final int SDKCLICKURL_FIELD_NUMBER = 16;
    public static final int SDKIMPRESSIONURL_FIELD_NUMBER = 15;
    public static final int SESSIONID_FIELD_NUMBER = 2;
    public static final int SKADNETWORKDATA_FIELD_NUMBER = 27;
    public static final int SKIPMODE_FIELD_NUMBER = 22;
    public static final int SKOVERLAYDATA_FIELD_NUMBER = 38;
    public static final int SPOTID_FIELD_NUMBER = 34;
    public static final int STORECTATEXT_FIELD_NUMBER = 21;
    public static final int STOREEVENTURL_FIELD_NUMBER = 20;
    public static final int STOREURLTYPE_FIELD_NUMBER = 19;
    public static final int STOREURL_FIELD_NUMBER = 17;
    private int adDuration_;
    private int adExpirationInterval_;
    private int adHeight_;
    private long adNetworkId_;
    private int adType_;
    private int adUnitDisplayType_;
    private int adUnitType_;
    private int adWidth_;
    private int autoStorekitState_;
    private int bitField0_;
    private int bitField1_;
    private boolean brandBidderDontShowEndcard_;
    private long contentId_;
    private int igniteMode_;
    private boolean mraidVideoOMSignal_;
    private MRCData mrcData_;
    private double pricingValue_;
    private long publisherId_;
    private SKAdNetworkData skAdNetworkData_;
    private SKOverlayData skOverlayData_;
    private boolean skipMode_;
    private long spotId_;
    private int storeUrlType_;
    private String markupUrl_ = "";
    private String sessionId_ = "";
    private String errorMessage_ = "";
    private String adUnitId_ = "";
    private String adNetworkName_ = "";
    private String sdkImpressionUrl_ = "";
    private String sdkClickUrl_ = "";
    private String storeUrl_ = "";
    private String advertisedAppId_ = "";
    private String storeEventUrl_ = "";
    private String storeCTAText_ = "";
    private String appBundleId_ = "";
    private String adCompletionUrl_ = "";
    private String creativeType_ = "";
    private String adDomain_ = "";
    private String creativeId_ = "";
    private String campaignId_ = "";
    private InterfaceC3202l0 abExperiments_ = AbstractC3169a0.emptyProtobufList();
    private String igniteInstallUrl_ = "";
    private String igniteLauncherActivity_ = "";
    private String brandBidderCtaText_ = "";
    private String customProductPageId_ = "";
    private String attributionImpressionUrl_ = "";
    private String attributionClickUrl_ = "";

    public static final class Experiment extends AbstractC3169a0 implements l {
        private static final Experiment DEFAULT_INSTANCE;
        public static final int IDENTIFIER_FIELD_NUMBER = 1;
        private static volatile N0 PARSER = null;
        public static final int VARIANT_FIELD_NUMBER = 2;
        private int bitField0_;
        private String identifier_ = "";
        private String variant_ = "";

        static {
            Experiment experiment = new Experiment();
            DEFAULT_INSTANCE = experiment;
            AbstractC3169a0.registerDefaultInstance(Experiment.class, experiment);
        }

        private Experiment() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdentifier() {
            this.bitField0_ &= -2;
            this.identifier_ = getDefaultInstance().getIdentifier();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVariant() {
            this.bitField0_ &= -3;
            this.variant_ = getDefaultInstance().getVariant();
        }

        public static Experiment getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static k newBuilder() {
            return (k) DEFAULT_INSTANCE.createBuilder();
        }

        public static Experiment parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Experiment) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Experiment parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static N0 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifier(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.identifier_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifierBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.identifier_ = abstractC3221s.f();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVariant(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.variant_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVariantBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.variant_ = abstractC3221s.f();
            this.bitField0_ |= 2;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
        public final Object dynamicMethod(Z z, Object obj, Object obj2) {
            switch (a.f1621a[z.ordinal()]) {
                case 1:
                    return new Experiment();
                case 2:
                    return new k();
                case 3:
                    return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"bitField0_", "identifier_", "variant_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    N0 v = PARSER;
                    if (v == null) {
                        synchronized (Experiment.class) {
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

        public String getIdentifier() {
            return this.identifier_;
        }

        public AbstractC3221s getIdentifierBytes() {
            return AbstractC3221s.a(this.identifier_);
        }

        public String getVariant() {
            return this.variant_;
        }

        public AbstractC3221s getVariantBytes() {
            return AbstractC3221s.a(this.variant_);
        }

        public boolean hasIdentifier() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasVariant() {
            return (this.bitField0_ & 2) != 0;
        }

        public static k newBuilder(Experiment experiment) {
            return (k) DEFAULT_INSTANCE.createBuilder(experiment);
        }

        public static Experiment parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
            return (Experiment) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static Experiment parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
        }

        public static Experiment parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
        }

        public static Experiment parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
        }

        public static Experiment parseFrom(byte[] bArr) throws C3211o0 {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Experiment parseFrom(byte[] bArr, H h) throws C3211o0 {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
        }

        public static Experiment parseFrom(InputStream inputStream) throws IOException {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Experiment parseFrom(InputStream inputStream, H h) throws IOException {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static Experiment parseFrom(AbstractC3229w abstractC3229w) throws IOException {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
        }

        public static Experiment parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
            return (Experiment) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
        }
    }

    public static final class MRCData extends AbstractC3169a0 implements F0 {
        private static final MRCData DEFAULT_INSTANCE;
        private static volatile N0 PARSER = null;
        public static final int PIXELDURATION_FIELD_NUMBER = 2;
        public static final int PIXELIMPRESSIONURL_FIELD_NUMBER = 3;
        public static final int PIXELPERCENT_FIELD_NUMBER = 1;
        private int bitField0_;
        private int pixelDuration_;
        private String pixelImpressionUrl_ = "";
        private int pixelPercent_;

        static {
            MRCData mRCData = new MRCData();
            DEFAULT_INSTANCE = mRCData;
            AbstractC3169a0.registerDefaultInstance(MRCData.class, mRCData);
        }

        private MRCData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPixelDuration() {
            this.bitField0_ &= -3;
            this.pixelDuration_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPixelImpressionUrl() {
            this.bitField0_ &= -5;
            this.pixelImpressionUrl_ = getDefaultInstance().getPixelImpressionUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPixelPercent() {
            this.bitField0_ &= -2;
            this.pixelPercent_ = 0;
        }

        public static MRCData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static o newBuilder() {
            return (o) DEFAULT_INSTANCE.createBuilder();
        }

        public static MRCData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MRCData) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MRCData parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static N0 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPixelDuration(int i) {
            this.bitField0_ |= 2;
            this.pixelDuration_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPixelImpressionUrl(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.pixelImpressionUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPixelImpressionUrlBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.pixelImpressionUrl_ = abstractC3221s.f();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPixelPercent(int i) {
            this.bitField0_ |= 1;
            this.pixelPercent_ = i;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
        public final Object dynamicMethod(Z z, Object obj, Object obj2) {
            switch (a.f1621a[z.ordinal()]) {
                case 1:
                    return new MRCData();
                case 2:
                    return new o();
                case 3:
                    return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ለ\u0002", new Object[]{"bitField0_", "pixelPercent_", "pixelDuration_", "pixelImpressionUrl_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    N0 v = PARSER;
                    if (v == null) {
                        synchronized (MRCData.class) {
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

        public int getPixelDuration() {
            return this.pixelDuration_;
        }

        public String getPixelImpressionUrl() {
            return this.pixelImpressionUrl_;
        }

        public AbstractC3221s getPixelImpressionUrlBytes() {
            return AbstractC3221s.a(this.pixelImpressionUrl_);
        }

        public int getPixelPercent() {
            return this.pixelPercent_;
        }

        public boolean hasPixelDuration() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasPixelImpressionUrl() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasPixelPercent() {
            return (this.bitField0_ & 1) != 0;
        }

        public static o newBuilder(MRCData mRCData) {
            return (o) DEFAULT_INSTANCE.createBuilder(mRCData);
        }

        public static MRCData parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
            return (MRCData) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static MRCData parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
        }

        public static MRCData parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
        }

        public static MRCData parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
        }

        public static MRCData parseFrom(byte[] bArr) throws C3211o0 {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MRCData parseFrom(byte[] bArr, H h) throws C3211o0 {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
        }

        public static MRCData parseFrom(InputStream inputStream) throws IOException {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MRCData parseFrom(InputStream inputStream, H h) throws IOException {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static MRCData parseFrom(AbstractC3229w abstractC3229w) throws IOException {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
        }

        public static MRCData parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
            return (MRCData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
        }
    }

    public static final class SKAdNetworkData extends AbstractC3169a0 implements F0 {
        private static final SKAdNetworkData DEFAULT_INSTANCE;
        private static volatile N0 PARSER = null;
        public static final int SKADNBUNDLE_FIELD_NUMBER = 4;
        public static final int SKADNCAMPIGN_FIELD_NUMBER = 3;
        public static final int SKADNETWORKID_FIELD_NUMBER = 2;
        public static final int SKADNID_FIELD_NUMBER = 5;
        public static final int SKADNIMPID_FIELD_NUMBER = 6;
        public static final int SKADNIMPSIGNATURE_FIELD_NUMBER = 10;
        public static final int SKADNIMPTIMESTAMP_FIELD_NUMBER = 9;
        public static final int SKADNSIGNATURE_FIELD_NUMBER = 11;
        public static final int SKADNSOURCEAPP_FIELD_NUMBER = 7;
        public static final int SKADNTIMESTAMP_FIELD_NUMBER = 8;
        public static final int SKADNVERSION_FIELD_NUMBER = 1;
        private int bitField0_;
        private long skAdnImpTimestamp_;
        private long skAdnSourceApp_;
        private long skAdnTimestamp_;
        private String skAdnVersion_ = "";
        private String skAdNetworkId_ = "";
        private String skAdnCampign_ = "";
        private String skAdnBundle_ = "";
        private String skAdnId_ = "";
        private String skAdnImpId_ = "";
        private String skAdnImpSignature_ = "";
        private String skAdnSignature_ = "";

        static {
            SKAdNetworkData sKAdNetworkData = new SKAdNetworkData();
            DEFAULT_INSTANCE = sKAdNetworkData;
            AbstractC3169a0.registerDefaultInstance(SKAdNetworkData.class, sKAdNetworkData);
        }

        private SKAdNetworkData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdNetworkId() {
            this.bitField0_ &= -3;
            this.skAdNetworkId_ = getDefaultInstance().getSkAdNetworkId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnBundle() {
            this.bitField0_ &= -9;
            this.skAdnBundle_ = getDefaultInstance().getSkAdnBundle();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnCampign() {
            this.bitField0_ &= -5;
            this.skAdnCampign_ = getDefaultInstance().getSkAdnCampign();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnId() {
            this.bitField0_ &= -17;
            this.skAdnId_ = getDefaultInstance().getSkAdnId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnImpId() {
            this.bitField0_ &= -33;
            this.skAdnImpId_ = getDefaultInstance().getSkAdnImpId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnImpSignature() {
            this.bitField0_ &= -513;
            this.skAdnImpSignature_ = getDefaultInstance().getSkAdnImpSignature();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnImpTimestamp() {
            this.bitField0_ &= -257;
            this.skAdnImpTimestamp_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnSignature() {
            this.bitField0_ &= -1025;
            this.skAdnSignature_ = getDefaultInstance().getSkAdnSignature();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnSourceApp() {
            this.bitField0_ &= -65;
            this.skAdnSourceApp_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnTimestamp() {
            this.bitField0_ &= -129;
            this.skAdnTimestamp_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkAdnVersion() {
            this.bitField0_ &= -2;
            this.skAdnVersion_ = getDefaultInstance().getSkAdnVersion();
        }

        public static SKAdNetworkData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static p newBuilder() {
            return (p) DEFAULT_INSTANCE.createBuilder();
        }

        public static SKAdNetworkData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SKAdNetworkData) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SKAdNetworkData parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static N0 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdNetworkId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.skAdNetworkId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdNetworkIdBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdNetworkId_ = abstractC3221s.f();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnBundle(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.skAdnBundle_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnBundleBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnBundle_ = abstractC3221s.f();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnCampign(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.skAdnCampign_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnCampignBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnCampign_ = abstractC3221s.f();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnId(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.skAdnId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnIdBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnId_ = abstractC3221s.f();
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnImpId(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.skAdnImpId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnImpIdBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnImpId_ = abstractC3221s.f();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnImpSignature(String str) {
            str.getClass();
            this.bitField0_ |= 512;
            this.skAdnImpSignature_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnImpSignatureBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnImpSignature_ = abstractC3221s.f();
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnImpTimestamp(long j) {
            this.bitField0_ |= 256;
            this.skAdnImpTimestamp_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnSignature(String str) {
            str.getClass();
            this.bitField0_ |= 1024;
            this.skAdnSignature_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnSignatureBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnSignature_ = abstractC3221s.f();
            this.bitField0_ |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnSourceApp(long j) {
            this.bitField0_ |= 64;
            this.skAdnSourceApp_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnTimestamp(long j) {
            this.bitField0_ |= 128;
            this.skAdnTimestamp_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnVersion(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.skAdnVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkAdnVersionBytes(AbstractC3221s abstractC3221s) {
            AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
            this.skAdnVersion_ = abstractC3221s.f();
            this.bitField0_ |= 1;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
        public final Object dynamicMethod(Z z, Object obj, Object obj2) {
            switch (a.f1621a[z.ordinal()]) {
                case 1:
                    return new SKAdNetworkData();
                case 2:
                    return new p();
                case 3:
                    return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007ဃ\u0006\bဃ\u0007\tတ\b\nለ\t\u000bለ\n", new Object[]{"bitField0_", "skAdnVersion_", "skAdNetworkId_", "skAdnCampign_", "skAdnBundle_", "skAdnId_", "skAdnImpId_", "skAdnSourceApp_", "skAdnTimestamp_", "skAdnImpTimestamp_", "skAdnImpSignature_", "skAdnSignature_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    N0 v = PARSER;
                    if (v == null) {
                        synchronized (SKAdNetworkData.class) {
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

        public String getSkAdNetworkId() {
            return this.skAdNetworkId_;
        }

        public AbstractC3221s getSkAdNetworkIdBytes() {
            return AbstractC3221s.a(this.skAdNetworkId_);
        }

        public String getSkAdnBundle() {
            return this.skAdnBundle_;
        }

        public AbstractC3221s getSkAdnBundleBytes() {
            return AbstractC3221s.a(this.skAdnBundle_);
        }

        public String getSkAdnCampign() {
            return this.skAdnCampign_;
        }

        public AbstractC3221s getSkAdnCampignBytes() {
            return AbstractC3221s.a(this.skAdnCampign_);
        }

        public String getSkAdnId() {
            return this.skAdnId_;
        }

        public AbstractC3221s getSkAdnIdBytes() {
            return AbstractC3221s.a(this.skAdnId_);
        }

        public String getSkAdnImpId() {
            return this.skAdnImpId_;
        }

        public AbstractC3221s getSkAdnImpIdBytes() {
            return AbstractC3221s.a(this.skAdnImpId_);
        }

        public String getSkAdnImpSignature() {
            return this.skAdnImpSignature_;
        }

        public AbstractC3221s getSkAdnImpSignatureBytes() {
            return AbstractC3221s.a(this.skAdnImpSignature_);
        }

        public long getSkAdnImpTimestamp() {
            return this.skAdnImpTimestamp_;
        }

        public String getSkAdnSignature() {
            return this.skAdnSignature_;
        }

        public AbstractC3221s getSkAdnSignatureBytes() {
            return AbstractC3221s.a(this.skAdnSignature_);
        }

        public long getSkAdnSourceApp() {
            return this.skAdnSourceApp_;
        }

        public long getSkAdnTimestamp() {
            return this.skAdnTimestamp_;
        }

        public String getSkAdnVersion() {
            return this.skAdnVersion_;
        }

        public AbstractC3221s getSkAdnVersionBytes() {
            return AbstractC3221s.a(this.skAdnVersion_);
        }

        public boolean hasSkAdNetworkId() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasSkAdnBundle() {
            return (this.bitField0_ & 8) != 0;
        }

        public boolean hasSkAdnCampign() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasSkAdnId() {
            return (this.bitField0_ & 16) != 0;
        }

        public boolean hasSkAdnImpId() {
            return (this.bitField0_ & 32) != 0;
        }

        public boolean hasSkAdnImpSignature() {
            return (this.bitField0_ & 512) != 0;
        }

        public boolean hasSkAdnImpTimestamp() {
            return (this.bitField0_ & 256) != 0;
        }

        public boolean hasSkAdnSignature() {
            return (this.bitField0_ & 1024) != 0;
        }

        public boolean hasSkAdnSourceApp() {
            return (this.bitField0_ & 64) != 0;
        }

        public boolean hasSkAdnTimestamp() {
            return (this.bitField0_ & 128) != 0;
        }

        public boolean hasSkAdnVersion() {
            return (this.bitField0_ & 1) != 0;
        }

        public static p newBuilder(SKAdNetworkData sKAdNetworkData) {
            return (p) DEFAULT_INSTANCE.createBuilder(sKAdNetworkData);
        }

        public static SKAdNetworkData parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
            return (SKAdNetworkData) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static SKAdNetworkData parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
        }

        public static SKAdNetworkData parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
        }

        public static SKAdNetworkData parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
        }

        public static SKAdNetworkData parseFrom(byte[] bArr) throws C3211o0 {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SKAdNetworkData parseFrom(byte[] bArr, H h) throws C3211o0 {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
        }

        public static SKAdNetworkData parseFrom(InputStream inputStream) throws IOException {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SKAdNetworkData parseFrom(InputStream inputStream, H h) throws IOException {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static SKAdNetworkData parseFrom(AbstractC3229w abstractC3229w) throws IOException {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
        }

        public static SKAdNetworkData parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
            return (SKAdNetworkData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
        }
    }

    public static final class SKOverlayData extends AbstractC3169a0 implements F0 {
        private static final SKOverlayData DEFAULT_INSTANCE;
        private static volatile N0 PARSER = null;
        public static final int SKOVERLAYAUTOCLICK_FIELD_NUMBER = 7;
        public static final int SKOVERLAYAUTOCLOSE_FIELD_NUMBER = 4;
        public static final int SKOVERLAYDELAY_FIELD_NUMBER = 2;
        public static final int SKOVERLAYDISMISSIBLE_FIELD_NUMBER = 5;
        public static final int SKOVERLAYENDCARDDELAY_FIELD_NUMBER = 6;
        public static final int SKOVERLAYENDCARD_FIELD_NUMBER = 3;
        public static final int SKOVERLAYPOSITION_FIELD_NUMBER = 1;
        private int bitField0_;
        private boolean skOverlayAutoclick_;
        private int skOverlayAutoclose_;
        private int skOverlayDelay_;
        private int skOverlayDismissible_;
        private int skOverlayEndcardDelay_;
        private int skOverlayEndcard_;
        private int skOverlayPosition_;

        static {
            SKOverlayData sKOverlayData = new SKOverlayData();
            DEFAULT_INSTANCE = sKOverlayData;
            AbstractC3169a0.registerDefaultInstance(SKOverlayData.class, sKOverlayData);
        }

        private SKOverlayData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayAutoclick() {
            this.bitField0_ &= -65;
            this.skOverlayAutoclick_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayAutoclose() {
            this.bitField0_ &= -9;
            this.skOverlayAutoclose_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayDelay() {
            this.bitField0_ &= -3;
            this.skOverlayDelay_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayDismissible() {
            this.bitField0_ &= -17;
            this.skOverlayDismissible_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayEndcard() {
            this.bitField0_ &= -5;
            this.skOverlayEndcard_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayEndcardDelay() {
            this.bitField0_ &= -33;
            this.skOverlayEndcardDelay_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSkOverlayPosition() {
            this.bitField0_ &= -2;
            this.skOverlayPosition_ = 0;
        }

        public static SKOverlayData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static q newBuilder() {
            return (q) DEFAULT_INSTANCE.createBuilder();
        }

        public static SKOverlayData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SKOverlayData) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SKOverlayData parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static N0 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayAutoclick(boolean z) {
            this.bitField0_ |= 64;
            this.skOverlayAutoclick_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayAutoclose(int i) {
            this.bitField0_ |= 8;
            this.skOverlayAutoclose_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayDelay(int i) {
            this.bitField0_ |= 2;
            this.skOverlayDelay_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayDismissible(int i) {
            this.bitField0_ |= 16;
            this.skOverlayDismissible_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayEndcard(int i) {
            this.bitField0_ |= 4;
            this.skOverlayEndcard_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayEndcardDelay(int i) {
            this.bitField0_ |= 32;
            this.skOverlayEndcardDelay_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSkOverlayPosition(int i) {
            this.bitField0_ |= 1;
            this.skOverlayPosition_ = i;
        }

        @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
        public final Object dynamicMethod(Z z, Object obj, Object obj2) {
            switch (a.f1621a[z.ordinal()]) {
                case 1:
                    return new SKOverlayData();
                case 2:
                    return new q();
                case 3:
                    return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဋ\u0000\u0002င\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"bitField0_", "skOverlayPosition_", "skOverlayDelay_", "skOverlayEndcard_", "skOverlayAutoclose_", "skOverlayDismissible_", "skOverlayEndcardDelay_", "skOverlayAutoclick_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    N0 v = PARSER;
                    if (v == null) {
                        synchronized (SKOverlayData.class) {
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

        public boolean getSkOverlayAutoclick() {
            return this.skOverlayAutoclick_;
        }

        public int getSkOverlayAutoclose() {
            return this.skOverlayAutoclose_;
        }

        public int getSkOverlayDelay() {
            return this.skOverlayDelay_;
        }

        public int getSkOverlayDismissible() {
            return this.skOverlayDismissible_;
        }

        public int getSkOverlayEndcard() {
            return this.skOverlayEndcard_;
        }

        public int getSkOverlayEndcardDelay() {
            return this.skOverlayEndcardDelay_;
        }

        public int getSkOverlayPosition() {
            return this.skOverlayPosition_;
        }

        public boolean hasSkOverlayAutoclick() {
            return (this.bitField0_ & 64) != 0;
        }

        public boolean hasSkOverlayAutoclose() {
            return (this.bitField0_ & 8) != 0;
        }

        public boolean hasSkOverlayDelay() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasSkOverlayDismissible() {
            return (this.bitField0_ & 16) != 0;
        }

        public boolean hasSkOverlayEndcard() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasSkOverlayEndcardDelay() {
            return (this.bitField0_ & 32) != 0;
        }

        public boolean hasSkOverlayPosition() {
            return (this.bitField0_ & 1) != 0;
        }

        public static q newBuilder(SKOverlayData sKOverlayData) {
            return (q) DEFAULT_INSTANCE.createBuilder(sKOverlayData);
        }

        public static SKOverlayData parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
            return (SKOverlayData) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static SKOverlayData parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
        }

        public static SKOverlayData parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
        }

        public static SKOverlayData parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
        }

        public static SKOverlayData parseFrom(byte[] bArr) throws C3211o0 {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SKOverlayData parseFrom(byte[] bArr, H h) throws C3211o0 {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
        }

        public static SKOverlayData parseFrom(InputStream inputStream) throws IOException {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SKOverlayData parseFrom(InputStream inputStream, H h) throws IOException {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
        }

        public static SKOverlayData parseFrom(AbstractC3229w abstractC3229w) throws IOException {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
        }

        public static SKOverlayData parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
            return (SKOverlayData) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
        }
    }

    static {
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = new AdmParametersOuterClass$AdmParameters();
        DEFAULT_INSTANCE = admParametersOuterClass$AdmParameters;
        AbstractC3169a0.registerDefaultInstance(AdmParametersOuterClass$AdmParameters.class, admParametersOuterClass$AdmParameters);
    }

    private AdmParametersOuterClass$AdmParameters() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAbExperiments(Experiment experiment) {
        experiment.getClass();
        ensureAbExperimentsIsMutable();
        this.abExperiments_.add(experiment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAbExperiments(Iterable<? extends Experiment> iterable) {
        ensureAbExperimentsIsMutable();
        AbstractC3171b.addAll((Iterable) iterable, (List) this.abExperiments_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAbExperiments() {
        this.abExperiments_ = AbstractC3169a0.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdCompletionUrl() {
        this.bitField0_ &= -1048577;
        this.adCompletionUrl_ = getDefaultInstance().getAdCompletionUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdDomain() {
        this.bitField0_ &= -33554433;
        this.adDomain_ = getDefaultInstance().getAdDomain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdDuration() {
        this.bitField0_ &= -2097153;
        this.adDuration_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdExpirationInterval() {
        this.bitField0_ &= -1025;
        this.adExpirationInterval_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdHeight() {
        this.bitField0_ &= -17;
        this.adHeight_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdNetworkId() {
        this.bitField0_ &= -513;
        this.adNetworkId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdNetworkName() {
        this.bitField0_ &= -257;
        this.adNetworkName_ = getDefaultInstance().getAdNetworkName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdType() {
        this.adType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdUnitDisplayType() {
        this.adUnitDisplayType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdUnitId() {
        this.bitField0_ &= -33;
        this.adUnitId_ = getDefaultInstance().getAdUnitId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdUnitType() {
        this.adUnitType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdWidth() {
        this.bitField0_ &= -9;
        this.adWidth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdvertisedAppId() {
        this.bitField0_ &= -16385;
        this.advertisedAppId_ = getDefaultInstance().getAdvertisedAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppBundleId() {
        this.bitField0_ &= -524289;
        this.appBundleId_ = getDefaultInstance().getAppBundleId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAttributionClickUrl() {
        this.bitField1_ &= -257;
        this.attributionClickUrl_ = getDefaultInstance().getAttributionClickUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAttributionImpressionUrl() {
        this.bitField1_ &= -129;
        this.attributionImpressionUrl_ = getDefaultInstance().getAttributionImpressionUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAutoStorekitState() {
        this.bitField1_ &= -33;
        this.autoStorekitState_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBrandBidderCtaText() {
        this.bitField1_ &= -9;
        this.brandBidderCtaText_ = getDefaultInstance().getBrandBidderCtaText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBrandBidderDontShowEndcard() {
        this.bitField1_ &= -5;
        this.brandBidderDontShowEndcard_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCampaignId() {
        this.bitField0_ &= -134217729;
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContentId() {
        this.bitField0_ &= -65;
        this.contentId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreativeId() {
        this.bitField0_ &= -67108865;
        this.creativeId_ = getDefaultInstance().getCreativeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreativeType() {
        this.bitField0_ &= -4194305;
        this.creativeType_ = getDefaultInstance().getCreativeType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCustomProductPageId() {
        this.bitField1_ &= -65;
        this.customProductPageId_ = getDefaultInstance().getCustomProductPageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrorMessage() {
        this.bitField0_ &= -5;
        this.errorMessage_ = getDefaultInstance().getErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIgniteInstallUrl() {
        this.bitField0_ &= Integer.MAX_VALUE;
        this.igniteInstallUrl_ = getDefaultInstance().getIgniteInstallUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIgniteLauncherActivity() {
        this.bitField1_ &= -2;
        this.igniteLauncherActivity_ = getDefaultInstance().getIgniteLauncherActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIgniteMode() {
        this.bitField0_ &= -1073741825;
        this.igniteMode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMarkupUrl() {
        this.bitField0_ &= -2;
        this.markupUrl_ = getDefaultInstance().getMarkupUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMraidVideoOMSignal() {
        this.bitField1_ &= -17;
        this.mraidVideoOMSignal_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMrcData() {
        this.mrcData_ = null;
        this.bitField0_ &= -268435457;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPricingValue() {
        this.bitField0_ &= -16777217;
        this.pricingValue_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublisherId() {
        this.bitField0_ &= -129;
        this.publisherId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSdkClickUrl() {
        this.bitField0_ &= -4097;
        this.sdkClickUrl_ = getDefaultInstance().getSdkClickUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSdkImpressionUrl() {
        this.bitField0_ &= -2049;
        this.sdkImpressionUrl_ = getDefaultInstance().getSdkImpressionUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -3;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkAdNetworkData() {
        this.skAdNetworkData_ = null;
        this.bitField0_ &= -8388609;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkOverlayData() {
        this.skOverlayData_ = null;
        this.bitField1_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkipMode() {
        this.bitField0_ &= -262145;
        this.skipMode_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpotId() {
        this.bitField0_ &= -536870913;
        this.spotId_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoreCTAText() {
        this.bitField0_ &= -131073;
        this.storeCTAText_ = getDefaultInstance().getStoreCTAText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoreEventUrl() {
        this.bitField0_ &= -65537;
        this.storeEventUrl_ = getDefaultInstance().getStoreEventUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoreUrl() {
        this.bitField0_ &= -8193;
        this.storeUrl_ = getDefaultInstance().getStoreUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStoreUrlType() {
        this.bitField0_ &= -32769;
        this.storeUrlType_ = 0;
    }

    private void ensureAbExperimentsIsMutable() {
        InterfaceC3202l0 interfaceC3202l0 = this.abExperiments_;
        if (((AbstractC3174c) interfaceC3202l0).f2277a) {
            return;
        }
        this.abExperiments_ = AbstractC3169a0.mutableCopy(interfaceC3202l0);
    }

    public static AdmParametersOuterClass$AdmParameters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMrcData(MRCData mRCData) {
        mRCData.getClass();
        MRCData mRCData2 = this.mrcData_;
        if (mRCData2 == null || mRCData2 == MRCData.getDefaultInstance()) {
            this.mrcData_ = mRCData;
        } else {
            o oVarNewBuilder = MRCData.newBuilder(this.mrcData_);
            oVarNewBuilder.c();
            U.a(oVarNewBuilder.b, mRCData);
            this.mrcData_ = (MRCData) oVarNewBuilder.b();
        }
        this.bitField0_ |= 268435456;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSkAdNetworkData(SKAdNetworkData sKAdNetworkData) {
        sKAdNetworkData.getClass();
        SKAdNetworkData sKAdNetworkData2 = this.skAdNetworkData_;
        if (sKAdNetworkData2 == null || sKAdNetworkData2 == SKAdNetworkData.getDefaultInstance()) {
            this.skAdNetworkData_ = sKAdNetworkData;
        } else {
            p pVarNewBuilder = SKAdNetworkData.newBuilder(this.skAdNetworkData_);
            pVarNewBuilder.c();
            U.a(pVarNewBuilder.b, sKAdNetworkData);
            this.skAdNetworkData_ = (SKAdNetworkData) pVarNewBuilder.b();
        }
        this.bitField0_ |= 8388608;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSkOverlayData(SKOverlayData sKOverlayData) {
        sKOverlayData.getClass();
        SKOverlayData sKOverlayData2 = this.skOverlayData_;
        if (sKOverlayData2 == null || sKOverlayData2 == SKOverlayData.getDefaultInstance()) {
            this.skOverlayData_ = sKOverlayData;
        } else {
            q qVarNewBuilder = SKOverlayData.newBuilder(this.skOverlayData_);
            qVarNewBuilder.c();
            U.a(qVarNewBuilder.b, sKOverlayData);
            this.skOverlayData_ = (SKOverlayData) qVarNewBuilder.b();
        }
        this.bitField1_ |= 2;
    }

    public static h newBuilder() {
        return (h) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdmParametersOuterClass$AdmParameters parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(ByteBuffer byteBuffer) throws C3211o0 {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static N0 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAbExperiments(int i) {
        ensureAbExperimentsIsMutable();
        this.abExperiments_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAbExperiments(int i, Experiment experiment) {
        experiment.getClass();
        ensureAbExperimentsIsMutable();
        this.abExperiments_.set(i, experiment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdCompletionUrl(String str) {
        str.getClass();
        this.bitField0_ |= 1048576;
        this.adCompletionUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdCompletionUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.adCompletionUrl_ = abstractC3221s.f();
        this.bitField0_ |= 1048576;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdDomain(String str) {
        str.getClass();
        this.bitField0_ |= 33554432;
        this.adDomain_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdDomainBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.adDomain_ = abstractC3221s.f();
        this.bitField0_ |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdDuration(int i) {
        this.bitField0_ |= 2097152;
        this.adDuration_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdExpirationInterval(int i) {
        this.bitField0_ |= 1024;
        this.adExpirationInterval_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdHeight(int i) {
        this.bitField0_ |= 16;
        this.adHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdNetworkId(long j) {
        this.bitField0_ |= 512;
        this.adNetworkId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdNetworkName(String str) {
        str.getClass();
        this.bitField0_ |= 256;
        this.adNetworkName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdNetworkNameBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.adNetworkName_ = abstractC3221s.f();
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdType(c cVar) {
        this.adType_ = cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdTypeValue(int i) {
        this.adType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdUnitDisplayType(s sVar) {
        this.adUnitDisplayType_ = sVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdUnitDisplayTypeValue(int i) {
        this.adUnitDisplayType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdUnitId(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.adUnitId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdUnitIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.adUnitId_ = abstractC3221s.f();
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdUnitType(e eVar) {
        this.adUnitType_ = eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdUnitTypeValue(int i) {
        this.adUnitType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdWidth(int i) {
        this.bitField0_ |= 8;
        this.adWidth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvertisedAppId(String str) {
        str.getClass();
        this.bitField0_ |= 16384;
        this.advertisedAppId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvertisedAppIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.advertisedAppId_ = abstractC3221s.f();
        this.bitField0_ |= 16384;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppBundleId(String str) {
        str.getClass();
        this.bitField0_ |= 524288;
        this.appBundleId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppBundleIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.appBundleId_ = abstractC3221s.f();
        this.bitField0_ |= 524288;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributionClickUrl(String str) {
        str.getClass();
        this.bitField1_ |= 256;
        this.attributionClickUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributionClickUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.attributionClickUrl_ = abstractC3221s.f();
        this.bitField1_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributionImpressionUrl(String str) {
        str.getClass();
        this.bitField1_ |= 128;
        this.attributionImpressionUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributionImpressionUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.attributionImpressionUrl_ = abstractC3221s.f();
        this.bitField1_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoStorekitState(g gVar) {
        this.autoStorekitState_ = gVar.a();
        this.bitField1_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoStorekitStateValue(int i) {
        this.bitField1_ |= 32;
        this.autoStorekitState_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrandBidderCtaText(String str) {
        str.getClass();
        this.bitField1_ |= 8;
        this.brandBidderCtaText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrandBidderCtaTextBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.brandBidderCtaText_ = abstractC3221s.f();
        this.bitField1_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrandBidderDontShowEndcard(boolean z) {
        this.bitField1_ |= 4;
        this.brandBidderDontShowEndcard_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignId(String str) {
        str.getClass();
        this.bitField0_ |= 134217728;
        this.campaignId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.campaignId_ = abstractC3221s.f();
        this.bitField0_ |= 134217728;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentId(long j) {
        this.bitField0_ |= 64;
        this.contentId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeId(String str) {
        str.getClass();
        this.bitField0_ |= 67108864;
        this.creativeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.creativeId_ = abstractC3221s.f();
        this.bitField0_ |= 67108864;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeType(String str) {
        str.getClass();
        this.bitField0_ |= 4194304;
        this.creativeType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreativeTypeBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.creativeType_ = abstractC3221s.f();
        this.bitField0_ |= 4194304;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomProductPageId(String str) {
        str.getClass();
        this.bitField1_ |= 64;
        this.customProductPageId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomProductPageIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.customProductPageId_ = abstractC3221s.f();
        this.bitField1_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMessage(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.errorMessage_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorMessageBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.errorMessage_ = abstractC3221s.f();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteInstallUrl(String str) {
        str.getClass();
        this.bitField0_ |= Integer.MIN_VALUE;
        this.igniteInstallUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteInstallUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.igniteInstallUrl_ = abstractC3221s.f();
        this.bitField0_ |= Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteLauncherActivity(String str) {
        str.getClass();
        this.bitField1_ |= 1;
        this.igniteLauncherActivity_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteLauncherActivityBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.igniteLauncherActivity_ = abstractC3221s.f();
        this.bitField1_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteMode(n nVar) {
        this.igniteMode_ = nVar.a();
        this.bitField0_ |= 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgniteModeValue(int i) {
        this.bitField0_ |= 1073741824;
        this.igniteMode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMarkupUrl(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.markupUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMarkupUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.markupUrl_ = abstractC3221s.f();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMraidVideoOMSignal(boolean z) {
        this.bitField1_ |= 16;
        this.mraidVideoOMSignal_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMrcData(MRCData mRCData) {
        mRCData.getClass();
        this.mrcData_ = mRCData;
        this.bitField0_ |= 268435456;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPricingValue(double d) {
        this.bitField0_ |= 16777216;
        this.pricingValue_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublisherId(long j) {
        this.bitField0_ |= 128;
        this.publisherId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkClickUrl(String str) {
        str.getClass();
        this.bitField0_ |= 4096;
        this.sdkClickUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkClickUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.sdkClickUrl_ = abstractC3221s.f();
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkImpressionUrl(String str) {
        str.getClass();
        this.bitField0_ |= 2048;
        this.sdkImpressionUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkImpressionUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.sdkImpressionUrl_ = abstractC3221s.f();
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.sessionId_ = abstractC3221s.f();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkAdNetworkData(SKAdNetworkData sKAdNetworkData) {
        sKAdNetworkData.getClass();
        this.skAdNetworkData_ = sKAdNetworkData;
        this.bitField0_ |= 8388608;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkOverlayData(SKOverlayData sKOverlayData) {
        sKOverlayData.getClass();
        this.skOverlayData_ = sKOverlayData;
        this.bitField1_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipMode(boolean z) {
        this.bitField0_ |= 262144;
        this.skipMode_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpotId(long j) {
        this.bitField0_ |= 536870912;
        this.spotId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreCTAText(String str) {
        str.getClass();
        this.bitField0_ |= 131072;
        this.storeCTAText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreCTATextBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.storeCTAText_ = abstractC3221s.f();
        this.bitField0_ |= 131072;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreEventUrl(String str) {
        str.getClass();
        this.bitField0_ |= 65536;
        this.storeEventUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreEventUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.storeEventUrl_ = abstractC3221s.f();
        this.bitField0_ |= 65536;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreUrl(String str) {
        str.getClass();
        this.bitField0_ |= 8192;
        this.storeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreUrlBytes(AbstractC3221s abstractC3221s) {
        AbstractC3171b.checkByteStringIsUtf8(abstractC3221s);
        this.storeUrl_ = abstractC3221s.f();
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreUrlType(j jVar) {
        this.storeUrlType_ = jVar.a();
        this.bitField0_ |= 32768;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStoreUrlTypeValue(int i) {
        this.bitField0_ |= 32768;
        this.storeUrlType_ = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3169a0
    public final Object dynamicMethod(Z z, Object obj, Object obj2) {
        switch (a.f1621a[z.ordinal()]) {
            case 1:
                return new AdmParametersOuterClass$AdmParameters();
            case 2:
                return new h();
            case 3:
                return AbstractC3169a0.newMessageInfo(DEFAULT_INSTANCE, "\u0000-\u0000\u0002\u0001--\u0000\u0001\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ለ\u0005\u0007\f\b\f\tဃ\u0006\nဃ\u0007\u000bለ\b\fဃ\t\rင\n\u000e\f\u000fለ\u000b\u0010ለ\f\u0011ለ\r\u0012ለ\u000e\u0013ဌ\u000f\u0014ለ\u0010\u0015ለ\u0011\u0016ဇ\u0012\u0017ለ\u0013\u0018ለ\u0014\u0019ဋ\u0015\u001aለ\u0016\u001bဉ\u0017\u001cက\u0018\u001dለ\u0019\u001eለ\u001a\u001fለ\u001b ဉ\u001c!\u001b\"ဃ\u001d#ဌ\u001e$ለ\u001f%ለ &ဉ!'ဇ\"(ለ#)ဇ$*ဌ%+ለ&,ለ'-ለ(", new Object[]{"bitField0_", "bitField1_", "markupUrl_", "sessionId_", "errorMessage_", "adWidth_", "adHeight_", "adUnitId_", "adUnitType_", "adUnitDisplayType_", "contentId_", "publisherId_", "adNetworkName_", "adNetworkId_", "adExpirationInterval_", "adType_", "sdkImpressionUrl_", "sdkClickUrl_", "storeUrl_", "advertisedAppId_", "storeUrlType_", "storeEventUrl_", "storeCTAText_", "skipMode_", "appBundleId_", "adCompletionUrl_", "adDuration_", "creativeType_", "skAdNetworkData_", "pricingValue_", "adDomain_", "creativeId_", "campaignId_", "mrcData_", "abExperiments_", Experiment.class, "spotId_", "igniteMode_", "igniteInstallUrl_", "igniteLauncherActivity_", "skOverlayData_", "brandBidderDontShowEndcard_", "brandBidderCtaText_", "mraidVideoOMSignal_", "autoStorekitState_", "customProductPageId_", "attributionImpressionUrl_", "attributionClickUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                N0 v = PARSER;
                if (v == null) {
                    synchronized (AdmParametersOuterClass$AdmParameters.class) {
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

    public Experiment getAbExperiments(int i) {
        return (Experiment) this.abExperiments_.get(i);
    }

    public int getAbExperimentsCount() {
        return this.abExperiments_.size();
    }

    public List<Experiment> getAbExperimentsList() {
        return this.abExperiments_;
    }

    public l getAbExperimentsOrBuilder(int i) {
        return (l) this.abExperiments_.get(i);
    }

    public List<? extends l> getAbExperimentsOrBuilderList() {
        return this.abExperiments_;
    }

    public String getAdCompletionUrl() {
        return this.adCompletionUrl_;
    }

    public AbstractC3221s getAdCompletionUrlBytes() {
        return AbstractC3221s.a(this.adCompletionUrl_);
    }

    public String getAdDomain() {
        return this.adDomain_;
    }

    public AbstractC3221s getAdDomainBytes() {
        return AbstractC3221s.a(this.adDomain_);
    }

    public int getAdDuration() {
        return this.adDuration_;
    }

    public int getAdExpirationInterval() {
        return this.adExpirationInterval_;
    }

    public int getAdHeight() {
        return this.adHeight_;
    }

    public long getAdNetworkId() {
        return this.adNetworkId_;
    }

    public String getAdNetworkName() {
        return this.adNetworkName_;
    }

    public AbstractC3221s getAdNetworkNameBytes() {
        return AbstractC3221s.a(this.adNetworkName_);
    }

    public c getAdType() {
        c cVar;
        int i = this.adType_;
        if (i == 0) {
            cVar = c.OTHER;
        } else if (i == 4) {
            cVar = c.HTML;
        } else if (i == 6) {
            cVar = c.MRAID;
        } else if (i != 8) {
            cVar = i != 15 ? null : c.DV360;
        } else {
            cVar = c.VAST;
        }
        return cVar == null ? c.UNRECOGNIZED : cVar;
    }

    public int getAdTypeValue() {
        return this.adType_;
    }

    public s getAdUnitDisplayType() {
        s sVar;
        int i = this.adUnitDisplayType_;
        if (i == 0) {
            sVar = s.UNITDISPLAYTYPEUNKNOWN;
        } else if (i == 1) {
            sVar = s.BANNER;
        } else if (i == 2) {
            sVar = s.INTERSTITIAL;
        } else if (i != 3) {
            sVar = i != 4 ? null : s.MRECT;
        } else {
            sVar = s.REWARDED;
        }
        return sVar == null ? s.UNRECOGNIZED : sVar;
    }

    public int getAdUnitDisplayTypeValue() {
        return this.adUnitDisplayType_;
    }

    public String getAdUnitId() {
        return this.adUnitId_;
    }

    public AbstractC3221s getAdUnitIdBytes() {
        return AbstractC3221s.a(this.adUnitId_);
    }

    public e getAdUnitType() {
        e eVar;
        int i = this.adUnitType_;
        if (i == 0) {
            eVar = e.DISPLAY;
        } else if (i != 1) {
            eVar = i != 2 ? null : e.VIDEOANDDISPLAY;
        } else {
            eVar = e.VIDEO;
        }
        return eVar == null ? e.UNRECOGNIZED : eVar;
    }

    public int getAdUnitTypeValue() {
        return this.adUnitType_;
    }

    public int getAdWidth() {
        return this.adWidth_;
    }

    public String getAdvertisedAppId() {
        return this.advertisedAppId_;
    }

    public AbstractC3221s getAdvertisedAppIdBytes() {
        return AbstractC3221s.a(this.advertisedAppId_);
    }

    public String getAppBundleId() {
        return this.appBundleId_;
    }

    public AbstractC3221s getAppBundleIdBytes() {
        return AbstractC3221s.a(this.appBundleId_);
    }

    public String getAttributionClickUrl() {
        return this.attributionClickUrl_;
    }

    public AbstractC3221s getAttributionClickUrlBytes() {
        return AbstractC3221s.a(this.attributionClickUrl_);
    }

    public String getAttributionImpressionUrl() {
        return this.attributionImpressionUrl_;
    }

    public AbstractC3221s getAttributionImpressionUrlBytes() {
        return AbstractC3221s.a(this.attributionImpressionUrl_);
    }

    public g getAutoStorekitState() {
        g gVar;
        int i = this.autoStorekitState_;
        if (i == 0) {
            gVar = g.AUTOSTOREKITNONE;
        } else if (i != 1) {
            gVar = i != 2 ? null : g.AUTOSTOREKITPRESENTANDTRACK;
        } else {
            gVar = g.AUTOSTOREKITPRESENTONLY;
        }
        return gVar == null ? g.UNRECOGNIZED : gVar;
    }

    public int getAutoStorekitStateValue() {
        return this.autoStorekitState_;
    }

    public String getBrandBidderCtaText() {
        return this.brandBidderCtaText_;
    }

    public AbstractC3221s getBrandBidderCtaTextBytes() {
        return AbstractC3221s.a(this.brandBidderCtaText_);
    }

    public boolean getBrandBidderDontShowEndcard() {
        return this.brandBidderDontShowEndcard_;
    }

    public String getCampaignId() {
        return this.campaignId_;
    }

    public AbstractC3221s getCampaignIdBytes() {
        return AbstractC3221s.a(this.campaignId_);
    }

    public long getContentId() {
        return this.contentId_;
    }

    public String getCreativeId() {
        return this.creativeId_;
    }

    public AbstractC3221s getCreativeIdBytes() {
        return AbstractC3221s.a(this.creativeId_);
    }

    public String getCreativeType() {
        return this.creativeType_;
    }

    public AbstractC3221s getCreativeTypeBytes() {
        return AbstractC3221s.a(this.creativeType_);
    }

    public String getCustomProductPageId() {
        return this.customProductPageId_;
    }

    public AbstractC3221s getCustomProductPageIdBytes() {
        return AbstractC3221s.a(this.customProductPageId_);
    }

    public String getErrorMessage() {
        return this.errorMessage_;
    }

    public AbstractC3221s getErrorMessageBytes() {
        return AbstractC3221s.a(this.errorMessage_);
    }

    public String getIgniteInstallUrl() {
        return this.igniteInstallUrl_;
    }

    public AbstractC3221s getIgniteInstallUrlBytes() {
        return AbstractC3221s.a(this.igniteInstallUrl_);
    }

    public String getIgniteLauncherActivity() {
        return this.igniteLauncherActivity_;
    }

    public AbstractC3221s getIgniteLauncherActivityBytes() {
        return AbstractC3221s.a(this.igniteLauncherActivity_);
    }

    public n getIgniteMode() {
        n nVar;
        int i = this.igniteMode_;
        if (i == 0) {
            nVar = n.NONE;
        } else if (i != 1) {
            nVar = i != 2 ? null : n.TRUESINGLETAP;
        } else {
            nVar = n.SINGLETAP;
        }
        return nVar == null ? n.UNRECOGNIZED : nVar;
    }

    public int getIgniteModeValue() {
        return this.igniteMode_;
    }

    public String getMarkupUrl() {
        return this.markupUrl_;
    }

    public AbstractC3221s getMarkupUrlBytes() {
        return AbstractC3221s.a(this.markupUrl_);
    }

    public boolean getMraidVideoOMSignal() {
        return this.mraidVideoOMSignal_;
    }

    public MRCData getMrcData() {
        MRCData mRCData = this.mrcData_;
        return mRCData == null ? MRCData.getDefaultInstance() : mRCData;
    }

    public double getPricingValue() {
        return this.pricingValue_;
    }

    public long getPublisherId() {
        return this.publisherId_;
    }

    public String getSdkClickUrl() {
        return this.sdkClickUrl_;
    }

    public AbstractC3221s getSdkClickUrlBytes() {
        return AbstractC3221s.a(this.sdkClickUrl_);
    }

    public String getSdkImpressionUrl() {
        return this.sdkImpressionUrl_;
    }

    public AbstractC3221s getSdkImpressionUrlBytes() {
        return AbstractC3221s.a(this.sdkImpressionUrl_);
    }

    public String getSessionId() {
        return this.sessionId_;
    }

    public AbstractC3221s getSessionIdBytes() {
        return AbstractC3221s.a(this.sessionId_);
    }

    public SKAdNetworkData getSkAdNetworkData() {
        SKAdNetworkData sKAdNetworkData = this.skAdNetworkData_;
        return sKAdNetworkData == null ? SKAdNetworkData.getDefaultInstance() : sKAdNetworkData;
    }

    public SKOverlayData getSkOverlayData() {
        SKOverlayData sKOverlayData = this.skOverlayData_;
        return sKOverlayData == null ? SKOverlayData.getDefaultInstance() : sKOverlayData;
    }

    public boolean getSkipMode() {
        return this.skipMode_;
    }

    public long getSpotId() {
        return this.spotId_;
    }

    public String getStoreCTAText() {
        return this.storeCTAText_;
    }

    public AbstractC3221s getStoreCTATextBytes() {
        return AbstractC3221s.a(this.storeCTAText_);
    }

    public String getStoreEventUrl() {
        return this.storeEventUrl_;
    }

    public AbstractC3221s getStoreEventUrlBytes() {
        return AbstractC3221s.a(this.storeEventUrl_);
    }

    public String getStoreUrl() {
        return this.storeUrl_;
    }

    public AbstractC3221s getStoreUrlBytes() {
        return AbstractC3221s.a(this.storeUrl_);
    }

    public j getStoreUrlType() {
        j jVar;
        int i = this.storeUrlType_;
        if (i != 0) {
            jVar = i != 1 ? null : j.AUTOMATIC;
        } else {
            jVar = j.MANUAL;
        }
        return jVar == null ? j.UNRECOGNIZED : jVar;
    }

    public int getStoreUrlTypeValue() {
        return this.storeUrlType_;
    }

    public boolean hasAdCompletionUrl() {
        return (this.bitField0_ & 1048576) != 0;
    }

    public boolean hasAdDomain() {
        return (this.bitField0_ & 33554432) != 0;
    }

    public boolean hasAdDuration() {
        return (this.bitField0_ & 2097152) != 0;
    }

    public boolean hasAdExpirationInterval() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasAdHeight() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasAdNetworkId() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasAdNetworkName() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasAdUnitId() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasAdWidth() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasAdvertisedAppId() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasAppBundleId() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasAttributionClickUrl() {
        return (this.bitField1_ & 256) != 0;
    }

    public boolean hasAttributionImpressionUrl() {
        return (this.bitField1_ & 128) != 0;
    }

    public boolean hasAutoStorekitState() {
        return (this.bitField1_ & 32) != 0;
    }

    public boolean hasBrandBidderCtaText() {
        return (this.bitField1_ & 8) != 0;
    }

    public boolean hasBrandBidderDontShowEndcard() {
        return (this.bitField1_ & 4) != 0;
    }

    public boolean hasCampaignId() {
        return (this.bitField0_ & 134217728) != 0;
    }

    public boolean hasContentId() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasCreativeId() {
        return (this.bitField0_ & 67108864) != 0;
    }

    public boolean hasCreativeType() {
        return (this.bitField0_ & 4194304) != 0;
    }

    public boolean hasCustomProductPageId() {
        return (this.bitField1_ & 64) != 0;
    }

    public boolean hasErrorMessage() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIgniteInstallUrl() {
        return (this.bitField0_ & Integer.MIN_VALUE) != 0;
    }

    public boolean hasIgniteLauncherActivity() {
        return (this.bitField1_ & 1) != 0;
    }

    public boolean hasIgniteMode() {
        return (this.bitField0_ & 1073741824) != 0;
    }

    public boolean hasMarkupUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMraidVideoOMSignal() {
        return (this.bitField1_ & 16) != 0;
    }

    public boolean hasMrcData() {
        return (this.bitField0_ & 268435456) != 0;
    }

    public boolean hasPricingValue() {
        return (this.bitField0_ & 16777216) != 0;
    }

    public boolean hasPublisherId() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasSdkClickUrl() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasSdkImpressionUrl() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasSessionId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSkAdNetworkData() {
        return (this.bitField0_ & 8388608) != 0;
    }

    public boolean hasSkOverlayData() {
        return (this.bitField1_ & 2) != 0;
    }

    public boolean hasSkipMode() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasSpotId() {
        return (this.bitField0_ & 536870912) != 0;
    }

    public boolean hasStoreCTAText() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasStoreEventUrl() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasStoreUrl() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasStoreUrlType() {
        return (this.bitField0_ & 32768) != 0;
    }

    public static h newBuilder(AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters) {
        return (h) DEFAULT_INSTANCE.createBuilder(admParametersOuterClass$AdmParameters);
    }

    public static AdmParametersOuterClass$AdmParameters parseDelimitedFrom(InputStream inputStream, H h) throws IOException {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(ByteBuffer byteBuffer, H h) throws C3211o0 {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(AbstractC3221s abstractC3221s) throws C3211o0 {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAbExperiments(int i, Experiment experiment) {
        experiment.getClass();
        ensureAbExperimentsIsMutable();
        this.abExperiments_.add(i, experiment);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(AbstractC3221s abstractC3221s, H h) throws C3211o0 {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3221s, h);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(byte[] bArr) throws C3211o0 {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(byte[] bArr, H h) throws C3211o0 {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, bArr, h);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(InputStream inputStream) throws IOException {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(InputStream inputStream, H h) throws IOException {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, inputStream, h);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(AbstractC3229w abstractC3229w) throws IOException {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w);
    }

    public static AdmParametersOuterClass$AdmParameters parseFrom(AbstractC3229w abstractC3229w, H h) throws IOException {
        return (AdmParametersOuterClass$AdmParameters) AbstractC3169a0.parseFrom(DEFAULT_INSTANCE, abstractC3229w, h);
    }
}

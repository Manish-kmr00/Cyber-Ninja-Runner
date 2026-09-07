package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.model.TokenCounters;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.data.repository.TcfRepository;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.HeaderBiddingTokenKt;
import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import gatewayprotocol.v1.InitializationDataOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.TestDataOuterClass;
import gatewayprotocol.v1.TokenCountersKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidBuildHeaderBiddingToken.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidBuildHeaderBiddingToken;", "Lcom/unity3d/ads/core/domain/BuildHeaderBiddingToken;", "generateId", "Lcom/unity3d/ads/core/domain/GetByteStringId;", "getClientInfo", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "getTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "getLimitedSessionToken", "Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;", "getInitializationData", "Lcom/unity3d/ads/core/domain/GetInitializationData;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "campaignRepository", "Lcom/unity3d/ads/core/data/repository/CampaignRepository;", "tcfRepository", "Lcom/unity3d/ads/core/data/repository/TcfRepository;", "testDataInfo", "Lcom/unity3d/ads/core/domain/AndroidTestDataInfo;", "offerwallManager", "Lcom/unity3d/ads/core/data/manager/OfferwallManager;", "(Lcom/unity3d/ads/core/domain/GetByteStringId;Lcom/unity3d/ads/core/domain/GetClientInfo;Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;Lcom/unity3d/ads/core/domain/GetLimitedSessionToken;Lcom/unity3d/ads/core/domain/GetInitializationData;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/CampaignRepository;Lcom/unity3d/ads/core/data/repository/TcfRepository;Lcom/unity3d/ads/core/domain/AndroidTestDataInfo;Lcom/unity3d/ads/core/data/manager/OfferwallManager;)V", "invoke", "Lgatewayprotocol/v1/HeaderBiddingTokenOuterClass$HeaderBiddingToken;", "scarSignalsCollected", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidBuildHeaderBiddingToken implements BuildHeaderBiddingToken {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetByteStringId generateId;
    private final GetClientInfo getClientInfo;
    private final GetInitializationData getInitializationData;
    private final GetLimitedSessionToken getLimitedSessionToken;
    private final GetSharedDataTimestamps getTimestamps;
    private final OfferwallManager offerwallManager;
    private final SessionRepository sessionRepository;
    private final TcfRepository tcfRepository;
    private final AndroidTestDataInfo testDataInfo;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidBuildHeaderBiddingToken.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken", f = "AndroidBuildHeaderBiddingToken.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {36, 45, 45, 50, 53, 55}, m = "invoke", n = {"this", "currentTokenCounters", "sToken", "$this$invoke_u24lambda_u243", "scarSignalsCollected", "this", "currentTokenCounters", "sToken", "$this$invoke_u24lambda_u243", "this", "currentTokenCounters", "sToken", "$this$invoke_u24lambda_u243", "this", "currentTokenCounters", "$this$invoke_u24lambda_u243", "this", "currentTokenCounters", "$this$invoke_u24lambda_u243", "this", "currentTokenCounters", "$this$invoke_u24lambda_u243"}, s = {"L$0", "L$1", "L$2", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidBuildHeaderBiddingToken.this.invoke(false, this);
        }
    }

    public AndroidBuildHeaderBiddingToken(GetByteStringId generateId, GetClientInfo getClientInfo, GetSharedDataTimestamps getTimestamps, GetLimitedSessionToken getLimitedSessionToken, GetInitializationData getInitializationData, DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, CampaignRepository campaignRepository, TcfRepository tcfRepository, AndroidTestDataInfo testDataInfo, OfferwallManager offerwallManager) {
        Intrinsics.checkNotNullParameter(generateId, "generateId");
        Intrinsics.checkNotNullParameter(getClientInfo, "getClientInfo");
        Intrinsics.checkNotNullParameter(getTimestamps, "getTimestamps");
        Intrinsics.checkNotNullParameter(getLimitedSessionToken, "getLimitedSessionToken");
        Intrinsics.checkNotNullParameter(getInitializationData, "getInitializationData");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(campaignRepository, "campaignRepository");
        Intrinsics.checkNotNullParameter(tcfRepository, "tcfRepository");
        Intrinsics.checkNotNullParameter(testDataInfo, "testDataInfo");
        Intrinsics.checkNotNullParameter(offerwallManager, "offerwallManager");
        this.generateId = generateId;
        this.getClientInfo = getClientInfo;
        this.getTimestamps = getTimestamps;
        this.getLimitedSessionToken = getLimitedSessionToken;
        this.getInitializationData = getInitializationData;
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.campaignRepository = campaignRepository;
        this.tcfRepository = tcfRepository;
        this.testDataInfo = testDataInfo;
        this.offerwallManager = offerwallManager;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x015b  */
    /* JADX WARN: Code duplicated, block: B:29:0x016f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0191  */
    /* JADX WARN: Code duplicated, block: B:36:0x019f  */
    /* JADX WARN: Code duplicated, block: B:38:0x01b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x01c0 A[PHI: r2 r5 r6 r7 r8 r11
  0x01c0: PHI (r2v15 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl) = (r2v11 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl), (r2v16 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl) binds: [B:35:0x019d, B:40:0x01bd] A[DONT_GENERATE, DONT_INLINE]
  0x01c0: PHI (r5v11 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl) = (r5v5 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl), (r5v12 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl) binds: [B:35:0x019d, B:40:0x01bd] A[DONT_GENERATE, DONT_INLINE]
  0x01c0: PHI (r6v11 com.google.protobuf.ByteString) = (r6v5 com.google.protobuf.ByteString), (r6v12 com.google.protobuf.ByteString) binds: [B:35:0x019d, B:40:0x01bd] A[DONT_GENERATE, DONT_INLINE]
  0x01c0: PHI (r7v9 com.unity3d.ads.core.data.model.TokenCounters) = (r7v5 com.unity3d.ads.core.data.model.TokenCounters), (r7v10 com.unity3d.ads.core.data.model.TokenCounters) binds: [B:35:0x019d, B:40:0x01bd] A[DONT_GENERATE, DONT_INLINE]
  0x01c0: PHI (r8v9 com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken) = 
  (r8v5 com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken)
  (r8v10 com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken)
 binds: [B:35:0x019d, B:40:0x01bd] A[DONT_GENERATE, DONT_INLINE]
  0x01c0: PHI (r11v22 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl) = (r11v5 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl), (r11v23 gatewayprotocol.v1.HeaderBiddingTokenKt$Dsl) binds: [B:35:0x019d, B:40:0x01bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:47:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:57:0x0217 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0218  */
    /* JADX WARN: Code duplicated, block: B:62:0x0237 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0238  */
    /* JADX WARN: Code duplicated, block: B:65:0x0244  */
    /* JADX WARN: Code duplicated, block: B:68:0x025e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.unity3d.ads.core.domain.BuildHeaderBiddingToken
    public Object invoke(boolean z, Continuation<? super HeaderBiddingTokenOuterClass.HeaderBiddingToken> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        TokenCounters tokenCounters;
        ByteString sessionToken;
        HeaderBiddingTokenKt.Dsl dsl_create;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken;
        HeaderBiddingTokenKt.Dsl dsl;
        HeaderBiddingTokenKt.Dsl dsl2;
        PiiOuterClass.Pii piiData;
        String tcfString;
        HeaderBiddingTokenKt.Dsl dsl3;
        HeaderBiddingTokenKt.Dsl dsl4;
        HeaderBiddingTokenKt.Dsl dsl5;
        ByteString byteString;
        TokenCounters tokenCounters2;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken2;
        boolean z2;
        String gameId;
        HeaderBiddingTokenKt.Dsl dsl6;
        HeaderBiddingTokenKt.Dsl dsl7;
        TokenCounters tokenCounters3;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken3;
        HeaderBiddingTokenKt.Dsl dsl8;
        HeaderBiddingTokenKt.Dsl dsl9;
        HeaderBiddingTokenKt.Dsl dsl10;
        TokenCounters tokenCounters4;
        HeaderBiddingTokenKt.Dsl dsl11;
        AndroidBuildHeaderBiddingToken androidBuildHeaderBiddingToken4;
        TestDataOuterClass.TestData testDataInvoke;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(objInvoke);
                tokenCounters = this.sessionRepository.getTokenCounters();
                sessionToken = this.sessionRepository.getSessionToken();
                this.sessionRepository.incrementTokenSequenceNumber();
                HeaderBiddingTokenKt.Dsl.Companion companion = HeaderBiddingTokenKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.HeaderBiddingToken.Builder builderNewBuilder = HeaderBiddingTokenOuterClass.HeaderBiddingToken.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
                dsl_create = companion._create(builderNewBuilder);
                dsl_create.setTokenId(this.generateId.invoke());
                dsl_create.setTokenNumber(this.sessionRepository.getHeaderBiddingTokenCounter());
                GetClientInfo getClientInfo = this.getClientInfo;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = tokenCounters;
                anonymousClass1.L$2 = sessionToken;
                anonymousClass1.L$3 = dsl_create;
                anonymousClass1.L$4 = dsl_create;
                anonymousClass1.L$5 = dsl_create;
                anonymousClass1.Z$0 = z;
                anonymousClass1.label = 1;
                objInvoke = getClientInfo.invoke(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                androidBuildHeaderBiddingToken = this;
                dsl = dsl_create;
                dsl2 = dsl;
                dsl_create.setClientInfo((ClientInfoOuterClass.ClientInfo) objInvoke);
                dsl.setTimestamps(androidBuildHeaderBiddingToken.getTimestamps.invoke());
                dsl.setSessionCounters(androidBuildHeaderBiddingToken.sessionRepository.getSessionCounters());
                dsl.setDynamicDeviceInfo(androidBuildHeaderBiddingToken.deviceInfoRepository.getDynamicDeviceInfo());
                piiData = androidBuildHeaderBiddingToken.deviceInfoRepository.getPiiData();
                if (piiData.getAdvertisingId().isEmpty() || !piiData.getOpenAdvertisingTrackingId().isEmpty()) {
                    dsl.setPii(piiData);
                }
                dsl.setCampaignState(androidBuildHeaderBiddingToken.campaignRepository.getCampaignState());
                tcfString = androidBuildHeaderBiddingToken.tcfRepository.getTcfString();
                if (tcfString != null) {
                    dsl.setTcf(ByteStringsKt.toByteStringUtf8(tcfString));
                }
                dsl.setScarSignalsCollected(z);
                OfferwallManager offerwallManager = androidBuildHeaderBiddingToken.offerwallManager;
                anonymousClass1.L$0 = androidBuildHeaderBiddingToken;
                anonymousClass1.L$1 = tokenCounters;
                anonymousClass1.L$2 = sessionToken;
                anonymousClass1.L$3 = dsl2;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl;
                anonymousClass1.label = 2;
                objInvoke = offerwallManager.isConnected(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl3 = dsl;
                dsl4 = dsl3;
                dsl5 = dsl2;
                byteString = sessionToken;
                tokenCounters2 = tokenCounters;
                androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken;
                if (((Boolean) objInvoke).booleanValue()) {
                    OfferwallManager offerwallManager2 = androidBuildHeaderBiddingToken2.offerwallManager;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                    anonymousClass1.L$1 = tokenCounters2;
                    anonymousClass1.L$2 = byteString;
                    anonymousClass1.L$3 = dsl5;
                    anonymousClass1.L$4 = dsl4;
                    anonymousClass1.L$5 = dsl3;
                    anonymousClass1.label = 3;
                    objInvoke = offerwallManager2.isContentReady(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z2 = ((Boolean) objInvoke).booleanValue() ? false : true;
                }
                dsl3.setOfferwallEnabled(z2);
                if (byteString.isEmpty()) {
                    gameId = androidBuildHeaderBiddingToken2.sessionRepository.getGameId();
                    if (gameId == null && gameId.length() > 0) {
                        GetInitializationData getInitializationData = androidBuildHeaderBiddingToken2.getInitializationData;
                        anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                        anonymousClass1.L$1 = tokenCounters2;
                        anonymousClass1.L$2 = dsl5;
                        anonymousClass1.L$3 = dsl4;
                        anonymousClass1.L$4 = dsl4;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 4;
                        objInvoke = getInitializationData.invoke(anonymousClass1);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dsl8 = dsl4;
                        dsl7 = dsl5;
                        tokenCounters3 = tokenCounters2;
                        androidBuildHeaderBiddingToken3 = androidBuildHeaderBiddingToken2;
                        dsl8.setInitializationData((InitializationDataOuterClass.InitializationData) objInvoke);
                        dsl9 = dsl4;
                        dsl10 = dsl7;
                        tokenCounters4 = tokenCounters3;
                        DeviceInfoRepository deviceInfoRepository = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                        anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                        anonymousClass1.L$1 = tokenCounters4;
                        anonymousClass1.L$2 = dsl10;
                        anonymousClass1.L$3 = dsl9;
                        anonymousClass1.L$4 = dsl9;
                        anonymousClass1.label = 6;
                        objInvoke = deviceInfoRepository.staticDeviceInfo(anonymousClass1);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dsl11 = dsl9;
                        androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                        dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                        androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                        dsl5 = dsl10;
                        tokenCounters2 = tokenCounters4;
                        dsl4 = dsl11;
                    } else {
                        GetLimitedSessionToken getLimitedSessionToken = androidBuildHeaderBiddingToken2.getLimitedSessionToken;
                        anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                        anonymousClass1.L$1 = tokenCounters2;
                        anonymousClass1.L$2 = dsl5;
                        anonymousClass1.L$3 = dsl4;
                        anonymousClass1.L$4 = dsl4;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 5;
                        objInvoke = getLimitedSessionToken.invoke(anonymousClass1);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dsl6 = dsl4;
                        dsl7 = dsl5;
                        tokenCounters3 = tokenCounters2;
                        androidBuildHeaderBiddingToken3 = androidBuildHeaderBiddingToken2;
                        dsl6.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) objInvoke);
                        dsl9 = dsl4;
                        dsl10 = dsl7;
                        tokenCounters4 = tokenCounters3;
                        DeviceInfoRepository deviceInfoRepository2 = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                        anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                        anonymousClass1.L$1 = tokenCounters4;
                        anonymousClass1.L$2 = dsl10;
                        anonymousClass1.L$3 = dsl9;
                        anonymousClass1.L$4 = dsl9;
                        anonymousClass1.label = 6;
                        objInvoke = deviceInfoRepository2.staticDeviceInfo(anonymousClass1);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dsl11 = dsl9;
                        androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                        dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                        androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                        dsl5 = dsl10;
                        tokenCounters2 = tokenCounters4;
                        dsl4 = dsl11;
                    }
                } else {
                    dsl4.setSessionToken(androidBuildHeaderBiddingToken2.sessionRepository.getSessionToken());
                    dsl4.setStaticDeviceInfo(androidBuildHeaderBiddingToken2.deviceInfoRepository.cachedStaticDeviceInfo());
                }
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion2 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder2 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
                TokenCountersKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
                dsl_create2.setSeq(tokenCounters2.getSeq());
                dsl_create2.setWins(tokenCounters2.getWins());
                dsl_create2.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create2._build());
                return dsl5._build();
            case 1:
                z = anonymousClass1.Z$0;
                dsl_create = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$5;
                dsl = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$4;
                dsl2 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$3;
                sessionToken = (ByteString) anonymousClass1.L$2;
                tokenCounters = (TokenCounters) anonymousClass1.L$1;
                androidBuildHeaderBiddingToken = (AndroidBuildHeaderBiddingToken) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl_create.setClientInfo((ClientInfoOuterClass.ClientInfo) objInvoke);
                dsl.setTimestamps(androidBuildHeaderBiddingToken.getTimestamps.invoke());
                dsl.setSessionCounters(androidBuildHeaderBiddingToken.sessionRepository.getSessionCounters());
                dsl.setDynamicDeviceInfo(androidBuildHeaderBiddingToken.deviceInfoRepository.getDynamicDeviceInfo());
                piiData = androidBuildHeaderBiddingToken.deviceInfoRepository.getPiiData();
                if (piiData.getAdvertisingId().isEmpty()) {
                    dsl.setPii(piiData);
                } else {
                    dsl.setPii(piiData);
                }
                dsl.setCampaignState(androidBuildHeaderBiddingToken.campaignRepository.getCampaignState());
                tcfString = androidBuildHeaderBiddingToken.tcfRepository.getTcfString();
                if (tcfString != null) {
                    dsl.setTcf(ByteStringsKt.toByteStringUtf8(tcfString));
                }
                dsl.setScarSignalsCollected(z);
                OfferwallManager offerwallManager3 = androidBuildHeaderBiddingToken.offerwallManager;
                anonymousClass1.L$0 = androidBuildHeaderBiddingToken;
                anonymousClass1.L$1 = tokenCounters;
                anonymousClass1.L$2 = sessionToken;
                anonymousClass1.L$3 = dsl2;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl;
                anonymousClass1.label = 2;
                objInvoke = offerwallManager3.isConnected(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl3 = dsl;
                dsl4 = dsl3;
                dsl5 = dsl2;
                byteString = sessionToken;
                tokenCounters2 = tokenCounters;
                androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken;
                if (((Boolean) objInvoke).booleanValue()) {
                    OfferwallManager offerwallManager4 = androidBuildHeaderBiddingToken2.offerwallManager;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                    anonymousClass1.L$1 = tokenCounters2;
                    anonymousClass1.L$2 = byteString;
                    anonymousClass1.L$3 = dsl5;
                    anonymousClass1.L$4 = dsl4;
                    anonymousClass1.L$5 = dsl3;
                    anonymousClass1.label = 3;
                    objInvoke = offerwallManager4.isContentReady(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) objInvoke).booleanValue()) {
                    }
                }
                dsl3.setOfferwallEnabled(z2);
                if (byteString.isEmpty()) {
                    gameId = androidBuildHeaderBiddingToken2.sessionRepository.getGameId();
                    if (gameId == null) {
                    }
                    GetLimitedSessionToken getLimitedSessionToken2 = androidBuildHeaderBiddingToken2.getLimitedSessionToken;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                    anonymousClass1.L$1 = tokenCounters2;
                    anonymousClass1.L$2 = dsl5;
                    anonymousClass1.L$3 = dsl4;
                    anonymousClass1.L$4 = dsl4;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 5;
                    objInvoke = getLimitedSessionToken2.invoke(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl6 = dsl4;
                    dsl7 = dsl5;
                    tokenCounters3 = tokenCounters2;
                    androidBuildHeaderBiddingToken3 = androidBuildHeaderBiddingToken2;
                    dsl6.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) objInvoke);
                    dsl9 = dsl4;
                    dsl10 = dsl7;
                    tokenCounters4 = tokenCounters3;
                    DeviceInfoRepository deviceInfoRepository3 = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                    anonymousClass1.L$1 = tokenCounters4;
                    anonymousClass1.L$2 = dsl10;
                    anonymousClass1.L$3 = dsl9;
                    anonymousClass1.L$4 = dsl9;
                    anonymousClass1.label = 6;
                    objInvoke = deviceInfoRepository3.staticDeviceInfo(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl11 = dsl9;
                    androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                    dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                    androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                    dsl5 = dsl10;
                    tokenCounters2 = tokenCounters4;
                    dsl4 = dsl11;
                    break;
                } else {
                    dsl4.setSessionToken(androidBuildHeaderBiddingToken2.sessionRepository.getSessionToken());
                    dsl4.setStaticDeviceInfo(androidBuildHeaderBiddingToken2.deviceInfoRepository.cachedStaticDeviceInfo());
                }
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion3 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder3 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder3, "newBuilder()");
                TokenCountersKt.Dsl dsl_create3 = companion3._create(builderNewBuilder3);
                dsl_create3.setSeq(tokenCounters2.getSeq());
                dsl_create3.setWins(tokenCounters2.getWins());
                dsl_create3.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create3._build());
                return dsl5._build();
            case 2:
                dsl3 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$5;
                dsl4 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$4;
                dsl5 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$3;
                byteString = (ByteString) anonymousClass1.L$2;
                tokenCounters2 = (TokenCounters) anonymousClass1.L$1;
                androidBuildHeaderBiddingToken2 = (AndroidBuildHeaderBiddingToken) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                if (((Boolean) objInvoke).booleanValue()) {
                    OfferwallManager offerwallManager5 = androidBuildHeaderBiddingToken2.offerwallManager;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                    anonymousClass1.L$1 = tokenCounters2;
                    anonymousClass1.L$2 = byteString;
                    anonymousClass1.L$3 = dsl5;
                    anonymousClass1.L$4 = dsl4;
                    anonymousClass1.L$5 = dsl3;
                    anonymousClass1.label = 3;
                    objInvoke = offerwallManager5.isContentReady(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) objInvoke).booleanValue()) {
                    }
                }
                dsl3.setOfferwallEnabled(z2);
                if (byteString.isEmpty()) {
                    gameId = androidBuildHeaderBiddingToken2.sessionRepository.getGameId();
                    if (gameId == null) {
                    }
                    GetLimitedSessionToken getLimitedSessionToken3 = androidBuildHeaderBiddingToken2.getLimitedSessionToken;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                    anonymousClass1.L$1 = tokenCounters2;
                    anonymousClass1.L$2 = dsl5;
                    anonymousClass1.L$3 = dsl4;
                    anonymousClass1.L$4 = dsl4;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 5;
                    objInvoke = getLimitedSessionToken3.invoke(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl6 = dsl4;
                    dsl7 = dsl5;
                    tokenCounters3 = tokenCounters2;
                    androidBuildHeaderBiddingToken3 = androidBuildHeaderBiddingToken2;
                    dsl6.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) objInvoke);
                    dsl9 = dsl4;
                    dsl10 = dsl7;
                    tokenCounters4 = tokenCounters3;
                    DeviceInfoRepository deviceInfoRepository4 = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                    anonymousClass1.L$1 = tokenCounters4;
                    anonymousClass1.L$2 = dsl10;
                    anonymousClass1.L$3 = dsl9;
                    anonymousClass1.L$4 = dsl9;
                    anonymousClass1.label = 6;
                    objInvoke = deviceInfoRepository4.staticDeviceInfo(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl11 = dsl9;
                    androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                    dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                    androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                    dsl5 = dsl10;
                    tokenCounters2 = tokenCounters4;
                    dsl4 = dsl11;
                    break;
                } else {
                    dsl4.setSessionToken(androidBuildHeaderBiddingToken2.sessionRepository.getSessionToken());
                    dsl4.setStaticDeviceInfo(androidBuildHeaderBiddingToken2.deviceInfoRepository.cachedStaticDeviceInfo());
                }
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion4 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder4 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder4, "newBuilder()");
                TokenCountersKt.Dsl dsl_create4 = companion4._create(builderNewBuilder4);
                dsl_create4.setSeq(tokenCounters2.getSeq());
                dsl_create4.setWins(tokenCounters2.getWins());
                dsl_create4.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create4._build());
                return dsl5._build();
            case 3:
                dsl3 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$5;
                dsl4 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$4;
                dsl5 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$3;
                byteString = (ByteString) anonymousClass1.L$2;
                tokenCounters2 = (TokenCounters) anonymousClass1.L$1;
                androidBuildHeaderBiddingToken2 = (AndroidBuildHeaderBiddingToken) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                if (((Boolean) objInvoke).booleanValue()) {
                }
                dsl3.setOfferwallEnabled(z2);
                if (byteString.isEmpty()) {
                    gameId = androidBuildHeaderBiddingToken2.sessionRepository.getGameId();
                    if (gameId == null) {
                    }
                    GetLimitedSessionToken getLimitedSessionToken4 = androidBuildHeaderBiddingToken2.getLimitedSessionToken;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken2;
                    anonymousClass1.L$1 = tokenCounters2;
                    anonymousClass1.L$2 = dsl5;
                    anonymousClass1.L$3 = dsl4;
                    anonymousClass1.L$4 = dsl4;
                    anonymousClass1.L$5 = null;
                    anonymousClass1.label = 5;
                    objInvoke = getLimitedSessionToken4.invoke(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl6 = dsl4;
                    dsl7 = dsl5;
                    tokenCounters3 = tokenCounters2;
                    androidBuildHeaderBiddingToken3 = androidBuildHeaderBiddingToken2;
                    dsl6.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) objInvoke);
                    dsl9 = dsl4;
                    dsl10 = dsl7;
                    tokenCounters4 = tokenCounters3;
                    DeviceInfoRepository deviceInfoRepository5 = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                    anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                    anonymousClass1.L$1 = tokenCounters4;
                    anonymousClass1.L$2 = dsl10;
                    anonymousClass1.L$3 = dsl9;
                    anonymousClass1.L$4 = dsl9;
                    anonymousClass1.label = 6;
                    objInvoke = deviceInfoRepository5.staticDeviceInfo(anonymousClass1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    dsl11 = dsl9;
                    androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                    dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                    androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                    dsl5 = dsl10;
                    tokenCounters2 = tokenCounters4;
                    dsl4 = dsl11;
                    break;
                } else {
                    dsl4.setSessionToken(androidBuildHeaderBiddingToken2.sessionRepository.getSessionToken());
                    dsl4.setStaticDeviceInfo(androidBuildHeaderBiddingToken2.deviceInfoRepository.cachedStaticDeviceInfo());
                }
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion5 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder5 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder5, "newBuilder()");
                TokenCountersKt.Dsl dsl_create5 = companion5._create(builderNewBuilder5);
                dsl_create5.setSeq(tokenCounters2.getSeq());
                dsl_create5.setWins(tokenCounters2.getWins());
                dsl_create5.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create5._build());
                return dsl5._build();
            case 4:
                dsl8 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$4;
                dsl4 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$3;
                dsl7 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$2;
                tokenCounters3 = (TokenCounters) anonymousClass1.L$1;
                androidBuildHeaderBiddingToken3 = (AndroidBuildHeaderBiddingToken) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl8.setInitializationData((InitializationDataOuterClass.InitializationData) objInvoke);
                dsl9 = dsl4;
                dsl10 = dsl7;
                tokenCounters4 = tokenCounters3;
                DeviceInfoRepository deviceInfoRepository6 = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                anonymousClass1.L$1 = tokenCounters4;
                anonymousClass1.L$2 = dsl10;
                anonymousClass1.L$3 = dsl9;
                anonymousClass1.L$4 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository6.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                dsl5 = dsl10;
                tokenCounters2 = tokenCounters4;
                dsl4 = dsl11;
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion6 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder6 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder6, "newBuilder()");
                TokenCountersKt.Dsl dsl_create6 = companion6._create(builderNewBuilder6);
                dsl_create6.setSeq(tokenCounters2.getSeq());
                dsl_create6.setWins(tokenCounters2.getWins());
                dsl_create6.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create6._build());
                return dsl5._build();
            case 5:
                dsl6 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$4;
                dsl4 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$3;
                dsl7 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$2;
                tokenCounters3 = (TokenCounters) anonymousClass1.L$1;
                androidBuildHeaderBiddingToken3 = (AndroidBuildHeaderBiddingToken) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl6.setLimitedSessionToken((UniversalRequestOuterClass.LimitedSessionToken) objInvoke);
                dsl9 = dsl4;
                dsl10 = dsl7;
                tokenCounters4 = tokenCounters3;
                DeviceInfoRepository deviceInfoRepository7 = androidBuildHeaderBiddingToken3.deviceInfoRepository;
                anonymousClass1.L$0 = androidBuildHeaderBiddingToken3;
                anonymousClass1.L$1 = tokenCounters4;
                anonymousClass1.L$2 = dsl10;
                anonymousClass1.L$3 = dsl9;
                anonymousClass1.L$4 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository7.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                androidBuildHeaderBiddingToken4 = androidBuildHeaderBiddingToken3;
                dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                dsl5 = dsl10;
                tokenCounters2 = tokenCounters4;
                dsl4 = dsl11;
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion7 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder7 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder7, "newBuilder()");
                TokenCountersKt.Dsl dsl_create7 = companion7._create(builderNewBuilder7);
                dsl_create7.setSeq(tokenCounters2.getSeq());
                dsl_create7.setWins(tokenCounters2.getWins());
                dsl_create7.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create7._build());
                return dsl5._build();
            case 6:
                dsl9 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$4;
                dsl11 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$3;
                dsl10 = (HeaderBiddingTokenKt.Dsl) anonymousClass1.L$2;
                tokenCounters4 = (TokenCounters) anonymousClass1.L$1;
                androidBuildHeaderBiddingToken4 = (AndroidBuildHeaderBiddingToken) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl9.setStaticDeviceInfo((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke);
                androidBuildHeaderBiddingToken2 = androidBuildHeaderBiddingToken4;
                dsl5 = dsl10;
                tokenCounters2 = tokenCounters4;
                dsl4 = dsl11;
                testDataInvoke = androidBuildHeaderBiddingToken2.testDataInfo.invoke();
                if (testDataInvoke != null) {
                    dsl4.setTestData(testDataInvoke);
                }
                TokenCountersKt.Dsl.Companion companion8 = TokenCountersKt.Dsl.INSTANCE;
                HeaderBiddingTokenOuterClass.TokenCounters.Builder builderNewBuilder8 = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder8, "newBuilder()");
                TokenCountersKt.Dsl dsl_create8 = companion8._create(builderNewBuilder8);
                dsl_create8.setSeq(tokenCounters2.getSeq());
                dsl_create8.setWins(tokenCounters2.getWins());
                dsl_create8.setStarts(tokenCounters2.getStarts());
                dsl4.setTokenCounters(dsl_create8._build());
                return dsl5._build();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

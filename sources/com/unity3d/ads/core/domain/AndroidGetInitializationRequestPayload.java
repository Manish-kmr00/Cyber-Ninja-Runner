package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.configuration.MediationInitBlobMetadataReader;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.InitializationDeviceInfoKt;
import gatewayprotocol.v1.InitializationRequestKt;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidGetInitializationRequestPayload.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidGetInitializationRequestPayload;", "Lcom/unity3d/ads/core/domain/GetInitializationRequestPayload;", "getClientInfo", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "legacyUserConsentRepository", "Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;", "mediationInitBlobMetadataReader", "Lcom/unity3d/ads/core/configuration/MediationInitBlobMetadataReader;", "(Lcom/unity3d/ads/core/domain/GetClientInfo;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;Lcom/unity3d/ads/core/configuration/MediationInitBlobMetadataReader;)V", "invoke", "Lgatewayprotocol/v1/InitializationRequestOuterClass$InitializationRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidGetInitializationRequestPayload implements GetInitializationRequestPayload {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetClientInfo getClientInfo;
    private final LegacyUserConsentRepository legacyUserConsentRepository;
    private final MediationInitBlobMetadataReader mediationInitBlobMetadataReader;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidGetInitializationRequestPayload.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload", f = "AndroidGetInitializationRequestPayload.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7}, l = {24, 25, 33, 34, 45, 50, 55, 60}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u245", "this", "$this$invoke_u24lambda_u245", "this", "$this$invoke_u24lambda_u245", "$this$invoke_u24lambda_u245_u24lambda_u242", "this", "$this$invoke_u24lambda_u245", "$this$invoke_u24lambda_u245_u24lambda_u242", "this", "$this$invoke_u24lambda_u245", "this", "$this$invoke_u24lambda_u245", "this", "$this$invoke_u24lambda_u245", "this", "$this$invoke_u24lambda_u245"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$5", "L$0", "L$2", "L$5", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidGetInitializationRequestPayload.this.invoke(this);
        }
    }

    public AndroidGetInitializationRequestPayload(GetClientInfo getClientInfo, SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository, LegacyUserConsentRepository legacyUserConsentRepository, MediationInitBlobMetadataReader mediationInitBlobMetadataReader) {
        Intrinsics.checkNotNullParameter(getClientInfo, "getClientInfo");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(legacyUserConsentRepository, "legacyUserConsentRepository");
        Intrinsics.checkNotNullParameter(mediationInitBlobMetadataReader, "mediationInitBlobMetadataReader");
        this.getClientInfo = getClientInfo;
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
        this.legacyUserConsentRepository = legacyUserConsentRepository;
        this.mediationInitBlobMetadataReader = mediationInitBlobMetadataReader;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x014c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x014d  */
    /* JADX WARN: Code duplicated, block: B:41:0x015b  */
    /* JADX WARN: Code duplicated, block: B:44:0x01b1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:48:0x01d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x01da  */
    /* JADX WARN: Code duplicated, block: B:52:0x027f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0280  */
    /* JADX WARN: Code duplicated, block: B:56:0x0287  */
    /* JADX WARN: Code duplicated, block: B:59:0x029b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:68:0x02be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x02dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:78:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:84:0x0307  */
    /* JADX WARN: Code duplicated, block: B:87:0x030b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0310  */
    /* JADX WARN: Code duplicated, block: B:93:0x031f  */
    @Override // com.unity3d.ads.core.domain.GetInitializationRequestPayload
    public Object invoke(Continuation<? super InitializationRequestOuterClass.InitializationRequest> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        InitializationRequestKt.Dsl dsl_create;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload;
        InitializationRequestKt.Dsl dsl;
        InitializationRequestKt.Dsl dsl2;
        InitializationRequestKt.Dsl dsl3;
        String analyticsUserId;
        InitializationDeviceInfoKt.Dsl dsl_create2;
        InitializationDeviceInfoKt.Dsl dsl4;
        InitializationRequestKt.Dsl dsl5;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload2;
        InitializationDeviceInfoKt.Dsl dsl6;
        InitializationRequestKt.Dsl dsl7;
        InitializationDeviceInfoKt.Dsl dsl8;
        InitializationRequestKt.Dsl dsl9;
        InitializationRequestKt.Dsl dsl10;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload3;
        ByteString byteString;
        String str;
        String str2;
        ByteString byteString2;
        InitializationRequestKt.Dsl dsl11;
        InitializationRequestKt.Dsl dsl12;
        AndroidGetInitializationRequestPayload androidGetInitializationRequestPayload4;
        ByteString byteString3;
        Object obj;
        String str3;
        String legacyFlowUserConsent;
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
        Object obj2 = null;
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(objInvoke);
                InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.INSTANCE;
                InitializationRequestOuterClass.InitializationRequest.Builder builderNewBuilder = InitializationRequestOuterClass.InitializationRequest.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
                dsl_create = companion._create(builderNewBuilder);
                Storage storage = StorageManager.getStorage(StorageManager.StorageType.PRIVATE);
                boolean z = false;
                if (storage.readStorage()) {
                    Object obj3 = storage.get("configuration.hasInitialized");
                    Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
                    if (bool != null ? bool.booleanValue() : false) {
                        z = true;
                    }
                }
                dsl_create.setIsFirstInit(!z);
                GetClientInfo getClientInfo = this.getClientInfo;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = dsl_create;
                anonymousClass1.L$2 = dsl_create;
                anonymousClass1.L$3 = dsl_create;
                anonymousClass1.label = 1;
                objInvoke = getClientInfo.invoke(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                androidGetInitializationRequestPayload = this;
                dsl = dsl_create;
                dsl2 = dsl;
                dsl_create.setClientInfo((ClientInfoOuterClass.ClientInfo) objInvoke);
                DeviceInfoRepository deviceInfoRepository = androidGetInitializationRequestPayload.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload;
                anonymousClass1.L$1 = dsl2;
                anonymousClass1.L$2 = dsl;
                anonymousClass1.L$3 = dsl;
                anonymousClass1.label = 2;
                objInvoke = deviceInfoRepository.getIdfi(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl3 = dsl;
                dsl3.setIdfi((String) objInvoke);
                analyticsUserId = androidGetInitializationRequestPayload.deviceInfoRepository.getAnalyticsUserId();
                if (analyticsUserId != null) {
                    dsl.setAnalyticsUserId(analyticsUserId);
                }
                dsl.setSessionId(androidGetInitializationRequestPayload.sessionRepository.getSessionId());
                InitializationDeviceInfoKt.Dsl.Companion companion2 = InitializationDeviceInfoKt.Dsl.INSTANCE;
                InitializationRequestOuterClass.InitializationDeviceInfo.Builder builderNewBuilder2 = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
                dsl_create2 = companion2._create(builderNewBuilder2);
                dsl_create2.setBundleId(androidGetInitializationRequestPayload.deviceInfoRepository.getAppName());
                dsl_create2.setDeviceModel(androidGetInitializationRequestPayload.deviceInfoRepository.getModel());
                dsl_create2.setDeviceMake(androidGetInitializationRequestPayload.deviceInfoRepository.getManufacturer());
                dsl_create2.setOsVersion(androidGetInitializationRequestPayload.deviceInfoRepository.getOsVersion());
                DeviceInfoRepository deviceInfoRepository2 = androidGetInitializationRequestPayload.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload;
                anonymousClass1.L$1 = dsl2;
                anonymousClass1.L$2 = dsl;
                anonymousClass1.L$3 = dsl_create2;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl_create2;
                anonymousClass1.L$6 = dsl_create2;
                anonymousClass1.label = 3;
                objInvoke = deviceInfoRepository2.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl4 = dsl_create2;
                dsl5 = dsl2;
                androidGetInitializationRequestPayload2 = androidGetInitializationRequestPayload;
                dsl6 = dsl4;
                dsl7 = dsl;
                dsl_create2.setTotalDiskSpace(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalDiskSpace());
                DeviceInfoRepository deviceInfoRepository3 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = dsl6;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl4;
                anonymousClass1.L$6 = dsl4;
                anonymousClass1.label = 4;
                objInvoke = deviceInfoRepository3.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl8 = dsl4;
                dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalRamMemory());
                dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                String networkOperator = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                dsl4.setNetworkOperator(networkOperator);
                dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                String language = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "deviceInfoRepository.dynamicDeviceInfo.language");
                dsl4.setLanguage(language);
                dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                dsl.setDeviceInfo(dsl6._build());
                DeviceInfoRepository deviceInfoRepository4 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = null;
                anonymousClass1.L$6 = null;
                anonymousClass1.label = 5;
                objInvoke = deviceInfoRepository4.getAuidByteString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl9 = dsl7;
                dsl10 = dsl5;
                androidGetInitializationRequestPayload3 = androidGetInitializationRequestPayload2;
                byteString = (ByteString) objInvoke;
                if (byteString != null) {
                    dsl9.setAuid(byteString);
                }
                DeviceInfoRepository deviceInfoRepository5 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository5.getAuidString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null && str2.length() != 0) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository2 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository2.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader.getJsonStorage().get(mediationInitBlobMetadataReader.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 1:
                dsl_create = (InitializationRequestKt.Dsl) anonymousClass1.L$3;
                dsl = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl2 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl_create.setClientInfo((ClientInfoOuterClass.ClientInfo) objInvoke);
                DeviceInfoRepository deviceInfoRepository6 = androidGetInitializationRequestPayload.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload;
                anonymousClass1.L$1 = dsl2;
                anonymousClass1.L$2 = dsl;
                anonymousClass1.L$3 = dsl;
                anonymousClass1.label = 2;
                objInvoke = deviceInfoRepository6.getIdfi(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl3 = dsl;
                dsl3.setIdfi((String) objInvoke);
                analyticsUserId = androidGetInitializationRequestPayload.deviceInfoRepository.getAnalyticsUserId();
                if (analyticsUserId != null) {
                    dsl.setAnalyticsUserId(analyticsUserId);
                }
                dsl.setSessionId(androidGetInitializationRequestPayload.sessionRepository.getSessionId());
                InitializationDeviceInfoKt.Dsl.Companion companion3 = InitializationDeviceInfoKt.Dsl.INSTANCE;
                InitializationRequestOuterClass.InitializationDeviceInfo.Builder builderNewBuilder3 = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder3, "newBuilder()");
                dsl_create2 = companion3._create(builderNewBuilder3);
                dsl_create2.setBundleId(androidGetInitializationRequestPayload.deviceInfoRepository.getAppName());
                dsl_create2.setDeviceModel(androidGetInitializationRequestPayload.deviceInfoRepository.getModel());
                dsl_create2.setDeviceMake(androidGetInitializationRequestPayload.deviceInfoRepository.getManufacturer());
                dsl_create2.setOsVersion(androidGetInitializationRequestPayload.deviceInfoRepository.getOsVersion());
                DeviceInfoRepository deviceInfoRepository7 = androidGetInitializationRequestPayload.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload;
                anonymousClass1.L$1 = dsl2;
                anonymousClass1.L$2 = dsl;
                anonymousClass1.L$3 = dsl_create2;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl_create2;
                anonymousClass1.L$6 = dsl_create2;
                anonymousClass1.label = 3;
                objInvoke = deviceInfoRepository7.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl4 = dsl_create2;
                dsl5 = dsl2;
                androidGetInitializationRequestPayload2 = androidGetInitializationRequestPayload;
                dsl6 = dsl4;
                dsl7 = dsl;
                dsl_create2.setTotalDiskSpace(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalDiskSpace());
                DeviceInfoRepository deviceInfoRepository8 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = dsl6;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl4;
                anonymousClass1.L$6 = dsl4;
                anonymousClass1.label = 4;
                objInvoke = deviceInfoRepository8.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl8 = dsl4;
                dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalRamMemory());
                dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                String networkOperator2 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator2, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                dsl4.setNetworkOperator(networkOperator2);
                dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                String language2 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language2, "deviceInfoRepository.dynamicDeviceInfo.language");
                dsl4.setLanguage(language2);
                dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                dsl.setDeviceInfo(dsl6._build());
                DeviceInfoRepository deviceInfoRepository9 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = null;
                anonymousClass1.L$6 = null;
                anonymousClass1.label = 5;
                objInvoke = deviceInfoRepository9.getAuidByteString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl9 = dsl7;
                dsl10 = dsl5;
                androidGetInitializationRequestPayload3 = androidGetInitializationRequestPayload2;
                byteString = (ByteString) objInvoke;
                if (byteString != null) {
                    dsl9.setAuid(byteString);
                }
                DeviceInfoRepository deviceInfoRepository10 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository10.getAuidString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository3 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository3.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository4 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository4.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader2 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader2.getJsonStorage().get(mediationInitBlobMetadataReader2.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 2:
                dsl3 = (InitializationRequestKt.Dsl) anonymousClass1.L$3;
                dsl = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl2 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl3.setIdfi((String) objInvoke);
                analyticsUserId = androidGetInitializationRequestPayload.deviceInfoRepository.getAnalyticsUserId();
                if (analyticsUserId != null) {
                    dsl.setAnalyticsUserId(analyticsUserId);
                }
                dsl.setSessionId(androidGetInitializationRequestPayload.sessionRepository.getSessionId());
                InitializationDeviceInfoKt.Dsl.Companion companion4 = InitializationDeviceInfoKt.Dsl.INSTANCE;
                InitializationRequestOuterClass.InitializationDeviceInfo.Builder builderNewBuilder4 = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
                Intrinsics.checkNotNullExpressionValue(builderNewBuilder4, "newBuilder()");
                dsl_create2 = companion4._create(builderNewBuilder4);
                dsl_create2.setBundleId(androidGetInitializationRequestPayload.deviceInfoRepository.getAppName());
                dsl_create2.setDeviceModel(androidGetInitializationRequestPayload.deviceInfoRepository.getModel());
                dsl_create2.setDeviceMake(androidGetInitializationRequestPayload.deviceInfoRepository.getManufacturer());
                dsl_create2.setOsVersion(androidGetInitializationRequestPayload.deviceInfoRepository.getOsVersion());
                DeviceInfoRepository deviceInfoRepository11 = androidGetInitializationRequestPayload.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload;
                anonymousClass1.L$1 = dsl2;
                anonymousClass1.L$2 = dsl;
                anonymousClass1.L$3 = dsl_create2;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl_create2;
                anonymousClass1.L$6 = dsl_create2;
                anonymousClass1.label = 3;
                objInvoke = deviceInfoRepository11.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl4 = dsl_create2;
                dsl5 = dsl2;
                androidGetInitializationRequestPayload2 = androidGetInitializationRequestPayload;
                dsl6 = dsl4;
                dsl7 = dsl;
                dsl_create2.setTotalDiskSpace(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalDiskSpace());
                DeviceInfoRepository deviceInfoRepository12 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = dsl6;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl4;
                anonymousClass1.L$6 = dsl4;
                anonymousClass1.label = 4;
                objInvoke = deviceInfoRepository12.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl8 = dsl4;
                dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalRamMemory());
                dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                String networkOperator3 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator3, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                dsl4.setNetworkOperator(networkOperator3);
                dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                String language3 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language3, "deviceInfoRepository.dynamicDeviceInfo.language");
                dsl4.setLanguage(language3);
                dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                dsl.setDeviceInfo(dsl6._build());
                DeviceInfoRepository deviceInfoRepository13 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = null;
                anonymousClass1.L$6 = null;
                anonymousClass1.label = 5;
                objInvoke = deviceInfoRepository13.getAuidByteString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl9 = dsl7;
                dsl10 = dsl5;
                androidGetInitializationRequestPayload3 = androidGetInitializationRequestPayload2;
                byteString = (ByteString) objInvoke;
                if (byteString != null) {
                    dsl9.setAuid(byteString);
                }
                DeviceInfoRepository deviceInfoRepository14 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository14.getAuidString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository5 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository5.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository6 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository6.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader3 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader3.getJsonStorage().get(mediationInitBlobMetadataReader3.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 3:
                dsl_create2 = (InitializationDeviceInfoKt.Dsl) anonymousClass1.L$6;
                dsl4 = (InitializationDeviceInfoKt.Dsl) anonymousClass1.L$5;
                dsl = (InitializationRequestKt.Dsl) anonymousClass1.L$4;
                dsl6 = (InitializationDeviceInfoKt.Dsl) anonymousClass1.L$3;
                dsl7 = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl5 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload2 = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl_create2.setTotalDiskSpace(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalDiskSpace());
                DeviceInfoRepository deviceInfoRepository15 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = dsl6;
                anonymousClass1.L$4 = dsl;
                anonymousClass1.L$5 = dsl4;
                anonymousClass1.L$6 = dsl4;
                anonymousClass1.label = 4;
                objInvoke = deviceInfoRepository15.staticDeviceInfo(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl8 = dsl4;
                dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalRamMemory());
                dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                String networkOperator4 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator4, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                dsl4.setNetworkOperator(networkOperator4);
                dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                String language4 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language4, "deviceInfoRepository.dynamicDeviceInfo.language");
                dsl4.setLanguage(language4);
                dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                dsl.setDeviceInfo(dsl6._build());
                DeviceInfoRepository deviceInfoRepository16 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = null;
                anonymousClass1.L$6 = null;
                anonymousClass1.label = 5;
                objInvoke = deviceInfoRepository16.getAuidByteString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl9 = dsl7;
                dsl10 = dsl5;
                androidGetInitializationRequestPayload3 = androidGetInitializationRequestPayload2;
                byteString = (ByteString) objInvoke;
                if (byteString != null) {
                    dsl9.setAuid(byteString);
                }
                DeviceInfoRepository deviceInfoRepository17 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository17.getAuidString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository7 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository7.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository8 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository8.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader4 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader4.getJsonStorage().get(mediationInitBlobMetadataReader4.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 4:
                dsl8 = (InitializationDeviceInfoKt.Dsl) anonymousClass1.L$6;
                dsl4 = (InitializationDeviceInfoKt.Dsl) anonymousClass1.L$5;
                dsl = (InitializationRequestKt.Dsl) anonymousClass1.L$4;
                dsl6 = (InitializationDeviceInfoKt.Dsl) anonymousClass1.L$3;
                dsl7 = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl5 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload2 = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                dsl8.setTotalRamMemory(((StaticDeviceInfoOuterClass.StaticDeviceInfo) objInvoke).getTotalRamMemory());
                dsl4.setCurrentUiTheme(androidGetInitializationRequestPayload2.deviceInfoRepository.getCurrentUiTheme());
                String networkOperator5 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getNetworkOperator();
                Intrinsics.checkNotNullExpressionValue(networkOperator5, "deviceInfoRepository.dyn…eviceInfo.networkOperator");
                dsl4.setNetworkOperator(networkOperator5);
                dsl4.setBatteryLevel(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryLevel());
                dsl4.setBatteryStatus(androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getBatteryStatus());
                dsl4.setSystemBootTime(androidGetInitializationRequestPayload2.deviceInfoRepository.getSystemBootTime());
                String language5 = androidGetInitializationRequestPayload2.deviceInfoRepository.getDynamicDeviceInfo().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language5, "deviceInfoRepository.dynamicDeviceInfo.language");
                dsl4.setLanguage(language5);
                dsl4.setLocalList(CollectionsKt.joinToString$default(androidGetInitializationRequestPayload2.deviceInfoRepository.getLocaleList(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                dsl4.setConnectionType(androidGetInitializationRequestPayload2.deviceInfoRepository.getConnectionTypeStr());
                dsl.setDeviceInfo(dsl6._build());
                DeviceInfoRepository deviceInfoRepository18 = androidGetInitializationRequestPayload2.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload2;
                anonymousClass1.L$1 = dsl5;
                anonymousClass1.L$2 = dsl7;
                anonymousClass1.L$3 = null;
                anonymousClass1.L$4 = null;
                anonymousClass1.L$5 = null;
                anonymousClass1.L$6 = null;
                anonymousClass1.label = 5;
                objInvoke = deviceInfoRepository18.getAuidByteString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl9 = dsl7;
                dsl10 = dsl5;
                androidGetInitializationRequestPayload3 = androidGetInitializationRequestPayload2;
                byteString = (ByteString) objInvoke;
                if (byteString != null) {
                    dsl9.setAuid(byteString);
                }
                DeviceInfoRepository deviceInfoRepository19 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository19.getAuidString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository9 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository9.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository10 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository10.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader5 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader5.getJsonStorage().get(mediationInitBlobMetadataReader5.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 5:
                dsl9 = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl10 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload3 = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                byteString = (ByteString) objInvoke;
                if (byteString != null) {
                    dsl9.setAuid(byteString);
                }
                DeviceInfoRepository deviceInfoRepository110 = androidGetInitializationRequestPayload3.deviceInfoRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 6;
                objInvoke = deviceInfoRepository110.getAuidString(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository11 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository11.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository12 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository12.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader6 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader6.getJsonStorage().get(mediationInitBlobMetadataReader6.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 6:
                dsl9 = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl10 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload3 = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                str = (String) objInvoke;
                str2 = str;
                if (str2 != null) {
                    dsl9.setAuidString(str);
                }
                SessionRepository sessionRepository13 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 7;
                objInvoke = sessionRepository13.getPrivacy(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository14 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository14.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader7 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader7.getJsonStorage().get(mediationInitBlobMetadataReader7.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 7:
                dsl9 = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl10 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload3 = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                byteString2 = (ByteString) objInvoke;
                if (!byteString2.isEmpty()) {
                    dsl9.setPrivacy(byteString2);
                }
                SessionRepository sessionRepository15 = androidGetInitializationRequestPayload3.sessionRepository;
                anonymousClass1.L$0 = androidGetInitializationRequestPayload3;
                anonymousClass1.L$1 = dsl10;
                anonymousClass1.L$2 = dsl9;
                anonymousClass1.label = 8;
                objInvoke = sessionRepository15.getGatewayCache(anonymousClass1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dsl11 = dsl9;
                dsl12 = dsl10;
                androidGetInitializationRequestPayload4 = androidGetInitializationRequestPayload3;
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader8 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader8.getJsonStorage().get(mediationInitBlobMetadataReader8.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            case 8:
                dsl11 = (InitializationRequestKt.Dsl) anonymousClass1.L$2;
                dsl12 = (InitializationRequestKt.Dsl) anonymousClass1.L$1;
                androidGetInitializationRequestPayload4 = (AndroidGetInitializationRequestPayload) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objInvoke);
                byteString3 = (ByteString) objInvoke;
                if (!byteString3.isEmpty()) {
                    dsl11.setCache(byteString3);
                }
                MediationInitBlobMetadataReader mediationInitBlobMetadataReader9 = androidGetInitializationRequestPayload4.mediationInitBlobMetadataReader;
                obj = mediationInitBlobMetadataReader9.getJsonStorage().get(mediationInitBlobMetadataReader9.getKey());
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    if (obj != null) {
                        obj2 = obj;
                    }
                }
                str3 = (String) obj2;
                if (str3 != null) {
                    dsl11.setUadsInitBlob(ByteStringsKt.toByteStringUtf8(str3));
                }
                legacyFlowUserConsent = androidGetInitializationRequestPayload4.legacyUserConsentRepository.getLegacyFlowUserConsent();
                if (legacyFlowUserConsent != null) {
                    dsl11.setLegacyFlowUserConsent(legacyFlowUserConsent);
                }
                return dsl12._build();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

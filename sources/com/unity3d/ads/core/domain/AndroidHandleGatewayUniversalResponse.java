package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.MutableDataOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: AndroidHandleGatewayUniversalResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidHandleGatewayUniversalResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayUniversalResponse;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "(Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;)V", "invoke", "", "response", "Lgatewayprotocol/v1/UniversalResponseOuterClass$UniversalResponse;", "(Lgatewayprotocol/v1/UniversalResponseOuterClass$UniversalResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidHandleGatewayUniversalResponse implements HandleGatewayUniversalResponse {
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayUniversalResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse", f = "AndroidHandleGatewayUniversalResponse.kt", i = {0, 0, 1, 1}, l = {35, 41, 44}, m = "invoke", n = {"this", "mutableData", "this", "mutableData"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidHandleGatewayUniversalResponse.this.invoke(null, this);
        }
    }

    public AndroidHandleGatewayUniversalResponse(SessionRepository sessionRepository, DeviceInfoRepository deviceInfoRepository) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        this.sessionRepository = sessionRepository;
        this.deviceInfoRepository = deviceInfoRepository;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:46:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.unity3d.ads.core.domain.HandleGatewayUniversalResponse
    public Object invoke(UniversalResponseOuterClass.UniversalResponse universalResponse, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        MutableDataOuterClass.MutableData mutableData;
        AllowedPiiOuterClass.AllowedPii value;
        AllowedPiiOuterClass.AllowedPii allowedPii;
        AndroidHandleGatewayUniversalResponse androidHandleGatewayUniversalResponse;
        SessionRepository sessionRepository;
        ByteString privacyFsm;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (universalResponse.hasError()) {
                String errorText = universalResponse.getError().getErrorText();
                Intrinsics.checkNotNullExpressionValue(errorText, "response.error.errorText");
                throw new GatewayException(errorText, new IllegalStateException(universalResponse.getError().getErrorText()), "gateway_universal", universalResponse.getError().getErrorText());
            }
            if (universalResponse.hasMutableData()) {
                mutableData = universalResponse.getMutableData();
                MutableStateFlow<AllowedPiiOuterClass.AllowedPii> allowedPii2 = this.deviceInfoRepository.getAllowedPii();
                do {
                    value = allowedPii2.getValue();
                    allowedPii = mutableData.getAllowedPii();
                    Intrinsics.checkNotNullExpressionValue(allowedPii, "mutableData.allowedPii");
                } while (!allowedPii2.compareAndSet(value, allowedPii));
                SessionRepository sessionRepository2 = this.sessionRepository;
                ByteString currentState = mutableData.getCurrentState();
                Intrinsics.checkNotNullExpressionValue(currentState, "mutableData.currentState");
                sessionRepository2.setGatewayState(currentState);
                if (mutableData.hasSessionToken()) {
                    SessionRepository sessionRepository3 = this.sessionRepository;
                    ByteString sessionToken = mutableData.getSessionToken();
                    Intrinsics.checkNotNullExpressionValue(sessionToken, "mutableData.sessionToken");
                    sessionRepository3.setSessionToken(sessionToken);
                }
                if (mutableData.hasPrivacy()) {
                    SessionRepository sessionRepository4 = this.sessionRepository;
                    ByteString privacy = mutableData.getPrivacy();
                    Intrinsics.checkNotNullExpressionValue(privacy, "mutableData.privacy");
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = mutableData;
                    anonymousClass1.label = 1;
                    if (sessionRepository4.setPrivacy(privacy, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                androidHandleGatewayUniversalResponse = this;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            mutableData = (MutableDataOuterClass.MutableData) anonymousClass1.L$1;
            androidHandleGatewayUniversalResponse = (AndroidHandleGatewayUniversalResponse) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i == 2) {
                mutableData = (MutableDataOuterClass.MutableData) anonymousClass1.L$1;
                androidHandleGatewayUniversalResponse = (AndroidHandleGatewayUniversalResponse) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                if (mutableData.hasPrivacyFsm()) {
                    sessionRepository = androidHandleGatewayUniversalResponse.sessionRepository;
                    privacyFsm = mutableData.getPrivacyFsm();
                    Intrinsics.checkNotNullExpressionValue(privacyFsm, "mutableData.privacyFsm");
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 3;
                    if (sessionRepository.setPrivacyFsm(privacyFsm, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        if (mutableData.hasSessionCounters()) {
            SessionRepository sessionRepository5 = androidHandleGatewayUniversalResponse.sessionRepository;
            SessionCountersOuterClass.SessionCounters sessionCounters = mutableData.getSessionCounters();
            Intrinsics.checkNotNullExpressionValue(sessionCounters, "mutableData.sessionCounters");
            sessionRepository5.setSessionCounters(sessionCounters);
        }
        if (mutableData.hasCache()) {
            SessionRepository sessionRepository6 = androidHandleGatewayUniversalResponse.sessionRepository;
            ByteString cache = mutableData.getCache();
            Intrinsics.checkNotNullExpressionValue(cache, "mutableData.cache");
            anonymousClass1.L$0 = androidHandleGatewayUniversalResponse;
            anonymousClass1.L$1 = mutableData;
            anonymousClass1.label = 2;
            if (sessionRepository6.setGatewayCache(cache, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (mutableData.hasPrivacyFsm()) {
            sessionRepository = androidHandleGatewayUniversalResponse.sessionRepository;
            privacyFsm = mutableData.getPrivacyFsm();
            Intrinsics.checkNotNullExpressionValue(privacyFsm, "mutableData.privacyFsm");
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            if (sessionRepository.setPrivacyFsm(privacyFsm, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}

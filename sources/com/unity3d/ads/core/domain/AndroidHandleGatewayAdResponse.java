package com.unity3d.ads.core.domain;

import android.content.Context;
import android.util.Base64;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.protobuf.ByteString;
import com.smaato.sdk.video.vast.model.Ad;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.Invocation;
import com.unity3d.ads.adplayer.WebViewBridge;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.WebViewConfiguration;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.properties.SdkProperties;
import com.vungle.ads.internal.protos.Sdk;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.CampaignKt;
import gatewayprotocol.v1.CampaignStateOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.OperativeEventErrorDataKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import java.net.URI;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J3\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#JI\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0096Bø\u0001\u0000¢\u0006\u0002\u00100R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidHandleGatewayAdResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "getWebViewContainerUseCase", "Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;", "getWebViewBridge", "Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "getHandleInvocationsFromAdViewer", "Lcom/unity3d/ads/core/domain/HandleInvocationsFromAdViewer;", "campaignRepository", "Lcom/unity3d/ads/core/data/repository/CampaignRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "getLatestWebViewConfiguration", "Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;", "adPlayerScope", "Lcom/unity3d/ads/adplayer/AdPlayerScope;", "getAdPlayer", "Lcom/unity3d/ads/core/domain/GetAdPlayer;", "(Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/domain/HandleInvocationsFromAdViewer;Lcom/unity3d/ads/core/data/repository/CampaignRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;Lcom/unity3d/ads/core/domain/GetLatestWebViewConfiguration;Lcom/unity3d/ads/adplayer/AdPlayerScope;Lcom/unity3d/ads/core/domain/GetAdPlayer;)V", "cleanup", "", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "", "opportunityId", "Lcom/google/protobuf/ByteString;", "response", "Lgatewayprotocol/v1/AdResponseOuterClass$AdResponse;", "adPlayer", "Lcom/unity3d/ads/adplayer/AdPlayer;", "(Ljava/lang/Throwable;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/AdResponseOuterClass$AdResponse;Lcom/unity3d/ads/adplayer/AdPlayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lcom/unity3d/ads/core/data/model/LoadResult;", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "context", "Landroid/content/Context;", "placementId", "", Ad.AD_TYPE, "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "", "(Lcom/unity3d/ads/UnityAdsLoadOptions;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/AdResponseOuterClass$AdResponse;Landroid/content/Context;Ljava/lang/String;Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidHandleGatewayAdResponse implements HandleGatewayAdResponse {
    private final AdPlayerScope adPlayerScope;
    private final AdRepository adRepository;
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetAdPlayer getAdPlayer;
    private final HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer;
    private final GetLatestWebViewConfiguration getLatestWebViewConfiguration;
    private final GetOperativeEventApi getOperativeEventApi;
    private final GetWebViewBridgeUseCase getWebViewBridge;
    private final AndroidGetWebViewContainerUseCase getWebViewContainerUseCase;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse", f = "AndroidHandleGatewayAdResponse.kt", i = {0}, l = {200, 206}, m = "cleanup", n = {"adPlayer"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidHandleGatewayAdResponse.this.cleanup(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse", f = "AndroidHandleGatewayAdResponse.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6}, l = {85, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 153, 162, 165, 178, 182}, m = "invoke", n = {"this", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "opportunityId", "response", "placementId", Ad.AD_TYPE, "adPlayer", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "this", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "opportunityId", "response", "placementId", Ad.AD_TYPE, "adPlayer", "webViewUrl", "base64ImpressionConfiguration", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "this", "opportunityId", "response", "adPlayer", "adObject", "this", "opportunityId", "response", "adPlayer", "adObject", "this", "opportunityId", "response", "adPlayer", "adObject", "loadEvent", "this", "opportunityId", "response", "adPlayer", "adObject", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
    static final class C37271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C37271(Continuation<? super C37271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidHandleGatewayAdResponse.this.invoke(null, null, null, null, null, null, false, this);
        }
    }

    public AndroidHandleGatewayAdResponse(AdRepository adRepository, AndroidGetWebViewContainerUseCase getWebViewContainerUseCase, GetWebViewBridgeUseCase getWebViewBridge, DeviceInfoRepository deviceInfoRepository, HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer, CampaignRepository campaignRepository, SendDiagnosticEvent sendDiagnosticEvent, GetOperativeEventApi getOperativeEventApi, GetLatestWebViewConfiguration getLatestWebViewConfiguration, AdPlayerScope adPlayerScope, GetAdPlayer getAdPlayer) {
        Intrinsics.checkNotNullParameter(adRepository, "adRepository");
        Intrinsics.checkNotNullParameter(getWebViewContainerUseCase, "getWebViewContainerUseCase");
        Intrinsics.checkNotNullParameter(getWebViewBridge, "getWebViewBridge");
        Intrinsics.checkNotNullParameter(deviceInfoRepository, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(getHandleInvocationsFromAdViewer, "getHandleInvocationsFromAdViewer");
        Intrinsics.checkNotNullParameter(campaignRepository, "campaignRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getOperativeEventApi, "getOperativeEventApi");
        Intrinsics.checkNotNullParameter(getLatestWebViewConfiguration, "getLatestWebViewConfiguration");
        Intrinsics.checkNotNullParameter(adPlayerScope, "adPlayerScope");
        Intrinsics.checkNotNullParameter(getAdPlayer, "getAdPlayer");
        this.adRepository = adRepository;
        this.getWebViewContainerUseCase = getWebViewContainerUseCase;
        this.getWebViewBridge = getWebViewBridge;
        this.deviceInfoRepository = deviceInfoRepository;
        this.getHandleInvocationsFromAdViewer = getHandleInvocationsFromAdViewer;
        this.campaignRepository = campaignRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getLatestWebViewConfiguration = getLatestWebViewConfiguration;
        this.adPlayerScope = adPlayerScope;
        this.getAdPlayer = getAdPlayer;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0401 A[Catch: CancellationException -> 0x0422, TRY_ENTER, TryCatch #0 {CancellationException -> 0x0422, blocks: (B:106:0x041c, B:93:0x03a5, B:95:0x03ab, B:103:0x0401, B:90:0x037c), top: B:140:0x037c }] */
    /* JADX WARN: Code duplicated, block: B:105:0x041b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x0495 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x049c  */
    /* JADX WARN: Code duplicated, block: B:155:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x01f1 A[Catch: CancellationException -> 0x044d, TRY_ENTER, TRY_LEAVE, TryCatch #12 {CancellationException -> 0x044d, blocks: (B:60:0x01c6, B:66:0x01f1), top: B:161:0x01c6 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0208  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0275 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0276  */
    /* JADX WARN: Code duplicated, block: B:88:0x0379 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x037a  */
    /* JADX WARN: Code duplicated, block: B:92:0x03a4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x03ab A[Catch: CancellationException -> 0x0422, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0422, blocks: (B:106:0x041c, B:93:0x03a5, B:95:0x03ab, B:103:0x0401, B:90:0x037c), top: B:140:0x037c }] */
    /* JADX WARN: Code duplicated, block: B:97:0x03da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x03db  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r40v1, types: [gatewayprotocol.v1.AdResponseOuterClass$AdResponse] */
    /* JADX WARN: Type inference failed for: r41v1, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r7v16, types: [T, com.unity3d.ads.adplayer.AdPlayer] */
    @Override // com.unity3d.ads.core.domain.HandleGatewayAdResponse
    public Object invoke(UnityAdsLoadOptions unityAdsLoadOptions, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Context context, String str, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, boolean z, Continuation<? super LoadResult> continuation) throws Throwable {
        C37271 c37271;
        CancellationException cancellationException;
        Object obj;
        ?? r13;
        ?? r14;
        ByteString byteString2;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse;
        ?? r5;
        NonCancellable nonCancellable;
        AnonymousClass6 anonymousClass6;
        ByteString byteString3;
        ?? r6;
        Throwable cause;
        AdResponseOuterClass.AdResponse adResponse2;
        UnityAdsLoadOptions unityAdsLoadOptions2;
        boolean z2;
        String str2;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType2;
        AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse2;
        AdResponseOuterClass.AdResponse adResponse3;
        Ref.ObjectRef objectRef;
        AdResponseOuterClass.AdResponse adResponse4;
        Ref.ObjectRef objectRef2;
        WebViewConfiguration webViewConfiguration;
        String it;
        String str3;
        String base64ImpressionConfiguration;
        Object objInvoke;
        boolean z3;
        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType3;
        UnityAdsLoadOptions unityAdsLoadOptions3;
        String str4;
        AdResponseOuterClass.AdResponse adResponse5;
        Ref.ObjectRef objectRef3;
        AdResponseOuterClass.AdResponse adResponse6;
        Ref.ObjectRef objectRef4;
        AdObject adObject;
        Object obj2;
        AdObject adObject2;
        AdResponseOuterClass.AdResponse adResponse7;
        Ref.ObjectRef objectRef5;
        AdResponseOuterClass.AdResponse adResponse8;
        Ref.ObjectRef objectRef6;
        LoadEvent loadEvent;
        AdRepository adRepository;
        NonCancellable nonCancellable2;
        AnonymousClass5 anonymousClass5;
        Ref.ObjectRef objectRef7;
        AdObject adObject3;
        LoadEvent loadEvent2;
        AdResponseOuterClass.AdResponse adResponse9;
        if (continuation instanceof C37271) {
            c37271 = (C37271) continuation;
            if ((c37271.label & Integer.MIN_VALUE) != 0) {
                c37271.label -= Integer.MIN_VALUE;
            } else {
                c37271 = new C37271(continuation);
            }
        } else {
            c37271 = new C37271(continuation);
        }
        Object objInvoke2 = c37271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37271.label;
        try {
            switch (i) {
                case 0:
                    ResultKt.throwOnFailure(objInvoke2);
                    Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                    try {
                        try {
                            if (adResponse.hasError()) {
                                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "gateway", adResponse.getError().getErrorText(), false, 36, null);
                            }
                            if (adResponse.getAdData().isEmpty()) {
                                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.NO_FILL, LoadResult.MSG_NO_FILL, null, "no_fill", null, false, 52, null);
                            }
                            GetLatestWebViewConfiguration getLatestWebViewConfiguration = this.getLatestWebViewConfiguration;
                            String entryPoint = adResponse.getWebviewConfiguration().getEntryPoint();
                            Integer numBoxInt = Boxing.boxInt(adResponse.getWebviewConfiguration().getVersion());
                            List<String> additionalFilesList = adResponse.getWebviewConfiguration().getAdditionalFilesList();
                            c37271.L$0 = this;
                            unityAdsLoadOptions2 = unityAdsLoadOptions;
                            c37271.L$1 = unityAdsLoadOptions2;
                            byteString2 = byteString;
                            try {
                                c37271.L$2 = byteString2;
                                adResponse2 = adResponse;
                                try {
                                    c37271.L$3 = adResponse2;
                                    c37271.L$4 = str;
                                    c37271.L$5 = diagnosticAdType;
                                    c37271.L$6 = objectRef8;
                                    z2 = z;
                                    c37271.Z$0 = z2;
                                    c37271.label = 1;
                                    objInvoke2 = getLatestWebViewConfiguration.invoke(entryPoint, numBoxInt, additionalFilesList, c37271);
                                    if (objInvoke2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str2 = str;
                                    diagnosticAdType2 = diagnosticAdType;
                                    androidHandleGatewayAdResponse2 = this;
                                    objectRef2 = objectRef8;
                                    adResponse4 = adResponse2;
                                    try {
                                        webViewConfiguration = (WebViewConfiguration) objInvoke2;
                                        if (webViewConfiguration.getEntryPoint().length() != 0) {
                                            it = SdkProperties.getConfigUrl();
                                            Intrinsics.checkNotNullExpressionValue(it, "it");
                                            try {
                                                if (!StringsKt.endsWith$default(it, ".html", false, 2, (Object) null)) {
                                                    it = null;
                                                }
                                                if (it == null) {
                                                    try {
                                                        it = webViewConfiguration.getEntryPoint();
                                                    } catch (CancellationException e) {
                                                        cancellationException = e;
                                                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                                                        obj = coroutine_suspended;
                                                        r5 = objectRef2;
                                                        r14 = adResponse4;
                                                    }
                                                }
                                                try {
                                                    str3 = StringsKt.substringBeforeLast$default(it, "?", (String) null, 2, (Object) null) + (UnityAdsConstants.DefaultUrls.AD_PLAYER_QUERY_PARAMS + new URI(it).getQuery());
                                                    base64ImpressionConfiguration = Base64.encodeToString(adResponse4.getImpressionConfiguration().toByteArray(), 2);
                                                    AndroidGetWebViewContainerUseCase androidGetWebViewContainerUseCase = androidHandleGatewayAdResponse2.getWebViewContainerUseCase;
                                                    AdPlayerScope adPlayerScope = androidHandleGatewayAdResponse2.adPlayerScope;
                                                    c37271.L$0 = androidHandleGatewayAdResponse2;
                                                    c37271.L$1 = unityAdsLoadOptions2;
                                                    c37271.L$2 = byteString2;
                                                    c37271.L$3 = adResponse4;
                                                    c37271.L$4 = str2;
                                                    c37271.L$5 = diagnosticAdType2;
                                                    c37271.L$6 = objectRef2;
                                                    c37271.L$7 = str3;
                                                    c37271.L$8 = base64ImpressionConfiguration;
                                                    c37271.Z$0 = z2;
                                                    c37271.label = 2;
                                                    objInvoke = androidGetWebViewContainerUseCase.invoke(adPlayerScope, c37271);
                                                    coroutine_suspended = coroutine_suspended;
                                                    if (objInvoke == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    z3 = z2;
                                                    diagnosticAdType3 = diagnosticAdType2;
                                                    unityAdsLoadOptions3 = unityAdsLoadOptions2;
                                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                                                    str4 = str3;
                                                    objInvoke2 = objInvoke;
                                                    objectRef4 = objectRef2;
                                                    adResponse6 = adResponse4;
                                                    try {
                                                        AndroidWebViewContainer androidWebViewContainer = (AndroidWebViewContainer) objInvoke2;
                                                        WebViewBridge webViewBridgeInvoke = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer, androidHandleGatewayAdResponse.adPlayerScope);
                                                        objectRef4.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(webViewBridgeInvoke, androidWebViewContainer, byteString2);
                                                        FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AnonymousClass2(objectRef4, null)), ((AdPlayer) objectRef4.element).getScope());
                                                        FlowKt.launchIn(FlowKt.onEach(((AdPlayer) objectRef4.element).getUpdateCampaignState(), androidHandleGatewayAdResponse.new AnonymousClass3(byteString2, str2, null)), ((AdPlayer) objectRef4.element).getScope());
                                                        ByteString trackingToken = adResponse6.getTrackingToken();
                                                        AdPlayer adPlayer = (AdPlayer) objectRef4.element;
                                                        Intrinsics.checkNotNullExpressionValue(trackingToken, "trackingToken");
                                                        adObject = new AdObject(byteString2, str2, trackingToken, false, null, null, null, false, null, adPlayer, null, unityAdsLoadOptions3, z3, diagnosticAdType3, 1528, null);
                                                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, adObject, 14, null);
                                                        HandleInvocationsFromAdViewer handleInvocationsFromAdViewer = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                                                        SharedFlow<Invocation> onInvocation = webViewBridgeInvoke.getOnInvocation();
                                                        ByteString adData = adResponse6.getAdData();
                                                        Intrinsics.checkNotNullExpressionValue(adData, "response.adData");
                                                        String base64$default = ProtobufExtensionsKt.toBase64$default(adData, false, 1, null);
                                                        ByteString adDataRefreshToken = adResponse6.getAdDataRefreshToken();
                                                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken, "response.adDataRefreshToken");
                                                        obj2 = coroutine_suspended;
                                                        try {
                                                            String base64$default2 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken, false, 1, null);
                                                            Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                                                            AnonymousClass4 anonymousClass4 = new AnonymousClass4(androidWebViewContainer, str4, null);
                                                            c37271.L$0 = androidHandleGatewayAdResponse;
                                                            c37271.L$1 = byteString2;
                                                            c37271.L$2 = adResponse6;
                                                            c37271.L$3 = objectRef4;
                                                            c37271.L$4 = adObject;
                                                            c37271.L$5 = null;
                                                            c37271.L$6 = null;
                                                            c37271.L$7 = null;
                                                            c37271.L$8 = null;
                                                            c37271.label = 3;
                                                            objInvoke2 = handleInvocationsFromAdViewer.invoke(onInvocation, base64$default, base64$default2, base64ImpressionConfiguration, adObject, anonymousClass4, c37271);
                                                            obj = obj2;
                                                            if (objInvoke2 == obj) {
                                                                return obj;
                                                            }
                                                            adObject2 = adObject;
                                                            byteString3 = byteString2;
                                                            objectRef5 = objectRef4;
                                                            adResponse7 = adResponse6;
                                                            try {
                                                                FlowKt.launchIn((Flow) objInvoke2, ((AdPlayer) objectRef5.element).getScope());
                                                                Flow<LoadEvent> onLoadEvent = ((AdPlayer) objectRef5.element).getOnLoadEvent();
                                                                c37271.L$0 = androidHandleGatewayAdResponse;
                                                                c37271.L$1 = byteString3;
                                                                c37271.L$2 = adResponse7;
                                                                c37271.L$3 = objectRef5;
                                                                c37271.L$4 = adObject2;
                                                                c37271.label = 4;
                                                                objInvoke2 = FlowKt.single(onLoadEvent, c37271);
                                                                objectRef6 = objectRef5;
                                                                adResponse8 = adResponse7;
                                                                if (objInvoke2 == obj) {
                                                                    return obj;
                                                                }
                                                                loadEvent = (LoadEvent) objInvoke2;
                                                                if (!(loadEvent instanceof LoadEvent.Error)) {
                                                                    androidHandleGatewayAdResponse.campaignRepository.setLoadTimestamp(byteString3);
                                                                    adRepository = androidHandleGatewayAdResponse.adRepository;
                                                                    c37271.L$0 = androidHandleGatewayAdResponse;
                                                                    c37271.L$1 = byteString3;
                                                                    c37271.L$2 = adResponse8;
                                                                    c37271.L$3 = objectRef6;
                                                                    c37271.L$4 = adObject2;
                                                                    c37271.label = 6;
                                                                    if (adRepository.addAd(byteString3, adObject2, c37271) == obj) {
                                                                        return obj;
                                                                    }
                                                                    return new LoadResult.Success(adObject2);
                                                                }
                                                                nonCancellable2 = NonCancellable.INSTANCE;
                                                                anonymousClass5 = androidHandleGatewayAdResponse.new AnonymousClass5(loadEvent, byteString3, adResponse8, objectRef6, null);
                                                                c37271.L$0 = androidHandleGatewayAdResponse;
                                                                c37271.L$1 = byteString3;
                                                                c37271.L$2 = adResponse8;
                                                                c37271.L$3 = objectRef6;
                                                                c37271.L$4 = adObject2;
                                                                c37271.L$5 = loadEvent;
                                                                c37271.label = 5;
                                                                if (BuildersKt.withContext(nonCancellable2, anonymousClass5, c37271) == obj) {
                                                                    return obj;
                                                                }
                                                                objectRef7 = objectRef6;
                                                                adObject3 = adObject2;
                                                                loadEvent2 = loadEvent;
                                                                adResponse9 = adResponse8;
                                                                try {
                                                                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                                                                } catch (CancellationException e2) {
                                                                    cancellationException = e2;
                                                                    r6 = objectRef7;
                                                                    r13 = adResponse9;
                                                                    byteString2 = byteString3;
                                                                    r5 = r6;
                                                                    r14 = r13;
                                                                    nonCancellable = NonCancellable.INSTANCE;
                                                                    anonymousClass6 = androidHandleGatewayAdResponse.new AnonymousClass6(cancellationException, byteString2, r14, r5, null);
                                                                    c37271.L$0 = cancellationException;
                                                                    c37271.L$1 = null;
                                                                    c37271.L$2 = null;
                                                                    c37271.L$3 = null;
                                                                    c37271.L$4 = null;
                                                                    c37271.L$5 = null;
                                                                    c37271.L$6 = null;
                                                                    c37271.L$7 = null;
                                                                    c37271.L$8 = null;
                                                                    c37271.label = 7;
                                                                    if (BuildersKt.withContext(nonCancellable, anonymousClass6, c37271) == obj) {
                                                                        return obj;
                                                                    }
                                                                    cause = cancellationException.getCause();
                                                                    if (cause == null) {
                                                                        throw cancellationException;
                                                                    }
                                                                    throw cause;
                                                                }
                                                            } catch (CancellationException e3) {
                                                                cancellationException = e3;
                                                                r6 = objectRef5;
                                                                r13 = adResponse7;
                                                                byteString2 = byteString3;
                                                                r5 = r6;
                                                                r14 = r13;
                                                                nonCancellable = NonCancellable.INSTANCE;
                                                                anonymousClass6 = androidHandleGatewayAdResponse.new AnonymousClass6(cancellationException, byteString2, r14, r5, null);
                                                                c37271.L$0 = cancellationException;
                                                                c37271.L$1 = null;
                                                                c37271.L$2 = null;
                                                                c37271.L$3 = null;
                                                                c37271.L$4 = null;
                                                                c37271.L$5 = null;
                                                                c37271.L$6 = null;
                                                                c37271.L$7 = null;
                                                                c37271.L$8 = null;
                                                                c37271.label = 7;
                                                                if (BuildersKt.withContext(nonCancellable, anonymousClass6, c37271) == obj) {
                                                                    return obj;
                                                                }
                                                                cause = cancellationException.getCause();
                                                                if (cause == null) {
                                                                    throw cancellationException;
                                                                }
                                                                throw cause;
                                                            }
                                                        } catch (CancellationException e4) {
                                                            e = e4;
                                                            obj = obj2;
                                                            objectRef3 = objectRef4;
                                                            adResponse5 = adResponse6;
                                                        }
                                                    } catch (CancellationException e5) {
                                                        e = e5;
                                                        obj = coroutine_suspended;
                                                        objectRef3 = objectRef4;
                                                        adResponse5 = adResponse6;
                                                    }
                                                } catch (Throwable unused) {
                                                    obj = coroutine_suspended;
                                                    try {
                                                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "invalid_url", it, false, 36, null);
                                                    } catch (CancellationException e6) {
                                                        e = e6;
                                                    }
                                                }
                                            } catch (CancellationException e7) {
                                                e = e7;
                                                obj = coroutine_suspended;
                                            }
                                            break;
                                        } else {
                                            try {
                                                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "no_webview_entry_point", null, false, 52, null);
                                            } catch (CancellationException e8) {
                                                cancellationException = e8;
                                                obj = coroutine_suspended;
                                                objectRef = objectRef2;
                                                adResponse3 = adResponse4;
                                            }
                                        }
                                    } catch (CancellationException e9) {
                                        e = e9;
                                        obj = coroutine_suspended;
                                    }
                                    cancellationException = e;
                                    objectRef = objectRef2;
                                    adResponse3 = adResponse4;
                                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                                    r5 = objectRef;
                                    r14 = adResponse3;
                                    nonCancellable = NonCancellable.INSTANCE;
                                    anonymousClass6 = androidHandleGatewayAdResponse.new AnonymousClass6(cancellationException, byteString2, r14, r5, null);
                                    c37271.L$0 = cancellationException;
                                    c37271.L$1 = null;
                                    c37271.L$2 = null;
                                    c37271.L$3 = null;
                                    c37271.L$4 = null;
                                    c37271.L$5 = null;
                                    c37271.L$6 = null;
                                    c37271.L$7 = null;
                                    c37271.L$8 = null;
                                    c37271.label = 7;
                                    if (BuildersKt.withContext(nonCancellable, anonymousClass6, c37271) == obj) {
                                        return obj;
                                    }
                                    cause = cancellationException.getCause();
                                    if (cause == null) {
                                        throw cancellationException;
                                    }
                                    throw cause;
                                } catch (CancellationException e10) {
                                    e = e10;
                                    obj = coroutine_suspended;
                                    androidHandleGatewayAdResponse = this;
                                    objectRef3 = objectRef8;
                                    adResponse5 = adResponse2;
                                }
                            } catch (CancellationException e11) {
                                e = e11;
                                adResponse2 = adResponse;
                            }
                        } catch (CancellationException e12) {
                            byteString2 = byteString;
                            r14 = adResponse;
                            cancellationException = e12;
                            androidHandleGatewayAdResponse = this;
                            obj = coroutine_suspended;
                            r5 = objectRef8;
                        }
                    } catch (CancellationException e13) {
                        e = e13;
                        byteString2 = byteString;
                    }
                    adResponse2 = adResponse;
                    obj = coroutine_suspended;
                    androidHandleGatewayAdResponse = this;
                    objectRef3 = objectRef8;
                    adResponse5 = adResponse2;
                    cancellationException = e;
                    r5 = objectRef3;
                    r14 = adResponse5;
                    nonCancellable = NonCancellable.INSTANCE;
                    anonymousClass6 = androidHandleGatewayAdResponse.new AnonymousClass6(cancellationException, byteString2, r14, r5, null);
                    c37271.L$0 = cancellationException;
                    c37271.L$1 = null;
                    c37271.L$2 = null;
                    c37271.L$3 = null;
                    c37271.L$4 = null;
                    c37271.L$5 = null;
                    c37271.L$6 = null;
                    c37271.L$7 = null;
                    c37271.L$8 = null;
                    c37271.label = 7;
                    if (BuildersKt.withContext(nonCancellable, anonymousClass6, c37271) == obj) {
                        return obj;
                    }
                    cause = cancellationException.getCause();
                    if (cause == null) {
                        throw cancellationException;
                    }
                    throw cause;
                case 1:
                    boolean z4 = c37271.Z$0;
                    Ref.ObjectRef objectRef9 = (Ref.ObjectRef) c37271.L$6;
                    diagnosticAdType2 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) c37271.L$5;
                    str2 = (String) c37271.L$4;
                    AdResponseOuterClass.AdResponse adResponse10 = (AdResponseOuterClass.AdResponse) c37271.L$3;
                    byteString2 = (ByteString) c37271.L$2;
                    UnityAdsLoadOptions unityAdsLoadOptions4 = (UnityAdsLoadOptions) c37271.L$1;
                    androidHandleGatewayAdResponse2 = (AndroidHandleGatewayAdResponse) c37271.L$0;
                    try {
                        ResultKt.throwOnFailure(objInvoke2);
                        z2 = z4;
                        objectRef2 = objectRef9;
                        adResponse4 = adResponse10;
                        unityAdsLoadOptions2 = unityAdsLoadOptions4;
                        webViewConfiguration = (WebViewConfiguration) objInvoke2;
                        if (webViewConfiguration.getEntryPoint().length() != 0) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_COMMUNICATION_FAILURE, null, "no_webview_entry_point", null, false, 52, null);
                        }
                        it = SdkProperties.getConfigUrl();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (!StringsKt.endsWith$default(it, ".html", false, 2, (Object) null)) {
                            it = null;
                        }
                        if (it == null) {
                            it = webViewConfiguration.getEntryPoint();
                            break;
                        }
                        str3 = StringsKt.substringBeforeLast$default(it, "?", (String) null, 2, (Object) null) + (UnityAdsConstants.DefaultUrls.AD_PLAYER_QUERY_PARAMS + new URI(it).getQuery());
                        base64ImpressionConfiguration = Base64.encodeToString(adResponse4.getImpressionConfiguration().toByteArray(), 2);
                        AndroidGetWebViewContainerUseCase androidGetWebViewContainerUseCase2 = androidHandleGatewayAdResponse2.getWebViewContainerUseCase;
                        AdPlayerScope adPlayerScope2 = androidHandleGatewayAdResponse2.adPlayerScope;
                        c37271.L$0 = androidHandleGatewayAdResponse2;
                        c37271.L$1 = unityAdsLoadOptions2;
                        c37271.L$2 = byteString2;
                        c37271.L$3 = adResponse4;
                        c37271.L$4 = str2;
                        c37271.L$5 = diagnosticAdType2;
                        c37271.L$6 = objectRef2;
                        c37271.L$7 = str3;
                        c37271.L$8 = base64ImpressionConfiguration;
                        c37271.Z$0 = z2;
                        c37271.label = 2;
                        objInvoke = androidGetWebViewContainerUseCase2.invoke(adPlayerScope2, c37271);
                        coroutine_suspended = coroutine_suspended;
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z3 = z2;
                        diagnosticAdType3 = diagnosticAdType2;
                        unityAdsLoadOptions3 = unityAdsLoadOptions2;
                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                        str4 = str3;
                        objInvoke2 = objInvoke;
                        objectRef4 = objectRef2;
                        adResponse6 = adResponse4;
                        AndroidWebViewContainer androidWebViewContainer2 = (AndroidWebViewContainer) objInvoke2;
                        WebViewBridge webViewBridgeInvoke2 = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer2, androidHandleGatewayAdResponse.adPlayerScope);
                        objectRef4.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(webViewBridgeInvoke2, androidWebViewContainer2, byteString2);
                        FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AnonymousClass2(objectRef4, null)), ((AdPlayer) objectRef4.element).getScope());
                        FlowKt.launchIn(FlowKt.onEach(((AdPlayer) objectRef4.element).getUpdateCampaignState(), androidHandleGatewayAdResponse.new AnonymousClass3(byteString2, str2, null)), ((AdPlayer) objectRef4.element).getScope());
                        ByteString trackingToken2 = adResponse6.getTrackingToken();
                        AdPlayer adPlayer2 = (AdPlayer) objectRef4.element;
                        Intrinsics.checkNotNullExpressionValue(trackingToken2, "trackingToken");
                        adObject = new AdObject(byteString2, str2, trackingToken2, false, null, null, null, false, null, adPlayer2, null, unityAdsLoadOptions3, z3, diagnosticAdType3, 1528, null);
                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, adObject, 14, null);
                        HandleInvocationsFromAdViewer handleInvocationsFromAdViewer2 = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                        SharedFlow<Invocation> onInvocation2 = webViewBridgeInvoke2.getOnInvocation();
                        ByteString adData2 = adResponse6.getAdData();
                        Intrinsics.checkNotNullExpressionValue(adData2, "response.adData");
                        String base64$default3 = ProtobufExtensionsKt.toBase64$default(adData2, false, 1, null);
                        ByteString adDataRefreshToken2 = adResponse6.getAdDataRefreshToken();
                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken2, "response.adDataRefreshToken");
                        obj2 = coroutine_suspended;
                        String base64$default4 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken2, false, 1, null);
                        Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                        AnonymousClass4 anonymousClass7 = new AnonymousClass4(androidWebViewContainer2, str4, null);
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString2;
                        c37271.L$2 = adResponse6;
                        c37271.L$3 = objectRef4;
                        c37271.L$4 = adObject;
                        c37271.L$5 = null;
                        c37271.L$6 = null;
                        c37271.L$7 = null;
                        c37271.L$8 = null;
                        c37271.label = 3;
                        objInvoke2 = handleInvocationsFromAdViewer2.invoke(onInvocation2, base64$default3, base64$default4, base64ImpressionConfiguration, adObject, anonymousClass7, c37271);
                        obj = obj2;
                        if (objInvoke2 == obj) {
                            return obj;
                        }
                        adObject2 = adObject;
                        byteString3 = byteString2;
                        objectRef5 = objectRef4;
                        adResponse7 = adResponse6;
                        FlowKt.launchIn((Flow) objInvoke2, ((AdPlayer) objectRef5.element).getScope());
                        Flow<LoadEvent> onLoadEvent2 = ((AdPlayer) objectRef5.element).getOnLoadEvent();
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString3;
                        c37271.L$2 = adResponse7;
                        c37271.L$3 = objectRef5;
                        c37271.L$4 = adObject2;
                        c37271.label = 4;
                        objInvoke2 = FlowKt.single(onLoadEvent2, c37271);
                        objectRef6 = objectRef5;
                        adResponse8 = adResponse7;
                        if (objInvoke2 == obj) {
                            return obj;
                        }
                        loadEvent = (LoadEvent) objInvoke2;
                        if (!(loadEvent instanceof LoadEvent.Error)) {
                            androidHandleGatewayAdResponse.campaignRepository.setLoadTimestamp(byteString3);
                            adRepository = androidHandleGatewayAdResponse.adRepository;
                            c37271.L$0 = androidHandleGatewayAdResponse;
                            c37271.L$1 = byteString3;
                            c37271.L$2 = adResponse8;
                            c37271.L$3 = objectRef6;
                            c37271.L$4 = adObject2;
                            c37271.label = 6;
                            if (adRepository.addAd(byteString3, adObject2, c37271) == obj) {
                                return obj;
                            }
                            return new LoadResult.Success(adObject2);
                        }
                        nonCancellable2 = NonCancellable.INSTANCE;
                        anonymousClass5 = androidHandleGatewayAdResponse.new AnonymousClass5(loadEvent, byteString3, adResponse8, objectRef6, null);
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString3;
                        c37271.L$2 = adResponse8;
                        c37271.L$3 = objectRef6;
                        c37271.L$4 = adObject2;
                        c37271.L$5 = loadEvent;
                        c37271.label = 5;
                        if (BuildersKt.withContext(nonCancellable2, anonymousClass5, c37271) == obj) {
                            return obj;
                        }
                        objectRef7 = objectRef6;
                        adObject3 = adObject2;
                        loadEvent2 = loadEvent;
                        adResponse9 = adResponse8;
                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                        cancellationException = e;
                        objectRef = objectRef2;
                        adResponse3 = adResponse4;
                    } catch (CancellationException e14) {
                        cancellationException = e14;
                        obj = coroutine_suspended;
                        objectRef = objectRef9;
                        adResponse3 = adResponse10;
                    }
                    androidHandleGatewayAdResponse = androidHandleGatewayAdResponse2;
                    r5 = objectRef;
                    r14 = adResponse3;
                    nonCancellable = NonCancellable.INSTANCE;
                    anonymousClass6 = androidHandleGatewayAdResponse.new AnonymousClass6(cancellationException, byteString2, r14, r5, null);
                    c37271.L$0 = cancellationException;
                    c37271.L$1 = null;
                    c37271.L$2 = null;
                    c37271.L$3 = null;
                    c37271.L$4 = null;
                    c37271.L$5 = null;
                    c37271.L$6 = null;
                    c37271.L$7 = null;
                    c37271.L$8 = null;
                    c37271.label = 7;
                    if (BuildersKt.withContext(nonCancellable, anonymousClass6, c37271) == obj) {
                        return obj;
                    }
                    cause = cancellationException.getCause();
                    if (cause == null) {
                        throw cancellationException;
                    }
                    throw cause;
                case 2:
                    boolean z5 = c37271.Z$0;
                    String str5 = (String) c37271.L$8;
                    String str6 = (String) c37271.L$7;
                    Ref.ObjectRef objectRef10 = (Ref.ObjectRef) c37271.L$6;
                    DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType4 = (DiagnosticEventRequestOuterClass.DiagnosticAdType) c37271.L$5;
                    String str7 = (String) c37271.L$4;
                    AdResponseOuterClass.AdResponse adResponse11 = (AdResponseOuterClass.AdResponse) c37271.L$3;
                    ByteString byteString4 = (ByteString) c37271.L$2;
                    UnityAdsLoadOptions unityAdsLoadOptions5 = (UnityAdsLoadOptions) c37271.L$1;
                    AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse3 = (AndroidHandleGatewayAdResponse) c37271.L$0;
                    try {
                        ResultKt.throwOnFailure(objInvoke2);
                        z3 = z5;
                        base64ImpressionConfiguration = str5;
                        str4 = str6;
                        objectRef4 = objectRef10;
                        diagnosticAdType3 = diagnosticAdType4;
                        str2 = str7;
                        byteString2 = byteString4;
                        unityAdsLoadOptions3 = unityAdsLoadOptions5;
                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                        adResponse6 = adResponse11;
                        AndroidWebViewContainer androidWebViewContainer3 = (AndroidWebViewContainer) objInvoke2;
                        WebViewBridge webViewBridgeInvoke3 = androidHandleGatewayAdResponse.getWebViewBridge.invoke(androidWebViewContainer3, androidHandleGatewayAdResponse.adPlayerScope);
                        objectRef4.element = androidHandleGatewayAdResponse.getAdPlayer.invoke(webViewBridgeInvoke3, androidWebViewContainer3, byteString2);
                        FlowKt.launchIn(FlowKt.onEach(androidHandleGatewayAdResponse.deviceInfoRepository.getAllowedPii(), new AnonymousClass2(objectRef4, null)), ((AdPlayer) objectRef4.element).getScope());
                        FlowKt.launchIn(FlowKt.onEach(((AdPlayer) objectRef4.element).getUpdateCampaignState(), androidHandleGatewayAdResponse.new AnonymousClass3(byteString2, str2, null)), ((AdPlayer) objectRef4.element).getScope());
                        ByteString trackingToken3 = adResponse6.getTrackingToken();
                        AdPlayer adPlayer3 = (AdPlayer) objectRef4.element;
                        Intrinsics.checkNotNullExpressionValue(trackingToken3, "trackingToken");
                        adObject = new AdObject(byteString2, str2, trackingToken3, false, null, null, null, false, null, adPlayer3, null, unityAdsLoadOptions3, z3, diagnosticAdType3, 1528, null);
                        SendDiagnosticEvent.DefaultImpls.invoke$default(androidHandleGatewayAdResponse.sendDiagnosticEvent, "native_load_started_ad_viewer", null, null, null, adObject, 14, null);
                        HandleInvocationsFromAdViewer handleInvocationsFromAdViewer3 = androidHandleGatewayAdResponse.getHandleInvocationsFromAdViewer;
                        SharedFlow<Invocation> onInvocation3 = webViewBridgeInvoke3.getOnInvocation();
                        ByteString adData3 = adResponse6.getAdData();
                        Intrinsics.checkNotNullExpressionValue(adData3, "response.adData");
                        String base64$default5 = ProtobufExtensionsKt.toBase64$default(adData3, false, 1, null);
                        ByteString adDataRefreshToken3 = adResponse6.getAdDataRefreshToken();
                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken3, "response.adDataRefreshToken");
                        obj2 = coroutine_suspended;
                        String base64$default6 = ProtobufExtensionsKt.toBase64$default(adDataRefreshToken3, false, 1, null);
                        Intrinsics.checkNotNullExpressionValue(base64ImpressionConfiguration, "base64ImpressionConfiguration");
                        AnonymousClass4 anonymousClass8 = new AnonymousClass4(androidWebViewContainer3, str4, null);
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString2;
                        c37271.L$2 = adResponse6;
                        c37271.L$3 = objectRef4;
                        c37271.L$4 = adObject;
                        c37271.L$5 = null;
                        c37271.L$6 = null;
                        c37271.L$7 = null;
                        c37271.L$8 = null;
                        c37271.label = 3;
                        objInvoke2 = handleInvocationsFromAdViewer3.invoke(onInvocation3, base64$default5, base64$default6, base64ImpressionConfiguration, adObject, anonymousClass8, c37271);
                        obj = obj2;
                        if (objInvoke2 == obj) {
                            return obj;
                        }
                        adObject2 = adObject;
                        byteString3 = byteString2;
                        objectRef5 = objectRef4;
                        adResponse7 = adResponse6;
                        FlowKt.launchIn((Flow) objInvoke2, ((AdPlayer) objectRef5.element).getScope());
                        Flow<LoadEvent> onLoadEvent3 = ((AdPlayer) objectRef5.element).getOnLoadEvent();
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString3;
                        c37271.L$2 = adResponse7;
                        c37271.L$3 = objectRef5;
                        c37271.L$4 = adObject2;
                        c37271.label = 4;
                        objInvoke2 = FlowKt.single(onLoadEvent3, c37271);
                        objectRef6 = objectRef5;
                        adResponse8 = adResponse7;
                        if (objInvoke2 == obj) {
                            return obj;
                        }
                        loadEvent = (LoadEvent) objInvoke2;
                        if (!(loadEvent instanceof LoadEvent.Error)) {
                            androidHandleGatewayAdResponse.campaignRepository.setLoadTimestamp(byteString3);
                            adRepository = androidHandleGatewayAdResponse.adRepository;
                            c37271.L$0 = androidHandleGatewayAdResponse;
                            c37271.L$1 = byteString3;
                            c37271.L$2 = adResponse8;
                            c37271.L$3 = objectRef6;
                            c37271.L$4 = adObject2;
                            c37271.label = 6;
                            if (adRepository.addAd(byteString3, adObject2, c37271) == obj) {
                                return obj;
                            }
                            return new LoadResult.Success(adObject2);
                        }
                        nonCancellable2 = NonCancellable.INSTANCE;
                        anonymousClass5 = androidHandleGatewayAdResponse.new AnonymousClass5(loadEvent, byteString3, adResponse8, objectRef6, null);
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString3;
                        c37271.L$2 = adResponse8;
                        c37271.L$3 = objectRef6;
                        c37271.L$4 = adObject2;
                        c37271.L$5 = loadEvent;
                        c37271.label = 5;
                        if (BuildersKt.withContext(nonCancellable2, anonymousClass5, c37271) == obj) {
                            return obj;
                        }
                        objectRef7 = objectRef6;
                        adObject3 = adObject2;
                        loadEvent2 = loadEvent;
                        adResponse9 = adResponse8;
                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                    } catch (CancellationException e15) {
                        cancellationException = e15;
                        obj = coroutine_suspended;
                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse3;
                        r5 = objectRef10;
                        byteString2 = byteString4;
                        r14 = adResponse11;
                    }
                    break;
                case 3:
                    adObject2 = (AdObject) c37271.L$4;
                    Ref.ObjectRef objectRef11 = (Ref.ObjectRef) c37271.L$3;
                    AdResponseOuterClass.AdResponse adResponse12 = (AdResponseOuterClass.AdResponse) c37271.L$2;
                    byteString3 = (ByteString) c37271.L$1;
                    androidHandleGatewayAdResponse = (AndroidHandleGatewayAdResponse) c37271.L$0;
                    ResultKt.throwOnFailure(objInvoke2);
                    obj = coroutine_suspended;
                    adResponse7 = adResponse12;
                    objectRef5 = objectRef11;
                    FlowKt.launchIn((Flow) objInvoke2, ((AdPlayer) objectRef5.element).getScope());
                    Flow<LoadEvent> onLoadEvent4 = ((AdPlayer) objectRef5.element).getOnLoadEvent();
                    c37271.L$0 = androidHandleGatewayAdResponse;
                    c37271.L$1 = byteString3;
                    c37271.L$2 = adResponse7;
                    c37271.L$3 = objectRef5;
                    c37271.L$4 = adObject2;
                    c37271.label = 4;
                    objInvoke2 = FlowKt.single(onLoadEvent4, c37271);
                    objectRef6 = objectRef5;
                    adResponse8 = adResponse7;
                    if (objInvoke2 == obj) {
                        return obj;
                    }
                    loadEvent = (LoadEvent) objInvoke2;
                    if (!(loadEvent instanceof LoadEvent.Error)) {
                        androidHandleGatewayAdResponse.campaignRepository.setLoadTimestamp(byteString3);
                        adRepository = androidHandleGatewayAdResponse.adRepository;
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString3;
                        c37271.L$2 = adResponse8;
                        c37271.L$3 = objectRef6;
                        c37271.L$4 = adObject2;
                        c37271.label = 6;
                        if (adRepository.addAd(byteString3, adObject2, c37271) == obj) {
                            return obj;
                        }
                        return new LoadResult.Success(adObject2);
                    }
                    nonCancellable2 = NonCancellable.INSTANCE;
                    anonymousClass5 = androidHandleGatewayAdResponse.new AnonymousClass5(loadEvent, byteString3, adResponse8, objectRef6, null);
                    c37271.L$0 = androidHandleGatewayAdResponse;
                    c37271.L$1 = byteString3;
                    c37271.L$2 = adResponse8;
                    c37271.L$3 = objectRef6;
                    c37271.L$4 = adObject2;
                    c37271.L$5 = loadEvent;
                    c37271.label = 5;
                    if (BuildersKt.withContext(nonCancellable2, anonymousClass5, c37271) == obj) {
                        return obj;
                    }
                    objectRef7 = objectRef6;
                    adObject3 = adObject2;
                    loadEvent2 = loadEvent;
                    adResponse9 = adResponse8;
                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                case 4:
                    adObject2 = (AdObject) c37271.L$4;
                    Ref.ObjectRef objectRef12 = (Ref.ObjectRef) c37271.L$3;
                    AdResponseOuterClass.AdResponse adResponse13 = (AdResponseOuterClass.AdResponse) c37271.L$2;
                    byteString3 = (ByteString) c37271.L$1;
                    androidHandleGatewayAdResponse = (AndroidHandleGatewayAdResponse) c37271.L$0;
                    ResultKt.throwOnFailure(objInvoke2);
                    obj = coroutine_suspended;
                    adResponse8 = adResponse13;
                    objectRef6 = objectRef12;
                    loadEvent = (LoadEvent) objInvoke2;
                    if (!(loadEvent instanceof LoadEvent.Error)) {
                        androidHandleGatewayAdResponse.campaignRepository.setLoadTimestamp(byteString3);
                        adRepository = androidHandleGatewayAdResponse.adRepository;
                        c37271.L$0 = androidHandleGatewayAdResponse;
                        c37271.L$1 = byteString3;
                        c37271.L$2 = adResponse8;
                        c37271.L$3 = objectRef6;
                        c37271.L$4 = adObject2;
                        c37271.label = 6;
                        if (adRepository.addAd(byteString3, adObject2, c37271) == obj) {
                            return obj;
                        }
                        return new LoadResult.Success(adObject2);
                    }
                    nonCancellable2 = NonCancellable.INSTANCE;
                    anonymousClass5 = androidHandleGatewayAdResponse.new AnonymousClass5(loadEvent, byteString3, adResponse8, objectRef6, null);
                    c37271.L$0 = androidHandleGatewayAdResponse;
                    c37271.L$1 = byteString3;
                    c37271.L$2 = adResponse8;
                    c37271.L$3 = objectRef6;
                    c37271.L$4 = adObject2;
                    c37271.L$5 = loadEvent;
                    c37271.label = 5;
                    if (BuildersKt.withContext(nonCancellable2, anonymousClass5, c37271) == obj) {
                        return obj;
                    }
                    objectRef7 = objectRef6;
                    adObject3 = adObject2;
                    loadEvent2 = loadEvent;
                    adResponse9 = adResponse8;
                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                case 5:
                    loadEvent2 = (LoadEvent) c37271.L$5;
                    adObject3 = (AdObject) c37271.L$4;
                    Ref.ObjectRef objectRef13 = (Ref.ObjectRef) c37271.L$3;
                    AdResponseOuterClass.AdResponse adResponse14 = (AdResponseOuterClass.AdResponse) c37271.L$2;
                    ByteString byteString5 = (ByteString) c37271.L$1;
                    AndroidHandleGatewayAdResponse androidHandleGatewayAdResponse4 = (AndroidHandleGatewayAdResponse) c37271.L$0;
                    try {
                        ResultKt.throwOnFailure(objInvoke2);
                        obj = coroutine_suspended;
                        adResponse9 = adResponse14;
                        byteString3 = byteString5;
                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse4;
                        objectRef7 = objectRef13;
                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "adviewer", ((LoadEvent.Error) loadEvent2).getMessage(), adObject3.isScarAd(), 4, null);
                    } catch (CancellationException e16) {
                        cancellationException = e16;
                        obj = coroutine_suspended;
                        r5 = objectRef13;
                        r14 = adResponse14;
                        byteString2 = byteString5;
                        androidHandleGatewayAdResponse = androidHandleGatewayAdResponse4;
                    }
                    break;
                case 6:
                    adObject2 = (AdObject) c37271.L$4;
                    ResultKt.throwOnFailure(objInvoke2);
                    return new LoadResult.Success(adObject2);
                case 7:
                    cancellationException = (CancellationException) c37271.L$0;
                    ResultKt.throwOnFailure(objInvoke2);
                    cause = cancellationException.getCause();
                    if (cause == null) {
                        throw cancellationException;
                    }
                    throw cause;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CancellationException e17) {
            cancellationException = e17;
            obj = coroutine_suspended;
            r13 = 1;
            r6 = i;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lgatewayprotocol/v1/AllowedPiiOuterClass$AllowedPii;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$2", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<AllowedPiiOuterClass.AllowedPii, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<AdPlayer> $adPlayer;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<AdPlayer> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$adPlayer = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$adPlayer, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AllowedPiiOuterClass.AllowedPii allowedPii, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(allowedPii, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AllowedPiiOuterClass.AllowedPii allowedPii = (AllowedPiiOuterClass.AllowedPii) this.L$0;
                AdPlayer adPlayer = this.$adPlayer.element;
                byte[] byteArray = allowedPii.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
                this.label = 1;
                if (adPlayer.onAllowedPiiChange(byteArray, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u008a@"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$3", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Pair<? extends byte[], ? extends Integer>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ String $placementId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ByteString byteString, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$opportunityId = byteString;
            this.$placementId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = AndroidHandleGatewayAdResponse.this.new AnonymousClass3(this.$opportunityId, this.$placementId, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Pair<? extends byte[], ? extends Integer> pair, Continuation<? super Unit> continuation) {
            return invoke2((Pair<byte[], Integer>) pair, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<byte[], Integer> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0058  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CampaignStateOuterClass.Campaign campaign_build;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                byte[] bArr = (byte[]) pair.component1();
                int iIntValue = ((Number) pair.component2()).intValue();
                CampaignStateOuterClass.Campaign campaign = AndroidHandleGatewayAdResponse.this.campaignRepository.getCampaign(this.$opportunityId);
                if (campaign == null) {
                    String str = this.$placementId;
                    ByteString byteString = this.$opportunityId;
                    CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.INSTANCE;
                    CampaignStateOuterClass.Campaign.Builder builderNewBuilder = CampaignStateOuterClass.Campaign.newBuilder();
                    Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
                    CampaignKt.Dsl dsl_create = companion._create(builderNewBuilder);
                    dsl_create.setData(ProtobufExtensionsKt.fromBase64$default(new String(bArr, Charsets.UTF_8), false, 1, null));
                    dsl_create.setDataVersion(iIntValue);
                    dsl_create.setPlacementId(str);
                    dsl_create.setImpressionOpportunityId(byteString);
                    campaign_build = dsl_create._build();
                } else {
                    CampaignKt.Dsl.Companion companion2 = CampaignKt.Dsl.INSTANCE;
                    CampaignStateOuterClass.Campaign.Builder builder = campaign.toBuilder();
                    Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
                    CampaignKt.Dsl dsl_create2 = companion2._create(builder);
                    dsl_create2.setData(ProtobufExtensionsKt.fromBase64$default(new String(bArr, Charsets.UTF_8), false, 1, null));
                    dsl_create2.setDataVersion(iIntValue);
                    campaign_build = dsl_create2._build();
                    if (campaign_build == null) {
                        String str2 = this.$placementId;
                        ByteString byteString2 = this.$opportunityId;
                        CampaignKt.Dsl.Companion companion3 = CampaignKt.Dsl.INSTANCE;
                        CampaignStateOuterClass.Campaign.Builder builderNewBuilder2 = CampaignStateOuterClass.Campaign.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
                        CampaignKt.Dsl dsl_create3 = companion3._create(builderNewBuilder2);
                        dsl_create3.setData(ProtobufExtensionsKt.fromBase64$default(new String(bArr, Charsets.UTF_8), false, 1, null));
                        dsl_create3.setDataVersion(iIntValue);
                        dsl_create3.setPlacementId(str2);
                        dsl_create3.setImpressionOpportunityId(byteString2);
                        campaign_build = dsl_create3._build();
                    }
                }
                AndroidHandleGatewayAdResponse.this.campaignRepository.setCampaign(this.$opportunityId, campaign_build);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$4", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $webViewUrl;
        final /* synthetic */ AndroidWebViewContainer $webviewContainer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AndroidWebViewContainer androidWebViewContainer, String str, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$webviewContainer = androidWebViewContainer;
            this.$webViewUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(this.$webviewContainer, this.$webViewUrl, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$webviewContainer.loadUrl(this.$webViewUrl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$5, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$5", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<AdPlayer> $adPlayer;
        final /* synthetic */ LoadEvent $loadEvent;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ AdResponseOuterClass.AdResponse $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(LoadEvent loadEvent, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Ref.ObjectRef<AdPlayer> objectRef, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$loadEvent = loadEvent;
            this.$opportunityId = byteString;
            this.$response = adResponse;
            this.$adPlayer = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidHandleGatewayAdResponse.this.new AnonymousClass5(this.$loadEvent, this.$opportunityId, this.$response, this.$adPlayer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AndroidHandleGatewayAdResponse.this.cleanup(new Error(((LoadEvent.Error) this.$loadEvent).getMessage()), this.$opportunityId, this.$response, this.$adPlayer.element, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$6, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidHandleGatewayAdResponse.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$6", f = "AndroidHandleGatewayAdResponse.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<AdPlayer> $adPlayer;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ AdResponseOuterClass.AdResponse $response;
        final /* synthetic */ CancellationException $t;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(CancellationException cancellationException, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Ref.ObjectRef<AdPlayer> objectRef, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$t = cancellationException;
            this.$opportunityId = byteString;
            this.$response = adResponse;
            this.$adPlayer = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidHandleGatewayAdResponse.this.new AnonymousClass6(this.$t, this.$opportunityId, this.$response, this.$adPlayer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AndroidHandleGatewayAdResponse.this.cleanup(this.$t, this.$opportunityId, this.$response, this.$adPlayer.element, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object cleanup(Throwable th, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, AdPlayer adPlayer, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        String message;
        AdPlayer adPlayer2;
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
        if (i != 0) {
            if (i == 1) {
                AdPlayer adPlayer3 = (AdPlayer) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                adPlayer2 = adPlayer3;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.INSTANCE;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder builderNewBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        OperativeEventErrorDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setErrorType(OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED);
        Throwable cause = th.getCause();
        if ((cause == null || (message = cause.getMessage()) == null) && (message = th.getMessage()) == null) {
            message = "";
        }
        dsl_create.setMessage(message);
        OperativeEventRequestOuterClass.OperativeEventErrorData operativeEventErrorData_build = dsl_create._build();
        GetOperativeEventApi getOperativeEventApi = this.getOperativeEventApi;
        OperativeEventRequestOuterClass.OperativeEventType operativeEventType = OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_LOAD_ERROR;
        ByteString trackingToken = adResponse.getTrackingToken();
        Intrinsics.checkNotNullExpressionValue(trackingToken, "response.trackingToken");
        ByteString byteString2 = operativeEventErrorData_build.toByteString();
        Intrinsics.checkNotNullExpressionValue(byteString2, "operativeEventErrorData.toByteString()");
        adPlayer2 = adPlayer;
        anonymousClass1.L$0 = adPlayer2;
        anonymousClass1.label = 1;
        if (GetOperativeEventApi.invoke$default(getOperativeEventApi, operativeEventType, byteString, trackingToken, byteString2, null, anonymousClass1, 16, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (adPlayer2 == null) {
            return Unit.INSTANCE;
        }
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        if (adPlayer2.destroy(anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}

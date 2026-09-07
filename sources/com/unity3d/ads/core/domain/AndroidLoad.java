package com.unity3d.ads.core.domain;

import android.content.Context;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.protobuf.ByteString;
import com.json.b9;
import com.json.k6;
import com.smaato.sdk.video.vast.model.Ad;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import com.unity3d.services.UnityAdsConstants;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.AdResponseKt;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import gatewayprotocol.v1.WebviewConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidLoad.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002JC\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidLoad;", "Lcom/unity3d/ads/core/domain/Load;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAdRequest", "Lcom/unity3d/ads/core/domain/GetAdRequest;", "getAdPlayerConfigRequest", "Lcom/unity3d/ads/core/domain/GetAdPlayerConfigRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "handleGatewayAdResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/GetAdRequest;Lcom/unity3d/ads/core/domain/GetAdPlayerConfigRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/gatewayclient/GatewayClient;Lcom/unity3d/ads/core/data/repository/AdRepository;)V", "handleGatewayException", "Lcom/unity3d/ads/core/data/model/LoadResult$Failure;", "e", "Lcom/unity3d/ads/core/data/model/exception/UnityAdsNetworkException;", "incrementLoadRequestAdmCount", "", b9.v, "", "incrementLoadRequestCount", "invoke", "Lcom/unity3d/ads/core/data/model/LoadResult;", "context", "Landroid/content/Context;", "placement", "", "opportunityId", "Lcom/google/protobuf/ByteString;", "headerBiddingAdMarkup", "Lgatewayprotocol/v1/HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup;", k6.u, "Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/protobuf/ByteString;Lgatewayprotocol/v1/HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup;Lgatewayprotocol/v1/AdRequestOuterClass$BannerSize;Lcom/unity3d/ads/UnityAdsLoadOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidLoad implements Load {
    private final AdRepository adRepository;
    private final CoroutineDispatcher defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetAdPlayerConfigRequest getAdPlayerConfigRequest;
    private final GetAdRequest getAdRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final HandleGatewayAdResponse handleGatewayAdResponse;
    private final SessionRepository sessionRepository;

    public AndroidLoad(CoroutineDispatcher defaultDispatcher, GetAdRequest getAdRequest, GetAdPlayerConfigRequest getAdPlayerConfigRequest, GetRequestPolicy getRequestPolicy, HandleGatewayAdResponse handleGatewayAdResponse, SessionRepository sessionRepository, GatewayClient gatewayClient, AdRepository adRepository) {
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(getAdRequest, "getAdRequest");
        Intrinsics.checkNotNullParameter(getAdPlayerConfigRequest, "getAdPlayerConfigRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(handleGatewayAdResponse, "handleGatewayAdResponse");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(gatewayClient, "gatewayClient");
        Intrinsics.checkNotNullParameter(adRepository, "adRepository");
        this.defaultDispatcher = defaultDispatcher;
        this.getAdRequest = getAdRequest;
        this.getAdPlayerConfigRequest = getAdPlayerConfigRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.handleGatewayAdResponse = handleGatewayAdResponse;
        this.sessionRepository = sessionRepository;
        this.gatewayClient = gatewayClient;
        this.adRepository = adRepository;
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidLoad$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidLoad.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/LoadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidLoad$invoke$2", f = "AndroidLoad.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER, 61, 66, TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER, 91, 94}, m = "invokeSuspend", n = {Ad.AD_TYPE, HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, Ad.AD_TYPE, HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, Ad.AD_TYPE, HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, Ad.AD_TYPE, HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
        final /* synthetic */ AdRequestOuterClass.BannerSize $bannerSize;
        final /* synthetic */ Context $context;
        final /* synthetic */ HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup $headerBiddingAdMarkup;
        final /* synthetic */ UnityAdsLoadOptions $loadOptions;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ String $placement;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AdRequestOuterClass.BannerSize bannerSize, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, String str, ByteString byteString, UnityAdsLoadOptions unityAdsLoadOptions, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bannerSize = bannerSize;
            this.$headerBiddingAdMarkup = headerBiddingAdMarkup;
            this.$placement = str;
            this.$opportunityId = byteString;
            this.$loadOptions = unityAdsLoadOptions;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AndroidLoad.this.new AnonymousClass2(this.$bannerSize, this.$headerBiddingAdMarkup, this.$placement, this.$opportunityId, this.$loadOptions, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x00e3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x0145 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:53:0x014e A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:55:0x0169 A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:57:0x01d2 A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:61:0x01f9  */
        /* JADX WARN: Code duplicated, block: B:62:0x01fb  */
        /* JADX WARN: Code duplicated, block: B:65:0x020c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:68:0x0213 A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:70:0x0227 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:73:0x022c A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0242 A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:75:0x024b A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:77:0x024f  */
        /* JADX WARN: Code duplicated, block: B:78:0x0250 A[Catch: UnityAdsNetworkException -> 0x0023, TryCatch #0 {UnityAdsNetworkException -> 0x0023, blocks: (B:6:0x0015, B:71:0x0228, B:73:0x022c, B:74:0x0242, B:7:0x001c, B:66:0x020d, B:68:0x0213, B:75:0x024b, B:78:0x0250, B:79:0x0255, B:12:0x002c, B:51:0x0146, B:53:0x014e, B:55:0x0169, B:57:0x01d2, B:58:0x01de, B:59:0x01e4, B:63:0x01fc, B:15:0x003a, B:48:0x011d, B:18:0x0048, B:43:0x00e4, B:21:0x0056, B:40:0x00bb, B:24:0x0060, B:26:0x006c, B:28:0x007e, B:33:0x0087, B:35:0x008c, B:37:0x009a, B:45:0x00f2, B:34:0x008a), top: B:82:0x000a }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType;
            int i;
            Object objInvoke;
            Object objInvoke2;
            Object objRequest$default;
            AdResponseOuterClass.AdResponse adResponse;
            Object objRequest$default2;
            boolean z;
            Object objInvoke3;
            UniversalResponseOuterClass.UniversalResponse universalResponse;
            AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponse;
            AdResponseKt.Dsl dsl_create;
            LoadResult loadResult;
            Object ad;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (!AndroidLoad.this.sessionRepository.isSdkInitialized()) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, null, null, "not_initialized", null, false, 54, null);
                        }
                        boolean z2 = this.$bannerSize != null;
                        diagnosticAdType = z2 ? DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_BANNER : DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
                        boolean zIsEmpty = this.$headerBiddingAdMarkup.getAdData().isEmpty();
                        i = !zIsEmpty ? 1 : 0;
                        if (zIsEmpty) {
                            AndroidLoad.this.incrementLoadRequestCount(z2);
                            this.L$0 = diagnosticAdType;
                            this.I$0 = i;
                            this.label = 1;
                            objInvoke2 = AndroidLoad.this.getAdRequest.invoke(this.$placement, this.$opportunityId, this.$bannerSize, this);
                            if (objInvoke2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            RequestPolicy requestPolicyInvoke = AndroidLoad.this.getRequestPolicy.invoke();
                            this.L$0 = diagnosticAdType;
                            this.I$0 = i;
                            this.label = 2;
                            objRequest$default = GatewayClient.DefaultImpls.request$default(AndroidLoad.this.gatewayClient, null, (UniversalRequestOuterClass.UniversalRequest) objInvoke2, requestPolicyInvoke, OperationType.LOAD, this, 1, null);
                            if (objRequest$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            adResponse = ((UniversalResponseOuterClass.UniversalResponse) objRequest$default).getPayload().getAdResponse();
                            AdResponseOuterClass.AdResponse response = adResponse;
                            DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType2 = diagnosticAdType;
                            HandleGatewayAdResponse handleGatewayAdResponse = AndroidLoad.this.handleGatewayAdResponse;
                            UnityAdsLoadOptions unityAdsLoadOptions = this.$loadOptions;
                            ByteString byteString = this.$opportunityId;
                            Intrinsics.checkNotNullExpressionValue(response, "response");
                            Context context = this.$context;
                            String str = this.$placement;
                            if (i != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            this.L$0 = null;
                            this.label = 5;
                            objInvoke3 = handleGatewayAdResponse.invoke(unityAdsLoadOptions, byteString, response, context, str, diagnosticAdType2, z, this);
                            if (objInvoke3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            loadResult = (LoadResult) objInvoke3;
                            if (!(loadResult instanceof LoadResult.Success)) {
                                if (loadResult instanceof LoadResult.Failure) {
                                    return loadResult;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            this.label = 6;
                            ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                            if (ad == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            AdObject adObject = (AdObject) ad;
                            return adObject == null ? new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_AD_OBJECT, null, "ad_object_not_found", null, false, 52, null) : new LoadResult.Success(adObject);
                        }
                        AndroidLoad.this.incrementLoadRequestAdmCount(z2);
                        GetAdPlayerConfigRequest getAdPlayerConfigRequest = AndroidLoad.this.getAdPlayerConfigRequest;
                        String str2 = this.$placement;
                        ByteString byteString2 = this.$opportunityId;
                        ByteString configurationToken = this.$headerBiddingAdMarkup.getConfigurationToken();
                        Intrinsics.checkNotNullExpressionValue(configurationToken, "headerBiddingAdMarkup.configurationToken");
                        this.L$0 = diagnosticAdType;
                        this.I$0 = i;
                        this.label = 3;
                        objInvoke = getAdPlayerConfigRequest.invoke(str2, byteString2, configurationToken, this);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        RequestPolicy requestPolicyInvoke2 = AndroidLoad.this.getRequestPolicy.invoke();
                        this.L$0 = diagnosticAdType;
                        this.I$0 = i;
                        this.label = 4;
                        objRequest$default2 = GatewayClient.DefaultImpls.request$default(AndroidLoad.this.gatewayClient, null, (UniversalRequestOuterClass.UniversalRequest) objInvoke, requestPolicyInvoke2, OperationType.LOAD_HEADER_BIDDING, this, 1, null);
                        if (objRequest$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        universalResponse = (UniversalResponseOuterClass.UniversalResponse) objRequest$default2;
                        if (universalResponse.hasError()) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "gateway", universalResponse.getError().getErrorText(), false, 36, null);
                        }
                        adPlayerConfigResponse = universalResponse.getPayload().getAdPlayerConfigResponse();
                        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup = this.$headerBiddingAdMarkup;
                        AdResponseKt.Dsl.Companion companion = AdResponseKt.Dsl.INSTANCE;
                        AdResponseOuterClass.AdResponse.Builder builderNewBuilder = AdResponseOuterClass.AdResponse.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
                        dsl_create = companion._create(builderNewBuilder);
                        ByteString adData = headerBiddingAdMarkup.getAdData();
                        Intrinsics.checkNotNullExpressionValue(adData, "headerBiddingAdMarkup.adData");
                        dsl_create.setAdData(adData);
                        dsl_create.setAdDataVersion(headerBiddingAdMarkup.getAdDataVersion());
                        ByteString trackingToken = adPlayerConfigResponse.getTrackingToken();
                        Intrinsics.checkNotNullExpressionValue(trackingToken, "response.trackingToken");
                        dsl_create.setTrackingToken(trackingToken);
                        ByteString impressionConfiguration = adPlayerConfigResponse.getImpressionConfiguration();
                        Intrinsics.checkNotNullExpressionValue(impressionConfiguration, "response.impressionConfiguration");
                        dsl_create.setImpressionConfiguration(impressionConfiguration);
                        dsl_create.setImpressionConfigurationVersion(adPlayerConfigResponse.getImpressionConfigurationVersion());
                        WebviewConfiguration.WebViewConfiguration webviewConfiguration = adPlayerConfigResponse.getWebviewConfiguration();
                        Intrinsics.checkNotNullExpressionValue(webviewConfiguration, "response.webviewConfiguration");
                        dsl_create.setWebviewConfiguration(webviewConfiguration);
                        ByteString adDataRefreshToken = adPlayerConfigResponse.getAdDataRefreshToken();
                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken, "response.adDataRefreshToken");
                        dsl_create.setAdDataRefreshToken(adDataRefreshToken);
                        if (adPlayerConfigResponse.hasError()) {
                            ErrorOuterClass.Error error = adPlayerConfigResponse.getError();
                            Intrinsics.checkNotNullExpressionValue(error, "response.error");
                            dsl_create.setError(error);
                        }
                        adResponse = dsl_create._build();
                        AdResponseOuterClass.AdResponse response2 = adResponse;
                        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType3 = diagnosticAdType;
                        HandleGatewayAdResponse handleGatewayAdResponse2 = AndroidLoad.this.handleGatewayAdResponse;
                        UnityAdsLoadOptions unityAdsLoadOptions2 = this.$loadOptions;
                        ByteString byteString3 = this.$opportunityId;
                        Intrinsics.checkNotNullExpressionValue(response2, "response");
                        Context context2 = this.$context;
                        String str3 = this.$placement;
                        if (i != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.L$0 = null;
                        this.label = 5;
                        objInvoke3 = handleGatewayAdResponse2.invoke(unityAdsLoadOptions2, byteString3, response2, context2, str3, diagnosticAdType3, z, this);
                        if (objInvoke3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loadResult = (LoadResult) objInvoke3;
                        if (!(loadResult instanceof LoadResult.Success)) {
                            if (loadResult instanceof LoadResult.Failure) {
                                return loadResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        this.label = 6;
                        ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                        if (ad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdObject adObject2 = (AdObject) ad;
                        if (adObject2 == null) {
                        }
                    case 1:
                        int i2 = this.I$0;
                        diagnosticAdType = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i2;
                        objInvoke2 = obj;
                        RequestPolicy requestPolicyInvoke3 = AndroidLoad.this.getRequestPolicy.invoke();
                        this.L$0 = diagnosticAdType;
                        this.I$0 = i;
                        this.label = 2;
                        objRequest$default = GatewayClient.DefaultImpls.request$default(AndroidLoad.this.gatewayClient, null, (UniversalRequestOuterClass.UniversalRequest) objInvoke2, requestPolicyInvoke3, OperationType.LOAD, this, 1, null);
                        if (objRequest$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        adResponse = ((UniversalResponseOuterClass.UniversalResponse) objRequest$default).getPayload().getAdResponse();
                        AdResponseOuterClass.AdResponse response3 = adResponse;
                        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType4 = diagnosticAdType;
                        HandleGatewayAdResponse handleGatewayAdResponse3 = AndroidLoad.this.handleGatewayAdResponse;
                        UnityAdsLoadOptions unityAdsLoadOptions3 = this.$loadOptions;
                        ByteString byteString4 = this.$opportunityId;
                        Intrinsics.checkNotNullExpressionValue(response3, "response");
                        Context context3 = this.$context;
                        String str4 = this.$placement;
                        if (i != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.L$0 = null;
                        this.label = 5;
                        objInvoke3 = handleGatewayAdResponse3.invoke(unityAdsLoadOptions3, byteString4, response3, context3, str4, diagnosticAdType4, z, this);
                        if (objInvoke3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loadResult = (LoadResult) objInvoke3;
                        if (!(loadResult instanceof LoadResult.Success)) {
                            if (loadResult instanceof LoadResult.Failure) {
                                return loadResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        this.label = 6;
                        ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                        if (ad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdObject adObject3 = (AdObject) ad;
                        if (adObject3 == null) {
                        }
                    case 2:
                        int i3 = this.I$0;
                        diagnosticAdType = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i3;
                        objRequest$default = obj;
                        adResponse = ((UniversalResponseOuterClass.UniversalResponse) objRequest$default).getPayload().getAdResponse();
                        AdResponseOuterClass.AdResponse response4 = adResponse;
                        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType5 = diagnosticAdType;
                        HandleGatewayAdResponse handleGatewayAdResponse4 = AndroidLoad.this.handleGatewayAdResponse;
                        UnityAdsLoadOptions unityAdsLoadOptions4 = this.$loadOptions;
                        ByteString byteString5 = this.$opportunityId;
                        Intrinsics.checkNotNullExpressionValue(response4, "response");
                        Context context4 = this.$context;
                        String str5 = this.$placement;
                        if (i != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.L$0 = null;
                        this.label = 5;
                        objInvoke3 = handleGatewayAdResponse4.invoke(unityAdsLoadOptions4, byteString5, response4, context4, str5, diagnosticAdType5, z, this);
                        if (objInvoke3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loadResult = (LoadResult) objInvoke3;
                        if (!(loadResult instanceof LoadResult.Success)) {
                            if (loadResult instanceof LoadResult.Failure) {
                                return loadResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        this.label = 6;
                        ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                        if (ad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdObject adObject4 = (AdObject) ad;
                        if (adObject4 == null) {
                        }
                    case 3:
                        int i4 = this.I$0;
                        diagnosticAdType = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i4;
                        objInvoke = obj;
                        RequestPolicy requestPolicyInvoke4 = AndroidLoad.this.getRequestPolicy.invoke();
                        this.L$0 = diagnosticAdType;
                        this.I$0 = i;
                        this.label = 4;
                        objRequest$default2 = GatewayClient.DefaultImpls.request$default(AndroidLoad.this.gatewayClient, null, (UniversalRequestOuterClass.UniversalRequest) objInvoke, requestPolicyInvoke4, OperationType.LOAD_HEADER_BIDDING, this, 1, null);
                        if (objRequest$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        universalResponse = (UniversalResponseOuterClass.UniversalResponse) objRequest$default2;
                        if (universalResponse.hasError()) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "gateway", universalResponse.getError().getErrorText(), false, 36, null);
                        }
                        adPlayerConfigResponse = universalResponse.getPayload().getAdPlayerConfigResponse();
                        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup2 = this.$headerBiddingAdMarkup;
                        AdResponseKt.Dsl.Companion companion2 = AdResponseKt.Dsl.INSTANCE;
                        AdResponseOuterClass.AdResponse.Builder builderNewBuilder2 = AdResponseOuterClass.AdResponse.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
                        dsl_create = companion2._create(builderNewBuilder2);
                        ByteString adData2 = headerBiddingAdMarkup2.getAdData();
                        Intrinsics.checkNotNullExpressionValue(adData2, "headerBiddingAdMarkup.adData");
                        dsl_create.setAdData(adData2);
                        dsl_create.setAdDataVersion(headerBiddingAdMarkup2.getAdDataVersion());
                        ByteString trackingToken2 = adPlayerConfigResponse.getTrackingToken();
                        Intrinsics.checkNotNullExpressionValue(trackingToken2, "response.trackingToken");
                        dsl_create.setTrackingToken(trackingToken2);
                        ByteString impressionConfiguration2 = adPlayerConfigResponse.getImpressionConfiguration();
                        Intrinsics.checkNotNullExpressionValue(impressionConfiguration2, "response.impressionConfiguration");
                        dsl_create.setImpressionConfiguration(impressionConfiguration2);
                        dsl_create.setImpressionConfigurationVersion(adPlayerConfigResponse.getImpressionConfigurationVersion());
                        WebviewConfiguration.WebViewConfiguration webviewConfiguration2 = adPlayerConfigResponse.getWebviewConfiguration();
                        Intrinsics.checkNotNullExpressionValue(webviewConfiguration2, "response.webviewConfiguration");
                        dsl_create.setWebviewConfiguration(webviewConfiguration2);
                        ByteString adDataRefreshToken2 = adPlayerConfigResponse.getAdDataRefreshToken();
                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken2, "response.adDataRefreshToken");
                        dsl_create.setAdDataRefreshToken(adDataRefreshToken2);
                        if (adPlayerConfigResponse.hasError()) {
                            ErrorOuterClass.Error error2 = adPlayerConfigResponse.getError();
                            Intrinsics.checkNotNullExpressionValue(error2, "response.error");
                            dsl_create.setError(error2);
                        }
                        adResponse = dsl_create._build();
                        AdResponseOuterClass.AdResponse response5 = adResponse;
                        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType6 = diagnosticAdType;
                        HandleGatewayAdResponse handleGatewayAdResponse5 = AndroidLoad.this.handleGatewayAdResponse;
                        UnityAdsLoadOptions unityAdsLoadOptions5 = this.$loadOptions;
                        ByteString byteString6 = this.$opportunityId;
                        Intrinsics.checkNotNullExpressionValue(response5, "response");
                        Context context5 = this.$context;
                        String str6 = this.$placement;
                        if (i != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.L$0 = null;
                        this.label = 5;
                        objInvoke3 = handleGatewayAdResponse5.invoke(unityAdsLoadOptions5, byteString6, response5, context5, str6, diagnosticAdType6, z, this);
                        if (objInvoke3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loadResult = (LoadResult) objInvoke3;
                        if (!(loadResult instanceof LoadResult.Success)) {
                            if (loadResult instanceof LoadResult.Failure) {
                                return loadResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        this.label = 6;
                        ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                        if (ad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdObject adObject5 = (AdObject) ad;
                        if (adObject5 == null) {
                        }
                    case 4:
                        int i5 = this.I$0;
                        diagnosticAdType = (DiagnosticEventRequestOuterClass.DiagnosticAdType) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i5;
                        objRequest$default2 = obj;
                        universalResponse = (UniversalResponseOuterClass.UniversalResponse) objRequest$default2;
                        if (universalResponse.hasError()) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, UnityAdsConstants.Messages.MSG_INTERNAL_ERROR, null, "gateway", universalResponse.getError().getErrorText(), false, 36, null);
                        }
                        adPlayerConfigResponse = universalResponse.getPayload().getAdPlayerConfigResponse();
                        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup3 = this.$headerBiddingAdMarkup;
                        AdResponseKt.Dsl.Companion companion3 = AdResponseKt.Dsl.INSTANCE;
                        AdResponseOuterClass.AdResponse.Builder builderNewBuilder3 = AdResponseOuterClass.AdResponse.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(builderNewBuilder3, "newBuilder()");
                        dsl_create = companion3._create(builderNewBuilder3);
                        ByteString adData3 = headerBiddingAdMarkup3.getAdData();
                        Intrinsics.checkNotNullExpressionValue(adData3, "headerBiddingAdMarkup.adData");
                        dsl_create.setAdData(adData3);
                        dsl_create.setAdDataVersion(headerBiddingAdMarkup3.getAdDataVersion());
                        ByteString trackingToken3 = adPlayerConfigResponse.getTrackingToken();
                        Intrinsics.checkNotNullExpressionValue(trackingToken3, "response.trackingToken");
                        dsl_create.setTrackingToken(trackingToken3);
                        ByteString impressionConfiguration3 = adPlayerConfigResponse.getImpressionConfiguration();
                        Intrinsics.checkNotNullExpressionValue(impressionConfiguration3, "response.impressionConfiguration");
                        dsl_create.setImpressionConfiguration(impressionConfiguration3);
                        dsl_create.setImpressionConfigurationVersion(adPlayerConfigResponse.getImpressionConfigurationVersion());
                        WebviewConfiguration.WebViewConfiguration webviewConfiguration3 = adPlayerConfigResponse.getWebviewConfiguration();
                        Intrinsics.checkNotNullExpressionValue(webviewConfiguration3, "response.webviewConfiguration");
                        dsl_create.setWebviewConfiguration(webviewConfiguration3);
                        ByteString adDataRefreshToken3 = adPlayerConfigResponse.getAdDataRefreshToken();
                        Intrinsics.checkNotNullExpressionValue(adDataRefreshToken3, "response.adDataRefreshToken");
                        dsl_create.setAdDataRefreshToken(adDataRefreshToken3);
                        if (adPlayerConfigResponse.hasError()) {
                            ErrorOuterClass.Error error3 = adPlayerConfigResponse.getError();
                            Intrinsics.checkNotNullExpressionValue(error3, "response.error");
                            dsl_create.setError(error3);
                        }
                        adResponse = dsl_create._build();
                        AdResponseOuterClass.AdResponse response6 = adResponse;
                        DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType7 = diagnosticAdType;
                        HandleGatewayAdResponse handleGatewayAdResponse6 = AndroidLoad.this.handleGatewayAdResponse;
                        UnityAdsLoadOptions unityAdsLoadOptions6 = this.$loadOptions;
                        ByteString byteString7 = this.$opportunityId;
                        Intrinsics.checkNotNullExpressionValue(response6, "response");
                        Context context6 = this.$context;
                        String str7 = this.$placement;
                        if (i != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.L$0 = null;
                        this.label = 5;
                        objInvoke3 = handleGatewayAdResponse6.invoke(unityAdsLoadOptions6, byteString7, response6, context6, str7, diagnosticAdType7, z, this);
                        if (objInvoke3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loadResult = (LoadResult) objInvoke3;
                        if (!(loadResult instanceof LoadResult.Success)) {
                            if (loadResult instanceof LoadResult.Failure) {
                                return loadResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        this.label = 6;
                        ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                        if (ad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdObject adObject6 = (AdObject) ad;
                        if (adObject6 == null) {
                        }
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        objInvoke3 = obj;
                        loadResult = (LoadResult) objInvoke3;
                        if (!(loadResult instanceof LoadResult.Success)) {
                            if (loadResult instanceof LoadResult.Failure) {
                                return loadResult;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        this.label = 6;
                        ad = AndroidLoad.this.adRepository.getAd(this.$opportunityId, this);
                        if (ad == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AdObject adObject7 = (AdObject) ad;
                        if (adObject7 == null) {
                        }
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        ad = obj;
                        AdObject adObject8 = (AdObject) ad;
                        if (adObject8 == null) {
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (UnityAdsNetworkException e) {
                return AndroidLoad.this.handleGatewayException(e);
            }
        }
    }

    @Override // com.unity3d.ads.core.domain.Load
    public Object invoke(Context context, String str, ByteString byteString, HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup, AdRequestOuterClass.BannerSize bannerSize, UnityAdsLoadOptions unityAdsLoadOptions, Continuation<? super LoadResult> continuation) {
        return BuildersKt.withContext(this.defaultDispatcher, new AnonymousClass2(bannerSize, headerBiddingAdMarkup, str, byteString, unityAdsLoadOptions, context, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadResult.Failure handleGatewayException(UnityAdsNetworkException e) {
        boolean z = e instanceof NetworkTimeoutException;
        return new LoadResult.Failure(z ? UnityAds.UnityAdsLoadError.TIMEOUT : UnityAds.UnityAdsLoadError.INTERNAL_ERROR, z ? LoadResult.MSG_TIMEOUT : LoadResult.MSG_COMMUNICATION_FAILURE, e, z ? "timeout" : "gateway", e.getMessage(), false, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLoadRequestCount(boolean isBanner) {
        if (isBanner) {
            this.sessionRepository.incrementBannerLoadRequestCount();
        } else {
            this.sessionRepository.incrementLoadRequestCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementLoadRequestAdmCount(boolean isBanner) {
        if (isBanner) {
            this.sessionRepository.incrementBannerLoadRequestAdmCount();
        } else {
            this.sessionRepository.incrementLoadRequestAdmCount();
        }
    }
}

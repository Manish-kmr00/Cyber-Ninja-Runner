package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.vungle.ads.internal.protos.Sdk;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import java.util.UUID;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LegacyLoadUseCase.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/LoadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1", f = "LegacyLoadUseCase.kt", i = {0, 2, 2}, l = {114, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 138, 139}, m = "invokeSuspend", n = {"opportunityIdByteString", "opportunityIdByteString", "headerBiddingAdMarkup"}, s = {"L$0", "L$0", "L$1"})
final class LegacyLoadUseCase$invoke$loadResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AdRequestOuterClass.BannerSize $gatewayBannerSize;
    final /* synthetic */ UnityAdsLoadOptions $loadOptions;
    final /* synthetic */ String $placement;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX INFO: compiled from: LegacyLoadUseCase.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitializationState.values().length];
            try {
                iArr[InitializationState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationState.NOT_INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InitializationState.INITIALIZING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$invoke$loadResult$1(String str, LegacyLoadUseCase legacyLoadUseCase, UnityAdsLoadOptions unityAdsLoadOptions, Context context, AdRequestOuterClass.BannerSize bannerSize, Continuation<? super LegacyLoadUseCase$invoke$loadResult$1> continuation) {
        super(2, continuation);
        this.$placement = str;
        this.this$0 = legacyLoadUseCase;
        this.$loadOptions = unityAdsLoadOptions;
        this.$context = context;
        this.$gatewayBannerSize = bannerSize;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyLoadUseCase$invoke$loadResult$1(this.$placement, this.this$0, this.$loadOptions, this.$context, this.$gatewayBannerSize, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
        return ((LegacyLoadUseCase$invoke$loadResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0126  */
    /* JADX WARN: Code duplicated, block: B:45:0x0128  */
    /* JADX WARN: Code duplicated, block: B:47:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0134  */
    /* JADX WARN: Code duplicated, block: B:49:0x015c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0171  */
    /* JADX WARN: Code duplicated, block: B:52:0x018e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ByteString byteString;
        Object objHasOpportunityId;
        Object objInvoke;
        Object objInvoke$default;
        ByteString byteString2;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup;
        InitializationState initializationState;
        int i;
        Object objInvoke2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$placement != null) {
                String opportunityId = this.this$0.getOpportunityId(this.$loadOptions);
                if (opportunityId == null) {
                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, LoadResult.MSG_OPPORTUNITY_ID, null, "no_opportunity_id", null, false, 52, null);
                }
                UUID uuidFromString = UUID.fromString(opportunityId);
                Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(opportunityId)");
                byteString = ProtobufExtensionsKt.toByteString(uuidFromString);
                this.this$0.opportunity = byteString;
                this.L$0 = byteString;
                this.label = 1;
                objHasOpportunityId = this.this$0.adRepository.hasOpportunityId(byteString, this);
                if (objHasOpportunityId == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, LoadResult.MSG_PLACEMENT_NULL, null, "placement_null", null, false, 52, null);
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objInvoke = obj;
                    return (LoadResult) objInvoke;
                }
                if (i2 == 3) {
                    HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup2 = (HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup) this.L$1;
                    ByteString byteString3 = (ByteString) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    headerBiddingAdMarkup = headerBiddingAdMarkup2;
                    byteString2 = byteString3;
                    objInvoke$default = obj;
                    initializationState = (InitializationState) objInvoke$default;
                    if (initializationState == null) {
                        i = -1;
                    } else {
                        i = WhenMappings.$EnumSwitchMapping$0[initializationState.ordinal()];
                    }
                    if (i != 1) {
                        if (i != 2) {
                            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, LoadResult.MSG_NOT_INITIALIZED, null, "not_initialized", null, false, 52, null);
                        }
                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.TIMEOUT, LoadResult.MSG_TIMEOUT + this.$placement, null, "timeout_initialization", null, false, 52, null);
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 4;
                    objInvoke2 = this.this$0.load.invoke(this.$context, this.$placement, byteString2, headerBiddingAdMarkup, this.$gatewayBannerSize, this.$loadOptions, this);
                    if (objInvoke2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objInvoke2 = obj;
                }
                return (LoadResult) objInvoke2;
            }
            byteString = (ByteString) this.L$0;
            ResultKt.throwOnFailure(obj);
            objHasOpportunityId = obj;
        }
        ByteString byteString4 = byteString;
        if (((Boolean) objHasOpportunityId).booleanValue()) {
            new LoadResult.Failure(UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, LoadResult.MSG_OPPORTUNITY_ID_USED, null, "opportunity_id_used", null, false, 52, null);
        }
        LegacyLoadUseCase legacyLoadUseCase = this.this$0;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup3 = legacyLoadUseCase.getHeaderBiddingAdMarkup(legacyLoadUseCase.adMarkup);
        if (headerBiddingAdMarkup3 != null) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[GetInitializationState.DefaultImpls.invoke$default(this.this$0.getInitializationState, false, 1, null).ordinal()];
            if (i3 == 1) {
                this.L$0 = null;
                this.label = 2;
                objInvoke = this.this$0.load.invoke(this.$context, this.$placement, byteString4, headerBiddingAdMarkup3, this.$gatewayBannerSize, this.$loadOptions, this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResult) objInvoke;
            }
            if (i3 == 2 || i3 == 3) {
                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, LoadResult.MSG_NOT_INITIALIZED, null, "not_initialized", null, false, 52, null);
            }
            if (i3 == 4) {
                this.L$0 = byteString4;
                this.L$1 = headerBiddingAdMarkup3;
                this.label = 3;
                objInvoke$default = AwaitInitialization.DefaultImpls.invoke$default(this.this$0.awaitInitialization, 0L, this, 1, null);
                if (objInvoke$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                byteString2 = byteString4;
                headerBiddingAdMarkup = headerBiddingAdMarkup3;
                initializationState = (InitializationState) objInvoke$default;
                if (initializationState == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[initializationState.ordinal()];
                }
                if (i != 1) {
                    if (i != 2) {
                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, LoadResult.MSG_NOT_INITIALIZED, null, "not_initialized", null, false, 52, null);
                    }
                    return new LoadResult.Failure(UnityAds.UnityAdsLoadError.TIMEOUT, LoadResult.MSG_TIMEOUT + this.$placement, null, "timeout_initialization", null, false, 52, null);
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = 4;
                objInvoke2 = this.this$0.load.invoke(this.$context, this.$placement, byteString2, headerBiddingAdMarkup, this.$gatewayBannerSize, this.$loadOptions, this);
                if (objInvoke2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResult) objInvoke2;
            }
            throw new NoWhenBranchMatchedException();
        }
        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_AD_MARKUP_PARSING, null, "invalid_admarkup", null, false, 52, null);
    }
}

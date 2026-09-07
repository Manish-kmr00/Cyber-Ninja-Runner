package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebView;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.safedk.android.internal.partials.MolocoAdsNetworkBridge;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f6639a;
    public final MutableSharedFlow<n> b;
    public final SharedFlow<n> c;
    public final u d;
    public final WebView e;
    public final StateFlow<Boolean> f;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> g;

    public static final class a implements o {
        public a() {
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.o
        public boolean a(String fromUrl) {
            Intrinsics.checkNotNullParameter(fromUrl, "fromUrl");
            return g.this.b(fromUrl);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBridgeImpl$consumeMraidJsCommand$1", f = "MraidBridge.kt", i = {0}, l = {IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT}, m = "invokeSuspend", n = {"cmd"}, s = {"L$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6641a;
        public int b;
        public final /* synthetic */ com.moloco.sdk.internal.v<n, n.b.a> c;
        public final /* synthetic */ g d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.v<n, n.b.a> vVar, g gVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = vVar;
            this.d = gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            n nVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                n nVar2 = (n) ((com.moloco.sdk.internal.v.b) this.c).a();
                MutableSharedFlow mutableSharedFlow = this.d.b;
                this.f6641a = nVar2;
                this.b = 1;
                if (mutableSharedFlow.emit(nVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                nVar = nVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                nVar = (n) this.f6641a;
                ResultKt.throwOnFailure(obj);
            }
            this.d.a(nVar);
            return Unit.INSTANCE;
        }
    }

    public g(Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f6639a = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        MutableSharedFlow<n> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.b = mutableSharedFlowMutableSharedFlow$default;
        this.c = mutableSharedFlowMutableSharedFlow$default;
        u uVar = new u(context, new a());
        this.d = uVar;
        this.e = uVar;
        this.f = uVar.c();
        this.g = uVar.getUnrecoverableError();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public StateFlow<Boolean> H() {
        return this.f;
    }

    public final boolean b(String str) {
        com.moloco.sdk.internal.v<n, n.b.a> vVarA = n.b.a(str);
        if (vVarA instanceof com.moloco.sdk.internal.v.b) {
            BuildersKt__Builders_commonKt.launch$default(this.f6639a, null, null, new b(vVarA, this, null), 3, null);
            return true;
        }
        if (vVarA instanceof com.moloco.sdk.internal.v.a) {
            return ((n.b.a) ((com.moloco.sdk.internal.v.a) vVarA).a()).b();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public WebView c() {
        return this.e;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void d(boolean z) {
        c("mraidbridge.setIsViewable(" + z + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        this.d.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void i() {
        c("mraidbridge.notifyReadyEvent()");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public SharedFlow<n> w() {
        return this.c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> x() {
        return this.g;
    }

    public final void c(String str) {
        MolocoAdsNetworkBridge.webviewLoadUrl(this.d, "javascript:" + str);
    }

    public final void a(n nVar) {
        c("mraidbridge.nativeCallComplete(" + JSONObject.quote(nVar.a()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(n command, String msg) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(msg, "msg");
        c("mraidbridge.notifyErrorEvent(" + JSONObject.quote(command.a()) + ", " + JSONObject.quote(msg) + ')');
    }

    public final String b(Rect rect) {
        return new StringBuilder().append(rect.width()).append(AbstractJsonLexerKt.COMMA).append(rect.height()).toString();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(q placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        c("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.b()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(s state) {
        Intrinsics.checkNotNullParameter(state, "state");
        c("mraidbridge.setState(" + JSONObject.quote(state.b()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        c("mraidbridge.setSupports(" + z + AbstractJsonLexerKt.COMMA + z2 + AbstractJsonLexerKt.COMMA + z3 + AbstractJsonLexerKt.COMMA + z4 + AbstractJsonLexerKt.COMMA + z5 + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void a(r screenMetrics) {
        Intrinsics.checkNotNullParameter(screenMetrics, "screenMetrics");
        c("\n                mraidbridge.setScreenSize(" + b(screenMetrics.g()) + ");\n                mraidbridge.setMaxSize(" + b(screenMetrics.f()) + ");\n                mraidbridge.setCurrentPosition(" + a(screenMetrics.b()) + ");\n                mraidbridge.setDefaultPosition(" + a(screenMetrics.d()) + ")\n            ");
        c("mraidbridge.notifySizeChangeEvent(" + b(screenMetrics.b()) + ')');
    }

    public final String a(Rect rect) {
        return new StringBuilder().append(rect.left).append(AbstractJsonLexerKt.COMMA).append(rect.top).append(AbstractJsonLexerKt.COMMA).append(rect.width()).append(AbstractJsonLexerKt.COMMA).append(rect.height()).toString();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public Object a(String str, Continuation<? super com.moloco.sdk.internal.v<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
        return this.d.a(str, continuation);
    }
}

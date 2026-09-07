package com.yandex.mobile.ads.features.debugpanel.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.yandex.mobile.ads.R;
import com.yandex.mobile.ads.features.debugpanel.common.BaseActivity;
import com.yandex.mobile.ads.impl.ax;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.bh2;
import com.yandex.mobile.ads.impl.bp0;
import com.yandex.mobile.ads.impl.cy;
import com.yandex.mobile.ads.impl.dy;
import com.yandex.mobile.ads.impl.ey;
import com.yandex.mobile.ads.impl.ix;
import com.yandex.mobile.ads.impl.nh2;
import com.yandex.mobile.ads.impl.nw;
import com.yandex.mobile.ads.impl.zg2;
import com.yandex.mobile.ads.impl.zx;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/yandex/mobile/ads/features/debugpanel/ui/IntegrationInspectorActivity;", "Lcom/yandex/mobile/ads/features/debugpanel/common/BaseActivity;", "Lcom/yandex/mobile/ads/impl/bp0;", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class IntegrationInspectorActivity extends BaseActivity<bp0> {
    private final Lazy d = LazyKt.lazy(new a());
    private final Lazy e = LazyKt.lazy(new e());
    private final Lazy f = LazyKt.lazy(new d());

    static final class a extends Lambda implements Function0<ax> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ax invoke() {
            Context applicationContext = IntegrationInspectorActivity.this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return new ax(applicationContext);
        }
    }

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.ui.IntegrationInspectorActivity$setupUiHandlers$1$1", f = "IntegrationInspectorActivity.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ IntegrationInspectorActivity f8337a;

            a(IntegrationInspectorActivity integrationInspectorActivity) {
                this.f8337a = integrationInspectorActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                IntegrationInspectorActivity.b(this.f8337a).a((ay) obj);
                return Unit.INSTANCE;
            }
        }

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntegrationInspectorActivity.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return IntegrationInspectorActivity.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<ay> flowC = IntegrationInspectorActivity.d(IntegrationInspectorActivity.this).c();
                a aVar = new a(IntegrationInspectorActivity.this);
                this.b = 1;
                if (flowC.collect(aVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.ui.IntegrationInspectorActivity$setupUiHandlers$1$2", f = "IntegrationInspectorActivity.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int b;

        static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ IntegrationInspectorActivity f8338a;

            a(IntegrationInspectorActivity integrationInspectorActivity) {
                this.f8338a = integrationInspectorActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                IntegrationInspectorActivity.c(this.f8338a).a((dy) obj);
                return Unit.INSTANCE;
            }
        }

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntegrationInspectorActivity.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return IntegrationInspectorActivity.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<dy> stateFlowD = IntegrationInspectorActivity.d(IntegrationInspectorActivity.this).d();
                a aVar = new a(IntegrationInspectorActivity.this);
                this.b = 1;
                if (stateFlowD.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    static final class d extends Lambda implements Function0<cy> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final cy invoke() {
            return new cy(IntegrationInspectorActivity.this);
        }
    }

    static final class e extends Lambda implements Function0<ey> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ey invoke() {
            IntegrationInspectorActivity integrationInspectorActivity = IntegrationInspectorActivity.this;
            com.yandex.mobile.ads.features.debugpanel.ui.a aVar = new com.yandex.mobile.ads.features.debugpanel.ui.a(IntegrationInspectorActivity.d(IntegrationInspectorActivity.this));
            ix ixVarA = IntegrationInspectorActivity.a(IntegrationInspectorActivity.this).a();
            return new ey(integrationInspectorActivity, aVar, ixVarA, new LinearLayoutManager(integrationInspectorActivity, 1, false), new nw(aVar, ixVarA, new zg2(aVar, ixVarA), new nh2()));
        }
    }

    private final void e() {
        CoroutineScope f8335a = getF8335a();
        BuildersKt__Builders_commonKt.launch$default(f8335a, null, null, new b(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(f8335a, null, null, new c(null), 3, null);
    }

    @Override // com.yandex.mobile.ads.features.debugpanel.common.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.y, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        b().a(zx.d.f10860a);
    }

    @Override // com.yandex.mobile.ads.features.debugpanel.common.BaseActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug);
        d();
        b().a(zx.a.f10857a);
        e();
    }

    @Override // com.yandex.mobile.ads.features.debugpanel.common.BaseActivity, android.app.Activity
    protected final void onDestroy() {
        ((ax) this.d.getValue()).a().a();
        super.onDestroy();
    }

    public static final ax a(IntegrationInspectorActivity integrationInspectorActivity) {
        return (ax) integrationInspectorActivity.d.getValue();
    }

    public static final cy b(IntegrationInspectorActivity integrationInspectorActivity) {
        return (cy) integrationInspectorActivity.f.getValue();
    }

    public static final ey c(IntegrationInspectorActivity integrationInspectorActivity) {
        return (ey) integrationInspectorActivity.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IntegrationInspectorActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b().a(zx.g.f10863a);
    }

    @Override // com.yandex.mobile.ads.features.debugpanel.common.BaseActivity
    public final bh2<bp0> c() {
        return ((ax) this.d.getValue()).b();
    }

    public static final /* synthetic */ bp0 d(IntegrationInspectorActivity integrationInspectorActivity) {
        return integrationInspectorActivity.b();
    }

    private final void d() {
        ((ImageButton) findViewById(R.id.toolbar_share_button)).setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.features.debugpanel.ui.IntegrationInspectorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegrationInspectorActivity.a(this.f$0, view);
            }
        });
    }
}

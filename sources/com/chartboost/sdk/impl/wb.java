package com.chartboost.sdk.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002\b\u0005B?\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b<\u0010=J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b\u0016\u0010 \"\u0004\b\b\u0010!R\u001c\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/chartboost/sdk/impl/wb;", "", "", "h", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "g", InneractiveMediationDefs.GENDER_FEMALE, "a", "", "d", "()Z", "e", "", SessionDescription.ATTR_LENGTH, "Landroid/content/Context;", "context", "(ILandroid/content/Context;)I", "Landroid/view/View;", "Landroid/view/View;", "trackedView", "rootView", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "I", "minVisibleDips", "minVisibleMs", "", "J", "visibilityCheckIntervalMs", "traversalLimit", "Lcom/chartboost/sdk/impl/wb$b;", "Lcom/chartboost/sdk/impl/wb$b;", "()Lcom/chartboost/sdk/impl/wb$b;", "(Lcom/chartboost/sdk/impl/wb$b;)V", "visibilityTrackerListener", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "Ljava/lang/ref/WeakReference;", "weakActivity", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "job", "Landroid/view/ViewTreeObserver;", "j", "weakViewTreeObserver", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", CampaignEx.JSON_KEY_AD_K, "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "preDrawListener", "l", "Z", "isVisibilityTracked", "m", "Ljava/lang/Long;", "startTimeMs", "Landroid/graphics/Rect;", "n", "Landroid/graphics/Rect;", "cachedRect", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;IIJI)V", "o", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class wb {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View trackedView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final View rootView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int minVisibleDips;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int minVisibleMs;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final long visibilityCheckIntervalMs;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int traversalLimit;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public b visibilityTrackerListener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final WeakReference<Activity> weakActivity;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public Job job;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public WeakReference<ViewTreeObserver> weakViewTreeObserver;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public ViewTreeObserver.OnPreDrawListener preDrawListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean isVisibilityTracked;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Long startTimeMs;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Rect cachedRect;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/chartboost/sdk/impl/wb$b;", "", "", "a", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public interface b {
        void a();
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.measurement.VisibilityTracker$scheduleVisibilityCheck$2", f = "VisibilityTracker.kt", i = {0}, l = {155}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public /* synthetic */ Object c;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.chartboost.sdk.internal.measurement.VisibilityTracker$scheduleVisibilityCheck$2$1", f = "VisibilityTracker.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int b;
            public final /* synthetic */ wb c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(wb wbVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = wbVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.c.visibilityCheckIntervalMs;
                    this.b = 1;
                    if (DelayKt.delay(j, this) == coroutine_suspended) {
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

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = wb.this.new d(continuation);
            dVar.c = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.c;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.c;
                ResultKt.throwOnFailure(obj);
            }
            while (CoroutineScopeKt.isActive(coroutineScope) && !wb.this.isVisibilityTracked) {
                if (wb.this.e()) {
                    wb wbVar = wb.this;
                    Long lBoxLong = wbVar.startTimeMs;
                    if (lBoxLong == null) {
                        lBoxLong = Boxing.boxLong(SystemClock.uptimeMillis());
                    }
                    wbVar.startTimeMs = lBoxLong;
                    if (wb.this.d()) {
                        b visibilityTrackerListener = wb.this.getVisibilityTrackerListener();
                        if (visibilityTrackerListener != null) {
                            visibilityTrackerListener.a();
                        }
                        wb.this.isVisibilityTracked = true;
                        break;
                    }
                }
                CoroutineDispatcher io2 = Dispatchers.getIO();
                a aVar = new a(wb.this, null);
                this.c = coroutineScope;
                this.b = 1;
                if (BuildersKt.withContext(io2, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public wb(Context context, View trackedView, View rootView, int i, int i2, long j, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(trackedView, "trackedView");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.trackedView = trackedView;
        this.rootView = rootView;
        this.minVisibleDips = i;
        this.minVisibleMs = i2;
        this.visibilityCheckIntervalMs = j;
        this.traversalLimit = i3;
        this.weakActivity = new WeakReference<>(context instanceof Activity ? (Activity) context : null);
        this.weakViewTreeObserver = new WeakReference<>(null);
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.chartboost.sdk.impl.wb$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return wb.f(this.f$0);
            }
        };
        this.cachedRect = new Rect();
    }

    public static final boolean f(wb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
        return true;
    }

    /* JADX INFO: renamed from: com.chartboost.sdk.impl.wb$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/chartboost/sdk/impl/wb$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "a", "(Landroid/content/Context;Landroid/view/View;)Landroid/view/View;", "", "MIN_VISIBLE_DIPS", "I", "MIN_VISIBLE_DURATION_MS", "TRAVERSAL_LIMIT", "", "VISIBILITY_CHECK_INTERVAL_MS", "J", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final View a(Context context, View view) {
            View viewFindViewById;
            View rootView;
            Window window;
            View decorView;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (viewFindViewById = decorView.findViewById(R.id.content)) == null) {
                viewFindViewById = (view == null || (rootView = view.getRootView()) == null) ? null : rootView.findViewById(R.id.content);
                if (viewFindViewById == null) {
                    if (view != null) {
                        return view.getRootView();
                    }
                    return null;
                }
            }
            return viewFindViewById;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            b7.a("Visibility check ran into a problem: " + exception, (Throwable) null, 2, (Object) null);
        }

        public c(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }
    }

    public final void h() {
        g();
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final b getVisibilityTrackerListener() {
        return this.visibilityTrackerListener;
    }

    public final void g() {
        try {
            ViewTreeObserver viewTreeObserver = this.weakViewTreeObserver.get();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                return;
            }
        } catch (Exception unused) {
            b7.a("Exception when accessing view tree observer.", (Throwable) null, 2, (Object) null);
        }
        View viewA = INSTANCE.a(this.weakActivity.get(), this.trackedView);
        ViewTreeObserver viewTreeObserver2 = viewA != null ? viewA.getViewTreeObserver() : null;
        if (viewTreeObserver2 == null) {
            return;
        }
        if (!viewTreeObserver2.isAlive()) {
            b7.b("Unable to set ViewTreeObserver since it is not alive", null, 2, null);
        } else {
            this.weakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.preDrawListener);
        }
    }

    public final void b() {
        a();
        ViewTreeObserver viewTreeObserver = this.weakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
        }
        this.weakViewTreeObserver.clear();
        this.visibilityTrackerListener = null;
    }

    public final boolean d() {
        Long l = this.startTimeMs;
        if (l != null) {
            if (SystemClock.uptimeMillis() - l.longValue() >= this.minVisibleMs) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        if (this.trackedView.getVisibility() != 0 || this.rootView.getParent() == null || this.trackedView.getWidth() <= 0 || this.trackedView.getHeight() <= 0) {
            return false;
        }
        int i = 0;
        for (ViewParent parent = this.trackedView.getParent(); parent != null && i < this.traversalLimit; parent = parent.getParent()) {
            if ((parent instanceof View) && ((View) parent).getVisibility() != 0) {
                return false;
            }
            i++;
        }
        if (!this.trackedView.getGlobalVisibleRect(this.cachedRect)) {
            return false;
        }
        int iWidth = this.cachedRect.width();
        Context context = this.trackedView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "trackedView.context");
        int iA = a(iWidth, context);
        int iHeight = this.cachedRect.height();
        Context context2 = this.trackedView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "trackedView.context");
        return iA * a(iHeight, context2) >= this.minVisibleDips;
    }

    public final void f() {
        if (this.job != null) {
            return;
        }
        this.job = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), new c(CoroutineExceptionHandler.INSTANCE), null, new d(null), 2, null);
    }

    public final void a() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
    }

    public final int a(int length, Context context) {
        return MathKt.roundToInt(length * context.getResources().getDisplayMetrics().density);
    }

    public final void a(b bVar) {
        this.visibilityTrackerListener = bVar;
    }
}

package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.R;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u0012\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020,0+\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\u0005\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/chartboost/sdk/impl/o5;", "Lcom/chartboost/sdk/impl/h3;", "Landroid/widget/RelativeLayout;", "container", "", "a", "(Landroid/widget/RelativeLayout;)V", "()V", "", ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORM, "", "(D)I", "Lcom/chartboost/sdk/impl/s6;", "e", "Lcom/chartboost/sdk/impl/s6;", "infoIcon", "Lcom/chartboost/sdk/impl/t3;", InneractiveMediationDefs.GENDER_FEMALE, "Lcom/chartboost/sdk/impl/t3;", "callback", "Lcom/chartboost/sdk/impl/i6;", "g", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "Lkotlinx/coroutines/CoroutineDispatcher;", "h", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/chartboost/sdk/impl/x1;", "i", "Lcom/chartboost/sdk/impl/x1;", "cbImageDownloader", "Lkotlinx/coroutines/Job;", "j", "Lkotlinx/coroutines/Job;", "infoIconDownloadJob", "Landroid/content/Context;", "context", "", "baseUrl", "html", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/p2;", "cbWebViewFactory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/s6;Lcom/chartboost/sdk/impl/l4;Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/i6;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lcom/chartboost/sdk/impl/x1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class o5 extends h3 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final s6 infoIcon;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final t3 callback;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final i6 impressionInterface;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final CoroutineDispatcher dispatcher;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final x1 cbImageDownloader;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public Job infoIconDownloadJob;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "it", "Lcom/chartboost/sdk/impl/t1;", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/t1;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<Context, t1> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t1 invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new t1(it);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/t3;", "cb", "Lcom/chartboost/sdk/impl/l4;", ApsMetricsDataMap.APSMETRICS_FIELD_ENDTIME, "Lcom/chartboost/sdk/impl/s3;", "a", "(Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/l4;)Lcom/chartboost/sdk/impl/s3;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function2<t3, l4, s3> {
        public final /* synthetic */ i6 b;
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i6 i6Var, Context context) {
            super(2);
            this.b = i6Var;
            this.c = context;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s3 invoke(t3 cb, l4 et) {
            Intrinsics.checkNotNullParameter(cb, "cb");
            Intrinsics.checkNotNullParameter(et, "et");
            return new u1(this.b, new w9(this.c), cb, et);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1093a;

        static {
            int[] iArr = new int[s6.b.values().length];
            try {
                iArr[s6.b.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[s6.b.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[s6.b.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[s6.b.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f1093a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.View.HtmlWebViewBase$makeInfoIcon$1", f = "HtmlWebViewBase.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ ImageView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ImageView imageView, Continuation<? super d> continuation) {
            super(2, continuation);
            this.d = imageView;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o5.this.new d(this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                x1 x1Var = o5.this.cbImageDownloader;
                String str = o5.this.infoIcon.getIo.bidmachine.unified.UnifiedMediationParams.KEY_IMAGE_URL java.lang.String();
                this.b = 1;
                obj = x1Var.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                this.d.setImageBitmap(bitmap);
            }
            this.d.setVisibility(0);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(Context context, String baseUrl, String html, s6 infoIcon, l4 eventTracker, t3 callback, i6 impressionInterface, CoroutineDispatcher dispatcher, Function1<? super Context, ? extends p2> cbWebViewFactory, x1 cbImageDownloader) {
        super(context, html, callback, impressionInterface, baseUrl, eventTracker, cbWebViewFactory, null, new b(impressionInterface, context), 128, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(infoIcon, "infoIcon");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(cbWebViewFactory, "cbWebViewFactory");
        Intrinsics.checkNotNullParameter(cbImageDownloader, "cbImageDownloader");
        this.infoIcon = infoIcon;
        this.callback = callback;
        this.impressionInterface = impressionInterface;
        this.dispatcher = dispatcher;
        this.cbImageDownloader = cbImageDownloader;
        addView(getWebViewContainer());
        callback.a();
        callback.b();
    }

    @Override // com.chartboost.sdk.impl.h3, com.chartboost.sdk.impl.vb, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.c, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.chartboost.sdk.impl.h3, com.chartboost.sdk.impl.vb, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public /* synthetic */ o5(Context context, String str, String str2, s6 s6Var, l4 l4Var, t3 t3Var, i6 i6Var, CoroutineDispatcher coroutineDispatcher, Function1 function1, x1 x1Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, s6Var, l4Var, t3Var, i6Var, (i & 128) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 256) != 0 ? a.b : function1, (i & 512) != 0 ? new x1(null, null, null, 7, null) : x1Var);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0})
    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }

        public final void a(Throwable th) {
            o5.this.infoIconDownloadJob = null;
        }
    }

    @Override // com.chartboost.sdk.impl.vb
    public void a() {
        Job job = this.infoIconDownloadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.infoIconDownloadJob = null;
        super.a();
    }

    public final int a(double dp) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            dp *= (double) displayMetrics.density;
        }
        return MathKt.roundToInt(dp);
    }

    public final void a(RelativeLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(this.infoIcon.getSize().getWidth()), a(this.infoIcon.getSize().getHeight()));
        int i = c.f1093a[this.infoIcon.getPosition().ordinal()];
        if (i == 1) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else if (i == 3) {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        } else if (i == 4) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        }
        layoutParams.setMargins(a(this.infoIcon.getIo.bidmachine.iab.vast.tags.VastAttributes.MARGIN java.lang.String().getWidth()), a(this.infoIcon.getIo.bidmachine.iab.vast.tags.VastAttributes.MARGIN java.lang.String().getHeight()), a(this.infoIcon.getIo.bidmachine.iab.vast.tags.VastAttributes.MARGIN java.lang.String().getWidth()), a(this.infoIcon.getIo.bidmachine.iab.vast.tags.VastAttributes.MARGIN java.lang.String().getHeight()));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.cb_info_icon);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.chartboost.sdk.impl.o5$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o5.a(this.f$0, view);
            }
        });
        imageView.setVisibility(8);
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatcher), null, null, new d(imageView, null), 3, null);
        jobLaunch$default.invokeOnCompletion(new e());
        this.infoIconDownloadJob = jobLaunch$default;
        container.addView(imageView, layoutParams);
        this.callback.a(imageView);
    }

    public static final void a(o5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.impressionInterface.a(new m2(this$0.infoIcon.getClickthroughUrl(), Boolean.FALSE));
    }
}

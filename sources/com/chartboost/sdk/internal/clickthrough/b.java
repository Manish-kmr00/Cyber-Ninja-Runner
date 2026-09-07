package com.chartboost.sdk.internal.clickthrough;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.impl.b3;
import com.chartboost.sdk.impl.e3;
import com.chartboost.sdk.impl.ua;
import com.chartboost.sdk.impl.va;
import com.chartboost.sdk.impl.w6;
import com.chartboost.sdk.impl.xa;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001ad\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001ad\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u001an\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0013\u001ad\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000f\u001a)\u0010\u0010\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0017\u001a\u0013\u0010\u0010\u001a\u00020\u0018*\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0019\u001a\u0013\u0010\u000e\u001a\u00020\u0018*\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u0019\u001a\u0013\u0010\u000e\u001a\u00020\b*\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u001a\u001a+\u0010\u0010\u001a\u00020\u0018*\u0004\u0018\u00010\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/chartboost/sdk/impl/va;", "args", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Landroid/net/Uri;", "uriParser", "Landroid/content/Intent;", "intentFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "Lkotlin/Result;", "Lcom/chartboost/sdk/impl/ua;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/va;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/chartboost/sdk/impl/w6;", "intentResolver", "(Lcom/chartboost/sdk/impl/va;Landroid/content/Context;Lcom/chartboost/sdk/impl/w6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, SDKConstants.PARAM_INTENT, "", "(Landroid/content/Context;Landroid/content/Intent;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lcom/chartboost/sdk/impl/va;)Z", "(Landroid/content/Intent;)Landroid/content/Intent;", "(Lcom/chartboost/sdk/impl/va;Lkotlin/jvm/functions/Function1;)Z", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class b {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlOpenerKt", f = "UrlOpener.kt", i = {}, l = {62}, m = "openDeepLink", n = {}, s = {})
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object b;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            Object objA = b.a(null, null, null, null, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    /* JADX INFO: renamed from: com.chartboost.sdk.internal.clickthrough.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class C0269b extends FunctionReferenceImpl implements Function1<String, Uri> {
        public static final C0269b b = new C0269b();

        public C0269b() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "it", "Landroid/content/Intent;", "a", "(Landroid/net/Uri;)Landroid/content/Intent;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<Uri, Intent> {
        public static final c b = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Uri it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Intent("android.intent.action.VIEW", it);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlOpenerKt", f = "UrlOpener.kt", i = {}, l = {41}, m = "openInEmbeddedBrowser", n = {}, s = {})
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object b;
        public int c;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            Object objA = b.a(null, null, null, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7903boximpl(objA);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<String, Uri> {
        public static final e b = new e();

        public e() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "url", "Landroid/content/Intent;", "a", "(Ljava/lang/String;)Landroid/content/Intent;"}, k = 3, mv = {1, 8, 0})
    public static final class f extends Lambda implements Function1<String, Intent> {
        public final /* synthetic */ Context b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(1);
            this.b = context;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return EmbeddedBrowserActivity.INSTANCE.a(this.b, url);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlOpenerKt", f = "UrlOpener.kt", i = {}, l = {22}, m = "openInNativeBrowser", n = {}, s = {})
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object b;
        public int c;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            Object objB = b.b(null, null, null, null, null, this);
            return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Result.m7903boximpl(objB);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class h extends FunctionReferenceImpl implements Function1<String, Uri> {
        public static final h b = new h();

        public h() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "it", "Landroid/content/Intent;", "a", "(Landroid/net/Uri;)Landroid/content/Intent;"}, k = 3, mv = {1, 8, 0})
    public static final class i extends Lambda implements Function1<Uri, Intent> {
        public static final i b = new i();

        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Uri it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Intent("android.intent.action.VIEW", it);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlOpenerKt", f = "UrlOpener.kt", i = {}, l = {78}, m = "openUnsecureLink", n = {}, s = {})
    public static final class j extends ContinuationImpl {
        public /* synthetic */ Object b;
        public int c;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            Object objC = b.c(null, null, null, null, null, this);
            return objC == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Result.m7903boximpl(objC);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class k extends FunctionReferenceImpl implements Function1<String, Uri> {
        public static final k b = new k();

        public k() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "it", "Landroid/content/Intent;", "a", "(Landroid/net/Uri;)Landroid/content/Intent;"}, k = 3, mv = {1, 8, 0})
    public static final class l extends Lambda implements Function1<Uri, Intent> {
        public static final l b = new l();

        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Uri it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Intent("android.intent.action.VIEW", it);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.chartboost.sdk.internal.clickthrough.UrlOpenerKt$startActivityInMain$2", f = "UrlOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ Intent d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Context context, Intent intent, Continuation<? super m> continuation) {
            super(2, continuation);
            this.c = context;
            this.d = intent;
        }

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.c);
            p0.startActivity(p1);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new m(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.c, b.b(this.d));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(va vaVar, Context context, Function1<? super String, ? extends Uri> function1, Function1<? super Uri, ? extends Intent> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<ua>> continuation) throws Throwable {
        j jVar;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i2 = jVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                jVar.c = i2 - Integer.MIN_VALUE;
            } else {
                jVar = new j(continuation);
            }
        } else {
            jVar = new j(continuation);
        }
        Object obj = jVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = jVar.c;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                if (!a(vaVar, function1)) {
                    throw com.chartboost.sdk.internal.clickthrough.a.b.b;
                }
                Intent intentInvoke = function2.invoke(function1.invoke(vaVar.getUrl()));
                jVar.c = 1;
                if (a(context, intentInvoke, coroutineDispatcher, jVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m7904constructorimpl(new ua("openUnsecureLink"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ Object c(va vaVar, Context context, Function1 function1, Function1 function2, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            function1 = k.b;
        }
        Function1 function3 = function1;
        if ((i2 & 8) != 0) {
            function2 = l.b;
        }
        Function1 function4 = function2;
        if ((i2 & 16) != 0) {
            coroutineDispatcher = Dispatchers.getMain();
        }
        return c(vaVar, context2, function3, function4, coroutineDispatcher, continuation);
    }

    public static final boolean a(va vaVar) {
        return vaVar.getClickPreference() == b3.CLICK_PREFERENCE_EMBEDDED;
    }

    public static final boolean b(va vaVar) {
        return vaVar.getClickPreference() == b3.CLICK_PREFERENCE_NATIVE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(va vaVar, Context context, Function1<? super String, ? extends Uri> function1, Function1<? super Uri, ? extends Intent> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<ua>> continuation) throws Throwable {
        g gVar;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i2 = gVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gVar.c = i2 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object obj = gVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = gVar.c;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                if (b(vaVar)) {
                    Intent intentInvoke = function2.invoke(function1.invoke(xa.b(vaVar).getUrl()));
                    gVar.c = 1;
                    if (a(context, intentInvoke, coroutineDispatcher, gVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw com.chartboost.sdk.internal.clickthrough.a.c.b;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m7904constructorimpl(new ua("openInNativeBrowser"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ Object b(va vaVar, Context context, Function1 function1, Function1 function2, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            function1 = h.b;
        }
        Function1 function3 = function1;
        if ((i2 & 8) != 0) {
            function2 = i.b;
        }
        Function1 function4 = function2;
        if ((i2 & 16) != 0) {
            coroutineDispatcher = Dispatchers.getMain();
        }
        return b(vaVar, context2, function3, function4, coroutineDispatcher, continuation);
    }

    public static final Intent b(Intent intent) {
        intent.setFlags(268435456);
        return intent;
    }

    public static final boolean a(va vaVar, Function1<? super String, ? extends Uri> function1) {
        if (vaVar != null) {
            return Intrinsics.areEqual(function1.invoke(vaVar.getUrl()).getScheme(), "http");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(va vaVar, Context context, w6 w6Var, Function1<? super String, ? extends Uri> function1, Function1<? super Uri, ? extends Intent> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<ua>> continuation) throws Throwable {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.c = i2 - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object obj = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = aVar.c;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                if (w6Var.b(vaVar.getUrl())) {
                    Intent intentInvoke = function2.invoke(function1.invoke(vaVar.getUrl()));
                    aVar.c = 1;
                    if (a(context, intentInvoke, coroutineDispatcher, aVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw com.chartboost.sdk.internal.clickthrough.a.C0268a.b;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m7904constructorimpl(new ua("openDeepLink"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ Object a(va vaVar, Context context, w6 w6Var, Function1 function1, Function1 function2, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            w6Var = e3.b();
        }
        w6 w6Var2 = w6Var;
        if ((i2 & 8) != 0) {
            function1 = C0269b.b;
        }
        Function1 function3 = function1;
        if ((i2 & 16) != 0) {
            function2 = c.b;
        }
        Function1 function4 = function2;
        if ((i2 & 32) != 0) {
            coroutineDispatcher = Dispatchers.getMain();
        }
        return a(vaVar, context2, w6Var2, function3, function4, coroutineDispatcher, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(va vaVar, Context context, Function1<? super String, ? extends Uri> function1, Function1<? super String, ? extends Intent> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<ua>> continuation) throws Throwable {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.c = i2 - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj = dVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dVar.c;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                if (a(vaVar)) {
                    function1.invoke(vaVar.getUrl());
                    Intent intentInvoke = function2.invoke(xa.b(vaVar).getUrl());
                    dVar.c = 1;
                    if (a(context, intentInvoke, coroutineDispatcher, dVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw com.chartboost.sdk.internal.clickthrough.a.c.b;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m7904constructorimpl(new ua("openInEmbeddedBrowser"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ Object a(va vaVar, Context context, Function1 function1, Function1 function2, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            function1 = e.b;
        }
        Function1 function3 = function1;
        if ((i2 & 8) != 0) {
            function2 = new f(context2);
        }
        Function1 function4 = function2;
        if ((i2 & 16) != 0) {
            coroutineDispatcher = Dispatchers.getMain();
        }
        return a(vaVar, context2, function3, function4, coroutineDispatcher, continuation);
    }

    public static final Object a(Context context, Intent intent, CoroutineDispatcher coroutineDispatcher, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher, new m(context, intent, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}

package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class d0 extends AbstractC4633i {
    public static final b l = new b(null);
    private final e0 g;
    private final Function1 h;
    private Context i;
    private C4639o j;
    private final String k;

    static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12081a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C4639o invoke(Context context) {
            return new C4639o(context);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f12082a;
        /* synthetic */ Object b;
        int d;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return d0.this.a(null, this);
        }
    }

    public d0(e0 e0Var, Function1 function1) {
        this.g = e0Var;
        this.h = function1;
        this.k = "apur";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.bidmachine.analytics.internal.AbstractC4633i
    public Object a(ReaderConfig.Rule rule, Continuation continuation) throws Throwable {
        c cVar;
        d0 d0Var;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.d = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            C4639o c4639o = this.j;
            if (c4639o == null) {
                throw new IllegalArgumentException("Not configured".toString());
            }
            Duration.Companion companion = Duration.INSTANCE;
            long jM9250getInWholeMillisecondsimpl = Duration.m9250getInWholeMillisecondsimpl(DurationKt.toDuration(10, DurationUnit.SECONDS));
            cVar.f12082a = this;
            cVar.d = 1;
            objA = c4639o.a(jM9250getInWholeMillisecondsimpl, cVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            d0Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0Var = (d0) cVar.f12082a;
            ResultKt.throwOnFailure(objA);
        }
        C4638n c4638n = (C4638n) objA;
        d0Var.g.a(c4638n);
        if (c4638n == null) {
            throw new FileNotFoundException("Data not received yet");
        }
        if (c4638n.e()) {
            throw new FileNotFoundException("Data is empty");
        }
        return c4638n.a();
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void d(Context context) {
        this.i = context;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i, io.bidmachine.analytics.internal.AbstractC4634j
    public void e(Context context) {
        super.e(context);
        C4639o c4639o = this.j;
        if (c4639o != null) {
            c4639o.j();
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i, io.bidmachine.analytics.internal.AbstractC4634j
    public void f(Context context) {
        C4639o c4639o = this.j;
        if (c4639o != null) {
            c4639o.i();
        }
        super.f(context);
    }

    public /* synthetic */ d0(e0 e0Var, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(e0Var, (i & 2) != 0 ? a.f12081a : function1);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public String a() {
        return this.k;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i, io.bidmachine.analytics.internal.AbstractC4634j
    /* JADX INFO: renamed from: a */
    public void b(AbstractC4633i.a aVar) {
        super.b(aVar);
        Context context = this.i;
        if (context == null) {
            throw new IllegalArgumentException("Context is null".toString());
        }
        if (aVar.c().size() != 1) {
            throw new IllegalStateException(("Reader " + a() + " should contains only one rule, received " + aVar.c().size()).toString());
        }
        List listSplit$default = StringsKt.split$default((CharSequence) s0.b(((ReaderConfig.Rule) CollectionsKt.first(aVar.c())).getPath()), new String[]{"-"}, false, 0, 6, (Object) null);
        if (listSplit$default.size() != 2) {
            throw new IllegalStateException("Path should contains min and max value".toString());
        }
        t0.a aVar2 = t0.d;
        t0 t0VarA = aVar2.a(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString());
        if (t0VarA == null) {
            throw new IllegalStateException("Min version not found".toString());
        }
        t0 t0VarA2 = aVar2.a(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
        if (t0VarA2 == null) {
            throw new IllegalStateException("Max version not found".toString());
        }
        C4639o c4639o = this.j;
        if (c4639o == null) {
            c4639o = (C4639o) this.h.invoke(context);
        }
        this.j = c4639o;
        t0 t0VarL = c4639o.l();
        if (t0VarL == null) {
            throw new IllegalStateException("Version not found".toString());
        }
        if (t0VarL.compareTo(t0VarA) < 0 || t0VarL.compareTo(t0VarA2) > 0) {
            throw new IllegalStateException(("Version " + t0VarL + " not supported by config").toString());
        }
        if (!c4639o.t()) {
            throw new IllegalStateException("No host found".toString());
        }
        if (!c4639o.s()) {
            throw new IllegalStateException("No permission".toString());
        }
    }
}

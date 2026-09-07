package io.bidmachine.analytics.internal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes8.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final J f12046a;
    private final K b;
    private final CoroutineScope c;
    private Job d;

    public interface a {
        G a();
    }

    static final class b extends SuspendLambda implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12047a;
        private /* synthetic */ Object b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Continuation continuation) {
            super(2, continuation);
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            b bVar = G.this.new b(this.d, continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            BufferedReader bufferedReader;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f12047a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            K k = G.this.b;
            G g = G.this;
            String str = this.d;
            synchronized (k) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    InputStream inputStreamA = g.b.a(StringsKt.split$default((CharSequence) s0.b(str), new String[]{" "}, false, 0, 6, (Object) null));
                    Unit unit = null;
                    if (inputStreamA != null) {
                        Reader inputStreamReader = new InputStreamReader(inputStreamA, Charsets.UTF_8);
                        bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    } else {
                        bufferedReader = null;
                    }
                    if (bufferedReader != null) {
                        try {
                            g.a(str, TextStreamsKt.lineSequence(bufferedReader));
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedReader, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(bufferedReader, th);
                                throw th2;
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        unit = Unit.INSTANCE;
                    }
                    Result.m7904constructorimpl(unit);
                } catch (Throwable th3) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m7904constructorimpl(ResultKt.createFailure(th3));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public G(J j, K k, CoroutineScope coroutineScope) {
        this.f12046a = j;
        this.b = k;
        this.c = coroutineScope;
    }

    private final boolean b() {
        Job job = this.d;
        return job != null && job.isActive();
    }

    public final void a() {
        Job job = this.d;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.d = null;
        synchronized (this.b) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.b.a();
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public final void a(String str) {
        Job job = this.d;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.d = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(str, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, Sequence sequence) {
        Iterator it = sequence.iterator();
        while (b() && it.hasNext()) {
            this.f12046a.a(str, (String) it.next());
        }
    }
}

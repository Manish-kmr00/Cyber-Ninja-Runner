package io.bidmachine.analytics.internal;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f12051a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public K() {
        Result.Companion companion = Result.INSTANCE;
        this.f12051a = Result.m7904constructorimpl(ResultKt.createFailure(new NullPointerException()));
        this.b = "amF2YS5sYW5nLlByb2Nlc3NCdWlsZGVy";
        this.c = "c3RhcnQ=";
        this.d = "Z2V0SW5wdXRTdHJlYW0=";
        this.e = "ZGVzdHJveQ==";
    }

    public final InputStream a(List list) {
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        Method method;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName(s0.a(this.b));
            objM7904constructorimpl = Result.m7904constructorimpl(cls.getMethod(s0.a(this.c), new Class[0]).invoke(cls.getConstructor(List.class).newInstance(CollectionsKt.toList(list)), new Object[0]));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        this.f12051a = objM7904constructorimpl;
        if (Result.m7911isSuccessimpl(objM7904constructorimpl)) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objM7904constructorimpl2 = Result.m7904constructorimpl((InputStream) ((objM7904constructorimpl == null || (method = objM7904constructorimpl.getClass().getMethod(s0.a(this.d), new Class[0])) == null) ? null : method.invoke(objM7904constructorimpl, new Object[0])));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM7904constructorimpl = ResultKt.createFailure(th2);
                objM7904constructorimpl2 = Result.m7904constructorimpl(objM7904constructorimpl);
            }
        } else {
            objM7904constructorimpl2 = Result.m7904constructorimpl(objM7904constructorimpl);
        }
        return (InputStream) (Result.m7910isFailureimpl(objM7904constructorimpl2) ? null : objM7904constructorimpl2);
    }

    public final void a() {
        Method method;
        Object objCreateFailure = this.f12051a;
        if (Result.m7911isSuccessimpl(objCreateFailure)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m7904constructorimpl((objCreateFailure == null || (method = objCreateFailure.getClass().getMethod(s0.a(this.e), new Class[0])) == null) ? null : method.invoke(objCreateFailure, new Object[0]));
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objCreateFailure = ResultKt.createFailure(th);
            }
        }
        Result.m7904constructorimpl(objCreateFailure);
    }
}

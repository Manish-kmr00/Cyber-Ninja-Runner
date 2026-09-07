package io.bidmachine.analytics.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class J {
    private static final a d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12050a;
    private final Map b;
    private final Object c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public J(int i) {
        this.f12050a = i;
        this.b = new LinkedHashMap();
        this.c = new Object();
    }

    private final L a() {
        int i = this.f12050a;
        return new L(i / 2, i);
    }

    public final String b(String str) {
        Object objM7904constructorimpl;
        Long lA;
        synchronized (this.c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                L l = (L) this.b.get(str);
                objM7904constructorimpl = Result.m7904constructorimpl((l == null || (lA = l.a()) == null) ? null : lA.toString());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
        return (String) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    public /* synthetic */ J(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2097152 : i);
    }

    public final InputStream a(String str) {
        Object objM7904constructorimpl;
        synchronized (this.c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                L l = (L) this.b.remove(str);
                objM7904constructorimpl = Result.m7904constructorimpl(new ByteArrayInputStream(l != null ? M.a(l) : null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
        return (InputStream) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    public final void a(String str, String str2) {
        synchronized (this.c) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Map map = this.b;
                Object objA = map.get(str);
                if (objA == null) {
                    objA = a();
                    map.put(str, objA);
                }
                ((L) objA).a(str2);
                Result.m7904constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}

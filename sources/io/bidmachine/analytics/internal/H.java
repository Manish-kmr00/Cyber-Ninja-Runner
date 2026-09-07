package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
public final class H extends AbstractC4633i {
    public static final a j = new a(null);
    private final J g;
    private final I h;
    private final String i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public H(J j2, I i) {
        this.g = j2;
        this.h = i;
        this.i = "alog";
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i
    public Object a(ReaderConfig.Rule rule, Continuation continuation) {
        return this.h.a(rule);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public void d(Context context) {
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i, io.bidmachine.analytics.internal.AbstractC4634j
    public void e(Context context) {
        super.e(context);
        this.h.a();
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i, io.bidmachine.analytics.internal.AbstractC4634j
    public void f(Context context) {
        this.h.b();
        super.f(context);
    }

    public /* synthetic */ H(J j2, I i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, (i2 & 2) != 0 ? new I(j2, null, 2, null) : i);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4634j
    public String a() {
        return this.i;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC4633i, io.bidmachine.analytics.internal.AbstractC4634j
    /* JADX INFO: renamed from: a */
    public void b(AbstractC4633i.a aVar) {
        super.b(aVar);
        this.h.a(aVar);
    }
}

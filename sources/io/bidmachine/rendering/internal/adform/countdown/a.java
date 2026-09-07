package io.bidmachine.rendering.internal.adform.countdown;

import android.content.Context;
import android.view.View;
import io.bidmachine.rendering.internal.adform.c;
import io.bidmachine.rendering.internal.m;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.utils.Utils;

/* JADX INFO: loaded from: classes3.dex */
public class a extends io.bidmachine.rendering.internal.adform.a {
    private final io.bidmachine.rendering.internal.view.b i;

    private final class b implements io.bidmachine.rendering.internal.view.b.d {
        private b() {
        }

        @Override // io.bidmachine.rendering.internal.view.b.d
        public void a() {
            a.this.p().a();
        }
    }

    public a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, c cVar, io.bidmachine.rendering.internal.event.a aVar2) {
        super(context, aVar, adElementParams, cVar, aVar2);
        io.bidmachine.rendering.internal.view.b bVar = new io.bidmachine.rendering.internal.view.b(context);
        this.i = bVar;
        bVar.setListener(new b());
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.t
    public void a(String str) {
        Integer intOrNull = Utils.toIntOrNull(str);
        if (intOrNull == null) {
            m.a("Can't obtain time to start", new Object[0]);
        } else {
            this.i.setDuration(intOrNull.intValue());
            this.i.f();
        }
    }

    @Override // io.bidmachine.rendering.internal.a
    public void c() {
        r().b(this);
    }

    @Override // io.bidmachine.rendering.internal.a
    public void d() {
        this.i.g();
    }

    @Override // io.bidmachine.rendering.internal.a
    public void e() {
        this.i.e();
    }

    @Override // io.bidmachine.rendering.internal.a
    public View k() {
        return this.i;
    }

    @Override // io.bidmachine.rendering.internal.adform.a
    protected void v() {
        this.i.b();
    }
}

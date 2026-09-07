package io.bidmachine.rendering.internal.adform.progress;

import android.content.Context;
import android.view.View;
import io.bidmachine.rendering.internal.q;
import io.bidmachine.rendering.internal.view.c;
import io.bidmachine.rendering.model.AdElementParams;

/* JADX INFO: loaded from: classes13.dex */
public class a extends io.bidmachine.rendering.internal.adform.a implements q {
    private final c i;

    public a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, io.bidmachine.rendering.internal.adform.c cVar, io.bidmachine.rendering.internal.event.a aVar2) {
        super(context, aVar, adElementParams, cVar, aVar2);
        this.i = new c(context);
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.q
    public void a(long j, long j2, float f) {
        this.i.a(j, j2, f);
    }

    @Override // io.bidmachine.rendering.internal.a
    public void c() {
        r().b(this);
    }

    @Override // io.bidmachine.rendering.internal.a
    public View k() {
        return this.i;
    }
}

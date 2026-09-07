package io.bidmachine.rendering.internal.adform;

import android.content.Context;
import android.view.View;
import io.bidmachine.rendering.internal.u;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.rendering.utils.VisibilityChanger;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a extends u implements io.bidmachine.rendering.internal.a, View.OnClickListener, VisibilityChanger {
    private final Context c;
    private final io.bidmachine.rendering.internal.repository.a d;
    private final AdElementParams e;
    private final c f;
    private volatile boolean g;
    private volatile boolean h;

    public a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, c cVar, io.bidmachine.rendering.internal.event.a aVar2) {
        super(aVar2);
        this.c = context;
        this.d = aVar;
        this.e = adElementParams;
        this.f = cVar;
    }

    @Override // io.bidmachine.rendering.internal.u, io.bidmachine.rendering.internal.a
    public void a() {
        super.a();
        v();
    }

    @Override // io.bidmachine.rendering.internal.a
    public AdElementParams i() {
        return this.e;
    }

    @Override // io.bidmachine.rendering.utils.VisibilityChanger
    public void lockVisibility(boolean z) {
        setVisibility(z);
        this.h = true;
    }

    @Override // io.bidmachine.rendering.internal.a
    public void n() {
        u();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u();
    }

    @Override // io.bidmachine.rendering.internal.u
    public String q() {
        return this.e.getName();
    }

    protected c r() {
        return this.f;
    }

    protected Context s() {
        return this.c;
    }

    @Override // io.bidmachine.rendering.utils.VisibilityChanger
    public void setVisibility(boolean z) {
        this.g = z;
        if (this.h) {
            return;
        }
        if (z) {
            UiUtils.safeShowView(k());
        } else {
            UiUtils.safeHideView(k());
        }
    }

    protected io.bidmachine.rendering.internal.repository.a t() {
        return this.d;
    }

    public String toString() {
        return "type - " + this.e.getAdElementType() + ", name - " + this.e.getName();
    }

    public void u() {
        p().i();
    }

    @Override // io.bidmachine.rendering.utils.VisibilityChanger
    public void unlockVisibility() {
        this.h = false;
        setVisibility(this.g);
    }

    protected void v() {
    }
}

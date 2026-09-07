package io.bidmachine.rendering.internal;

import io.bidmachine.rendering.model.MethodParams;

/* JADX INFO: loaded from: classes11.dex */
public class n extends u {
    private final MethodParams c;

    public n(MethodParams methodParams, io.bidmachine.rendering.internal.event.a aVar) {
        super(aVar);
        this.c = methodParams;
    }

    @Override // io.bidmachine.rendering.internal.u
    public String q() {
        return this.c.getName();
    }

    public MethodParams r() {
        return this.c;
    }
}

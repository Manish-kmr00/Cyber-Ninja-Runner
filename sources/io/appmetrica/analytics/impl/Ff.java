package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class Ff implements Pn {
    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(Object obj) {
        Integer num = (Integer) obj;
        return (num == null || num.intValue() > 0) ? new Nn(this, true, "") : new Nn(this, false, "Invalid quantity value " + num);
    }
}

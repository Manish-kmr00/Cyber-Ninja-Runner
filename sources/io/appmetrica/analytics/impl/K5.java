package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class K5 implements J8, W8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S6 f11219a;
    public final Set b;
    public final AtomicLong c;

    public K5(S6 s6) {
        this.f11219a = s6;
        Set of = SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(EnumC4164hb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_APP_UPDATE.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_FIRST_ACTIVATION.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_INIT.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_SEND_AD_REVENUE_EVENT.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_SEND_ECOMMERCE_EVENT.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_SEND_REFERRER.a()), Integer.valueOf(EnumC4164hb.EVENT_TYPE_SEND_REVENUE_EVENT.a())});
        this.b = of;
        this.c = new AtomicLong(s6.a(of));
        s6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final void a() {
        this.c.set(this.f11219a.a(this.b));
    }

    @Override // io.appmetrica.analytics.impl.J8
    public final boolean b() {
        return this.c.get() > 0;
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final void b(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (this.b.contains(Integer.valueOf(((Number) it.next()).intValue())) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.c.addAndGet(-i);
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final void a(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (this.b.contains(Integer.valueOf(((Number) it.next()).intValue())) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.c.addAndGet(i);
    }
}

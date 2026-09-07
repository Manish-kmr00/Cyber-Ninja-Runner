package io.appmetrica.analytics.impl;

import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.coreutils.internal.toggle.ConjunctiveCompositeThreadSafeToggle;
import io.appmetrica.analytics.coreutils.internal.toggle.OuterStateToggle;
import io.appmetrica.analytics.coreutils.internal.toggle.SavableToggle;
import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oe f11149a = C4486ua.j().x();
    public final SavableToggle b;
    public final OuterStateToggle c;
    public final OuterStateToggle d;
    public final ConjunctiveCompositeThreadSafeToggle e;
    public final ConjunctiveCompositeThreadSafeToggle f;
    public final SavableToggle g;

    public G(Hl hl) {
        SavableToggle savableToggle = new SavableToggle("advIdsFromClientApi", new F(this));
        this.b = savableToggle;
        OuterStateToggle outerStateToggle = new OuterStateToggle(false, "GAID-remote-config");
        this.c = outerStateToggle;
        OuterStateToggle outerStateToggle2 = new OuterStateToggle(false, "HOAID-remote-config");
        this.d = outerStateToggle2;
        this.e = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) new SimpleThreadSafeToggle[]{savableToggle, outerStateToggle}), IronSourceConstants.TYPE_GAID);
        this.f = new ConjunctiveCompositeThreadSafeToggle(CollectionsKt.listOf((Object[]) new SimpleThreadSafeToggle[]{savableToggle, outerStateToggle2}), "HOAID");
        this.g = savableToggle;
        a(hl);
    }

    public final void a(Hl hl) {
        boolean z = hl.p;
        this.c.update(!z || hl.n.c);
        this.d.update(!z || hl.n.e);
    }

    public final D a() {
        int i;
        int i2 = 3;
        int i3 = 4;
        if (this.e.getActualState()) {
            i = 1;
        } else if (this.b.getActualState()) {
            i = !this.c.getActualState() ? 3 : 4;
        } else {
            i = 2;
        }
        if (this.f.getActualState()) {
            i2 = 1;
        } else if (!this.b.getActualState()) {
            i2 = 2;
        } else if (this.d.getActualState()) {
            i2 = 4;
        }
        if (this.g.getActualState()) {
            i3 = 1;
        } else if (!this.b.getActualState()) {
            i3 = 2;
        }
        return new D(i, i2, i3);
    }
}

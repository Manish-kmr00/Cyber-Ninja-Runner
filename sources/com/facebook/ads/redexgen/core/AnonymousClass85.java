package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.85, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass85 extends ContextWrapper {
    public final AnonymousClass87 A00;
    public final AtomicReference<String> A01;

    public AnonymousClass85(Context context, AnonymousClass87 anonymousClass87) {
        super(context.getApplicationContext());
        this.A01 = new AtomicReference<>();
        this.A00 = anonymousClass87;
    }

    public final InterfaceC12431j A00(AnonymousClass85 anonymousClass85) {
        return this.A00.A82(anonymousClass85);
    }

    public final InterfaceC14107x A01() {
        return this.A00.A76();
    }

    public final C2698k0 A02() {
        return this.A00.A8p(this);
    }

    public final AnonymousClass86 A03() {
        return this.A00.A6u(this);
    }

    public final AnonymousClass88 A04() {
        return this.A00.A7n(this);
    }

    public final C8A A05() {
        return this.A00.A8o(this);
    }

    public final C8B A06() {
        return this.A00.A95();
    }

    public final C8M A07() {
        return this.A00.A7b(this);
    }

    public final C8Z A08() {
        return this.A00.A7d(this);
    }

    public final AnonymousClass94 A09() {
        return this.A00.A8w();
    }

    public final A7 A0A() {
        return this.A00.A6d(A02());
    }

    public final AJ A0B() {
        return this.A00.A8q(A02());
    }

    public final String A0C() {
        return this.A01.get();
    }

    public final void A0D(String str) {
        this.A01.set(str);
    }
}

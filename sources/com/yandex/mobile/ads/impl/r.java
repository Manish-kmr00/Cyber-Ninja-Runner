package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f10060a = new s();
    private final wf1 b = new wf1(2786);
    private boolean c;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.r$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return r.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.f10060a.a(y70Var, new i72.d(Integer.MIN_VALUE, 0, 1));
        y70Var.a();
        y70Var.a(new xw1.b(-9223372036854775807L, 0L));
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        int i = ((tz) x70Var).read(this.b.c(), 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.b.e(0);
        this.b.d(i);
        if (!this.c) {
            this.f10060a.a(4, 0L);
            this.c = true;
        }
        this.f10060a.a(this.b);
        return 0;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.c = false;
        this.f10060a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] a() {
        return new w70[]{new r()};
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar;
        wf1 wf1Var = new wf1(10);
        int i = 0;
        while (true) {
            tzVar = (tz) x70Var;
            tzVar.b(wf1Var.c(), 0, 10, false);
            wf1Var.e(0);
            if (wf1Var.w() != 4801587) {
                break;
            }
            wf1Var.f(3);
            int iS = wf1Var.s();
            i += iS + 10;
            tzVar.a(false, iS);
        }
        tzVar.c();
        tzVar.a(false, i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            tzVar.b(wf1Var.c(), 0, 6, false);
            wf1Var.e(0);
            if (wf1Var.z() != 2935) {
                tzVar.c();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                tzVar.a(false, i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iA = t.a(wf1Var.c());
                if (iA == -1) {
                    return false;
                }
                tzVar.a(false, iA - 6);
            }
        }
    }
}

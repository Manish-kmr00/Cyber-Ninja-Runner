package com.inmobi.media;

import com.inmobi.adquality.models.AdQualityResult;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class V implements D9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z f3213a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Bb c;
    public final /* synthetic */ String d;

    public V(Z z, boolean z2, Bb bb, String str) {
        this.f3213a = z;
        this.b = z2;
        this.c = bb;
        this.d = str;
    }

    @Override // com.inmobi.media.D9
    public final void a(Object obj) {
        String result = (String) obj;
        Intrinsics.checkNotNullParameter(result, "result");
        this.f3213a.a("file saved - " + result + " , isReporting - " + this.b);
        Z z = this.f3213a;
        Bb process = this.c;
        String beacon = this.d;
        boolean z2 = this.b;
        z.getClass();
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(process, "process");
        Intrinsics.checkNotNullParameter(beacon, "beacon");
        Unit unit = null;
        if (z2) {
            z.a(new AdQualityResult(result, null, beacon, z.k.toString()), false);
            return;
        }
        z.f.remove(process);
        AdQualityResult adQualityResult = z.i;
        if (adQualityResult != null) {
            adQualityResult.setImageLocation(result);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            z.i = new AdQualityResult(result, null, beacon, null, 8, null);
        }
        z.a("file is saved. result - " + z.i);
        z.a(true);
    }

    @Override // com.inmobi.media.D9
    public final void onError(Exception exc) {
        Z z = this.f3213a;
        Bb process = this.c;
        z.getClass();
        Intrinsics.checkNotNullParameter(process, "process");
        z.a(exc, "error in running process - ".concat("Bb"));
        z.f.remove(process);
        z.a(true);
    }
}

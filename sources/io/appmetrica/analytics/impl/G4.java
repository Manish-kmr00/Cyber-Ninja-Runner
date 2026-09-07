package io.appmetrica.analytics.impl;

import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes4.dex */
public final class G4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bl f11154a;
    public final F4 b;
    public final ResultReceiver c;

    public G4(C4007b4 c4007b4) {
        this(new Bl(c4007b4), new F4(c4007b4.b(), c4007b4.a().a()), c4007b4.a().c());
    }

    public G4(Bl bl, F4 f4, ResultReceiver resultReceiver) {
        this.f11154a = bl;
        this.b = f4;
        this.c = resultReceiver;
    }
}

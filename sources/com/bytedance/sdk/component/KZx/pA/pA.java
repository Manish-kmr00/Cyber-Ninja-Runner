package com.bytedance.sdk.component.KZx.pA;

import android.os.SystemClock;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    long JG;
    long KZx;
    long ML;
    long Og;
    long SD;
    long ZZv;
    long omh;
    long pA = SystemClock.elapsedRealtime();

    public void pA() {
        this.KZx = SystemClock.elapsedRealtime();
    }

    public void Og() {
        this.ZZv = SystemClock.elapsedRealtime();
    }

    public void KZx() {
        this.ML = SystemClock.elapsedRealtime();
    }

    public long ZZv() {
        return this.pA;
    }

    public void ML() {
        this.JG = SystemClock.elapsedRealtime();
    }

    public long JG() {
        return this.JG;
    }

    public long SD() {
        return this.KZx;
    }

    public long omh() {
        return this.ZZv;
    }

    public long Bzk() {
        return this.ML;
    }

    public long SGo() {
        return this.SD;
    }

    public void BSW() {
        this.SD = SystemClock.elapsedRealtime();
    }

    public long WV() {
        return this.omh;
    }

    public void Wx() {
        this.omh = SystemClock.elapsedRealtime();
    }

    public long Sn() {
        return this.Og;
    }

    public void DX() {
        this.Og = SystemClock.elapsedRealtime();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.pA + ", asyncCallExecTs=" + this.Og + ", requestStartExecTs=" + this.KZx + ", requestConnectStartTs=" + this.ZZv + ", requestConnectFinishTs=" + this.ML + ", reqCallServerStartTs=" + this.SD + ", reqCallServerFinishTs=" + this.omh + AbstractJsonLexerKt.END_OBJ;
    }
}

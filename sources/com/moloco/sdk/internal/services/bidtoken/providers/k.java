package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6334a;
    public final MolocoPrivacy.PrivacySettings b;
    public final p c;
    public final d d;
    public final r e;
    public final h f;
    public final com.moloco.sdk.internal.services.c g;
    public final n h;
    public final f i;
    public final a j;

    public k(boolean z, MolocoPrivacy.PrivacySettings privacySettings, p memoryInfo, d appDirInfo, r networkInfoSignal, h batteryInfoSignal, com.moloco.sdk.internal.services.c adDataSignal, n deviceSignal, f audioSignal, a accessibilitySignal) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        Intrinsics.checkNotNullParameter(appDirInfo, "appDirInfo");
        Intrinsics.checkNotNullParameter(networkInfoSignal, "networkInfoSignal");
        Intrinsics.checkNotNullParameter(batteryInfoSignal, "batteryInfoSignal");
        Intrinsics.checkNotNullParameter(adDataSignal, "adDataSignal");
        Intrinsics.checkNotNullParameter(deviceSignal, "deviceSignal");
        Intrinsics.checkNotNullParameter(audioSignal, "audioSignal");
        Intrinsics.checkNotNullParameter(accessibilitySignal, "accessibilitySignal");
        this.f6334a = z;
        this.b = privacySettings;
        this.c = memoryInfo;
        this.d = appDirInfo;
        this.e = networkInfoSignal;
        this.f = batteryInfoSignal;
        this.g = adDataSignal;
        this.h = deviceSignal;
        this.i = audioSignal;
        this.j = accessibilitySignal;
    }

    public final boolean a() {
        return this.f6334a;
    }

    public final a b() {
        return this.j;
    }

    public final MolocoPrivacy.PrivacySettings c() {
        return this.b;
    }

    public final p d() {
        return this.c;
    }

    public final d e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f6334a == kVar.f6334a && Intrinsics.areEqual(this.b, kVar.b) && Intrinsics.areEqual(this.c, kVar.c) && Intrinsics.areEqual(this.d, kVar.d) && Intrinsics.areEqual(this.e, kVar.e) && Intrinsics.areEqual(this.f, kVar.f) && Intrinsics.areEqual(this.g, kVar.g) && Intrinsics.areEqual(this.h, kVar.h) && Intrinsics.areEqual(this.i, kVar.i) && Intrinsics.areEqual(this.j, kVar.j);
    }

    public final r f() {
        return this.e;
    }

    public final h g() {
        return this.f;
    }

    public final com.moloco.sdk.internal.services.c h() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean z = this.f6334a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public final n i() {
        return this.h;
    }

    public final f j() {
        return this.i;
    }

    public final a k() {
        return this.j;
    }

    public final com.moloco.sdk.internal.services.c l() {
        return this.g;
    }

    public final d m() {
        return this.d;
    }

    public final f n() {
        return this.i;
    }

    public final h o() {
        return this.f;
    }

    public final n p() {
        return this.h;
    }

    public final p q() {
        return this.c;
    }

    public final r r() {
        return this.e;
    }

    public final MolocoPrivacy.PrivacySettings s() {
        return this.b;
    }

    public final boolean t() {
        return this.f6334a;
    }

    public String toString() {
        return "ClientSignals(sdkInitialized=" + this.f6334a + ", privacySettings=" + this.b + ", memoryInfo=" + this.c + ", appDirInfo=" + this.d + ", networkInfoSignal=" + this.e + ", batteryInfoSignal=" + this.f + ", adDataSignal=" + this.g + ", deviceSignal=" + this.h + ", audioSignal=" + this.i + ", accessibilitySignal=" + this.j + ')';
    }

    public final k a(boolean z, MolocoPrivacy.PrivacySettings privacySettings, p memoryInfo, d appDirInfo, r networkInfoSignal, h batteryInfoSignal, com.moloco.sdk.internal.services.c adDataSignal, n deviceSignal, f audioSignal, a accessibilitySignal) {
        Intrinsics.checkNotNullParameter(privacySettings, "privacySettings");
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        Intrinsics.checkNotNullParameter(appDirInfo, "appDirInfo");
        Intrinsics.checkNotNullParameter(networkInfoSignal, "networkInfoSignal");
        Intrinsics.checkNotNullParameter(batteryInfoSignal, "batteryInfoSignal");
        Intrinsics.checkNotNullParameter(adDataSignal, "adDataSignal");
        Intrinsics.checkNotNullParameter(deviceSignal, "deviceSignal");
        Intrinsics.checkNotNullParameter(audioSignal, "audioSignal");
        Intrinsics.checkNotNullParameter(accessibilitySignal, "accessibilitySignal");
        return new k(z, privacySettings, memoryInfo, appDirInfo, networkInfoSignal, batteryInfoSignal, adDataSignal, deviceSignal, audioSignal, accessibilitySignal);
    }
}

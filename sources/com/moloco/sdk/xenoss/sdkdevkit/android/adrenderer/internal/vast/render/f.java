package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {
    public static final int h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r f7071a;
    public final File b;
    public final Integer c;
    public final String d;
    public final String e;
    public final h f;
    public final e g;

    public f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r rVar, File localMediaResource, Integer num, String networkMediaResource, String str, h tracking, e eVar) {
        Intrinsics.checkNotNullParameter(localMediaResource, "localMediaResource");
        Intrinsics.checkNotNullParameter(networkMediaResource, "networkMediaResource");
        Intrinsics.checkNotNullParameter(tracking, "tracking");
        this.f7071a = rVar;
        this.b = localMediaResource;
        this.c = num;
        this.d = networkMediaResource;
        this.e = str;
        this.f = tracking;
        this.g = eVar;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r a() {
        return this.f7071a;
    }

    public final File b() {
        return this.b;
    }

    public final Integer c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.f7071a, fVar.f7071a) && Intrinsics.areEqual(this.b, fVar.b) && Intrinsics.areEqual(this.c, fVar.c) && Intrinsics.areEqual(this.d, fVar.d) && Intrinsics.areEqual(this.e, fVar.e) && Intrinsics.areEqual(this.f, fVar.f) && Intrinsics.areEqual(this.g, fVar.g);
    }

    public final h f() {
        return this.f;
    }

    public final e g() {
        return this.g;
    }

    public final String h() {
        return this.e;
    }

    public int hashCode() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r rVar = this.f7071a;
        int iHashCode = (((rVar == null ? 0 : rVar.hashCode()) * 31) + this.b.hashCode()) * 31;
        Integer num = this.c;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.f.hashCode()) * 31;
        e eVar = this.g;
        return iHashCode3 + (eVar != null ? eVar.hashCode() : 0);
    }

    public final e i() {
        return this.g;
    }

    public final File j() {
        return this.b;
    }

    public final Integer k() {
        return this.c;
    }

    public final String l() {
        return this.d;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r m() {
        return this.f7071a;
    }

    public final h n() {
        return this.f;
    }

    public String toString() {
        return "Linear(skipOffset=" + this.f7071a + ", localMediaResource=" + this.b + ", localMediaResourceBitrate=" + this.c + ", networkMediaResource=" + this.d + ", clickThroughUrl=" + this.e + ", tracking=" + this.f + ", icon=" + this.g + ')';
    }

    public final f a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r rVar, File localMediaResource, Integer num, String networkMediaResource, String str, h tracking, e eVar) {
        Intrinsics.checkNotNullParameter(localMediaResource, "localMediaResource");
        Intrinsics.checkNotNullParameter(networkMediaResource, "networkMediaResource");
        Intrinsics.checkNotNullParameter(tracking, "tracking");
        return new f(rVar, localMediaResource, num, networkMediaResource, str, tracking, eVar);
    }

    public static /* synthetic */ f a(f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r rVar, File file, Integer num, String str, String str2, h hVar, e eVar, int i, Object obj) {
        if ((i & 1) != 0) {
            rVar = fVar.f7071a;
        }
        if ((i & 2) != 0) {
            file = fVar.b;
        }
        File file2 = file;
        if ((i & 4) != 0) {
            num = fVar.c;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str = fVar.d;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = fVar.e;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            hVar = fVar.f;
        }
        h hVar2 = hVar;
        if ((i & 64) != 0) {
            eVar = fVar.g;
        }
        return fVar.a(rVar, file2, num2, str3, str4, hVar2, eVar);
    }
}

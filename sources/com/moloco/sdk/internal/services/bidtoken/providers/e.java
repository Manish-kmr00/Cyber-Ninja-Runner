package com.moloco.sdk.internal.services.bidtoken.providers;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements j<d> {
    public static final a d = new a(null);
    public static final String e = "ADISignalProvider";
    public final Context b;
    public d c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context;
        this.c = new d(e());
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = new d(e());
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        d dVar = new d(e());
        boolean z = !Intrinsics.areEqual(dVar, this.c);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] ADI needsRefresh: " + z + ", with adi: " + dVar.b(), false, 4, null);
        return z;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return e;
    }

    public final Long e() {
        try {
            return Long.valueOf(this.b.getFilesDir().getTotalSpace());
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "ADI Error", e2, false, 8, null);
            return null;
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d d() {
        d dVar = this.c;
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, e, "[CBT] ADI providing " + dVar.b(), false, 4, null);
        return dVar;
    }
}

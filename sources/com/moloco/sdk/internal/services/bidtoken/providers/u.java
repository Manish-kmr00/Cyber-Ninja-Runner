package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.Moloco;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements j<Boolean> {
    public final String b = "SDKInitStateSignalProvider";
    public boolean c = Moloco.isInitialized();

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.c = Moloco.isInitialized();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        StringBuilder sb;
        StringBuilder sbAppend;
        boolean z = this.c;
        boolean zIsInitialized = Moloco.isInitialized();
        boolean z2 = z != zIsInitialized;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str = this.b;
        if (z2) {
            sb = new StringBuilder("[CBT] sdkInitialized updated from ");
            sbAppend = sb.append(z).append(" to ").append(zIsInitialized);
        } else {
            sb = new StringBuilder("[CBT] sdkInitialized didn't change (before: ");
            sbAppend = sb.append(z).append(", after: ").append(zIsInitialized).append(')');
        }
        MolocoLogger.debugBuildLog$default(molocoLogger, str, sbAppend.toString(), false, 4, null);
        return z2;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public String c() {
        return this.b;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean d() {
        return Boolean.valueOf(this.c);
    }
}

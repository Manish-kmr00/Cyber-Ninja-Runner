package com.monetization.ads.mediation.nativeads.assets.factories;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/assets/factories/DefaultMediatedSponsoredFactory;", "", "Landroid/content/Context;", "context", "", "resourceId", "", "makeSponsored", "(Landroid/content/Context;I)Ljava/lang/String;", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class DefaultMediatedSponsoredFactory {
    public final String makeSponsored(Context context, int resourceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String string = context.getString(resourceId);
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Throwable unused) {
            return "Advertisement";
        }
    }
}

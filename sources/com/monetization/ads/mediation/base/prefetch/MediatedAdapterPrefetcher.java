package com.monetization.ads.mediation.base.prefetch;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J.\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/monetization/ads/mediation/base/prefetch/MediatedAdapterPrefetcher;", "", "onInvalidate", "", "prefetchAd", "context", "Landroid/content/Context;", "extras", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/monetization/ads/mediation/base/prefetch/MediatedAdapterPrefetchListener;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedAdapterPrefetcher {
    void onInvalidate();

    void prefetchAd(Context context, Map<String, String> extras, MediatedAdapterPrefetchListener listener);
}

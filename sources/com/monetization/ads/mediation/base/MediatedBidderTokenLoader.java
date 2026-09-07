package com.monetization.ads.mediation.base;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/monetization/ads/mediation/base/MediatedBidderTokenLoader;", "", "loadBidderToken", "", "context", "Landroid/content/Context;", "extras", "", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/monetization/ads/mediation/base/MediatedBidderTokenLoadListener;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedBidderTokenLoader {
    void loadBidderToken(Context context, Map<String, String> extras, MediatedBidderTokenLoadListener listener);
}

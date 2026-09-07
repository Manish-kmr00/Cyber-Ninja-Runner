package com.monetization.ads.mediation.nativeads;

import android.content.Context;
import com.monetization.ads.mediation.base.a;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdapter;", "Lcom/monetization/ads/mediation/base/a;", "Landroid/content/Context;", "context", "Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdapterListener;", "mediatedNativeAdapterListener", "", "", "", "localExtras", "serverExtras", "", "loadAd", "(Landroid/content/Context;Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdapterListener;Ljava/util/Map;Ljava/util/Map;)V", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public abstract class MediatedNativeAdapter extends a {
    public abstract void loadAd(Context context, MediatedNativeAdapterListener mediatedNativeAdapterListener, Map<String, ? extends Object> localExtras, Map<String, String> serverExtras);
}

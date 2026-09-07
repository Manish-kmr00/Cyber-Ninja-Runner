package com.monetization.ads.mediation.appopenad;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.monetization.ads.mediation.base.MediatedAdRequestError;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\u000fJK\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/monetization/ads/mediation/appopenad/MediatedAppOpenAdAdapter;", "Lcom/monetization/ads/mediation/base/a;", "Landroid/content/Context;", "context", "Lcom/monetization/ads/mediation/appopenad/MediatedAppOpenAdAdapter$MediatedAppOpenAdAdapterListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "", "", "localExtras", "serverExtras", "", "loadAppOpenAd", "(Landroid/content/Context;Lcom/monetization/ads/mediation/appopenad/MediatedAppOpenAdAdapter$MediatedAppOpenAdAdapterListener;Ljava/util/Map;Ljava/util/Map;)V", "onInvalidate", "()V", "Landroid/app/Activity;", "activity", "showAppOpenAd", "(Landroid/app/Activity;)V", "", "isLoaded", "()Z", "<init>", "MediatedAppOpenAdAdapterListener", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public abstract class MediatedAppOpenAdAdapter extends com.monetization.ads.mediation.base.a {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/monetization/ads/mediation/appopenad/MediatedAppOpenAdAdapter$MediatedAppOpenAdAdapterListener;", "", "onAdImpression", "", "onAppOpenAdClicked", "onAppOpenAdDismissed", "onAppOpenAdFailedToLoad", "error", "Lcom/monetization/ads/mediation/base/MediatedAdRequestError;", "onAppOpenAdLeftApplication", "onAppOpenAdLoaded", "onAppOpenAdShown", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface MediatedAppOpenAdAdapterListener {
        void onAdImpression();

        void onAppOpenAdClicked();

        void onAppOpenAdDismissed();

        void onAppOpenAdFailedToLoad(MediatedAdRequestError error);

        void onAppOpenAdLeftApplication();

        void onAppOpenAdLoaded();

        void onAppOpenAdShown();
    }

    public abstract boolean isLoaded();

    public abstract void loadAppOpenAd(Context context, MediatedAppOpenAdAdapterListener listener, Map<String, ? extends Object> localExtras, Map<String, String> serverExtras);

    public abstract void onInvalidate();

    public abstract void showAppOpenAd(Activity activity);
}

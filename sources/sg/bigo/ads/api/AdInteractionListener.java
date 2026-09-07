package sg.bigo.ads.api;

/* JADX INFO: loaded from: classes12.dex */
public interface AdInteractionListener {
    void onAdClicked();

    void onAdClosed();

    void onAdError(AdError adError);

    void onAdImpression();

    void onAdOpened();
}

package net.pubnative.lite.sdk.models.bidstream;

import com.pubmatic.sdk.openwrap.core.POBConstants;

/* JADX INFO: loaded from: classes11.dex */
public class Impression extends Signal {

    @BidParam(name = POBConstants.KEY_CLICK_BROWSER)
    public int clickBrowser;

    @BidParam(name = POBConstants.KEY_INTERSTITIAL)
    public Integer isInterstitial;

    public Impression() {
        this.isInterstitial = 0;
        this.clickBrowser = 1;
    }

    public Impression(Integer num, int i) {
        Integer.valueOf(0);
        this.isInterstitial = num;
        this.clickBrowser = i;
    }
}

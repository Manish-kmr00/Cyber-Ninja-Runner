package sg.bigo.ads.api;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class InterstitialAdRequest extends b {
    private int h;

    public static class Builder extends c<Builder, InterstitialAdRequest> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sg.bigo.ads.api.c
        public InterstitialAdRequest createAdRequest() {
            return new InterstitialAdRequest(this.mSlotId, this.mServerBidPayload);
        }
    }

    public InterstitialAdRequest(String str, String str2) {
        super(str, str2);
        this.h = 3;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean a(int i) {
        if (i == 3) {
            this.h = 3;
            return false;
        }
        if (i != 20) {
            return true;
        }
        this.h = 20;
        return false;
    }

    @Override // sg.bigo.ads.api.b
    public final int c() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.b
    public final Map<String, Object> d() {
        return null;
    }
}

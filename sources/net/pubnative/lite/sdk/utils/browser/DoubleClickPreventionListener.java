package net.pubnative.lite.sdk.utils.browser;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DoubleClickPreventionListener implements View.OnClickListener {
    private static final long MIN_CLICK_INTERVAL_MS = 1000;
    private long lastClickTimestamp;

    protected void processClick() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastClickTimestamp < 1000) {
            return;
        }
        this.lastClickTimestamp = jCurrentTimeMillis;
        processClick();
    }
}

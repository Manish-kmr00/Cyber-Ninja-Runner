package com.smaato.sdk.core.browser;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public abstract class DoubleClickPreventionListener implements View.OnClickListener {
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

package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface IB {
    View getView();

    ArrayList<View> getViewsForInteraction();

    void unregisterView();
}

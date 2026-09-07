package io.bidmachine.rendering.measurer;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public interface HtmlMeasurer extends Measurer<WebView> {
    String prepareCreativeForMeasure(String html);
}

package com.smaato.sdk.richmedia.mraid;

import android.content.Context;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.richmedia.util.RichMediaHtmlUtils;
import com.smaato.sdk.richmedia.widget.RichMediaWebView;

/* JADX INFO: loaded from: classes13.dex */
public class RichMediaWebViewFactory {
    private final RichMediaHtmlUtils htmlUtils;
    private final Logger logger;

    public RichMediaWebViewFactory(Logger logger, RichMediaHtmlUtils richMediaHtmlUtils) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.htmlUtils = (RichMediaHtmlUtils) Objects.requireNonNull(richMediaHtmlUtils);
    }

    public RichMediaWebView create(Context context) {
        return new RichMediaWebView(context, this.logger, this.htmlUtils);
    }

    public RichMediaWebView create(Context context, boolean z) {
        return new RichMediaWebView(context, this.logger, this.htmlUtils, z);
    }
}

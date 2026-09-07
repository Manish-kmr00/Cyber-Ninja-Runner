package com.smaato.sdk.core.datacollector;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Supplier;

/* JADX INFO: loaded from: classes2.dex */
class UserAgentProvider implements Supplier<String> {
    private final Context context;

    UserAgentProvider(Context context) {
        this.context = (Context) Objects.requireNonNull(context);
    }

    @Override // com.smaato.sdk.core.util.fi.Supplier
    public String get() {
        String defaultUserAgent = null;
        try {
            defaultUserAgent = WebSettings.getDefaultUserAgent(this.context);
            if (defaultUserAgent == null) {
                defaultUserAgent = System.getProperty("http.agent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultUserAgent == null ? "" : defaultUserAgent;
    }

    /* JADX INFO: renamed from: lambda$get$0$com-smaato-sdk-core-datacollector-UserAgentProvider, reason: not valid java name */
    /* synthetic */ String m5522lambda$get$0$comsmaatosdkcoredatacollectorUserAgentProvider() {
        return new WebView(this.context).getSettings().getUserAgentString();
    }
}

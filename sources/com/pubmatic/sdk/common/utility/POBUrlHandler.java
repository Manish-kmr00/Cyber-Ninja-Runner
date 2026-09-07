package com.pubmatic.sdk.common.utility;

import android.content.Context;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.browser.POBInternalBrowserActivity;
import com.pubmatic.sdk.common.log.POBLog;

/* JADX INFO: loaded from: classes7.dex */
public class POBUrlHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UrlHandlerListener f7645a;
    private final Context b;
    private boolean c = false;

    public interface UrlHandlerListener {
        void onErrorOpenUrl(String str);

        void onInternalBrowserClose(String str);

        void onInternalBrowserOpen(String str);

        void onLeaveApp(String str);
    }

    class a implements POBInternalBrowserActivity.InternalBrowserListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7646a;

        a(String str) {
            this.f7646a = str;
        }

        @Override // com.pubmatic.sdk.common.browser.POBInternalBrowserActivity.InternalBrowserListener
        public void onBrowserDismiss() {
            POBLog.debug("POBUrlHandler", "Dismissed device default browser. url :%s", this.f7646a);
            POBUrlHandler.this.f7645a.onInternalBrowserClose(this.f7646a);
            POBUrlHandler.this.c = false;
        }

        @Override // com.pubmatic.sdk.common.browser.POBInternalBrowserActivity.InternalBrowserListener
        public void onBrowserStart() {
            POBUrlHandler.this.f7645a.onInternalBrowserOpen(this.f7646a);
        }

        @Override // com.pubmatic.sdk.common.browser.POBInternalBrowserActivity.InternalBrowserListener
        public void onExternalBrowserClick(String str) {
            POBLog.debug("POBUrlHandler", "Opening current page in device's default browser. url :%s", str);
            if (POBUtils.openExternalBrowser(POBUrlHandler.this.b, str)) {
                POBUrlHandler.this.f7645a.onLeaveApp(str);
            } else {
                POBUrlHandler.this.f7645a.onErrorOpenUrl(str);
                POBLog.warn("POBUrlHandler", "Unable to open url in external browser from internal browser %s", str);
            }
        }
    }

    public POBUrlHandler(Context context, UrlHandlerListener urlHandlerListener) {
        this.b = context;
        this.f7645a = urlHandlerListener;
    }

    public void open(String str, String str2) {
        if (!POBUtils.isStringValueNullOrEmpty(str)) {
            POBLog.debug("POBUrlHandler", "Opening landing page with url: %s", str);
            open(str);
        } else {
            if (!POBUtils.isStringValueNullOrEmpty(str2)) {
                POBLog.debug("POBUrlHandler", "Opening landing page with url: %s", str);
                open(str2);
                return;
            }
            POBLog.debug("POBUrlHandler", "Failed to open url: " + str, new Object[0]);
            UrlHandlerListener urlHandlerListener = this.f7645a;
            if (str == null) {
                str = "";
            }
            urlHandlerListener.onErrorOpenUrl(str);
        }
    }

    public void open(String str) {
        String strDecodeUrl = POBUtils.decodeUrl(str);
        if (strDecodeUrl == null) {
            this.f7645a.onErrorOpenUrl(str);
            return;
        }
        if (POBDeepLinkUtil.validateAndRedirect(this.b, strDecodeUrl)) {
            POBLog.debug("POBUrlHandler", "Deep link success", new Object[0]);
            this.f7645a.onLeaveApp(strDecodeUrl);
            return;
        }
        if (POBInstanceProvider.getSdkConfig().isUseInternalBrowser()) {
            if (!this.c) {
                this.c = true;
                POBInternalBrowserActivity.startNewActivity(this.b, strDecodeUrl, new a(strDecodeUrl));
                return;
            } else {
                POBLog.warn("POBUrlHandler", "Internal browser already displayed", new Object[0]);
                return;
            }
        }
        if (POBUtils.openExternalBrowser(this.b, strDecodeUrl)) {
            this.f7645a.onLeaveApp(strDecodeUrl);
        } else {
            POBLog.warn("POBUrlHandler", "Unable to open url in external browser %s", strDecodeUrl);
            this.f7645a.onErrorOpenUrl(strDecodeUrl);
        }
    }
}

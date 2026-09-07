package com.smaato.sdk.core.browser;

import android.app.Application;
import android.content.ClipboardManager;
import android.webkit.CookieManager;
import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.di.DiRegistry;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.DiLogLayer;
import com.smaato.sdk.core.network.UrlCreator;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.DiWebViewLayer;

/* JADX INFO: loaded from: classes12.dex */
public final class DiBrowserLayer {
    public static DiRegistry createRegistry() {
        return DiRegistry.of(new Consumer() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                DiBrowserLayer.lambda$createRegistry$6((DiRegistry) obj);
            }
        });
    }

    static /* synthetic */ void lambda$createRegistry$6(DiRegistry diRegistry) {
        diRegistry.registerFactory(CookieSyncManagerHolder.class, new ClassFactory() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiBrowserLayer.lambda$createRegistry$0(diConstructor);
            }
        });
        diRegistry.registerFactory(ClipboardManager.class, new ClassFactory() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiBrowserLayer.lambda$createRegistry$1(diConstructor);
            }
        });
        diRegistry.registerFactory(CookieManager.class, new ClassFactory() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return CookieManager.getInstance();
            }
        });
        diRegistry.registerFactory(SmaatoCookieManager.class, new ClassFactory() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiBrowserLayer.lambda$createRegistry$3(diConstructor);
            }
        });
        diRegistry.registerFactory(BrowserModel.class, new ClassFactory() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiBrowserLayer.lambda$createRegistry$4(diConstructor);
            }
        });
        diRegistry.registerFactory(BrowserPresenter.class, new ClassFactory() { // from class: com.smaato.sdk.core.browser.DiBrowserLayer$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.di.ClassFactory
            /* JADX INFO: renamed from: get */
            public final Object get2(DiConstructor diConstructor) {
                return DiBrowserLayer.lambda$createRegistry$5(diConstructor);
            }
        });
    }

    static /* synthetic */ CookieSyncManagerHolder lambda$createRegistry$0(DiConstructor diConstructor) {
        return new CookieSyncManagerHolder((Application) diConstructor.get(Application.class));
    }

    static /* synthetic */ ClipboardManager lambda$createRegistry$1(DiConstructor diConstructor) {
        return (ClipboardManager) Objects.requireNonNull((ClipboardManager) ((Application) diConstructor.get(Application.class)).getSystemService("clipboard"));
    }

    static /* synthetic */ SmaatoCookieManager lambda$createRegistry$3(DiConstructor diConstructor) {
        return new SmaatoCookieManager((CookieManager) diConstructor.get(CookieManager.class), (CookieSyncManagerHolder) diConstructor.get(CookieSyncManagerHolder.class));
    }

    static /* synthetic */ BrowserModel lambda$createRegistry$4(DiConstructor diConstructor) {
        return new BrowserModel(DiLogLayer.getLoggerFrom(diConstructor), DiWebViewLayer.getBaseWebViewClientFrom(diConstructor), DiWebViewLayer.getBaseWebChromeClientFrom(diConstructor), (SmaatoCookieManager) diConstructor.get(SmaatoCookieManager.class));
    }

    static /* synthetic */ BrowserPresenter lambda$createRegistry$5(DiConstructor diConstructor) {
        return new BrowserPresenter(DiLogLayer.getLoggerFrom(diConstructor), (BrowserModel) diConstructor.get(BrowserModel.class), (UrlCreator) diConstructor.get(UrlCreator.class), (LinkHandler) diConstructor.get(LinkHandler.class), (ClipboardManager) diConstructor.get(ClipboardManager.class));
    }
}

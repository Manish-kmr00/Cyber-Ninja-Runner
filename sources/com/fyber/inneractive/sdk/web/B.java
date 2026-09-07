package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;

/* JADX INFO: loaded from: classes13.dex */
public interface B extends k0 {
    void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError);

    void a(boolean z, Orientation orientation);

    boolean a(String str);

    void b();

    void b(boolean z);

    void c();

    void d();

    void onClose();
}

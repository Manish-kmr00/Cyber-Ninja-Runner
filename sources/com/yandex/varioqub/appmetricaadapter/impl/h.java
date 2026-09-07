package com.yandex.varioqub.appmetricaadapter.impl;

import com.yandex.metrica.IIdentifierCallback;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class h implements IIdentifierCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdapterIdentifiersCallback f10906a;

    public h(AdapterIdentifiersCallback adapterIdentifiersCallback) {
        this.f10906a = adapterIdentifiersCallback;
    }

    public final void onReceive(Map map) {
        AdapterIdentifiersCallback adapterIdentifiersCallback = this.f10906a;
        String str = (String) map.get("yandex_mobile_metrica_uuid");
        if (str == null) {
            str = "";
        }
        adapterIdentifiersCallback.onSuccess(str);
    }

    public final void onRequestError(IIdentifierCallback.Reason reason) {
        this.f10906a.onError(reason.toString());
    }
}

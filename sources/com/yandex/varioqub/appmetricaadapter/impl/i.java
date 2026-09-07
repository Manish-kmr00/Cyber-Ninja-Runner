package com.yandex.varioqub.appmetricaadapter.impl;

import android.content.Context;
import com.yandex.metrica.ModulesFacade;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.p;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements d {
    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(Context context, String str) {
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void b(Context context, AdapterIdentifiersCallback adapterIdentifiersCallback) {
        p.a(context, new h(adapterIdentifiersCallback), new String[]{"yandex_mobile_metrica_uuid"});
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(Context context, AdapterIdentifiersCallback adapterIdentifiersCallback) {
        p.a(context, new g(adapterIdentifiersCallback), new String[]{"yandex_mobile_metrica_device_id"});
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(byte[] bArr) {
        ModulesFacade.setSessionExtra("varioqub", bArr);
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(LinkedHashMap linkedHashMap) {
        YandexMetrica.reportEvent("com.yandex.varioqub.activate_config", linkedHashMap);
    }
}

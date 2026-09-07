package com.yandex.mobile.ads.appopenad;

import android.app.Activity;
import com.json.m5;
import com.yandex.mobile.ads.common.AdInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/yandex/mobile/ads/appopenad/AppOpenAd;", "", "info", "Lcom/yandex/mobile/ads/common/AdInfo;", "getInfo", "()Lcom/yandex/mobile/ads/common/AdInfo;", "setAdEventListener", "", "appOpenAdEventListener", "Lcom/yandex/mobile/ads/appopenad/AppOpenAdEventListener;", m5.v, "activity", "Landroid/app/Activity;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AppOpenAd {
    AdInfo getInfo();

    void setAdEventListener(AppOpenAdEventListener appOpenAdEventListener);

    void show(Activity activity);
}

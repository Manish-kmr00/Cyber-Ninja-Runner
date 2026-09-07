package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.re, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4415re extends Jc {
    public C4415re() {
        super(EnumC4490ue.UNDEFINED);
        a(1, EnumC4490ue.WIFI);
        a(0, EnumC4490ue.CELL);
        a(3, EnumC4490ue.ETHERNET);
        a(2, EnumC4490ue.BLUETOOTH);
        a(4, EnumC4490ue.VPN);
        if (AndroidUtils.isApiAchieved(27)) {
            a(6, EnumC4490ue.LOWPAN);
        }
        if (AndroidUtils.isApiAchieved(26)) {
            a(5, EnumC4490ue.WIFI_AWARE);
        }
    }
}

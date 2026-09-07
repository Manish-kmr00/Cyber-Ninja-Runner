package com.fyber.inneractive.sdk.video;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.cache.m;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.EnumC3259x;
import com.fyber.inneractive.sdk.util.InterfaceC3258w;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements InterfaceC3258w {
    @Override // com.fyber.inneractive.sdk.util.InterfaceC3258w
    public final boolean a() {
        return TextUtils.equals("vid_cache", "vid_cache") && m.f.c && AbstractC3255t.a();
    }

    @Override // com.fyber.inneractive.sdk.util.InterfaceC3258w
    public final EnumC3259x getType() {
        return EnumC3259x.Video;
    }
}

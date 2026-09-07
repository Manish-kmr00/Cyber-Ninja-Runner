package com.iab.omid.library.ogury.internal;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class b extends d {
    private static b d = new b();

    private b() {
    }

    public static b g() {
        return d;
    }

    @Override // com.iab.omid.library.ogury.internal.d
    public void b(boolean z) {
        Iterator<com.iab.omid.library.ogury.adsession.a> it = c.c().b().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(z);
        }
    }

    @Override // com.iab.omid.library.ogury.internal.d
    public boolean d() {
        Iterator<com.iab.omid.library.ogury.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            View viewC = it.next().c();
            if (viewC != null && viewC.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}

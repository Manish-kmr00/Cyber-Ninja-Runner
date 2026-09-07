package com.fyber.inneractive.sdk.mraid;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import com.fyber.inneractive.sdk.web.k0;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class r extends AbstractC3122e {
    public r(LinkedHashMap linkedHashMap, I i, h0 h0Var) {
        super(linkedHashMap, i, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3123f
    public final void a() {
        String str = (String) this.b.get("uri");
        if (TextUtils.isEmpty(str)) {
            this.c.a(k.PLAY_VIDEO, "Video can't be played with null or empty URL");
            return;
        }
        k0 k0Var = ((IAmraidWebViewController) this.c).g;
        if (k0Var != null) {
            ((com.fyber.inneractive.sdk.web.B) k0Var).a(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.AbstractC3122e
    public final String c() {
        return (String) this.b.get("uri");
    }
}

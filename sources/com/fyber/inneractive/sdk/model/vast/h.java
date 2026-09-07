package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f1879a;
    public Integer b;
    public String c;
    public l d;
    public String e;
    public String f;
    public String g;
    public com.fyber.inneractive.sdk.flow.vast.b i;
    public final ArrayList h = new ArrayList();
    public final ArrayList j = new ArrayList();

    public final boolean a() {
        return (TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.e) && this.d == null) ? false : true;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("Companion:  w:").append(this.f1879a).append(" h:").append(this.b).append(" ctr:").append(this.g).append(" clt:").append(this.h);
        if (!TextUtils.isEmpty(this.f)) {
            sbAppend.append(" html:").append(this.f);
        }
        if (this.d != null) {
            sbAppend.append(" static:").append(this.d.b).append("creative:").append(this.d.f1881a);
        }
        if (!TextUtils.isEmpty(this.e)) {
            sbAppend.append(" iframe:").append(this.e);
        }
        sbAppend.append(" events:").append(this.j);
        if (this.i != null) {
            sbAppend.append(" reason:").append(this.i.f1835a);
        }
        return sbAppend.toString();
    }
}

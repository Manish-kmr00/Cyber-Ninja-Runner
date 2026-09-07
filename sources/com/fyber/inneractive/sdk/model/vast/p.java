package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.y0;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes12.dex */
public final class p extends g {
    public static p c(Node node) {
        p pVar = new p();
        super.b(node);
        y0.a(y0.d(node, "AdTitle"));
        y0.a(y0.d(node, "Description"));
        return pVar;
    }
}

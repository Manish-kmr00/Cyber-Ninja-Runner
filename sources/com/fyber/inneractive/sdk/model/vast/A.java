package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.y0;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes12.dex */
public final class A extends g {
    public String i;

    public A() {
        this.f = 1;
    }

    public static A c(Node node) {
        A a2 = new A();
        super.b(node);
        a2.i = y0.a(y0.d(node, "VASTAdTagURI"));
        return a2;
    }
}

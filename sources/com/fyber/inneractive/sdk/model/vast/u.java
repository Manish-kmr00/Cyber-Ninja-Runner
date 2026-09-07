package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.y0;
import java.util.ArrayList;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes12.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1887a;
    public ArrayList b;

    public static u a(Node node) {
        f fVar;
        u uVar = new u();
        uVar.f1887a = y0.b(node, "version");
        ArrayList<Node> arrayListC = y0.c(node, "Ad");
        if (!arrayListC.isEmpty()) {
            uVar.b = new ArrayList();
            for (Node node2 : arrayListC) {
                if (node2 == null) {
                    fVar = null;
                } else {
                    f fVar2 = new f();
                    fVar2.f1877a = y0.b(node2, "id");
                    Node nodeD = y0.d(node2, "Wrapper");
                    if (nodeD != null) {
                        fVar2.b = A.c(nodeD);
                    }
                    Node nodeD2 = y0.d(node2, "InLine");
                    if (nodeD2 != null) {
                        fVar2.c = p.c(nodeD2);
                    }
                    fVar = fVar2;
                }
                uVar.b.add(fVar);
            }
        }
        return uVar;
    }

    public final String toString() {
        return new StringBuilder("Vast: version - " + this.f1887a + "\nAds: ").toString();
    }
}

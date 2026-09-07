package sg.bigo.ads.core.f.a.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements sg.bigo.ads.core.f.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Node f13579a;
    private List<sg.bigo.ads.core.f.a.a.d> b;

    public b(Node node) {
        this.f13579a = node;
    }

    @Override // sg.bigo.ads.core.f.a.a.b
    public final List<sg.bigo.ads.core.f.a.a.d> a() {
        if (this.b == null) {
            this.b = new ArrayList();
            Iterator<Node> it = sg.bigo.ads.core.f.a.c(this.f13579a, "Companion").iterator();
            while (it.hasNext()) {
                this.b.add(new d(it.next()));
            }
        }
        return this.b;
    }
}

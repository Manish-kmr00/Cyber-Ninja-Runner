package sg.bigo.ads.core.f.a.a.a;

import android.text.TextUtils;
import com.smaato.sdk.video.vast.model.AdParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.w3c.dom.Node;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements sg.bigo.ads.core.f.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Node f13581a;
    private final String b;
    private final int c;
    private final int d;
    private String g;
    private sg.bigo.ads.core.f.a.a.a h;
    private String i;
    private final List<sg.bigo.ads.core.f.a.a.g> e = new ArrayList();
    private final List<String> f = new ArrayList();
    private final List<sg.bigo.ads.core.f.a.a.c> j = new ArrayList();

    public d(Node node) {
        this.f13581a = node;
        this.b = sg.bigo.ads.core.f.a.e(node, "id");
        this.c = sg.bigo.ads.core.f.a.d(node, "width").intValue();
        this.d = sg.bigo.ads.core.f.a.d(node, "height").intValue();
        g();
    }

    private void g() {
        List<Node> listB = sg.bigo.ads.core.f.a.b(this.f13581a, "StaticResource", null, null);
        if (!k.a((Collection) listB)) {
            for (Node node : listB) {
                this.e.add(new g(sg.bigo.ads.core.f.a.e(node, "creativeType"), sg.bigo.ads.core.f.a.a(node)));
            }
        }
        List<Node> listB2 = sg.bigo.ads.core.f.a.b(this.f13581a, "IFrameResource", null, null);
        if (!k.a((Collection) listB2)) {
            Iterator<Node> it = listB2.iterator();
            while (it.hasNext()) {
                this.e.add(new f(sg.bigo.ads.core.f.a.b(it.next())));
            }
        }
        List<Node> listB3 = sg.bigo.ads.core.f.a.b(this.f13581a, "HTMLResource", null, null);
        if (!k.a((Collection) listB3)) {
            Iterator<Node> it2 = listB3.iterator();
            while (it2.hasNext()) {
                this.e.add(new e(sg.bigo.ads.core.f.a.b(it2.next())));
            }
        }
        Node nodeA = sg.bigo.ads.core.f.a.a(this.f13581a, "AltText", null, null);
        if (nodeA != null) {
            this.g = sg.bigo.ads.core.f.a.b(nodeA);
        }
        Node nodeA2 = sg.bigo.ads.core.f.a.a(this.f13581a, "AdParameters", null, null);
        if (nodeA2 != null) {
            this.h = new a(TextUtils.equals(sg.bigo.ads.core.f.a.e(nodeA2, AdParameters.XML_ENCODED), "true"), sg.bigo.ads.core.f.a.b(nodeA2));
        }
        Node nodeA3 = sg.bigo.ads.core.f.a.a(this.f13581a, "CompanionClickThrough", null, null);
        if (nodeA3 != null) {
            this.i = sg.bigo.ads.core.f.a.a(nodeA3);
        }
        List<Node> listB4 = sg.bigo.ads.core.f.a.b(this.f13581a, "CompanionClickTracking", null, null);
        if (!k.a((Collection) listB4)) {
            for (Node node2 : listB4) {
                this.j.add(new c(sg.bigo.ads.core.f.a.e(node2, "id"), sg.bigo.ads.core.f.a.a(node2)));
            }
        }
        Node nodeA4 = sg.bigo.ads.core.f.a.a(this.f13581a, "TrackingEvents", null, null);
        if (nodeA4 != null) {
            List<Node> listB5 = sg.bigo.ads.core.f.a.b(nodeA4, "Tracking", "event", Arrays.asList(EventConstants.CREATIVE_VIEW));
            if (k.a((Collection) listB5)) {
                return;
            }
            Iterator<Node> it3 = listB5.iterator();
            while (it3.hasNext()) {
                String strA = sg.bigo.ads.core.f.a.a(it3.next());
                if (!TextUtils.isEmpty(strA)) {
                    this.f.add(strA);
                }
            }
        }
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final int a() {
        return this.c;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final int b() {
        return this.d;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final List<sg.bigo.ads.core.f.a.a.g> c() {
        return this.e;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final String d() {
        return this.i;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final List<sg.bigo.ads.core.f.a.a.c> e() {
        return this.j;
    }

    @Override // sg.bigo.ads.core.f.a.a.d
    public final List<String> f() {
        return this.f;
    }
}

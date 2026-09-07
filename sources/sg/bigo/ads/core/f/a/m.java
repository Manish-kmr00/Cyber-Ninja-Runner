package sg.bigo.ads.core.f.a;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes13.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Document f13597a;

    public final List<d> a() {
        ArrayList arrayList = new ArrayList();
        Document document = this.f13597a;
        if (document == null) {
            return arrayList;
        }
        NodeList elementsByTagName = document.getElementsByTagName("Ad");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            arrayList.add(new d(elementsByTagName.item(i)));
        }
        return arrayList;
    }
}

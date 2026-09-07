package com.bykv.vk.openvk.preload.geckox.a.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FIFOCachePolicy.java */
/* JADX INFO: loaded from: classes8.dex */
final class e extends b {
    e() {
    }

    @Override // com.bykv.vk.openvk.preload.geckox.a.a.b
    public final void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.a.a.b
    public final void a() {
        Iterator<String> it = this.e.iterator();
        while (it.hasNext()) {
            List<File> listB = com.bykv.vk.openvk.preload.geckox.utils.b.b(new File(this.d, it.next()));
            if (listB != null && listB.size() > this.c.f913a) {
                Iterator<File> it2 = listB.subList(0, listB.size() - this.c.f913a).iterator();
                while (it2.hasNext()) {
                    com.bykv.vk.openvk.preload.geckox.a.c.b(it2.next().getAbsolutePath());
                }
            }
        }
    }
}

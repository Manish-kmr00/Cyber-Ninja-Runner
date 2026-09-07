package com.bykv.vk.openvk.preload.geckox.g;

import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.b.h;
import com.bykv.vk.openvk.preload.b.l;
import com.bykv.vk.openvk.preload.geckox.d.c;
import com.bykv.vk.openvk.preload.geckox.d.e;
import com.bykv.vk.openvk.preload.geckox.d.f;
import com.bykv.vk.openvk.preload.geckox.d.g;
import com.bykv.vk.openvk.preload.geckox.d.i;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.yandex.div.core.DivActionHandler;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GeckoPipeline.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f939a;

    public static b<Object> a(File file, com.bykv.vk.openvk.preload.geckox.b bVar, com.bykv.vk.openvk.preload.falconx.a.a aVar, Map<String, List<CheckRequestBodyModel.TargetChannel>> map, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(e.class).a(file, bVar.d()).a(aVar.a(e.class)).b());
        com.bykv.vk.openvk.preload.geckox.e.a.a aVar2 = null;
        arrayList.add(h.a.a().a(c.class).a(bVar, null, map, null, str).a(new com.bykv.vk.openvk.preload.b.b.b(new com.bykv.vk.openvk.preload.b.b.a(aVar2, bVar) { // from class: com.bykv.vk.openvk.preload.geckox.g.a.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.e.a.a f944a = null;
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.b b;

            {
                this.b = bVar;
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                List<UpdatePackage> list = (List) bVar2.b(c.class);
                bVar2.a(c.class);
                HashMap map2 = new HashMap();
                for (UpdatePackage updatePackage : list) {
                    String accessKey = updatePackage.getAccessKey();
                    List arrayList2 = (List) map2.get(accessKey);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(updatePackage);
                    map2.put(accessKey, arrayList2);
                }
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                bVar2.a(c.class);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        }, aVar.a(c.class))).b());
        arrayList.add(h.a.a().a(f.class).a(com.bykv.vk.openvk.preload.geckox.b.g()).a(new com.bykv.vk.openvk.preload.b.b.a(aVar2, bVar) { // from class: com.bykv.vk.openvk.preload.geckox.g.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.e.a.a f940a = null;
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.b b;

            {
                this.b = bVar;
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                if (this.f940a != null) {
                    ((UpdatePackage) bVar2.b(f.class)).getChannel();
                }
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(b<T> bVar2, d dVar) {
                super.c(bVar2, dVar);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onPipelineEnd", "");
                } catch (Throwable unused) {
                }
            }
        }).b());
        l.b bVar2 = new l.b();
        l.a aVarA = bVar2.a("branch_zip");
        l.b bVar3 = new l.b();
        l.a aVarA2 = bVar3.a(DivActionHandler.DivActionReason.PATCH);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.h.class).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.c.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.c.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.b.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.b.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.d.class).a(bVar).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.d.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.a.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.f.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.b.f.class))).b());
        arrayList2.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.b.e.class).a(new com.bykv.vk.openvk.preload.b.b.b(null)).b());
        aVarA2.a(arrayList2);
        l.a aVarA3 = bVar3.a("full");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(h.a.a().a(g.class).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.b.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.a.b.class))).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.a.a.class))).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.d.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.b.a.d.class))).b());
        arrayList3.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.b.a.c.class).a(new com.bykv.vk.openvk.preload.b.b.b(null)).b());
        aVarA3.a(arrayList3);
        aVarA.a(bVar3.a(com.bykv.vk.openvk.preload.geckox.d.b.class)).a(h.a.a().a(com.bykv.vk.openvk.preload.b.f.class).a(a(bVar)).b());
        l.a aVarA4 = bVar2.a("branch_single_file");
        l.b bVar4 = new l.b();
        l.a aVarA5 = bVar4.a(DivActionHandler.DivActionReason.PATCH);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.h.class).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.c.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.c.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.b.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.b.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.d.class).a(bVar).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.d.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.a.class))).b());
        arrayList4.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.b.e.class).a(new com.bykv.vk.openvk.preload.b.b.b(null, aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.b.e.class))).b());
        aVarA5.a(arrayList4);
        l.a aVarA6 = bVar4.a("full");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(h.a.a().a(g.class).b());
        arrayList5.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.a.b.class).a(bVar, file).a(new com.bykv.vk.openvk.preload.b.b.b(b(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.a.b.class))).b());
        arrayList5.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.a.a.class).a(new com.bykv.vk.openvk.preload.b.b.b(a(null, bVar), aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.a.a.class))).b());
        arrayList5.add(h.a.a().a(com.bykv.vk.openvk.preload.geckox.d.a.a.c.class).a(new com.bykv.vk.openvk.preload.b.b.b(null, aVar.a(com.bykv.vk.openvk.preload.geckox.d.a.a.c.class))).b());
        aVarA6.a(arrayList5);
        aVarA4.a(bVar4.a(com.bykv.vk.openvk.preload.geckox.d.b.class)).a(h.a.a().a(com.bykv.vk.openvk.preload.b.f.class).a(a(bVar)).b());
        l.a aVarA7 = bVar2.a("branch_myarchive_file");
        l.b bVar5 = new l.b();
        bVar5.a(DivActionHandler.DivActionReason.PATCH).a(Collections.emptyList());
        bVar5.a("full").a(Collections.emptyList());
        aVarA7.a(bVar5.a(com.bykv.vk.openvk.preload.geckox.d.b.class)).a(h.a.a().a(com.bykv.vk.openvk.preload.b.f.class).a(a(bVar)).b());
        arrayList.add(bVar2.a(com.bykv.vk.openvk.preload.geckox.d.a.class));
        arrayList.add(h.a.a().a(i.class).a(new com.bykv.vk.openvk.preload.b.b.a(null, bVar) { // from class: com.bykv.vk.openvk.preload.geckox.g.a.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.e.a.a f941a = null;
            private /* synthetic */ com.bykv.vk.openvk.preload.geckox.b b;

            {
                this.b = bVar;
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void c(b<T> bVar6, d dVar) {
                super.c(bVar6, dVar);
                Pair pair = (Pair) bVar6.a(i.class);
                if (this.f941a != null) {
                    Object obj = pair.first;
                    ((Long) pair.second).longValue();
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar6, d dVar, Throwable th) {
                super.a(bVar6, dVar, th);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar6, d dVar, Throwable th) {
                super.b(bVar6, dVar, th);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar6, d dVar) {
                super.a(bVar6, dVar);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar6, d dVar) {
                super.b(bVar6, dVar);
                try {
                    this.b.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }
        }).b());
        return com.bykv.vk.openvk.preload.b.c.a((List<h>) arrayList);
    }

    private static com.bykv.vk.openvk.preload.b.b.a a(com.bykv.vk.openvk.preload.geckox.e.a.a aVar, final com.bykv.vk.openvk.preload.geckox.b bVar) {
        final com.bykv.vk.openvk.preload.geckox.e.a.a aVar2 = null;
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.g.a.3
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                if (aVar2 != null) {
                    bVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a b(com.bykv.vk.openvk.preload.geckox.e.a.a aVar, final com.bykv.vk.openvk.preload.geckox.b bVar) {
        final com.bykv.vk.openvk.preload.geckox.e.a.a aVar2 = null;
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.g.a.4
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                if (aVar2 != null) {
                    bVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                if (aVar2 != null) {
                    bVar2.b(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                if (aVar2 != null) {
                    bVar2.a(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        };
    }

    private static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() { // from class: com.bykv.vk.openvk.preload.geckox.g.a.6
            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar, Throwable th) {
                super.a(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar, Throwable th) {
                super.b(bVar2, dVar, th);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void a(b<T> bVar2, d dVar) {
                super.a(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            @Override // com.bykv.vk.openvk.preload.b.b.a
            public final <T> void b(b<T> bVar2, d dVar) {
                super.b(bVar2, dVar);
                try {
                    bVar.f().put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }
        };
    }

    public a(Field field) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(field);
        this.f939a = field;
    }
}

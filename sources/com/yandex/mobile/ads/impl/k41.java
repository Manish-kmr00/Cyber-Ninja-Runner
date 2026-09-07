package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class k41 implements w71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f9377a;
    private final s71 b;
    private String c;
    private c71 d;

    /* JADX WARN: Multi-variable type inference failed */
    public k41(List<? extends ig<?>> assets, s71 nativeAdsConfiguration) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(nativeAdsConfiguration, "nativeAdsConfiguration");
        this.f9377a = assets;
        this.b = nativeAdsConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(k41 this$0, List assets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(assets, "assets");
        ArrayList<ig<?>> arrayList = new ArrayList();
        for (Object obj : assets) {
            if (((ig) obj).f()) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            for (ig<?> igVar : arrayList) {
                c71 c71Var = this$0.d;
                jg<?> jgVarA = c71Var != null ? c71Var.a(igVar) : null;
                if (jgVarA != null && jgVarA.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(k41 this$0, List assets) {
        Object next;
        ig<?> igVar;
        jg<?> jgVarA;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(assets, "assets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : assets) {
            if (((ig) obj).f()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            igVar = (ig) next;
            c71 c71Var = this$0.d;
            jgVarA = c71Var != null ? c71Var.a(igVar) : null;
            if (!(jgVarA instanceof jg)) {
                jgVarA = null;
            }
            if (jgVarA == null) {
                break;
            }
        } while (jgVarA.a(igVar.d()));
        ig igVar2 = (ig) next;
        this$0.c = igVar2 != null ? igVar2.b() : null;
        return igVar2 == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(k41 this$0, List assets) {
        Object next;
        jg<?> jgVarA;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(assets, "assets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : assets) {
            if (((ig) obj).f()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ig<?> igVar = (ig) next;
            c71 c71Var = this$0.d;
            jgVarA = c71Var != null ? c71Var.a(igVar) : null;
            if (jgVarA == null) {
                break;
            }
        } while (jgVarA.e());
        ig igVar2 = (ig) next;
        this$0.c = igVar2 != null ? igVar2.b() : null;
        return igVar2 == null;
    }

    public final boolean e() {
        return !a(new w71.a() { // from class: com.yandex.mobile.ads.impl.k41$$ExternalSyntheticLambda2
            @Override // com.yandex.mobile.ads.impl.w71.a
            public final boolean a(List list) {
                return k41.c(this.f$0, list);
            }
        });
    }

    public final boolean d() {
        return !a(new w71.a() { // from class: com.yandex.mobile.ads.impl.k41$$ExternalSyntheticLambda3
            @Override // com.yandex.mobile.ads.impl.w71.a
            public final boolean a(List list) {
                return k41.b(this.f$0, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(k41 this$0, List assets) {
        Object next;
        jg<?> jgVarA;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(assets, "assets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : assets) {
            if (((ig) obj).f()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ig<?> igVar = (ig) next;
            c71 c71Var = this$0.d;
            jgVarA = c71Var != null ? c71Var.a(igVar) : null;
            if (jgVarA == null) {
                break;
            }
        } while (jgVarA.b());
        ig igVar2 = (ig) next;
        this$0.c = igVar2 != null ? igVar2.b() : null;
        return igVar2 == null;
    }

    public boolean a(w71.a validator, List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.b.c();
        return validator.a(assets);
    }

    public final s71 b() {
        return this.b;
    }

    public final boolean c() {
        return !a(new w71.a() { // from class: com.yandex.mobile.ads.impl.k41$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.w71.a
            public final boolean a(List list) {
                return k41.a(this.f$0, list);
            }
        });
    }

    private final boolean a(w71.a aVar) {
        return this.d != null && a(aVar, this.f9377a);
    }

    @Override // com.yandex.mobile.ads.impl.w71
    public final void a(c71 c71Var) {
        this.d = c71Var;
    }

    @Override // com.yandex.mobile.ads.impl.w71
    public final jq1 a() {
        return new jq1(this.c, a(new w71.a() { // from class: com.yandex.mobile.ads.impl.k41$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.w71.a
            public final boolean a(List list) {
                return k41.d(this.f$0, list);
            }
        }));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:24:0x0043  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    @Override // com.yandex.mobile.ads.impl.w71
    public final v71 a(boolean z) {
        f92.a aVar;
        List<ig<?>> list = this.f9377a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((ig) it.next()).f() && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            if (i >= 2 && c() && !z) {
                aVar = f92.a.h;
            } else if (e()) {
                aVar = f92.a.k;
            } else if (d()) {
                aVar = f92.a.e;
            } else {
                aVar = f92.a.c;
            }
        } else if (e()) {
            aVar = f92.a.k;
        } else if (d()) {
            aVar = f92.a.e;
        } else {
            aVar = f92.a.c;
        }
        return new v71(aVar, this.c);
    }
}

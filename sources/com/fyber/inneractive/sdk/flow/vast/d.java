package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.util.AbstractC3256u;
import java.util.Comparator;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1837a;
    public final float b;

    public d(int i, int i2) {
        this.f1837a = i * i2;
        this.b = i / i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i;
        com.fyber.inneractive.sdk.model.vast.c cVar = (com.fyber.inneractive.sdk.model.vast.c) obj;
        com.fyber.inneractive.sdk.model.vast.c cVar2 = (com.fyber.inneractive.sdk.model.vast.c) obj2;
        int iA = AbstractC3256u.a(cVar.h, cVar2.h);
        if (iA != 0) {
            return iA;
        }
        com.fyber.inneractive.sdk.model.vast.i iVar = cVar.f1875a;
        com.fyber.inneractive.sdk.model.vast.i iVar2 = com.fyber.inneractive.sdk.model.vast.i.Html;
        int i2 = 3;
        if (iVar == iVar2) {
            i = 1;
        } else if (iVar == com.fyber.inneractive.sdk.model.vast.i.Iframe) {
            i = 2;
        } else {
            i = iVar == com.fyber.inneractive.sdk.model.vast.i.Static ? 3 : Integer.MAX_VALUE;
        }
        com.fyber.inneractive.sdk.model.vast.i iVar3 = cVar2.f1875a;
        if (iVar3 == iVar2) {
            i2 = 1;
        } else if (iVar3 == com.fyber.inneractive.sdk.model.vast.i.Iframe) {
            i2 = 2;
        } else if (iVar3 != com.fyber.inneractive.sdk.model.vast.i.Static) {
            i2 = Integer.MAX_VALUE;
        }
        int iA2 = AbstractC3256u.a(i, i2);
        if (iA2 != 0) {
            return iA2;
        }
        int iCompare = Float.compare(Math.abs((cVar.c / cVar.d) - this.b), Math.abs((cVar2.c / cVar2.d) - this.b));
        if (iCompare != 0) {
            return iCompare;
        }
        return AbstractC3256u.a(Math.abs((cVar.c * cVar.d) - this.f1837a), Math.abs((cVar2.c * cVar2.d) - this.f1837a));
    }
}

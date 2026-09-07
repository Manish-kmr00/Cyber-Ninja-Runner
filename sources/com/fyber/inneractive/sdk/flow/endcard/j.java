package com.fyber.inneractive.sdk.flow.endcard;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1794a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public int c = -1;

    public final b a(com.fyber.inneractive.sdk.model.vast.i iVar) {
        for (b bVar : this.b) {
            if (bVar.h() == iVar) {
                return bVar;
            }
        }
        return null;
    }
}

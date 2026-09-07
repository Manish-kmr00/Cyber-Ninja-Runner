package com.bykv.vk.openvk.preload.geckox.c;

import com.bykv.vk.openvk.preload.a.d.c;
import com.bykv.vk.openvk.preload.a.l;
import com.bykv.vk.openvk.preload.a.q;
import java.io.IOException;

/* JADX INFO: compiled from: BooleanTypeAdapter.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends q<Boolean> {
    @Override // com.bykv.vk.openvk.preload.a.q
    public final /* synthetic */ void a(c cVar, Boolean bool) throws IOException {
        Boolean bool2 = bool;
        if (bool2 == null) {
            cVar.h();
        } else {
            cVar.a(bool2);
        }
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.c.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: BooleanTypeAdapter.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f927a;

        static {
            int[] iArr = new int[com.bykv.vk.openvk.preload.a.d.b.values().length];
            f927a = iArr;
            try {
                iArr[com.bykv.vk.openvk.preload.a.d.b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f927a[com.bykv.vk.openvk.preload.a.d.b.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f927a[com.bykv.vk.openvk.preload.a.d.b.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.q
    public final /* synthetic */ Boolean a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
        int i = AnonymousClass1.f927a[bVarF.ordinal()];
        if (i == 1) {
            return Boolean.valueOf(aVar.i());
        }
        if (i == 2) {
            aVar.j();
            return null;
        }
        if (i == 3) {
            return Boolean.valueOf(aVar.m() != 0);
        }
        throw new l("Expected BOOLEAN or NUMBER but was ".concat(String.valueOf(bVarF)));
    }
}

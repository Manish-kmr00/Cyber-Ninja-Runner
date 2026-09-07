package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nm0 f8357a;
    private final zi1 b;
    private z2 c;

    public /* synthetic */ a3(nm0 nm0Var) {
        this(nm0Var, new zi1());
    }

    public a3(nm0 instreamAdPlaylistHolder, zi1 playlistAdBreaksProvider) {
        Intrinsics.checkNotNullParameter(instreamAdPlaylistHolder, "instreamAdPlaylistHolder");
        Intrinsics.checkNotNullParameter(playlistAdBreaksProvider, "playlistAdBreaksProvider");
        this.f8357a = instreamAdPlaylistHolder;
        this.b = playlistAdBreaksProvider;
    }

    public final z2 a() {
        z2 z2Var = this.c;
        if (z2Var != null) {
            return z2Var;
        }
        lm0 playlist = this.f8357a.a();
        this.b.getClass();
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        dt dtVarC = playlist.c();
        if (dtVarC != null) {
            listCreateListBuilder.add(dtVarC);
        }
        List<aj1> listA = playlist.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(((aj1) it.next()).a());
        }
        listCreateListBuilder.addAll(arrayList);
        dt dtVarB = playlist.b();
        if (dtVarB != null) {
            listCreateListBuilder.add(dtVarB);
        }
        z2 z2Var2 = new z2(CollectionsKt.build(listCreateListBuilder));
        this.c = z2Var2;
        return z2Var2;
    }
}

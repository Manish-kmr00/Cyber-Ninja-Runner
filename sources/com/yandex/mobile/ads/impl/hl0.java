package com.yandex.mobile.ads.impl;

import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes12.dex */
public final class hl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Json f9109a;
    private final tj b;

    public hl0(Json jsonSerializer, tj dataEncoder) {
        Intrinsics.checkNotNullParameter(jsonSerializer, "jsonSerializer");
        Intrinsics.checkNotNullParameter(dataEncoder, "dataEncoder");
        this.f9109a = jsonSerializer;
        this.b = dataEncoder;
    }

    public final String a(px reportData) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        Json json = this.f9109a;
        Json.INSTANCE.getSerializersModule();
        String strEncodeToString = json.encodeToString(px.Companion.serializer(), reportData);
        this.b.getClass();
        String strA = tj.a(strEncodeToString);
        if (strA == null) {
            strA = "";
        }
        List listPlus = CollectionsKt.plus((Iterable) new CharRange('A', 'Z'), (Iterable) new CharRange('a', GMTDateParser.ZONE));
        IntRange intRange = new IntRange(1, 3);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            Character ch = (Character) CollectionsKt.random(listPlus, Random.INSTANCE);
            ch.getClass();
            arrayList.add(ch);
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null) + strA;
    }
}

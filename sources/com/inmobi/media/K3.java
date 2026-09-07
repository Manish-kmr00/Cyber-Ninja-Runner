package com.inmobi.media;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class K3 extends D1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K3(String tableName, String tableSchema) {
        super(tableName, tableSchema);
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(tableSchema, "tableSchema");
    }

    public final void a(ArrayList eventIdList) {
        Intrinsics.checkNotNullParameter(eventIdList, "eventIdList");
        if (eventIdList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int size = eventIdList.size() - 1;
        for (int i = 0; i < size; i++) {
            sb.append(eventIdList.get(i)).append(StringUtils.COMMA);
        }
        sb.append(eventIdList.get(eventIdList.size() - 1));
        a("id IN (" + ((Object) sb) + ')', null);
        Intrinsics.checkNotNullExpressionValue("K3", "TAG");
    }

    public final ArrayList b(int i) {
        Intrinsics.checkNotNullExpressionValue("K3", "TAG");
        ArrayList<E1> arrayListA = D1.a(this, null, null, null, null, "ts ASC", Integer.valueOf(i), 15);
        ArrayList arrayList = new ArrayList();
        for (E1 e1 : arrayListA) {
            if (e1 != null) {
                arrayList.add(e1);
            }
        }
        return arrayList;
    }

    public final void a(long j) {
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            J5.a(contextD, "batch_processing_info").a(this.f3045a.concat("_last_batch_process"), j);
        }
    }

    public final void a(int i) {
        ArrayList<E1> arrayListA = D1.a(this, null, null, null, null, "ts ASC", Integer.valueOf(i), 15);
        ArrayList<Integer> arrayList = new ArrayList();
        for (E1 e1 : arrayListA) {
            Intrinsics.checkNotNullExpressionValue("K3", "TAG");
            arrayList.add(e1 != null ? Integer.valueOf(e1.c) : null);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : arrayList) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        a(arrayList2);
    }
}

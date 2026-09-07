package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.Struct;
import io.bidmachine.protobuf.sdk.Error;
import io.bidmachine.protobuf.sdk.Event;
import io.bidmachine.protobuf.sdk.Monitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
public final class P extends Y {
    private final String f;
    private final Struct g;
    private final List h;

    public P(String str, String str2, Struct struct, List list, p0 p0Var) {
        super(o0.Post, str, p0Var, null, 8, null);
        this.f = str2;
        this.g = struct;
        this.h = list;
    }

    @Override // io.bidmachine.analytics.internal.Y
    public byte[] b() {
        try {
            Result.Companion companion = Result.INSTANCE;
            Monitor.Builder name = Monitor.newBuilder().setName(this.f);
            List<Q> list = this.h;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Q q : list) {
                Monitor.Record.Builder timestamp = Monitor.Record.newBuilder().setFields(b0.a(q.a())).setTimestamp(b0.a(q.f()));
                q0 q0VarB = q.b();
                if (q0VarB != null) {
                    timestamp.setError(Error.newBuilder().setName(q0VarB.a()).setError(Error.Data.newBuilder().setCode(Z.a(q0VarB.c()).getNumber()).setDescription(q0VarB.b()).build()).build());
                }
                arrayList.add(timestamp.build());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                name.addRecords((Monitor.Record) it.next());
            }
            return Event.newBuilder().setMonitor(name.build()).setExtrasPrivate(this.g).build().toByteArray();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th));
            return null;
        }
    }

    @Override // io.bidmachine.analytics.internal.Y
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public P a() {
        return this;
    }

    public /* synthetic */ P(String str, String str2, Struct struct, List list, p0 p0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, struct, list, (i & 16) != 0 ? p0.g.a() : p0Var);
    }
}

package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.BytesValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Timestamp;
import io.bidmachine.protobuf.sdk.Error;
import io.bidmachine.protobuf.sdk.Event;
import io.bidmachine.protobuf.sdk.Reader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
public final class g0 extends Y {
    private final String f;
    private final Struct g;
    private final List h;
    private final a i;

    public interface a {
        BytesValue a(h0.a aVar);
    }

    public g0(String str, String str2, Struct struct, List list, a aVar, p0 p0Var) {
        super(o0.Post, str, p0Var, null, 8, null);
        this.f = str2;
        this.g = struct;
        this.h = list;
        this.i = aVar;
    }

    @Override // io.bidmachine.analytics.internal.Y
    public byte[] b() {
        Object next;
        Timestamp timestampA;
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Reader.Builder name = Reader.newBuilder().setName(this.f);
            List<h0> list = this.h;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (h0 h0Var : list) {
                Reader.Record.Builder rule = Reader.Record.newBuilder().setRule(Reader.Rule.newBuilder().setGeneralRule(Reader.Rule.GeneralRule.newBuilder().setTag(b0.a(h0Var.e().b())).setPath(b0.a(h0Var.e().a())).build()));
                q0 q0VarB = h0Var.b();
                if (q0VarB == null) {
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(rule.setRawData(this.i.a(h0Var.e())));
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
                    if (thM7907exceptionOrNullimpl != null) {
                        q0VarB = new q0(this.f, thM7907exceptionOrNullimpl instanceof FileNotFoundException ? q0.a.READER_NO_CONTENT : thM7907exceptionOrNullimpl instanceof SecurityException ? q0.a.READER_NO_ACCESS : q0.a.READER_INVALID, s0.a(thM7907exceptionOrNullimpl));
                    }
                }
                if (q0VarB != null) {
                    rule.setError(Error.newBuilder().setName(q0VarB.a()).setError(Error.Data.newBuilder().setCode(Z.a(q0VarB.c()).getNumber()).setDescription(q0VarB.b()).build()).build());
                }
                arrayList.add(rule.build());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                name.addRecords((Reader.Record) it.next());
            }
            Iterator it2 = this.h.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    long jF = ((h0) next).f();
                    do {
                        Object next2 = it2.next();
                        long jF2 = ((h0) next2).f();
                        if (jF < jF2) {
                            next = next2;
                            jF = jF2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            h0 h0Var2 = (h0) next;
            if (h0Var2 != null && (timestampA = b0.a(h0Var2.f())) != null) {
                name.setTimestamp(timestampA);
            }
            return Event.newBuilder().setReader(name.build()).setExtrasPrivate(this.g).build().toByteArray();
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }

    @Override // io.bidmachine.analytics.internal.Y
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public g0 a() {
        return this;
    }

    public /* synthetic */ g0(String str, String str2, Struct struct, List list, a aVar, p0 p0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, struct, list, aVar, (i & 32) != 0 ? p0.g.a() : p0Var);
    }
}

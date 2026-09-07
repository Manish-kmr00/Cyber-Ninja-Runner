package com.five_corp.ad.internal.http.movcache;

import android.os.Handler;
import android.os.HandlerThread;
import com.five_corp.ad.CreativeType;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.cache.o;
import com.five_corp.ad.internal.cache.x;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements com.five_corp.ad.internal.hub.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1404a;
    public final com.five_corp.ad.internal.storage.d b;
    public final com.five_corp.ad.internal.http.connection.b c;
    public final int d;
    public final com.five_corp.ad.internal.hub.a e;
    public int f;
    public ArrayList g;
    public final ArrayList h;
    public Object i = null;

    public h(com.five_corp.ad.internal.storage.d dVar, com.five_corp.ad.internal.http.connection.b bVar, com.five_corp.ad.internal.hub.a aVar) {
        HandlerThread handlerThread = new HandlerThread("MovieResourceCacheDownloadManager");
        handlerThread.start();
        this.f1404a = new Handler(handlerThread.getLooper());
        this.b = dVar;
        this.c = bVar;
        this.e = aVar;
        this.d = 2;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.f = 250000;
    }

    public static com.five_corp.ad.internal.util.f a(h hVar, com.five_corp.ad.internal.http.a aVar) {
        hVar.getClass();
        com.five_corp.ad.internal.context.l lVar = (com.five_corp.ad.internal.context.l) aVar.b.get();
        com.five_corp.ad.internal.ad.a aVar2 = lVar != null ? lVar.b : (com.five_corp.ad.internal.ad.a) aVar.f1379a.get();
        if (aVar2 == null || !aVar.a() || aVar2.f1266a != CreativeType.MOVIE || aVar2.F == 3) {
            return new com.five_corp.ad.internal.util.f(true, null, Boolean.FALSE);
        }
        s sVar = aVar2.k;
        o oVarA = hVar.b.a(sVar);
        if (oVarA.d()) {
            return new com.five_corp.ad.internal.util.f(true, null, Boolean.FALSE);
        }
        com.five_corp.ad.internal.util.f fVarB = oVarA.b();
        if (fVarB.f1560a) {
            return (!aVar2.a() || ((long) ((Integer) fVarB.c).intValue()) < aVar2.g.b) ? hVar.a(sVar, oVarA, new j(aVar)) : new com.five_corp.ad.internal.util.f(true, null, Boolean.FALSE);
        }
        return new com.five_corp.ad.internal.util.f(false, fVarB.b, null);
    }

    public final void b() {
        for (m mVar : this.g) {
            synchronized (mVar.g) {
                if (mVar.m == 5) {
                    mVar.m = 1;
                    mVar.q++;
                }
            }
        }
    }

    public final void c() {
        ArrayList arrayList = new ArrayList();
        for (m mVar : this.g) {
            if (mVar.h()) {
                arrayList.add(mVar);
            }
        }
        this.g = arrayList;
        while (this.h.size() < this.d) {
            m mVar2 = null;
            for (m mVar3 : this.g) {
                if (mVar3.i()) {
                    if (mVar2 != null) {
                        if (com.five_corp.ad.internal.http.b.a(mVar3.f()) - com.five_corp.ad.internal.http.b.a(mVar2.f()) > 0) {
                        }
                    }
                    mVar2 = mVar3;
                }
            }
            if (mVar2 == null) {
                break;
            }
            synchronized (mVar2.g) {
                if (mVar2.m == 1) {
                    int i = mVar2.k;
                    boolean z = mVar2.p;
                    com.five_corp.ad.internal.http.client.a aVar = new com.five_corp.ad.internal.http.client.a(mVar2.f1408a, mVar2, mVar2.c);
                    synchronized (mVar2.g) {
                        mVar2.m = 2;
                        mVar2.h = aVar;
                    }
                    aVar.b(i, z ? 0 : mVar2.e);
                    this.h.add(mVar2);
                }
            }
        }
        if (this.h.isEmpty()) {
            a();
        }
    }

    public static void a(h hVar) {
        hVar.i = null;
        for (m mVar : hVar.g) {
            if (mVar.f() == 3 && mVar.h() && mVar.i()) {
                for (m mVar2 : hVar.h) {
                    if (mVar2.f() != 3) {
                        synchronized (mVar2.g) {
                            if (mVar2.m == 2) {
                                mVar2.h.a();
                            }
                        }
                    }
                }
                break;
            }
        }
        hVar.b();
        hVar.c();
    }

    @Override // com.five_corp.ad.internal.hub.c
    public final void a(x xVar) {
        this.f = xVar.b.d;
    }

    public final void a() {
        boolean z;
        long jMin = Long.MAX_VALUE;
        for (m mVar : this.g) {
            if (mVar.h()) {
                synchronized (mVar.g) {
                    z = mVar.m == 5;
                }
                if (z) {
                    jMin = Math.min(jMin, mVar.e());
                }
            }
        }
        if (jMin != Long.MAX_VALUE) {
            Object obj = new Object();
            this.i = obj;
            this.f1404a.postDelayed(new g(this, obj), jMin);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v0 ??, still in use, count: 1, list:
          (r10v0 ?? I:java.lang.Object) from 0x0056: INVOKE (r12v13 ?? I:java.util.ArrayList), (r10v0 ?? I:java.lang.Object) VIRTUAL call: java.util.ArrayList.add(java.lang.Object):boolean A[MD:(E):boolean (c)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final com.five_corp.ad.internal.util.f a(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v0 ??, still in use, count: 1, list:
          (r10v0 ?? I:java.lang.Object) from 0x0056: INVOKE (r12v13 ?? I:java.util.ArrayList), (r10v0 ?? I:java.lang.Object) VIRTUAL call: java.util.ArrayList.add(java.lang.Object):boolean A[MD:(E):boolean (c)]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
        */
}

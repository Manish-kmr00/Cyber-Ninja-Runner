package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes11.dex */
@DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.ui.viewmodel.IntegrationInspectorViewModel$updateData$1", f = "IntegrationInspectorViewModel.kt", i = {0, 1, 2, 3}, l = {108, 109, 111, 115}, m = "invokeSuspend", n = {"currentDestination", "currentDestination", "currentDestination", "currentDestination"}, s = {"L$0", "L$0", "L$0", "L$0"})
final class cp0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    cx b;
    Object c;
    int d;
    final /* synthetic */ bp0 e;
    final /* synthetic */ boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    cp0(bp0 bp0Var, boolean z, Continuation<? super cp0> continuation) {
        super(2, continuation);
        this.e = bp0Var;
        this.f = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new cp0(this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new cp0(this.e, this.f, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00fc A[LOOP:1: B:33:0x00f6->B:35:0x00fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0154  */
    /* JADX WARN: Code duplicated, block: B:50:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:52:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:54:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:56:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:59:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:62:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x0245  */
    /* JADX WARN: Code duplicated, block: B:79:0x026c  */
    /* JADX WARN: Code duplicated, block: B:82:0x027c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        cx cxVarA;
        Object objA;
        cx cxVar;
        Object objA2;
        Object objA3;
        la laVar;
        Object objA4;
        hx hxVar;
        hw adUnit;
        List listCreateListBuilder;
        jw.a aVarF;
        pw pwVar;
        jw.a aVarF2;
        jw.a.b bVar;
        List<iy> listA;
        ow mediationNetworkData;
        List listCreateListBuilder2;
        String strB;
        String strC;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.d;
        ?? A = 0;
        A = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            cxVarA = ((dy) this.e.m.getValue()).a();
            if (((dy) this.e.m.getValue()).c().isEmpty() || this.f) {
                bp0 bp0Var = this.e;
                bp0.a(bp0Var, dy.a((dy) bp0Var.m.getValue(), null, null, true, null, 11));
            }
            if (cxVarA instanceof cx.d) {
                hx hxVar2 = this.e.h;
                je0 je0Var = this.e.d;
                boolean z = this.f;
                this.b = cxVarA;
                this.c = hxVar2;
                this.d = 1;
                objA4 = je0Var.a(z, this);
                if (objA4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                hxVar = hxVar2;
                A = hxVar.a((fx) objA4);
            } else if (cxVarA instanceof cx.c) {
                la laVar2 = this.e.i;
                ie0 ie0Var = this.e.e;
                boolean z2 = this.f;
                this.b = cxVarA;
                this.c = laVar2;
                this.d = 2;
                objA3 = ie0Var.a(z2, this);
                if (objA3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                laVar = laVar2;
                mw adUnits = (mw) objA3;
                laVar.getClass();
                Intrinsics.checkNotNullParameter(adUnits, "adUnits");
                List<gw> listA2 = adUnits.a();
                A = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA2, 10));
                for (gw gwVar : listA2) {
                    A.add(new fy.a(gwVar.c(), gwVar.b(), gwVar.a()));
                }
            } else if (cxVarA instanceof cx.b) {
                fa faVar = this.e.k;
                fy.g gVarB = ((cx.b) cxVarA).b();
                faVar.getClass();
                A = fa.a(gVarB);
            } else if (cxVarA instanceof cx.a) {
                he0 he0Var = this.e.f;
                String strB2 = ((cx.a) cxVarA).b();
                boolean z3 = this.f;
                this.b = cxVarA;
                this.d = 3;
                objA2 = he0Var.a(strB2, z3, this);
                if (objA2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cxVar = cxVarA;
                adUnit = (hw) objA2;
                if (adUnit != null) {
                    this.e.j.getClass();
                    Intrinsics.checkNotNullParameter(adUnit, "adUnit");
                    listCreateListBuilder = CollectionsKt.createListBuilder();
                    listCreateListBuilder.add(fy.d.f8946a);
                    listCreateListBuilder.add(new fy.e(adUnit.d()));
                    listCreateListBuilder.add(new fy.f("Format", adUnit.b()));
                    listCreateListBuilder.add(new fy.f("ID", adUnit.a()));
                    for (jw jwVar : adUnit.c().a()) {
                        aVarF = jwVar.f();
                        if (aVarF instanceof jw.a.C0749a) {
                            pwVar = pw.c;
                        } else {
                            if (aVarF instanceof jw.a.b) {
                                throw new NoWhenBranchMatchedException();
                            }
                            pwVar = pw.d;
                        }
                        pw pwVar2 = pwVar;
                        aVarF2 = jwVar.f();
                        if (aVarF2 instanceof jw.a.b) {
                            bVar = (jw.a.b) aVarF2;
                        } else {
                            bVar = null;
                        }
                        if (bVar != null) {
                            listA = bVar.a();
                        } else {
                            listA = null;
                        }
                        listCreateListBuilder.add(new fy.g(jwVar.b(), jwVar.c(), new yx("Mediation", R.attr.debug_panel_label_secondary, null, R.style.DebugPanelText_Body2, 4), new ww(R.attr.debug_panel_label_primary, R.style.DebugPanelText_Body1, pwVar2.a()), null, jwVar.a(), jwVar.d(), jwVar.e(), listA, pwVar2, null, 1024));
                    }
                    A = CollectionsKt.build(listCreateListBuilder);
                }
                cxVarA = cxVar;
            } else {
                if (!(cxVarA instanceof cx.e)) {
                    throw new NoWhenBranchMatchedException();
                }
                le0 le0Var = this.e.g;
                String strB3 = ((cx.e) cxVarA).b();
                boolean z4 = this.f;
                this.b = cxVarA;
                this.d = 4;
                objA = le0Var.a(strB3, z4, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cxVar = cxVarA;
                mediationNetworkData = (ow) objA;
                if (mediationNetworkData != null) {
                    this.e.l.getClass();
                    Intrinsics.checkNotNullParameter(mediationNetworkData, "mediationNetworkData");
                    listCreateListBuilder2 = CollectionsKt.createListBuilder();
                    listCreateListBuilder2.add(fy.d.f8946a);
                    listCreateListBuilder2.add(new fy.e("Integration"));
                    strB = mediationNetworkData.b();
                    if (strB != null) {
                        listCreateListBuilder2.add(new fy.f("Adapter Version", strB));
                    }
                    strC = mediationNetworkData.c();
                    if (strC != null) {
                        listCreateListBuilder2.add(new fy.f("Latest Adapter Version", strC));
                    }
                    fy.c.a aVar = fy.c.a.TEST_MODE;
                    listCreateListBuilder2.add(new fy.c());
                    A = CollectionsKt.build(listCreateListBuilder2);
                }
                cxVarA = cxVar;
            }
        } else if (i == 1) {
            hxVar = (hx) this.c;
            cxVarA = this.b;
            ResultKt.throwOnFailure(obj);
            objA4 = obj;
            A = hxVar.a((fx) objA4);
        } else if (i == 2) {
            laVar = (la) this.c;
            cxVarA = this.b;
            ResultKt.throwOnFailure(obj);
            objA3 = obj;
            mw adUnits2 = (mw) objA3;
            laVar.getClass();
            Intrinsics.checkNotNullParameter(adUnits2, "adUnits");
            List<gw> listA3 = adUnits2.a();
            A = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA3, 10));
            while (r1.hasNext()) {
                A.add(new fy.a(gwVar.c(), gwVar.b(), gwVar.a()));
            }
        } else if (i == 3) {
            cxVar = this.b;
            ResultKt.throwOnFailure(obj);
            objA2 = obj;
            adUnit = (hw) objA2;
            if (adUnit != null) {
                this.e.j.getClass();
                Intrinsics.checkNotNullParameter(adUnit, "adUnit");
                listCreateListBuilder = CollectionsKt.createListBuilder();
                listCreateListBuilder.add(fy.d.f8946a);
                listCreateListBuilder.add(new fy.e(adUnit.d()));
                listCreateListBuilder.add(new fy.f("Format", adUnit.b()));
                listCreateListBuilder.add(new fy.f("ID", adUnit.a()));
                while (r3.hasNext()) {
                    aVarF = jwVar.f();
                    if (aVarF instanceof jw.a.C0749a) {
                        pwVar = pw.c;
                    } else {
                        if (aVarF instanceof jw.a.b) {
                            throw new NoWhenBranchMatchedException();
                        }
                        pwVar = pw.d;
                    }
                    pw pwVar3 = pwVar;
                    aVarF2 = jwVar.f();
                    if (aVarF2 instanceof jw.a.b) {
                        bVar = (jw.a.b) aVarF2;
                    } else {
                        bVar = null;
                    }
                    if (bVar != null) {
                        listA = bVar.a();
                    } else {
                        listA = null;
                    }
                    listCreateListBuilder.add(new fy.g(jwVar.b(), jwVar.c(), new yx("Mediation", R.attr.debug_panel_label_secondary, null, R.style.DebugPanelText_Body2, 4), new ww(R.attr.debug_panel_label_primary, R.style.DebugPanelText_Body1, pwVar3.a()), null, jwVar.a(), jwVar.d(), jwVar.e(), listA, pwVar3, null, 1024));
                }
                A = CollectionsKt.build(listCreateListBuilder);
            }
            cxVarA = cxVar;
        } else {
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cxVar = this.b;
            ResultKt.throwOnFailure(obj);
            objA = obj;
            mediationNetworkData = (ow) objA;
            if (mediationNetworkData != null) {
                this.e.l.getClass();
                Intrinsics.checkNotNullParameter(mediationNetworkData, "mediationNetworkData");
                listCreateListBuilder2 = CollectionsKt.createListBuilder();
                listCreateListBuilder2.add(fy.d.f8946a);
                listCreateListBuilder2.add(new fy.e("Integration"));
                strB = mediationNetworkData.b();
                if (strB != null) {
                    listCreateListBuilder2.add(new fy.f("Adapter Version", strB));
                }
                strC = mediationNetworkData.c();
                if (strC != null) {
                    listCreateListBuilder2.add(new fy.f("Latest Adapter Version", strC));
                }
                fy.c.a aVar2 = fy.c.a.TEST_MODE;
                listCreateListBuilder2.add(new fy.c());
                A = CollectionsKt.build(listCreateListBuilder2);
            }
            cxVarA = cxVar;
        }
        if (A == 0) {
            bp0.m(this.e);
        } else if (Intrinsics.areEqual(cxVarA, ((dy) this.e.m.getValue()).a())) {
            bp0.a(this.e, dy.a((dy) this.e.m.getValue(), null, null, false, A, 3));
        }
        return Unit.INSTANCE;
    }
}

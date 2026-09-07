package com.inmobi.media;

import com.amazon.device.ads.DtbDeviceData;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class Wb extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Xb f3230a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wb(Xb xb) {
        super(1);
        this.f3230a = xb;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        switch (it.f3141a) {
            case 150:
                Xb xb = this.f3230a;
                Map map = it.c;
                Object obj2 = map != null ? map.get("data") : null;
                R2 r2 = obj2 instanceof R2 ? (R2) obj2 : null;
                xb.a("CrashEventOccurred", r2);
                if (r2 != null && Intrinsics.areEqual(new JSONObject(r2.a()).optString("name", ""), "OutOfMemoryError")) {
                    StackTraceElement[] stackTraceElementArr = r2.g;
                    if (stackTraceElementArr == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stackTrace");
                        stackTraceElementArr = null;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    C3435k3 c3435k3 = C3435k3.f3355a;
                    linkedHashMap.put(CommonUrlParts.MANUFACTURER, c3435k3.l());
                    linkedHashMap.put("modelName", c3435k3.n());
                    linkedHashMap.put(DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY, c3435k3.s());
                    C3393h3 c3393h3A = c3435k3.a();
                    linkedHashMap.put("maxHeapSize", Long.valueOf(c3393h3A.f3330a));
                    linkedHashMap.put("freeHeapSize", Long.valueOf(c3393h3A.b));
                    linkedHashMap.put("currentHeapSize", Long.valueOf(c3393h3A.c));
                    linkedHashMap.put("activeThreads", Integer.valueOf(Thread.activeCount()));
                    Set<Thread> setKeySet = Thread.getAllStackTraces().keySet();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : setKeySet) {
                        String name = ((Thread) obj3).getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (StringsKt.contains$default((CharSequence) name, (CharSequence) "TIM-", false, 2, (Object) null)) {
                            arrayList.add(obj3);
                        }
                    }
                    linkedHashMap.put("inmobiThreadCount", Integer.valueOf(arrayList.size()));
                    linkedHashMap.put("isSdkInvolved", Boolean.valueOf(Ec.b(stackTraceElementArr)));
                    Ob.b("OutOfMemoryEvent", linkedHashMap, Sb.SDK);
                }
                break;
            case 151:
                Xb xb2 = this.f3230a;
                Map map2 = it.c;
                Object obj4 = map2 != null ? map2.get("data") : null;
                gd gdVar = obj4 instanceof gd ? (gd) obj4 : null;
                xb2.getClass();
                if (gdVar != null && Ec.a(gdVar) && !C3435k3.f3355a.z()) {
                    xb2.a("MainThreadBlockedEvent", gdVar);
                }
                break;
            case 152:
                Xb xb3 = this.f3230a;
                Map map3 = it.c;
                Object obj5 = map3 != null ? map3.get("data") : null;
                xb3.a(obj5 instanceof N0 ? (N0) obj5 : null);
                break;
        }
        return Unit.INSTANCE;
    }
}

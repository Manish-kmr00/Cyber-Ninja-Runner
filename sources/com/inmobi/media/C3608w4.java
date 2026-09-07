package com.inmobi.media;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: com.inmobi.media.w4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3608w4 extends ObservableProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3622x4 f3465a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3608w4(EnumC3501o9 enumC3501o9, C3622x4 c3622x4) {
        super(enumC3501o9);
        this.f3465a = c3622x4;
    }

    @Override // kotlin.properties.ObservableProperty
    public final void afterChange(KProperty property, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        EnumC3501o9 enumC3501o9 = (EnumC3501o9) obj2;
        if (AbstractC3515p9.a((EnumC3501o9) obj) == AbstractC3515p9.a(enumC3501o9)) {
            return;
        }
        Iterator it = this.f3465a.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC3542r9) it.next()).a(enumC3501o9);
        }
    }
}

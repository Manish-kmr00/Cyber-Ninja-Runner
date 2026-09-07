package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Hg implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lg f11178a;

    public Hg(Lg lg) {
        this.f11178a = lg;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        C4363pb c4363pb = (C4363pb) obj;
        Lg lg = this.f11178a;
        String str = c4363pb.h;
        String str2 = c4363pb.e;
        Integer num = c4363pb.f;
        String str3 = c4363pb.g;
        C4157h4 c4157h4 = new C4157h4(str, str2, num, str3, c4363pb.i);
        String str4 = c4363pb.b;
        byte[] bArr = c4363pb.f11719a;
        int i = c4363pb.c;
        HashMap map = c4363pb.d;
        String str5 = c4363pb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4(bArr, str4, 5889, orCreatePublicLogger);
        c4082e4.q = map;
        c4082e4.g = i;
        c4082e4.c = str5;
        G4 g4 = new G4(new Bl(), new F4(), null);
        lg.c.a(c4157h4, g4).a(c4082e4, g4);
        lg.c.a(num.intValue(), str2, str3);
    }
}

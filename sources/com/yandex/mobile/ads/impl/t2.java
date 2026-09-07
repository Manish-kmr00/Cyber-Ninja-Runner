package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10258a;
    private final v70 b;
    private final l9 c;
    private final bm d;
    private final wo1 e;
    private final v42 f;
    private final g62 g;

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:34:0x00d4
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final com.yandex.mobile.ads.impl.p2 a(org.xmlpull.v1.XmlPullParser r11, com.yandex.mobile.ads.impl.vj r12) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.t2.a(org.xmlpull.v1.XmlPullParser, com.yandex.mobile.ads.impl.vj):com.yandex.mobile.ads.impl.p2");
    }

    public /* synthetic */ t2(wk2 wk2Var, v70 v70Var) {
        this(wk2Var, v70Var, new l9(wk2Var), new bm(), new wo1(), new v42(), new g62());
    }

    public t2(wk2 xmlHelper, v70 extensionsParser, l9 adSourceParser, bm breakTypeParser, wo1 repeatAfterParser, v42 timeOffsetParser, g62 trackingEventsParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(extensionsParser, "extensionsParser");
        Intrinsics.checkNotNullParameter(adSourceParser, "adSourceParser");
        Intrinsics.checkNotNullParameter(breakTypeParser, "breakTypeParser");
        Intrinsics.checkNotNullParameter(repeatAfterParser, "repeatAfterParser");
        Intrinsics.checkNotNullParameter(timeOffsetParser, "timeOffsetParser");
        Intrinsics.checkNotNullParameter(trackingEventsParser, "trackingEventsParser");
        this.f10258a = xmlHelper;
        this.b = extensionsParser;
        this.c = adSourceParser;
        this.d = breakTypeParser;
        this.e = repeatAfterParser;
        this.f = timeOffsetParser;
        this.g = trackingEventsParser;
    }
}

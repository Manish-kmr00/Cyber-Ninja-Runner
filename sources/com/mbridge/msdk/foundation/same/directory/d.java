package com.mbridge.msdk.foundation.same.directory;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MBridgeDirContext.java */
/* JADX INFO: loaded from: classes6.dex */
public class d extends b {
    public d(String str) {
        super(str);
    }

    @Override // com.mbridge.msdk.foundation.same.directory.b
    protected List<a> b() {
        ArrayList<a> arrayList = new ArrayList<>();
        a(arrayList, c.MBRIDGE_RES_MANAGER_DIR, "mb/res");
        a(arrayList, c.AD_MOVIES, "mb/res/Movies").a(c.MBRIDGE_VC, "mb/res/.MBridge_VC");
        a aVarA = a(arrayList, c.AD_MBRIDGE_700, "mb/res/.mbridge700");
        aVarA.a(c.MBRIDGE_700_IMG, "mb/res/img");
        aVarA.a(c.MBRIDGE_700_IMG_PICASSO, "mb/res/picasso");
        aVarA.a(c.MBRIDGE_700_RES, "mb/res/res");
        aVarA.a(c.MBRIDGE_700_HTML, "mb/res/html");
        aVarA.a(c.MBRIDGE_700_XML, "mb/res/xml");
        aVarA.a(c.MBRIDGE_700_CONFIG, "mb/config");
        c cVar = c.MBRIDGE_OTHER;
        a(arrayList, cVar, "mb/other");
        a(arrayList, c.MBRIDGE_CRASH_INFO, "mb/crashinfo");
        a(arrayList, cVar, "mb/other");
        return arrayList;
    }
}

package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"Lcom/ironsource/yq;", ug.p, "", "isManual", "Lcom/ironsource/o2;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "mediationsdk_release"}, k = 2, mv = {1, 8, 0})
public final class uq {
    /* JADX INFO: Access modifiers changed from: private */
    public static final o2 b(yq yqVar, boolean z) {
        o2.a aVar;
        if (z) {
            aVar = o2.a.MANUAL;
        } else {
            aVar = yqVar.k().e() ? o2.a.AUTOMATIC_LOAD_WHILE_SHOW : o2.a.AUTOMATIC_LOAD_AFTER_CLOSE;
        }
        return new o2(aVar, yqVar.k().j(), yqVar.k().b(), -1L);
    }
}

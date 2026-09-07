package com.json;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¨\u0006\u0004"}, d2 = {"Lcom/ironsource/u6;", ug.p, "Lcom/ironsource/o2;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "mediationsdk_release"}, k = 2, mv = {1, 8, 0})
public final class i6 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final o2 b(u6 u6Var) {
        return new o2(u6Var.d().e() ? o2.a.MANUAL_WITH_LOAD_ON_SHOW : o2.a.MANUAL_WITH_AUTOMATIC_RELOAD, u6Var.d().j(), u6Var.d().b(), ((long) u6Var.h()) * 1000);
    }
}

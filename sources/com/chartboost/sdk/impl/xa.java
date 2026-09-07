package com.chartboost.sdk.impl;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/chartboost/sdk/impl/va;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lcom/chartboost/sdk/impl/va;)Lcom/chartboost/sdk/impl/va;", "", "a", "(Lcom/chartboost/sdk/impl/va;)Ljava/lang/String;", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "MARKET_REGEX", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f1193a = new Regex("^market://details\\?id=(.*)$");

    public static final String a(va vaVar) {
        List<String> groupValues;
        MatchResult matchResultMatchEntire = f1193a.matchEntire(vaVar.getUrl());
        if (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null) {
            return null;
        }
        return (String) CollectionsKt.getOrNull(groupValues, 1);
    }

    public static final va b(va vaVar) {
        Intrinsics.checkNotNullParameter(vaVar, "<this>");
        String strA = a(vaVar);
        if (strA == null) {
            return vaVar;
        }
        String str = String.format(POBCommonConstants.PLAY_STORE_URL, Arrays.copyOf(new Object[]{strA}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        va vaVarA = va.a(vaVar, str, null, 2, null);
        return vaVarA == null ? vaVar : vaVarA;
    }
}

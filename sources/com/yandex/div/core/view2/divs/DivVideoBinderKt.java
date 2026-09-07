package com.yandex.div.core.view2.divs;

import android.net.Uri;
import com.yandex.div.core.player.DivVideoResolution;
import com.yandex.div.core.player.DivVideoSource;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivVideo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivVideoBinder.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"createSource", "", "Lcom/yandex/div/core/player/DivVideoSource;", "Lcom/yandex/div2/DivVideo;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivVideoBinderKt {
    public static final List<DivVideoSource> createSource(DivVideo divVideo, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divVideo, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List<com.yandex.div2.DivVideoSource> list = divVideo.videoSources;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (com.yandex.div2.DivVideoSource divVideoSource : list) {
            Uri uriEvaluate = divVideoSource.url.evaluate(resolver);
            String strEvaluate = divVideoSource.mimeType.evaluate(resolver);
            com.yandex.div2.DivVideoSource.Resolution resolution = divVideoSource.resolution;
            Long lEvaluate = null;
            DivVideoResolution divVideoResolution = resolution != null ? new DivVideoResolution((int) resolution.width.evaluate(resolver).longValue(), (int) resolution.height.evaluate(resolver).longValue()) : null;
            Expression<Long> expression = divVideoSource.bitrate;
            if (expression != null) {
                lEvaluate = expression.evaluate(resolver);
            }
            arrayList.add(new DivVideoSource(uriEvaluate, strEvaluate, divVideoResolution, lEvaluate));
        }
        return arrayList;
    }
}

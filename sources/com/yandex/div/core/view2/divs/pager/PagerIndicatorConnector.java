package com.yandex.div.core.view2.divs.pager;

import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.view2.divs.widgets.DivPagerIndicatorView;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagerIndicatorConnector.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0010J\u001d\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0013R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/PagerIndicatorConnector;", "", "()V", "divIndicators", "", "", "", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerIndicatorView;", "divPagers", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "attach", "", "attach$div_release", "submitIndicator", "pagerId", "divPagerIndicatorView", "submitIndicator$div_release", "submitPager", "divPagerView", "submitPager$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class PagerIndicatorConnector {
    private final Map<String, DivPagerView> divPagers = new LinkedHashMap();
    private final Map<String, List<DivPagerIndicatorView>> divIndicators = new LinkedHashMap();

    @Inject
    public PagerIndicatorConnector() {
    }

    public final void submitPager$div_release(String pagerId, DivPagerView divPagerView) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(divPagerView, "divPagerView");
        this.divPagers.put(pagerId, divPagerView);
    }

    public final void submitIndicator$div_release(String pagerId, DivPagerIndicatorView divPagerIndicatorView) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(divPagerIndicatorView, "divPagerIndicatorView");
        Map<String, List<DivPagerIndicatorView>> map = this.divIndicators;
        ArrayList arrayList = map.get(pagerId);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(pagerId, arrayList);
        }
        arrayList.add(divPagerIndicatorView);
    }

    public final void attach$div_release() {
        for (Map.Entry<String, DivPagerView> entry : this.divPagers.entrySet()) {
            String key = entry.getKey();
            DivPagerView value = entry.getValue();
            value.clearChangePageCallbackForIndicators();
            List<DivPagerIndicatorView> list = this.divIndicators.get(key);
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((DivPagerIndicatorView) it.next()).attachPager(value);
                }
            }
        }
        this.divPagers.clear();
        this.divIndicators.clear();
    }
}

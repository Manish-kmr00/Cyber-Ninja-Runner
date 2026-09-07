package io.bidmachine.rendering.measurer;

import android.webkit.WebView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class CompositeHtmlMeasurer extends BaseCompositeMeasurer<HtmlMeasurer, WebView> implements HtmlMeasurer {
    public CompositeHtmlMeasurer(List<HtmlMeasurer> measurerList) {
        super(measurerList);
    }

    @Override // io.bidmachine.rendering.measurer.HtmlMeasurer
    public String prepareCreativeForMeasure(String html) {
        Iterator it = this.f12396a.iterator();
        while (it.hasNext()) {
            html = ((HtmlMeasurer) it.next()).prepareCreativeForMeasure(html);
        }
        return html;
    }
}

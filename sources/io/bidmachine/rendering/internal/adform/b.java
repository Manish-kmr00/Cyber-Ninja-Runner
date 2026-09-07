package io.bidmachine.rendering.internal.adform;

import android.content.Context;
import io.bidmachine.rendering.measurer.CompositeHtmlMeasurer;
import io.bidmachine.rendering.measurer.CompositeVideoMeasurer;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdElementType;
import io.bidmachine.rendering.model.MeasurerParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12330a;

        static {
            int[] iArr = new int[AdElementType.values().length];
            f12330a = iArr;
            try {
                iArr[AdElementType.Mraid.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12330a[AdElementType.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12330a[AdElementType.Image.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12330a[AdElementType.Progress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12330a[AdElementType.Countdown.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static io.bidmachine.rendering.internal.adform.a a(Context context, io.bidmachine.rendering.internal.repository.a aVar, AdElementParams adElementParams, c cVar, io.bidmachine.rendering.internal.event.a aVar2) {
        int i = a.f12330a[adElementParams.getAdElementType().ordinal()];
        if (i == 1) {
            return new io.bidmachine.rendering.internal.adform.html.a(context, aVar, adElementParams, cVar, aVar2, a(context, adElementParams.getMeasurerFactory(), adElementParams.getMeasurerParamsList()));
        }
        if (i == 2) {
            return new io.bidmachine.rendering.internal.adform.video.a(context, aVar, adElementParams, cVar, aVar2, b(context, adElementParams.getMeasurerFactory(), adElementParams.getMeasurerParamsList()));
        }
        if (i == 3) {
            return new io.bidmachine.rendering.internal.adform.image.a(context, aVar, adElementParams, cVar, aVar2);
        }
        if (i == 4) {
            return new io.bidmachine.rendering.internal.adform.progress.a(context, aVar, adElementParams, cVar, aVar2);
        }
        if (i != 5) {
            return null;
        }
        return new io.bidmachine.rendering.internal.adform.countdown.a(context, aVar, adElementParams, cVar, aVar2);
    }

    static VideoMeasurer b(Context context, MeasurerFactory measurerFactory, List list) {
        if (measurerFactory == null || list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MeasurerParams measurerParams = (MeasurerParams) it.next();
            VideoMeasurer videoMeasurerCreateVideoMeasurer = measurerFactory.createVideoMeasurer(context, measurerParams.getName(), measurerParams.getParameters());
            if (videoMeasurerCreateVideoMeasurer != null) {
                arrayList.add(videoMeasurerCreateVideoMeasurer);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new CompositeVideoMeasurer(arrayList);
    }

    static HtmlMeasurer a(Context context, MeasurerFactory measurerFactory, List list) {
        if (measurerFactory == null || list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MeasurerParams measurerParams = (MeasurerParams) it.next();
            HtmlMeasurer htmlMeasurerCreateHtmlMeasurer = measurerFactory.createHtmlMeasurer(context, measurerParams.getName(), measurerParams.getParameters());
            if (htmlMeasurerCreateHtmlMeasurer != null) {
                arrayList.add(htmlMeasurerCreateHtmlMeasurer);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new CompositeHtmlMeasurer(arrayList);
    }
}

package net.pubnative.lite.sdk.utils.svgparser.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes11.dex */
public class CanvasLegacy {
    public static final int ALL_SAVE_FLAG;
    public static final int MATRIX_SAVE_FLAG;
    private static final Method SAVE;
    private static final Method SAVE_LAYER;

    static {
        try {
            MATRIX_SAVE_FLAG = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            ALL_SAVE_FLAG = ((Integer) Canvas.class.getField("ALL_SAVE_FLAG").get(null)).intValue();
            SAVE = Canvas.class.getMethod("save", Integer.TYPE);
            SAVE_LAYER = Canvas.class.getMethod("saveLayer", RectF.class, Paint.class, Integer.TYPE);
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    public static void save(Canvas canvas, int i) {
        try {
            SAVE.invoke(canvas, Integer.valueOf(i));
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    private static RuntimeException sneakyThrow(Throwable th) {
        if (th == null) {
            throw new NullPointerException(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
        }
        return (RuntimeException) sneakyThrow0(th);
    }

    private static <T extends Throwable> T sneakyThrow0(Throwable th) throws Throwable {
        throw th;
    }

    public static void saveLayer(Canvas canvas, RectF rectF, Paint paint, int i) {
        try {
            SAVE_LAYER.invoke(canvas, rectF, paint, Integer.valueOf(i));
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }
}

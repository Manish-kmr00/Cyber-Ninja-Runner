package sg.bigo.ads.core.mraid;

import android.graphics.Rect;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f13632a;
    final Rect b;
    final List<Rect> c;

    b(float f, Rect rect, List<Rect> list) {
        this.f13632a = f;
        this.b = rect;
        this.c = list;
    }

    static JSONArray a(List<Rect> list) {
        if (list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Rect> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(a(it.next()));
        }
        return jSONArray;
    }

    static JSONObject a(Rect rect) {
        if (rect == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VastAttributes.HORIZONTAL_POSITION, rect.left);
            jSONObject.put(VastAttributes.VERTICAL_POSITION, rect.top);
            jSONObject.put("width", rect.width());
            jSONObject.put("height", rect.height());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}

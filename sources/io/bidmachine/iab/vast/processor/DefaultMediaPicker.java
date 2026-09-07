package io.bidmachine.iab.vast.processor;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.tags.LinearCreativeTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class DefaultMediaPicker extends VastMediaPicker<MediaFileTag> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12308a;
    private boolean b;

    private class b implements Comparator {
        private b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair pair, Pair pair2) {
            int width = ((MediaFileTag) pair.second).getWidth() * ((MediaFileTag) pair.second).getHeight();
            int width2 = ((MediaFileTag) pair2.second).getWidth() * ((MediaFileTag) pair2.second).getHeight();
            int iAbs = Math.abs(width - DefaultMediaPicker.this.f12308a);
            int iAbs2 = Math.abs(width2 - DefaultMediaPicker.this.f12308a);
            VastLog.d("DefaultMediaPicker", "AreaComparator: obj1 - %d, obj2 - %d", Integer.valueOf(iAbs), Integer.valueOf(iAbs2));
            if (iAbs < iAbs2) {
                return -1;
            }
            return iAbs > iAbs2 ? 1 : 0;
        }
    }

    public DefaultMediaPicker(int width, int height) {
        a(width, height);
    }

    protected boolean b(MediaFileTag mediaFileTag) {
        return (mediaFileTag.getWidth() > mediaFileTag.getHeight()) == this.b;
    }

    @Override // io.bidmachine.iab.vast.processor.VastMediaPicker
    public Pair<LinearCreativeTag, MediaFileTag> pickVideo(List<Pair<LinearCreativeTag, MediaFileTag>> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new b());
        return a(list);
    }

    public DefaultMediaPicker(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.b = Utils.isLandscapeOrientation(context);
    }

    private Pair a(List list) {
        VastLog.d("DefaultMediaPicker", "getBestMatch", new Object[0]);
        Iterator it = list.iterator();
        Pair pair = null;
        while (it.hasNext()) {
            Pair pair2 = (Pair) it.next();
            if (a((MediaFileTag) pair2.second)) {
                if (b((MediaFileTag) pair2.second)) {
                    return pair2;
                }
                if (pair == null) {
                    pair = pair2;
                }
            }
        }
        return pair;
    }

    protected boolean a(MediaFileTag mediaFileTag) {
        String type = mediaFileTag.getType();
        return type != null && type.matches("video/.*(?i)(mp4|3gpp|mp2t|webm|matroska)");
    }

    private void a(int i, int i2) {
        this.f12308a = i * i2;
    }
}

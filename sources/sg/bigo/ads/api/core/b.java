package sg.bigo.ads.api.core;

import android.util.SparseArray;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<List<Integer>> f13100a;

    static {
        SparseArray<List<Integer>> sparseArray = new SparseArray<>();
        f13100a = sparseArray;
        sparseArray.put(0, Arrays.asList(1, 2, 3));
        sparseArray.put(1, Arrays.asList(1, 2));
        sparseArray.put(2, Collections.singletonList(3));
        sparseArray.put(3, Arrays.asList(1, 2, 3));
        sparseArray.put(20, Arrays.asList(1, 2, 3));
        sparseArray.put(4, Arrays.asList(1, 2, 3));
        sparseArray.put(12, Arrays.asList(1, 2));
        sparseArray.put(15, Arrays.asList(1, 2, 5));
        sparseArray.put(16, Arrays.asList(1, 2, 5));
        sparseArray.put(17, Arrays.asList(1, 2, 5));
        sparseArray.put(18, Arrays.asList(1, 2, 5));
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = f13100a.get(i);
        if (list != null) {
            for (Integer num : list) {
                if (sb.length() > 0) {
                    sb.append(StringUtils.COMMA);
                }
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static boolean b(int i) {
        return i == 3 || i == 4 || i == 20;
    }

    public static boolean c(int i) {
        return i == 3 || i == 4 || i == 12 || i == 20;
    }

    public static boolean d(int i) {
        return i == 12;
    }

    public static boolean e(int i) {
        return i != 4;
    }
}

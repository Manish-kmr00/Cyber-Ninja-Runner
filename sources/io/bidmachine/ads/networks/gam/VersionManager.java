package io.bidmachine.ads.networks.gam;

import android.os.Build;
import android.util.Pair;
import io.bidmachine.ads.networks.gam.versions.VersionWrapper;
import io.bidmachine.ads.networks.gam.versions.v21_0_0.VersionWrapperImpl;
import io.bidmachine.utils.version.Version;
import io.bidmachine.utils.version.VersionRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class VersionManager {
    static final List<Pair<VersionRange, VersionWrapper>> VERSION_WRAPPER_LIST = new ArrayList();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VersionWrapperImpl());
        arrayList.add(new io.bidmachine.ads.networks.gam.versions.v22_0_0.VersionWrapperImpl());
        arrayList.add(new io.bidmachine.ads.networks.gam.versions.v23_0_0.VersionWrapperImpl());
        Collections.sort(arrayList, new Comparator() { // from class: io.bidmachine.ads.networks.gam.VersionManager$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((VersionWrapper) obj).getVersionForWhichCompiled().compareTo(((VersionWrapper) obj2).getVersionForWhichCompiled());
            }
        });
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            VersionWrapper versionWrapper = (VersionWrapper) arrayList.get(i);
            Version versionForWhichCompiled = null;
            VersionWrapper versionWrapper2 = i < size + (-1) ? (VersionWrapper) arrayList.get(i + 1) : null;
            Version versionForWhichCompiled2 = versionWrapper.getVersionForWhichCompiled();
            if (versionWrapper2 != null) {
                versionForWhichCompiled = versionWrapper2.getVersionForWhichCompiled();
            }
            VERSION_WRAPPER_LIST.add(new Pair<>(new VersionRange(versionForWhichCompiled2, versionForWhichCompiled, true, false), versionWrapper));
            i++;
        }
    }

    public static VersionWrapper findVersionWrapper(String str) {
        Version versionFindVersion;
        VersionRange versionRange = VersionRange.parseVersionRange(str);
        if (versionRange == null || (versionFindVersion = findVersion()) == null || !versionRange.contains(versionFindVersion)) {
            return null;
        }
        for (Pair<VersionRange, VersionWrapper> pair : VERSION_WRAPPER_LIST) {
            if (((VersionRange) pair.first).contains(versionFindVersion)) {
                return (VersionWrapper) pair.second;
            }
        }
        return null;
    }

    static Version findVersion() {
        Version versionSafeGetVersion;
        Iterator<Pair<VersionRange, VersionWrapper>> it = VERSION_WRAPPER_LIST.iterator();
        while (it.hasNext()) {
            VersionWrapper versionWrapper = (VersionWrapper) it.next().second;
            if (Build.VERSION.SDK_INT >= versionWrapper.getMinDeviceApiVersion() && (versionSafeGetVersion = safeGetVersion(versionWrapper)) != null) {
                return versionSafeGetVersion;
            }
        }
        return null;
    }

    static Version safeGetVersion(VersionWrapper versionWrapper) {
        try {
            return versionWrapper.getVersion();
        } catch (Throwable unused) {
            return null;
        }
    }
}

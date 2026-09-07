package com.smaato.sdk.richmedia.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.fi.Supplier;

/* JADX INFO: loaded from: classes3.dex */
abstract class OrientationLockedCompat {
    static boolean isLockedInManifest(final Activity activity) {
        try {
            return isLockedInternal(activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0).screenOrientation, new Supplier() { // from class: com.smaato.sdk.richmedia.util.OrientationLockedCompat$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Supplier
                public final Object get() {
                    return Boolean.valueOf(OrientationLockedCompat.isParentActivityLocked(activity, new Function() { // from class: com.smaato.sdk.richmedia.util.OrientationLockedCompat$$ExternalSyntheticLambda2
                        @Override // com.smaato.sdk.core.util.fi.Function
                        public final Object apply(Object obj) {
                            return Boolean.valueOf(OrientationLockedCompat.isLockedInManifest((Activity) obj));
                        }
                    }));
                }
            });
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    static boolean isLocked(final Activity activity) {
        return isLockedInternal(activity.getRequestedOrientation(), new Supplier() { // from class: com.smaato.sdk.richmedia.util.OrientationLockedCompat$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Supplier
            public final Object get() {
                return Boolean.valueOf(OrientationLockedCompat.isParentActivityLocked(activity, new Function() { // from class: com.smaato.sdk.richmedia.util.OrientationLockedCompat$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Function
                    public final Object apply(Object obj) {
                        return Boolean.valueOf(OrientationLockedCompat.isLocked((Activity) obj));
                    }
                }));
            }
        });
    }

    private static boolean isLockedInternal(int i, Supplier supplier) {
        return isOrientationLockedJellyBeanMR2(i, supplier);
    }

    private static boolean isOrientationLockedBase(int i, Supplier supplier) {
        if (i != 0 && i != 1) {
            if (i == 3) {
                return ((Boolean) supplier.get()).booleanValue();
            }
            switch (i) {
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private static boolean isOrientationLockedJellyBeanMR2(int i, Supplier supplier) {
        if (i == 11 || i == 12 || i == 14) {
            return true;
        }
        return isOrientationLockedBase(i, supplier);
    }

    private static boolean isParentActivityLocked(Activity activity, Function function) {
        if (activity.isChild()) {
            return ((Boolean) function.apply(activity.getParent())).booleanValue();
        }
        return false;
    }
}

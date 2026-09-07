package com.ogury.ad.internal;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 {
    public static final void a(ArrayList arrayList, FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment.getUserVisibleHint() && fragment.isResumed() && !fragment.isHidden()) {
                Intrinsics.checkNotNull(fragment);
                arrayList.add(fragment);
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                a(arrayList, childFragmentManager);
            }
        }
    }
}

package com.yandex.div.core.view2.animations;

import kotlin.Metadata;

/* JADX INFO: compiled from: DivComparatorReporter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/animations/DivComparatorReporter;", "", "onComparisonDifferentChildCount", "", "onComparisonDifferentClasses", "onComparisonDifferentCustomTypes", "onComparisonDifferentIdsWithTransition", "onComparisonDifferentOverlap", "onComparisonDifferentWrap", "onComparisonNoOldData", "onComparisonNoState", "onComparisonSuccess", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivComparatorReporter {
    default void onComparisonDifferentChildCount() {
    }

    default void onComparisonDifferentClasses() {
    }

    default void onComparisonDifferentCustomTypes() {
    }

    default void onComparisonDifferentIdsWithTransition() {
    }

    default void onComparisonDifferentOverlap() {
    }

    default void onComparisonDifferentWrap() {
    }

    default void onComparisonNoOldData() {
    }

    default void onComparisonNoState() {
    }

    default void onComparisonSuccess() {
    }
}

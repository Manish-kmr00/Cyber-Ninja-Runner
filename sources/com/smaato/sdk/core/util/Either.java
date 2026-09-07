package com.smaato.sdk.core.util;

/* JADX INFO: loaded from: classes13.dex */
public final class Either<Left, Right> {
    private final Object left;
    private final Object right;

    Either(Left left, Right right) {
        if (left == null && right == null) {
            throw new IllegalArgumentException("Both parameters are null. Either left or right parameter should be not null");
        }
        if (left != null && right != null) {
            throw new IllegalArgumentException("Both parameters are not null. Either left or right parameter should be null");
        }
        this.left = left;
        this.right = right;
    }

    public Left left() {
        return (Left) this.left;
    }

    public Right right() {
        return (Right) this.right;
    }

    public static <Left, Right> Either<Left, Right> left(Left left) {
        return new Either<>(left, null);
    }

    public static <Left, Right> Either<Left, Right> right(Right right) {
        return new Either<>(null, right);
    }
}

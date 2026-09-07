package com.smaato.sdk.core.util;

import android.os.Bundle;

/* JADX INFO: loaded from: classes11.dex */
public final class Metadata {
    private final Bundle args;

    private Metadata(Bundle bundle) {
        this.args = (Bundle) Objects.requireNonNull(bundle);
    }

    public Integer getInt(String str) {
        int i = this.args.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static class Builder {
        private final Bundle args = new Bundle();

        public Builder putInt(String str, int i) {
            this.args.putInt(str, i);
            return this;
        }

        public Metadata build() {
            return new Metadata(this.args);
        }
    }
}

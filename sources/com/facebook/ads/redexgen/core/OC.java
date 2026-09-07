package com.facebook.ads.redexgen.core;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OC<T> extends AbstractC2964oj<T> {
    public static String[] A01 = {"Fzf9bGtlgYLIOrAPw9kTEZaT3NBj", "nNz32xSm8VfJXUnPFvOMlwsl", "3M1fcCd7TlcDEm", "k56f22msP7PYqb6b5y873zlegrO4Fy04", "AWl95DwkGptNZ3xbY", "ykYqQOs6JuEGf9dZOwLcZB0OUqMBre0v", "7kom9xCVKDNVBTXZjYyNTlOlPeBN", "7wkC9IZFUiSnbQO"};
    public boolean A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OC != com.google.common.collect.Iterators$SingletonNullIterator<T> */
    public OC() {
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OC != com.google.common.collect.Iterators$SingletonNullIterator<T> */
    public /* synthetic */ OC(OF of) {
        this();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OC != com.google.common.collect.Iterators$SingletonNullIterator<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OC != com.google.common.collect.Iterators$SingletonNullIterator<T> */
    @Override // java.util.Iterator
    public final T next() {
        if (!this.A00) {
            this.A00 = true;
            String[] strArr = A01;
            if (strArr[5].charAt(30) != strArr[3].charAt(30)) {
                throw new RuntimeException();
            }
            A01[7] = "or3VpPW3iSzksP2";
            return null;
        }
        throw new NoSuchElementException();
    }
}

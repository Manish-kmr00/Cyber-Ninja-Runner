package androidx.browser.trusted;

/* JADX INFO: loaded from: classes11.dex */
public interface TokenStore {
    Token load();

    void store(Token token);
}

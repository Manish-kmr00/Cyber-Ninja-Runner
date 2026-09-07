package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.util.collections.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public final class ParseResult<Result> {
    public final List<ParseError> errors;
    public final Result value;

    /* JADX WARN: Multi-variable type inference failed */
    private ParseResult(List list, Object obj) {
        this.errors = list;
        this.value = obj;
    }

    public static <Result> ParseResult<Result> error(String str, Exception exc) {
        return new ParseResult<>(Collections.singletonList(ParseError.buildFrom(str, exc)), null);
    }

    public static <Result> ParseResult<Result> error(ParseError parseError) {
        return new ParseResult<>(Collections.singletonList(parseError), null);
    }

    public static class Builder<Result> {
        private List errors;
        private Object value;

        public Builder<Result> setResult(Result result) {
            this.value = result;
            return this;
        }

        public Builder<Result> setErrors(List<ParseError> list) {
            this.errors = list;
            return this;
        }

        public ParseResult<Result> build() {
            if (this.value == null && this.errors == null) {
                throw new IllegalStateException("ParseResult should contain value or list of errors at least");
            }
            return new ParseResult<>(Lists.toImmutableList((Collection) this.errors), this.value);
        }
    }
}

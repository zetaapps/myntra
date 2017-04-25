package zeta.android.thunderbird.models.common;

public interface ITransformer<T, R> {
    R transform(T t);
}

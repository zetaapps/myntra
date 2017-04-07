package zeta.android.thunderbird.models.session;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        GenderType.MALE,
        GenderType.FEMALE,
        GenderType.UNKNOWN,
})
public @interface GenderType {
    String MALE = "male";
    String FEMALE = "female";
    String UNKNOWN = "UNKNOWN";
}

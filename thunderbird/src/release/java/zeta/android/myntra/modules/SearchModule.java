package zeta.android.thunderbird.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import zeta.android.thunderbird.api.devapi.MyntraDevApi;
import zeta.android.thunderbird.api.devapi.response.search.SearchResponse;
import zeta.android.thunderbird.managers.SearchManager;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.search.SearchModel;
import zeta.android.thunderbird.models.transformers.SearchModelTransformer;
import zeta.android.thunderbird.qualifiers.retrofit.RetrofitDevApi;

@Module
public class SearchModule {

    @Provides
    MyntraDevApi providesMyntraApi(@RetrofitDevApi Retrofit retrofit) {
        return retrofit.create(MyntraDevApi.class);
    }

    @Provides
    ITransformer<SearchResponse, SearchModel> providesSearchTransformer() {
        return new SearchModelTransformer();
    }

    @Provides
    SearchManager providesSearchManager(MyntraDevApi devApi,
                                        ITransformer<SearchResponse, SearchModel> transformer) {
        return new SearchManager(devApi, transformer);
    }
}

package zeta.android.thunderbird.managers;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.github.zetaapps.either.Either;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;

import rx.Observable;
import zeta.android.thunderbird.api.devapi.MyntraDevApi;
import zeta.android.thunderbird.api.devapi.response.search.SearchResponse;
import zeta.android.thunderbird.managers.params.SearchParams;
import zeta.android.thunderbird.models.common.ITransformer;
import zeta.android.thunderbird.models.common.Managers;
import zeta.android.thunderbird.models.search.SearchModel;
import zeta.android.thunderbird.models.search.errors.SearchException;

@ParametersAreNonnullByDefault
public class SearchManager {

    private final MyntraDevApi devAPi;
    private final ITransformer<SearchResponse, SearchModel> mSearchTransformer;

    @Inject
    public SearchManager(MyntraDevApi devApi, ITransformer<SearchResponse, SearchModel> transformer) {
        devAPi = devApi;
        mSearchTransformer = transformer;
    }

    @RxLogObservable
    public Observable<Either<SearchModel, SearchException>> getSearchResult(SearchParams searchParams) {
        return devAPi.getSearchResultResponse(searchParams.getSearchQuery(),
                searchParams.getPageNumber(),
                searchParams.getPageSize())
                .map(response -> Managers.buildOneOf(
                        response,
                        SearchException::new,
                        mSearchTransformer));
    }


}

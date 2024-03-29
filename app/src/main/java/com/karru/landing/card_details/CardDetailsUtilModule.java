package com.karru.landing.card_details;

import com.karru.dagger.ActivityScoped;
import com.karru.network.NetworkReachableActivity;
import com.karru.util.AppTypeface;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import static com.karru.utility.Constants.CARD_DETAILS;

/**
 * <h1>AddCardDaggerUtilModule</h1>
 * used to provide models to dagger
 * @author 3Embed
 * @since on 21-03-2018.
 */
@Module
public class CardDetailsUtilModule
{
    @Provides
    @ActivityScoped
    @Named(CARD_DETAILS)
    CompositeDisposable provideCompositeDisposable()
    {
        return new CompositeDisposable();
    }
}

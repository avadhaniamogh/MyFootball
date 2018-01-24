package amogh.org.myfootball.dagger;

import android.content.Context;

import javax.inject.Singleton;

import amogh.org.myfootball.ui.CompetitionsPresenter;
import amogh.org.myfootball.ui.CompetitionsPresenterImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Amogh on 1/23/2018.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    CompetitionsPresenter provideCompetitionPresenter(Context context) {
        return new CompetitionsPresenterImpl(context);
    }
}

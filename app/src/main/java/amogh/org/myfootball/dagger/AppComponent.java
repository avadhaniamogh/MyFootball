package amogh.org.myfootball.dagger;

import javax.inject.Singleton;

import amogh.org.myfootball.ui.CompetitionsActivity;
import amogh.org.myfootball.ui.CompetitionsPresenterImpl;
import dagger.Component;

/**
 * Created by Amogh on 1/23/2018.
 */

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(CompetitionsActivity activity);

    void inject(CompetitionsPresenterImpl presenter);
}

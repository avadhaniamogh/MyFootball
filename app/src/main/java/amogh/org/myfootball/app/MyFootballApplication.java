package amogh.org.myfootball.app;

import android.app.Application;

import amogh.org.myfootball.dagger.AppComponent;
import amogh.org.myfootball.dagger.AppModule;
import amogh.org.myfootball.dagger.DaggerAppComponent;

/**
 * Created by Amogh on 1/23/2018.
 */

public class MyFootballApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);

    }

    protected  AppComponent initDagger(MyFootballApplication myFootballApplication) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(myFootballApplication))
                .build();
    }
}

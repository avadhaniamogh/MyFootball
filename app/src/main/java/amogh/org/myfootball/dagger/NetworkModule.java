package amogh.org.myfootball.dagger;

import javax.inject.Named;
import javax.inject.Singleton;

import amogh.org.myfootball.app.Constants;
import amogh.org.myfootball.network.FootballDataApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amogh on 1/23/2018.
 */

@Module
public class NetworkModule {

    private static final String NAME_BASE_URL = "NAME_BASE_URL";

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrlString() {
        return Constants.BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converterFactory, @Named(NAME_BASE_URL) String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Provides
    @Singleton
    FootballDataApi provideFootballDataApi(Retrofit retrofit) {
        return retrofit.create(FootballDataApi.class);
    }
}

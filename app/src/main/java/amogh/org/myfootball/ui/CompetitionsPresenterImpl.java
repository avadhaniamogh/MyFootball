package amogh.org.myfootball.ui;

import android.content.Context;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import amogh.org.myfootball.app.Constants;
import amogh.org.myfootball.app.MyFootballApplication;
import amogh.org.myfootball.model.Competition;
import amogh.org.myfootball.network.FootballDataApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amogh on 1/23/2018.
 */

public class CompetitionsPresenterImpl implements CompetitionsPresenter {

    private CompetitionsView view;

    @Inject
    FootballDataApi api;

    public CompetitionsPresenterImpl(Context context) {
        ((MyFootballApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(CompetitionsView view) {
        this.view = view;
    }

    @Override
    public void getCompetitions() {
        view.showLoading();

        api.getCompetitions().enqueue(new Callback<List<Competition>>() {
            @Override
            public void onResponse(Call<List<Competition>> call, Response<List<Competition>> response) {
                if (response.code() != 200) {
                    view.showErrorMessage();
                } else {
                    Log.d(Constants.TAG, "Retrofit Call response");
                    List<Competition> competitionList = response.body();

                    view.showCompetitions(competitionList);
                }

                view.hideLoading();
            }

            @Override
            public void onFailure(Call<List<Competition>> call, Throwable t) {
                view.showErrorMessage();
                view.hideLoading();
            }
        });
    }
}

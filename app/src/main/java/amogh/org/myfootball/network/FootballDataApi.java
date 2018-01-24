package amogh.org.myfootball.network;

import java.util.List;

import amogh.org.myfootball.app.Constants;
import amogh.org.myfootball.model.Competition;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Amogh on 1/23/2018.
 */

public interface FootballDataApi {

    @Headers({
            "Accept: application/json",
            "X-Auth-Token:" + Constants.API_KEY
    })
    @GET("competitions/")
    Call<List<Competition>> getCompetitions();
}

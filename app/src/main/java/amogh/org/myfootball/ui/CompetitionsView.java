package amogh.org.myfootball.ui;

import java.util.List;

import amogh.org.myfootball.model.Competition;

/**
 * Created by Amogh on 1/23/2018.
 */

public interface CompetitionsView {

    void showLoading();

    void hideLoading();

    void showCompetitions(List<Competition> competitionList);

    void showErrorMessage();

//    void launchCompetition();
}

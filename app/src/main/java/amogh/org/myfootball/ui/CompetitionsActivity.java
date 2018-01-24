package amogh.org.myfootball.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import amogh.org.myfootball.R;
import amogh.org.myfootball.app.MyFootballApplication;
import amogh.org.myfootball.model.Competition;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CompetitionsActivity extends AppCompatActivity implements CompetitionsView {

    @Inject
    CompetitionsPresenter competitionsPresenter;

    @BindView(R.id.activity_competitions_recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.activity_competitions_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);

        ((MyFootballApplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        competitionsPresenter.setView(this);
        competitionsPresenter.getCompetitions();

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showCompetitions(List<Competition> competitionList) {
        recyclerView.setAdapter(new CompetitionsAdapter(competitionList));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Unable to retrieve competitions", Toast.LENGTH_SHORT).show();
    }

    // Adapter
    class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsHolder> {

        private List<Competition> competitionList;

        CompetitionsAdapter(List<Competition> competitionList) {
            this.competitionList = competitionList;
        }

        @Override
        public CompetitionsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(CompetitionsActivity.this);
            return new CompetitionsHolder(inflater.inflate(R.layout.list_item_competition, parent, false));
        }

        @Override
        public void onBindViewHolder(CompetitionsHolder holder, int position) {
            Competition competition = competitionList.get(position);
            holder.getCompetitionName().setText(competition.getCaption());
        }

        @Override
        public int getItemCount() {
            return competitionList.size();
        }
    }
}

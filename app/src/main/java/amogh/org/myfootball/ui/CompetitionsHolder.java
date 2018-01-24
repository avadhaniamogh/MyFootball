package amogh.org.myfootball.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import amogh.org.myfootball.R;

/**
 * Created by Amogh on 1/23/2018.
 */

public class CompetitionsHolder extends RecyclerView.ViewHolder {
    private ViewGroup container;
    private TextView competitionName;

    public CompetitionsHolder(View itemView) {
        super(itemView);
        container = (ViewGroup) itemView.findViewById(R.id.list_item_competition_container);
        competitionName = (TextView) itemView.findViewById(R.id.list_item_competition_name);
    }

    public ViewGroup getContainer() {
        return container;
    }

    public TextView getCompetitionName() {
        return competitionName;
    }
}

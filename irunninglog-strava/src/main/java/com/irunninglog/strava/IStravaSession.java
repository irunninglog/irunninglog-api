package com.irunninglog.strava;

import com.irunninglog.api.runs.IRun;
import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.model.StravaActivityUpdate;
import javastrava.api.v3.model.StravaAthlete;

import java.util.List;

public interface IStravaSession {

    void load(String token);

    StravaAthlete athlete();

    List<IRun> activities();

    IStravaShoe gear(String id);

    StravaActivity create(StravaActivity activity);

    StravaActivity update(long id, StravaActivityUpdate activity);

}

package rikka.akashitoolkit.network;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import rikka.akashitoolkit.model.Avatars;
import rikka.akashitoolkit.model.CheckUpdate;
import rikka.akashitoolkit.model.Event;
import rikka.akashitoolkit.model.LatestAvatar;
import rikka.akashitoolkit.model.ShipVoice;
import rikka.akashitoolkit.model.Twitter;
import rikka.akashitoolkit.model.Seasonal;
import rikka.akashitoolkit.model.Version;

/**
 * Created by Rikka on 2016/3/8.
 */
public class RetrofitAPI {

    public interface TwitterAPI {
        @GET("/avatar/latest")
        Call<LatestAvatar> getLatestAvatarUrl();

        @GET("/avatars")
        Call<Avatars> getAvatars();

        @GET("/tweet/{count}")
        Call<List<Twitter>> getTweets(@Path("count") int count);
    }

    public interface UpdateAPI {
        @GET("/api/info.php")
        Call<CheckUpdate> get(
                @Query("api_version") int api_version,
                @Query("api_channel") int api_channel);
    }

    public interface SeasonalAPI {
        @GET("/api/seasonal.php")
        Call<List<Seasonal>> get(
                @Query("api_version") int api_version);
    }

    public interface EventAPI {
        @GET("/api/event.php")
        Call<Event> get(
                @Query("api_version") int api_version);
    }

    public interface SubtitleAPI {
        @GET("subtitle/detail/{shipId}")
        Call<List<ShipVoice>> getDetail(
                @Path("shipId") int shipId);

        @GET("subtitles/version")
        Call<Version> getVersion();
    }

}

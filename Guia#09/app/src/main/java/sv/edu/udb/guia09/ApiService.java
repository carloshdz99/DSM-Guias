package sv.edu.udb.guia09;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("{raza}/images")
    Call<DogsResponse> getDogsByBreed(@Path("raza") String raza);
}

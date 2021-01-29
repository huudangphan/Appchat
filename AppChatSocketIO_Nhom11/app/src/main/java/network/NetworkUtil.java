package network;

import android.util.Base64;

import com.sinhvien.appchatsocketio.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class NetworkUtil {
    public static RetrofitInterface getRetrofit(){
        RxJavaCallAdapterFactory rxAdapter=RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        return new Retrofit().Builder()
                .baseUrl(Constants.Base_url)
                .addCallAddapterFactory(rxAdapter)
                .addConvertFactory(GsonConverterFactory.create())
                .build().create(RetrofitInterface.class);

    }
    public static RetrofitInterface getRetrofit(String email, String password) {

        String credentials = email + ":" + password;
        final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(),Base64.NO_WRAP);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {

//            Request original = chain.request();
////            Request.Builder builder = original.newBuilder()
////                    .addHeader("Authorization", basic)
////                    .method(original.method(),original.body());
////            return  chain.proceed(builder.build());


        });
}



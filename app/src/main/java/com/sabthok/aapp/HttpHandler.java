    package com.sabthok.aapp;

    import android.content.Context;
    import android.os.AsyncTask;

    import com.squareup.okhttp.HttpUrl;
    import com.squareup.okhttp.OkHttpClient;
    import com.squareup.okhttp.Request;
    import com.squareup.okhttp.Response;

    import java.io.IOException;
    import java.util.concurrent.TimeUnit;

    import static com.hajiri.jolly.Common.DisplayLog;
    import static com.hajiri.jolly.Common.isNetworkAvailable;

    /**
     * Created by Aayush on 8/2/2015.
     */
    public class HttpHandler extends AsyncTask<Void, Void, Void> {

        private OkHttpClient client;
        private String Response;
        private Integer Status;
        private HttpUrl URL;
        private Boolean Success;
        protected Context context;

        public HttpHandler(Context context, String URL, String[] Path, String[] qHeaders, String[] qValues) {
            this.client = new OkHttpClient();
            this.client.setConnectTimeout(10, TimeUnit.SECONDS);
            this.client.setReadTimeout(10, TimeUnit.SECONDS);

            this.Status = -1;
            this.Response = "";
            this.context = context;

            HttpUrl.Builder urlBuilder = new HttpUrl.Builder();
            try {
                urlBuilder.scheme("http")
                        .host(URL);
            } catch (Exception e) {
                DisplayLog(getClass(), e.toString());
            }
            if (Path.length > 0)
                for (String path: Path)
                    urlBuilder.addPathSegment(path);

            if (qHeaders.length == qValues.length)
                for (int i = 0; i < qHeaders.length; i++)
                    if (qValues[i] != null) urlBuilder.addQueryParameter(qHeaders[i], qValues[i]);

            HttpUrl url = urlBuilder.build();
            DisplayLog(getClass(), "url:"+url);
            this.URL = url;
        }

        public HttpHandler(Context context, String URL, String[] Path) {
            this.client = new OkHttpClient();
            this.client.setConnectTimeout(10, TimeUnit.SECONDS);
            this.client.setReadTimeout(10, TimeUnit.SECONDS);

            this.Status = -1;
            this.Response = "";
            this.context = context;

            HttpUrl.Builder urlBuilder = new HttpUrl.Builder();
            try {
                urlBuilder.scheme("http")
                        .host(URL);
            } catch (Exception e) {
                DisplayLog(getClass(), e.toString());
            }
            if (Path.length > 0)
                for (String path: Path)
                    urlBuilder.addPathSegment(path);

            HttpUrl url = urlBuilder.build();
            DisplayLog(getClass(), "url:"+url);
            this.URL = url;
        }

        public String getResponse() {
            return Response;
        }

        public void setResponse(String response) {
            Response = response;
        }

        public Integer getResponseStatus() {
            return Status;
        }

        public void setResponseStatus(Integer status) {
            Status = status;
        }

        public Boolean getSuccess() {
            return Success;
        }

        public void setSuccess(Boolean success) {
            Success = success;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                if (isNetworkAvailable(context)) Run();
                DisplayLog(getClass(), "Async Process Completed");
            } catch (IOException e) {
                DisplayLog(getClass(), e.toString());
            }

            return null;
        }

        private void Run() throws IOException {
            Request request = new Request.Builder().url(URL).build();

            Response response = client.newCall(request).execute();

            this.Response = response.body().string();
            this.Status = response.code();
            this.Success = response.isSuccessful();

            DisplayLog(getClass(),"URL Loaded");
        }

        public HttpUrl getURL() {
            return URL;
        }

        public void setURL(HttpUrl URL) {
            this.URL = URL;
        }
    }

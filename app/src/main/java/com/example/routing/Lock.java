package com.example.routing;

public class Lock{

    public boolean isLocked = false;

    public synchronized void lock()
            throws InterruptedException{
        while(isLocked){
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}


/*void run(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                else {
                    final String myResponse = response.body().string();
                    List<HashMap<String, String>> places = null;
                    PlaceJSONParser placeJsonParser = new PlaceJSONParser();
                    try {
                        JSONObject json = new JSONObject(myResponse);
                        places = placeJsonParser.parse(json);
                    } catch (JSONException e) {

                    }
                    counter.add(places.size());
                    Log.d("In Run ", "counter=" + counter.count);
                }
            }
        });

    }*/
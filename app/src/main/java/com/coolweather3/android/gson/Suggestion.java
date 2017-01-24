package com.coolweather3.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/1/23 0023.
 */

public class Suggestion {

    @SerializedName("comf")
    public Comfort Comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{

        @SerializedName("txt")
        public String info;
    }

    public class CarWash{

        @SerializedName("txt")
        public String info;
    }

    public class  Sport{
        @SerializedName("txt")
        public String info;
    }
}

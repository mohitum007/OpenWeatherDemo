
package com.mohitum.openweatherdemo.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord implements Parcelable
{

    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("lat")
    @Expose
    private double lat;
    public final static Parcelable.Creator<Coord> CREATOR = new Creator<Coord>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Coord createFromParcel(Parcel in) {
            Coord instance = new Coord();
            instance.lon = ((double) in.readValue((double.class.getClassLoader())));
            instance.lat = ((double) in.readValue((double.class.getClassLoader())));
            return instance;
        }

        public Coord[] newArray(int size) {
            return (new Coord[size]);
        }

    }
    ;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lon);
        dest.writeValue(lat);
    }

    public int describeContents() {
        return  0;
    }

}

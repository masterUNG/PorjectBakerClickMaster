package piyawat.bakerclick.com.bakerclick.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class PromotionModel implements Parcelable{

    private String nameString;

    public PromotionModel() {
    }

    public PromotionModel(String nameString) {
        this.nameString = nameString;
    }

    protected PromotionModel(Parcel in) {
        nameString = in.readString();
    }

    public static final Creator<PromotionModel> CREATOR = new Creator<PromotionModel>() {
        @Override
        public PromotionModel createFromParcel(Parcel in) {
            return new PromotionModel(in);
        }

        @Override
        public PromotionModel[] newArray(int size) {
            return new PromotionModel[size];
        }
    };

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameString);
    }
}   // Main Class

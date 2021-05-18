package data.tv

import android.os.Parcel
import android.os.Parcelable



data class TvModel(val uuid: String?, val title: String?, val director: String?, val poster: String?, val age: String?,
                   val genre: String?, val duration: String?, val rating: Int, val category: String?, val release_date: String?,
                   val synopsis: String?) : Parcelable
{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uuid)
        parcel.writeString(title)
        parcel.writeString(director)
        parcel.writeString(poster)
        parcel.writeString(age)
        parcel.writeString(genre)
        parcel.writeString(duration)
        parcel.writeInt(rating)
        parcel.writeString(category)
        parcel.writeString(release_date)
        parcel.writeString(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvModel> {
        override fun createFromParcel(parcel: Parcel): TvModel {
            return TvModel(parcel)
        }

        override fun newArray(size: Int): Array<TvModel?> {
            return arrayOfNulls(size)
        }
    }

}
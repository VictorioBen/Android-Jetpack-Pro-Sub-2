package data.movies

import android.os.Parcel
import android.os.Parcelable



data class MovieModel(var uuid: String, var title: String, var director: String, var poster: String, var age: String,
                      var genre: String, var duration: String, var rating: Int, var category: String, var release_date: String,
                      var synopsis: String) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
            parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
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

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }

}
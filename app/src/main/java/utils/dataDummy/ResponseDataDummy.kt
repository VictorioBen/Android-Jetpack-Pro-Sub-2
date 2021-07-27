package utils.dataDummy

import source.remote.response.movie.MovieDetailResponse
import source.remote.response.movie.MovieResultItem
import source.remote.response.tv.TvResponseDetail
import source.remote.response.tv.TvResultsItem


object ResponseDataDummy {

    fun responseDummyMovies(): List<MovieResultItem> {

        val movies = ArrayList<MovieResultItem>()

        movies.add(
            MovieResultItem(
                202101,
                "A Star Is Born",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "2021-01-01",
                8.0
            )
        )

        movies.add(
            MovieResultItem(
                202102,
                "Alita: Battle Angel",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "2020-09-09",
                7.0

            )
        )

        movies.add(
            MovieResultItem(
                202103,
                "Aquaman",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "2019-01-02",
                5.5
            )
        )

        movies.add(
            MovieResultItem(
                202104,
                "Bohemian Rhapsody",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "2021-02-01",
                10.0

            )
        )

        movies.add(
            MovieResultItem(
                202105,
                "Cold Pursuit",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "08/02/2019",
                9.0

            )
        )

        movies.add(
            MovieResultItem(
                202106,
                "Creed",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "25/11/2015",
                7.0
            )
        )


        movies.add(
            MovieResultItem(
                202107,
                "The Crimes Of Grindelwald",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "16/11/2018",
                9.0
            )
        )

        movies.add(
            MovieResultItem(
                202108,
                "Glass",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "18/01/2019 ",
                6.5
            )
        )

        movies.add(
            MovieResultItem(
                202109,
                "Infinity War",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "27/04/2018",
                7.5
            )
        )

        movies.add(
            MovieResultItem(
                202110,
                "Master Z: IP Man Legacy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "17/02/2018",
                7.0
            )
        )

        return movies
    }

    fun responseDummyDetailMovies(): List<MovieDetailResponse> {
        val movieDetail = ArrayList<MovieDetailResponse>()

        movieDetail.add(
            MovieDetailResponse(
                "A Star Is Born",
                202101,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                120,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "2021-01-01",
                8.0,
                "Documentary",
                "released",
                "https://image.tmdb.org/t/p/original/keIxh0wPr2Ymj0Btjh4gW7JJ89e.jpg"
            )

        )

        movieDetail.add(
            MovieDetailResponse(
                "Alita: Battle Angel",
                202102,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                110,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "2020-09-09",
                7.0,
                "Anime",
                "released",
                "https://image.tmdb.org/t/p/original/8s4h9friP6Ci3adRGahHARVd76E.jpg"
            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Aquaman",
                202103,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                180,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "2019-01-02",
                5.5,
                "Action",
                "released",
                "https://image.tmdb.org/t/p/original/8s4h9friP6Ci3adRGahHARVd76E.jpg"
            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Bohemian Rhapsody",
                202104,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                60,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "2021-02-01",
                10.0,
                "Documentary",
                "released",
                "https://image.tmdb.org/t/p/original/tehpKMsls621GT9WUQie2Ft6LmP.jpg"


            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Cold Pursuit",
                202105,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                70,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "08/02/2019",
                9.0,
                "Action",
                "released",
                "https://image.tmdb.org/t/p/original/gX5UrH1TLVVBwI7WxplW43BD6Z1.jpg"


            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Creed",
                202106,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                90,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "25/11/2015",
                7.0,
                "Horror",
                "released",
                "https://image.tmdb.org/t/p/original/yizL4cEKsVvl17Wc1mGEIrQtM2F.jpg"
            )
        )


        movieDetail.add(
            MovieDetailResponse(
                "The Crimes Of Grindelwald",
                202107,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                110,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "16/11/2018",
                9.0,
                "Sci-fi",
                "released",
                "https://image.tmdb.org/t/p/original/620hnMVLu6RSZW6a5rwO8gqpt0t.jpg"
            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Glass",
                202108,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                118,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "18/01/2019 ",
                6.5,
                "Thriller",
                "released",
                "https://image.tmdb.org/t/p/original/3RMbkXS4ocMmoJyAD3ZsWbm32Kx.jpg"
            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Infinity War",
                202109,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                121,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "27/04/2018",
                7.5,
                "Action",
                "released",
                "https://image.tmdb.org/t/p/original/70AV2Xx5FQYj20labp0EGdbjI6E.jpg"
            )
        )

        movieDetail.add(
            MovieDetailResponse(
                "Master Z: IP Man Legacy",
                202110,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                140,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "17/02/2018",
                7.0,
                "Action",
                "released",
                "https://image.tmdb.org/t/p/original/wjQXZTlFM3PVEUmKf1sUajjygqT.jpg"
            )
        )

        return movieDetail
    }

    fun responseDummyTvShow(): List<TvResultsItem> {
        val tvShow = ArrayList<TvResultsItem>()

        tvShow.add(
            TvResultsItem(
                202111,
                "Arrow",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "1989",
                8.8
            )

        )

        tvShow.add(
            TvResultsItem(
                202112,
                "Doom Patrol",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
                "06/05/2017",
                5.5

            )
        )

        tvShow.add(
            TvResultsItem(
                202113,
                "Dragon Ball",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
                "04/08/2007",
                12.0

            )
        )

        tvShow.add(
            TvResultsItem(
                202114,
                "Fairy Tail",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lV07a5UwE75jVVuFN1GFEscN7if.jpg",
                "27/07/2007",
                9.9

            )
        )

        tvShow.add(
            TvResultsItem(
                202115,
                "Family Guy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xtIFsv0Wpy29Bw7i8gUm1L9x6x8.jpg",
                "31/07/2010",
                7.0

            )
        )

        tvShow.add(
            TvResultsItem(
                202116,
                "Gotham",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "2014",
                7.5

            )
        )

        tvShow.add(
            TvResultsItem(
                202117,
                "Hanna",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                "2019",
                6.0

            )
        )

        tvShow.add(
            TvResultsItem(
                202118,
                "The Flash",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "2012",
                4.0
            )
        )

        tvShow.add(
            TvResultsItem(
                202119,
                "Game of Thrones",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "2017",
                8.8

            )
        )

        tvShow.add(
            TvResultsItem(
                202120,
                "Grey\\'s Anatomy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "2019",
                8.6

            )
        )

        return tvShow
    }

    fun responseDummyTvDetail(): List<TvResponseDetail> {
        val tvShow = ArrayList<TvResponseDetail>()

        tvShow.add(
            TvResponseDetail(
                202111,
                "Arrow",
                "you are the one",
                "17/02/2018",
                2,
                1,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"
            )

        )

        tvShow.add(
            TvResponseDetail(
                202112,
                "Doom Patrol",
                "you are the two",
                "17/02/2018",
                2,
                3,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202113,
                "Dragon Ball",
                "you are the one",
                "17/02/2018",
                2,
                4,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202114,
                "Fairy Tail",
                "you are the one",
                "17/02/2018",
                2,
                5,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202115,
                "Family Guy",
                "you are the one",
                "17/02/2018",
                1,
                10,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202116,
                "Gotham",
                "you are the one",
                "17/02/2018",
                1,
                5,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202117,
                "Hanna",
                "you are the one",
                "17/02/2018",
                1,
                1,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202118,
                "The Flash",
                "you are the one",
                "17/02/2018",
                3,
                1,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"
            )
        )

        tvShow.add(
            TvResponseDetail(
                202119,
                "Game of Thrones",
                "you are the one",
                "17/02/2018",
                1,
                7,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        tvShow.add(
            TvResponseDetail(
                202120,
                "Grey\\'s Anatomy",
                "you are the one",
                "17/02/2018",
                1,
                13,
                listOf(45),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eget congue sapien. Vivamus vel arcu vehicula, gravida turpis a, pulvinar justo. Morbi efficitur magna ac magna sodales faucibus. Donec et orci quis nunc consectetur tincidunt vitae mollis diam. \n Curabitur dictum venenatis felis. Duis tempor magna nec velit lobortis, eu hendrerit justo auctor.",
                8.8,
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "https://image.tmdb.org/t/p/original/bZGAX8oMDm3Mo5i0ZPKh9G2OcaO.jpg"

            )
        )

        return tvShow
    }

}
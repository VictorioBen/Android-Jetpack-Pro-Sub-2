package utils

import data.movies.MovieEntity
import data.movies.MovieModel

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(
                "202101",
                "A Star Is Born",
                "Bradley Cooper",
                "@drawable/poster_one",
                "R",
                "Drama, Percintaan, Musik",
                "2H16M",
                75,
                "movie",
                "3/10/2018",
                "Seorang bintang musik country yang karirnya mulai memudar,Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini."
        ))

        movies.add(MovieEntity(
                "202102",
                "Alita: Battle Angel",
                "Robert Rodriguez",
                "@drawable/poster_two",
                "PG-13",
                "Aksi, Cerita Fiksi, Petualangan",
                "2H2M",
                72,
                "movie",
                "14/02/2019",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu."

        ))

        movies.add(MovieEntity(
                "202103",
                "Aquaman",
                "James Wan",
                "@drawable/poster_three",
                "PG-13",
                "Aksi, Petualangan, Fantasi",
                "2H23M",
                69,
                "movie",
                "7/12/2018",
                "Dulunya rumah bagi peradaban paling maju di Bumi, Atlantis sekarang menjadi kerajaan bawah air yang diperintah oleh Raja Orm yang haus kekuasaan. Dengan pasukan besar yang dimilikinya, Orm berencana untuk menaklukkan orang-orang samudra yang tersisa dan kemudian dunia permukaan. Yang menghalangi jalannya adalah Arthur Curry, saudara setengah manusia Orm, saudara setengah Atlantis dan pewaris sejati takhta."

        ))

        movies.add(MovieEntity(
                "202104",
                "Bohemian Rhapsody",
                "Brayn Singer",
                "@drawable/poster_four",
                "PG-13",
                "Musik, Drama, Sejara",
                "2H15M",
                80,
                "movie",
                "02/11/2018",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."


        ))

        movies.add(MovieEntity(
                "202105",
                "Cold Pursuit",
                "Hans Petter Moland",
                "@drawable/poster_five",
                "R",
                "Aksi, Kejahatan, Cerita Seru",
                "1H59M",
                57,
                "movie",
                "08/02/2019",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."

        ))

        movies.add(MovieEntity(
                "202106",
                "Creed",
                "Ryan Coolger",
                "@drawable/poster_six",
                "PG-13",
                "Drama",
                "2H13M",
                74,
                "movie",
                "25/11/2015",
                "Dulunya rumah bagi peradaban paling maju di Bumi, Atlantis sekarang menjadi kerajaan bawah air yang diperintah oleh Raja Orm yang haus kekuasaan. Dengan pasukan besar yang dimilikinya, Orm berencana untuk menaklukkan orang-orang samudra yang tersisa dan kemudian dunia permukaan. Yang menghalangi jalannya adalah Arthur Curry, saudara setengah manusia Orm, saudara setengah Atlantis dan pewaris sejati takhta."
        ))


        movies.add(MovieEntity(
                "202107",
                "The Crimes Of Grindelwald",
                "David Yates",
                "@drawable/poster_seven",
                "PG-13",
                "Petualangan, Fantasi, Drama",
                "1H22M",
                75,
                "movie",
                "16/11/2018",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
        ))

        movies.add(MovieEntity(
                "202109",
                "Infinity War",
                "Joe Russo",
                "@drawable/poster_nine",
                "PG-13",
                "Petualangan, Aksi, Cerita Fiksi",
                "2H29M",
                83,
                "movie",
                "27/04/2018",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti."

        ))

        movies.add(MovieEntity(
                "202110",
                "Master Z: IP Man Legacy",
                "Yuen Woo-ping",
                "@drawable/poster_ten",
                "R",
                "Aksi",
                "1H47M",
                60,
                "movie",
                "17/02/2018",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight."

        ))

        return movies
    }
}
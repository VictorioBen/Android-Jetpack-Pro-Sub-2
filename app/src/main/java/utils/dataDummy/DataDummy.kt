package utils.dataDummy

import com.submission.victorio_jetpackpro.R
import data.tv.TvShowEntity


object DataDummy {

//    fun generateDummyMovies(): List<MovieEntity> {
//
//        val movies = ArrayList<MovieEntity>()
//
//        movies.add(
//                MovieEntity(
//                        "202101",
//                        "A Star Is Born",
//                        "Bradley Cooper",
//                        R.drawable.poster_one,
//                        "R",
//                        "Drama, Percintaan, Musik",
//                        "2H16M",
//                        "75",
//                        "movie",
//                        "3/10/2018",
//                        "Seorang bintang musik country yang karirnya mulai memudar,Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini."
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202102",
//                        "Alita: Battle Angel",
//                        "Robert Rodriguez",
//                        R.drawable.poster_two,
//                        "PG-13",
//                        "Aksi, Cerita Fiksi, Petualangan",
//                        "2H2M",
//                        "72",
//                        "movie",
//                        "14/02/2019",
//                        "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu."
//
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202103",
//                        "Aquaman",
//                        "James Wan",
//                        R.drawable.poster_three,
//                        "PG-13",
//                        "Aksi, Petualangan, Fantasi",
//                        "2H23M",
//                        "69",
//                        "movie",
//                        "7/12/2018",
//                        "Dulunya rumah bagi peradaban paling maju di Bumi, Atlantis sekarang menjadi kerajaan bawah air yang diperintah oleh Raja Orm yang haus kekuasaan. Dengan pasukan besar yang dimilikinya, Orm berencana untuk menaklukkan orang-orang samudra yang tersisa dan kemudian dunia permukaan. Yang menghalangi jalannya adalah Arthur Curry, saudara setengah manusia Orm, saudara setengah Atlantis dan pewaris sejati takhta."
//
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202104",
//                        "Bohemian Rhapsody",
//                        "Brayn Singer",
//                        R.drawable.poster_four,
//                        "PG-13",
//                        "Music, Drama, Sejarah",
//                        "2H15M",
//                        "80",
//                        "movie",
//                        "02/11/2018",
//                        "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
//
//
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202105",
//                        "Cold Pursuit",
//                        "Hans Petter Moland",
//                        R.drawable.poster_five,
//                        "R",
//                        "Aksi, Kejahatan, Cerita Seru",
//                        "1H59M",
//                        "57",
//                        "movie",
//                        "08/02/2019",
//                        "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
//
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202106",
//                        "Creed",
//                        "Ryan Coolger",
//                        R.drawable.poster_six,
//                        "PG-13",
//                        "Drama",
//                        "2H13M",
//                        "74",
//                        "movie",
//                        "25/11/2015",
//                        "Dulunya rumah bagi peradaban paling maju di Bumi, Atlantis sekarang menjadi kerajaan bawah air yang diperintah oleh Raja Orm yang haus kekuasaan. Dengan pasukan besar yang dimilikinya, Orm berencana untuk menaklukkan orang-orang samudra yang tersisa dan kemudian dunia permukaan. Yang menghalangi jalannya adalah Arthur Curry, saudara setengah manusia Orm, saudara setengah Atlantis dan pewaris sejati takhta."
//                )
//        )
//
//
//        movies.add(
//                MovieEntity(
//                        "202107",
//                        "The Crimes Of Grindelwald",
//                        "David Yates",
//                        R.drawable.poster_seven,
//                        "PG-13",
//                        "Petualangan, Fantasi, Drama",
//                        "1H22M",
//                        "75",
//                        "movie",
//                        "16/11/2018",
//                        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202108",
//                        "Glass",
//                        "M. Night Shyamalan",
//                        R.drawable.poster_eight,
//                        "PG-13",
//                        "Cerita Seru, Drama, Cerita Fiksi",
//                        "2H9M",
//                        "67",
//                        "movie",
//                        "18/01/2019 ",
//                        "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
//
//
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202109",
//                        "Infinity War",
//                        "Joe Russo",
//                        R.drawable.poster_nine,
//                        "PG-13",
//                        "Petualangan, Aksi, Cerita Fiksi",
//                        "2H29M",
//                        "83",
//                        "movie",
//                        "27/04/2018",
//                        "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti."
//
//                )
//        )
//
//        movies.add(
//                MovieEntity(
//                        "202110",
//                        "Master Z: IP Man Legacy",
//                        "Yuen Woo-ping",
//                        R.drawable.poster_ten,
//                        "R",
//                        "Aksi",
//                        "1H47M",
//                        "60",
//                        "movie",
//                        "17/02/2018",
//                        "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight."
//
//                )
//        )
//
//        return movies
//    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
                TvShowEntity(
                        "202111",
                        "Dragon Ball Z",
                        "Akira Toriyama",
                        R.drawable.poster_eleven,
                        "TV-PG",
                        "Animation, Sci-fi & Fantasy",
                        "26m",
                        "82",
                        "Tv Show",
                        "1989",
                        "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans."

                )

        )

        tvShow.add(
                TvShowEntity(
                        "202112",
                        "Fairy Tail: Dragon Cry",
                        "Tatsuma Minamikawa",
                        R.drawable.poster_twelve,
                        "TV-15",
                        "Aksi, Komedi, Fantasi, Animasi",
                        "1H25M",
                        "65",
                        "Tv Show",
                        "06/05/2017",
                        "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction."

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202113",
                        "Naruto Shippuden the Movie",
                        "Hajime Kamegaki",
                        R.drawable.poster_thirteen,
                        "TV-12",
                        "Aksi, Petualangan, Animasi",
                        "1H34M",
                        "90",
                        "Tv Show",
                        "04/08/2007",
                        "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans. This time Naruto's mission is to guard Shion, but she predicts Naruto's death. The only way to escape it, is to get away from Shion, which would leave her unguarded, then the demon, whose only goal is to kill Shion will do so, thus meaning the end of the world. Naruto decides to challenge this."

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202114",
                        "The Simpsons Movie",
                        "David Silverman",
                        R.drawable.poster_fourteen,
                        "TV-14",
                        "Animasi, Komedi, Keluarga",
                        "1H27M",
                        "70",
                        "Tv Show",
                        "27/07/2007",
                        "After Homer accidentally pollutes the town's water supply, Springfield is encased in a gigantic dome by the EPA and the Simpsons are declared fugitives."

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202115",
                        "The Walking Dead",
                        "Constantine Nasr",
                        R.drawable.poster_fiveteen,
                        "TV-14",
                        "Zombie",
                        "30M",
                        "80",
                        "Tv Show",
                        "31/07/2010",
                        "The Making of the TV Series The Walking Dead."
                )
        )

        tvShow.add(
                TvShowEntity(
                        "202116",
                        "Gotham",
                        "Bruno Heller",
                        R.drawable.poster_sixteen,
                        "TV-13",
                        "Drama, Kejahatan, Sci-fi & Fantasy",
                        "43M",
                        "75",
                        "Tv Show",
                        "2014",
                        "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?"

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202117",
                        "Hanna",
                        "David Yates",
                        R.drawable.poster_seventeen,
                        "TV-MA",
                        "Aksi & Petualangan, Drama",
                        "50M",
                        "75",
                        "Tv Show",
                        "2019",
                        "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film."

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202118",
                        "The Arrow",
                        "Greg Berlanti",
                        R.drawable.poster_eighteen,
                        "TV-13",
                        "Crime, Drama, Mystery",
                        "42M",
                        "66",
                        "Tv Show",
                        "2012",
                        "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow"

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202119",
                        "Riverdale",
                        "Roberto Aguirre-Sacasa",
                        R.drawable.poster_nineteen,
                        "TV-14",
                        "Misteri, Drama, Kejahatan",
                        "45M",
                        "86",
                        "Tv Show",
                        "2017",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."

                )
        )

        tvShow.add(
                TvShowEntity(
                        "202120",
                        "Doom Patrol",
                        "Jeremy Carver",
                        R.drawable.poster_twenty,
                        "TV-MA",
                        "Sci-fi & Fantasy, Komedi, Drama",
                        "49M",
                        "76",
                        "Tv Show",
                        "2019",
                        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find."

                )
        )

        return tvShow
    }
}
package com.waterissue.sayangair.presentation.donation.component

sealed class Article(
    val image: String,
    val title: String,
    val description: String,
    val date: String,
    val recipient: String,
    val goal: String,
    val backgroundStory: String,
    val donationTarget: String,
    val donationMethod: String,
    val financialTransparency: String,
    val visualSupport: String,
    val contactInfo: String,
    val updatesAndThanks: String
) {
    object First : Article(
        image = "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1634025439/01h2fdww0jk9ftmeczfrxvt3fy.jpg",
        title = "Inovasi Teknologi Pemurnian Air untuk Masyarakat Sehat dan Bersih",
        description = "Bantu Masyarakat Mendapatkan Akses ke Air Bersih dengan Pendekatan Teknologi Terkini",
        date = "1 Januari 2023",
        recipient = "Masyarakat Umum",
        goal = "Rp 50.000.000",
        backgroundStory = "Proyek Inovasi Teknologi Pemurnian Air bertujuan untuk meningkatkan akses masyarakat terhadap air bersih. Dengan menggunakan teknologi terkini, kami berkomitmen untuk menyediakan solusi yang efisien dan berkelanjutan.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk pemurnian air dan distribusi ke wilayah terpencil yang kesulitan mengakses air bersih.",
        donationMethod = "Transfer Bank",
        financialTransparency = "Kami berkomitmen untuk mempublikasikan laporan keuangan secara berkala agar donatur dapat melihat penggunaan dana secara transparan.",
        visualSupport = "Dukungan visual proyek ini dapat dilihat melalui foto-foto kegiatan pemurnian air yang akan kami dokumentasikan.",
        contactInfo = "Hubungi kami melalui email: support@cleanwaterproject.com",
        updatesAndThanks = "Terima kasih atas dukungan Anda. Update terakhir: 5 Januari 2023. Semangat bersama untuk air bersih!"
    )

    object Second : Article(
        image = "https://cdn-assetd.kompas.id/byPZVkMDcmO6X1x-AlRCJoxhnBY=/1280x2275/filters:watermark(https://cdn-content.kompas.id/umum/kompas_main_logo.png,-16p,-13p,0)/https%3A%2F%2Fasset.kgnewsroom.com%2Fphoto%2Fpre%2F2023%2F09%2F16%2F4a12c3bf-dd67-4599-b5b9-c1979853996b_jpg.jpg",
        title = "Pembangunan Fasilitas Penyimpanan Air Tangguh untuk Mengatasi Bencana Kekeringan",
        description = "Cegah Bencana Kekeringan atau Simpan Cadangan Air dengan Pembangunan Fasilitas Modern",
        date = "15 Februari 2023",
        recipient = "Daerah Rawan Kekeringan",
        goal = "Rp 75.000.000",
        backgroundStory = "Proyek Pembangunan Fasilitas Penyimpanan Air bertujuan untuk menghadapi tantangan bencana kekeringan. Dengan membangun fasilitas modern, kami ingin menciptakan cadangan air yang dapat digunakan ketika kekeringan melanda.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk pembangunan dan pemeliharaan fasilitas penyimpanan air di daerah rawan kekeringan.",
        donationMethod = "Transfer Bank, Kartu Kredit",
        financialTransparency = "Kami berkomitmen untuk memberikan laporan keuangan terperinci dan memastikan setiap donasi digunakan dengan efisien.",
        visualSupport = "Dukungan visual proyek ini melibatkan foto-foto konstruksi dan kegiatan distribusi air bersih di daerah terdampak.",
        contactInfo = "Hubungi kami melalui email: info@droughtrescue.org",
        updatesAndThanks = "Terima kasih atas partisipasi Anda dalam mewujudkan solusi terhadap masalah kekeringan. Update terakhir: 20 Februari 2023. Bersama kita bisa!"
    )

    object Third : Article(
        image = "https://th.bing.com/th?id=OIP.AJ6QQZwZgplzG-9_KvGUOAHaE8&w=200&h=133&rs=1&qlt=80&o=6&dpr=1.1&pid=3.1",
        title = "Sistem Pemanenan Air Hujan: Memanfaatkan Air untuk Masa Depan yang Berkelanjutan",
        description = "Dukung Masa Depan yang Berkelanjutan dengan Pemanenan Air Hujan",
        date = "5 Maret 2023",
        recipient = "Komunitas Pedesaan",
        goal = "Rp 30.000.000",
        backgroundStory = "Proyek Sistem Pemanenan Air Hujan bertujuan untuk memanfaatkan sumber daya alam secara berkelanjutan. Kami akan membangun sistem pemanenan air hujan yang efisien dan ramah lingkungan untuk mendukung keberlanjutan komunitas pedesaan.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk membangun infrastruktur pemanenan air hujan dan penyuluhan bagi masyarakat.",
        donationMethod = "Transfer Bank",
        financialTransparency = "Kami akan secara transparan menyajikan laporan penggunaan dana secara berkala agar donatur merasa yakin dengan kontribusinya.",
        visualSupport = "Dokumentasi visual akan mencakup proses pembangunan dan manfaat dari sistem pemanenan air hujan ini.",
        contactInfo = "Hubungi kami melalui email: support@sustainablewaterproject.org",
        updatesAndThanks = "Terima kasih atas dukungan Anda untuk menciptakan masa depan yang lebih berkelanjutan. Update terakhir: 10 Maret 2023. Bersama kita, air menjadi kehidupan!"
    )

    object Fourth : Article(
        image = "https://th.bing.com/th?id=OIP.4aKTfkxnvSMYuHeBLIcoHgHaE4&w=80&h=80&c=1&vt=10&bgcl=21d247&r=0&o=6&dpr=1.1&pid=5.1",
        title = "Kampanye Sadar Air: Ajak Hemat dan Lindungi Sumber Daya Air Bersama-sama!",
        description = "Bergabung dalam Kampanye Hemat Air dan Lindungi Sumber Daya Air",
        date = "15 April 2023",
        recipient = "Seluruh Komunitas",
        goal = "Rp 20.000.000",
        backgroundStory = "Kampanye Sadar Air bertujuan untuk meningkatkan kesadaran masyarakat akan pentingnya hemat air dan perlindungan sumber daya alam. Kami akan menyelenggarakan berbagai kegiatan edukatif dan kampanye sosial untuk melibatkan seluruh komunitas.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk penyelenggaraan kampanye dan pembuatan materi edukasi.",
        donationMethod = "Transfer Bank, Donasi Online",
        financialTransparency = "Kami akan menyediakan informasi terperinci tentang penggunaan dana dan dampak dari kampanye ini secara berkala.",
        visualSupport = "Grafik dan video dukungan visual akan membantu menyampaikan pesan kampanye dengan lebih efektif.",
        contactInfo = "Hubungi kami melalui email: info@waterawarenesscampaign.org",
        updatesAndThanks = "Terima kasih telah menjadi bagian dari kampanye ini. Update terakhir: 20 April 2023. Mari bersama-sama jaga air, sumber kehidupan kita!"
    )

    object Fifth : Article(
        image = "https://www.bing.com/th?id=OIP.8jFNXRWw0OPhn-qbdJ_zUgAAAA&w=173&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.1&pid=3.1&rm=2",
        title = "Penanaman Pohon: Menghidupkan Hutan dan Melindungi Sumber Daya Air",
        description = "Selamatkan Hutan dan Lindungi Sumber Air dengan Penanaman Pohon",
        date = "20 Mei 2023",
        recipient = "Kawasan Hutan Terdegradasi",
        goal = "Rp 40.000.000",
        backgroundStory = "Proyek Penanaman Pohon bertujuan untuk menghidupkan kembali kawasan hutan terdegradasi dan melindungi sumber daya air. Kami akan melibatkan masyarakat dalam kegiatan penanaman pohon yang berkelanjutan.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk membeli bibit pohon, perawatan, dan pemeliharaan kawasan hutan.",
        donationMethod = "Transfer Bank, Donasi Langsung",
        financialTransparency = "Laporan keuangan akan diumumkan secara terbuka untuk memastikan akuntabilitas dan transparansi penggunaan dana.",
        visualSupport = "Dokumentasi visual akan menampilkan proses penanaman pohon dan perkembangan hutan dari waktu ke waktu.",
        contactInfo = "Hubungi kami melalui email: support@reforestationproject.org",
        updatesAndThanks = "Terima kasih telah berkontribusi dalam menjaga keberlanjutan hutan. Update terakhir: 25 Mei 2023. Mari bersama-sama lestarikan alam kita!"
    )

    object Six : Article(
        image = "https://www.bing.com/th?id=OIP.9wNK9Fcm1qcJ9ibZ1u2jUgHaEF&w=192&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.1&pid=3.1&rm=2",
        title = "Pendidikan dan Sosialisasi: Membangun Kesadaran akan Pentingnya Air Bersih",
        description = "Bantu Kami Membangun Kesadaran akan Pentingnya Air Bersih melalui Pendidikan dan Sosialisasi",
        date = "10 Juni 2023",
        recipient = "Sekolah dan Komunitas",
        goal = "Rp 25.000.000",
        backgroundStory = "Proyek Pendidikan dan Sosialisasi bertujuan untuk membangun kesadaran masyarakat akan pentingnya air bersih. Kami akan menyelenggarakan program-program edukatif di sekolah-sekolah dan komunitas untuk membentuk perilaku hemat air sejak dini.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk menyelenggarakan kegiatan edukatif, membuat materi pembelajaran, dan menyediakan sumber daya bagi sekolah dan komunitas.",
        donationMethod = "Transfer Bank, Donasi Langsung",
        financialTransparency = "Kami akan memastikan transparansi penuh dengan menyajikan laporan keuangan secara terbuka dan terperinci setiap bulan.",
        visualSupport = "Grafik, video pembelajaran, dan dokumentasi kegiatan akan kami bagikan untuk memberikan gambaran nyata tentang dampak dari program ini.",
        contactInfo = "Hubungi kami melalui email: info@watereducationproject.org",
        updatesAndThanks = "Terima kasih atas dukungan Anda dalam membangun kesadaran akan pentingnya air bersih. Update terakhir: 15 Juni 2023. Bersama kita, mari edukasi generasi masa depan!"
    )

    object Seven : Article(
        image = "https://th.bing.com/th/id/OIP.xDe_UYkBHULr5s22u65u-gHaE8?w=200&h=183&c=7&r=0&o=5&dpr=1.1&pid=1.7",
        title = "Penelitian dan Pengembangan: Mencari Solusi Baru untuk Pengelolaan Air yang Efektif",
        description = "Dukung Penelitian dan Pengembangan kami untuk Menemukan Solusi Baru dalam Pengelolaan Air",
        date = "5 Juli 2023",
        recipient = "Komunitas Ilmiah dan Pengelolaan Sumber Daya Alam",
        goal = "Rp 60.000.000",
        backgroundStory = "Proyek Penelitian dan Pengembangan bertujuan untuk mencari solusi inovatif dalam pengelolaan air. Kami akan melakukan riset terkini dan mengembangkan teknologi efektif untuk menjaga ketersediaan air.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk biaya riset, pengembangan teknologi, dan pelibatan komunitas ilmiah.",
        donationMethod = "Transfer Bank, Donasi Online",
        financialTransparency = "Laporan keuangan akan diumumkan secara terbuka dan akuntabel setiap bulan.",
        visualSupport = "Dukungan visual akan mencakup gambaran proses penelitian, prototipe teknologi, dan dampak positif yang dihasilkan.",
        contactInfo = "Hubungi kami melalui email: research@watermanagementproject.org",
        updatesAndThanks = "Terima kasih atas kontribusi Anda dalam mencari solusi baru untuk pengelolaan air. Update terakhir: 10 Juli 2023. Bersama-sama, mari menciptakan masa depan yang berkelanjutan!"
    )

    object Eight : Article(
        image = "https://indonesia.go.id/assets/upload/headline/airgsfjnf_thumb.jpeg",
        title = "Kerjasama dengan Pemerintah dan Swasta: Bersinergi untuk Menjaga Ketersediaan Air",
        description = "Dukung Kerjasama Kami dengan Pemerintah dan Swasta untuk Menjaga Ketersediaan Air",
        date = "15 Agustus 2023",
        recipient = "Pemerintah Daerah dan Sektor Swasta",
        goal = "Rp 50.000.000",
        backgroundStory = "Proyek Kerjasama dengan Pemerintah dan Swasta bertujuan untuk menciptakan sinergi dalam menjaga ketersediaan air. Kami akan bekerja sama dengan pemerintah daerah dan sektor swasta untuk pengelolaan air yang lebih efektif.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk mendukung program-program kerjasama, seminar, dan pengembangan kebijakan air.",
        donationMethod = "Transfer Bank, Kerjasama Bisnis",
        financialTransparency = "Laporan keuangan akan diumumkan secara berkala dan terbuka untuk memberikan gambaran transparan penggunaan dana.",
        visualSupport = "Visualisasi proyek, foto pertemuan, dan dokumentasi kolaborasi akan kami bagikan untuk memperlihatkan perkembangan dan dampak kerjasama ini.",
        contactInfo = "Hubungi kami melalui email: partnership@waterconservationproject.org",
        updatesAndThanks = "Terima kasih atas dukungan Anda dalam membangun sinergi dengan pemerintah dan swasta. Update terakhir: 20 Agustus 2023. Mari bersama-sama jaga ketersediaan air di komunitas kita!"
    )

    object Nine : Article(
        image = "https://cdn.medcom.id/dynamic/content/2023/09/29/1617392/ae24CwWKnL.jpg?w=1024",
        title = "Bantuan Darurat: Mendukung Masyarakat yang Terdampak Kekeringan",
        description = "Bantu Kami Memberikan Bantuan Darurat untuk Masyarakat Terdampak Kekeringan",
        date = "1 September 2023",
        recipient = "Masyarakat Terdampak Bencana",
        goal = "Rp 15.000.000",
        backgroundStory = "Proyek Bantuan Darurat bertujuan untuk memberikan dukungan cepat dan tepat kepada masyarakat yang terdampak kekeringan. Kami akan menyediakan air bersih, kebutuhan dasar, dan dukungan psikososial.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk pembelian air bersih, kebutuhan dasar, dan program rehabilitasi masyarakat.",
        donationMethod = "Transfer Bank, Donasi Langsung",
        financialTransparency = "Laporan keuangan akan disajikan secara terbuka untuk memberikan informasi yang jelas mengenai penggunaan dana donasi.",
        visualSupport = "Dokumentasi visual akan mencakup proses distribusi bantuan dan kegiatan rehabilitasi masyarakat.",
        contactInfo = "Hubungi kami melalui email: emergencyrelief@waterassistance.org",
        updatesAndThanks = "Terima kasih telah menjadi pahlawan bagi mereka yang membutuhkan. Update terakhir: 5 September 2023. Bersama kita, mari bantu masyarakat pulih dari dampak kekeringan!"
    )

    object Ten : Article(
        image = "https://asset-a.grid.id//crop/0x0:0x0/700x465/photo/2023/11/22/upaya-pelestarian-sumber-daya-ai-20231122023816.jpg",
        title = "Pelestarian Sumber Daya Air: Lindungi dan Jaga Keseimbangan Ekosistem Air",
        description = "Lindungi Sumber Daya Air untuk Masa Depan dengan Langkah-langkah Pelestarian dan Pengelolaan yang Berkelanjutan",
        date = "15 Agustus 2023",
        recipient = "Seluruh Ekosistem",
        goal = "Rp 50.000.000",
        backgroundStory = "Proyek Pelestarian Sumber Daya Air bertujuan untuk melindungi dan menjaga keseimbangan ekosistem air. Kami akan melakukan berbagai kegiatan pelestarian, termasuk penghijauan, pemantauan kualitas air, dan kampanye kesadaran lingkungan.",
        donationTarget = "Dana yang terkumpul akan digunakan untuk melaksanakan program pelestarian, pemantauan ekosistem, dan kampanye edukasi lingkungan.",
        donationMethod = "Transfer Bank, Donasi Langsung",
        financialTransparency = "Laporan keuangan akan diumumkan secara terbuka untuk memberikan visibilitas penuh kepada para donatur.",
        visualSupport = "Dokumentasi visual akan mencakup foto dan video kegiatan pelestarian serta hasil pemantauan ekosistem.",
        contactInfo = "Hubungi kami melalui email: conservation@watersustainability.org",
        updatesAndThanks = "Terima kasih atas dukungan Anda dalam menjaga keseimbangan ekosistem air. Update terakhir: 20 Agustus 2023. Bersama-sama kita lindungi sumber daya air untuk generasi mendatang!"
    )
}
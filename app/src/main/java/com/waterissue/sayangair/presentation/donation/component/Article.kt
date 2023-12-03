package com.waterissue.sayangair.presentation.donation.component

sealed class Article(
    val image: String,
    val title: String,
    val description: String
) {
    object First : Article(
        image = "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1634025439/01h2fdww0jk9ftmeczfrxvt3fy.jpg",
        title = "Inovasi Teknologi Pemurnian Air untuk Masyarakat Sehat dan Bersih",
        description = "Bantu Masyarakat Mendapatkan Akses ke Air Bersih dengan Pendekatan Teknologi Terkini"
    )

    object Second : Article(
        image = "https://cdn-assetd.kompas.id/byPZVkMDcmO6X1x-AlRCJoxhnBY=/1280x2275/filters:watermark(https://cdn-content.kompas.id/umum/kompas_main_logo.png,-16p,-13p,0)/https%3A%2F%2Fasset.kgnewsroom.com%2Fphoto%2Fpre%2F2023%2F09%2F16%2F4a12c3bf-dd67-4599-b5b9-c1979853996b_jpg.jpg",
        title = "Pembangunan Fasilitas Penyimpanan Air Tangguh untuk Mengatasi Bencana Kekeringan",
        description = "Cegah Bencana Kekeringan atau Simpan Cadangan Air dengan Pembangunan Fasilitas Modern"
    )

    object Third : Article(
        image = "https://th.bing.com/th?id=OIP.AJ6QQZwZgplzG-9_KvGUOAHaE8&w=200&h=133&rs=1&qlt=80&o=6&dpr=1.1&pid=3.1",
        title = "Sistem Pemanenan Air Hujan: Memanfaatkan Air untuk Masa Depan yang Berkelanjutan",
        description = "Manfaatkan Air Hujan untuk Mendukung Ketersediaan Air di Masa Depan dengan Sistem Pemanenan yang Efisien"
    )

    object Fourth : Article(
        image = "https://th.bing.com/th?id=OIP.4aKTfkxnvSMYuHeBLIcoHgHaE4&w=80&h=80&c=1&vt=10&bgcl=21d247&r=0&o=6&dpr=1.1&pid=5.1",
        title = "Kampanye Sadar Air: Ajak Hemat dan Lindungi Sumber Daya Air Bersama-sama!",
        description = "Bergabung dalam Kampanye Hemat Air dan Lindungi Sumber Daya Air untuk Menjaga Bumi yang Lebih Baik"
    )

    object Fifth : Article(
        image = "https://www.bing.com/th?id=OIP.8jFNXRWw0OPhn-qbdJ_zUgAAAA&w=173&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.1&pid=3.1&rm=2",
        title = "Penanaman Pohon: Menghidupkan Hutan dan Melindungi Sumber Daya Air",
        description = "Selamatkan Hutan atau Lindungi Sumber Air dengan Program Penanaman Pohon yang Berkelanjutan"
    )

    object Six : Article(
        image = "https://www.bing.com/th?id=OIP.9wNK9Fcm1qcJ9ibZ1u2jUgHaEF&w=192&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.1&pid=3.1&rm=2",
        title = "Pendidikan dan Sosialisasi: Membangun Kesadaran akan Pentingnya Air Bersih",
        description = "Edukasi Masyarakat tentang Pentingnya Air Bersih untuk Kesehatan dan Kehidupan yang Lebih Baik"
    )

    object Seven : Article(
        image = "https://th.bing.com/th/id/OIP.xDe_UYkBHULr5s22u65u-gHaE8?w=200&h=183&c=7&r=0&o=5&dpr=1.1&pid=1.7",
        title = "Penelitian dan Pengembangan: Mencari Solusi Baru untuk Pengelolaan Air yang Efektif",
        description = "Mendukung Penelitian dan Pengembangan untuk Menemukan Solusi Terbaru dalam Pengelolaan Air yang Berkelanjutan"
    )

    object Eight : Article(
        image = "https://indonesia.go.id/assets/upload/headline/airgsfjnf_thumb.jpeg",
        title = "Kerjasama dengan Pemerintah dan Swasta: Bersinergi untuk Menjaga Ketersediaan Air",
        description = "Berkolaborasi dengan Pemerintah dan Sektor Swasta untuk Menjaga Ketersediaan Air di Seluruh Komunitas"
    )

    object Nine : Article(
        image = "https://cdn.medcom.id/dynamic/content/2023/09/29/1617392/ae24CwWKnL.jpg?w=1024",
        title = "Bantuan Darurat: Mendukung Masyarakat yang Terdampak Kekeringan",
        description = "Bantu Masyarakat yang Mengalami Krisis Air dengan Program Bantuan Darurat yang Cepat dan Tepat"
    )

    object Ten : Article(
        image = "https://asset-a.grid.id//crop/0x0:0x0/700x465/photo/2023/11/22/upaya-pelestarian-sumber-daya-ai-20231122023816.jpg",
        title = "Pelestarian Sumber Daya Air: Lindungi dan Jaga Keseimbangan Ekosistem Air",
        description = "Lindungi Sumber Daya Air untuk Masa Depan dengan Langkah-langkah Pelestarian dan Pengelolaan yang Berkelanjutan"
    )
}

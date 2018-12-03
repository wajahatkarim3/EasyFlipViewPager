package com.wajahatkarim3.easyflipviewpager.demo

import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer
import me.relex.circleindicator.CircleIndicator

class PictureGalleryDemoActivity : AppCompatActivity() {

    lateinit var galleryViewPager: ViewPager
    lateinit var pagerAdapter: GalleryPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_gallery_demo)

        galleryViewPager = findViewById(R.id.galleryViewPager)
        pagerAdapter = GalleryPagerAdapter(supportFragmentManager)
        galleryViewPager.adapter = pagerAdapter

        var pageIndicator = findViewById<CircleIndicator>(R.id.indicator)
        pageIndicator.setViewPager(galleryViewPager)

        var pageTransformer = CardFlipPageTransformer()
        pageTransformer.flipOrientation = CardFlipPageTransformer.VERTICAL
        pageTransformer.isScalable = true
        galleryViewPager.setPageTransformer(true, pageTransformer)
    }

    class GalleryPagerAdapter : FragmentPagerAdapter
    {
        var fragmentsList = arrayListOf<GalleryImageFragment>()

        constructor(fm: FragmentManager) : super(fm)
        {
            val titles = arrayOf(
                    "Naltar valley, Gilgit",
                    "Neelum Valley, Azad Kashmir",
                    "Shangrila resort, Skardu",
                    "Gojal Valley, Khunjerab",
                    "Deosai Plains",
                    "Rama Meadow",
                    "Ayun Valley, Chitral",
                    "Ghanche District, Gilgit–Baltistan",
                    "Ranikot Fort",
                    "Gorak Hill"
            )

            val subtitles = arrayOf(
                    // Naltar
                    "Naltar is famous for its colourful lakes, it is situated at a drive of 2.5 hours from Gilgit. World’s tastiest potatoes are cultivated here. Covered with pine trees, this valley doesn’t seem to be a part of this world.\n" +
                            "\n" +
                            "If you really want to experience paradise in this world, you should visit Naltar at least once. This place will make you fall in love with it.",

                    // Neelum
                    "Opposite to the Keran sector of Indian-held Kashmir. From the Chella Bandi Bridge – just north of Azaad Kashmir’s capital Muzaffarabad – to Tau Butt, a valley stretches out for 240 kilometres; it is known as the Neelum Valley (literally, the Blue Gem Valley).\n" +
                            "\n" +
                            "Neelum is one of the most beautiful valleys of Azaad Kashmir, and it hosts several brooks, freshwater streams, forests, lush green mountains, and a river. Here, you see cataracts falling down the mountains; their milky-white waters flowing over the roads and splashing against the rocks, before commingling with the muddy waters of River Neelum.",

                    // Shangrila
                    "In the extreme north of Pakistan, Skardu the central valley of Gilgit-Baltistan, is an epitome of beauty, serenity and wilderness.\n" +
                            "\n" +
                            "After Jaglot on the Karakoram Highway, a narrow road turns towards Skardu. During the seven-hour journey, one is greeted with several streams, springs, and the hospitality of the local people.\n" +
                            "\n" +
                            "After crossing the old wooden bridge built over the River Indus, one reaches Shangrila, a paradise on earth for tourists. It is a famous tourist spot in Skardu, which is about 25 minutes away by drive.",

                    // Gojal
                    "The Gojal Valley borders China and Afghanistan, with its border meeting the Chinese border at Khunjerab — 15,397 feet above sea level — and remains covered with snow all year long.\n" +
                            "\n" +
                            "In the north west, there is Chiporsun, whose border touches the Wakhan region of Afghanistan. Wakhan is about six square miles in area, after which starts Tajikistan. The Karakoram Highway which connects Pakistan to China also passes through Gojal Valley and enters China at Khunjerab.",

                    // Deosai
                    "Deosai is located on the boundary of Karakoram and the western Himalayas, and at no point it is less than 4000 meters above sea level. It remains covered with snow for 8 months. The rest of the year, it hosts a range of beautiful flowers of all hues and colours, but not a single tree is found in this plateau spread over 3000 sq. km.\n" +
                            "\n" +
                            "Sheosar lake is also part of this. This lake is one of the highest lakes in the world. The deep blue water, with snow-covered mountains in backdrop, and greenery with wild flowers in foreground offer such a view in summers, that one is left amused for the rest of his life.",

                    // Rama
                    "Just a little ahead of Rama Village, which is 11 kilometres from Astore, is a beautiful and serene plain called Rama Meadow.\n" +
                            "\n" +
                            "If you ever happen to find yourself in plain, ice-cold and milk-white water flowing in streams, sheep and cows grazing in peace, pine trees, Chongra’s ice-covered peak in background, and Nanga Parbat’s southern ridge is in view, then you are probably in Rama Meadow.",

                    // Ayun and Bamburet
                    "Ayun district is a village of Chitral. Located 12 kilometres south of the city at the confluence of the River Bamburet . There are no words to describe the beauty of the mountains surrounding the village. Beyond Ayun valley is Bamburet Valley, it is one of the three Kalash valleys.\n" +
                            "\n" +
                            "Bamburet is nearly two-hour journey from Chitral. Locals trace their roots to Alexander the Great and Greece. Bamburet valley is a picturesque valley with lush greenery and mountains that give you a sense of calm and solitude.",

                    // Ghanche
                    "Gilgit-Baltistan's Ghanche district stands almost aloof with its beautiful valleys and settlements inhabited by the most hospitable locals and river irrigated lands. The central location in the district is Khaplu, which is a beautiful landscape with high summits, flowing blue waters and waterfalls.\n" +
                            "\n" +
                            "The people of this small settlement on the bank of River Shyok, are warm and loving, as they were centuries before.\n" +
                            "\n" +
                            "Going a little ahead from Khaplu, the curvy road takes one to the delta of River Shyok, where it splits up, flowing through the gravel filled river plain.",

                    // Ranikot
                    "Ranikot, with a circumference of about 26 km, is the largest fort in the world. However, this has not been enough to convince the authorities to develop it as a major tourist attraction.\n" +
                            "\n" +
                            "This fort is easily accessible from Karachi through the National Highway. After departing from Karachi, head to Dadu through on the Indus Highway. The road is in excellent condition. It's an hour-long journey to San, the home of Sindhi nationalist, GM Syed. A little further from the town there comes a diversion. A rusty board announces that Ranikot is some 30 km away. Even though the road is in pathetic condition, the distance can be covered in 30 to 40 minutes.",

                    // Gorakh
                    "Snowfall in Sindh — sounds more like fantasy but no, there’s one place in Sindh where it really snows in winter, to the extent that in 2008 the mountains got entirely covered with a layer of snow.\n" +
                            "\n" +
                            "Gorakh is a scenic plateau situated at a height of over 5,688 feet and is part of the Kirthar Mountain Range that covers the entire Sindh’s border with Balochistan in the west."
            )

            val imageIds = intArrayOf(
                    R.drawable.img_naltar_valley,
                    R.drawable.img_neelum_valley,
                    R.drawable.img_shangrila,
                    R.drawable.img_gojal_valley,
                    R.drawable.img_deosai_plains,
                    R.drawable.img_rama_meadow,
                    R.drawable.img_ayun_valley,
                    R.drawable.img_ghanche,
                    R.drawable.img_ranikot,
                    R.drawable.img_gorakh_hill
            )

            for (i in 0 until imageIds.size)
            {
                var frag = GalleryImageFragment.newInstance(titles[i], subtitles[i], imageIds[i])
                fragmentsList.add(frag)
            }
        }

        override fun getItem(position: Int): Fragment = fragmentsList[position]

        override fun getCount() = fragmentsList.size

    }
}

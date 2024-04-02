package com.example.recycleviewactivity

import kotlin.random.Random

object Data {
    private val titles = arrayOf(
        "Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven", "Chapter Eight"
    )

    private val detailsList = arrayOf(
        "Item One Details", "Item Two Details", "Item Three Details", "Item Four Details",
        "Item Five Details", "Item Six Details", "Item Seven Details", "Item Eight Details"
    )

    private val imagesList = intArrayOf(
        R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6,
        R.drawable.android_image_7, R.drawable.android_image_8
    )

    fun getRandomChapter(): Triple<String, String, Int> {
        val randomIndex = Random.nextInt(titles.size)
        val randomDetail = detailsList.random()
        val randomImage = imagesList.random()
        return Triple(titles[randomIndex], randomDetail, randomImage)
    }
}

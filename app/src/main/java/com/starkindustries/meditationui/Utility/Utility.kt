package com.starkindustries.meditationui.Utility

import com.starkindustries.meditationui.Data.FeautuesData
import com.starkindustries.meditationui.R

class Utility {
    companion object{
        fun getFeauturesData():List<FeautuesData>{
          var feauturesList = listOf(FeautuesData("Sleep Meditation", R.drawable.video_camera,R.drawable.blue_bg),
              FeautuesData("Tips for Sleeping", R.drawable.video_camera,R.drawable.green_background),
              FeautuesData("Night Island", R.drawable.headphone,R.drawable.orange_background),
              FeautuesData("Calming Sounds", R.drawable.video_camera,R.drawable.red_background))
            return feauturesList
        }
    }
}
package com.example.snapchekad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnappUI()
        }
    }
}

@Preview(
    showBackground = true,
    name = "Snapp",
    widthDp = 400,
    heightDp = 800
)
@Composable
private fun SnappUI() {

    Box {

        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {

            SpacerHeight(40)
            TopItems()

            SpacerHeight(30)
            BannerItem(R.drawable.banner)

            SpacerHeight(30)
            FruitItems()

            SpacerHeight(30)
            BannerItem(R.drawable.banner)
            SpacerHeight(20)

        }

        Box(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomItem()
        }

    }

}

@Composable
private fun SpacerHeight(height: Int) {
    Spacer(Modifier.height(height.dp))
}

@Composable
private fun SpacerWidth(width: Int) {
    Spacer(Modifier.width(width.dp))
}

@Composable
private fun TopItems() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CreatorItem(R.drawable.food, "غذا")
            SpacerHeight(20)
            CreatorItem(R.drawable.bike, "اسنپ باکس")
            SpacerHeight(20)
            CreatorItem(R.drawable.credit, "اسنپ پی")

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CreatorItem(R.drawable.taxi, "اسنپ")
            SpacerHeight(20)
            CreatorItem(R.drawable.hotel, "هتل")
            SpacerHeight(20)
            CreatorItem(R.drawable.pickup, "وانت")

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CreatorItem(R.drawable.doctor, "دکتر")
            SpacerHeight(20)
            CreatorItem(R.drawable.moving, "کامیون")
            SpacerHeight(20)
            CreatorItem(R.drawable.food, "غذا")

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CreatorItem(R.drawable.credit, "اسنپ پی")
            SpacerHeight(20)
            CreatorItem(R.drawable.food, "غذا")
            SpacerHeight(20)
            CreatorItem(R.drawable.bike, "اسنپ باکس")

        }

    }

}

@Composable
private fun CreatorItem(imageID: Int, title: String) {

    Image(
        painter = painterResource(imageID),
        contentDescription = "",
        modifier = Modifier.size(45.dp)
    )

    Text(
        title,
        fontSize = 12.sp
    )

}

@Composable
private fun BannerItem(imageID: Int) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(imageID),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
private fun FruitItems() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(
                rememberScrollState(),
                reverseScrolling = true
            )
    ) {

        for (i in 1..10) {

            Surface(
                modifier = Modifier.padding(2.dp),
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 6.dp
            ) {
                Image(
                    painter = painterResource(R.drawable.banana),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
            }

            SpacerWidth(16)

        }

    }

}

@Composable
private fun BottomItem(){

    Card(
        modifier = Modifier
            .padding(2.dp)
            .width(280.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Row(
            Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreatorItem(R.drawable.food, "غذا")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreatorItem(R.drawable.credit, "اسنپ پی")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreatorItem(R.drawable.hotel, "هتل")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreatorItem(R.drawable.taxi, "اسنپ")
            }

        }

    }


}
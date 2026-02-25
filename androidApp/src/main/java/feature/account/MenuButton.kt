package feature.account

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multibabydiaryapp.android.ScreenTransitionListener
import com.example.multibabydiaryapp.android.coredesign.DarkBrown
import com.example.multibabydiaryapp.android.coredesign.White


@Composable
fun MenuButton(
    mainTitle: String,
    subTitle: String = "",
    packageName: String = "",
    httpsUrl: String = ""
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBrown)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                mainTitle = mainTitle,
                subTitle = subTitle,
                packageName = packageName,
                httpsUrl = httpsUrl,
            )
            ArrowBackImage()
        }
    }
}


@Composable
fun TextButton(
    mainTitle: String,
    subTitle: String = "",
    packageName: String = "",
    httpsUrl: String = "",
    screenName: String = "",
    viewModel: AccountViewModel? = null,
    screenTransitionListener: ScreenTransitionListener? = null
) {
    val context = LocalContext.current
    Column(modifier = Modifier
        .clickable {
            if (mainTitle == "めいたん") {
                viewModel?.getUserByName()
            }
            if (mainTitle == "赤ちゃんの追加・編集") {
                viewModel?.createUser(1)
            }
            if (packageName.isNotEmpty()) {
                val appUrl = "market://details?id=$packageName"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(appUrl)
                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    intent.data =
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    context.startActivity(intent)
                }
            } else if (httpsUrl.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(httpsUrl)
                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    intent.data =
                        Uri.parse(httpsUrl)
                    context.startActivity(intent)
                }
            } else if (screenName.isNotEmpty()) {
                screenTransitionListener?.transitionListener(screenName)
            }
        }) {
        Text(
            text = mainTitle, color = White
        )
        if (subTitle.isNotEmpty()) {
            Text(
                text = subTitle,
                color = White,
                style = TextStyle(fontSize = 12.sp)
            )
        }
    }
}

@Composable
fun ArrowBackImage() {
    Icon(
        painter = rememberVectorPainter(image = Icons.Default.KeyboardArrowRight),
        contentDescription = null,
        tint = Color.White
    )
}
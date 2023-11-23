package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticlePage()
                }
            }
        }
    }
}

@Composable
fun ArticlePage(){
    Article(title = stringResource(R.string.article_title),
            subtitle = stringResource(R.string.article_subtitle),
            body = stringResource(R.string.article_body) )
}

@Composable
fun Article(title: String = "Title", subtitle: String, body: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
Column(modifier = modifier){
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
    Text(
        text = title,
        fontSize=24.sp,
        modifier = Modifier.padding(16.dp)

    )
    Text(
        text = subtitle,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
    Text(
        text = body,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
}

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article(subtitle = "something",body = "something else", title = "jetpack compose")
    }
}
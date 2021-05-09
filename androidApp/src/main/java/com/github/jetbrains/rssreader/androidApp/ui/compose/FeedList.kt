package com.github.jetbrains.rssreader.androidApp.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.jetbrains.rssreader.core.entity.Feed
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun FeedItemList(
    feeds: List<Feed>,
    onClick: (Feed) -> Unit
) {
    LazyColumn {
        itemsIndexed(feeds) { i, feed ->
            if (i == 0) Spacer(modifier = Modifier.statusBarsHeight())
            FeedItem(feed) { onClick(feed) }
        }
    }
}

@Composable
fun FeedItem(
    feed: Feed,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .clickable(onClick = onClick, enabled = !feed.isDefault)
            .padding(16.dp)
    ) {
        FeedIcon(feed = feed)
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(
                style = MaterialTheme.typography.body1,
                text = feed.title
            )
            Text(
                style = MaterialTheme.typography.body2,
                text = feed.desc
            )
        }
    }
}

@Preview
@Composable
private fun FeedItemPreview() {
    AppTheme {
        FeedItem(feed = PreviewData.feed) {}
    }
}
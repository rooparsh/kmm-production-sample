package com.github.jetbrains.rssreader.core.datasource.network

import com.github.jetbrains.rssreader.core.entity.FeedData
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

internal class FeedLoader(
    private val httpClient: HttpClient,
    private val parser: FeedParser
) {
    suspend fun getFeedData(url: String): FeedData {
        val xml = httpClient.get<HttpResponse>(url).readText()
        return parser.parse(url, xml)
    }
}
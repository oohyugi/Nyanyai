package com.oohyugi.nyanyai.model

import com.google.gson.annotations.SerializedName

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
object MusicModel {

    data class BaseMdl(@SerializedName("message")
                       val message: MessageMdl)

    data class BodyMdl(@SerializedName("track_list")
                       val trackList: List<TrackListItemMdl>?)
    data class HeaderMdl(@SerializedName("status_code")
                         val statusCode: Int = 0,
                         @SerializedName("execute_time")
                         val executeTime: Double = 0.0,
                         @SerializedName("available")
                         val available: Int = 0)
    data class MessageMdl(@SerializedName("header")
                          val header: HeaderMdl,
                          @SerializedName("body")
                          val body: BodyMdl)
    data class MusicGenreListItemMdl(@SerializedName("music_genre")
                                     val musicGenre: MusicGenreMdl)
    data class MusicGenreMdl(@SerializedName("music_genre_id")
                             val musicGenreId: Int = 0,
                             @SerializedName("music_genre_vanity")
                             val musicGenreVanity: String = "",
                             @SerializedName("music_genre_parent_id")
                             val musicGenreParentId: Int = 0,
                             @SerializedName("music_genre_name_extended")
                             val musicGenreNameExtended: String = "",
                             @SerializedName("music_genre_name")
                             val musicGenreName: String = "")
    data class PrimaryGenresMdl(@SerializedName("music_genre_list")
                                val musicGenreList: List<MusicGenreListItemMdl>?)
//    data class SecondaryGenresMdl()

    data class TrackListItemMdl(@SerializedName("track")
                                val track: TrackMdl)
    data class TrackMdl(@SerializedName("updated_time")
                        val updatedTime: String = "",
                        @SerializedName("track_share_url")
                        val trackShareUrl: String = "",

                        @SerializedName("artist_name")
                        val artistName: String = "",
                        @SerializedName("track_xboxmusic_id")
                        val trackXboxmusicId: String = "",
                        @SerializedName("track_isrc")
                        val trackIsrc: String = "",
                        @SerializedName("num_favourite")
                        val numFavourite: Int = 0,
                        @SerializedName("track_rating")
                        val trackRating: Int = 0,
                        @SerializedName("album_name")
                        val albumName: String = "",
                        @SerializedName("first_release_date")
                        val firstReleaseDate: String = "",
                        @SerializedName("album_coverart_350x350")
                        val albumCoverartX: String = "",
                        @SerializedName("has_lyrics_crowd")
                        val hasLyricsCrowd: Int = 0,
                        @SerializedName("track_edit_url")
                        val trackEditUrl: String = "",
                        @SerializedName("track_name")
                        val trackName: String = "",
                        @SerializedName("primary_genres")
                        val primaryGenres: PrimaryGenresMdl,
                        @SerializedName("track_soundcloud_id")
                        val trackSoundcloudId: String = "",
                        @SerializedName("track_length")
                        val trackLength: Int = 0,
                        @SerializedName("commontrack_id")
                        val commontrackId: Int = 0,
                        @SerializedName("subtitle_id")
                        val subtitleId: Int = 0,
                        @SerializedName("artist_id")
                        val artistId: Int = 0,
                        @SerializedName("artist_mbid")
                        val artistMbid: String = "",
                        @SerializedName("lyrics_id")
                        val lyricsId: Int = 0,
                        @SerializedName("explicit")
                        val explicit: Int = 0,
                        @SerializedName("commontrack_vanity_id")
                        val commontrackVanityId: String = "",
                        @SerializedName("track_spotify_id")
                        val trackSpotifyId: String = "",
                        @SerializedName("has_richsync")
                        val hasRichsync: Int = 0,
                        @SerializedName("track_id")
                        val trackId: Int = 0,
                        @SerializedName("instrumental")
                        val instrumental: Int = 0,
                        @SerializedName("restricted")
                        val restricted: Int = 0,
                        @SerializedName("has_subtitles")
                        val hasSubtitles: Int = 0,
                        @SerializedName("album_id")
                        val albumId: Int = 0,
                        @SerializedName("track_mbid")
                        val trackMbid: String = "",
                        @SerializedName("has_lyrics")
                        val hasLyrics: Int = 0)
}
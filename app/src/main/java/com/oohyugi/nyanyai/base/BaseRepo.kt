package com.oohyugi.nyanyai.base

import com.oohyugi.nyanyai.BuildConfig
import com.oohyugi.nyanyai.api.ApiClient

/**
 * Created by oohyugi on 08/10/18.
 * github: https://github.com/oohyugi
 */
open class BaseRepo {
    var mApiClient : ApiClient = ApiClient(BuildConfig.BASE_URL)
}
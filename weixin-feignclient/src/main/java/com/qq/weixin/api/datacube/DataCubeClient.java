package com.qq.weixin.api.datacube;

import com.qq.weixin.api.BaseRequest;
import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gong.hua
 */
@FeignClient(name = "datacube", url = "https://api.weixin.qq.com/datacube/", configuration = FeignConfiguration.class)
public interface DataCubeClient {
    /**
     * 获取用户访问小程序日留存
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisDailyRetain.html}
     */
    @RequestMapping(value = "getweanalysisappiddailyretaininfo", method = RequestMethod.POST)
    BaseResponse getweanalysisappiddailyretaininfo(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取用户访问小程序月留存
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisMonthlyRetain.html}
     */
    @RequestMapping(value = "getweanalysisappidmonthlyretaininfo", method = RequestMethod.POST)
    BaseResponse getweanalysisappidmonthlyretaininfo(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取用户访问小程序周留存
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisWeeklyRetain.html}
     */
    @RequestMapping(value = "getweanalysisappidweeklyretaininfo", method = RequestMethod.POST)
    BaseResponse getweanalysisappidweeklyretaininfo(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);


    /**
     * 获取用户访问小程序数据概况
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisDailySummary.html}
     */
    @RequestMapping(value = "getweanalysisappiddailysummarytrend", method = RequestMethod.POST)
    BaseResponse getweanalysisappiddailysummarytrend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取用户访问小程序数据日趋势
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisDailyVisitTrend.html}
     */
    @RequestMapping(value = "getweanalysisappiddailyvisittrend", method = RequestMethod.POST)
    BaseResponse getweanalysisappiddailyvisittrend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取用户访问小程序数据月趋势
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisMonthlyVisitTrend.html}
     */
    @RequestMapping(value = "getweanalysisappidmonthlyvisittrend", method = RequestMethod.POST)
    BaseResponse getweanalysisappidmonthlyvisittrend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取用户访问小程序数据周趋势
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisWeeklyVisitTrend.html}
     */
    @RequestMapping(value = "getweanalysisappidweeklyvisittrend", method = RequestMethod.POST)
    BaseResponse getweanalysisappidweeklyvisittrend(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取小程序新增或活跃用户的画像分布数据。
     * 时间范围支持昨天、最近7天、最近30天。其中，新增用户数为时间范围内首次访问小程序的去重用户数，活跃用户数为时间范围内访问过小程序的去重用户数。
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisUserPortrait.html}
     */
    @RequestMapping(value = "getweanalysisappiduserportrait", method = RequestMethod.POST)
    BaseResponse getweanalysisappiduserportrait(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 获取用户小程序访问分布数据
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisVisitDistribution.html}
     */
    @RequestMapping(value = "getweanalysisappidvisitdistribution", method = RequestMethod.POST)
    BaseResponse getweanalysisappidvisitdistribution(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

    /**
     * 访问页面。目前只提供按 page_visit_pv 排序的 top200
     *
     * @param accessToken
     * @return
     * @link {https://developers.weixin.qq.com/miniprogram/dev/api/getAnalysisVisitDistribution.html}
     */
    @RequestMapping(value = "getweanalysisappidvisitpage", method = RequestMethod.POST)
    BaseResponse getweanalysisappidvisitpage(@RequestParam("access_token") String accessToken, @RequestBody BaseRequest baseRequest);

}

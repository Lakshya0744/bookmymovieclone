package com.bookmymovie.service;
import com.bookmymovie.model.Banner;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    private Banner banner;
    BannerService(){
        banner = new Banner();
    }
    public Banner createBanner(){
        banner.setBannerUrl("/banner/banner-bg-compressed.mp4");
        banner.setBannerId(1L);
        return banner;
    }
}

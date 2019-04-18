package com.codecool.web.dto;

import com.codecool.web.model.Art;
import com.codecool.web.model.Shop;

import java.util.List;

public final class CouponDto {

    private final Art art;
    private final List<Shop> couponShops;
    private final List<Shop> allShops;

    public CouponDto(Art art, List<Shop> couponShops, List<Shop> allShops) {
        this.art = art;
        this.couponShops = couponShops;
        this.allShops = allShops;
    }

    public Art getArt() {
        return art;
    }

    public List<Shop> getCouponShops() {
        return couponShops;
    }

    public List<Shop> getAllShops() {
        return allShops;
    }
}

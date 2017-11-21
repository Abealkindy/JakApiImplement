package com.rosinante24.exploremuseum.model;

import lombok.Data;

/**
 * Created by Rosinante24 on 21/11/17.
 */
@Data
public class GambarList {
    public GambarList() {
    }

    private int gambar;

    public GambarList(int gambar) {
        this.gambar = gambar;
    }
}

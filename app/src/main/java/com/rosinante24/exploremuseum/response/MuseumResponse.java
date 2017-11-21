package com.rosinante24.exploremuseum.response;

import java.util.List;

import lombok.Data;

/**
 * Created by Rosinante24 on 21/11/17.
 */
@Data
public class MuseumResponse {
    private List<ResponseMuseumData> data;

    @Data
    public class ResponseMuseumData {
        private int id;
        private String nama_museum;
        private String alamat;
        private String deskripsi;
        private String link;
        private double latitude;
        private double longitude;
    }
}

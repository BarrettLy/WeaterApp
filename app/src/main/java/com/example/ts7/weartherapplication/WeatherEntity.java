package com.example.ts7.weartherapplication;


import java.util.List;

/**
 * @FileName WeatherEntity
 * @Description WeatherEntity
 * @Author x925914554@gmail.com
 * @Company
 * @CreateDate 18-11-13
 * @LastModifyDate 18-11-13
 * @Since
 * @Version
 */
public class WeatherEntity {

    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    //public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
    //    this.HeWeather6 = HeWeather6;
    //}

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101010100","location":"北京","parent_city":"北京","admin_area":"北京","cnty":"中国","lat":"39.90498734","lon":"116.4052887","tz":"+8.00"}
         * update : {"loc":"2018-05-28 14:52","utc":"2018-05-28 06:52"}
         * status : ok
         * now : {"cloud":"0","cond_code":"100","cond_txt":"晴","fl":"22","hum":"14","pcpn":"0.0","pres":"1008","tmp":"27","vis":"20","wind_deg":"351","wind_dir":"北风","wind_sc":"4","wind_spd":"25"}
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public static class BasicBean {
            @Override
            public String toString() {
                return "BasicBean{" +
                        "cid='" + cid + '\'' +
                        ", location='" + location + '\'' +
                        ", parent_city='" + parent_city + '\'' +
                        ", admin_area='" + admin_area + '\'' +
                        ", cnty='" + cnty + '\'' +
                        ", lat='" + lat + '\'' +
                        ", lon='" + lon + '\'' +
                        ", tz='" + tz + '\'' +
                        '}';
            }

            /**
             * cid : CN101010100
             * location : 北京
             * parent_city : 北京
             * admin_area : 北京
             * cnty : 中国
             * lat : 39.90498734
             * lon : 116.4052887
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            @Override
            public String toString() {
                return "UpdateBean{" +
                        "loc='" + loc + '\'' +
                        ", utc='" + utc + '\'' +
                        '}';
            }

            /**
             * loc : 2018-05-28 14:52
             * utc : 2018-05-28 06:52
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            @Override
            public String toString() {
                return "NowBean{" +
                        "cloud='" + cloud + '\'' +
                        ", cond_code='" + cond_code + '\'' +
                        ", cond_txt='" + cond_txt + '\'' +
                        ", fl='" + fl + '\'' +
                        ", hum='" + hum + '\'' +
                        ", pcpn='" + pcpn + '\'' +
                        ", pres='" + pres + '\'' +
                        ", tmp='" + tmp + '\'' +
                        ", vis='" + vis + '\'' +
                        ", wind_deg='" + wind_deg + '\'' +
                        ", wind_dir='" + wind_dir + '\'' +
                        ", wind_sc='" + wind_sc + '\'' +
                        ", wind_spd='" + wind_spd + '\'' +
                        '}';
            }

            /**
             * cloud : 0
             * cond_code : 100
             * cond_txt : 晴
             * fl : 22
             * hum : 14
             * pcpn : 0.0
             * pres : 1008
             * tmp : 27
             * vis : 20
             * wind_deg : 351
             * wind_dir : 北风
             * wind_sc : 4
             * wind_spd : 25
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        @Override
        public String toString() {
            return "HeWeather6Bean{" +
                    "basic=" + basic +
                    ", update=" + update +
                    ", status='" + status + '\'' +
                    ", now=" + now +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "HeWeather6=" + HeWeather6 +
                '}';
    }
}

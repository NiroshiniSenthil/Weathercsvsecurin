package com.example.weather.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;



@Entity
@Table(name="climate")
public class Climate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datetime_utc")
    private LocalDateTime datetimeUtc;

    private String conds;
    private  Integer dewptm;
    private  Integer fog;
    private Integer hail;
    private Integer heatindexm;
    private Integer hum;
    private Integer precipm;
    private Integer pressure;
    private Integer rain;
    private Integer snow;
    private Integer tempm;
    private Integer thunder;
    private Integer tornado;
    private Double vism;
    private Integer wdird;
    private String wdire;
    private Integer wsgustm;
    private Integer windchill;
    private Double wspdm;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDatetimeUtc() {
        return datetimeUtc;
    }
    public void setDatetimeUtc(LocalDateTime datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }
    public String getConds() {
        return conds;
    }
    public void setConds(String conds) {
        this.conds = conds;
    }
    public Integer getDewptm() {
        return dewptm;
    }
    public void setDewptm(Integer dewptm) {
        this.dewptm = dewptm;
    }
    public Integer getFog() {
        return fog;
    }
    public void setFog(Integer fog) {
        this.fog = fog;
    }
    public Integer getHail() {
        return hail;
    }
    public void setHail(Integer hail) {
        this.hail = hail;
    }
    public Integer getHeatindexm() {
        return heatindexm;
    }
    public void setHeatindexm(Integer heatindexm) {
        this.heatindexm = heatindexm;
    }
    public Integer getHum() {
        return hum;
    }
    public void setHum(Integer hum) {
        this.hum = hum;
    }
    public Integer getPrecipm() {
        return precipm;
    }
    public void setPrecipm(Integer precipm) {
        this.precipm = precipm;
    }
    public Integer getPressure() {
        return pressure;
    }
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }
    public Integer getRain() {
        return rain;
    }
    public void setRain(Integer rain) {
        this.rain = rain;
    }
    public Integer getSnow() {
        return snow;
    }
    public void setSnow(Integer snow) {
        this.snow = snow;
    }
    public Integer getTempm() {
        return tempm;
    }
    public void setTempm(Integer tempm) {
        this.tempm = tempm;
    }
    public Integer getThunder() {
        return thunder;
    }
    public void setThunder(Integer thunder) {
        this.thunder = thunder;
    }
    public Integer getTornado() {
        return tornado;
    }
    public void setTornado(Integer tornado) {
        this.tornado = tornado;
    }
    public Double getVism() {
        return vism;
    }
    public void setVism(Double vism) {
        this.vism = vism;
    }
    public Integer getWdird() {
        return wdird;
    }
    public void setWdird(Integer wdird) {
        this.wdird = wdird;
    }
    public String getWdire() {
        return wdire;
    }
    public void setWdire(String wdire) {
        this.wdire = wdire;
    }
    public Integer getWsgustm() {
        return wsgustm;
    }
    public void setWsgustm(Integer wsgustm) {
        this.wsgustm = wsgustm;
    }
    public Integer getWindchill() {
        return windchill;
    }
    public void setWindchill(Integer windchill) {
        this.windchill = windchill;
    }
    public Double getWspdm() {
        return wspdm;
    }
    public void setWspdm(Double wspdm) {
        this.wspdm = wspdm;
    }
     
}

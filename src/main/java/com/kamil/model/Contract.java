package com.kamil.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "contract")
public class Contract {
    private int id; // номер договора
    private int postcode; // индекс
    private int constructionYear; // год постройки
    private float insuranceSum; // страховая сумма
    private float insurancePremium; // страховая премия
    private float area; // площадь
    private Date insuranceStartDate; // дата начала страховки
    private Date insuranceEndDate; // дата окончания страховки
    private Date computationDate; // дата расчёта
    private Date contractDate; // дата заключения договора
    private String property; // тип недвижимости
    private String country; // государство
    private String republic; // республика, край, область
    private String region; // район
    private String locality; // населенный пункт
    private String street; // улица
    private String house; // дом
    private String housing; // корпус
    private String building; // строение
    private String apartment; // квартира
    private String comment; // комментарий
    private Client clientId; // id клиента

    public Contract () {

    }

    public Contract (int postcode, int constructionYear, float insuranceSum, float insurancePremium, float area, Date insuranceStartDate, Date insuranceEndDate, Date computationDate, Date contractDate, String property, String country, String republic, String region, String locality, String street, String house, String housing, String building, String apartment, String comment, Client clientId) {
        super();
        this.postcode = postcode;
        this.constructionYear = constructionYear;
        this.insuranceSum = insuranceSum;
        this.insurancePremium = insurancePremium;
        this.area = area;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceEndDate = insuranceEndDate;
        this.computationDate = computationDate;
        this.property = property;
        this.country = country;
        this.republic = republic;
        this.region = region;
        this.locality = locality;
        this.street = street;
        this.house = house;
        this.housing = housing;
        this.building = building;
        this.apartment = apartment;
        this.comment = comment;
        this.clientId = clientId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "postcode", nullable = false, insertable = true, updatable = true)
    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "construction_year", nullable = false, insertable = true, updatable = true)
    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    @Basic
    @Column(name = "insurance_sum", nullable = false, insertable = true, updatable = true)
    public float getInsuranceSum() {
        return insuranceSum;
    }

    public void setInsuranceSum(float insuranceSum) {
        this.insuranceSum = insuranceSum;
    }

    @Basic
    @Column(name = "insurance_premium", nullable = false, insertable = true, updatable = true)
    public float getInsurancePremium() {
        return insurancePremium;
    }

    public void setInsurancePremium(float insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    @Basic
    @Column(name = "area", nullable = false, insertable = true, updatable = true)
    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "insurance_start_date", nullable = false, insertable = true, updatable = true)
    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "insurance_end_date", nullable = false, insertable = true, updatable = true)
    public Date getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(Date insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "computation_date", nullable = false, insertable = true, updatable = true)
    public Date getComputationDate() {
        return computationDate;
    }

    public void setComputationDate(Date computationDate) {
        this.computationDate = computationDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_date", nullable = false, insertable = true, updatable = true)
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Basic
    @Column(name = "property", nullable = false, insertable = true, updatable = true, length = 10)
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Basic
    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 25)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "republic", nullable = true, insertable = true, updatable = true, length = 30)
    public String getRepublic() {
        return republic;
    }

    public void setRepublic(String republic) {
        this.republic = republic;
    }

    @Basic
    @Column(name = "region", nullable = true, insertable = true, updatable = true, length = 30)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "locality", nullable = false, insertable = true, updatable = true, length = 30)
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Basic
    @Column(name = "street", nullable = false, insertable = true, updatable = true, length = 30)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "house", nullable = false, insertable = true, updatable = true, length = 10)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Basic
    @Column(name = "housing", nullable = true, insertable = true, updatable = true, length = 10)
    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    @Basic
    @Column(name = "building", nullable = true, insertable = true, updatable = true, length = 30)
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "apartment", nullable = true, insertable = true, updatable = true, length = 30)
    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Basic
    @Column(name = "comment", nullable = true, insertable = true, updatable = true, length = 250)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name="client_id")
    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "{" +
                "id:'" + id +
                "', postcode:'" + postcode +
                "', constructionYear:'" + constructionYear +
                "', insuranceSum:'" + insuranceSum +
                "', insurancePremium:'" + insurancePremium +
                "', area:'" + area +
                "', insuranceStartDate:'" + insuranceStartDate +
                "', insuranceEndDate:'" + insuranceEndDate +
                "', computationDate:'" + computationDate +
                "', contractDate:'" + contractDate +
                "', property:'" + property +
                "', country:'" + country +
                "', republic:'" + republic +
                "', region:'" + region +
                "', locality:'" + locality +
                "', street:'" + street +
                "', house:'" + house +
                "', housing:'" + housing +
                "', building:'" + building +
                "', apartment:'" + apartment +
                "', comment:'" + comment +
                "', clientId:'" + clientId +
                "'}";
    }
}

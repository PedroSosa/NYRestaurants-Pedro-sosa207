package softdrive.com.nyrestaurants.Modelos;

/**
 * Created by the-b on 30/10/2017.
 */

public class Restaurante {

    private String name;
    private String phone;
    private String address;
    private long price;
    private String area;
    private String image_url;
    private String postal_code;
    private double lat;
    private double lng;
    private String city;

    public Restaurante() {
    }



    public Restaurante(String name, String phone, String address, long price, String area, String image_url, String postal_code, double lat, double lng,String city) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.price = price;
        this.area = area;
        this.image_url = image_url;
        this.postal_code = postal_code;
        this.lat = lat;
        this.lng = lng;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

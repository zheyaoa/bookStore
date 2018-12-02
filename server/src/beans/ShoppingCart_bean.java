package beans;

public class ShoppingCart_bean {
    private Integer uId;
    private Integer cId;
    private Integer num;
    private Float price;

    public ShoppingCart_bean(Integer uId, Integer cId, Integer num, Float price) {
        this.uId = uId;
        this.cId = cId;
        this.num = num;
        this.price = price;
    }

    public Integer getuId() {
        return uId;
    }

    public Integer getcId() {
        return cId;
    }

    public Integer getNum() {
        return num;
    }

    public Float getPrice() {
        return price;
    }
}

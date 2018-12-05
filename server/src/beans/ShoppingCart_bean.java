package beans;

public class ShoppingCart_bean {
    private Integer uId;
    private Integer cId;


    public ShoppingCart_bean(Integer uId, Integer cId) {
        this.uId = uId;
        this.cId = cId;

    }

    public Integer getuId() {
        return uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}

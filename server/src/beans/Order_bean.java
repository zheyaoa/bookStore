package beans;

import dao.Commodity_dao;

import java.sql.SQLException;

public class Order_bean {
    private Integer oId;
    private Integer uId;
    private Integer cId;
    private Integer num;
    private Integer status;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getPrice()throws Exception{
        Float price = null;
        try {
            Commodity_dao commodity_dao = new Commodity_dao();
            price = commodity_dao.getPriceByCId(this.cId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return price;
    }

    public String getCName() throws Exception{
        String cName = null;
        try {
            Commodity_dao commodity_dao = new Commodity_dao();
            cName = commodity_dao.getCNameByCId(this.cId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cName;
    }
    public String getImage() throws Exception{
        String image = null;
        try {
            Commodity_dao commodity_dao = new Commodity_dao();
            image = commodity_dao.getImageByCId(this.cId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return image;
    }
}

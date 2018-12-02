package beans;

public class CommodityType_bean {
    private Integer typeId;
    private String typeName;
    public CommodityType_bean(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }
}
